package com.tencent.mobileqq.utils.fts;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.interfaces.IFTSConfig.DefaultConfig;
import com.tencent.mobileqq.fts.v2.tokenizer.Token;
import com.tencent.mobileqq.fts.v2.tokenizer.cn.ChineseTokenizer;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.business.contact.ContactSearchEngine;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelDiscussionMember;
import com.tencent.mobileqq.search.business.contact.model.ContactSearchModelFriend;
import com.tencent.mobileqq.search.business.contact.model.IContactSearchModel;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SQLiteFTSUtils
{
  public static boolean a = false;
  private static boolean b = false;
  private static int c = -1;
  private static int d = -1;
  private static int e = -1;
  private static int f = -1;
  private static int g = -1;
  private static int h = -1;
  
  private static int a(Context paramContext)
  {
    paramContext = (Activity)paramContext;
    if ((paramContext instanceof FTSEntitySearchActivity)) {
      return 2;
    }
    if ((paramContext instanceof FTSEntitySearchDetailActivity)) {
      return 3;
    }
    return 0;
  }
  
  public static int a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (f == -1)
    {
      SharedPreferences localSharedPreferences = paramBaseApplicationImpl.getSharedPreferences("fts_sp_file", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fts_notify_flag");
      localStringBuilder.append(paramBaseApplicationImpl.getRuntime().getAccount());
      f = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    }
    return f;
  }
  
  public static Pair<CharSequence, CharSequence> a(IContactSearchModel paramIContactSearchModel)
  {
    if ((paramIContactSearchModel instanceof ContactSearchModelFriend)) {
      return ((ContactSearchModelFriend)paramIContactSearchModel).r();
    }
    if ((paramIContactSearchModel instanceof ContactSearchModelDiscussionMember)) {
      return ((ContactSearchModelDiscussionMember)paramIContactSearchModel).r();
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return paramString1;
      }
      if ((paramInt != 0) && (paramInt != 1000) && (paramInt != 1004)) {
        return ContactUtils.a(paramQQAppInterface, paramString1, paramInt);
      }
      if (AppConstants.SYSTEM_MSG_UIN.equals(paramString1)) {
        return paramContext.getString(2131916963);
      }
      if (AppConstants.QQBROADCAST_MSG_UIN.equals(paramString1)) {
        return paramContext.getString(2131916962);
      }
      if (AppConstants.VOTE_MSG_UIN.equals(paramString1)) {
        return paramContext.getString(2131917014);
      }
      if (paramInt == 1000)
      {
        TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        paramContext = paramString1;
        if (localTroopManager != null) {
          paramContext = ContactUtils.a(paramQQAppInterface, paramString1, localTroopManager.k(paramString2), paramString2, true, null);
        }
        return paramContext;
      }
      if (paramInt == 1004)
      {
        paramContext = ContactUtils.a(paramQQAppInterface, paramString2, paramString1);
        if ((paramContext != null) && (paramContext.equals(paramString1))) {
          return ContactUtils.a(paramQQAppInterface, paramString1, true);
        }
        return paramContext;
      }
      return ContactUtils.a(paramQQAppInterface, paramString1, paramInt);
    }
    return paramString1;
  }
  
  public static ArrayList<SQLiteFTSUtils.MsgSearchContactInfo> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    long l1 = System.nanoTime();
    int k = paramString.length();
    int n = 0;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      if (paramString.charAt(j) < '') {
        i += 1;
      } else {
        i += 2;
      }
      j += 1;
    }
    j = i / 2 + 2;
    if (i >= 3) {
      k = i * 2;
    } else {
      k = -1;
    }
    ArrayList localArrayList = new ArrayList();
    int m = j;
    Object localObject1;
    Object localObject2;
    if (i >= 3)
    {
      localObject1 = paramQQAppInterface.getCurrentAccountUin();
      localObject2 = ContactUtils.a(paramQQAppInterface, (String)localObject1, true);
      if (((String)localObject2).toLowerCase().startsWith(paramString.toLowerCase()))
      {
        localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
        ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131168189)), 0, paramString.length(), 17);
        localArrayList.add(new SQLiteFTSUtils.MsgSearchContactInfo((String)localObject1, 0, new Pair(localObject2, null)));
      }
      for (;;)
      {
        m = j + 1;
        break;
        Object localObject3;
        if (((String)localObject1).toLowerCase().startsWith(paramString.toLowerCase()))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("(");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(")");
          localObject3 = new SpannableStringBuilder(((StringBuilder)localObject3).toString());
          ((SpannableStringBuilder)localObject3).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131168189)), 1, paramString.length() + 1, 17);
          localArrayList.add(new SQLiteFTSUtils.MsgSearchContactInfo((String)localObject1, 0, new Pair(localObject2, localObject3)));
        }
        else
        {
          localObject3 = SearchUtils.a((String)localObject2, paramString, 1);
          if (localObject3[0] == 0)
          {
            i = localObject3[1];
            localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
            ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131168189)), 0, i, 17);
            localArrayList.add(new SQLiteFTSUtils.MsgSearchContactInfo((String)localObject1, 0, new Pair(localObject2, null)));
          }
          else
          {
            localObject3 = SearchUtils.a((String)localObject2, paramString, 2);
            m = j;
            if (localObject3[0] != 0) {
              break;
            }
            i = localObject3[1];
            localObject2 = new SpannableStringBuilder((CharSequence)localObject2);
            ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(BaseApplicationImpl.sApplication.getResources().getColor(2131168189)), 0, i, 17);
            localArrayList.add(new SQLiteFTSUtils.MsgSearchContactInfo((String)localObject1, 0, new Pair(localObject2, null)));
          }
        }
      }
    }
    paramQQAppInterface = new ContactSearchEngine(paramQQAppInterface, 10001, 29, null);
    paramQQAppInterface.a();
    paramQQAppInterface = paramQQAppInterface.a(new SearchRequest(paramString));
    if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
    {
      localObject1 = paramQQAppInterface.iterator();
      j = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (IContactSearchModel)((Iterator)localObject1).next();
        if ((((IContactSearchModel)localObject2).u() & 0xFFFFFFFF & 0xFF000000) >> 24 != 2L)
        {
          i = localArrayList.size();
          paramQQAppInterface = "null";
          if (i < m)
          {
            if ((((IContactSearchModel)localObject2).j() != 0) && (((IContactSearchModel)localObject2).j() != 1004))
            {
              localArrayList.add(new SQLiteFTSUtils.MsgSearchContactInfo(((IContactSearchModel)localObject2).c(), ((IContactSearchModel)localObject2).j(), null));
            }
            else
            {
              j += 1;
              paramString = a((IContactSearchModel)localObject2);
              localArrayList.add(new SQLiteFTSUtils.MsgSearchContactInfo(((IContactSearchModel)localObject2).c(), ((IContactSearchModel)localObject2).j(), paramString));
            }
            i = j;
            if (QLog.isColorLevel())
            {
              if (((IContactSearchModel)localObject2).c() == null) {
                paramString = "null";
              } else {
                paramString = ((IContactSearchModel)localObject2).c();
              }
              i = ((IContactSearchModel)localObject2).j();
              if (((IContactSearchModel)localObject2).d() != null) {
                paramQQAppInterface = ((IContactSearchModel)localObject2).d();
              }
              QLog.d("Q.fts.utils", 2, String.format("contactSearchForTopN, contact uin: %s, uinType: %d, matchTitle: %s", new Object[] { paramString, Integer.valueOf(i), paramQQAppInterface }));
              i = j;
            }
          }
          else
          {
            if (j >= k) {
              break;
            }
            if (((IContactSearchModel)localObject2).j() == 0) {
              break label823;
            }
            i = j;
            if (((IContactSearchModel)localObject2).j() == 1004) {
              break label823;
            }
          }
          for (;;)
          {
            break;
            label823:
            j += 1;
            paramString = a((IContactSearchModel)localObject2);
            localArrayList.add(new SQLiteFTSUtils.MsgSearchContactInfo(((IContactSearchModel)localObject2).c(), ((IContactSearchModel)localObject2).j(), paramString));
            i = j;
            if (QLog.isColorLevel())
            {
              if (((IContactSearchModel)localObject2).c() == null) {
                paramString = "null";
              } else {
                paramString = ((IContactSearchModel)localObject2).c();
              }
              i = ((IContactSearchModel)localObject2).j();
              if (((IContactSearchModel)localObject2).d() != null) {
                paramQQAppInterface = ((IContactSearchModel)localObject2).d();
              }
              QLog.d("Q.fts.utils", 2, String.format("contactSearchForTopN, contact uin: %s, uinType: %d, matchTitle: %s", new Object[] { paramString, Integer.valueOf(i), paramQQAppInterface }));
              i = j;
            }
          }
          j = i;
        }
      }
    }
    long l2 = System.nanoTime();
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("contactSearchForTopN, cost: ");
      paramQQAppInterface.append((l2 - l1) / 1000000L);
      paramQQAppInterface.append("ms size: ");
      paramQQAppInterface.append(localArrayList.size());
      paramQQAppInterface.append(" contactNum: ");
      paramQQAppInterface.append(m);
      paramQQAppInterface.append(" friendNum: ");
      paramQQAppInterface.append(k);
      QLog.d("Q.fts.utils", 2, paramQQAppInterface.toString());
      i = n;
      while (i < localArrayList.size())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("index = ");
        paramQQAppInterface.append(i);
        paramQQAppInterface.append(", contactInfo = ");
        paramQQAppInterface.append(localArrayList.get(i));
        QLog.i("Q.fts.utils", 2, paramQQAppInterface.toString());
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void a(View paramView)
  {
    HashMap localHashMap = new HashMap();
    SQLiteFTSUtils.FtsItemClickEvent.c = a(paramView.getContext());
    paramView = (Integer)paramView.getTag(2131449868);
    int i;
    if (paramView != null) {
      i = paramView.intValue();
    } else {
      i = -1;
    }
    SQLiteFTSUtils.FtsItemClickEvent.e = i + 1;
    if (SQLiteFTSUtils.FtsItemClickEvent.f == 1)
    {
      SQLiteFTSUtils.FtsItemClickEvent.h = SQLiteFTSUtils.FtsItemClickEvent.n + (System.nanoTime() - SQLiteFTSUtils.FtsItemClickEvent.m) / 1000000L;
      SQLiteFTSUtils.FtsItemClickEvent.i = SQLiteFTSUtils.FtsItemClickEvent.p + (System.nanoTime() - SQLiteFTSUtils.FtsItemClickEvent.o) / 1000000L;
    }
    if (SQLiteFTSUtils.FtsItemClickEvent.d == 1)
    {
      SQLiteFTSUtils.FtsItemClickEvent.j = -1;
      SQLiteFTSUtils.FtsItemClickEvent.k = -1;
      SQLiteFTSUtils.FtsItemClickEvent.l = -1;
    }
    localHashMap.put("keyNum", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.a));
    localHashMap.put("firstKeyLen", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.b));
    localHashMap.put("itemPage", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.c));
    localHashMap.put("itemSearchStrategy", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.d));
    localHashMap.put("itemPosition", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.e));
    localHashMap.put("itemType", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.f));
    localHashMap.put("itemUinType", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.g));
    if (SQLiteFTSUtils.FtsItemClickEvent.f == 1)
    {
      localHashMap.put("totalCost", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.h));
      localHashMap.put("searchCost", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.i));
    }
    localHashMap.put("senderNum", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.j));
    localHashMap.put("friendNum", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.k));
    localHashMap.put("friendIndex", String.valueOf(SQLiteFTSUtils.FtsItemClickEvent.l));
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actFtsItemClickEvent", true, SQLiteFTSUtils.FtsItemClickEvent.h, SQLiteFTSUtils.FtsItemClickEvent.i, localHashMap, "", false);
    if ((SQLiteFTSUtils.FtsItemClickEvent.f == 1) && (QLog.isColorLevel()))
    {
      paramView = new StringBuilder();
      paramView.append("actFtsItemClickEvent: totalCost = ");
      paramView.append(SQLiteFTSUtils.FtsItemClickEvent.h);
      paramView.append(", searchCost = ");
      paramView.append(SQLiteFTSUtils.FtsItemClickEvent.i);
      QLog.d("Q.fts.utils", 2, paramView.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("install_external_report_flag");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.utils", 2, "setConfigToFTSComp");
    }
    paramAppRuntime = (IFTSDBRuntimeService)paramAppRuntime.getRuntimeService(IFTSDBRuntimeService.class, "");
    if ((paramAppRuntime.getIFTSConfig() instanceof IFTSConfig.DefaultConfig))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.utils", 2, "setConfigToFTSComp: is Default Config");
      }
      paramAppRuntime.setIFTSConfig(new SQLiteFTSUtils.2());
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("support_fts4_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
  }
  
  public static boolean a()
  {
    PackageManager localPackageManager = BaseApplicationImpl.getApplication().getPackageManager();
    try
    {
      int i = localPackageManager.getApplicationInfo(BaseApplicationImpl.getApplication().getPackageName(), 0).flags;
      if ((i & 0x40000) != 0) {
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "isInstallOnSDCard: failure", localException);
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return (c(paramQQAppInterface) == 1) && (!b());
  }
  
  public static String[] a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new StringBuilder(32);
    paramString = new ChineseTokenizer(new StringReader(paramString));
    for (;;)
    {
      int i = 0;
      try
      {
        Token localToken = paramString.a();
        if (localToken != null)
        {
          if (TextUtils.isEmpty(localToken.a())) {
            continue;
          }
          ((StringBuilder)localObject).append(localToken.a());
          ((StringBuilder)localObject).append(' ');
        }
      }
      catch (IOException paramString)
      {
        ((StringBuilder)localObject).setLength(0);
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.utils", 2, "keywordSegment: failure", paramString);
        }
        paramString = new ArrayList();
        if (((StringBuilder)localObject).length() > 0) {
          paramString.add(((StringBuilder)localObject).toString().trim());
        }
        if (paramString.size() == 0) {
          return null;
        }
        localObject = new String[paramString.size()];
        while (i < paramString.size())
        {
          localObject[i] = ((String)paramString.get(i));
          i += 1;
        }
      }
    }
    return localObject;
  }
  
  public static int b(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("support_fts4_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), -1);
  }
  
  public static ArrayList<String> b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.replaceAll("[^A-Za-z0-9\\u4e00-\\u9fa5]", " ").split("\\s");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.length)
    {
      String str = paramString[i].trim();
      if ((str != null) && (!TextUtils.isEmpty(str))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("low_rom_for_fts_report_flag");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b()
  {
    if (a) {
      return b;
    }
    a = true;
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "QQ install on SDCard");
      }
      if (!b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_ROM", DeviceInfoUtil.v());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actQQInstallExternal", true, -1L, 0L, (HashMap)localObject1, null, false);
        a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true);
      }
    }
    Object localObject1 = DeviceInfoUtil.p();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Rom total size: ");
      ((StringBuilder)localObject2).append(localObject1[0]);
      ((StringBuilder)localObject2).append(" MB, Rom available size: ");
      ((StringBuilder)localObject2).append(localObject1[1]);
      ((StringBuilder)localObject2).append(" MB");
      QLog.i("Q.fts.utils", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1[0] == -1L)
    {
      b = true;
      return true;
    }
    try
    {
      localObject2 = BaseApplicationImpl.getApplication().getFilesDir().getPath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((String)localObject2).substring(0, ((String)localObject2).lastIndexOf("/")));
      localStringBuilder.append("/databases");
      localObject2 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      localStringBuilder.append(".db");
      long l = new File((String)localObject2, localStringBuilder.toString()).length();
      double d1 = l;
      Double.isNaN(d1);
      d1 /= 1048576.0D;
      l = Math.ceil(d1);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("uin.db size: ");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append(" MB");
        QLog.i("Q.fts.utils", 2, ((StringBuilder)localObject2).toString());
      }
      if (localObject1[1] > 5L * l)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.fts.utils", 2, "NOT Low Rom For FTS");
        }
        b = false;
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.fts.utils", 2, "IS Low Rom For FTS");
      }
      if (!c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("param_ROM", DeviceInfoUtil.v());
        ((HashMap)localObject2).put("param_totalrom", String.valueOf(localObject1[0]));
        ((HashMap)localObject2).put("param_availrom", String.valueOf(localObject1[1]));
        ((HashMap)localObject2).put("param_dbsize", String.valueOf(l));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actLowRomForFTS", true, -1L, 0L, (HashMap)localObject2, null, false);
        b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), true);
      }
      b = true;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "isLowRomForFTS: failure", localException);
      }
      b = true;
    }
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("install_external_report_flag");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int c(AppRuntime paramAppRuntime)
  {
    int j = b(paramAppRuntime);
    int i = j;
    if (j == -1)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        a(paramAppRuntime, 1);
        return 1;
      }
      a(paramAppRuntime, 0);
      i = 0;
    }
    return i;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hardware_support_fts_flag");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("low_rom_for_fts_report_flag");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int d(QQAppInterface paramQQAppInterface)
  {
    if (c == -1)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fts_compare_flag");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      c = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    }
    return c;
  }
  
  public static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_first_flag");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean d(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_log_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int e(QQAppInterface paramQQAppInterface)
  {
    if (d == -1)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fts_extension_flag");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      d = localSharedPreferences.getInt(localStringBuilder.toString(), 1);
    }
    return d;
  }
  
  public static boolean e(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_upgrade_table_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int f(QQAppInterface paramQQAppInterface)
  {
    if (e == -1)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("fts_sp_file", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fts_extension_conversation_flag");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      e = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    }
    return e;
  }
  
  public static boolean f(AppRuntime paramAppRuntime)
  {
    return (d(paramAppRuntime)) && (e(paramAppRuntime));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.fts.SQLiteFTSUtils
 * JD-Core Version:    0.7.0.1
 */