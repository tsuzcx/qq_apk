package com.tencent.mobileqq.gamecenter.data;

import acii;
import acik;
import acit;
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
import avjt;
import avju;
import avjv;
import avjw;
import avmc;
import bhny;
import bjqd;
import bnyy;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.gamecenter.appointment.GameCenterReceiver;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class GameNoticeCenter
  extends CopyOnWriteArrayList<GameNoticeInfo>
  implements acii, Handler.Callback
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
  private static final Comparator<GameNoticeInfo> a = new avjt();
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
  
  public GameNoticeCenter(QQAppInterface paramQQAppInterface)
  {
    GameCenterReceiver.a();
    GameCenterReceiver.a(this);
    this.mEntityManager = paramQQAppInterface.a().createEntityManager();
    this.mHandler = new MqqHandler(Looper.getMainLooper(), this);
    paramQQAppInterface.setHandler(getClass(), this.mHandler);
  }
  
  private acit a()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      localObject = new acit((AppInterface)localObject);
      ((acit)localObject).f("4").g("430").a("817");
      return localObject;
    }
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
    label114:
    GameNoticeInfo localGameNoticeInfo2;
    for (;;)
    {
      try
      {
        Iterator localIterator = iterator();
        if (!localIterator.hasNext()) {
          break label491;
        }
        localGameNoticeInfo2 = (GameNoticeInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 1, "checkBanner info=" + localGameNoticeInfo2);
        }
        if (localGameNoticeInfo2.isValid()) {
          break label207;
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
      label207:
      if (localGameNoticeInfo2.bannerType == 1)
      {
        long l2 = new File(localGameNoticeInfo2.filePath).lastModified();
        a(l2, l1, localGameNoticeInfo2);
        b(l2, l1, localGameNoticeInfo2);
      }
      if (l1 >= localGameNoticeInfo2.startTime) {
        break label294;
      }
      if (QLog.isColorLevel()) {
        QLog.w("GameNoticeCenter", 1, "checkBanner  is not time, info=" + localGameNoticeInfo2);
      }
    }
    label294:
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
          break label114;
        }
        if (a(localGameNoticeInfo2))
        {
          if (!QLog.isColorLevel()) {
            break label491;
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
        break label114;
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
      label491:
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
    long l = acik.a("KEY_RED_POINT_TIME_" + paramGameNoticeInfo.appId);
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
          acik.a("KEY_RED_POINT_TIME_" + paramGameNoticeInfo.appId, paramLong2);
          if (!bhny.a(BaseApplicationImpl.getApplication(), paramGameNoticeInfo.packageName)) {
            bnyy.a().a(9);
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
      do
      {
        return;
        localObject = BaseApplicationImpl.getApplication().getRuntime();
      } while (!(localObject instanceof QQAppInterface));
      Object localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (localObject != null)
      {
        localObject = ((MqqHandler)localObject).obtainMessage(1134071);
        Bundle localBundle = new Bundle();
        localBundle.putString("appid", paramGameNoticeInfo.appId);
        localBundle.putString("tips", paramGameNoticeInfo.title);
        if (!TextUtils.isEmpty(paramGameNoticeInfo.iconUrl)) {
          localBundle.putString("iconURL", paramGameNoticeInfo.iconUrl);
        }
        ((Message)localObject).obj = localBundle;
        ((Message)localObject).sendToTarget();
      }
      if (paramGameNoticeInfo.bannerType == 1)
      {
        a().e("81706").b("205431").d("8").c(paramGameNoticeInfo.appId).h(paramGameNoticeInfo.apkChannel).a();
        return;
      }
    } while (paramGameNoticeInfo.bannerType != 2);
    a().e("81707").b("205433").d("8").c(paramGameNoticeInfo.appId).h(paramGameNoticeInfo.apkChannel).a();
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
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        ((VasExtensionHandler)((QQAppInterface)localAppRuntime).a(71)).g(paramGameNoticeInfo.appId);
      }
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
    long l = acik.a("REQUEST_ARK_TIME_" + paramGameNoticeInfo.appId);
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
        bnyy.a().a(paramGameNoticeInfo.appId, i);
        acik.a("REQUEST_ARK_TIME_" + paramGameNoticeInfo.appId, paramLong2);
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
    localTipsBar.setTipsIcon(paramActivity.getResources().getDrawable(2130838356));
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
          if (paramMessage.bannerType == 1)
          {
            a().e("81706").b("205435").d("20").c(paramMessage.appId).h(paramMessage.apkChannel).a();
          }
          else if (paramMessage.bannerType == 2)
          {
            a().e("81707").b("205436").d("20").c(paramMessage.appId).h(paramMessage.apkChannel).a();
            continue;
            hideBanner();
            if ((paramMessage.obj instanceof String))
            {
              Object localObject = (String)paramMessage.obj;
              paramMessage = a((String)localObject);
              if (paramMessage != null)
              {
                remove(paramMessage);
                if (paramMessage.bannerType == 1)
                {
                  if (paramMessage.isGray)
                  {
                    localObject = new WadlParams((String)localObject, paramMessage.packageName);
                    ((WadlParams)localObject).p = "biz_src_zf_games";
                    ((WadlParams)localObject).c(1);
                    avmc.a((WadlParams)localObject);
                  }
                  for (;;)
                  {
                    a().e("81706").b("205432").d("20").c(paramMessage.appId).h(paramMessage.apkChannel).a();
                    break;
                    a(paramMessage.jumpUrl, BaseApplication.getContext());
                  }
                }
                if (paramMessage.bannerType == 2)
                {
                  a().e("81707").b("205434").d("20").c(paramMessage.appId).h(paramMessage.apkChannel).a();
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
        if (localObject != null) {
          ((MqqHandler)localObject).obtainMessage(1134072).sendToTarget();
        }
      }
      this.mCurrentBanner = null;
    }
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
  
  public void parseGameRegisterInfo(JSONObject paramJSONObject)
  {
    int i = 1;
    String str = paramJSONObject.optString("game_appid");
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "parseGameRegisterInfo rspJson=" + paramJSONObject.toString());
    }
    GameNoticeInfo localGameNoticeInfo = a(str);
    if (localGameNoticeInfo != null)
    {
      if (paramJSONObject.optInt("registered", 0) == 1)
      {
        if (i == 0) {
          break label125;
        }
        remove(localGameNoticeInfo);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 2, "parseGameRegisterInfo info=" + localGameNoticeInfo);
        }
        a();
        return;
        i = 0;
        break;
        label125:
        long l1 = paramJSONObject.optLong("bar_delay");
        long l2 = paramJSONObject.optLong("bar_interval");
        acik.a("MILLISECONDS_DELAY", l1);
        acik.a("MILLISECONDS_INTERVAL", l2);
      }
    }
    QLog.e("GameNoticeCenter", 1, new Object[] { "parseGameRegisterInfo, GameNoticeInfo for ", str, " not found!" });
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
        paramView.setTipsIcon(BaseApplicationImpl.getApplication().getResources().getDrawable(2130838356));
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
      paramView.setOnClickListener(new avju(this, paramMessage));
      paramView.setCloseListener(new avjv(this, paramMessage));
      if (!TextUtils.isEmpty(str)) {
        paramView.setTipsText(str);
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    bjqd.a().a((String)localObject, new avjw(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeCenter
 * JD-Core Version:    0.7.0.1
 */