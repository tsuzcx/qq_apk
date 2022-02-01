package com.tencent.mobileqq.gamecenter.data;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.WadlCommConfig;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.GameCenterListener;
import com.tencent.gamecenter.wadl.biz.listener.WadlCmdListener;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.agent.datamodel.ImageLoader;
import com.tencent.qphone.base.util.QLog;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class GameNoticeCenter
  extends CopyOnWriteArrayList<GameNoticeInfo>
  implements Handler.Callback, GameCenterListener, WadlCmdListener
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
  private static final Comparator<GameNoticeInfo> a = new GameNoticeCenter.1();
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
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).addListener(this);
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
    for (;;)
    {
      GameNoticeInfo localGameNoticeInfo;
      try
      {
        ArrayList localArrayList = (ArrayList)this.mEntityManager.query(GameNoticeInfo.class);
        if (localArrayList == null) {
          break label98;
        }
        localObject = localArrayList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localGameNoticeInfo = (GameNoticeInfo)((Iterator)localObject).next();
        if (!localGameNoticeInfo.isValid())
        {
          ((Iterator)localObject).remove();
          continue;
        }
        MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameNoticeCenter", 1, "loadGameNoticeInfos exception", localThrowable);
        return;
      }
      localGameNoticeInfo.setTipsInfo(MobileQQ.getContext());
    }
    addAll(localThrowable);
    b();
    label98:
    Object localObject = new StringBuilder().append("loadGameNoticeInfos size=");
    if (localThrowable != null) {}
    for (int i = localThrowable.size();; i = 0)
    {
      QLog.d("GameNoticeCenter", 1, i + ", cache size=" + size());
      return;
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
    long l = GameCenterSpUtils.a("KEY_RED_POINT_TIME_" + paramGameNoticeInfo.appId);
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
          GameCenterSpUtils.a("KEY_RED_POINT_TIME_" + paramGameNoticeInfo.appId, paramLong2);
          if (!PackageUtil.a(MobileQQ.sMobileQQ, paramGameNoticeInfo.packageName)) {
            ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestRedPoint(9);
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
        break label479;
      }
      localObject = (WadlCommConfig)((IQQGameConfigService)QRoute.api(IQQGameConfigService.class)).getConfig("comminfo");
      if (localObject != null) {
        localObject = ((WadlCommConfig)localObject).a(paramGameNoticeInfo.downloadType);
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      label406:
      label479:
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
            break label406;
          }
          localObject = new WadlReportBuilder();
          ((WadlReportBuilder)localObject).a("dc00087").b(paramGameNoticeInfo.appId).g("81706").c("205431").a(4, "8").a(35, paramGameNoticeInfo.apkChannel).a(10, paramGameNoticeInfo.getReportType());
          if (paramGameNoticeInfo.isGray)
          {
            ((WadlReportBuilder)localObject).h(paramGameNoticeInfo.expeKey);
            ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).reportTianJi("59", paramGameNoticeInfo.expeKey, "", "205431", "1000", "1000", "0", "0");
          }
          ((WadlReportBuilder)localObject).a();
          return;
          if (paramGameNoticeInfo.downloadType == 1)
          {
            localObject = CommonDataAdapter.a().a().getString(2131694532);
            break;
          }
          if (paramGameNoticeInfo.downloadType != 3) {
            break label484;
          }
          localObject = CommonDataAdapter.a().a().getString(2131694533);
          break;
          if (QLog.isColorLevel()) {
            QLog.w("GameNoticeCenter", 2, "showBanner Conversation handler is null");
          }
        }
        if (paramGameNoticeInfo.bannerType != 2) {
          break;
        }
        localObject = new WadlReportBuilder();
        ((WadlReportBuilder)localObject).a("dc00087").b(paramGameNoticeInfo.appId).g("81707").c("205433").a(4, "8").a(35, paramGameNoticeInfo.apkChannel).a(10, paramGameNoticeInfo.getReportType());
        ((WadlReportBuilder)localObject).a();
        return;
      }
      label484:
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
    Object localObject = MobileQQ.sMobileQQ;
    localObject = new Intent(MobileQQ.getContext(), GameCenterActivity.class);
    ((Intent)localObject).putExtra("url", paramString);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zf_games");
    paramContext.startActivity((Intent)localObject);
  }
  
  private void a(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "checkBanner checkFreq = " + paramBoolean + ",now=" + l1 + ",mLastRefreshTime=" + this.mLastRefreshTime + ",size=" + size());
    }
    if (!this.mInit.getAndSet(true)) {
      a();
    }
    if ((paramBoolean) && (l1 - this.mLastRefreshTime < 60000L))
    {
      if (QLog.isColorLevel()) {
        QLog.w("GameNoticeCenter", 2, "checkBanner time limit!");
      }
      if ((this.mCurrentBanner != null) && (!this.mCurrentBanner.isValid()))
      {
        hideBanner();
        remove(this.mCurrentBanner);
      }
      return;
    }
    this.mLastRefreshTime = l1;
    label161:
    GameNoticeInfo localGameNoticeInfo2;
    for (;;)
    {
      try
      {
        Iterator localIterator = iterator();
        if (!localIterator.hasNext()) {
          break label541;
        }
        localGameNoticeInfo2 = (GameNoticeInfo)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("GameNoticeCenter", 1, "checkBanner info=" + localGameNoticeInfo2);
        }
        if (localGameNoticeInfo2.isValid()) {
          break label254;
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
      label254:
      if (localGameNoticeInfo2.bannerType == 1)
      {
        long l2 = new File(localGameNoticeInfo2.filePath).lastModified();
        a(l2, l1, localGameNoticeInfo2);
        b(l2, l1, localGameNoticeInfo2);
      }
      if (l1 >= localGameNoticeInfo2.startTime) {
        break label344;
      }
      if (QLog.isColorLevel()) {
        QLog.w("GameNoticeCenter", 1, "checkBanner  is not time, info=" + localGameNoticeInfo2);
      }
    }
    label344:
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
          break label161;
        }
        if (a(localGameNoticeInfo2))
        {
          if (!QLog.isColorLevel()) {
            break label541;
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
        break label161;
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
      label541:
      localGameNoticeInfo1 = null;
    }
  }
  
  private boolean a(WadlResult paramWadlResult)
  {
    Object localObject = a(paramWadlResult.a.a);
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 2, "processTaskInfo find info=" + localObject + ",taskInfo=" + paramWadlResult);
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
      if (localObject != null)
      {
        remove(localObject);
        return true;
        i = GameNoticeInfo.convertToBannerType(paramWadlResult);
      }
      else
      {
        return false;
      }
    }
    if ((localObject != null) && ((((GameNoticeInfo)localObject).bannerType != i) || (((GameNoticeInfo)localObject).createTime != paramWadlResult.c)))
    {
      remove(localObject);
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 1, new Object[] { "processTaskInfo: remove GameNoticeInfo: ", localObject });
      }
      localObject = null;
    }
    for (boolean bool = true;; bool = false)
    {
      if (localObject == null)
      {
        localObject = MobileQQ.sMobileQQ;
        paramWadlResult = new GameNoticeInfo(paramWadlResult, MobileQQ.getContext());
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
  
  private final boolean a(GameNoticeInfo paramGameNoticeInfo)
  {
    if (!paramGameNoticeInfo.infoRequested)
    {
      paramGameNoticeInfo.infoRequested = true;
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, "requestGameRegisterInfo appId=" + paramGameNoticeInfo.appId);
      }
      ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).getGameRegisterInfo(paramGameNoticeInfo.appId);
      return true;
    }
    return false;
  }
  
  private void b()
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
  
  private void b(long paramLong1, long paramLong2, GameNoticeInfo paramGameNoticeInfo)
  {
    long l = GameCenterSpUtils.a("REQUEST_ARK_TIME_" + paramGameNoticeInfo.appId);
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
        if ((paramLong1 <= 300000L) || (paramLong1 > 10800000L)) {
          break label246;
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
        ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).requestArk(paramGameNoticeInfo.appId, i);
        GameCenterSpUtils.a("REQUEST_ARK_TIME_" + paramGameNoticeInfo.appId, paramLong2);
      }
      return;
      bool = false;
      break;
      label246:
      if ((paramLong1 > 10800000L) && (paramLong1 <= 86400000L)) {
        i = 1;
      } else if (paramLong1 > 86400000L) {
        i = 2;
      } else {
        i = -1;
      }
    }
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
    int i;
    if (!this.mCheckBannerPosted.getAndSet(true))
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        break label80;
      }
      i = 1;
      if (i == 0) {
        break label85;
      }
      ThreadManagerV2.excute(this.mCheckBanner, 16, null, true);
    }
    for (;;)
    {
      QQGameHelper.b = true;
      QQGameHelper.d();
      return;
      label80:
      i = 0;
      break;
      label85:
      this.mCheckBanner.run();
    }
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
            localObject = new WadlReportBuilder();
            ((WadlReportBuilder)localObject).a("dc00087").b(paramMessage.appId).g("81706").c("205435").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
            if (paramMessage.isGray) {
              ((WadlReportBuilder)localObject).h(paramMessage.expeKey);
            }
            ((WadlReportBuilder)localObject).a();
          }
          else if (paramMessage.bannerType == 2)
          {
            localObject = new WadlReportBuilder();
            ((WadlReportBuilder)localObject).a("dc00087").b(paramMessage.appId).g("81707").c("205436").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
            ((WadlReportBuilder)localObject).a();
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
                    ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).reportTianJi("59", paramMessage.expeKey, "", "205432", "1000", "1000", "0", "0");
                    localObject = new WadlParams((String)localObject, paramMessage.packageName);
                    ((WadlParams)localObject).p = "biz_src_zf_games";
                    ((WadlParams)localObject).c(1);
                    WadlProxyServiceUtil.a().c((WadlParams)localObject);
                  }
                  for (;;)
                  {
                    localObject = new WadlReportBuilder();
                    ((WadlReportBuilder)localObject).a("dc00087").b(paramMessage.appId).g("81706").c("205432").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
                    if (paramMessage.isGray) {
                      ((WadlReportBuilder)localObject).h(paramMessage.expeKey);
                    }
                    ((WadlReportBuilder)localObject).a();
                    break;
                    localObject = paramMessage.jumpUrl;
                    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
                    a((String)localObject, MobileQQ.getContext());
                  }
                }
                if (paramMessage.bannerType == 2)
                {
                  localObject = new WadlReportBuilder();
                  ((WadlReportBuilder)localObject).a("dc00087").b(paramMessage.appId).g("81707").c("205434").a(4, "20").a(35, paramMessage.apkChannel).a(10, paramMessage.getReportType());
                  ((WadlReportBuilder)localObject).a();
                  paramMessage = paramMessage.jumpUrl;
                  localObject = MobileQQ.sMobileQQ;
                  a(paramMessage, MobileQQ.getContext());
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
        break label178;
      }
      if (paramJSONObject.optInt("registered", 0) != 1) {
        break label135;
      }
      if (i == 0) {
        break label141;
      }
      remove(paramString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameNoticeCenter", 2, "parseGameRegisterInfo info=" + paramString);
      }
      a(false);
      return;
      label135:
      i = 0;
      break;
      label141:
      paramLong = paramJSONObject.optLong("bar_delay");
      long l = paramJSONObject.optLong("bar_interval");
      GameCenterSpUtils.a("MILLISECONDS_DELAY", paramLong);
      GameCenterSpUtils.a("MILLISECONDS_INTERVAL", l);
    }
    label178:
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
    ((IQQGameNetService)QRoute.api(IQQGameNetService.class)).removeListener(this);
    hideBanner();
    this.mInit.set(false);
  }
  
  public void onTaskComplete(WadlResult paramWadlResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameNoticeCenter", 1, "onTaskComplete wadlResult=" + paramWadlResult);
    }
    if (a(paramWadlResult)) {
      b();
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
      b();
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
        paramView.setTipsIcon(MobileQQ.sMobileQQ.getResources().getDrawable(2130838463));
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
      paramView.setOnClickListener(new GameNoticeCenter.3(this, paramMessage));
      paramView.setCloseListener(new GameNoticeCenter.4(this, paramMessage));
      if (!TextUtils.isEmpty(str)) {
        paramView.setTipsText(str);
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    ImageLoader.a().a((String)localObject, new GameNoticeCenter.5(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeCenter
 * JD-Core Version:    0.7.0.1
 */