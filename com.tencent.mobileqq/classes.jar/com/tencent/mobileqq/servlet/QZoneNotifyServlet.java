package com.tencent.mobileqq.servlet;

import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.single_count;
import ahyb;
import ahyc;
import ahyd;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.os.MqqHandler;

public class QZoneNotifyServlet
  extends MSFServlet
  implements WebEventListener
{
  private static SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  private static LbsDataV2.GpsInfo jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo;
  public static boolean a;
  public static long c;
  public static long d;
  public long a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ahyd(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  public long b = 5000L;
  
  public QZoneNotifyServlet()
  {
    this.jdField_a_of_type_Long = 180000L;
  }
  
  public static LbsDataV2.GpsInfo a()
  {
    return jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo;
  }
  
  private MqqHandler a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {}
    try
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler == null)
      {
        HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("QZONE_UNDEALCOUNT", 0);
        localHandlerThread.start();
        this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(localHandlerThread.getLooper());
      }
      return this.jdField_a_of_type_MqqOsMqqHandler;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
      QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new ahyc());
    }
  }
  
  private static void b()
  {
    if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener == null)) {
      jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new ahyb(3, true, true, 60000L, true, false, "QzReqInfo");
    }
    try
    {
      SosoInterface.a(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "onCreate startLocation exception " + localException);
    }
  }
  
  private void c()
  {
    a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    RemoteHandleManager.a().a(this);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null) {
      SosoInterface.b(jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    }
    jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = null;
    RemoteHandleManager.a().b(this);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 4, "QZoneNotifyServlet onDestroy" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_MqqOsMqqHandler.getLooper().quit();
    }
    this.jdField_a_of_type_MqqOsMqqHandler = null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = getAppRuntime();
    if (localObject == null) {}
    while (!(localObject instanceof QQAppInterface)) {
      return;
    }
    localObject = (QQAppInterface)localObject;
    d = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onReceive onReceive: " + d);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      LocalMultiProcConfig.putString4Uin("qzone_passive_undeal_readtime", "", ((QQAppInterface)localObject).getLongAccountUin());
      QZoneUnreadServletLogic.a(paramIntent, paramFromServiceMsg, (QQAppInterface)localObject, this);
      return;
    }
    QZoneUnreadServletLogic.a((QQAppInterface)localObject, paramIntent, paramFromServiceMsg, this);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend.begin.");
    }
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        b();
      } while (!"Qzone_Get_NewAndUnread_Count".equals(paramIntent.getAction()));
      localObject = getAppRuntime();
    } while ((localObject == null) || (!(localObject instanceof QQAppInterface)));
    Object localObject = (QQAppInterface)localObject;
    int i = 3;
    int k = paramIntent.getIntExtra("scene", 102);
    int j = paramIntent.getIntExtra("qzone_send_by_time", 4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "QzoneNotifyServlet onSend byTimeType:" + j + ",isBackground_Pause:" + ((QQAppInterface)localObject).isBackground_Pause);
    }
    if (j == 2)
    {
      i = 2;
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "GETFEEDUNREADTYPE_SWITCHTOFORGROUND nowtime: " + l + ",lastGetFeedTime:" + c + ",lastGetFeedTime:" + c + "difference: " + (l - c));
      }
      if (l - c < this.b)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend.interval time is not enough,schedule task.byTimeType:2");
        }
        c();
        return;
      }
    }
    if (((j == 1) || (j == 4) || (j == 5) || (j == 6) || (j == 7) || (j == 8)) && (((QQAppInterface)localObject).isBackground_Pause))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend app.isBackground_Pause: " + ((QQAppInterface)localObject).isBackground_Pause + " not send request,schedule task");
      }
      c();
      return;
    }
    if (j == 3) {
      i = 4;
    }
    if (j == 1) {
      i = 1;
    }
    if (j == 4) {
      i = 3;
    }
    if (j == 2) {
      i = 2;
    }
    if (j == 5) {
      i = 5;
    }
    if (j == 6) {
      i = 6;
    }
    if (j == 7) {
      i = 7;
    }
    if (j == 8) {
      i = 8;
    }
    for (;;)
    {
      int m = ((QQAppInterface)localObject).getApp().getResources().getDisplayMetrics().widthPixels;
      int n = ((QQAppInterface)localObject).getApp().getResources().getDisplayMetrics().heightPixels;
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      QZoneManagerImp localQZoneManagerImp = (QZoneManagerImp)((QQAppInterface)localObject).getManager(9);
      if ((localQZoneManagerImp != null) && (localQZoneManagerImp.a != null))
      {
        j = 1;
        if (j <= 2)
        {
          QZoneCountInfo localQZoneCountInfo = (QZoneCountInfo)localQZoneManagerImp.a.get(Integer.valueOf(j));
          single_count localsingle_count;
          ArrayList localArrayList;
          if (localQZoneCountInfo != null)
          {
            localsingle_count = new single_count(localQZoneCountInfo.jdField_a_of_type_Long, (byte)localQZoneCountInfo.jdField_a_of_type_Int);
            localArrayList = new ArrayList();
            if ((localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList == null) || (localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
              break label650;
            }
          }
          label650:
          for (paramIntent = new feed_host_info(((QZoneCountUserInfo)localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Long, "", localQZoneCountInfo.jdField_a_of_type_JavaLangString, null, null);; paramIntent = new feed_host_info(0L, "", localQZoneCountInfo.jdField_a_of_type_JavaLangString, null, null))
          {
            localArrayList.add(paramIntent);
            localConcurrentHashMap.put(Integer.valueOf(j), new count_info(localsingle_count, localArrayList, localQZoneCountInfo.b, localQZoneCountInfo.c, localQZoneCountInfo.e, localQZoneCountInfo.f, localQZoneCountInfo.g));
            j += 1;
            break;
          }
        }
      }
      paramIntent = LocalMultiProcConfig.getString4Uin("qzone_passive_undeal_readtime", "", ((QQAppInterface)localObject).getLongAccountUin());
      paramIntent = QZoneUnreadServletLogic.a(Long.valueOf(((QQAppInterface)localObject).getCurrentAccountUin()).longValue(), null, m, n, i, k, localConcurrentHashMap, paramIntent);
      if (paramIntent == null)
      {
        paramIntent = new byte[4];
        notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
      }
      for (;;)
      {
        c();
        return;
        paramPacket.setTimeout(30000L);
        if (QLog.isDevelopLevel()) {
          QLog.d("NavigatorBar.Q.lebatab.UndealCount.QZoneNotifyServlet", 4, "onSend cmd: " + "SQQzoneSvc." + "getUndealCount" + " iVisitQZoneType: " + i);
        }
        paramPacket.setSSOCommand("SQQzoneSvc." + "getUndealCount");
        paramPacket.putSendData(paramIntent);
        c = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 2, "onSend send success,send request time: " + c);
        }
      }
    }
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((!paramString.equals("cmd.pre.getpassivefeeds")) || (paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    int i;
    do
    {
      return;
      paramBundle = paramBundle.getBundle("data");
      i = paramBundle.getInt("param.preget_seqid");
      paramString = getAppRuntime();
    } while ((paramString == null) || (!(paramString instanceof QQAppInterface)));
    paramBundle = Long.valueOf(paramBundle.getLong("param.preget_undealcount", -1L));
    QLog.d("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "onWebEvent undealcount" + paramBundle);
    QZoneUnreadServletLogic.a((QQAppInterface)paramString, i, paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet
 * JD-Core Version:    0.7.0.1
 */