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
import com.tencent.qzonehub.api.IQzoneMixApi;
import com.tencent.qzonehub.api.IQzoneReq;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MSFServlet;
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
        if (paramQQAppInterface.length() > 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramQQAppInterface);
          localStringBuilder.append(":");
          localStringBuilder.append(paramInt);
          l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
        }
      }
    }
    return l1;
  }
  
  private void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report resultCode:");
    localStringBuilder.append(paramInt);
    QLog.e("CliNotifyPush", 1, localStringBuilder.toString());
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
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramQQAppInterface);
        localStringBuilder.append(":");
        localStringBuilder.append(paramInt);
        localEditor.putLong(localStringBuilder.toString(), paramLong);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleQQCirclePush ");
    ((StringBuilder)localObject).append(paramQQAppInterface.isBackgroundPause);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramQQAppInterface.isBackgroundStop);
    QLog.i("CliNotifyPush", 1, ((StringBuilder)localObject).toString());
    if ((paramQQAppInterface.isBackgroundPause) && (paramQQAppInterface.isBackgroundStop))
    {
      localObject = (IRedTouchServer)paramQQAppInterface.getRuntimeService(IRedTouchServer.class, "");
      QLog.i("CliNotifyPush", 1, "handleQQCirclePush sendRedpointReq");
      ((IRedTouchServer)localObject).sendRedpointReq(true, false, 6);
    }
    localObject = new Intent();
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
    int i;
    try
    {
      i = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("VideoCirclePushMergeType"));
    }
    catch (Exception localException)
    {
      QLog.e("CliNotifyPush", 1, localException, new Object[0]);
      i = 0;
    }
    if (paramQQAppInterface.isBackgroundPause)
    {
      MsgNotification.getInstance().showQZoneMsgNotification(paramQQAppInterface, 1, str3, (String)localObject, str5, str6, paramQQAppInterface.isShowMsgContent(), 366, str2, str1, true, "1".equals(str4), i);
      a(paramSinglePushMsg, paramQQAppInterface, 4L);
      QLog.e("CliNotifyPush", 1, "show push: XXX");
      return;
    }
    MsgNotification.getInstance().updateUnreadcount(366, i);
    a(paramSinglePushMsg, paramQQAppInterface, 32L);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      QLog.e("CliNotifyPush", 1, "processMiniAppRedDotPush, data is null.");
      return;
    }
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
      paramMap = new StringBuilder();
      paramMap.append("processMiniAppRedDotPush, exception: ");
      paramMap.append(paramQQAppInterface.toString());
      QLog.e("CliNotifyPush", 1, paramMap.toString());
    }
  }
  
  private void a(SinglePushMsg paramSinglePushMsg)
  {
    QLog.e("CliNotifyPush", 1, "dispathQzonePushMsg()");
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface == null) {
      return;
    }
    if (paramSinglePushMsg != null)
    {
      if (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap == null) {
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
  }
  
  public static void a(SinglePushMsg paramSinglePushMsg, QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramSinglePushMsg == null) {
      return;
    }
    long l1;
    if (paramQQAppInterface != null) {
      l1 = Long.parseLong(paramQQAppInterface.getAccount());
    } else {
      l1 = 0L;
    }
    long l2 = paramLong;
    if (paramSinglePushMsg.jdField_a_of_type_Long != 0L)
    {
      l2 = paramLong;
      if (l1 != 0L)
      {
        if (paramSinglePushMsg.jdField_b_of_type_Boolean) {
          paramLong |= 1L;
        } else {
          paramLong &= 0xFFFFFFFE;
        }
        String str = paramSinglePushMsg.jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(str))
        {
          paramQQAppInterface = str;
          if (!str.equals("0")) {}
        }
        else
        {
          paramQQAppInterface = str;
          if (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap != null) {
            paramQQAppInterface = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushstatkey");
          }
        }
        ((IQzoneReq)QRoute.api(IQzoneReq.class)).sentPushAckServlet(paramSinglePushMsg.jdField_a_of_type_Long, l1, paramQQAppInterface, paramLong);
        l2 = paramLong;
      }
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("sentQzoneMsfPushAck: localTimeStamp=");
    paramQQAppInterface.append(paramSinglePushMsg.jdField_a_of_type_Long);
    paramQQAppInterface.append(" uin=");
    paramQQAppInterface.append(l1);
    paramQQAppInterface.append(" flag=");
    paramQQAppInterface.append(l2);
    QLog.e("CliNotifyPush", 1, paramQQAppInterface.toString());
  }
  
  private void a(SinglePushMsg paramSinglePushMsg, boolean paramBoolean)
  {
    Object localObject1;
    QZoneManagerImp localQZoneManagerImp;
    if ((paramSinglePushMsg != null) && (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap != null))
    {
      localObject1 = (QQAppInterface)getAppRuntime();
      if (localObject1 == null)
      {
        QLog.e("CliNotifyPush", 1, "showRedTouch failed app=null");
        return;
      }
      localQZoneManagerImp = (QZoneManagerImp)((QQAppInterface)localObject1).getManager(QQManagerFactory.QZONE_MANAGER);
      if (localQZoneManagerImp == null) {
        return;
      }
    }
    try
    {
      k = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showRedTouch type:");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(",uin:");
      ((StringBuilder)localObject2).append(paramSinglePushMsg.jdField_b_of_type_Long);
      ((StringBuilder)localObject2).append(",isBackground_Pause:");
      ((StringBuilder)localObject2).append(((QQAppInterface)localObject1).isBackgroundPause);
      QLog.i("CliNotifyPush", 1, ((StringBuilder)localObject2).toString());
      if ((k == 1) || (k == 300) || (k == 302))
      {
        localObject1 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("conent");
        m = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("count"));
        l = paramSinglePushMsg.jdField_b_of_type_Long;
      }
    }
    catch (Exception paramSinglePushMsg)
    {
      int k;
      Object localObject2;
      int m;
      long l;
      boolean bool;
      int i;
      int j;
      label262:
      Object localObject3;
      Object localObject4;
      break label690;
    }
    try
    {
      bool = paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.containsKey("opuin_qzoneVipLevel");
      if (!bool) {}
    }
    catch (Exception localException1)
    {
      break label276;
    }
    try
    {
      i = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("opuin_qzoneVipLevel"));
      j = 1;
    }
    catch (Exception localException2)
    {
      break label262;
      break label398;
    }
    j = 1;
    break label279;
    i = 0;
    j = 0;
    break label290;
    label276:
    j = 0;
    label279:
    QLog.i("CliNotifyPush", 2, "parse vip level error");
    i = 0;
    label290:
    localObject2 = new ArrayList();
    localObject3 = new QZoneCountUserInfo();
    ((QZoneCountUserInfo)localObject3).uin = l;
    ((QZoneCountUserInfo)localObject3).iYellowLevel = i;
    ((QZoneCountUserInfo)localObject3).iYellowType = j;
    paramSinglePushMsg.jdField_a_of_type_ArrayOfByte = JceUtils.inflateByte(paramSinglePushMsg.jdField_a_of_type_ArrayOfByte);
    if (paramSinglePushMsg.jdField_a_of_type_ArrayOfByte != null)
    {
      localObject4 = (PassiveFeedsPush)JceUtils.decodeWup(PassiveFeedsPush.class, paramSinglePushMsg.jdField_a_of_type_ArrayOfByte);
      if ((localObject4 != null) && (((PassiveFeedsPush)localObject4).stBubbleSkin != null))
      {
        if (((PassiveFeedsPush)localObject4).stBubbleSkin.lUin == l) {
          ((QZoneCountUserInfo)localObject3).pushData = ((PassiveFeedsPush)localObject4);
        }
        label398:
        ((ArrayList)localObject2).add(localObject3);
        localObject3 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("shcemaUrlAnd");
        try
        {
          paramSinglePushMsg = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("psv_tab_textlist");
          if (!TextUtils.isEmpty(paramSinglePushMsg))
          {
            paramSinglePushMsg = new JSONObject(paramSinglePushMsg);
            paramSinglePushMsg.getJSONObject("psv_tab_list");
            paramSinglePushMsg = paramSinglePushMsg.getJSONObject("psv_tab_list").getJSONArray("text_data");
            i = 0;
            while (i < paramSinglePushMsg.length())
            {
              Object localObject5 = (JSONObject)paramSinglePushMsg.get(i);
              l = ((JSONObject)localObject5).getLong("uin");
              localObject4 = ((JSONObject)localObject5).getString("nk");
              localObject5 = new feed_info(0L, 0L, 0L, ((JSONObject)localObject5).getString("text"));
              QZoneCountUserInfo localQZoneCountUserInfo = new QZoneCountUserInfo();
              localQZoneCountUserInfo.nickName = ((String)localObject4);
              localQZoneCountUserInfo.uin = l;
              localObject4 = new ArrayList();
              ((ArrayList)localObject4).add(localObject5);
              localQZoneCountUserInfo.vec_feedInfos = ((ArrayList)localObject4);
              ((ArrayList)localObject2).add(localQZoneCountUserInfo);
              i += 1;
            }
          }
          QLog.e("CliNotifyPush", 1, "showRedTouch failed");
        }
        catch (Exception paramSinglePushMsg)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("psv_tab_textlist failed");
          ((StringBuilder)localObject4).append(paramSinglePushMsg);
          QLog.e("CliNotifyPush", 1, ((StringBuilder)localObject4).toString());
          if ((k == 302) && (!TextUtils.isEmpty((CharSequence)localObject3)))
          {
            localQZoneManagerImp.a(1, m, (ArrayList)localObject2, (String)localObject1, paramBoolean, true, (String)localObject3);
            return;
          }
          localQZoneManagerImp.a(1, m, (ArrayList)localObject2, (String)localObject1, paramBoolean, true, "");
          return;
        }
        label690:
        return;
        QLog.e("CliNotifyPush", 1, "showRedTouch failed sm=null");
        return;
      }
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
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
        return;
      }
      try
      {
        ((IQzoneMixApi)QRoute.api(IQzoneMixApi.class)).execCtrlCommand(paramString, Integer.parseInt((String)paramMap.get("key_ctrl_cmd")), paramMap);
        return;
      }
      catch (Exception paramMap)
      {
        paramMap.printStackTrace();
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label19:
      break label19;
    }
    catch (Exception paramContext) {}
    paramContext = null;
    return paramContext != null;
    return false;
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramInt == 10000) {
      return false;
    }
    if ((8 != paramInt) && (4 != paramInt))
    {
      if (366 == paramInt) {
        return true;
      }
      if (paramInt == 2) {
        return true;
      }
      if ((paramInt != 1) && (paramInt != 300)) {
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQAppInterface.getApp().getApplicationContext().getString(2131718396));
      localStringBuilder.append(paramQQAppInterface.getAccount());
      return LocalMultiProcConfig.getBool(localStringBuilder.toString(), true);
    }
    return true;
  }
  
  private boolean a(SinglePushMsg paramSinglePushMsg)
  {
    int j = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int i = 0;
    QzNotificationStruct localQzNotificationStruct;
    if (j == 301) {
      if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.size() > 0))
      {
        localObject = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("live_roomid");
        if (localObject != null)
        {
          localQzNotificationStruct = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
          if ((localQzNotificationStruct != null) && (((String)localObject).equals(localQzNotificationStruct.roomId)))
          {
            jdField_a_of_type_JavaUtilList.remove(localQzNotificationStruct);
            if (jdField_a_of_type_JavaUtilList.size() != 0) {}
          }
        }
      }
    }
    try
    {
      localObject = QQNotificationManager.getInstance();
      if (localObject == null) {
        break label322;
      }
      ((QQNotificationManager)localObject).cancel("CliNotifyPush.clearLivePush", 242);
    }
    catch (Exception localException)
    {
      label163:
      break label163;
    }
    QLog.e("CliNotifyPush", 1, "NotificationManager cancel exception");
    break label322;
    Object localObject = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(jdField_a_of_type_JavaUtilList.size() - 1);
    if (localObject != null)
    {
      MsgNotification.getInstance().showQZoneMsgNotification(localQQAppInterface, 0, null, ((QzNotificationStruct)localObject).notifyText, null, null, ((QzNotificationStruct)localObject).showMsgContent, ((QzNotificationStruct)localObject).pushType, ((QzNotificationStruct)localObject).actionUrl, ((QzNotificationStruct)localObject).pushstatkey, false, false, -1);
      break label322;
      if (jdField_a_of_type_JavaUtilList.size() > 1) {
        while (i < jdField_a_of_type_JavaUtilList.size() - 1)
        {
          localQzNotificationStruct = (QzNotificationStruct)jdField_a_of_type_JavaUtilList.get(i);
          if ((localQzNotificationStruct != null) && (((String)localObject).equals(localQzNotificationStruct.roomId))) {
            jdField_a_of_type_JavaUtilList.remove(localQzNotificationStruct);
          }
          i += 1;
        }
      }
    }
    label322:
    a(paramSinglePushMsg, localQQAppInterface, 16L);
    return true;
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
    if ((paramSinglePushMsg.jdField_a_of_type_Boolean) && (paramSinglePushMsg.jdField_a_of_type_Int == 0))
    {
      paramSinglePushMsg.jdField_a_of_type_Int += 1;
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)getAppRuntime();
    int m = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushtype"));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pushType:");
    ((StringBuilder)localObject).append(m);
    QLog.e("CliNotifyPush", 1, ((StringBuilder)localObject).toString());
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
    if (a(paramSinglePushMsg)) {
      return;
    }
    if (m == 100)
    {
      a(paramSinglePushMsg, localQQAppInterface, 16L);
      return;
    }
    localObject = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("conent");
    String str1 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("pushstatkey");
    String str2 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("shcemaUrlAnd");
    String str3 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("title");
    String str4 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("fake_push");
    String str5 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("icon_type");
    String str6 = (String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("icon_url");
    if (QLog.isColorLevel()) {
      QLog.d("CliNotifyPush", 2, new Object[] { "showPush: invoked. ", " iconType: ", str5, " title: ", str3, " message: ", localObject });
    }
    long l = paramSinglePushMsg.jdField_b_of_type_Long;
    StringBuilder localStringBuilder;
    if (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("count") != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showPush receive push time:");
      localStringBuilder.append(paramSinglePushMsg.jdField_a_of_type_Long);
      localStringBuilder.append(",unreadCount=");
      localStringBuilder.append(1);
      localStringBuilder.append(",uin=");
      localStringBuilder.append(l);
      localStringBuilder.append(",type=");
      localStringBuilder.append(m);
      QLog.i("CliNotifyPush", 1, localStringBuilder.toString());
    }
    try
    {
      i = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("count"));
      j = i;
      if (i >= 1) {
        break label527;
      }
    }
    catch (Exception localException1)
    {
      int i;
      int j;
      label525:
      break label525;
    }
    j = 1;
    try
    {
      label527:
      i = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("CtrlFlag"));
    }
    catch (Exception localException2)
    {
      label549:
      int k;
      boolean bool1;
      break label549;
    }
    i = 0;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qzone redtypeinfo:receive push time:");
      localStringBuilder.append(paramSinglePushMsg.jdField_a_of_type_Long);
      localStringBuilder.append("=unreadCount=");
      localStringBuilder.append(j);
      localStringBuilder.append("=uin=");
      localStringBuilder.append(l);
      localStringBuilder.append("=type=");
      localStringBuilder.append(m);
      localStringBuilder.append("=CtrlFlag=");
      localStringBuilder.append(i);
      localStringBuilder.append("=message=");
      localStringBuilder.append((String)localObject);
      QLog.i("CliNotifyPush", 2, localStringBuilder.toString());
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("qzone redtypeinfo:receive push time:");
      localStringBuilder.append(paramSinglePushMsg.jdField_a_of_type_Long);
      localStringBuilder.append("=unreadCount=");
      localStringBuilder.append(j);
      localStringBuilder.append("=uin=");
      localStringBuilder.append(l);
      localStringBuilder.append("=type=");
      localStringBuilder.append(m);
      localStringBuilder.append("=CtrlFlag=");
      localStringBuilder.append(i);
      QLog.i("CliNotifyPush", 1, localStringBuilder.toString());
    }
    k = i;
    if (k == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a(paramSinglePushMsg, bool1);
    try
    {
      i = Integer.parseInt((String)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("show_level"));
    }
    catch (Exception localException3)
    {
      label834:
      boolean bool2;
      break label834;
    }
    i = 4;
    if ((!localQQAppInterface.isBackgroundPause) && (!a(i, 1)))
    {
      a(paramSinglePushMsg, localQQAppInterface, 32L);
      return;
    }
    if (!a(localQQAppInterface, m))
    {
      a(paramSinglePushMsg, localQQAppInterface, 16L);
      return;
    }
    if (k == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("not show push, existDL = ");
      ((StringBuilder)localObject).append(k);
      QLog.e("CliNotifyPush", 1, ((StringBuilder)localObject).toString());
      a(paramSinglePushMsg, localQQAppInterface, 128L);
      return;
    }
    if ((!QQUtils.a(localQQAppInterface.getApp())) && (a(localQQAppInterface)) && (!a(i, 0)))
    {
      a(paramSinglePushMsg, localQQAppInterface, 64L);
      return;
    }
    if (!QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext()))
    {
      a(paramSinglePushMsg, localQQAppInterface, 512L);
      return;
    }
    if (localObject != null)
    {
      bool2 = localQQAppInterface.isShowMsgContent();
      if (!bool2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localQQAppInterface.getApp().getApplicationContext().getString(2131717546));
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(localQQAppInterface.getApp().getApplicationContext().getString(2131717547));
        localObject = ((StringBuilder)localObject).toString();
      }
      if ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap != null) && (paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("daemonShow") != null)) {
        bool1 = "1".equals(paramSinglePushMsg.jdField_a_of_type_JavaUtilMap.get("daemonShow"));
      } else {
        bool1 = true;
      }
      if (bool1)
      {
        MsgNotification.getInstance().showQZoneMsgNotification(localQQAppInterface, 1, str3, (String)localObject, str5, str6, bool2, m, str2, str1, true, "1".equals(str4), -1);
        a(paramSinglePushMsg, localQQAppInterface, 4L);
      }
      QLog.e("CliNotifyPush", 1, "show push: XXX");
      return;
    }
    a(paramSinglePushMsg, localQQAppInterface, 256L);
  }
  
  private void b(Map<String, String> paramMap, String paramString)
  {
    if (paramMap != null)
    {
      if (paramMap.isEmpty()) {
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
    } else if ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap != null) && ((paramSinglePushMsg.jdField_a_of_type_JavaUtilMap instanceof HashMap))) {
      localIntent.putExtra("update_feeds", (HashMap)paramSinglePushMsg.jdField_a_of_type_JavaUtilMap);
    }
    BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  public Map<Integer, SinglePushMsg> a(FromServiceMsg paramFromServiceMsg)
  {
    Object localObject2 = this;
    String str = "CliNotifyPush";
    QLog.e("CliNotifyPush", 1, "decodeQzonePushMsgs()");
    QQAppInterface localQQAppInterface1 = (QQAppInterface)getAppRuntime();
    if (localQQAppInterface1 == null) {
      return null;
    }
    Object localObject1 = paramFromServiceMsg.getWupBuffer();
    System.arraycopy(localObject1, 4, localObject1, 0, localObject1.length - 4);
    paramFromServiceMsg = new PushInfo();
    localObject1 = new JceInputStream((byte[])localObject1);
    ((JceInputStream)localObject1).setServerEncoding("utf-8");
    paramFromServiceMsg.readFrom((JceInputStream)localObject1);
    Object localObject3 = paramFromServiceMsg.vecMsg;
    localObject1 = new HashMap();
    long l2 = a(localQQAppInterface1);
    localObject3 = ((ArrayList)localObject3).iterator();
    long l1 = l2;
    label1214:
    while (((Iterator)localObject3).hasNext())
    {
      SingleMsg localSingleMsg = (SingleMsg)((Iterator)localObject3).next();
      int i;
      QQAppInterface localQQAppInterface2;
      long l3;
      Object localObject5;
      if (localSingleMsg != null)
      {
        long l4;
        for (;;)
        {
          if (localSingleMsg.data.containsKey("pushtype")) {
            i = Integer.parseInt((String)localSingleMsg.data.get("pushtype"));
          } else if (localSingleMsg.data.containsKey("type")) {
            i = Integer.parseInt((String)localSingleMsg.data.get("type"));
          } else {
            i = 0;
          }
          if ((i != 1) && (i != 2) && (i != 4) && (i != 301) && (i != 8) && (i != 300) && (i != 10000) && (i != 10100) && (i != 302) && (i != 350) && (i != 100) && (i != 366))
          {
            if (i == 7066) {
              ((CliNotifyPush)localObject2).a(localSingleMsg.data);
            }
            for (;;)
            {
              break;
              if (i == 200) {
                ((CliNotifyPush)localObject2).a(localQQAppInterface1, localSingleMsg.data);
              } else if (i == 699) {
                ((CliNotifyPush)localObject2).a(localSingleMsg);
              } else {
                a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface1, 256L);
              }
            }
            break label1214;
          }
          localQQAppInterface2 = localQQAppInterface1;
          l4 = a(localQQAppInterface2, i);
          if (QzoneConfig.getInstance().getConfig("QZoneSetting", "PushDeduplication", 1) == 1)
          {
            if (localSingleMsg.addTime > l4) {
              break;
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("PushDeduplication: localTimeStap:");
            ((StringBuilder)localObject4).append(l4);
            ((StringBuilder)localObject4).append(" newTimeStap:");
            ((StringBuilder)localObject4).append(localSingleMsg.addTime);
            ((StringBuilder)localObject4).append(" msg:");
            ((StringBuilder)localObject4).append((String)localSingleMsg.data.get("conent"));
            QLog.e(str, 1, ((StringBuilder)localObject4).toString());
            a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface2, 8L);
            ((CliNotifyPush)localObject2).a(2014);
          }
          else
          {
            if (localSingleMsg.addTime >= l4) {
              break;
            }
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("PushDeduplication: localTimeStap:");
            ((StringBuilder)localObject4).append(l4);
            ((StringBuilder)localObject4).append(" newTimeStap:");
            ((StringBuilder)localObject4).append(localSingleMsg.addTime);
            ((StringBuilder)localObject4).append(" msg:");
            ((StringBuilder)localObject4).append((String)localSingleMsg.data.get("conent"));
            QLog.e(str, 1, ((StringBuilder)localObject4).toString());
            a(new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark), localQQAppInterface2, 8L);
            ((CliNotifyPush)localObject2).a(2014);
          }
        }
        l3 = l1;
        localObject5 = localObject1;
        if (((Map)localObject5).containsKey(Integer.valueOf(i)))
        {
          localObject4 = (SinglePushMsg)((Map)localObject5).get(Integer.valueOf(i));
          if (localObject4 != null) {
            if (((SinglePushMsg)localObject4).jdField_a_of_type_Long < localSingleMsg.addTime)
            {
              localObject2 = new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark, localSingleMsg.extBuffer);
              if (i != 366) {
                ((Map)localObject5).put(Integer.valueOf(i), localObject2);
              }
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("PushDeduplication: msg localTimeStap:");
              ((StringBuilder)localObject5).append(localSingleMsg.addTime);
              ((StringBuilder)localObject5).append(" sm newTimeStap:");
              ((StringBuilder)localObject5).append(((SinglePushMsg)localObject4).jdField_a_of_type_Long);
              ((StringBuilder)localObject5).append(" msg:");
              ((StringBuilder)localObject5).append((String)((SinglePushMsg)localObject4).jdField_a_of_type_JavaUtilMap.get("conent"));
              QLog.e(str, 1, ((StringBuilder)localObject5).toString());
              a((SinglePushMsg)localObject4, localQQAppInterface2, 8L);
              localObject4 = paramFromServiceMsg;
              break label1148;
            }
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("PushDeduplication: localTimeStap:");
          ((StringBuilder)localObject2).append(l4);
          ((StringBuilder)localObject2).append(" newTimeStap:");
          ((StringBuilder)localObject2).append(localSingleMsg.addTime);
          ((StringBuilder)localObject2).append(" msg:");
          ((StringBuilder)localObject2).append((String)localSingleMsg.data.get("conent"));
          QLog.e(str, 1, ((StringBuilder)localObject2).toString());
          l3 = localSingleMsg.addTime;
          localObject2 = localSingleMsg.data;
          l4 = localSingleMsg.opUin;
          a(new SinglePushMsg(l3, (Map)localObject2, l4, paramFromServiceMsg.Mark), localQQAppInterface2, 8L);
        }
      }
      else
      {
        localObject2 = this;
        continue;
      }
      SinglePushMsg localSinglePushMsg = new SinglePushMsg(localSingleMsg.addTime, localSingleMsg.data, localSingleMsg.opUin, paramFromServiceMsg.Mark, localSingleMsg.extBuffer);
      localObject2 = localSinglePushMsg;
      Object localObject4 = paramFromServiceMsg;
      if (i != 366)
      {
        ((Map)localObject5).put(Integer.valueOf(i), localSinglePushMsg);
        localObject4 = paramFromServiceMsg;
        localObject2 = localSinglePushMsg;
      }
      label1148:
      a(localQQAppInterface2, i, localSingleMsg.addTime);
      if (l3 < localSingleMsg.addTime) {
        l1 = localSingleMsg.addTime;
      } else {
        l1 = l3;
      }
      if (i == 366)
      {
        paramFromServiceMsg = this;
        paramFromServiceMsg.a(localQQAppInterface2, (SinglePushMsg)localObject2);
        localObject2 = paramFromServiceMsg;
        paramFromServiceMsg = (FromServiceMsg)localObject4;
      }
      else
      {
        localObject2 = this;
        paramFromServiceMsg = (FromServiceMsg)localObject4;
      }
    }
    if (l2 < l1) {
      a(localQQAppInterface1, l1);
    }
    return localObject1;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if ((1 << paramInt2 & paramInt1) == 0) {
      bool = false;
    }
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkForegroundShowEnabled showLevel: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",result: ");
      localStringBuilder.append(bool);
      QZLog.i("CliNotifyPush", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = ((ActivityManager)paramQQAppInterface.getApp().getSystemService("activity")).getRunningTasks(1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (paramQQAppInterface.size() > 0)
      {
        paramQQAppInterface = ((ActivityManager.RunningTaskInfo)paramQQAppInterface.get(0)).topActivity.getClassName();
        if ((!"cooperation.qzone.QzoneGPUPluginProxyActivity".equals(paramQQAppInterface)) && (!"cooperation.qzone.QzonePluginProxyActivity".equals(paramQQAppInterface)))
        {
          bool1 = bool2;
          if (!"cooperation.qzone.QzoneFeedsPluginProxyActivity".equals(paramQQAppInterface)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public String[] getPreferSSOCommands()
  {
    return jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    RemoteHandleManager.getInstance().addWebEventListener(this);
  }
  
  protected void onDestroy()
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
      return;
    }
    if ((paramFromServiceMsg.getServiceCmd().equals("MessageSvc.WNSQzone")) && (paramFromServiceMsg.isSuccess()))
    {
      QLog.e("CliNotifyPush", 1, "get qzone push begin");
      paramIntent = a(paramFromServiceMsg);
      if (paramIntent != null) {
        paramIntent = paramIntent.values().iterator();
      }
    }
    else
    {
      while (paramIntent.hasNext())
      {
        a((SinglePushMsg)paramIntent.next());
        continue;
        QLog.e("CliNotifyPush", 1, "get qzone push error");
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramString.equals("cmd.pre.getpassivefeeds")) && (paramBundle != null))
    {
      if (!paramBundle.containsKey("data")) {
        return;
      }
      paramString = paramBundle.getBundle("data");
      int i = paramString.getInt("param.preget_seqid");
      paramString = Long.valueOf(paramString.getLong("param.preget_undealcount", -1L));
      if (jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)) != null)
      {
        paramBundle = (SinglePushMsg)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
        if (paramString.longValue() != -1L)
        {
          paramBundle = paramBundle.jdField_a_of_type_JavaUtilMap;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append("");
          paramBundle.put("count", localStringBuilder.toString());
        }
        paramBundle = new StringBuilder();
        paramBundle.append("onWebEvent showPush count:");
        paramBundle.append(paramString);
        QLog.e("CliNotifyPush", 1, paramBundle.toString());
        b((SinglePushMsg)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.CliNotifyPush
 * JD-Core Version:    0.7.0.1
 */