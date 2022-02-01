package com.tencent.mobileqq.servlet;

import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.feed_info;
import NS_UNDEAL_COUNT.single_count;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.report.QzoneLbsReporter;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.os.MqqHandler;

public class QZoneNotifyServlet
  extends MSFServlet
  implements WebEventListener
{
  public static long c = 0L;
  public static long d = 0L;
  public static boolean e = false;
  private static long f;
  private static SosoInterfaceOnLocationListener h;
  private static LbsManagerServiceOnLocationChangeListener i;
  private static LbsDataV2.GpsInfo j;
  private static long k;
  private static long l = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
  public long a = 180000L;
  public long b = 5000L;
  private MqqHandler g;
  private Runnable m = new QZoneNotifyServlet.5(this);
  
  public static LbsDataV2.GpsInfo a(String paramString)
  {
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(paramString);
    boolean bool;
    if (localSosoLbsInfo != null) {
      bool = true;
    } else {
      bool = false;
    }
    QzoneLbsReporter.reportLocationCacheResult(bool, paramString);
    QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getGpsInfo");
    if (localSosoLbsInfo != null) {
      return LbsDataV2.convertFromSoso(localSosoLbsInfo.mLocation);
    }
    return null;
  }
  
  private static void b(int paramInt)
  {
    if (paramInt == 2)
    {
      l *= 10L;
      return;
    }
    if (paramInt == 0)
    {
      l = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
      return;
    }
    l *= 2L;
  }
  
  public static void b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - f < l)
    {
      paramString = new StringBuilder();
      paramString.append("[QZ_LBS_MODULE] mIsGettingLocation = , (now - mLastGetLocationTime) ) = ");
      paramString.append((l1 - f) / 1000L);
      paramString.append(", so return");
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", paramString.toString());
      return;
    }
    f = l1;
    if (i != null) {
      QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new QZoneNotifyServlet.4());
    }
  }
  
  private static void c(String paramString)
  {
    if ((e) && (i == null))
    {
      i = new QZoneNotifyServlet.2(paramString, false);
      try
      {
        k = System.currentTimeMillis();
        if ((Build.VERSION.SDK_INT >= 23) && (BaseApplication.getContext() != null) && (BaseApplication.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
        {
          QZLog.w("QZLog", "[QZ_LBS_MODULE]定位有版本或权限限制");
          return;
        }
        ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(i);
        return;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[QZ_LBS_MODULE]onCreate startLocation exception ");
        localStringBuilder.append(paramString);
        QLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, localStringBuilder.toString());
      }
    }
  }
  
  private void e()
  {
    f().removeCallbacks(this.m);
    f().postDelayed(this.m, this.a);
  }
  
  private MqqHandler f()
  {
    if (this.g == null) {
      try
      {
        if (this.g == null)
        {
          HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("QZONE_UNDEALCOUNT", 0);
          localHandlerThread.start();
          this.g = new MqqHandler(localHandlerThread.getLooper());
        }
      }
      finally {}
    }
    return this.g;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    RemoteHandleManager.getInstance().addWebEventListener(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (h != null) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(h);
    }
    h = null;
    if (i != null) {
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).removeListener(i);
    }
    i = null;
    RemoteHandleManager.getInstance().removeWebEventListener(this);
    if (this.g != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QZoneNotifyServlet onDestroy");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 4, localStringBuilder.toString());
      }
      this.g.removeCallbacks(this.m);
      this.g.getLooper().quit();
    }
    this.g = null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = getAppRuntime();
    if (localObject == null) {
      return;
    }
    if (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    d = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive onReceive: ");
      localStringBuilder.append(d);
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, localStringBuilder.toString());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      QZoneUnreadServletLogic.a(paramIntent, paramFromServiceMsg, (QQAppInterface)localObject, this);
      return;
    }
    QZoneUnreadServletLogic.a((QQAppInterface)localObject, paramIntent, paramFromServiceMsg, this);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    boolean bool = QLog.isColorLevel();
    Object localObject1 = "Q.lebatab.UndealCount.QZoneNotifyServlet";
    if (bool) {
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend.begin.");
    }
    if (paramIntent == null) {
      return;
    }
    if ("Qzone_Get_NewAndUnread_Count".equals(paramIntent.getAction()))
    {
      Object localObject2 = getAppRuntime();
      if (localObject2 == null) {
        return;
      }
      if (!(localObject2 instanceof QQAppInterface)) {
        return;
      }
      localObject2 = (QQAppInterface)localObject2;
      if (!((QQAppInterface)localObject2).isBackgroundPause) {
        c("qzone_little_video_enter");
      }
      int i2 = paramIntent.getIntExtra("scene", 102);
      int i3 = paramIntent.getIntExtra("qzone_send_by_time", 4);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("QzoneNotifyServlet onSend byTimeType:");
        paramIntent.append(i3);
        paramIntent.append(",isBackground_Pause:");
        paramIntent.append(((QQAppInterface)localObject2).isBackgroundPause);
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, paramIntent.toString());
      }
      long l1;
      if (i3 == 2)
      {
        l1 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("GETFEEDUNREADTYPE_SWITCHTOFORGROUND nowtime: ");
          paramIntent.append(l1);
          paramIntent.append(",lastGetFeedTime:");
          paramIntent.append(c);
          paramIntent.append(",lastGetFeedTime:");
          paramIntent.append(c);
          paramIntent.append("difference: ");
          paramIntent.append(l1 - c);
          QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, paramIntent.toString());
        }
        if (l1 - c < this.b)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend.interval time is not enough,schedule task.byTimeType:2");
          }
          e();
          return;
        }
        n = 2;
      }
      else
      {
        n = 3;
      }
      paramIntent = "qzone_lastgetfeedtime";
      long l2;
      if (((i3 == 1) || (i3 == 4) || (i3 == 5) || (i3 == 6) || (i3 == 7) || (i3 == 8)) && (((QQAppInterface)localObject2).isBackgroundPause))
      {
        l2 = c;
        l1 = l2;
        if (l2 == 0L) {
          l1 = LocalMultiProcConfig.getLong("qzone_lastgetfeedtime", 0L);
        }
        if (System.currentTimeMillis() - l1 < QzoneConfig.getInstance().getConfig("QZoneSetting", "qzone_lastgetfeedtime", 43200000))
        {
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("onSend app.isBackground_Pause: ");
            paramIntent.append(((QQAppInterface)localObject2).isBackgroundPause);
            paramIntent.append(" not send request,schedule task");
            QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, paramIntent.toString());
          }
          e();
          return;
        }
      }
      if (i3 == 3) {
        n = 4;
      }
      if (i3 == 1) {
        n = 1;
      }
      if (i3 == 4) {
        n = 3;
      }
      if (i3 == 2) {
        n = 2;
      }
      if (i3 == 5) {
        n = 5;
      }
      if (i3 == 6) {
        n = 6;
      }
      if (i3 == 7) {
        n = 7;
      }
      int i1 = 8;
      if (i3 != 8) {
        i1 = n;
      }
      int n = ((QQAppInterface)localObject2).getApp().getResources().getDisplayMetrics().widthPixels;
      i3 = ((QQAppInterface)localObject2).getApp().getResources().getDisplayMetrics().heightPixels;
      ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
      ConcurrentHashMap localConcurrentHashMap2 = new ConcurrentHashMap();
      Object localObject5 = (QZoneManagerImp)((QQAppInterface)localObject2).getManager(QQManagerFactory.QZONE_MANAGER);
      if (localObject5 != null)
      {
        Object localObject3 = ((QZoneManagerImp)localObject5).a;
        if (localObject3 != null)
        {
          localObject3 = QZoneUnreadServletLogic.a((Map)localObject3);
          i4 = ((List)localObject3).size();
          i5 = 0;
          Object localObject6;
          while (i5 < i4)
          {
            i6 = ((Integer)((List)localObject3).get(i5)).intValue();
            localQZoneCountInfo = (QZoneCountInfo)((QZoneManagerImp)localObject5).a.get(Integer.valueOf(i6));
            if (localQZoneCountInfo != null)
            {
              localObject6 = new single_count(localQZoneCountInfo.uCount, (byte)localQZoneCountInfo.iControl);
              ArrayList localArrayList = new ArrayList();
              if ((localQZoneCountInfo.friendList != null) && (localQZoneCountInfo.friendList.size() > 0)) {
                localObject4 = new feed_host_info(((QZoneCountUserInfo)localQZoneCountInfo.friendList.get(0)).uin, "", localQZoneCountInfo.friendMsg, null, null, null);
              } else {
                localObject4 = new feed_host_info(0L, "", localQZoneCountInfo.friendMsg, null, null, null);
              }
              localArrayList.add(localObject4);
              localObject4 = localQZoneCountInfo.trace_info;
              i7 = localQZoneCountInfo.countId;
              String str1 = localQZoneCountInfo.iconUrl;
              String str2 = localQZoneCountInfo.strShowMsg;
              String str3 = localQZoneCountInfo.reportValue;
              localConcurrentHashMap1.put(Integer.valueOf(i6), new count_info((single_count)localObject6, localArrayList, (String)localObject4, i7, str1, str2, str3, localQZoneCountInfo.cTime, localQZoneCountInfo.iShowLevel, localQZoneCountInfo.actPageAttach));
            }
            i5 += 1;
          }
          i4 = n;
          int i6 = i2;
          localObject3 = paramIntent;
          QZoneCountInfo localQZoneCountInfo = (QZoneCountInfo)((QZoneManagerImp)localObject5).a.get(Integer.valueOf(56));
          localObject4 = localObject3;
          paramIntent = (Intent)localObject1;
          i7 = i3;
          i5 = i6;
          localObject5 = localObject2;
          i2 = i4;
          n = i1;
          if (localQZoneCountInfo == null) {
            break label1278;
          }
          paramIntent = new single_count(localQZoneCountInfo.uCount, (byte)localQZoneCountInfo.iControl);
          localObject4 = new ArrayList();
          if ((localQZoneCountInfo.friendList != null) && (localQZoneCountInfo.friendList.size() > 0))
          {
            localObject5 = localQZoneCountInfo.friendList.iterator();
            l1 = 0L;
            for (;;)
            {
              l2 = l1;
              if (!((Iterator)localObject5).hasNext()) {
                break;
              }
              localObject6 = (QZoneCountUserInfo)((Iterator)localObject5).next();
              if (localObject6 != null)
              {
                ((ArrayList)localObject4).add(new feed_host_info(((QZoneCountUserInfo)localObject6).uin, ((QZoneCountUserInfo)localObject6).nickName, null, ((QZoneCountUserInfo)localObject6).vec_feedInfos, null, null));
                if ((l1 == 0L) && (((QZoneCountUserInfo)localObject6).vec_feedInfos != null) && (((QZoneCountUserInfo)localObject6).vec_feedInfos.size() > 0)) {
                  l1 = ((feed_info)((QZoneCountUserInfo)localObject6).vec_feedInfos.get(0)).uOrgFeedTime;
                }
              }
            }
          }
          l2 = 0L;
          if ((localQZoneCountInfo.hasShow) && (l2 > 0L)) {
            localConcurrentHashMap2.put(Long.valueOf(56L), Long.valueOf(l2));
          }
          localConcurrentHashMap1.put(Integer.valueOf(56), new count_info(paramIntent, (ArrayList)localObject4, localQZoneCountInfo.trace_info, localQZoneCountInfo.countId, localQZoneCountInfo.iconUrl, localQZoneCountInfo.strShowMsg, localQZoneCountInfo.reportValue, localQZoneCountInfo.cTime, localQZoneCountInfo.iShowLevel, localQZoneCountInfo.actPageAttach));
          localObject4 = localObject3;
          paramIntent = (Intent)localObject1;
          i7 = i3;
          i5 = i6;
          localObject5 = localObject2;
          i2 = i4;
          n = i1;
          break label1278;
        }
      }
      paramIntent = "Q.lebatab.UndealCount.QZoneNotifyServlet";
      int i4 = n;
      int i5 = i2;
      Object localObject4 = "qzone_lastgetfeedtime";
      n = i1;
      i2 = i4;
      localObject5 = localObject2;
      int i7 = i3;
      label1278:
      localObject1 = LocalMultiProcConfig.getString4Uin("qzone_passive_undeal_readtime", "", ((QQAppInterface)localObject5).getLongAccountUin());
      localObject1 = QZoneUnreadServletLogic.a(Long.valueOf(((QQAppInterface)localObject5).getCurrentAccountUin()).longValue(), null, i2, i7, n, i5, localConcurrentHashMap1, (String)localObject1, localConcurrentHashMap2);
      if (localObject1 == null)
      {
        paramIntent = new byte[4];
        notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
      }
      else
      {
        paramPacket.setTimeout(30000L);
        if (QLog.isDevelopLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onSend cmd: ");
          ((StringBuilder)localObject2).append("SQQzoneSvc.");
          ((StringBuilder)localObject2).append("getUndealCount");
          ((StringBuilder)localObject2).append(" iVisitQZoneType: ");
          ((StringBuilder)localObject2).append(n);
          QLog.d("NavigatorBar.Q.lebatab.UndealCount.QZoneNotifyServlet", 4, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("SQQzoneSvc.");
        ((StringBuilder)localObject2).append("getUndealCount");
        paramPacket.setSSOCommand(((StringBuilder)localObject2).toString());
        paramPacket.putSendData((byte[])localObject1);
        c = System.currentTimeMillis();
        LocalMultiProcConfig.putLong((String)localObject4, c);
        if (QLog.isColorLevel())
        {
          paramPacket = new StringBuilder();
          paramPacket.append("onSend send success,send request time: ");
          paramPacket.append(c);
          QLog.d(paramIntent, 2, paramPacket.toString());
        }
      }
      e();
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramString.equals("cmd.pre.getpassivefeeds")) && (paramBundle != null))
    {
      if (!paramBundle.containsKey("data")) {
        return;
      }
      paramBundle = paramBundle.getBundle("data");
      int n = paramBundle.getInt("param.preget_seqid");
      paramString = getAppRuntime();
      if (paramString == null) {
        return;
      }
      if (!(paramString instanceof QQAppInterface)) {
        return;
      }
      paramBundle = Long.valueOf(paramBundle.getLong("param.preget_undealcount", -1L));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onWebEvent undealcount");
      localStringBuilder.append(paramBundle);
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, localStringBuilder.toString());
      QZoneUnreadServletLogic.a((QQAppInterface)paramString, n, paramBundle);
    }
  }
  
  public void service(Intent paramIntent)
  {
    if (paramIntent.getAction().equals("Qzone_Refresh_UI"))
    {
      long l1 = paramIntent.getLongExtra("notify_type", -1L);
      paramIntent = new Bundle();
      paramIntent.putBoolean("new", true);
      paramIntent.putLong("notify_type", l1);
      notifyObserver(null, 1000, true, paramIntent, QZoneObserver.class);
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebanew", 2, "qzone redtypeinfo:call notify observer");
      }
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet
 * JD-Core Version:    0.7.0.1
 */