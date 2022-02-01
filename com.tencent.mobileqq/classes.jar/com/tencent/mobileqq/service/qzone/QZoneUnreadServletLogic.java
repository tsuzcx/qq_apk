package com.tencent.mobileqq.service.qzone;

import BOSSStrategyCenter.tAdvDesc;
import NS_QBOSS_GATEWAY_PROTO.QbossGateWayRsp;
import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.entrance_cfg;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.master_info;
import NS_UNDEAL_COUNT.mobile_count_req;
import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import NS_UNDEAL_COUNT.operat_data;
import NS_UNDEAL_COUNT.single_count;
import NS_UNDEAL_COUNT.stNuanNuanComment;
import NS_UNDEAL_COUNT.stPlusRecomInfo;
import NS_UNDEAL_COUNT.stVerticalVideoDisplay;
import NS_UNDEAL_COUNT.yellow_info;
import QZONE_OPERATION_ENTRANCE.EntranceRes;
import QZONE_OPERATION_ENTRANCE.OperEntranceInfo;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneMixApi;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.JceUtils;
import cooperation.qzone.util.PhotoUtils;
import cooperation.qzone.util.QZLog;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class QZoneUnreadServletLogic
{
  public static HashMap<Integer, HashMap<Integer, QZoneCountInfo>> a = new HashMap();
  
  public static int a(long paramLong)
  {
    int i = LocalMultiProcConfig.getInt4Uin("cancellation_status", 0, paramLong);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCancellationStatus:");
    localStringBuilder.append(i);
    QLog.d("UndealCount.QZoneUnreadServletLogic", 1, localStringBuilder.toString());
    return i;
  }
  
  public static List<Integer> a(Map<Integer, QZoneCountInfo> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(1));
    localArrayList.add(Integer.valueOf(2));
    localArrayList.add(Integer.valueOf(3));
    if ((paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.keySet();
      if (paramMap != null)
      {
        paramMap = paramMap.iterator();
        while (paramMap.hasNext())
        {
          Integer localInteger = (Integer)paramMap.next();
          if (localInteger.intValue() >= 1006) {
            localArrayList.add(localInteger);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static Map<Long, Long> a(Long paramLong)
  {
    localHashMap = new HashMap();
    paramLong = LocalMultiProcConfig.getString4Uin("getMapLastGetTime", "", paramLong.longValue());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getUdealCountLastGetTime: ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("UndealCount.QZoneUnreadServletLogic", 1, ((StringBuilder)localObject).toString());
    if (!TextUtils.isEmpty(paramLong))
    {
      paramLong = new JSONTokener(paramLong);
      try
      {
        paramLong = (JSONArray)paramLong.nextValue();
        int i = 0;
        while (i < paramLong.length())
        {
          localObject = paramLong.getJSONObject(i);
          localHashMap.put(Long.valueOf(((JSONObject)localObject).getLong("key")), Long.valueOf(((JSONObject)localObject).getLong("value")));
          i += 1;
        }
        return localHashMap;
      }
      catch (JSONException paramLong)
      {
        QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "getMapLastGetTime JSONException", paramLong);
      }
    }
  }
  
  public static void a(int paramInt1, int paramInt2, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        LocalMultiProcConfig.putInt4Uin("qzone_redpocket_plus_entry", paramInt1, Long.valueOf(paramQQAppInterface).longValue());
        LocalMultiProcConfig.putInt4Uin("qzone_redpocket_visitor_entry", paramInt2, Long.valueOf(paramQQAppInterface).longValue());
      }
    }
  }
  
  public static void a(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleCancellationStatus status:");
    localStringBuilder.append(paramInt);
    QLog.d("UndealCount.QZoneUnreadServletLogic", 1, localStringBuilder.toString());
    LocalMultiProcConfig.putInt4Uin("cancellation_status", paramInt, paramLong);
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        LocalMultiProcConfig.putInt4Uin("qzone_plus_live_show", paramInt, Long.valueOf(paramQQAppInterface).longValue());
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("saveFriendPlusLiveStatus:");
          paramQQAppInterface.append(paramInt);
          QLog.e("UndealCount.QZoneUnreadServletLogic", 2, paramQQAppInterface.toString());
        }
      }
    }
  }
  
  public static void a(int paramInt, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        LocalMultiProcConfig.putInt4Uin("creditlevel", paramInt, Long.valueOf(paramQQAppInterface).longValue());
        LocalMultiProcConfig.putString4Uin("creditmessage", paramString, Long.valueOf(paramQQAppInterface).longValue());
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("creditlevel:");
        paramQQAppInterface.append(paramInt);
        paramQQAppInterface.append(" message:");
        paramQQAppInterface.append(paramString);
        QLog.e("UndealCount.QZoneUnreadServletLogic", 1, paramQQAppInterface.toString());
      }
    }
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null) {
        LocalMultiProcConfig.putInt4Uin("qzone_jinyan", (int)(paramLong & 0x8000), Long.valueOf(paramQQAppInterface).longValue());
      }
    }
  }
  
  private static void a(count_info paramcount_info)
  {
    if (paramcount_info != null)
    {
      if (paramcount_info.vecUinList == null) {
        return;
      }
      QLog.i("UndealCount.QZoneUnreadServletLogic", 1, "recv Qzone Unread Push: Feed实时更新未读");
      Intent localIntent = new Intent("com.qzone.push_feed_unread");
      if (paramcount_info != null) {
        localIntent.putExtra("feeds_unread", paramcount_info);
      }
      BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
    }
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new)
  {
    if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.vec_soft_infos != null) && (parammobile_count_rsp_new.vec_soft_infos.size() != 0))
    {
      long l = System.currentTimeMillis();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get FeedSoft command, ");
      ((StringBuilder)localObject).append(parammobile_count_rsp_new.snnComment.iStatus);
      ((StringBuilder)localObject).append("timestamp ");
      ((StringBuilder)localObject).append(l);
      QLog.w("UndealCount.QZoneUnreadServletLogic", 1, ((StringBuilder)localObject).toString());
      parammobile_count_rsp_new = parammobile_count_rsp_new.vec_soft_infos;
      localObject = new JceOutputStream();
      ((JceOutputStream)localObject).setServerEncoding("utf8");
      ((JceOutputStream)localObject).write(parammobile_count_rsp_new, 1);
      LocalMultiProcConfig.putString("qzone_soft_infos", Base64Util.encodeToString(((JceOutputStream)localObject).toByteArray(), 0));
    }
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new, long paramLong)
  {
    if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.extendinfo != null) && (parammobile_count_rsp_new.extendinfo.containsKey(Integer.valueOf(1010))))
    {
      parammobile_count_rsp_new = (String)parammobile_count_rsp_new.extendinfo.get(Integer.valueOf(1010));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleRenZhenghaoInfo certified_puin:");
      localStringBuilder.append(parammobile_count_rsp_new);
      QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, localStringBuilder.toString());
      if (!TextUtils.isEmpty(parammobile_count_rsp_new))
      {
        LocalMultiProcConfig.putString4Uin("certified_puin", parammobile_count_rsp_new, paramLong);
        return;
      }
      LocalMultiProcConfig.putString4Uin("certified_puin", "0", paramLong);
    }
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new, QbossGateWayRsp paramQbossGateWayRsp, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new.mapExtendinfo != null) && ("CLEARALL".equalsIgnoreCase((String)parammobile_count_rsp_new.mapExtendinfo.get("appid_2586"))))
    {
      LocalMultiProcConfig.putString4Uin("friendheadmenudata", "", paramQQAppInterface.getLongAccountUin());
      QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "handleHeadMenuData:clearAll");
      return;
    }
    if ((paramQbossGateWayRsp.mapAdv != null) && (paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2586)) != null))
    {
      parammobile_count_rsp_new = (ArrayList)paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2586));
      if (parammobile_count_rsp_new.size() > 0)
      {
        paramQbossGateWayRsp = ((tAdvDesc)parammobile_count_rsp_new.get(0)).res_data;
        if (!TextUtils.isEmpty(paramQbossGateWayRsp))
        {
          parammobile_count_rsp_new = LocalMultiProcConfig.getString4Uin("friendheadmenudata", "", paramQQAppInterface.getLongAccountUin());
          if (!paramQbossGateWayRsp.equals(parammobile_count_rsp_new)) {
            LocalMultiProcConfig.putString4Uin("friendheadmenudata", paramQbossGateWayRsp, paramQQAppInterface.getLongAccountUin());
          }
          if (QLog.isColorLevel())
          {
            paramQbossGateWayRsp = new StringBuilder();
            paramQbossGateWayRsp.append("headDropMenuUrl:");
            paramQbossGateWayRsp.append(parammobile_count_rsp_new);
            QLog.i("UndealCount.QZoneUnreadServletLogic", 2, paramQbossGateWayRsp.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "headDropMenuUrl: null");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "advDescs.size() = 0");
      }
    }
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {
      return;
    }
    if (parammobile_count_rsp_new.stMasterInfo != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      a(parammobile_count_rsp_new.stMasterInfo.iLevel, parammobile_count_rsp_new.stMasterInfo.strMessage, paramQQAppInterface);
      a(parammobile_count_rsp_new.stMasterInfo.host_unimbitmap, paramQQAppInterface);
    }
  }
  
  private static void a(mobile_count_rsp_new parammobile_count_rsp_new, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    if (parammobile_count_rsp_new == null) {
      return;
    }
    if (paramQZoneNotifyServlet == null) {
      return;
    }
    if (parammobile_count_rsp_new.iNextTimeout > 0)
    {
      paramQZoneNotifyServlet.a = (parammobile_count_rsp_new.iNextTimeout * 1000L);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive getFeedInterval:");
        localStringBuilder.append(paramQZoneNotifyServlet.a);
        QLog.d("UndealCount.QZoneUnreadServletLogic", 2, localStringBuilder.toString());
      }
    }
    if (parammobile_count_rsp_new.switchTimeout > 0)
    {
      paramQZoneNotifyServlet.b = (parammobile_count_rsp_new.switchTimeout * 1000);
      if (QLog.isColorLevel())
      {
        parammobile_count_rsp_new = new StringBuilder();
        parammobile_count_rsp_new.append("onReceive getActiveAppInterval:");
        parammobile_count_rsp_new.append(paramQZoneNotifyServlet.b);
        QLog.d("UndealCount.QZoneUnreadServletLogic", 2, parammobile_count_rsp_new.toString());
      }
    }
  }
  
  public static void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, QQAppInterface paramQQAppInterface, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    paramIntent = paramFromServiceMsg.getWupBuffer();
    if (paramIntent == null) {
      return;
    }
    paramFromServiceMsg = QZoneFeedCountPackeger.a(paramIntent, paramQQAppInterface, "getUndealCount");
    if (paramFromServiceMsg == null) {
      return;
    }
    if (!(paramFromServiceMsg instanceof mobile_count_rsp_new)) {
      return;
    }
    paramFromServiceMsg = (mobile_count_rsp_new)paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "onResponseCMD_STRING_GET_UNDEAL_COUNT rsp has data");
    }
    a(paramFromServiceMsg.mapLastGetTime, Long.valueOf(paramQQAppInterface.getCurrentAccountUin()));
    QZoneManager localQZoneManager = (QZoneManager)paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    if (localQZoneManager != null) {
      localQZoneManager.b(0);
    }
    if ((paramFromServiceMsg.stMapCountInfo != null) && (paramFromServiceMsg.stMapCountInfo.get(Integer.valueOf(1)) != null)) {
      a((count_info)paramFromServiceMsg.stMapCountInfo.get(Integer.valueOf(1)));
    }
    LocalMultiProcConfig.putInt4Uin("qzone_preget_passive_open", paramFromServiceMsg.isPreLoad, paramQQAppInterface.getLongAccountUin());
    a(paramIntent, paramFromServiceMsg, paramQQAppInterface, paramQZoneNotifyServlet);
    d(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg, paramQZoneNotifyServlet);
    f(paramFromServiceMsg, paramQQAppInterface);
    e(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg.sqDyncFeedsJson, paramQZoneNotifyServlet);
    c(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg.isLiveShow, paramQQAppInterface);
    a(paramFromServiceMsg.isPlusRedBous, paramFromServiceMsg.isVistorRedBous, paramQQAppInterface);
    a(paramFromServiceMsg.strRedBousUrl, paramQQAppInterface);
    a(paramFromServiceMsg.vecOperateInfo, paramQQAppInterface.getCurrentAccountUin());
    d(paramFromServiceMsg.isSetMemorySeal, paramQQAppInterface);
    b(paramFromServiceMsg.grayOperateMask, paramQQAppInterface);
    c(paramFromServiceMsg.isGetActiveWeiShi, paramQQAppInterface);
    j(paramFromServiceMsg, paramQQAppInterface);
    b(paramFromServiceMsg, paramQQAppInterface.getLongAccountUin());
    a(paramFromServiceMsg);
    i(paramFromServiceMsg, paramQQAppInterface);
    b(paramFromServiceMsg);
    h(paramFromServiceMsg, paramQQAppInterface);
    b(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg, paramQQAppInterface.getLongAccountUin());
    g(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg.cancellation_status, paramQQAppInterface.getLongAccountUin());
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      long l = System.currentTimeMillis();
      HashMap localHashMap = new HashMap();
      StatisticCollector.getInstance(paramQQAppInterface.getApp()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "actQzoneUnread", true, l - QZoneNotifyServlet.c, 0L, localHashMap, "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, Long paramLong)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
    if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof QZoneManagerImp)))
    {
      HashMap localHashMap = (HashMap)a.get(Integer.valueOf(paramInt));
      a.remove(Integer.valueOf(paramInt));
      if ((localHashMap != null) && (!localHashMap.isEmpty()))
      {
        if ((paramLong.longValue() != -1L) && (localHashMap.get(Integer.valueOf(1)) != null))
        {
          QZoneCountInfo localQZoneCountInfo = (QZoneCountInfo)localHashMap.get(Integer.valueOf(1));
          localQZoneCountInfo.uCount = paramLong.longValue();
          localHashMap.put(Integer.valueOf(1), localQZoneCountInfo);
        }
        ((QZoneManagerImp)paramQQAppInterface).a(localHashMap);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, FromServiceMsg paramFromServiceMsg, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "inform QZONE_GET_UNREAD isSuccess false");
    }
    if (paramQZoneNotifyServlet != null) {
      paramQZoneNotifyServlet.notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
    }
    if (paramQQAppInterface != null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("|resultcode: ");
      paramIntent.append(paramFromServiceMsg.getResultCode());
      paramIntent.append("|reason: ");
      paramIntent.append(BaseMessageHandler.a(paramFromServiceMsg));
      paramIntent = paramIntent.toString();
      paramFromServiceMsg = new HashMap();
      paramFromServiceMsg.put("param_FailCode", String.valueOf(9311));
      paramFromServiceMsg.put("param_errorDesc", paramIntent);
      StatisticCollector.getInstance(paramQQAppInterface.getApp()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "actQzoneUnread", false, QZoneNotifyServlet.d - QZoneNotifyServlet.c, 0L, paramFromServiceMsg, "");
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "inform QZONE_GET_UNREAD isSuccess false");
    }
    if (paramQZoneNotifyServlet != null) {
      paramQZoneNotifyServlet.notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
    }
    if (paramQQAppInterface != null)
    {
      paramQZoneNotifyServlet = new StringBuilder();
      paramQZoneNotifyServlet.append("|wufbuf: ");
      paramQZoneNotifyServlet.append(HexUtil.bytes2HexStr(paramArrayOfByte));
      paramArrayOfByte = paramQZoneNotifyServlet.toString();
      paramQZoneNotifyServlet = new HashMap();
      paramQZoneNotifyServlet.put("param_FailCode", String.valueOf(9045));
      paramQZoneNotifyServlet.put("param_errorDesc", paramArrayOfByte);
      StatisticCollector.getInstance(paramQQAppInterface.getApp()).collectPerformance(paramQQAppInterface.getCurrentAccountUin(), "actQzoneUnread", false, QZoneNotifyServlet.d - QZoneNotifyServlet.c, 0L, paramQZoneNotifyServlet, "");
    }
  }
  
  public static void a(String paramString) {}
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        if (!TextUtils.isEmpty(paramString))
        {
          LocalMultiProcConfig.putString4Uin("qzone_redpocket_guide_comment_icon_url", paramString, Long.valueOf(paramQQAppInterface).longValue());
          return;
        }
        LocalMultiProcConfig.putString4Uin("qzone_redpocket_guide_comment_icon_url", "", Long.valueOf(paramQQAppInterface).longValue());
      }
    }
  }
  
  private static void a(String paramString, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramQZoneNotifyServlet != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("sqDyncFeedsJson", paramString);
      paramQZoneNotifyServlet.notifyObserver(null, 1003, true, localBundle, QZoneObserver.class);
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ACTPAGE_ATTACH");
      localStringBuilder.append(paramString1);
      LocalMultiProcConfig.putString(localStringBuilder.toString(), paramString2);
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("ACTPAGE_ATTACH");
    paramString2.append(paramString1);
    LocalMultiProcConfig.putString(paramString2.toString(), "");
  }
  
  public static void a(String paramString, ArrayList<String> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = StringUtil.listToString(paramArrayList, ",");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setKuolieHotTags uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" kuolieHotTags:");
      localStringBuilder.append(paramArrayList);
      QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("KUOLIE_HOTTAGS");
      localStringBuilder.append(paramString);
      LocalMultiProcConfig.putString(localStringBuilder.toString(), paramArrayList);
      return;
    }
    paramArrayList = new StringBuilder();
    paramArrayList.append("setKuolieHotTags uin:");
    paramArrayList.append(paramString);
    paramArrayList.append(" kuolieHotTags: empty");
    QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, paramArrayList.toString());
    paramArrayList = new StringBuilder();
    paramArrayList.append("KUOLIE_HOTTAGS");
    paramArrayList.append(paramString);
    LocalMultiProcConfig.putString(paramArrayList.toString(), "");
  }
  
  public static void a(String paramString, Map<Integer, String> paramMap)
  {
    paramMap = QzoneMapUtil.a(paramMap);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setExtendInfo uin:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" extend_info:");
    localStringBuilder.append(paramMap);
    QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("EXTEND_INFO");
    localStringBuilder.append(paramString);
    LocalMultiProcConfig.putString(localStringBuilder.toString(), paramMap);
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BANNER_INFO");
      localStringBuilder.append(paramString);
      LocalMultiProcConfig.putString(localStringBuilder.toString(), Base64.encodeToString(paramArrayOfByte, 2));
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("BANNER_INFO");
    paramArrayOfByte.append(paramString);
    LocalMultiProcConfig.putString(paramArrayOfByte.toString(), "");
  }
  
  public static void a(ArrayList<operat_data> paramArrayList, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "QZoneFeedCountPackeger execCmds");
    }
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        operat_data localoperat_data = (operat_data)paramArrayList.next();
        if (localoperat_data != null)
        {
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("QZoneFeedCountPackeger operat_data cmd: ");
            ((StringBuilder)localObject).append(localoperat_data.cmd);
            QLog.d("UndealCount.QZoneUnreadServletLogic", 4, ((StringBuilder)localObject).toString());
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("QZoneFeedCountPackeger operat_data desc: ");
            ((StringBuilder)localObject).append(localoperat_data.desc);
            QLog.d("UndealCount.QZoneUnreadServletLogic", 4, ((StringBuilder)localObject).toString());
          }
          Object localObject = new HashMap();
          if ((localoperat_data.mapExt != null) && (localoperat_data.mapExt.size() > 0)) {
            ((Map)localObject).putAll(localoperat_data.mapExt);
          }
          ((Map)localObject).put("key_desc", localoperat_data.desc);
          ((IQzoneMixApi)QRoute.api(IQzoneMixApi.class)).execCtrlCommand(paramString, localoperat_data.cmd, (Map)localObject);
        }
      }
    }
  }
  
  public static void a(Map<Long, Long> paramMap, Long paramLong)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 0) {
        return;
      }
      JSONArray localJSONArray = new JSONArray();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("key", localEntry.getKey());
          localJSONObject.put("value", localEntry.getValue());
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException paramMap)
        {
          QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "setMapLastGetTime JSONException", paramMap);
          return;
        }
      }
      if (localJSONArray.length() > 0)
      {
        paramMap = localJSONArray.toString();
        LocalMultiProcConfig.putString4Uin("getMapLastGetTime", paramMap, paramLong.longValue());
        paramLong = new StringBuilder();
        paramLong.append("setUdealCountLastGetTime: ");
        paramLong.append(paramMap);
        QLog.i("UndealCount.QZoneUnreadServletLogic", 1, paramLong.toString());
      }
    }
  }
  
  private static void a(JSONArray paramJSONArray, JSONObject paramJSONObject)
  {
    int j;
    int i;
    if ((paramJSONArray != null) && (paramJSONObject != null))
    {
      j = paramJSONArray.length();
      i = 0;
    }
    for (;;)
    {
      if (i < j) {}
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
        if (!localJSONObject.optString("priority", "0").equalsIgnoreCase(paramJSONObject.optString("priority", "0"))) {
          break label181;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("find one,oldData:");
        localStringBuilder.append(localJSONObject.toString());
        localStringBuilder.append(" ,newData:");
        localStringBuilder.append(paramJSONObject.toString());
        QLog.d("UndealCount.QZoneUnreadServletLogic", 1, localStringBuilder.toString());
        paramJSONArray.put(i, paramJSONObject);
        if (i != j) {
          break label180;
        }
        paramJSONArray.put(paramJSONObject);
        paramJSONArray = new StringBuilder();
        paramJSONArray.append("add newData:");
        paramJSONArray.append(paramJSONObject.toString());
        QLog.d("UndealCount.QZoneUnreadServletLogic", 2, paramJSONArray.toString());
        return;
      }
      catch (Throwable paramJSONArray)
      {
        label170:
        break label170;
      }
      QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "updateSurpriseData error:", paramJSONArray);
      label180:
      return;
      label181:
      i += 1;
    }
  }
  
  private static void a(byte[] paramArrayOfByte, mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    HashMap localHashMap = new HashMap();
    boolean bool = a(parammobile_count_rsp_new, localHashMap, paramQQAppInterface);
    int i;
    if (bool) {
      i = RemoteHandleManager.getInstance().getSender().pregetPassiveFeeds(paramQQAppInterface.getLongAccountUin());
    } else {
      i = 0;
    }
    if (localHashMap.size() != 0)
    {
      if (!bool)
      {
        if (paramQQAppInterface == null) {
          return;
        }
        paramArrayOfByte = paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof QZoneManagerImp)))
        {
          ((QZoneManagerImp)paramArrayOfByte).a(localHashMap);
          if (QLog.isColorLevel()) {
            QLog.d("Q.lebanew", 2, "qzone redtypeinfo:recive undealcount rsp");
          }
        }
      }
      else
      {
        a.put(Integer.valueOf(i), localHashMap);
      }
      a(paramQQAppInterface);
      return;
    }
    a(paramQQAppInterface, paramArrayOfByte, paramQZoneNotifyServlet);
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 21)
    {
      QZoneUnreadServletLogic.WMDConfig localWMDConfig = new QZoneUnreadServletLogic.WMDConfig();
      if (localWMDConfig.b())
      {
        if (paramInt == 2)
        {
          if (localWMDConfig.b > 0) {
            bool = true;
          }
          return bool;
        }
        if (localWMDConfig.c > 0) {
          return !localWMDConfig.a(paramString);
        }
      }
    }
    return false;
  }
  
  public static boolean a(entrance_cfg paramentrance_cfg1, entrance_cfg paramentrance_cfg2)
  {
    return (paramentrance_cfg1.iEntranceId == paramentrance_cfg2.iEntranceId) && (TextUtils.equals(paramentrance_cfg1.sEntranceAction, paramentrance_cfg2.sEntranceAction)) && (TextUtils.equals(paramentrance_cfg1.sEntranceName, paramentrance_cfg2.sEntranceName)) && (TextUtils.equals(paramentrance_cfg1.sEntranceIcon, paramentrance_cfg2.sEntranceIcon)) && (TextUtils.equals(paramentrance_cfg1.sQbossEntranceIcon, paramentrance_cfg2.sQbossEntranceIcon)) && (paramentrance_cfg1.isCanNotShowOnTeenagerMod == paramentrance_cfg2.isCanNotShowOnTeenagerMod);
  }
  
  public static boolean a(mobile_count_rsp_new parammobile_count_rsp_new, HashMap<Integer, QZoneCountInfo> paramHashMap, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "onResponse");
    }
    if (parammobile_count_rsp_new == null) {
      return false;
    }
    if ((parammobile_count_rsp_new.extendinfo != null) && (paramQQAppInterface != null)) {
      a(paramQQAppInterface.getCurrentUin(), parammobile_count_rsp_new.extendinfo);
    }
    if ((parammobile_count_rsp_new.mapTransData != null) && (paramQQAppInterface != null) && (parammobile_count_rsp_new.mapTransData.containsKey("unreadCountBanner"))) {
      a(paramQQAppInterface.getCurrentUin(), (byte[])parammobile_count_rsp_new.mapTransData.get("unreadCountBanner"));
    }
    if ((parammobile_count_rsp_new.mapTransData != null) && (paramQQAppInterface != null) && (parammobile_count_rsp_new.mapTransData.containsKey("frdBirthRecom"))) {
      b(paramQQAppInterface.getCurrentUin(), (byte[])parammobile_count_rsp_new.mapTransData.get("frdBirthRecom"));
    }
    if (parammobile_count_rsp_new.mapAutoTransData != null) {
      b(paramQQAppInterface.getCurrentUin(), parammobile_count_rsp_new.mapAutoTransData);
    }
    if (parammobile_count_rsp_new.stMapCountInfo == null) {
      return false;
    }
    if (parammobile_count_rsp_new.stMapCountInfo.size() == 0) {
      return false;
    }
    if (paramHashMap == null) {
      return false;
    }
    int i = 1;
    boolean bool1 = false;
    while (i < 1014)
    {
      count_info localcount_info = (count_info)parammobile_count_rsp_new.stMapCountInfo.get(Integer.valueOf(i));
      if (localcount_info != null)
      {
        QZoneCountInfo localQZoneCountInfo = new QZoneCountInfo();
        boolean bool2 = bool1;
        if (localcount_info.stCount != null)
        {
          localQZoneCountInfo.uCount = localcount_info.stCount.uCount;
          localQZoneCountInfo.iControl = localcount_info.stCount.iControl;
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onResponse unread cout: ");
            ((StringBuilder)localObject).append(localcount_info.stCount.uCount);
            ((StringBuilder)localObject).append("unread type: ");
            ((StringBuilder)localObject).append(i);
            QLog.d("UndealCount.QZoneUnreadServletLogic", 4, ((StringBuilder)localObject).toString());
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("qzone redtypeinfo:onResponse unread cout: ");
            ((StringBuilder)localObject).append(localcount_info.stCount.uCount);
            ((StringBuilder)localObject).append("unread type: ");
            ((StringBuilder)localObject).append(i);
            QLog.d("Q.lebanew", 2, ((StringBuilder)localObject).toString());
          }
          bool2 = bool1;
          if (i == 1)
          {
            bool2 = bool1;
            if (localQZoneCountInfo.uCount > 0L)
            {
              bool2 = bool1;
              if (paramQQAppInterface != null)
              {
                bool2 = bool1;
                if (parammobile_count_rsp_new.isPreLoad == 1)
                {
                  bool2 = bool1;
                  if (!TextUtils.isEmpty(parammobile_count_rsp_new.undealCountTime))
                  {
                    bool2 = bool1;
                    if (!LocalMultiProcConfig.getString4Uin("qzone_passive_undealtime", "", paramQQAppInterface.getLongAccountUin()).equals(parammobile_count_rsp_new.undealCountTime)) {
                      bool2 = true;
                    }
                  }
                }
              }
            }
          }
        }
        QZoneCountUserInfo localQZoneCountUserInfo = null;
        Object localObject = localQZoneCountUserInfo;
        if (parammobile_count_rsp_new.mapTransData != null)
        {
          byte[] arrayOfByte = (byte[])parammobile_count_rsp_new.mapTransData.get("PassiveFeedsPush");
          localObject = localQZoneCountUserInfo;
          if (arrayOfByte != null) {
            localObject = (PassiveFeedsPush)JceUtils.decodeWup(PassiveFeedsPush.class, arrayOfByte);
          }
        }
        if ((localcount_info.vecUinList != null) && (localcount_info.vecUinList.size() > 0))
        {
          int j = 0;
          while (j < localcount_info.vecUinList.size())
          {
            localQZoneCountUserInfo = new QZoneCountUserInfo();
            localQZoneCountUserInfo.uin = ((feed_host_info)localcount_info.vecUinList.get(j)).uUin;
            if (((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo != null)
            {
              localQZoneCountUserInfo.iYellowType = ((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo.iYellowType;
              localQZoneCountUserInfo.iYellowLevel = ((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo.iYellowLevel;
              localQZoneCountUserInfo.isAnnualVip = ((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo.isAnnualVip;
            }
            localQZoneCountUserInfo.vec_feedInfos = ((feed_host_info)localcount_info.vecUinList.get(j)).vec_feedInfos;
            localQZoneCountUserInfo.nickName = ((feed_host_info)localcount_info.vecUinList.get(j)).nickname;
            if ((localObject != null) && (((PassiveFeedsPush)localObject).stBubbleSkin != null) && (localQZoneCountUserInfo.uin == ((PassiveFeedsPush)localObject).stBubbleSkin.lUin)) {
              localQZoneCountUserInfo.pushData = ((PassiveFeedsPush)localObject);
            }
            localQZoneCountInfo.friendList.add(localQZoneCountUserInfo);
            j += 1;
          }
          j = i;
          localQZoneCountInfo.friendMsg = ((feed_host_info)localcount_info.vecUinList.get(0)).actiondesc;
          i = j;
          if (QLog.isDevelopLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onResponse unread list first uin: ");
            ((StringBuilder)localObject).append(((feed_host_info)localcount_info.vecUinList.get(0)).uUin);
            ((StringBuilder)localObject).append(",actiondesc: ");
            ((StringBuilder)localObject).append(((feed_host_info)localcount_info.vecUinList.get(0)).actiondesc);
            QLog.d("UndealCount.QZoneUnreadServletLogic", 4, ((StringBuilder)localObject).toString());
            i = j;
          }
        }
        localQZoneCountInfo.trace_info = localcount_info.trace_info;
        localQZoneCountInfo.countId = localcount_info.iSubCountID;
        localQZoneCountInfo.actPageAttach = localcount_info.actPageAttach;
        localQZoneCountInfo.strShowMsg = localcount_info.strShowMsg;
        localQZoneCountInfo.reportValue = localcount_info.strReportValue;
        localQZoneCountInfo.iconUrl = localcount_info.strIconUrl;
        localQZoneCountInfo.cTime = localcount_info.cTime;
        paramHashMap.put(Integer.valueOf(i), localQZoneCountInfo);
        bool1 = bool2;
      }
      i += 1;
    }
    return bool1;
  }
  
  private static boolean a(ArrayList<entrance_cfg> paramArrayList, entrance_cfg paramentrance_cfg)
  {
    if (paramArrayList == null) {
      return false;
    }
    if (paramentrance_cfg == null) {
      return false;
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      if (b(paramentrance_cfg, (entrance_cfg)paramArrayList.get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static byte[] a(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Map<Integer, count_info> paramMap, String paramString2, Map<Long, Long> paramMap1)
  {
    if (paramLong == 0L) {
      return null;
    }
    paramString1 = new mobile_count_req();
    paramString1.iRelationType = 1;
    paramString1.iVisitQZoneType = paramInt3;
    paramString1.mapTimeStamp = d(paramLong);
    paramString1.mapLastGetTime = a(Long.valueOf(paramLong));
    paramString1.stMapCountInfo = paramMap;
    paramString1.extendinfo = b(paramLong);
    paramString1.lastUndealCountTime = paramString2;
    paramString1.mapDyncShowTime = paramMap1;
    return QZoneFeedCountPackeger.a(paramString1, "getUndealCount", paramLong, paramInt1, paramInt2, paramInt4);
  }
  
  private static <T extends JceStruct> T b(Class<T> paramClass, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramClass = (JceStruct)paramClass.newInstance();
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf8");
      paramClass.readFrom(paramArrayOfByte);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Map<Integer, String> b(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getExtendInfo uin:");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" extend_info:");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EXTEND_INFO");
    localStringBuilder.append(paramLong);
    ((StringBuilder)localObject).append(LocalMultiProcConfig.getString(localStringBuilder.toString(), ""));
    QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("EXTEND_INFO");
    ((StringBuilder)localObject).append(paramLong);
    localObject = QzoneMapUtil.a(LocalMultiProcConfig.getString(((StringBuilder)localObject).toString(), ""));
    if (e(paramLong)) {
      ((Map)localObject).put(Integer.valueOf(1003), "0");
    }
    return localObject;
  }
  
  public static void b(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if (str != null)
      {
        LocalMultiProcConfig.putInt4Uin("qzone_feed_gray_mask", paramInt, Long.valueOf(str).longValue());
        PhotoUtils.clearNewPicRuleMapCache();
        paramQQAppInterface = (QZoneManager)paramQQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        boolean bool;
        if ((paramInt & 0x80) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramQQAppInterface.b(bool);
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("saveGrayOperate: ");
        paramQQAppInterface.append(paramInt);
        QLog.d("UndealCount.QZoneUnreadServletLogic", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  private static void b(mobile_count_rsp_new parammobile_count_rsp_new)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new QZoneUnreadServletLogic.2(parammobile_count_rsp_new));
  }
  
  public static void b(mobile_count_rsp_new parammobile_count_rsp_new, long paramLong)
  {
    if (parammobile_count_rsp_new == null) {
      return;
    }
    try
    {
      Object localObject = parammobile_count_rsp_new.snnComment;
      long l;
      if ((localObject != null) && (parammobile_count_rsp_new.snnComment.iStatus != 0) && (paramLong != -1L))
      {
        l = System.currentTimeMillis();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get dualwarm normal comment command, ");
        ((StringBuilder)localObject).append(parammobile_count_rsp_new.snnComment.iStatus);
        ((StringBuilder)localObject).append("timestamp ");
        ((StringBuilder)localObject).append(l);
        QLog.w("UndealCount.QZoneUnreadServletLogic", 1, ((StringBuilder)localObject).toString());
        localObject = parammobile_count_rsp_new.snnComment;
        JceOutputStream localJceOutputStream = new JceOutputStream();
        localJceOutputStream.setServerEncoding("utf8");
        ((stNuanNuanComment)localObject).writeTo(localJceOutputStream);
        LocalMultiProcConfig.putString4Uin("qzone_dual_warm_comment_info", Base64Util.encodeToString(localJceOutputStream.toByteArray(), 0), paramLong);
        LocalMultiProcConfig.putLong4Uin("qzone_dual_warm_comment_update_time", l, paramLong);
      }
      if ((parammobile_count_rsp_new.sContentOpComment != null) && (parammobile_count_rsp_new.sContentOpComment.iStatus != 0) && (paramLong != -1L))
      {
        l = System.currentTimeMillis();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get dualwarm operation comment command, ");
        ((StringBuilder)localObject).append(parammobile_count_rsp_new.sContentOpComment.iStatus);
        ((StringBuilder)localObject).append("timestamp ");
        ((StringBuilder)localObject).append(l);
        QLog.w("UndealCount.QZoneUnreadServletLogic", 1, ((StringBuilder)localObject).toString());
        parammobile_count_rsp_new = parammobile_count_rsp_new.sContentOpComment;
        localObject = new JceOutputStream();
        ((JceOutputStream)localObject).setServerEncoding("utf8");
        parammobile_count_rsp_new.writeTo((JceOutputStream)localObject);
        LocalMultiProcConfig.putString4Uin("qzone_dual_warm_operation_comment_info", Base64Util.encodeToString(((JceOutputStream)localObject).toByteArray(), 0), paramLong);
        return;
      }
    }
    catch (Exception parammobile_count_rsp_new)
    {
      QLog.e("UndealCount.QZoneUnreadServletLogic", 100, "save dual warm data failed", parammobile_count_rsp_new);
    }
  }
  
  public static void b(mobile_count_rsp_new parammobile_count_rsp_new, QbossGateWayRsp paramQbossGateWayRsp, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new.mapExtendinfo != null) && ("CLEARALL".equalsIgnoreCase((String)parammobile_count_rsp_new.mapExtendinfo.get("appid_2585"))))
    {
      LocalMultiProcConfig.putString4Uin("friendplusmenudata", "", paramQQAppInterface.getLongAccountUin());
      QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "handlePlusMenuData:clearAll");
      return;
    }
    if ((paramQbossGateWayRsp.mapAdv != null) && (paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2585)) != null))
    {
      parammobile_count_rsp_new = (ArrayList)paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2585));
      if (parammobile_count_rsp_new.size() > 0)
      {
        parammobile_count_rsp_new = ((tAdvDesc)parammobile_count_rsp_new.get(0)).res_data;
        if (!TextUtils.isEmpty(parammobile_count_rsp_new))
        {
          if (!parammobile_count_rsp_new.equals(LocalMultiProcConfig.getString4Uin("friendplusmenudata", "", paramQQAppInterface.getLongAccountUin()))) {
            LocalMultiProcConfig.putString4Uin("friendplusmenudata", parammobile_count_rsp_new, paramQQAppInterface.getLongAccountUin());
          }
          if (QLog.isColorLevel())
          {
            paramQbossGateWayRsp = new StringBuilder();
            paramQbossGateWayRsp.append("plusMenuData:");
            paramQbossGateWayRsp.append(parammobile_count_rsp_new);
            QLog.i("UndealCount.QZoneUnreadServletLogic", 2, paramQbossGateWayRsp.toString());
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "plusMenuData: null");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "handlePlusMenuData advDescs.size() = 0");
      }
    }
  }
  
  public static void b(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramQQAppInterface = new QZoneUnreadServletLogic.WMDConfig();
      paramQQAppInterface.a = parammobile_count_rsp_new.strABTestId;
      paramQQAppInterface.b = parammobile_count_rsp_new.operate_nbp_type;
      paramQQAppInterface.c = parammobile_count_rsp_new.report_sq_switch;
      paramQQAppInterface.d = parammobile_count_rsp_new.report_counts;
      paramQQAppInterface.e = parammobile_count_rsp_new.report_nexttime;
      paramQQAppInterface.f = parammobile_count_rsp_new.vec_blackReportPid;
      paramQQAppInterface.a();
    }
  }
  
  public static void b(String paramString, Map<String, byte[]> paramMap)
  {
    Object localObject;
    if ((paramMap != null) && (paramMap.size() != 0))
    {
      localObject = new HashMap();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        String str = Base64.encodeToString((byte[])localEntry.getValue(), 2);
        ((Map)localObject).put(localEntry.getKey(), str);
      }
    }
    try
    {
      paramMap = new JSONObject((Map)localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MAPAUTOTRANS_DATA");
      ((StringBuilder)localObject).append(paramString);
      LocalMultiProcConfig.putString(((StringBuilder)localObject).toString(), paramMap.toString());
      return;
    }
    catch (Exception paramString)
    {
      label131:
      break label131;
    }
    QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, "setMapAutoTransData failed, null keys exist in the map");
    return;
    paramMap = new StringBuilder();
    paramMap.append("MAPAUTOTRANS_DATA");
    paramMap.append(paramString);
    LocalMultiProcConfig.putString(paramMap.toString(), "");
  }
  
  public static void b(String paramString, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BIRTHRECOM_INFO");
      localStringBuilder.append(paramString);
      LocalMultiProcConfig.putString(localStringBuilder.toString(), Base64.encodeToString(paramArrayOfByte, 2));
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("BIRTHRECOM_INFO");
    paramArrayOfByte.append(paramString);
    LocalMultiProcConfig.putString(paramArrayOfByte.toString(), "");
  }
  
  private static boolean b(entrance_cfg paramentrance_cfg1, entrance_cfg paramentrance_cfg2)
  {
    if ((paramentrance_cfg1 == null) && (paramentrance_cfg2 == null)) {
      return true;
    }
    if (paramentrance_cfg1 == null) {
      return false;
    }
    if (paramentrance_cfg2 == null) {
      return false;
    }
    return a(paramentrance_cfg1, paramentrance_cfg2);
  }
  
  private static boolean b(ArrayList<entrance_cfg> paramArrayList1, ArrayList<entrance_cfg> paramArrayList2)
  {
    boolean bool = false;
    if (paramArrayList1 == null) {
      return false;
    }
    if (paramArrayList2 == null) {
      return false;
    }
    if (paramArrayList1.size() != paramArrayList2.size()) {
      return false;
    }
    if (paramArrayList1.size() == 0) {
      return false;
    }
    int j = 0;
    int i = 1;
    while (j < paramArrayList1.size())
    {
      entrance_cfg localentrance_cfg = (entrance_cfg)paramArrayList1.get(j);
      if ((i != 0) && (a(paramArrayList2, localentrance_cfg))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        return false;
      }
      j += 1;
    }
    if (j == paramArrayList1.size()) {
      bool = true;
    }
    return bool;
  }
  
  public static byte[] b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BANNER_INFO");
    localStringBuilder.append(paramString);
    return Base64.decode(LocalMultiProcConfig.getString(localStringBuilder.toString(), ""), 2);
  }
  
  public static void c(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null) {
        LocalMultiProcConfig.putInt4Uin("qzone_call_weishi", paramInt, Long.valueOf(paramQQAppInterface).longValue());
      }
    }
  }
  
  public static void c(mobile_count_rsp_new parammobile_count_rsp_new, QbossGateWayRsp paramQbossGateWayRsp, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new.mapExtendinfo != null) && ("CLEARALL".equalsIgnoreCase((String)parammobile_count_rsp_new.mapExtendinfo.get("appid_2595"))))
    {
      LocalMultiProcConfig.putString4Uin("surprise_config", "", paramQQAppInterface.getLongAccountUin());
      QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "handleSurpriseData:clearAll");
      return;
    }
    if ((paramQbossGateWayRsp.mapAdv != null) && (paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2595)) != null))
    {
      parammobile_count_rsp_new = LocalMultiProcConfig.getString4Uin("surprise_config", "", paramQQAppInterface.getLongAccountUin());
      if (TextUtils.isEmpty(parammobile_count_rsp_new)) {
        parammobile_count_rsp_new = new JSONArray();
      } else {
        try
        {
          parammobile_count_rsp_new = new JSONArray(parammobile_count_rsp_new);
        }
        catch (Exception localException)
        {
          parammobile_count_rsp_new = new JSONArray();
          QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "parse local advDesc.res_data error,catch an exception", localException);
        }
      }
      paramQbossGateWayRsp = ((ArrayList)paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2595))).iterator();
      while (paramQbossGateWayRsp.hasNext())
      {
        tAdvDesc localtAdvDesc = (tAdvDesc)paramQbossGateWayRsp.next();
        if (!TextUtils.isEmpty(localtAdvDesc.res_data)) {
          try
          {
            a(parammobile_count_rsp_new, new JSONObject(localtAdvDesc.res_data));
          }
          catch (Throwable localThrowable)
          {
            QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "parse advDesc.res_data error,catch an exception", localThrowable);
          }
        }
      }
      LocalMultiProcConfig.putString4Uin("surprise_config", parammobile_count_rsp_new.toString(), paramQQAppInterface.getLongAccountUin());
      paramQbossGateWayRsp = new StringBuilder();
      paramQbossGateWayRsp.append("all configs:");
      paramQbossGateWayRsp.append(parammobile_count_rsp_new.toString());
      QLog.d("UndealCount.QZoneUnreadServletLogic", 2, paramQbossGateWayRsp.toString());
    }
  }
  
  public static void c(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {
      return;
    }
    QbossGateWayRsp localQbossGateWayRsp = new QbossGateWayRsp();
    if (parammobile_count_rsp_new.mapTransData != null)
    {
      Object localObject = (byte[])parammobile_count_rsp_new.mapTransData.get("QbossAdv");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleSurpriseData:rsp.mapTransData != null,data == null ? ");
      boolean bool;
      if (localObject == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("UndealCount.QZoneUnreadServletLogic", 4, localStringBuilder.toString());
      if (localObject != null) {
        try
        {
          localObject = new JceInputStream((byte[])localObject);
          ((JceInputStream)localObject).setServerEncoding("utf-8");
          localQbossGateWayRsp.readFrom((JceInputStream)localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "handleSurpriseData error:", localThrowable);
        }
      }
    }
    else
    {
      QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "handleSurpriseData rsp.mapTransData: null");
    }
    c(parammobile_count_rsp_new, localQbossGateWayRsp, paramQQAppInterface);
    a(parammobile_count_rsp_new, localQbossGateWayRsp, paramQQAppInterface);
    b(parammobile_count_rsp_new, localQbossGateWayRsp, paramQQAppInterface);
  }
  
  public static byte[] c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BIRTHRECOM_INFO");
    localStringBuilder.append(paramString);
    return Base64.decode(LocalMultiProcConfig.getString(localStringBuilder.toString(), ""), 2);
  }
  
  public static String[] c(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("KUOLIE_HOTTAGS");
    ((StringBuilder)localObject).append(paramLong);
    localObject = LocalMultiProcConfig.getString(((StringBuilder)localObject).toString(), "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getKuolieHotTags uin:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" getKuolieHotTags:");
    localStringBuilder.append((String)localObject);
    QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return ((String)localObject).split(",");
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ACTPAGE_ATTACH");
    localStringBuilder.append(paramString);
    return LocalMultiProcConfig.getString(localStringBuilder.toString(), "");
  }
  
  public static Map<Integer, Long> d(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CTIME_MAP");
    ((StringBuilder)localObject).append(paramLong);
    localObject = f(LocalMultiProcConfig.getString(((StringBuilder)localObject).toString(), ""));
    Integer localInteger = Integer.valueOf(0);
    if (!((Map)localObject).containsKey(localInteger)) {
      ((Map)localObject).put(localInteger, Long.valueOf(0L));
    }
    return localObject;
  }
  
  private static void d(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveHasUserArchieveMemoryFlag:");
      String str;
      if (paramInt == 0) {
        str = "未使用过记忆封存";
      } else {
        str = "已经使用过记忆封存";
      }
      localStringBuilder.append(str);
      QLog.d("ArchiveMemorySettingGuide", 2, localStringBuilder.toString());
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null) {
        LocalMultiProcConfig.putInt4Uin("qzone_memory_seal_key", paramInt, Long.valueOf(paramQQAppInterface).longValue());
      }
    }
  }
  
  private static void d(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {
      return;
    }
    if (parammobile_count_rsp_new.stYellowInfo != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin())) {
        QZoneVipInfoManager.a().a(parammobile_count_rsp_new.stYellowInfo.iYellowType, parammobile_count_rsp_new.stYellowInfo.iYellowLevel, parammobile_count_rsp_new.stYellowInfo.isAnnualVip, parammobile_count_rsp_new.stuStarInfo, parammobile_count_rsp_new.stuCombineDiamondInfo);
      }
    }
  }
  
  public static Map<String, byte[]> e(String paramString)
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("MAPAUTOTRANS_DATA");
    ((StringBuilder)localObject1).append(paramString);
    localObject1 = LocalMultiProcConfig.getString(((StringBuilder)localObject1).toString(), "");
    if (!"".equals(localObject1)) {}
    try
    {
      localObject2 = new JSONObject((String)localObject1);
      Iterator localIterator = ((JSONObject)localObject2).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, Base64.decode(((JSONObject)localObject2).getString(str), 2));
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject2;
      label108:
      break label108;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getMapAutoTransData failed: ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" jsonString = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, ((StringBuilder)localObject2).toString());
    return localHashMap;
  }
  
  private static void e(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    QZoneTitleTabManager.a(parammobile_count_rsp_new, paramQQAppInterface);
  }
  
  private static boolean e(long paramLong)
  {
    Object localObject = LocalMultiProcConfig.getString4Uin("qzone_dual_warm_comment_info", "", paramLong);
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    try
    {
      localObject = (stNuanNuanComment)b(stNuanNuanComment.class, Base64Util.decode((String)localObject, 0));
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (((stNuanNuanComment)localObject).vcOtherComments != null)
        {
          int i = ((stNuanNuanComment)localObject).vcOtherComments.size();
          if (i <= 0) {
            return true;
          }
          bool1 = false;
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public static Map<Integer, Long> f(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      return localHashMap;
    }
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length == 2) {
        try
        {
          localHashMap.put(Integer.valueOf(URLDecoder.decode(arrayOfString[0], "UTF-8")), Long.valueOf(URLDecoder.decode(arrayOfString[1], "UTF-8")));
        }
        catch (Throwable localThrowable)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UndealCount.QZoneUnreadServletLogic", 2, localThrowable.toString());
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UndealCount.QZoneUnreadServletLogic", 2, localUnsupportedEncodingException.toString());
          }
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  private static void f(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {
      return;
    }
    LocalMultiProcConfig.putInt4Uin("navigator_bar_style", parammobile_count_rsp_new.isShowNewStyles, paramQQAppInterface.getLongAccountUin());
    if (parammobile_count_rsp_new.mapEntranceCfg == null) {
      return;
    }
    if (parammobile_count_rsp_new.mapEntranceCfg.size() == 0) {
      return;
    }
    parammobile_count_rsp_new = (ArrayList)parammobile_count_rsp_new.mapEntranceCfg.get(Integer.valueOf(2));
    if (parammobile_count_rsp_new == null) {
      return;
    }
    if (parammobile_count_rsp_new.size() == 0) {
      return;
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleNavigatorBarInfo rsp entracesize is:");
      localStringBuilder.append(parammobile_count_rsp_new.size());
      QLog.d("UndealCount.QZoneUnreadServletLogic", 4, localStringBuilder.toString());
    }
    ThreadManager.post(new QZoneUnreadServletLogic.1(paramQQAppInterface, parammobile_count_rsp_new), 8, null, false);
  }
  
  private static void g(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    parammobile_count_rsp_new = parammobile_count_rsp_new.plusRecom;
    if (parammobile_count_rsp_new == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "plusRecom null");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("plusRecom.status=");
      localStringBuilder.append(parammobile_count_rsp_new.status);
      localStringBuilder.append("  plusRecom.strMinProgramJson=");
      localStringBuilder.append(parammobile_count_rsp_new.strMinProgramJson);
      QLog.i("UndealCount.QZoneUnreadServletLogic", 2, localStringBuilder.toString());
    }
    if (parammobile_count_rsp_new.status == -1)
    {
      LocalMultiProcConfig.putString4Uin("friendplusmenurecom", "", paramQQAppInterface.getLongAccountUin());
      return;
    }
    if (parammobile_count_rsp_new.status == 1) {
      LocalMultiProcConfig.putString4Uin("friendplusmenurecom", parammobile_count_rsp_new.strMinProgramJson, paramQQAppInterface.getLongAccountUin());
    }
  }
  
  private static void h(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.stMapCountInfo != null) && (parammobile_count_rsp_new.stMapCountInfo.containsKey(Integer.valueOf(1009))) && (paramQQAppInterface != null))
    {
      parammobile_count_rsp_new = (count_info)parammobile_count_rsp_new.stMapCountInfo.get(Integer.valueOf(1009));
      if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.stCount != null) && (parammobile_count_rsp_new.stCount.uCount > 0L))
      {
        LocalMultiProcConfig.putLong4Uin("need_show_story_tips", 1L, paramQQAppInterface.getLongAccountUin());
        return;
      }
      LocalMultiProcConfig.putLong4Uin("need_show_story_tips", 0L, paramQQAppInterface.getLongAccountUin());
    }
  }
  
  private static void i(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    parammobile_count_rsp_new = (byte[])parammobile_count_rsp_new.mapTransData.get("OperEntrance");
    if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "saveMoreEntranceResConfig updateConfig");
      }
      Object localObject = new OperEntranceInfo();
      JceUtils.decodeWup((JceStruct)localObject, parammobile_count_rsp_new);
      localObject = ((OperEntranceInfo)localObject).resTable.entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        a(((EntranceRes)((Map.Entry)((Iterator)localObject).next()).getValue()).resUrl);
      }
      LocalMultiProcConfig.putString4Uin("key_plus_menu_config", Base64.encodeToString(parammobile_count_rsp_new, 0), paramQQAppInterface.getLongAccountUin());
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putByteArray("data", parammobile_count_rsp_new);
      QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "PlusMenuDecorates", "updateConfig", paramQQAppInterface, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "saveMoreEntranceResConfig no Config update");
    }
  }
  
  private static void j(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new != null) && (parammobile_count_rsp_new.vertVideoDisplay != null) && (parammobile_count_rsp_new.vertVideoDisplay.iType != 0) && (paramQQAppInterface != null))
    {
      LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_type", parammobile_count_rsp_new.vertVideoDisplay.iType, paramQQAppInterface.getLongAccountUin());
      LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_ratio", parammobile_count_rsp_new.vertVideoDisplay.iFeedAspectRatio, paramQQAppInterface.getLongAccountUin());
      LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_width", parammobile_count_rsp_new.vertVideoDisplay.iAspectRatioWidth, paramQQAppInterface.getLongAccountUin());
      LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_height", parammobile_count_rsp_new.vertVideoDisplay.iAspectRatioHeight, paramQQAppInterface.getLongAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic
 * JD-Core Version:    0.7.0.1
 */