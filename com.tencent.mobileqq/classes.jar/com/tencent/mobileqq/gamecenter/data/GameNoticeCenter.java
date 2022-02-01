package com.tencent.mobileqq.gamecenter.data;

import aber;
import abet;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import atwv;
import atww;
import atwx;
import atwy;
import atzb;
import bfwv;
import bhpc;
import bhvs;
import bifp;
import bifq;
import bleb;
import blec;
import bled;
import blef;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class GameNoticeCenter
  extends CopyOnWriteArrayList<GameNoticeInfo>
  implements aber, Handler.Callback, bleb
{
  public static final long HOUR_3 = 10800000L;
  public static final long HOUR_8 = 28800000L;
  public static final long MIN_1 = 60000L;
  public static final long MIN_5 = 300000L;
  public static final long ONE_DAY = 86400000L;
  public static final long SEVEN_DAY = 604800000L;
  public static final String TAG = "GameNoticeCenter";
  public static final long TWO_DAY = 172800000L;
  public static final int WHAT_CLICK_BANNER = 2;
  public static final int WHAT_CLOSE_BANNER = 1;
  private static final Comparator<GameNoticeInfo> a = new atwv();
  static HashSet<String> cmdMap = new HashSet();
  private final int arkTypeCare = 2;
  private final int arkTypeNormal = 0;
  private final int arkTypeTemptation = 1;
  private Runnable mCheckBanner = new GameNoticeCenter.2(this);
  private volatile AtomicBoolean mCheckBannerPosted = new AtomicBoolean(false);
  private GameNoticeInfo mCurrentBanner;
  private EntityManager mEntityManager;
  private MqqHandler mHandler;
  private volatile AtomicBoolean mInit = new AtomicBoolean(false);
  private long mLastRefreshTime;
  private final int typeDelete = 2;
  private final int typeInstall = 1;
  
  static
  {
    cmdMap.add("12855");
  }
  
  public GameNoticeCenter(AppInterface paramAppInterface)
  {
    this.mEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
    this.mHandler = new MqqHandler(Looper.getMainLooper(), this);
    paramAppInterface.setHandler(getClass(), this.mHandler);
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "GameNoticeCenter instance");
    }
    GameCenterReceiver.a();
    GameCenterReceiver.a(this);
    blec.a().a(this);
  }
  
  private GameNoticeInfo a(String paramString)
  {
    Iterator localIterator = iterator();
    GameNoticeInfo localGameNoticeInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localGameNoticeInfo = (GameNoticeInfo)localIterator.next();
    } while ((TextUtils.isEmpty(localGameNoticeInfo.appId)) || (!localGameNoticeInfo.appId.equals(paramString)));
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, "getByAppId appId=" + paramString + ",noticeInfo=" + localGameNoticeInfo);
      }
      return localGameNoticeInfo;
      localGameNoticeInfo = null;
    }
  }
  
  private void a()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "checkBanner now=" + l1 + ",mLastRefreshTime=" + this.mLastRefreshTime + ",size=" + size());
    }
    if (l1 - this.mLastRefreshTime < 60000L)
    {
      if (QLog.isColorLevel()) {
        QLog.w("GameNoticeCenter", 2, "checkBanner time limit!");
      }
      return;
    }
    this.mLastRefreshTime = l1;
    if (!this.mInit.getAndSet(true)) {
      b();
    }
    label113:
    GameNoticeInfo localGameNoticeInfo2;
    for (;;)
    {
      try
      {
        Iterator localIterator = iterator();
        if (!localIterator.hasNext()) {
          break label490;
        }
        localGameNoticeInfo2 = (GameNoticeInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 1, "checkBanner info=" + localGameNoticeInfo2);
        }
        if (localGameNoticeInfo2.isValid()) {
          break label206;
        }
        remove(localGameNoticeInfo2);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Throwable localThrowable) {}
      QLog.e("GameNoticeCenter", 2, "checkBanner exception!", localThrowable);
      return;
      label206:
      if (localGameNoticeInfo2.bannerType == 1)
      {
        long l2 = new File(localGameNoticeInfo2.filePath).lastModified();
        a(l2, l1, localGameNoticeInfo2);
        b(l2, l1, localGameNoticeInfo2);
      }
      if (l1 >= localGameNoticeInfo2.startTime) {
        break label293;
      }
      if (QLog.isColorLevel()) {
        QLog.w("GameNoticeCenter", 1, "checkBanner  is not time, info=" + localGameNoticeInfo2);
      }
    }
    label293:
    GameNoticeInfo localGameNoticeInfo1;
    if (localGameNoticeInfo2.bannerType == 1) {
      localGameNoticeInfo1 = localGameNoticeInfo2;
    }
    for (;;)
    {
      if (localGameNoticeInfo1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 2, "getting no banner to show");
        }
        hideBanner();
        return;
        if (localGameNoticeInfo2.bannerType != 2) {
          break label113;
        }
        if (a(localGameNoticeInfo2))
        {
          if (!QLog.isColorLevel()) {
            break label490;
          }
          QLog.d("GameNoticeCenter", 1, "request register info, break! ");
          localGameNoticeInfo1 = null;
          continue;
        }
        if (!TextUtils.isEmpty(localGameNoticeInfo2.title))
        {
          localGameNoticeInfo1 = localGameNoticeInfo2;
          if (!TextUtils.isEmpty(localGameNoticeInfo2.jumpUrl)) {
            continue;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 2, "title or jumpUrl is empty, break! ");
        }
        remove(localGameNoticeInfo2);
        break label113;
      }
      if (localGameNoticeInfo1.equals(this.mCurrentBanner))
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("GameNoticeCenter", 2, "mCurrentBanner not changed, mCurrentBanner=" + this.mCurrentBanner);
        return;
      }
      this.mCurrentBanner = ((GameNoticeInfo)localGameNoticeInfo1.clone());
      a(this.mCurrentBanner);
      return;
      label490:
      localGameNoticeInfo1 = null;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 1, "refreshBanner type=" + paramInt + ",appId=" + paramString);
    }
    for (;;)
    {
      try
      {
        if ((this.mCurrentBanner != null) && (this.mCurrentBanner.appId.equals(paramString)))
        {
          int i = 0;
          if (paramInt != 1) {
            continue;
          }
          paramInt = i;
          if (this.mCurrentBanner.bannerType == 1) {
            paramInt = 1;
          }
          if (paramInt != 0)
          {
            remove(this.mCurrentBanner);
            hideBanner();
          }
        }
        return;
      }
      catch (Throwable paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("GameNoticeCenter", 1, "refreshBanner exception!", paramString);
      }
      paramInt = 1;
    }
  }
  
  private void a(long paramLong1, long paramLong2, GameNoticeInfo paramGameNoticeInfo)
  {
    long l = abet.a("KEY_RED_POINT_TIME_" + paramGameNoticeInfo.appId);
    if ((paramLong2 - l > 604800000L) || (l > paramLong2)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 1, "requestRedPointIfNeed lastReqRedDotTime=" + l + ",now=" + paramLong2 + ",fileLastModifiedTime=" + paramLong1 + ",bRequestRedDot=" + bool);
      }
      if (bool)
      {
        paramLong1 = paramLong2 - paramLong1;
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 1, "requestRedPointIfNeed lostTime=" + paramLong1 + ",compTime=" + 86400000L + " | " + 172800000L);
        }
        if ((paramLong1 > 86400000L) && (paramLong1 < 172800000L))
        {
          abet.a("KEY_RED_POINT_TIME_" + paramGameNoticeInfo.appId, paramLong2);
          if (!bfwv.a(BaseApplicationImpl.getApplication(), paramGameNoticeInfo.packageName)) {
            blec.a().a(9);
          }
        }
      }
      return;
    }
  }
  
  private void a(GameNoticeInfo paramGameNoticeInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "showBanner banner=" + paramGameNoticeInfo);
    }
    if (paramGameNoticeInfo == null) {}
    do
    {
      return;
      localObject = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(localObject instanceof QQAppInterface));
    Object localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
    Message localMessage;
    Bundle localBundle;
    String str;
    if (localObject != null)
    {
      localMessage = ((MqqHandler)localObject).obtainMessage(1134071);
      localBundle = new Bundle();
      localBundle.putString("appid", paramGameNoticeInfo.appId);
      str = paramGameNoticeInfo.title;
      if (paramGameNoticeInfo.bannerType != 1) {
        break label469;
      }
      localObject = (bifp)bifq.a().a("comminfo");
      if (localObject != null) {
        localObject = ((bifp)localObject).a(paramGameNoticeInfo.downloadType);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      label393:
      label469:
      for (localObject = (String)localObject + str;; localObject = str)
      {
        localBundle.putString("tips", (String)localObject);
        if (!TextUtils.isEmpty(paramGameNoticeInfo.iconUrl)) {
          localBundle.putString("iconURL", paramGameNoticeInfo.iconUrl);
        }
        localMessage.obj = localBundle;
        localMessage.sendToTarget();
        for (;;)
        {
          if (paramGameNoticeInfo.bannerType != 1) {
            break label393;
          }
          localObject = new bled();
          ((bled)localObject).a("dc00087").b(paramGameNoticeInfo.appId).d("81706").c("205431").a(4, "8").a(35, paramGameNoticeInfo.apkChannel).a(10, paramGameNoticeInfo.getReportType());
          if (paramGameNoticeInfo.isGray)
          {
            ((bled)localObject).e(paramGameNoticeInfo.expeKey);
            blef.a().a("59", paramGameNoticeInfo.expeKey, "", "205431", "1000", "1000", "0", "0");
          }
          blec.a().a((bled)localObject);
          return;
          if (paramGameNoticeInfo.downloadType == 1)
          {
            localObject = bhpc.a().a().getString(2131694130);
            break;
          }
          if (paramGameNoticeInfo.downloadType != 3) {
            break label474;
          }
          localObject = bhpc.a().a().getString(2131694131);
          break;
          if (QLog.isColorLevel()) {
            QLog.w("GameNoticeCenter", 2, "showBanner Conversation handler is null");
          }
        }
        if (paramGameNoticeInfo.bannerType != 2) {
          break;
        }
        localObject = new bled();
        ((bled)localObject).a("dc00087").b(paramGameNoticeInfo.appId).d("81707").c("205433").a(4, "8").a(35, paramGameNoticeInfo.apkChannel).a(10, paramGameNoticeInfo.getReportType());
        blec.a().a((bled)localObject);
        return;
      }
      label474:
      localObject = null;
    }
  }
  
  private static void a(String paramString, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 1, "startActivityWithUrl url=" + paramString + ",context=" + paramContext);
    }
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(BaseApplication.getContext(), GameCenterActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.addFlags(268435456);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    paramContext.startActivity(localIntent);
  }
  
  private final boolean a(GameNoticeInfo paramGameNoticeInfo)
  {
    if (!paramGameNoticeInfo.infoRequested)
    {
      paramGameNoticeInfo.infoRequested = true;
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, "requestGameRegisterInfo appId=" + paramGameNoticeInfo.appId);
      }
      blec.a().b(paramGameNoticeInfo.appId);
      return true;
    }
    return false;
  }
  
  private boolean a(WadlResult paramWadlResult)
  {
    GameNoticeInfo localGameNoticeInfo = a(paramWadlResult.a.a);
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "processTaskInfo find info=" + localGameNoticeInfo + ",taskInfo=" + paramWadlResult);
    }
    int i;
    switch (paramWadlResult.b)
    {
    case 7: 
    case 8: 
    default: 
      i = 0;
    }
    while (i == 0) {
      if (localGameNoticeInfo != null)
      {
        remove(localGameNoticeInfo);
        return true;
        i = GameNoticeInfo.convertToBannerType(paramWadlResult);
      }
      else
      {
        return false;
      }
    }
    if ((localGameNoticeInfo != null) && ((localGameNoticeInfo.bannerType != i) || (localGameNoticeInfo.createTime != paramWadlResult.c)))
    {
      remove(localGameNoticeInfo);
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 1, new Object[] { "processTaskInfo: remove GameNoticeInfo: ", localGameNoticeInfo });
      }
      localGameNoticeInfo = null;
    }
    for (boolean bool = true;; bool = false)
    {
      if (localGameNoticeInfo == null)
      {
        paramWadlResult = new GameNoticeInfo(paramWadlResult, BaseApplication.getContext());
        if (paramWadlResult.isValid())
        {
          add(paramWadlResult);
          if (QLog.isColorLevel()) {
            QLog.d("GameNoticeCenter", 1, new Object[] { "processTaskInfo: add GameNoticeInfo: ", paramWadlResult });
          }
          if (i != 2) {
            break;
          }
          a(paramWadlResult);
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.e("GameNoticeCenter", 1, new Object[] { "processTaskInfo: invalid GameNoticeInfo: ", paramWadlResult });
        }
      }
      return bool;
    }
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)this.mEntityManager.query(GameNoticeInfo.class);
        if (localArrayList == null) {
          break label94;
        }
        localObject = localArrayList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        GameNoticeInfo localGameNoticeInfo = (GameNoticeInfo)((Iterator)localObject).next();
        if (!localGameNoticeInfo.isValid()) {
          ((Iterator)localObject).remove();
        } else {
          localGameNoticeInfo.setTipsInfo(BaseApplication.getContext());
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameNoticeCenter", 1, "loadGameNoticeInfos exception", localThrowable);
        return;
      }
    }
    addAll(localThrowable);
    c();
    label94:
    Object localObject = new StringBuilder().append("loadGameNoticeInfos size=");
    if (localThrowable != null) {}
    for (int i = localThrowable.size();; i = 0)
    {
      QLog.d("GameNoticeCenter", 1, i + ", cache size=" + size());
      return;
    }
  }
  
  private void b(long paramLong1, long paramLong2, GameNoticeInfo paramGameNoticeInfo)
  {
    long l = abet.a("REQUEST_ARK_TIME_" + paramGameNoticeInfo.appId);
    boolean bool;
    int i;
    if ((paramLong2 - l > 86400000L) || (l > paramLong2))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 1, "lastRequestArkTime=" + l + ",now=" + paramLong2 + ",fileLastModifiedTime=" + paramLong1 + ",bRequestArk=" + bool);
      }
      if (bool)
      {
        paramLong1 = paramLong2 - paramLong1;
        i = -1;
        if ((paramLong1 <= 300000L) || (paramLong1 > 10800000L)) {
          break label242;
        }
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 1, "requestPushArkIfNeed lostTime=" + paramLong1 + ",arkType=" + i);
      }
      if (i > -1)
      {
        blec.a().a(paramGameNoticeInfo.appId, i);
        abet.a("REQUEST_ARK_TIME_" + paramGameNoticeInfo.appId, paramLong2);
      }
      return;
      bool = false;
      break;
      label242:
      if ((paramLong1 > 10800000L) && (paramLong1 <= 86400000L)) {
        i = 1;
      } else if (paramLong1 > 86400000L) {
        i = 2;
      }
    }
  }
  
  private void c()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this);
      Collections.sort(localArrayList, a);
      clear();
      addAll(localArrayList);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GameNoticeCenter", 1, "sort exception", localThrowable);
    }
  }
  
  public static TipsBar createBanner(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "createBanner baseActivity=" + paramActivity);
    }
    TipsBar localTipsBar = new TipsBar(paramActivity);
    localTipsBar.setTipsIcon(paramActivity.getResources().getDrawable(2130838381));
    localTipsBar.setVisibility(8);
    localTipsBar.a(true);
    return localTipsBar;
  }
  
  public boolean add(GameNoticeInfo paramGameNoticeInfo)
  {
    boolean bool = super.add(paramGameNoticeInfo);
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "add ret=" + bool);
    }
    if (bool) {
      this.mEntityManager.persist(paramGameNoticeInfo);
    }
    return bool;
  }
  
  public void checkBannerFromResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "checkBannerFromResume mCheckBannerPosted=" + this.mCheckBannerPosted);
    }
    if (!this.mCheckBannerPosted.getAndSet(true)) {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label73;
      }
    }
    label73:
    for (int i = 1; i != 0; i = 0)
    {
      ThreadManagerV2.excute(this.mCheckBanner, 16, null, true);
      return;
    }
    this.mCheckBanner.run();
  }
  
  public HashSet<String> getFilterCmds()
  {
    return cmdMap;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 1, "handleMessage msg=" + paramMessage.what + ",appid=" + paramMessage.obj);
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      hideBanner();
      if ((paramMessage.obj instanceof String))
      {
        paramMessage = a((String)paramMessage.obj);
        if (paramMessage != null)
        {
          remove(paramMessage);
          Object localObject;
          if (paramMessage.bannerType == 1)
          {
            localObject = new bled();
            ((bled)localObject).a("dc00087").b(paramMessage.appId).d("81706").c("205435").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
            if (paramMessage.isGray) {
              ((bled)localObject).e(paramMessage.expeKey);
            }
            blec.a().a((bled)localObject);
          }
          else if (paramMessage.bannerType == 2)
          {
            localObject = new bled();
            ((bled)localObject).a("dc00087").b(paramMessage.appId).d("81707").c("205436").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
            blec.a().a((bled)localObject);
            continue;
            hideBanner();
            if ((paramMessage.obj instanceof String))
            {
              localObject = (String)paramMessage.obj;
              paramMessage = a((String)localObject);
              if (paramMessage != null)
              {
                remove(paramMessage);
                if (paramMessage.bannerType == 1)
                {
                  if (paramMessage.isGray)
                  {
                    blef.a().a("59", paramMessage.expeKey, "", "205432", "1000", "1000", "0", "0");
                    localObject = new WadlParams((String)localObject, paramMessage.packageName);
                    ((WadlParams)localObject).p = "biz_src_zf_games";
                    ((WadlParams)localObject).c(1);
                    atzb.a((WadlParams)localObject);
                  }
                  for (;;)
                  {
                    localObject = new bled();
                    ((bled)localObject).a("dc00087").b(paramMessage.appId).d("81706").c("205432").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
                    if (paramMessage.isGray) {
                      ((bled)localObject).e(paramMessage.expeKey);
                    }
                    blec.a().a((bled)localObject);
                    break;
                    a(paramMessage.jumpUrl, BaseApplication.getContext());
                  }
                }
                if (paramMessage.bannerType == 2)
                {
                  localObject = new bled();
                  ((bled)localObject).a("dc00087").b(paramMessage.appId).d("81707").c("205434").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
                  blec.a().a((bled)localObject);
                  a(paramMessage.jumpUrl, BaseApplication.getContext());
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected void hideBanner()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "hideBanner mCurrentBanner=" + this.mCurrentBanner);
    }
    if (this.mCurrentBanner != null)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
        if (localObject == null) {
          break label87;
        }
        ((MqqHandler)localObject).obtainMessage(1134072).sendToTarget();
      }
    }
    for (;;)
    {
      this.mCurrentBanner = null;
      return;
      label87:
      if (QLog.isColorLevel()) {
        QLog.w("GameNoticeCenter", 2, "hideBanner Conversation handler is null");
      }
    }
  }
  
  public void onCmdRsp(Intent paramIntent, String paramString, long paramLong, JSONObject paramJSONObject)
  {
    int i = 1;
    if (("12855".equals(paramString)) && (paramLong == 0L))
    {
      paramIntent = paramJSONObject.optString("game_appid");
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, "parseGameRegisterInfo dataJson=" + paramJSONObject.toString());
      }
      paramString = a(paramIntent);
      if (paramString == null) {
        break label177;
      }
      if (paramJSONObject.optInt("registered", 0) != 1) {
        break label134;
      }
      if (i == 0) {
        break label140;
      }
      remove(paramString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, "parseGameRegisterInfo info=" + paramString);
      }
      a();
      return;
      label134:
      i = 0;
      break;
      label140:
      paramLong = paramJSONObject.optLong("bar_delay");
      long l = paramJSONObject.optLong("bar_interval");
      abet.a("MILLISECONDS_DELAY", paramLong);
      abet.a("MILLISECONDS_INTERVAL", l);
    }
    label177:
    QLog.e("GameNoticeCenter", 1, new Object[] { "parseGameRegisterInfo, GameNoticeInfo for ", paramIntent, " not found!" });
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 1, "onDestroy");
    }
    if (this.mCurrentBanner != null) {
      remove(this.mCurrentBanner);
    }
    GameCenterReceiver.b(this);
    blec.a().b(this);
    hideBanner();
    this.mInit.set(false);
  }
  
  public void onTaskComplete(WadlResult paramWadlResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 1, "onTaskComplete wadlResult=" + paramWadlResult);
    }
    if (a(paramWadlResult)) {
      c();
    }
  }
  
  public void onTaskDeleted(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 1, "onTaskDeleted appId=" + paramString1);
    }
    a(2, paramString1);
  }
  
  public void onTaskInstall(WadlResult paramWadlResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 1, "onTaskInstall wadlResult=" + paramWadlResult);
    }
    if (a(paramWadlResult)) {
      c();
    }
  }
  
  public GameNoticeInfo remove(int paramInt)
  {
    GameNoticeInfo localGameNoticeInfo = (GameNoticeInfo)super.remove(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "remove index=" + paramInt + ",info=" + localGameNoticeInfo);
    }
    if (localGameNoticeInfo != null) {
      this.mEntityManager.remove(localGameNoticeInfo);
    }
    return localGameNoticeInfo;
  }
  
  public boolean remove(Object paramObject)
  {
    boolean bool = super.remove(paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "remove ret=" + bool);
    }
    if ((bool) && ((paramObject instanceof Entity))) {
      this.mEntityManager.remove((Entity)paramObject);
    }
    return bool;
  }
  
  public void updateGameCenterBar(View paramView, Message paramMessage)
  {
    if (!(paramView instanceof TipsBar)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = (TipsBar)paramView;
            if (paramMessage != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("GameNoticeCenter", 2, "updateGameCenterBar msg is null");
          return;
          if ((paramMessage.what == 1134071) || (paramMessage.what == 1134072)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("GameNoticeCenter", 2, "updateGameCenterBar msg.what=" + paramMessage.what);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 2, "updateGameCenterBar msg.what=" + paramMessage.what + ",msg.obj = " + paramMessage.obj);
        }
        if (paramMessage.what == 1134050)
        {
          paramView.setVisibility(8);
          return;
        }
        paramView.setTipsIcon(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838381));
        paramView.setTipsText("");
        paramView.setVisibility(0);
      } while (!(paramMessage.obj instanceof Bundle));
      localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("appid");
      String str = ((Bundle)localObject).getString("tips");
      localObject = ((Bundle)localObject).getString("iconURL");
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, "updateGameCenterBar  appid=" + paramMessage + ",tips= " + str + ",iconURL= " + (String)localObject);
      }
      paramView.setOnClickListener(new atww(this, paramMessage));
      paramView.setCloseListener(new atwx(this, paramMessage));
      if (!TextUtils.isEmpty(str)) {
        paramView.setTipsText(str);
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    bhvs.a().a((String)localObject, new atwy(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeCenter
 * JD-Core Version:    0.7.0.1
 */