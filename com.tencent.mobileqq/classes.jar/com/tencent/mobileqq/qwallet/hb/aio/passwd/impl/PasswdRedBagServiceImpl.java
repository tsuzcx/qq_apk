package com.tencent.mobileqq.qwallet.hb.aio.passwd.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.DrawableRes;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.Pair;
import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IQWalletAIOLifeCycleHelper;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.cache.QQHashMap;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.QQWalletAioBodyReserve;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.hb.aio.impl.QWalletRedPkgUtils;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.PasswdRedBagInfo;
import com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRedPacketHelperImpl;
import com.tencent.mobileqq.qwallet.hb.pb.oidb_0x438.RedBagInfo;
import com.tencent.mobileqq.qwallet.hb.pb.oidb_0x438.ReqInfo;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.QQWalletAioBody;
import tencent.im.msg.im_msg_body.QQWalletAioElem;

public class PasswdRedBagServiceImpl
  implements IPasswdRedBagService
{
  private static final String KEY_DB_UPDATE_CONFIGS = "key_db_update";
  private static final String KEY_EXTSTR_IDIOMSEQ = "key_extstr_idiomseq";
  private static final String KEY_PASSWD_CONFIGS = "key_passwd_configs";
  private static final String SP_PASSWD_CONFIGS = "sp_passwd_configs";
  private List<PasswdRedBagUpdateInfo> disgroupNeedUpdates;
  private List<PasswdRedBagUpdateInfo> groupNeedUpdates;
  private boolean isConfigLoaded;
  public boolean isFirstInAio = true;
  private boolean isLoadingRedBagRelation;
  private boolean isNeedLoadRedBagInfo;
  private boolean isNeedLoadRedBagRelation;
  private boolean isNeedSyncLoadRedBagInfo;
  private HashMap<String, String> mCacheDisGroupInfos;
  private HashMap<String, String> mCacheGroupInfos;
  public Context mContext;
  private List<String> mDefaultPasswds;
  Handler mHandler = new PasswdRedBagServiceImpl.1(this, Looper.getMainLooper());
  private Map<Integer, List<Pair<String, String>>> mIdiomRedBagLensCache;
  private HashMap<String, List<String>> mIdiomRedBagsCache;
  private HashMap<String, List<String>> mPasswdCache;
  public HashMap<String, String> mPasswdRedBagAuthKeyCache;
  private PasswdRedBagDBManager mPasswdRedBagDBManager;
  private HashMap<String, PasswdRedBagInfo> mPasswdRedBagsCache;
  protected Object mPasswdRedListLock = new Object();
  private BaseQQAppInterface mQQAppInterface;
  private QWalletHandler mQWalletHandler;
  private QWalletObserver mQWalletObserver = new QWalletObserver(this.mHandler);
  private PasswdRedBagServiceImpl.RedPacketRefreshReceiver mRedPacketRefreshReceiver;
  private HashMap<String, List<String>> mShengpiziRedBagsCache;
  public String mUin;
  
  private String getOldPassword(PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    if (paramPasswdRedBagInfo == null) {
      return "";
    }
    if (TextUtils.isEmpty(paramPasswdRedBagInfo.e))
    {
      paramPasswdRedBagInfo = paramPasswdRedBagInfo.d;
    }
    else
    {
      String[] arrayOfString = paramPasswdRedBagInfo.e.trim().split("_");
      if (arrayOfString.length == 2)
      {
        String str = arrayOfString[0];
        if (paramPasswdRedBagInfo.a() == 2) {
          paramPasswdRedBagInfo = arrayOfString[1];
        } else {
          paramPasswdRedBagInfo = str;
        }
      }
      else
      {
        paramPasswdRedBagInfo = "";
      }
    }
    if (TextUtils.isEmpty(paramPasswdRedBagInfo)) {
      return "";
    }
    return paramPasswdRedBagInfo.trim();
  }
  
  private PasswdRedBagInfo getSelectRedBag(BaseSessionInfo paramBaseSessionInfo, String paramString, Object[] paramArrayOfObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(transType(paramBaseSessionInfo.jdField_a_of_type_Int));
    ((StringBuilder)localObject1).append("_");
    ((StringBuilder)localObject1).append(paramBaseSessionInfo.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("_");
    paramBaseSessionInfo = ((StringBuilder)localObject1).toString();
    Object localObject3 = (List)this.mPasswdCache.get(paramString);
    Object localObject2 = new ArrayList();
    localObject1 = this.mPasswdRedListLock;
    if (localObject3 != null) {}
    try
    {
      if (!((List)localObject3).isEmpty())
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (String)((Iterator)localObject3).next();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramBaseSessionInfo);
          ((StringBuilder)localObject4).append((String)localObject5);
          localObject4 = ((StringBuilder)localObject4).toString();
          if (!this.mPasswdRedBagAuthKeyCache.containsKey(localObject4))
          {
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("get redbagid, no find passwd redbag auth key in cache, key: ");
              ((StringBuilder)localObject5).append((String)localObject4);
              QLog.d("msgFold", 2, ((StringBuilder)localObject5).toString());
            }
          }
          else
          {
            localObject5 = (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(localObject5);
            if (localObject5 != null)
            {
              ((List)localObject2).add(localObject5);
            }
            else if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("get redbagid, no find passwd redbag in cache, key: ");
              ((StringBuilder)localObject5).append((String)localObject4);
              QLog.d("msgFold", 2, ((StringBuilder)localObject5).toString());
            }
          }
        }
      }
      localObject3 = new ArrayList();
      if (paramString.trim().length() <= 1) {
        break label497;
      }
      localObject4 = paramString.trim().substring(0, 1);
      if ((paramString.trim().length() != 4) && (!isEnglishWords(paramString))) {
        break label449;
      }
      localObject5 = ChnToSpell.a((String)localObject4);
      if ((localObject5 == null) || (localObject5.length <= 0)) {
        break label449;
      }
      j = localObject5.length;
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject5;
        Object localObject4;
        int j;
        int i;
        Object localObject6;
        label449:
        label497:
        boolean bool1;
        boolean bool2;
        for (;;)
        {
          throw paramBaseSessionInfo;
        }
        i += 1;
        continue;
        paramArrayOfObject = null;
        paramString = paramBaseSessionInfo;
        paramBaseSessionInfo = paramArrayOfObject;
        continue;
        paramBaseSessionInfo = null;
        paramString = null;
      }
    }
    if (i < j)
    {
      localObject6 = localObject5[i];
      if (!TextUtils.isEmpty((CharSequence)localObject6))
      {
        localObject6 = (List)this.mIdiomRedBagsCache.get(((String)localObject6).trim());
        if ((localObject6 != null) && (!((List)localObject6).isEmpty())) {
          ((List)localObject3).addAll((Collection)localObject6);
        }
      }
    }
    else
    {
      if (isChinese((String)localObject4))
      {
        localObject4 = (List)this.mIdiomRedBagsCache.get(localObject4);
        if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
          ((List)localObject3).addAll((Collection)localObject4);
        }
      }
      localObject4 = paramString.trim();
      i = ((String)localObject4).length();
      if (i > 1)
      {
        bool1 = this.mIdiomRedBagLensCache.containsKey(Integer.valueOf(i));
        bool2 = this.mIdiomRedBagLensCache.containsKey(Integer.valueOf(0));
        if ((bool1) || (bool2))
        {
          localObject5 = new ArrayList();
          if (bool2)
          {
            localObject6 = (List)this.mIdiomRedBagLensCache.get(Integer.valueOf(0));
            if (localObject6 != null) {
              ((List)localObject5).addAll((Collection)localObject6);
            }
          }
          if (bool1)
          {
            localObject6 = (List)this.mIdiomRedBagLensCache.get(Integer.valueOf(i));
            if (localObject6 != null) {
              ((List)localObject5).addAll((Collection)localObject6);
            }
          }
          if (((List)localObject5).size() > 0)
          {
            localObject6 = new LinkedList();
            localObject5 = ((List)localObject5).iterator();
            while (((Iterator)localObject5).hasNext())
            {
              Pair localPair = (Pair)((Iterator)localObject5).next();
              if ((!TextUtils.isEmpty((CharSequence)localPair.second)) && (((String)localObject4).contains((CharSequence)localPair.second))) {
                ((List)localObject6).add(localPair.first);
              }
            }
            if (((List)localObject6).size() > 0) {
              ((List)localObject3).addAll((Collection)localObject6);
            }
          }
        }
      }
      if (!((List)localObject3).isEmpty())
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (String)((Iterator)localObject3).next();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramBaseSessionInfo);
          ((StringBuilder)localObject4).append((String)localObject5);
          localObject4 = ((StringBuilder)localObject4).toString();
          if (!this.mPasswdRedBagAuthKeyCache.containsKey(localObject4))
          {
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("get redbagid, no find passwd redbag auth key in cache, key: ");
              ((StringBuilder)localObject5).append((String)localObject4);
              QLog.d("msgFold", 2, ((StringBuilder)localObject5).toString());
            }
          }
          else
          {
            localObject5 = (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(localObject5);
            if (localObject5 != null)
            {
              ((List)localObject2).add(localObject5);
            }
            else if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("get redbagid, no find passwd redbag in cache, key: ");
              ((StringBuilder)localObject5).append((String)localObject4);
              QLog.d("msgFold", 2, ((StringBuilder)localObject5).toString());
            }
          }
        }
      }
      if ((paramString.trim().length() > 0) && (isEnglishWords(paramString)))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramString.trim().toUpperCase());
        ((StringBuilder)localObject3).append("&rareword");
        paramString = MD5.a(((StringBuilder)localObject3).toString()).substring(0, 8);
        paramString = (List)this.mShengpiziRedBagsCache.get(paramString);
        if ((paramString != null) && (!paramString.isEmpty()))
        {
          paramString = paramString.iterator();
          while (paramString.hasNext())
          {
            localObject4 = (String)paramString.next();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramBaseSessionInfo);
            ((StringBuilder)localObject3).append((String)localObject4);
            localObject3 = ((StringBuilder)localObject3).toString();
            if (!this.mPasswdRedBagAuthKeyCache.containsKey(localObject3))
            {
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("get redbagid, no find passwd redbag auth key in cache, key: ");
                ((StringBuilder)localObject4).append((String)localObject3);
                QLog.d("msgFold", 2, ((StringBuilder)localObject4).toString());
              }
            }
            else
            {
              localObject4 = (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(localObject4);
              if (localObject4 != null)
              {
                ((List)localObject2).add(localObject4);
              }
              else if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("get redbagid, no find passwd redbag in cache, key: ");
                ((StringBuilder)localObject4).append((String)localObject3);
                QLog.d("msgFold", 2, ((StringBuilder)localObject4).toString());
              }
            }
          }
        }
      }
      if (((List)localObject2).isEmpty()) {
        break label1500;
      }
      Collections.sort((List)localObject2, new PasswdRedBagServiceImpl.2(this));
      localObject2 = ((List)localObject2).iterator();
      paramBaseSessionInfo = null;
      while (((Iterator)localObject2).hasNext())
      {
        paramString = (PasswdRedBagInfo)((Iterator)localObject2).next();
        paramArrayOfObject[1] = Long.valueOf(paramString.c);
        if (4 == paramString.jdField_a_of_type_Int)
        {
          paramArrayOfObject[2] = null;
          paramArrayOfObject[3] = null;
        }
        else if (!paramString.a())
        {
          paramArrayOfObject[2] = paramString.jdField_a_of_type_JavaLangString;
          paramArrayOfObject[3] = paramString.jdField_b_of_type_JavaLangString;
        }
        if (paramString.jdField_a_of_type_Boolean)
        {
          if ((4 == paramString.jdField_a_of_type_Int) && (!paramString.jdField_b_of_type_Boolean) && (!paramString.a()) && (paramBaseSessionInfo == null)) {
            paramBaseSessionInfo = paramString;
          }
        }
        else if (paramString.jdField_b_of_type_Boolean)
        {
          paramArrayOfObject[0] = Integer.valueOf(2);
        }
        else if (paramString.a())
        {
          paramArrayOfObject[0] = Integer.valueOf(3);
        }
        else
        {
          if ((4 != paramString.jdField_a_of_type_Int) && (8 != paramString.jdField_a_of_type_Int)) {
            paramString.jdField_a_of_type_Boolean = true;
          }
          paramArrayOfObject[0] = Integer.valueOf(1);
          paramArrayOfObject = paramString;
          paramString = paramBaseSessionInfo;
          paramBaseSessionInfo = paramArrayOfObject;
          if (paramBaseSessionInfo == null) {
            return paramString;
          }
          return paramBaseSessionInfo;
        }
      }
    }
    label1500:
    return paramString;
  }
  
  private boolean isChinese(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.trim().length() > 0) && (paramString.matches("[一-龥]"));
  }
  
  private boolean isContinueIdiom(String paramString1, String paramString2, PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString1 = paramString1.trim();
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramString1.length() <= 1) {
        return false;
      }
      String str = paramString1.substring(0, 1);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (!paramString2.contains(str)) {
          return false;
        }
        if (paramPasswdRedBagInfo.a(paramString1.length())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean isEnglishWords(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = true;
    if ((bool2) || (paramString.trim().length() <= 1) || (!paramString.trim().matches("[a-zA-Z]+"))) {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isEnglishWords: ");
      paramString.append(bool1);
      QLog.i("PasswdRedBagSgervice", 2, paramString.toString());
    }
    return bool1;
  }
  
  private boolean isKeyWords(String paramString1, String paramString2, PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    paramString1 = paramString1.trim();
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.length() > 1))
    {
      if (!paramString1.contains(paramString2)) {
        return false;
      }
      if (paramPasswdRedBagInfo.a(paramString1.length())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isMatchIdomRedBag(String paramString, PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramPasswdRedBagInfo == null) {
        return false;
      }
      String str = getLastIdiomPinyin(paramPasswdRedBagInfo.e);
      if (paramPasswdRedBagInfo.a() == 0)
      {
        if (paramString.trim().length() < 4) {
          return false;
        }
        paramString = ChnToSpell.a(paramString.trim().substring(0, 1));
        if (paramString != null)
        {
          if (paramString.length == 0) {
            return false;
          }
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            paramPasswdRedBagInfo = paramString[i];
            if ((!TextUtils.isEmpty(str)) && (paramPasswdRedBagInfo.equals(str.trim()))) {
              return true;
            }
            i += 1;
          }
        }
        return false;
      }
      if (paramPasswdRedBagInfo.a() == 1)
      {
        if (isEnglishWords(paramString))
        {
          paramString = paramString.trim().substring(0, 1);
          if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(str))) {
            return true;
          }
        }
      }
      else if (paramPasswdRedBagInfo.a() == 2)
      {
        if (isKeyWords(paramString, str, paramPasswdRedBagInfo)) {
          return true;
        }
      }
      else if ((paramPasswdRedBagInfo.a() == 3) && (isContinueIdiom(paramString, str, paramPasswdRedBagInfo))) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isNeedReInit()
  {
    return !this.mQQAppInterface.getCurrentAccountUin().equals(this.mUin);
  }
  
  private void loadPasswdRedBagToCache(PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    String str = paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString;
    Object localObject6 = paramPasswdRedBagInfo.d;
    this.mPasswdRedBagsCache.put(str, paramPasswdRedBagInfo);
    int i = paramPasswdRedBagInfo.jdField_a_of_type_Int;
    int k = 0;
    int j;
    Object localObject7;
    label159:
    label348:
    int m;
    if (i == 0)
    {
      ??? = (List)this.mPasswdCache.get(localObject6);
      Object localObject1 = ???;
      if (??? == null)
      {
        localObject1 = new LinkedList();
        this.mPasswdCache.put(localObject6, localObject1);
      }
      try
      {
        synchronized (this.mPasswdRedListLock)
        {
          j = ((List)localObject1).size();
          i = 0;
          if (i >= j) {
            break label862;
          }
          localObject7 = (String)((List)localObject1).get(i);
          if (TextUtils.isEmpty((CharSequence)localObject7)) {
            break label855;
          }
          localObject7 = (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(localObject7);
          if ((localObject7 == null) || (((PasswdRedBagInfo)localObject7).jdField_a_of_type_Long >= paramPasswdRedBagInfo.jdField_a_of_type_Long)) {
            break label855;
          }
          ((List)localObject1).add(i, str);
        }
      }
      catch (Throwable localThrowable1)
      {
        if (QLog.isDevelopLevel()) {
          localThrowable1.printStackTrace();
        }
      }
      throw paramPasswdRedBagInfo;
    }
    else if (paramPasswdRedBagInfo.jdField_a_of_type_Int == 4)
    {
      Object localObject8;
      if ((paramPasswdRedBagInfo.a() != 0) && (paramPasswdRedBagInfo.a() != 1) && (paramPasswdRedBagInfo.a() != 3))
      {
        if (paramPasswdRedBagInfo.a() == 2)
        {
          localObject7 = paramPasswdRedBagInfo.a().iterator();
          for (;;)
          {
            if (!((Iterator)localObject7).hasNext()) {
              break label677;
            }
            i = ((Integer)((Iterator)localObject7).next()).intValue();
            ??? = (List)this.mIdiomRedBagLensCache.get(Integer.valueOf(i));
            Object localObject2 = ???;
            if (??? == null)
            {
              localObject2 = new LinkedList();
              this.mIdiomRedBagLensCache.put(Integer.valueOf(i), localObject2);
            }
            try
            {
              synchronized (this.mPasswdRedListLock)
              {
                j = ((List)localObject2).size();
                i = 0;
                if (i >= j) {
                  break label874;
                }
                localObject8 = (String)((Pair)((List)localObject2).get(i)).first;
                if (TextUtils.isEmpty((CharSequence)localObject8)) {
                  break label867;
                }
                localObject8 = (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(localObject8);
                if ((localObject8 == null) || (((PasswdRedBagInfo)localObject8).jdField_a_of_type_Long >= paramPasswdRedBagInfo.jdField_a_of_type_Long)) {
                  break label867;
                }
                label415:
                ((List)localObject2).add(i, new Pair(str, getLastIdiomPinyin(paramPasswdRedBagInfo.e)));
              }
            }
            catch (Throwable localThrowable2)
            {
              if (QLog.isDevelopLevel()) {
                localThrowable2.printStackTrace();
              }
            }
          }
          throw paramPasswdRedBagInfo;
        }
      }
      else
      {
        localObject7 = getLastIdiomPinyin(paramPasswdRedBagInfo.e).split("-");
        m = localObject7.length;
        j = 0;
        for (;;)
        {
          if (j >= m) {
            break label677;
          }
          localObject8 = localObject7[j];
          ??? = (List)this.mIdiomRedBagsCache.get(localObject8);
          Object localObject3 = ???;
          if (??? == null)
          {
            localObject3 = new LinkedList();
            this.mIdiomRedBagsCache.put(localObject8, localObject3);
          }
          try
          {
            synchronized (this.mPasswdRedListLock)
            {
              int n = ((List)localObject3).size();
              i = 0;
              label570:
              if (i >= n) {
                break label886;
              }
              localObject8 = (String)((List)localObject3).get(i);
              if (TextUtils.isEmpty((CharSequence)localObject8)) {
                break label879;
              }
              localObject8 = (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(localObject8);
              if ((localObject8 == null) || (((PasswdRedBagInfo)localObject8).jdField_a_of_type_Long >= paramPasswdRedBagInfo.jdField_a_of_type_Long)) {
                break label879;
              }
              label632:
              ((List)localObject3).add(i, str);
            }
          }
          catch (Throwable localThrowable3)
          {
            if (QLog.isDevelopLevel()) {
              localThrowable3.printStackTrace();
            }
            j += 1;
          }
        }
        throw paramPasswdRedBagInfo;
      }
    }
    label677:
    Object localObject4;
    if (paramPasswdRedBagInfo.jdField_a_of_type_Int == 8)
    {
      ??? = (List)this.mShengpiziRedBagsCache.get(localObject6);
      localObject4 = ???;
      if (??? == null)
      {
        localObject4 = new LinkedList();
        this.mShengpiziRedBagsCache.put(localObject6, localObject4);
      }
    }
    for (;;)
    {
      try
      {
        synchronized (this.mPasswdRedListLock)
        {
          m = ((List)localObject4).size();
          i = 0;
          j = k;
          if (i < m)
          {
            localObject6 = (String)((List)localObject4).get(i);
            if (TextUtils.isEmpty((CharSequence)localObject6)) {
              break label891;
            }
            localObject6 = (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(localObject6);
            if ((localObject6 == null) || (((PasswdRedBagInfo)localObject6).jdField_a_of_type_Long >= paramPasswdRedBagInfo.jdField_a_of_type_Long)) {
              break label891;
            }
            j = i;
          }
          ((List)localObject4).add(j, str);
        }
      }
      catch (Throwable paramPasswdRedBagInfo)
      {
        if (QLog.isDevelopLevel()) {
          paramPasswdRedBagInfo.printStackTrace();
        }
        return;
      }
      throw paramPasswdRedBagInfo;
      return;
      label855:
      i += 1;
      break;
      label862:
      i = 0;
      break label159;
      label867:
      i += 1;
      break label348;
      label874:
      i = 0;
      break label415;
      label879:
      i += 1;
      break label570;
      label886:
      i = 0;
      break label632;
      label891:
      i += 1;
    }
  }
  
  private void openSolitaireRedBagByIdiom(String paramString, BaseSessionInfo paramBaseSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt)
  {
    long l1 = ((IQWalletPreferenceApi)QRoute.api(IQWalletPreferenceApi.class)).getLong(this.mQQAppInterface.getCurrentAccountUin(), "idiom_match_in_phone", 0L);
    long l2 = NetConnInfoCenter.getServerTime();
    boolean bool;
    if ((l1 != 0L) && (l1 > l2)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openSolitaireRedBagByIdiom|isServerAvailable: ");
      localStringBuilder.append(bool);
      QLog.d("PasswdRedBagSgervice", 2, localStringBuilder.toString());
    }
    if (bool) {
      VoiceRedPacketHelperImpl.getInstance().getSkey(new PasswdRedBagServiceImpl.5(this, paramPasswdRedBagInfo, paramString, paramBaseSessionInfo, paramLong, paramInt));
    }
  }
  
  private void reInit()
  {
    this.mUin = this.mQQAppInterface.getCurrentAccountUin();
    this.mPasswdRedBagDBManager = new PasswdRedBagDBManager(this);
    this.mPasswdCache.clear();
    this.mPasswdRedBagAuthKeyCache.clear();
    this.mPasswdRedBagsCache.clear();
    this.mDefaultPasswds.clear();
    this.mShengpiziRedBagsCache.clear();
    this.isNeedSyncLoadRedBagInfo = true;
    this.isNeedLoadRedBagInfo = true;
    this.isNeedLoadRedBagRelation = true;
    this.isLoadingRedBagRelation = false;
  }
  
  private void saveConfigs(Set<String> paramSet)
  {
    try
    {
      Object localObject1 = this.mContext;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sp_passwd_configs_");
      ((StringBuilder)localObject2).append(this.mUin);
      localObject2 = ((StringBuilder)localObject2).toString();
      int i = 0;
      localObject1 = ((Context)localObject1).getSharedPreferences((String)localObject2, 0).edit();
      if (Build.VERSION.SDK_INT >= 11)
      {
        ((SharedPreferences.Editor)localObject1).putStringSet("key_passwd_configs", paramSet);
      }
      else
      {
        ((SharedPreferences.Editor)localObject1).putInt("key_passwd_configs_count", paramSet.size());
        paramSet = paramSet.iterator();
        while (paramSet.hasNext())
        {
          localObject2 = (String)paramSet.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("key_passwd_configs_");
          localStringBuilder.append(i);
          ((SharedPreferences.Editor)localObject1).putString(localStringBuilder.toString(), (String)localObject2);
          i += 1;
        }
      }
      ((SharedPreferences.Editor)localObject1).commit();
      return;
    }
    catch (Throwable paramSet)
    {
      paramSet.printStackTrace();
    }
  }
  
  private void savePasswdRedBagFromOffLine(oidb_0x438.RedBagInfo paramRedBagInfo)
  {
    savePasswdRedBag(paramRedBagInfo.string_redbag_id.get().toStringUtf8(), paramRedBagInfo.string_index.get().toStringUtf8(), paramRedBagInfo.string_password.get().toStringUtf8(), String.valueOf(paramRedBagInfo.uint64_creator_uin.get()), paramRedBagInfo.uint64_expire_time.get(), String.valueOf(paramRedBagInfo.uint32_source.get()), String.valueOf(paramRedBagInfo.uint64_code.get()), paramRedBagInfo.string_authkey.get().toStringUtf8(), false, false, 0);
  }
  
  private void setPasswdRedBagOpenStatus(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    loadRedBagInfoToCache(false);
    if ((paramBoolean) && ((paramInt == 1) || (paramInt == 3000))) {
      NotifyMsgApiImpl.onGroupHbGrabbedNotify(paramString2, paramInt, paramString1);
    }
    paramString2 = (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(paramString1);
    if (paramString2 == null) {
      return;
    }
    if (paramString2.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    paramString2.jdField_a_of_type_Boolean = paramBoolean;
    ThreadManager.getFileThreadHandler().post(new PasswdRedBagServiceImpl.14(this, paramString1, paramBoolean));
  }
  
  private void updateIdiomRedBagToCache(PasswdRedBagInfo paramPasswdRedBagInfo, String paramString)
  {
    if (paramPasswdRedBagInfo != null) {}
    for (;;)
    {
      int i;
      synchronized (this.mPasswdRedListLock)
      {
        paramString = paramString.split("-");
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          CharSequence localCharSequence = paramString[i];
          if (TextUtils.isEmpty(localCharSequence)) {
            break label180;
          }
          List localList = (List)this.mIdiomRedBagsCache.get(localCharSequence);
          if ((localList != null) && (!localList.isEmpty()))
          {
            Iterator localIterator = localList.iterator();
            if (localIterator.hasNext())
            {
              if (!((String)localIterator.next()).equals(paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString)) {
                continue;
              }
              localIterator.remove();
            }
          }
          if (((localList != null) && (!localList.isEmpty())) || (!this.mIdiomRedBagsCache.containsKey(localCharSequence))) {
            break label180;
          }
          this.mIdiomRedBagsCache.remove(localCharSequence);
          break label180;
        }
        loadPasswdRedBagToCache(paramPasswdRedBagInfo);
        return;
      }
      return;
      label180:
      i += 1;
    }
  }
  
  public void createPasswdRedBagAnonymousTips(String paramString, int paramInt)
  {
    String str = HardCodeUtil.a(R.string.br);
    if (paramInt == 8) {
      str = "匿名不能抢K歌红包哦";
    }
    for (;;)
    {
      break;
      if (paramInt == 9) {
        str = HardCodeUtil.a(R.string.bu);
      } else if (paramInt == 10) {
        str = HardCodeUtil.a(R.string.bq);
      } else if (paramInt == 11) {
        str = HardCodeUtil.a(R.string.bx);
      }
    }
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).TroopTipsMsgMgr$insertTroopTipsIntoMessageList(this.mQQAppInterface, paramString, str, NetConnInfoCenter.getServerTime(), 10000L, 0, 1);
  }
  
  public void createPasswdRedBagBanTips(String paramString, int paramInt)
  {
    String str = HardCodeUtil.a(R.string.bv);
    if (paramInt == 8) {
      str = "禁言不能抢K歌红包哦";
    }
    for (;;)
    {
      break;
      if (paramInt == 9) {
        str = HardCodeUtil.a(R.string.bs);
      } else if (paramInt == 10) {
        str = HardCodeUtil.a(R.string.bt);
      } else if (paramInt == 11) {
        str = HardCodeUtil.a(R.string.bw);
      }
    }
    ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).TroopTipsMsgMgr$insertTroopTipsIntoMessageList(this.mQQAppInterface, paramString, str, NetConnInfoCenter.getServerTime(), 10000L, 0, 1);
  }
  
  public void fetchNewestIdomRedbagWordWhenFirstEnterAIO(BaseSessionInfo paramBaseSessionInfo)
  {
    ThreadManagerV2.excute(new PasswdRedBagServiceImpl.3(this, paramBaseSessionInfo), 16, null, true);
  }
  
  public Map<String, String> getAuthKeyCache()
  {
    return this.mPasswdRedBagAuthKeyCache;
  }
  
  public Bitmap getIconFromCacheByType(String paramString, @DrawableRes int paramInt)
  {
    Object localObject2 = GlobalImageCache.a;
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1 = null;
    if (localObject2 != null) {
      localObject2 = (Bitmap)GlobalImageCache.a.get(paramString);
    } else {
      localObject2 = null;
    }
    Object localObject3 = localObject2;
    Object localObject4;
    if (localObject2 == null)
    {
      localObject3 = localBitmap2;
      Object localObject1;
      try
      {
        localBitmap2 = BitmapFactory.decodeResource(this.mContext.getResources(), paramInt);
        localBitmap1 = localBitmap2;
        if (localBitmap2 != null)
        {
          localBitmap1 = localBitmap2;
          localObject3 = localBitmap2;
          localBitmap2 = Bitmap.createScaledBitmap(localBitmap2, DisplayUtil.a(this.mContext, 10.0F), DisplayUtil.a(this.mContext, 15.0F), true);
          localBitmap1 = localBitmap2;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject1 = localOutOfMemoryError;
      }
      localObject4 = localObject2;
      if (localObject1 != null)
      {
        if (GlobalImageCache.a != null) {
          GlobalImageCache.a.put(paramString, localObject1);
        }
        localObject4 = localObject1;
      }
    }
    return localObject4;
  }
  
  public String getLastIdiom(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.contains("_")) {
        return "";
      }
      paramString = paramString.split("_");
      if (paramString.length <= 1) {
        return "";
      }
      return paramString[0];
    }
    return "";
  }
  
  public String getLastIdiomPinyin(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLastIdiomPinyin|password: ");
      localStringBuilder.append(paramString);
      QLog.d("PasswdRedBagSgervice", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.contains("_")) {
        return "";
      }
      paramString = paramString.split("_");
      if (paramString.length != 2) {
        return "";
      }
      return paramString[1];
    }
    return "";
  }
  
  public PasswdRedBagInfo getPasswdRedBagInfoById(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    loadRedBagInfoToCache(false);
    return (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(paramString);
  }
  
  public void getRandomIdiomList(BusinessObserver paramBusinessObserver, int paramInt1, int paramInt2)
  {
    VoiceRedPacketHelperImpl.getInstance().getSkey(new PasswdRedBagServiceImpl.6(this, paramInt2, paramInt1, paramBusinessObserver));
  }
  
  public String getRandomPasswd()
  {
    loadConfigs();
    if (this.mDefaultPasswds.size() == 0) {
      return null;
    }
    int i = new Random(System.currentTimeMillis()).nextInt(this.mDefaultPasswds.size());
    return (String)this.mDefaultPasswds.get(i);
  }
  
  public boolean isFirstInAio()
  {
    return this.isFirstInAio;
  }
  
  public void loadConfigs()
  {
    if (this.isConfigLoaded) {
      return;
    }
    try
    {
      Object localObject1 = this.mContext;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sp_passwd_configs_");
      ((StringBuilder)localObject2).append(this.mUin);
      localObject2 = ((StringBuilder)localObject2).toString();
      int i = 0;
      localObject1 = ((Context)localObject1).getSharedPreferences((String)localObject2, 0);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localObject1 = ((SharedPreferences)localObject1).getStringSet("key_passwd_configs", new HashSet());
        if ((localObject1 != null) && (((Set)localObject1).size() > 0)) {
          this.mDefaultPasswds.addAll((Collection)localObject1);
        }
      }
      else
      {
        int j = ((SharedPreferences)localObject1).getInt("key_passwd_configs_count", 0);
        if (j > 0) {
          while (i < j)
          {
            localObject2 = this.mDefaultPasswds;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("key_passwd_configs_");
            localStringBuilder.append(i);
            ((List)localObject2).add(((SharedPreferences)localObject1).getString(localStringBuilder.toString(), ""));
            i += 1;
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.isConfigLoaded = true;
    }
  }
  
  public void loadDBToCache()
  {
    try
    {
      Object localObject1 = this.mContext;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_passwd_configs_");
      localStringBuilder.append(this.mUin);
      localObject1 = ((Context)localObject1).getSharedPreferences(localStringBuilder.toString(), 0);
      if (((SharedPreferences)localObject1).getBoolean("key_db_update", true))
      {
        ThreadManager.getFileThreadHandler().post(new PasswdRedBagServiceImpl.7(this));
        ((SharedPreferences)localObject1).edit().putBoolean("key_db_update", false);
        ((SharedPreferences)localObject1).edit().commit();
      }
      ThreadManager.getFileThreadHandler().post(new PasswdRedBagServiceImpl.8(this));
      return;
    }
    finally {}
  }
  
  public void loadRedBagInfoToCache(boolean paramBoolean)
  {
    try
    {
      if (isNeedReInit()) {
        reInit();
      }
      Object localObject1;
      if (paramBoolean)
      {
        boolean bool = this.isNeedSyncLoadRedBagInfo;
        if (!bool) {
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("loadRedBagInfoToCache sync=");
          ((StringBuilder)localObject1).append(paramBoolean);
          ((StringBuilder)localObject1).append(",isNeedSyncLoadRedBagInfo=");
          ((StringBuilder)localObject1).append(this.isNeedSyncLoadRedBagInfo);
          ((StringBuilder)localObject1).append(",isNeedLoadRedBagInfo=");
          ((StringBuilder)localObject1).append(this.isNeedLoadRedBagInfo);
          QLog.d("msgFold", 2, ((StringBuilder)localObject1).toString());
        }
        localObject1 = this.mPasswdRedBagDBManager.a().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          PasswdRedBagInfo localPasswdRedBagInfo = (PasswdRedBagInfo)((Iterator)localObject1).next();
          loadPasswdRedBagToCache(localPasswdRedBagInfo);
          ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).PasswdRedBagFoldManager$updateRedBagMapCache(this.mQQAppInterface, false, localPasswdRedBagInfo.jdField_a_of_type_JavaLangString, localPasswdRedBagInfo.jdField_b_of_type_JavaLangString);
        }
        this.isNeedSyncLoadRedBagInfo = false;
      }
      else
      {
        if ((!this.isNeedLoadRedBagInfo) || (!this.isNeedSyncLoadRedBagInfo)) {
          break label292;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("loadRedBagInfoToCache sync=");
          ((StringBuilder)localObject1).append(paramBoolean);
          ((StringBuilder)localObject1).append(",isNeedSyncLoadRedBagInfo=");
          ((StringBuilder)localObject1).append(this.isNeedSyncLoadRedBagInfo);
          ((StringBuilder)localObject1).append(",isNeedLoadRedBagInfo=");
          ((StringBuilder)localObject1).append(this.isNeedLoadRedBagInfo);
          QLog.d("msgFold", 2, ((StringBuilder)localObject1).toString());
        }
        ThreadManager.post(new PasswdRedBagServiceImpl.9(this), 8, null, false);
        this.isNeedLoadRedBagInfo = false;
      }
      return;
      label292:
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void loadRedBagRelationToCache()
  {
    try
    {
      if (isNeedReInit()) {
        reInit();
      }
      if ((this.isNeedLoadRedBagRelation) && (!this.isLoadingRedBagRelation))
      {
        this.isLoadingRedBagRelation = true;
        ThreadManager.excute(new PasswdRedBagServiceImpl.10(this), 32, null, true);
        return;
      }
      return;
    }
    finally {}
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mQQAppInterface = ((BaseQQAppInterface)paramAppRuntime);
    this.mContext = this.mQQAppInterface.getApplication();
    this.mUin = this.mQQAppInterface.getCurrentAccountUin();
    this.mPasswdRedBagDBManager = new PasswdRedBagDBManager(this);
    this.mQQAppInterface.addObserver(this.mQWalletObserver);
    this.mQWalletHandler = ((QWalletHandler)this.mQQAppInterface.getBusinessHandler(((IQWalletTemp)QRoute.api(IQWalletTemp.class)).BusinessHandlerFactory$QWALLET_HANDLER()));
    this.mPasswdCache = new HashMap();
    this.mIdiomRedBagsCache = new HashMap();
    this.mIdiomRedBagLensCache = new HashMap();
    this.mPasswdRedBagsCache = new QQHashMap(1008, 0, 100);
    this.mPasswdRedBagAuthKeyCache = new HashMap();
    this.mShengpiziRedBagsCache = new HashMap();
    this.mDefaultPasswds = new ArrayList();
    this.groupNeedUpdates = new ArrayList();
    this.disgroupNeedUpdates = new ArrayList();
    this.isNeedSyncLoadRedBagInfo = true;
    this.isNeedLoadRedBagInfo = true;
    this.isNeedLoadRedBagRelation = true;
    loadDBToCache();
    try
    {
      paramAppRuntime = new IntentFilter();
      this.mRedPacketRefreshReceiver = new PasswdRedBagServiceImpl.RedPacketRefreshReceiver(this, null);
      paramAppRuntime.addAction("grap_idiom_hb_result_action");
      this.mContext.registerReceiver(this.mRedPacketRefreshReceiver, paramAppRuntime);
      return;
    }
    catch (Throwable paramAppRuntime)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("regist RedPacketRefreshReceiver throw an excepion");
      localStringBuilder.append(paramAppRuntime);
      QLog.e("PasswdRedBagSgervice", 1, localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    this.mQWalletObserver.a();
    this.mQQAppInterface.removeObserver(this.mQWalletObserver);
    this.mPasswdRedBagDBManager.a();
    PasswdRedBagServiceImpl.RedPacketRefreshReceiver localRedPacketRefreshReceiver = this.mRedPacketRefreshReceiver;
    if (localRedPacketRefreshReceiver != null)
    {
      Context localContext = this.mContext;
      if (localContext != null) {
        localContext.unregisterReceiver(localRedPacketRefreshReceiver);
      }
    }
  }
  
  public void openPasswdBagByTenpay(BaseSessionInfo paramBaseSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt)
  {
    openPasswdBagByTenpay(paramBaseSessionInfo, paramPasswdRedBagInfo, paramLong, 32, "", 0, paramInt, null);
  }
  
  public void openPasswdBagByTenpay(BaseSessionInfo paramBaseSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    openPasswdBagByTenpay(paramBaseSessionInfo, paramPasswdRedBagInfo, paramLong, paramInt1, "", 0, paramInt2, paramBundle);
  }
  
  public void openPasswdBagByTenpay(BaseSessionInfo paramBaseSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt, Bundle paramBundle)
  {
    openPasswdBagByTenpay(paramBaseSessionInfo, paramPasswdRedBagInfo, paramLong, 524288, "", 0, paramInt, paramBundle);
  }
  
  public void openPasswdBagByTenpay(BaseSessionInfo paramBaseSessionInfo, PasswdRedBagInfo paramPasswdRedBagInfo, long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (paramBaseSessionInfo != null)
    {
      if (paramPasswdRedBagInfo == null) {
        return;
      }
      loadRedBagRelationToCache();
      Object localObject1 = this.mPasswdRedBagAuthKeyCache;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(transType(paramBaseSessionInfo.jdField_a_of_type_Int));
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramBaseSessionInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString);
      localObject2 = (String)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      if ((paramBaseSessionInfo.jdField_a_of_type_Int != 0) && (paramBaseSessionInfo.jdField_a_of_type_Int != 2) && (paramBaseSessionInfo.jdField_a_of_type_Int != 1004) && (paramBaseSessionInfo.jdField_a_of_type_Int != 1001) && (paramBaseSessionInfo.jdField_a_of_type_Int != 10002)) {
        i = 0;
      } else {
        i = 1;
      }
      localObject1 = paramBaseSessionInfo.jdField_a_of_type_JavaLangString;
      Object localObject3 = String.valueOf(paramPasswdRedBagInfo.c);
      if (i != 0) {
        if (((String)localObject3).equals(this.mUin)) {
          localObject1 = paramBaseSessionInfo.jdField_a_of_type_JavaLangString;
        } else {
          localObject1 = this.mUin;
        }
      }
      localObject3 = QWalletRedPkgUtils.a(this.mQQAppInterface, paramBaseSessionInfo);
      int i = ((Bundle)localObject3).getInt("groupType");
      localObject3 = ((Bundle)localObject3).getString("name");
      paramPasswdRedBagInfo = paramPasswdRedBagInfo.jdField_a_of_type_JavaLangString;
      paramBaseSessionInfo = QWalletRedPkgUtils.a(this.mQQAppInterface, paramBaseSessionInfo, i, (String)localObject3, paramPasswdRedBagInfo, (String)localObject2, (String)localObject1, "appid#1344242394|bargainor_id#1000030201|channel#msg", "graphb", null, paramInt1, 0, paramString, paramInt2, paramInt3, paramBundle);
      paramString = new Bundle();
      paramString.putString("json", paramBaseSessionInfo.toString());
      paramString.putString("callbackSn", "0");
      if ((paramPasswdRedBagInfo != null) && (paramPasswdRedBagInfo.length() > 4))
      {
        paramBaseSessionInfo = new StringBuilder();
        paramBaseSessionInfo.append("****");
        paramBaseSessionInfo.append(paramPasswdRedBagInfo.substring(4));
        paramBaseSessionInfo = paramBaseSessionInfo.toString();
      }
      else
      {
        paramBaseSessionInfo = paramPasswdRedBagInfo;
      }
      paramPasswdRedBagInfo = new StringBuilder();
      paramPasswdRedBagInfo.append("groupType=");
      paramPasswdRedBagInfo.append(i);
      paramPasswdRedBagInfo.append("&msgType=6&redId=");
      paramPasswdRedBagInfo.append(paramBaseSessionInfo);
      VACDReportUtil.a(paramLong, null, "open", paramPasswdRedBagInfo.toString(), 0, null);
      paramString.putLong("vacreport_key_seq", paramLong);
      paramBaseSessionInfo = new Intent();
      paramBaseSessionInfo.putExtras(paramString);
      paramBaseSessionInfo.addFlags(268435456);
      paramBaseSessionInfo.putExtra("pay_requestcode", 5);
      RouteUtils.a(this.mContext, paramBaseSessionInfo, "/base/payBridge");
    }
  }
  
  public Object[] openPasswdRedBagById(String paramString1, BaseSessionInfo paramBaseSessionInfo, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openPasswdRedBagById, id = ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Object[4];
    localObject[0] = Integer.valueOf(0);
    localObject[1] = Long.valueOf(0L);
    localObject[2] = null;
    localObject[3] = null;
    if (paramBaseSessionInfo == null) {
      return localObject;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return localObject;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendById", "msgType=6", 0, null);
    loadRedBagInfoToCache(false);
    loadRedBagRelationToCache();
    PasswdRedBagInfo localPasswdRedBagInfo = (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(paramString2);
    if (localPasswdRedBagInfo == null)
    {
      VACDReportUtil.endReport(l, "pwd.end", "", -1, "no redid");
      return localObject;
    }
    localObject[1] = Long.valueOf(localPasswdRedBagInfo.c);
    if (4 == localPasswdRedBagInfo.jdField_a_of_type_Int)
    {
      localObject[2] = null;
      localObject[3] = null;
    }
    else if (!localPasswdRedBagInfo.a())
    {
      localObject[2] = paramString2;
      localObject[3] = localPasswdRedBagInfo.jdField_b_of_type_JavaLangString;
    }
    if (4 != localPasswdRedBagInfo.jdField_a_of_type_Int)
    {
      if (localPasswdRedBagInfo.jdField_a_of_type_Boolean)
      {
        VACDReportUtil.endReport(l, "pwd.end", "", -1, "opened");
        return localObject;
      }
      if (localPasswdRedBagInfo.jdField_b_of_type_Boolean)
      {
        localObject[0] = Integer.valueOf(2);
        VACDReportUtil.endReport(l, "pwd.end", "", -1, "finish");
        return localObject;
      }
      if ((localPasswdRedBagInfo.a()) && (4 != localPasswdRedBagInfo.jdField_a_of_type_Int))
      {
        localObject[0] = Integer.valueOf(3);
        VACDReportUtil.endReport(l, "pwd.end", "", -1, "overdue");
        return localObject;
      }
    }
    if (!TextUtils.isEmpty(paramString1)) {
      if ((localPasswdRedBagInfo.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(localPasswdRedBagInfo.d)) && (paramString1.equals(localPasswdRedBagInfo.d)))
      {
        setPasswdRedBagOpen(localPasswdRedBagInfo.jdField_a_of_type_JavaLangString, paramBaseSessionInfo.jdField_a_of_type_JavaLangString, paramBaseSessionInfo.jdField_a_of_type_Int);
        openPasswdBagByTenpay(paramBaseSessionInfo, localPasswdRedBagInfo, l, paramInt);
      }
      else if ((4 == localPasswdRedBagInfo.jdField_a_of_type_Int) && (isMatchIdomRedBag(paramString1, localPasswdRedBagInfo)) && (!localPasswdRedBagInfo.jdField_b_of_type_Boolean) && (!localPasswdRedBagInfo.a()))
      {
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("----成语接龙红包----");
          paramString2.append(localPasswdRedBagInfo.jdField_a_of_type_JavaLangString);
          QLog.i("PasswdRedBagSgervice", 2, paramString2.toString());
        }
        openSolitaireRedBagByIdiom(paramString1.trim(), paramBaseSessionInfo, localPasswdRedBagInfo, l, paramInt);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("PasswdRedBagSgervice", 2, "openPasswdRedBagById| 根据输入文字进行匹配");
        }
        return openPasswdRedBagByPassword(paramBaseSessionInfo, paramString1.trim(), paramInt);
      }
    }
    localObject[0] = Integer.valueOf(1);
    return localObject;
  }
  
  public Object[] openPasswdRedBagByPassword(BaseSessionInfo paramBaseSessionInfo, String paramString, int paramInt)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(0);
    arrayOfObject[1] = Long.valueOf(0L);
    arrayOfObject[2] = null;
    arrayOfObject[3] = null;
    if (paramBaseSessionInfo == null) {
      return arrayOfObject;
    }
    if (TextUtils.isEmpty(paramString)) {
      return arrayOfObject;
    }
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString.charAt(0));
      ((StringBuilder)localObject1).append("|");
      ((StringBuilder)localObject1).append(paramString.length());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("openPasswdRedBagByPassword, passwd = ");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject2).toString());
    }
    long l = SystemClock.uptimeMillis();
    loadRedBagInfoToCache(false);
    loadRedBagRelationToCache();
    PasswdRedBagInfo localPasswdRedBagInfo;
    try
    {
      localObject1 = getSelectRedBag(paramBaseSessionInfo, paramString, arrayOfObject);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("PasswdRedBagSgervice", 2, QLog.getStackTraceString(localThrowable));
      localPasswdRedBagInfo = null;
    }
    if (localPasswdRedBagInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PasswdRedBagSgervice", 2, "openPasswdRedBagByPassword, selectPasswdRedBagInfo = null");
      }
      return arrayOfObject;
    }
    l = VACDReportUtil.a(null, "qqwallet", "graphb", "pwd.sendByPwd", "msgType=6", 0, null, l);
    if (localPasswdRedBagInfo.jdField_a_of_type_Int == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("----word hb----");
        ((StringBuilder)localObject2).append(localPasswdRedBagInfo.jdField_a_of_type_JavaLangString);
        QLog.i("PasswdRedBagSgervice", 2, ((StringBuilder)localObject2).toString());
      }
      if ((!TextUtils.isEmpty(paramString)) && (localPasswdRedBagInfo != null) && (!TextUtils.isEmpty(localPasswdRedBagInfo.d)) && (paramString.trim().equals(localPasswdRedBagInfo.d.trim())))
      {
        setPasswdRedBagOpen(localPasswdRedBagInfo.jdField_a_of_type_JavaLangString, paramBaseSessionInfo.jdField_a_of_type_JavaLangString, paramBaseSessionInfo.jdField_a_of_type_Int);
        openPasswdBagByTenpay(paramBaseSessionInfo, localPasswdRedBagInfo, l, paramInt);
        return arrayOfObject;
      }
    }
    else if (4 == localPasswdRedBagInfo.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("----word chain hb----");
        ((StringBuilder)localObject2).append(localPasswdRedBagInfo.jdField_a_of_type_JavaLangString);
        QLog.i("PasswdRedBagSgervice", 2, ((StringBuilder)localObject2).toString());
      }
      if (isMatchIdomRedBag(paramString, localPasswdRedBagInfo))
      {
        openSolitaireRedBagByIdiom(paramString.trim(), paramBaseSessionInfo, localPasswdRedBagInfo, l, paramInt);
        return arrayOfObject;
      }
    }
    else if (8 == localPasswdRedBagInfo.jdField_a_of_type_Int)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("----word hb----");
        ((StringBuilder)localObject2).append(localPasswdRedBagInfo.jdField_a_of_type_JavaLangString);
        QLog.i("PasswdRedBagSgervice", 2, ((StringBuilder)localObject2).toString());
      }
      if ((!TextUtils.isEmpty(paramString)) && (localPasswdRedBagInfo != null) && (!TextUtils.isEmpty(localPasswdRedBagInfo.d)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString.trim().toUpperCase());
        ((StringBuilder)localObject2).append("&rareword");
        if (MD5.a(((StringBuilder)localObject2).toString()).substring(0, 8).equals(localPasswdRedBagInfo.d.trim()))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("answer", paramString);
          ((Bundle)localObject2).putInt("channel", 1000003);
          ((Bundle)localObject2).putString("hb_from", localPasswdRedBagInfo.a());
          openPasswdBagByTenpay(paramBaseSessionInfo, localPasswdRedBagInfo, l, paramInt, (Bundle)localObject2);
        }
      }
    }
    return arrayOfObject;
  }
  
  public void refreshCureentIdomResbag(BaseSessionInfo paramBaseSessionInfo, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty())) {
      VoiceRedPacketHelperImpl.getInstance().getSkey(new PasswdRedBagServiceImpl.4(this, paramArrayList, paramBaseSessionInfo));
    }
  }
  
  public void reportPasswdRedBagClick(String paramString, boolean paramBoolean)
  {
    BaseQQAppInterface localBaseQQAppInterface = this.mQQAppInterface;
    String str;
    if (paramBoolean) {
      str = "0";
    } else {
      str = "1";
    }
    ReportController.b(localBaseQQAppInterface, "CliOper", "", "", "0X8006115", "0X8006115", 0, 0, "", str, paramString, "0");
  }
  
  public void reportPasswdTipsClick(String paramString)
  {
    ReportController.b(this.mQQAppInterface, "CliOper", "", "", "0X8006116", "0X8006116", 0, 0, "", "0", paramString, "0");
  }
  
  public void requestPasswdRedBagByDisgroups()
  {
    Object localObject1 = this.mCacheDisGroupInfos;
    if (localObject1 != null)
    {
      if (((HashMap)localObject1).size() == 0) {
        return;
      }
      this.disgroupNeedUpdates.clear();
      localObject1 = new ArrayList();
      List localList = this.mPasswdRedBagDBManager.a(2);
      Iterator localIterator = this.mCacheDisGroupInfos.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        PasswdRedBagUpdateInfo localPasswdRedBagUpdateInfo = new PasswdRedBagUpdateInfo();
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Long = Long.parseLong((String)localObject2);
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Int = 2;
        localPasswdRedBagUpdateInfo.b = Long.parseLong((String)this.mCacheDisGroupInfos.get(localObject2));
        int i = localList.indexOf(localPasswdRedBagUpdateInfo);
        if (i != -1)
        {
          localObject2 = (PasswdRedBagUpdateInfo)localList.get(i);
          if (localPasswdRedBagUpdateInfo.b <= ((PasswdRedBagUpdateInfo)localObject2).b) {}
        }
        else
        {
          localObject2 = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject2).uint64_code.set(localPasswdRedBagUpdateInfo.jdField_a_of_type_Long);
          ((oidb_0x438.ReqInfo)localObject2).uint64_last_redbag_time.set(localPasswdRedBagUpdateInfo.b);
          ((List)localObject1).add(localObject2);
          this.disgroupNeedUpdates.add(localPasswdRedBagUpdateInfo);
        }
      }
      this.mCacheDisGroupInfos.clear();
      if (this.disgroupNeedUpdates.isEmpty()) {
        return;
      }
      this.mQWalletHandler.a(1, (List)localObject1);
    }
  }
  
  public void requestPasswdRedBagByGroups()
  {
    Object localObject1 = this.mCacheGroupInfos;
    if (localObject1 != null)
    {
      if (((HashMap)localObject1).size() == 0) {
        return;
      }
      this.groupNeedUpdates.clear();
      localObject1 = new ArrayList();
      List localList = this.mPasswdRedBagDBManager.a(1);
      Iterator localIterator = this.mCacheGroupInfos.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        PasswdRedBagUpdateInfo localPasswdRedBagUpdateInfo = new PasswdRedBagUpdateInfo();
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Long = Long.parseLong((String)localObject2);
        localPasswdRedBagUpdateInfo.jdField_a_of_type_Int = 1;
        localPasswdRedBagUpdateInfo.b = Long.parseLong((String)this.mCacheGroupInfos.get(localObject2));
        int i = localList.indexOf(localPasswdRedBagUpdateInfo);
        if (i != -1)
        {
          localObject2 = (PasswdRedBagUpdateInfo)localList.get(i);
          if (localPasswdRedBagUpdateInfo.b <= ((PasswdRedBagUpdateInfo)localObject2).b) {}
        }
        else
        {
          localObject2 = new oidb_0x438.ReqInfo();
          ((oidb_0x438.ReqInfo)localObject2).uint64_code.set(localPasswdRedBagUpdateInfo.jdField_a_of_type_Long);
          ((oidb_0x438.ReqInfo)localObject2).uint64_last_redbag_time.set(localPasswdRedBagUpdateInfo.b);
          ((List)localObject1).add(localObject2);
          this.groupNeedUpdates.add(localPasswdRedBagUpdateInfo);
        }
      }
      this.mCacheGroupInfos.clear();
      if (this.groupNeedUpdates.isEmpty()) {
        return;
      }
      this.mQWalletHandler.a(0, (List)localObject1);
    }
  }
  
  public void saveDisGroupInfos(HashMap<String, String> paramHashMap)
  {
    if (this.mCacheDisGroupInfos == null) {
      this.mCacheDisGroupInfos = new HashMap();
    }
    this.mCacheDisGroupInfos.putAll(paramHashMap);
  }
  
  public void saveGroupInfos(HashMap<String, String> paramHashMap)
  {
    if (this.mCacheGroupInfos == null) {
      this.mCacheGroupInfos = new HashMap();
    }
    this.mCacheGroupInfos.putAll(paramHashMap);
  }
  
  public void savePasswdRedBag(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    savePasswdRedBag(paramString1, paramString2, paramString3, paramString4, paramLong, paramString5, paramString6, paramString7, paramBoolean1, paramBoolean2, paramInt, "", "");
  }
  
  public void savePasswdRedBag(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString8, String paramString9)
  {
    if ((PasswdRedBagInfo)this.mPasswdRedBagsCache.get(paramString1) == null)
    {
      paramString2 = new PasswdRedBagInfo(paramString1, paramString2, paramString4, paramLong, new QQText(paramString3, 5, 16).toString(), paramBoolean1, paramBoolean2, paramInt, paramString8, paramString9);
      loadPasswdRedBagToCache(paramString2);
      ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).PasswdRedBagFoldManager$updateRedBagMapCache(this.mQQAppInterface, true, paramString2.jdField_a_of_type_JavaLangString, paramString2.jdField_b_of_type_JavaLangString);
      ThreadManager.getFileThreadHandler().post(new PasswdRedBagServiceImpl.11(this, paramString2));
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString5);
    paramString2.append("_");
    paramString2.append(paramString6);
    paramString2.append("_");
    paramString2.append(paramString1);
    if (TextUtils.isEmpty((String)this.mPasswdRedBagAuthKeyCache.get(paramString2.toString())))
    {
      this.mPasswdRedBagAuthKeyCache.put(paramString2.toString(), paramString7);
      ThreadManager.getFileThreadHandler().post(new PasswdRedBagServiceImpl.12(this, paramString5, paramString6, paramString1, paramString7));
    }
  }
  
  public void savePasswdRedBagFromNet(im_msg_body.QQWalletAioBody paramQQWalletAioBody, int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2, String paramString1, String paramString2)
  {
    String str = paramQQWalletAioBody.receiver.bytes_title.get().toStringUtf8();
    if (paramQQWalletAioBody.sint32_msgtype.get() == 29) {
      str = new QQWalletAioBodyReserve(paramQQWalletAioBody).shengpiziMD5;
    }
    savePasswdRedBag(paramQQWalletAioBody.bytes_billno.get().toStringUtf8(), paramQQWalletAioBody.string_index.get().toStringUtf8(), str, String.valueOf(paramLong2), paramLong3 + 90000L, String.valueOf(paramInt1), String.valueOf(paramLong1), paramQQWalletAioBody.bytes_authkey.get().toStringUtf8(), false, false, paramInt2, paramString1, paramString2);
  }
  
  public void setPasswdRedBagFinish(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    loadRedBagInfoToCache(false);
    PasswdRedBagInfo localPasswdRedBagInfo = (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(paramString);
    if (localPasswdRedBagInfo == null) {
      return;
    }
    if (localPasswdRedBagInfo.jdField_b_of_type_Boolean) {
      return;
    }
    localPasswdRedBagInfo.jdField_b_of_type_Boolean = true;
    ThreadManager.getFileThreadHandler().post(new PasswdRedBagServiceImpl.13(this, paramString));
  }
  
  public void setPasswdRedBagLastedWord(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    try
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("<<<setPasswdRedBagLastedWord start<<< |redBagId: ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" lastedWord: ");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(" lastPinyin: ");
        ((StringBuilder)localObject1).append(paramString3);
        QLog.i("PasswdRedBagSgervice", 2, ((StringBuilder)localObject1).toString());
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        loadRedBagInfoToCache(false);
        localObject1 = (PasswdRedBagInfo)this.mPasswdRedBagsCache.get(paramString1);
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("setPasswdRedBagLastedWord|passwdRedBagInfo: ");
          ((StringBuilder)localObject2).append(localObject1);
          QLog.d("PasswdRedBagSgervice", 2, ((StringBuilder)localObject2).toString());
        }
        if (localObject1 == null) {
          return;
        }
        if (TextUtils.isEmpty(paramString3))
        {
          if (((PasswdRedBagInfo)localObject1).a() == 3) {
            setPasswdRedBagFinish(paramString1);
          }
          return;
        }
        try
        {
          localObject2 = this.mPasswdRedBagDBManager.a(((PasswdRedBagInfo)localObject1).f);
          if (localObject2 != null)
          {
            int i = ((JSONObject)localObject2).optInt("key_extstr_idiomseq");
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("oldSeq: ");
              localStringBuilder.append(i);
              localStringBuilder.append(" newSeq: ");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(" extObj: ");
              localStringBuilder.append(((JSONObject)localObject2).toString());
              localStringBuilder.append(" lastpassword: ");
              localStringBuilder.append(((PasswdRedBagInfo)localObject1).e);
              QLog.d("PasswdRedBagSgervice", 2, localStringBuilder.toString());
            }
            if (paramInt > i)
            {
              ((JSONObject)localObject2).put("key_extstr_idiomseq", paramInt);
              PasswdRedBagInfo.a((JSONObject)localObject2, paramString4);
              ((PasswdRedBagInfo)localObject1).f = ((JSONObject)localObject2).toString();
              paramString4 = new StringBuilder();
              paramString4.append(paramString2.trim());
              paramString4.append("_");
              paramString4.append(paramString3.trim());
              paramString2 = paramString4.toString();
              if (QLog.isColorLevel())
              {
                paramString3 = new StringBuilder();
                paramString3.append("finalLastWord: ");
                paramString3.append(paramString2);
                QLog.d("PasswdRedBagSgervice", 2, paramString3.toString());
              }
              paramString3 = getLastIdiomPinyin(((PasswdRedBagInfo)localObject1).e);
              ((PasswdRedBagInfo)localObject1).e = paramString2;
              updateIdiomRedBagToCache((PasswdRedBagInfo)localObject1, paramString3);
              ThreadManager.getFileThreadHandler().post(new PasswdRedBagServiceImpl.15(this, paramString1, paramString2, (JSONObject)localObject2));
            }
          }
        }
        catch (Throwable paramString1)
        {
          paramString1.printStackTrace();
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public void setPasswdRedBagOpen(String paramString1, String paramString2, int paramInt)
  {
    setPasswdRedBagOpenStatus(paramString1, paramString2, paramInt, true);
  }
  
  public int transType(int paramInt)
  {
    int i = 1;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return i;
      }
      if ((paramInt != 1000) && (paramInt != 1001) && (paramInt != 1004)) {
        if (paramInt != 3000)
        {
          if ((paramInt != 10002) && (paramInt != 10004) && (paramInt != 10008)) {
            return 0;
          }
        }
        else {
          return 2;
        }
      }
    }
    i = 3;
    return i;
  }
  
  public void updateIdiomBubbleView(Context paramContext, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      if ((paramContext instanceof QBaseActivity))
      {
        paramContext = (QBaseActivity)paramContext;
        paramContext = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).ChatFragment$getCurPie(paramContext);
        if (paramContext != null)
        {
          paramContext = paramContext.a();
          if (paramContext != null) {
            paramContext.a(paramString2, paramString1);
          }
        }
      }
    }
  }
  
  public void updateIdiomRedbagsLastword(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return;
      }
      setPasswdRedBagLastedWord(paramString1, paramString3, paramString4, paramInt2, paramString5);
    }
  }
  
  public void updatePasswdConfig(HashSet<String> paramHashSet)
  {
    this.mDefaultPasswds.clear();
    this.mDefaultPasswds.addAll(paramHashSet);
    saveConfigs(paramHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.passwd.impl.PasswdRedBagServiceImpl
 * JD-Core Version:    0.7.0.1
 */