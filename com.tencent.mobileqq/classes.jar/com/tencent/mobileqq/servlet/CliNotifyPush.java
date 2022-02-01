package com.tencent.mobileqq.servlet;

import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.feed_info;
import QzoneCombine.PushInfo;
import QzoneCombine.SingleMsg;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppRedDotEntity;
import com.tencent.mobileqq.mini.push.MiniAppControlInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.model.SinglePushMsg;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sc.qzonepush.QQService.SvcMsgPush;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.push.MsgNotification;
import cooperation.qzone.push.QzNotificationStruct;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.remote.logic.WebEventListener;
import cooperation.qzone.util.JceUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONObject;

public class CliNotifyPush
  extends MSFServlet
  implements WebEventListener
{
  public static volatile HashMap<Integer, SinglePushMsg> a;
  public static volatile List<QzNotificationStruct> a;
  private static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "baseSdk.Msf.NotifyResp", "CliNotifySvc.SvcReqPush", "MessageSvc.WNSQzone" };
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static long a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, 0);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramQQAppInterface != null)
    {
      SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("QZONE_PUSH_ST", 0);
      paramQQAppInterface = paramQQAppInterface.getAccount();
      l1 = l2;
      if (paramQQAppInterface != null)
      {
        l1 = l2;
        if (paramQQAppInterface.length() > 0) {
          l1 = localSharedPreferences.getLong(paramQQAppInterface + ":" + paramInt, 0L);
        }
      }
    }
    return l1;
  }
  
  private void a(int paramInt)
  {
    QLog.e("CliNotifyPush", 1, "report resultCode:" + paramInt);
    b(paramInt);
    QZoneHelper.preloadQZoneForHaboReport((QQAppInterface)getAppRuntime(), "qzonenewservice.callqzonev2", paramInt, "CliNotifyPush", 1, System.currentTimeMillis());
  }
  
  private void a(SingleMsg paramSingleMsg)
  {
    QLog.e("CliNotifyPush", 1, "handle eeveepush");
    if (paramSingleMsg == null)
    {
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportDc010001(500, 10, 2, null, null, null, null, 1000);
      return;
    }
    QLog.d("CliNotifyPush", 1, "processEeveePush");
    String str1 = (String)paramSingleMsg.data.get("eevee_ext_info");
    String str3 = (String)paramSingleMsg.data.get("eevee_push_data");
    String str2 = (String)paramSingleMsg.data.get("pushstatkey");
    paramSingleMsg = (String)paramSingleMsg.data.get("pushscene");
    if (!TextUtils.isEmpty(paramSingleMsg)) {
      try
      {
        if (Integer.parseInt(paramSingleMsg) == 1001)
        {
          ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportDc010001(500, 10, 1, null, null, null, str2, 1001);
          QCircleUtils.a().onSend(1001, str3, str2);
          return;
        }
      }
      catch (Exception paramSingleMsg)
      {
        QLog.e("CliNotifyPush", 1, paramSingleMsg, new Object[0]);
      }
    }
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportDc010001(500, 10, 1, null, null, null, str2, 1000);
    QCircleUtils.a().onSend(1000, str1, str2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramQQAppInterface != null)
    {
      SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("QZONE_PUSH_ST", 0).edit();
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
        localEditor.putLong(paramQQAppInterface + ":" + paramInt, paramLong);
      }
      localEditor.commit();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    a(paramQQAppInterface, 0, paramLong);
  }
  
  private void a(QQAppInterface paramQQAppInterface, SinglePushMsg paramSinglePushMsg)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    QLog.i("CliNotifyPush", 1, "handleQQCirclePush " + paramQQAppInterface.isBackgroundPause + ", " + paramQQAppInterface.isBackgroundStop);
    if ((paramQQAppInterface.isBackgroundPause) && (paramQQAppInterface.isBackgroundStop))
    {
      localObject = (IRedTouchServer)paramQQAppInterface.getRuntimeService(IRedTouchServer.class, "");
      QLog.i("CliNotifyPush", 1, "handleQQCirclePush sendRedpointReq");
      ((IRedTouchServer)localObject).sendRedpointReq(true, false, 6);
    }
    Object localObject = new Intent();
    ((Intent)localObject).setAction("action_receive_message_push");
    BaseApplication.getContext().sendBroadcast((Intent)localObject);
    QLog.e("CliNotifyPush", 1, "showQQCirclePush()");
    if (!QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext()))
    {
      a(paramSinglePushMsg, paramQQAppInterface, 512L);
      return;
    }
    localObject = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("conent");
    String str1 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushstatkey");
    String str2 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("shcemaUrlAnd");
    String str3 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("title");
    String str4 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("fake_push");
    String str5 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("icon_type");
    String str6 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("icon_url");
    int i = 0;
    try
    {
      int j = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("VideoCirclePushMergeType"));
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("CliNotifyPush", 1, localException, new Object[0]);
      }
      MsgNotification.getInstance().updateUnreadcount(366, i);
      a(paramSinglePushMsg, paramQQAppInterface, 32L);
    }
    if (paramQQAppInterface.isBackgroundPause)
    {
      MsgNotification.getInstance().showQZoneMsgNotification(paramQQAppInterface, 1, str3, (String)localObject, str5, str6, paramQQAppInterface.isShowMsgContent(), 366, str2, str1, true, "1".equals(str4), i);
      a(paramSinglePushMsg, paramQQAppInterface, 4L);
      QLog.e("CliNotifyPush", 1, "show push: XXX");
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Map<String, String> paramMap)
  {
    if (paramMap == null) {
      QLog.e("CliNotifyPush", 1, "processMiniAppRedDotPush, data is null.");
    }
    for (;;)
    {
      return;
      try
      {
        String str = (String)paramMap.get("maappid");
        int i = Integer.valueOf((String)paramMap.get("reddotcount")).intValue();
        if ((!TextUtils.isEmpty(str)) && (i > 0))
        {
          paramMap = new MiniAppRedDotEntity(str, 0, i);
          paramQQAppInterface = (AppletsHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface.notifyUI(9, true, paramMap);
            return;
          }
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.e("CliNotifyPush", 1, "processMiniAppRedDotPush, exception: " + paramQQAppInterface.toString());
      }
    }
  }
  
  private void a(SinglePushMsg paramSinglePushMsg)
  {
    QLog.e("CliNotifyPush", 1, "dispathQzonePushMsg()");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {}
    while ((paramSinglePushMsg == null) || (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    if ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap != null) && (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("utime") != null) && (LocalMultiProcConfig.getInt4Uin("qzone_preget_passive_open", 0, localQQAppInterface.getLongAccountUin()) == 1))
    {
      String str = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("utime");
      if (!LocalMultiProcConfig.getString4Uin("qzone_passive_undealtime", "", localQQAppInterface.getLongAccountUin()).equals(str))
      {
        paramSinglePushMsg.jdField_a_of_type_Boolean = true;
        int i = RemoteHandleManager.getInstance().getSender().pregetPassiveFeeds(localQQAppInterface.getLongAccountUin());
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), paramSinglePushMsg);
      }
    }
    b(paramSinglePushMsg);
  }
  
  public static void a(SinglePushMsg paramSinglePushMsg, QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramSinglePushMsg == null) {
      return;
    }
    if (paramQQAppInterface != null) {}
    for (long l1 = Long.parseLong(paramQQAppInterface.getAccount());; l1 = 0L)
    {
      long l2 = paramLong;
      NewIntent localNewIntent;
      if (paramSinglePushMsg.jdField_a_of_type_Long != 0L)
      {
        l2 = paramLong;
        if (l1 != 0L)
        {
          localNewIntent = new NewIntent(paramQQAppInterface.getApplication(), QZonePushAckServlet.class);
          localNewIntent.putExtra("timestamp", paramSinglePushMsg.jdField_a_of_type_Long);
          localNewIntent.putExtra("hostuin", l1);
          if (!paramSinglePushMsg.jdField_b_of_type_Boolean) {
            break label229;
          }
        }
      }
      label229:
      for (paramLong = 1L | paramLong;; paramLong = 0xFFFFFFFE & paramLong)
      {
        String str2 = paramSinglePushMsg.jdField_a_of_type_JavaLangString;
        String str1;
        if (!TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (!str2.equals("0")) {}
        }
        else
        {
          str1 = str2;
          if (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap != null) {
            str1 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushstatkey");
          }
        }
        localNewIntent.putExtra("mark", str1);
        localNewIntent.putExtra("flag", paramLong);
        paramQQAppInterface.startServlet(localNewIntent);
        l2 = paramLong;
        QLog.e("CliNotifyPush", 1, "sentQzoneMsfPushAck: localTimeStamp=" + paramSinglePushMsg.jdField_a_of_type_Long + " uin=" + l1 + " flag=" + l2);
        return;
      }
    }
  }
  
  private void a(SinglePushMsg paramSinglePushMsg, boolean paramBoolean)
  {
    if ((paramSinglePushMsg == null) || (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap == null)) {
      QLog.e("CliNotifyPush", 1, "showRedTouch failed sm=null");
    }
    Object localObject1;
    QZoneManagerImp localQZoneManagerImp;
    do
    {
      return;
      localObject1 = (QQAppInterface)getAppRuntime();
      if (localObject1 == null)
      {
        QLog.e("CliNotifyPush", 1, "showRedTouch failed app=null");
        return;
      }
      localQZoneManagerImp = (QZoneManagerImp)((QQAppInterface)localObject1).getManager(QQManagerFactory.QZONE_MANAGER);
    } while (localQZoneManagerImp == null);
    for (;;)
    {
      int m;
      try
      {
        int k = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
        QLog.i("CliNotifyPush", 1, "showRedTouch type:" + k + ",uin:" + paramSinglePushMsg.jdField_b_of_type_Long + ",isBackground_Pause:" + ((QQAppInterface)localObject1).isBackgroundPause);
        if ((k != 1) && (k != 300) && (k != 302)) {
          break;
        }
        localObject1 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("conent");
        m = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("count"));
        l = paramSinglePushMsg.jdField_b_of_type_Long;
        int i = 0;
        try
        {
          boolean bool = paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.containsKey("opuin_qzoneVipLevel");
          if (!bool) {
            break label673;
          }
          i = 1;
          ArrayList localArrayList;
          Object localObject3;
          Object localObject4;
          QZoneCountUserInfo localQZoneCountUserInfo;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label645;
          }
        }
        catch (Exception localException1)
        {
          try
          {
            j = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("opuin_qzoneVipLevel"));
            i = 1;
            localArrayList = new ArrayList();
            localObject2 = new QZoneCountUserInfo();
            ((QZoneCountUserInfo)localObject2).uin = l;
            ((QZoneCountUserInfo)localObject2).iYellowLevel = j;
            ((QZoneCountUserInfo)localObject2).iYellowType = i;
            paramSinglePushMsg.jdField_a_of_type_ArrayOfByte = JceUtils.inflateByte(paramSinglePushMsg.jdField_a_of_type_ArrayOfByte);
            if (paramSinglePushMsg.jdField_a_of_type_ArrayOfByte != null)
            {
              localObject3 = (PassiveFeedsPush)JceUtils.decodeWup(PassiveFeedsPush.class, paramSinglePushMsg.jdField_a_of_type_ArrayOfByte);
              if ((localObject3 != null) && (((PassiveFeedsPush)localObject3).stBubbleSkin != null) && (((PassiveFeedsPush)localObject3).stBubbleSkin.lUin == l)) {
                ((QZoneCountUserInfo)localObject2).pushData = ((PassiveFeedsPush)localObject3);
              }
            }
            localArrayList.add(localObject2);
            localObject2 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("shcemaUrlAnd");
          }
          catch (Exception localException2)
          {
            Object localObject2;
            continue;
          }
          try
          {
            paramSinglePushMsg = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("psv_tab_textlist");
            if (!TextUtils.isEmpty(paramSinglePushMsg))
            {
              paramSinglePushMsg = new JSONObject(paramSinglePushMsg);
              paramSinglePushMsg.getJSONObject("psv_tab_list");
              paramSinglePushMsg = paramSinglePushMsg.getJSONObject("psv_tab_list").getJSONArray("text_data");
              i = 0;
              if (i < paramSinglePushMsg.length())
              {
                localObject4 = (JSONObject)paramSinglePushMsg.get(i);
                l = ((JSONObject)localObject4).getLong("uin");
                localObject3 = ((JSONObject)localObject4).getString("nk");
                localObject4 = new feed_info(0L, 0L, 0L, ((JSONObject)localObject4).getString("text"));
                localQZoneCountUserInfo = new QZoneCountUserInfo();
                localQZoneCountUserInfo.nickName = ((String)localObject3);
                localQZoneCountUserInfo.uin = l;
                localObject3 = new ArrayList();
                ((ArrayList)localObject3).add(localObject4);
                localQZoneCountUserInfo.vec_feedInfos = ((ArrayList)localObject3);
                localArrayList.add(localQZoneCountUserInfo);
                i += 1;
                continue;
                localException1 = localException1;
                i = 0;
                QLog.i("CliNotifyPush", 2, "parse vip level error");
                j = 0;
              }
            }
          }
          catch (Exception paramSinglePushMsg)
          {
            QLog.e("CliNotifyPush", 1, "psv_tab_textlist failed" + paramSinglePushMsg);
            if (k != 302) {
              break label645;
            }
          }
        }
        localQZoneManagerImp.a(1, m, localException1, (String)localObject1, paramBoolean, true, (String)localObject2);
        return;
      }
      catch (Exception paramSinglePushMsg)
      {
        QLog.e("CliNotifyPush", 1, "showRedTouch failed");
        return;
      }
      label645:
      long l = m;
      localQZoneManagerImp.a(1, l, localException1, (String)localObject1, paramBoolean, true, "");
      return;
      label673:
      int j = 0;
    }
  }
  
  private void a(Map<String, String> paramMap)
  {
    Intent localIntent = new Intent("com.qzone.live.MicLogic.processMicMsg");
    if ((paramMap != null) && ((paramMap instanceof HashMap))) {
      localIntent.putExtra("mic_msg", (HashMap)paramMap);
    }
    BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  private void a(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    try
    {
      QZoneDistributedAppCtrl.Control localControl = new QZoneDistributedAppCtrl.Control();
      localControl.cmd = Integer.parseInt((String)paramMap.get("key_ctrl_cmd"));
      localControl.data.putAll(paramMap);
      QZoneDistributedAppCtrl.getInstance(paramString).submitCtrl(localControl);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
        if (paramContext != null) {
          return true;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext = null;
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 10000) {}
    do
    {
      return false;
      if ((8 == paramInt) || (4 == paramInt) || (366 == paramInt)) {
        return true;
      }
      if (paramInt == 2) {
        return true;
      }
    } while ((paramInt != 1) && (paramInt != 300));
    return LocalMultiProcConfig.getBool(paramQQAppInterface.getApp().getApplicationContext().getString(2131718678) + paramQQAppInterface.getAccount(), true);
  }
  
  private boolean a(SinglePushMsg paramSinglePushMsg)
  {
    int i = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (i == 301)
    {
      Object localObject;
      QzNotificationStruct localQzNotificationStruct2;
      if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("live_roomid");
        if (localObject != null)
        {
          localQzNotificationStruct2 = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
          if ((localQzNotificationStruct2 == null) || (!((String)localObject).equals(localQzNotificationStruct2.roomId))) {
            break label251;
          }
          jdField_a_of_type_JavaUtilList.remove(localQzNotificationStruct2);
          if (jdField_a_of_type_JavaUtilList.size() != 0) {
            break label181;
          }
        }
      }
      for (;;)
      {
        try
        {
          localObject = QQNotificationManager.getInstance();
          if (localObject != null) {
            ((QQNotificationManager)localObject).cancel("CliNotifyPush.clearLivePush", 242);
          }
        }
        catch (Exception localException)
        {
          QLog.e("CliNotifyPush", 1, "NotificationManager cancel exception");
          continue;
        }
        a(paramSinglePushMsg, localQQAppInterface, 16L);
        return true;
        label181:
        QzNotificationStruct localQzNotificationStruct1 = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
        if (localQzNotificationStruct1 != null)
        {
          MsgNotification.getInstance().showQZoneMsgNotification(localQQAppInterface, 0, null, localQzNotificationStruct1.notifyText, null, null, localQzNotificationStruct1.showMsgContent, localQzNotificationStruct1.pushType, localQzNotificationStruct1.actionUrl, localQzNotificationStruct1.pushstatkey, false, false, -1);
          continue;
          label251:
          if (jdField_a_of_type_JavaUtilList.size() > 1)
          {
            i = 0;
            while (i < jdField_a_of_type_JavaUtilList.size() - 1)
            {
              localQzNotificationStruct2 = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(i);
              if ((localQzNotificationStruct2 != null) && (localQzNotificationStruct1.equals(localQzNotificationStruct2.roomId))) {
                jdField_a_of_type_JavaUtilList.remove(localQzNotificationStruct2);
              }
              i += 1;
            }
          }
        }
      }
    }
    return false;
  }
  
  private void b(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("resultcode", String.valueOf(paramInt));
    localHashMap.put("time", String.valueOf(System.currentTimeMillis()));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(localQQAppInterface.getAccount(), "callqzonefrompushv2", true, 0L, 0L, localHashMap, null, true);
  }
  
  private void b(SinglePushMsg paramSinglePushMsg)
  {
    QLog.e("CliNotifyPush", 1, "showPush()");
    if ((paramSinglePushMsg.jdField_a_of_type_Boolean) && (paramSinglePushMsg.jdField_a_of_type_Int == 0)) {
      paramSinglePushMsg.jdField_a_of_type_Int += 1;
    }
    QQAppInterface localQQAppInterface;
    int m;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)getAppRuntime();
      m = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
      QLog.e("CliNotifyPush", 1, "pushType:" + m);
      if (m == 10000)
      {
        a(paramSinglePushMsg.jdField_a_of_type_JavaUtilMap, localQQAppInterface.getAccount());
        a(paramSinglePushMsg, localQQAppInterface, 16L);
        return;
      }
      if (m == 10100)
      {
        b(paramSinglePushMsg.jdField_a_of_type_JavaUtilMap, localQQAppInterface.getAccount());
        a(paramSinglePushMsg, localQQAppInterface, 16L);
        return;
      }
      if (m == 350)
      {
        a(paramSinglePushMsg, localQQAppInterface, 16L);
        c(paramSinglePushMsg);
        return;
      }
    } while (a(paramSinglePushMsg));
    if (m == 100)
    {
      a(paramSinglePushMsg, localQQAppInterface, 16L);
      return;
    }
    String str1 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("conent");
    String str2 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushstatkey");
    String str3 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("shcemaUrlAnd");
    String str4 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("title");
    String str5 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("fake_push");
    String str6 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("icon_type");
    String str7 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("icon_url");
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, new Object[] { "showPush: invoked. ", " iconType: ", str6, " title: ", str4, " message: ", str1 });
    }
    long l = paramSinglePushMsg.jdField_b_of_type_Long;
    if (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("count") != null) {
      QLog.i("CliNotifyPush", 1, "showPush receive push time:" + paramSinglePushMsg.jdField_a_of_type_Long + ",unreadCount=" + 1 + ",uin=" + l + ",type=" + m);
    }
    for (;;)
    {
      boolean bool1;
      try
      {
        int j = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("count"));
        i = j;
        if (j < 1) {
          i = 1;
        }
        int k;
        bool3 = localQQAppInterface.isShowMsgContent();
      }
      catch (Exception localException2)
      {
        try
        {
          j = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("CtrlFlag"));
          if (QLog.isColorLevel())
          {
            QLog.i("CliNotifyPush", 2, "qzone redtypeinfo:receive push time:" + paramSinglePushMsg.jdField_a_of_type_Long + "=unreadCount=" + i + "=uin=" + l + "=type=" + m + "=CtrlFlag=" + j + "=message=" + str1);
            if (j != 1) {
              continue;
            }
            bool1 = true;
            a(paramSinglePushMsg, bool1);
          }
        }
        catch (Exception localException2)
        {
          try
          {
            k = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("show_level"));
            if ((!localQQAppInterface.isBackgroundPause) && (!a(k, 1))) {
              break label1060;
            }
            if (!a(localQQAppInterface, m))
            {
              a(paramSinglePushMsg, localQQAppInterface, 16L);
              return;
              localException1 = localException1;
              i = 1;
              continue;
              localException2 = localException2;
              j = 0;
              continue;
              QLog.i("CliNotifyPush", 1, "qzone redtypeinfo:receive push time:" + paramSinglePushMsg.jdField_a_of_type_Long + "=unreadCount=" + i + "=uin=" + l + "=type=" + m + "=CtrlFlag=" + j);
              continue;
              bool1 = false;
            }
          }
          catch (Exception localException3)
          {
            k = 4;
            continue;
            if (j == 1)
            {
              QLog.e("CliNotifyPush", 1, "not show push, existDL = " + j);
              a(paramSinglePushMsg, localQQAppInterface, 128L);
              return;
            }
            if ((!QQUtils.a(localQQAppInterface.getApp())) && (a(localQQAppInterface)) && (!a(k, 0)))
            {
              a(paramSinglePushMsg, localQQAppInterface, 64L);
              return;
            }
            if (!QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext()))
            {
              a(paramSinglePushMsg, localQQAppInterface, 512L);
              return;
            }
            if (str1 == null) {
              break label1050;
            }
          }
        }
      }
      boolean bool3;
      if (!bool3) {
        str1 = localQQAppInterface.getApp().getApplicationContext().getString(2131717887) + i + localQQAppInterface.getApp().getApplicationContext().getString(2131717888);
      }
      for (;;)
      {
        boolean bool2 = true;
        bool1 = bool2;
        if (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap != null)
        {
          bool1 = bool2;
          if (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("daemonShow") != null) {
            bool1 = "1".equals(paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("daemonShow"));
          }
        }
        if (bool1)
        {
          MsgNotification.getInstance().showQZoneMsgNotification(localQQAppInterface, 1, str4, str1, str6, str7, bool3, m, str3, str2, true, "1".equals(str5), -1);
          a(paramSinglePushMsg, localQQAppInterface, 4L);
        }
        QLog.e("CliNotifyPush", 1, "show push: XXX");
        return;
        label1050:
        a(paramSinglePushMsg, localQQAppInterface, 256L);
        return;
        label1060:
        a(paramSinglePushMsg, localQQAppInterface, 32L);
        return;
      }
      int i = 1;
    }
  }
  
  private void b(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return;
    }
    try
    {
      MiniAppControlInfo localMiniAppControlInfo = new MiniAppControlInfo();
      localMiniAppControlInfo.cmd = ((String)paramMap.get("key_ctrl_cmd"));
      localMiniAppControlInfo.data.putAll(paramMap);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).processControlInfo(paramString, localMiniAppControlInfo);
      return;
    }
    catch (Exception paramMap)
    {
      QLog.e("CliNotifyPush", 1, "decodeMiniAppCtrlPush failed:", paramMap);
    }
  }
  
  private void c(SinglePushMsg paramSinglePushMsg)
  {
    if (paramSinglePushMsg == null) {
      return;
    }
    QLog.e("CliNotifyPush", 1, "recv Qzone Push: Feed实时更新Push");
    Intent localIntent = new Intent("com.qzone.push_feed_update");
    if ((paramSinglePushMsg.jdField_a_of_type_ArrayOfByte != null) && (paramSinglePushMsg.jdField_a_of_type_ArrayOfByte.length > 0)) {
      localIntent.putExtra("update_feeds_buffer", paramSinglePushMsg.jdField_a_of_type_ArrayOfByte);
    }
    for (;;)
    {
      BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
      if ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap != null) && ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap instanceof HashMap))) {
        localIntent.putExtra("update_feeds", (HashMap)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap);
      }
    }
  }
  
  public Map<Integer, SinglePushMsg> a(FromServiceMsg paramFromServiceMsg)
  {
    QLog.e("CliNotifyPush", 1, "decodeQzonePushMsgs()");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return null;
    }
    paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
    System.arraycopy(paramFromServiceMsg, 4, paramFromServiceMsg, 0, paramFromServiceMsg.length - 4);
    PushInfo localPushInfo = new PushInfo();
    paramFromServiceMsg = new JceInputStream(paramFromServiceMsg);
    paramFromServiceMsg.setServerEncoding("utf-8");
    localPushInfo.readFrom(paramFromServiceMsg);
    paramFromServiceMsg = localPushInfo.vecMsg;
    HashMap localHashMap = new HashMap();
    long l3 = a(localQQAppInterface);
    Iterator localIterator = paramFromServiceMsg.iterator();
    long l1 = l3;
    SingleMsg localSingleMsg;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localSingleMsg = (SingleMsg)localIterator.next();
        if (localSingleMsg != null) {
          if (localSingleMsg.data.containsKey("pushtype")) {
            i = Integer.parseInt((String)localSingleMsg.data.get("pushtype"));
          }
        }
      }
    }
    for (;;)
    {
      long l2;
      label551:
      SinglePushMsg localSinglePushMsg;
      if ((i == 1) || (i == 2) || (i == 4) || (i == 301) || (i == 8) || (i == 300) || (i == 10000) || (i == 10100) || (i == 302) || (i == 350) || (i == 100) || (i == 366))
      {
        l2 = a(localQQAppInterface, i);
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", "PushDeduplication", 1) == 1)
        {
          if (localSingleMsg.addTime > l2) {
            break label551;
          }
          QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
          a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, localPushInfo.Mark), localQQAppInterface, 8L);
          a(2014);
          break;
          if (!localSingleMsg.data.containsKey("type")) {
            break label1061;
          }
          i = Integer.parseInt((String)localSingleMsg.data.get("type"));
          continue;
        }
        if (localSingleMsg.addTime < l2)
        {
          QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
          a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, localPushInfo.Mark), localQQAppInterface, 8L);
          a(2014);
          break;
        }
        if (localHashMap.containsKey(Integer.valueOf(i)))
        {
          localSinglePushMsg = (SinglePushMsg)localHashMap.get(Integer.valueOf(i));
          if ((localSinglePushMsg != null) && (localSinglePushMsg.jdField_a_of_type_Long < localSingleMsg.addTime))
          {
            paramFromServiceMsg = new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, localPushInfo.Mark, localSingleMsg.extBuffer);
            if (i != 366) {
              localHashMap.put(Integer.valueOf(i), paramFromServiceMsg);
            }
            QLog.e("CliNotifyPush", 1, "PushDeduplication: msg localTimeStap:" + localSingleMsg.addTime + " sm newTimeStap:" + localSinglePushMsg.jdField_a_of_type_Long + " msg:" + (String)localSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("conent"));
            a(localSinglePushMsg, localQQAppInterface, 8L);
            label732:
            a(localQQAppInterface, i, localSingleMsg.addTime);
            l2 = l1;
            if (l1 < localSingleMsg.addTime) {
              l2 = localSingleMsg.addTime;
            }
            if (i == 366) {
              a(localQQAppInterface, paramFromServiceMsg);
            }
            l1 = l2;
          }
        }
      }
      for (;;)
      {
        break;
        QLog.e("CliNotifyPush", 1, "PushDeduplication: localTimeStap:" + l2 + " newTimeStap:" + localSingleMsg.addTime + " msg:" + (String)localSingleMsg.data.get("conent"));
        a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, localPushInfo.Mark), localQQAppInterface, 8L);
        break;
        localSinglePushMsg = new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, localPushInfo.Mark, localSingleMsg.extBuffer);
        paramFromServiceMsg = localSinglePushMsg;
        if (i == 366) {
          break label732;
        }
        localHashMap.put(Integer.valueOf(i), localSinglePushMsg);
        paramFromServiceMsg = localSinglePushMsg;
        break label732;
        if (i == 7066) {
          a(localSingleMsg.data);
        } else if (i == 200) {
          a(localQQAppInterface, localSingleMsg.data);
        } else if (i == 699) {
          a(localSingleMsg);
        } else {
          a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, localPushInfo.Mark), localQQAppInterface, 256L);
        }
      }
      if (l3 < l1) {
        a(localQQAppInterface, l1);
      }
      return localHashMap;
      label1061:
      i = 0;
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((1 << paramInt2 & paramInt1) != 0) {}
    for (;;)
    {
      if (QZLog.isColorLevel()) {
        QZLog.i("CliNotifyPush", 2, "checkForegroundShowEnabled showLevel: " + paramInt1 + ",result: " + bool);
      }
      return bool;
      bool = false;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    paramQQAppInterface = ((ActivityManager)paramQQAppInterface.getApp().getSystemService("activity")).getRunningTasks(1);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface.size() > 0)
      {
        paramQQAppInterface = ((ActivityManager.RunningTaskInfo)paramQQAppInterface.get(0)).topActivity.getClassName();
        if ((!"cooperation.qzone.QzoneGPUPluginProxyActivity".equals(paramQQAppInterface)) && (!"cooperation.qzone.QzonePluginProxyActivity".equals(paramQQAppInterface)) && (!"cooperation.qzone.QzoneFeedsPluginProxyActivity".equals(paramQQAppInterface))) {
          break label88;
        }
      }
    }
    label88:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  public String[] getPreferSSOCommands()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public void onCreate()
  {
    super.onCreate();
    RemoteHandleManager.getInstance().addWebEventListener(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    RemoteHandleManager.getInstance().removeWebEventListener(this);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify begin");
    }
    if ((paramFromServiceMsg.getServiceCmd().equals("CliNotifySvc.SvcReqPush")) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CliNotifyPush", 2, "<<---ClientNotifyPush get notify");
      }
      paramIntent = (byte[])paramFromServiceMsg.attributes.get("pushMsgs");
      SvcMsgPush localSvcMsgPush = new SvcMsgPush();
      localSvcMsgPush.readFrom(new JceInputStream(paramIntent));
      ((MessageHandler)((QQAppInterface)getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).onReceive(null, paramFromServiceMsg, localSvcMsgPush);
    }
    for (;;)
    {
      return;
      if ((!paramFromServiceMsg.getServiceCmd().equals("MessageSvc.WNSQzone")) || (!paramFromServiceMsg.isSuccess())) {
        break;
      }
      QLog.e("CliNotifyPush", 1, "get qzone push begin");
      paramIntent = a(paramFromServiceMsg);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.values().iterator();
        while (paramIntent.hasNext()) {
          a((SinglePushMsg)paramIntent.next());
        }
      }
    }
    QLog.e("CliNotifyPush", 1, "get qzone push error");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((!paramString.equals("cmd.pre.getpassivefeeds")) || (paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    int i;
    do
    {
      return;
      paramString = paramBundle.getBundle("data");
      i = paramString.getInt("param.preget_seqid");
      paramString = Long.valueOf(paramString.getLong("param.preget_undealcount", -1L));
    } while (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)) == null);
    paramBundle = (SinglePushMsg)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    if (paramString.longValue() != -1L) {
      paramBundle.jdField_a_of_type_JavaUtilMap.put("count", paramString + "");
    }
    QLog.e("CliNotifyPush", 1, "onWebEvent showPush count:" + paramString);
    b((SinglePushMsg)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.CliNotifyPush
 * JD-Core Version:    0.7.0.1
 */