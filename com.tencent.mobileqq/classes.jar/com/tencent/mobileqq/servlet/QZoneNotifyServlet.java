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
  private static LbsManagerServiceOnLocationChangeListener jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener;
  private static SosoInterfaceOnLocationListener jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener;
  private static LbsDataV2.GpsInfo jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo;
  public static boolean a = false;
  public static long c;
  public static long d;
  private static long e;
  private static long f;
  private static long g = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
  public long a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new QZoneNotifyServlet.5(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b = 5000L;
  
  public QZoneNotifyServlet()
  {
    this.jdField_a_of_type_Long = 180000L;
  }
  
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
  
  private MqqHandler a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      try
      {
        if (this.jdField_a_of_type_MqqOsMqqHandler == null)
        {
          HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("QZONE_UNDEALCOUNT", 0);
          localHandlerThread.start();
          this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(localHandlerThread.getLooper());
        }
      }
      finally {}
    }
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  private void a()
  {
    a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
  }
  
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - e < g)
    {
      paramString = new StringBuilder();
      paramString.append("[QZ_LBS_MODULE] mIsGettingLocation = , (now - mLastGetLocationTime) ) = ");
      paramString.append((l - e) / 1000L);
      paramString.append(", so return");
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", paramString.toString());
      return;
    }
    e = l;
    if (jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener != null) {
      QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new QZoneNotifyServlet.4());
    }
  }
  
  private static void b(int paramInt)
  {
    if (paramInt == 2)
    {
      g *= 10L;
      return;
    }
    if (paramInt == 0)
    {
      g = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
      return;
    }
    g *= 2L;
  }
  
  private static void b(String paramString)
  {
    if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener == null))
    {
      jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener = new QZoneNotifyServlet.2(paramString, false);
      try
      {
        f = System.currentTimeMillis();
        if ((Build.VERSION.SDK_INT >= 23) && (BaseApplication.getContext() != null) && (BaseApplication.getContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0))
        {
          QZLog.w("QZLog", "[QZ_LBS_MODULE]定位有版本或权限限制");
          return;
        }
        ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener);
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
  
  protected void onCreate()
  {
    super.onCreate();
    RemoteHandleManager.getInstance().addWebEventListener(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener != null) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
    }
    jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = null;
    if (jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener != null) {
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).removeListener(jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener);
    }
    jdField_a_of_type_ComTencentMobileqqSosoLocationLbsManagerServiceOnLocationChangeListener = null;
    RemoteHandleManager.getInstance().removeWebEventListener(this);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("QZoneNotifyServlet onDestroy");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 4, localStringBuilder.toString());
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.getLooper().quit();
    }
    this.jdField_a_of_type_MqqOsMqqHandler = null;
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
        b("qzone_little_video_enter");
      }
      int k = paramIntent.getIntExtra("scene", 102);
      int m = paramIntent.getIntExtra("qzone_send_by_time", 4);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("QzoneNotifyServlet onSend byTimeType:");
        paramIntent.append(m);
        paramIntent.append(",isBackground_Pause:");
        paramIntent.append(((QQAppInterface)localObject2).isBackgroundPause);
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, paramIntent.toString());
      }
      long l1;
      if (m == 2)
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
          a();
          return;
        }
        i = 2;
      }
      else
      {
        i = 3;
      }
      paramIntent = "qzone_lastgetfeedtime";
      long l2;
      if (((m == 1) || (m == 4) || (m == 5) || (m == 6) || (m == 7) || (m == 8)) && (((QQAppInterface)localObject2).isBackgroundPause))
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
          a();
          return;
        }
      }
      if (m == 3) {
        i = 4;
      }
      if (m == 1) {
        i = 1;
      }
      if (m == 4) {
        i = 3;
      }
      if (m == 2) {
        i = 2;
      }
      if (m == 5) {
        i = 5;
      }
      if (m == 6) {
        i = 6;
      }
      if (m == 7) {
        i = 7;
      }
      int j = 8;
      if (m != 8) {
        j = i;
      }
      int i = ((QQAppInterface)localObject2).getApp().getResources().getDisplayMetrics().widthPixels;
      m = ((QQAppInterface)localObject2).getApp().getResources().getDisplayMetrics().heightPixels;
      ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
      ConcurrentHashMap localConcurrentHashMap2 = new ConcurrentHashMap();
      Object localObject5 = (QZoneManagerImp)((QQAppInterface)localObject2).getManager(QQManagerFactory.QZONE_MANAGER);
      if (localObject5 != null)
      {
        Object localObject3 = ((QZoneManagerImp)localObject5).a;
        if (localObject3 != null)
        {
          localObject3 = QZoneUnreadServletLogic.a((Map)localObject3);
          n = ((List)localObject3).size();
          i1 = 0;
          Object localObject6;
          while (i1 < n)
          {
            i2 = ((Integer)((List)localObject3).get(i1)).intValue();
            localQZoneCountInfo = (QZoneCountInfo)((QZoneManagerImp)localObject5).a.get(Integer.valueOf(i2));
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
              i3 = localQZoneCountInfo.countId;
              String str1 = localQZoneCountInfo.iconUrl;
              String str2 = localQZoneCountInfo.strShowMsg;
              String str3 = localQZoneCountInfo.reportValue;
              localConcurrentHashMap1.put(Integer.valueOf(i2), new count_info((single_count)localObject6, localArrayList, (String)localObject4, i3, str1, str2, str3, localQZoneCountInfo.cTime, localQZoneCountInfo.iShowLevel, localQZoneCountInfo.actPageAttach));
            }
            i1 += 1;
          }
          n = i;
          int i2 = k;
          localObject3 = paramIntent;
          QZoneCountInfo localQZoneCountInfo = (QZoneCountInfo)((QZoneManagerImp)localObject5).a.get(Integer.valueOf(56));
          localObject4 = localObject3;
          paramIntent = (Intent)localObject1;
          i3 = m;
          i1 = i2;
          localObject5 = localObject2;
          k = n;
          i = j;
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
          i3 = m;
          i1 = i2;
          localObject5 = localObject2;
          k = n;
          i = j;
          break label1278;
        }
      }
      paramIntent = "Q.lebatab.UndealCount.QZoneNotifyServlet";
      int n = i;
      int i1 = k;
      Object localObject4 = "qzone_lastgetfeedtime";
      i = j;
      k = n;
      localObject5 = localObject2;
      int i3 = m;
      label1278:
      localObject1 = LocalMultiProcConfig.getString4Uin("qzone_passive_undeal_readtime", "", ((QQAppInterface)localObject5).getLongAccountUin());
      localObject1 = QZoneUnreadServletLogic.a(Long.valueOf(((QQAppInterface)localObject5).getCurrentAccountUin()).longValue(), null, k, i3, i, i1, localConcurrentHashMap1, (String)localObject1, localConcurrentHashMap2);
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
          ((StringBuilder)localObject2).append(i);
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
      a();
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
      int i = paramBundle.getInt("param.preget_seqid");
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
      QZoneUnreadServletLogic.a((QQAppInterface)paramString, i, paramBundle);
    }
  }
  
  public void service(Intent paramIntent)
  {
    if (paramIntent.getAction().equals("Qzone_Refresh_UI"))
    {
      long l = paramIntent.getLongExtra("notify_type", -1L);
      paramIntent = new Bundle();
      paramIntent.putBoolean("new", true);
      paramIntent.putLong("notify_type", l);
      notifyObserver(null, 1000, true, paramIntent, QZoneObserver.class);
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebanew", 2, "qzone redtypeinfo:call notify observer");
      }
      return;
    }
    super.service(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet
 * JD-Core Version:    0.7.0.1
 */