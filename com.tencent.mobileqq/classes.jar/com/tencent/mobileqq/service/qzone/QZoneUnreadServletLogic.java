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
import NS_UNDEAL_COUNT.yellow_info;
import ahjq;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.model.QZoneManager;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneVipInfoManager;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.RemoteRequestSender;
import cooperation.qzone.util.JceUtils;
import cooperation.qzone.util.QZoneDistributedAppCtrl;
import cooperation.qzone.util.QZoneDistributedAppCtrl.Control;
import cooperation.qzone.util.QZoneLogTags;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class QZoneUnreadServletLogic
{
  private static final String a;
  public static HashMap a;
  private static String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = QZoneLogTags.LOG_TAG_UNDEALCOUNT + "QZoneUnreadServletLogic";
    b = "key_personalization_undeal_Count";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static Map a(long paramLong)
  {
    return QzoneMapUtil.a(LocalMultiProcConfig.getString("EXTEND_INFO" + paramLong, ""));
  }
  
  public static Map a(Long paramLong)
  {
    localHashMap = new HashMap();
    paramLong = LocalMultiProcConfig.getString4Uin("getMapLastGetTime", "", paramLong.longValue());
    if (!TextUtils.isEmpty(paramLong))
    {
      paramLong = new JSONTokener(paramLong);
      try
      {
        paramLong = (JSONArray)paramLong.nextValue();
        int i = 0;
        while (i < paramLong.length())
        {
          JSONObject localJSONObject = paramLong.getJSONObject(i);
          localHashMap.put(Long.valueOf(localJSONObject.getLong("key")), Long.valueOf(localJSONObject.getLong("value")));
          i += 1;
        }
        return localHashMap;
      }
      catch (JSONException paramLong)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getMapLastGetTime JSONException");
      }
    }
  }
  
  public static Map a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (TextUtils.isEmpty(paramString)) {
      return localHashMap;
    }
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    label29:
    String[] arrayOfString;
    if (i < j)
    {
      arrayOfString = paramString[i].split("=");
      if (arrayOfString.length == 2) {
        break label58;
      }
    }
    for (;;)
    {
      i += 1;
      break label29;
      break;
      try
      {
        label58:
        localHashMap.put(Integer.valueOf(URLDecoder.decode(arrayOfString[0], "UTF-8")), Long.valueOf(URLDecoder.decode(arrayOfString[1], "UTF-8")));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, localUnsupportedEncodingException.toString());
      }
      catch (Throwable localThrowable) {}
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, localThrowable.toString());
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
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        LocalMultiProcConfig.putInt4Uin("qzone_plus_live_show", paramInt, Long.valueOf(paramQQAppInterface).longValue());
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "saveFriendPlusLiveStatus:" + paramInt);
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
        QLog.e(jdField_a_of_type_JavaLangString, 1, "creditlevel:" + paramInt + " message:" + paramString);
      }
    }
  }
  
  public static void a(long paramLong, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null) {
        LocalMultiProcConfig.putInt4Uin("qzone_jinyan", (int)(0x8000 & paramLong), Long.valueOf(paramQQAppInterface).longValue());
      }
    }
  }
  
  private static void a(count_info paramcount_info)
  {
    if ((paramcount_info == null) || (paramcount_info.vecUinList == null)) {
      return;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "recv Qzone Unread Push: Feed实时更新未读");
    Intent localIntent = new Intent("com.qzone.push_feed_unread");
    if (paramcount_info != null) {
      localIntent.putExtra("feeds_unread", paramcount_info);
    }
    BaseApplication.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new, QbossGateWayRsp paramQbossGateWayRsp, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new.mapExtendinfo != null) && ("CLEARALL".equalsIgnoreCase((String)parammobile_count_rsp_new.mapExtendinfo.get("appid_2586"))))
    {
      LocalMultiProcConfig.putString4Uin("friendheadmenudata", "", paramQQAppInterface.getLongAccountUin());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "handleHeadMenuData:clearAll");
    }
    label51:
    label205:
    do
    {
      do
      {
        do
        {
          break label51;
          do
          {
            return;
          } while ((paramQbossGateWayRsp.mapAdv == null) || (paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2586)) == null));
          parammobile_count_rsp_new = (ArrayList)paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2586));
          if (parammobile_count_rsp_new.size() <= 0) {
            break label205;
          }
          parammobile_count_rsp_new = ((tAdvDesc)parammobile_count_rsp_new.get(0)).res_data;
          if (TextUtils.isEmpty(parammobile_count_rsp_new)) {
            break;
          }
          paramQbossGateWayRsp = LocalMultiProcConfig.getString4Uin("friendheadmenudata", "", paramQQAppInterface.getLongAccountUin());
          if (!parammobile_count_rsp_new.equals(paramQbossGateWayRsp)) {
            LocalMultiProcConfig.putString4Uin("friendheadmenudata", parammobile_count_rsp_new, paramQQAppInterface.getLongAccountUin());
          }
        } while (!QLog.isColorLevel());
        QLog.i(jdField_a_of_type_JavaLangString, 2, "headDropMenuUrl:" + paramQbossGateWayRsp);
        return;
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "headDropMenuUrl: null");
      return;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "advDescs.size() = 0");
  }
  
  public static void a(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {}
    while ((parammobile_count_rsp_new.stMasterInfo == null) || (paramQQAppInterface == null)) {
      return;
    }
    a(parammobile_count_rsp_new.stMasterInfo.iLevel, parammobile_count_rsp_new.stMasterInfo.strMessage, paramQQAppInterface);
    a(parammobile_count_rsp_new.stMasterInfo.host_unimbitmap, paramQQAppInterface);
  }
  
  private static void a(mobile_count_rsp_new parammobile_count_rsp_new, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    if (parammobile_count_rsp_new == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramQZoneNotifyServlet == null);
        if (parammobile_count_rsp_new.iNextTimeout > 0)
        {
          paramQZoneNotifyServlet.jdField_a_of_type_Long = (parammobile_count_rsp_new.iNextTimeout * 1000);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onReceive getFeedInterval:" + paramQZoneNotifyServlet.jdField_a_of_type_Long);
          }
        }
      } while (parammobile_count_rsp_new.switchTimeout <= 0);
      paramQZoneNotifyServlet.b = (parammobile_count_rsp_new.switchTimeout * 1000);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "onReceive getActiveAppInterval:" + paramQZoneNotifyServlet.b);
  }
  
  public static void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, QQAppInterface paramQQAppInterface, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    paramIntent = paramFromServiceMsg.getWupBuffer();
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
        paramFromServiceMsg = QZoneFeedCountPackeger.a(paramIntent, paramQQAppInterface, "getUndealCount");
      } while ((paramFromServiceMsg == null) || (!(paramFromServiceMsg instanceof mobile_count_rsp_new)));
      paramFromServiceMsg = (mobile_count_rsp_new)paramFromServiceMsg;
    } while (paramFromServiceMsg == null);
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onResponseCMD_STRING_GET_UNDEAL_COUNT rsp has data");
    }
    a(paramFromServiceMsg.mapLastGetTime, Long.valueOf(paramQQAppInterface.getCurrentAccountUin()));
    QZoneManager localQZoneManager = (QZoneManager)paramQQAppInterface.getManager(9);
    if (localQZoneManager != null) {
      localQZoneManager.b(0);
    }
    if ((paramFromServiceMsg.stMapCountInfo != null) && (paramFromServiceMsg.stMapCountInfo.get(Integer.valueOf(1)) != null)) {
      a((count_info)paramFromServiceMsg.stMapCountInfo.get(Integer.valueOf(1)));
    }
    LocalMultiProcConfig.putInt4Uin("qzone_preget_passive_open", paramFromServiceMsg.isPreLoad, paramQQAppInterface.getLongAccountUin());
    a(paramIntent, paramFromServiceMsg, paramQQAppInterface, paramQZoneNotifyServlet);
    c(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg, paramQZoneNotifyServlet);
    d(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg.sqDyncFeedsJson, paramQZoneNotifyServlet);
    b(paramFromServiceMsg, paramQQAppInterface);
    a(paramFromServiceMsg.isLiveShow, paramQQAppInterface);
    a(paramFromServiceMsg.isPlusRedBous, paramFromServiceMsg.isVistorRedBous, paramQQAppInterface);
    a(paramFromServiceMsg.strRedBousUrl, paramQQAppInterface);
    a(paramFromServiceMsg.vecOperateInfo, paramQQAppInterface.getCurrentAccountUin());
    c(paramFromServiceMsg.isSetMemorySeal, paramQQAppInterface);
    b(paramFromServiceMsg.grayOperateMask, paramQQAppInterface);
  }
  
  private static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      long l = System.currentTimeMillis();
      HashMap localHashMap = new HashMap();
      StatisticCollector.a(paramQQAppInterface.getApp()).a(paramQQAppInterface.getCurrentAccountUin(), "actQzoneUnread", true, l - QZoneNotifyServlet.c, 0L, localHashMap, "");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, Long paramLong)
  {
    if (paramQQAppInterface == null) {}
    HashMap localHashMap;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.getManager(9);
      } while ((paramQQAppInterface == null) || (!(paramQQAppInterface instanceof QZoneManagerImp)));
      localHashMap = (HashMap)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
    } while ((localHashMap == null) || (localHashMap.isEmpty()));
    if ((paramLong.longValue() != -1L) && (localHashMap.get(Integer.valueOf(1)) != null))
    {
      QZoneCountInfo localQZoneCountInfo = (QZoneCountInfo)localHashMap.get(Integer.valueOf(1));
      localQZoneCountInfo.jdField_a_of_type_Long = paramLong.longValue();
      localHashMap.put(Integer.valueOf(1), localQZoneCountInfo);
    }
    ((QZoneManagerImp)paramQQAppInterface).a(localHashMap);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, FromServiceMsg paramFromServiceMsg, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "inform QZONE_GET_UNREAD isSuccess false");
    }
    if (paramQZoneNotifyServlet != null) {
      paramQZoneNotifyServlet.notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
    }
    if (paramQQAppInterface != null)
    {
      paramIntent = "|resultcode: " + paramFromServiceMsg.getResultCode() + "|reason: " + MessageHandler.a(paramFromServiceMsg);
      paramFromServiceMsg = new HashMap();
      paramFromServiceMsg.put("param_FailCode", String.valueOf(9311));
      paramFromServiceMsg.put("param_errorDesc", paramIntent);
      StatisticCollector.a(paramQQAppInterface.getApp()).a(paramQQAppInterface.getCurrentAccountUin(), "actQzoneUnread", false, QZoneNotifyServlet.d - QZoneNotifyServlet.c, 0L, paramFromServiceMsg, "");
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "inform QZONE_GET_UNREAD isSuccess false");
    }
    if (paramQZoneNotifyServlet != null) {
      paramQZoneNotifyServlet.notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
    }
    if (paramQQAppInterface != null)
    {
      paramArrayOfByte = "|wufbuf: " + HexUtil.a(paramArrayOfByte);
      paramQZoneNotifyServlet = new HashMap();
      paramQZoneNotifyServlet.put("param_FailCode", String.valueOf(9045));
      paramQZoneNotifyServlet.put("param_errorDesc", paramArrayOfByte);
      StatisticCollector.a(paramQQAppInterface.getApp()).a(paramQQAppInterface.getCurrentAccountUin(), "actQzoneUnread", false, QZoneNotifyServlet.d - QZoneNotifyServlet.c, 0L, paramQZoneNotifyServlet, "");
    }
  }
  
  public static void a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        if (TextUtils.isEmpty(paramString)) {
          break label35;
        }
        LocalMultiProcConfig.putString4Uin("qzone_redpocket_guide_comment_icon_url", paramString, Long.valueOf(paramQQAppInterface).longValue());
      }
    }
    return;
    label35:
    LocalMultiProcConfig.putString4Uin("qzone_redpocket_guide_comment_icon_url", "", Long.valueOf(paramQQAppInterface).longValue());
  }
  
  private static void a(String paramString, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (paramQZoneNotifyServlet == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("sqDyncFeedsJson", paramString);
    paramQZoneNotifyServlet.notifyObserver(null, 1003, true, localBundle, QZoneObserver.class);
  }
  
  public static void a(String paramString, Map paramMap)
  {
    paramMap = QzoneMapUtil.a(paramMap);
    LocalMultiProcConfig.putString("EXTEND_INFO" + paramString, paramMap);
  }
  
  public static void a(ArrayList paramArrayList, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "QZoneFeedCountPackeger execCmds");
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
            QLog.d(jdField_a_of_type_JavaLangString, 4, "QZoneFeedCountPackeger operat_data cmd: " + localoperat_data.cmd);
            QLog.d(jdField_a_of_type_JavaLangString, 4, "QZoneFeedCountPackeger operat_data desc: " + localoperat_data.desc);
          }
          QZoneDistributedAppCtrl.Control localControl = new QZoneDistributedAppCtrl.Control();
          localControl.jdField_a_of_type_Int = localoperat_data.cmd;
          if ((localoperat_data.mapExt != null) && (localoperat_data.mapExt.size() > 0)) {
            localControl.jdField_a_of_type_JavaUtilMap.putAll(localoperat_data.mapExt);
          }
          localControl.jdField_a_of_type_JavaUtilMap.put("key_desc", localoperat_data.desc);
          QZoneDistributedAppCtrl.a(paramString).a(localControl);
        }
      }
    }
  }
  
  public static void a(Map paramMap, Long paramLong)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    JSONArray localJSONArray;
    do
    {
      return;
      localJSONArray = new JSONArray();
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
          QLog.d(jdField_a_of_type_JavaLangString, 2, "setMapLastGetTime JSONException");
          return;
        }
      }
    } while (localJSONArray.length() <= 0);
    LocalMultiProcConfig.putString4Uin("getMapLastGetTime", localJSONArray.toString(), paramLong.longValue());
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
        if (localJSONObject.optString("priority", "0").equalsIgnoreCase(paramJSONObject.optString("priority", "0")))
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "find one,oldData:" + localJSONObject.toString() + " ,newData:" + paramJSONObject.toString());
          paramJSONArray.put(i, paramJSONObject);
          if (i == j)
          {
            paramJSONArray.put(paramJSONObject);
            QLog.d(jdField_a_of_type_JavaLangString, 2, "add newData:" + paramJSONObject.toString());
          }
          return;
        }
        i += 1;
      }
      catch (Throwable paramJSONArray)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "updateSurpriseData error:", paramJSONArray);
      }
    }
  }
  
  private static void a(byte[] paramArrayOfByte, mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface, QZoneNotifyServlet paramQZoneNotifyServlet)
  {
    HashMap localHashMap = new HashMap();
    boolean bool = a(parammobile_count_rsp_new, localHashMap, paramQQAppInterface);
    int i = 0;
    if (bool) {
      i = RemoteHandleManager.a().a().a(paramQQAppInterface.getLongAccountUin());
    }
    if (localHashMap == null) {}
    do
    {
      return;
      if (localHashMap.size() == 0) {
        break label129;
      }
      if (bool) {
        break;
      }
    } while (paramQQAppInterface == null);
    paramArrayOfByte = paramQQAppInterface.getManager(9);
    if ((paramArrayOfByte != null) && ((paramArrayOfByte instanceof QZoneManagerImp)))
    {
      ((QZoneManagerImp)paramArrayOfByte).a(localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebanew", 2, "qzone redtypeinfo:recive undealcount rsp");
      }
    }
    for (;;)
    {
      a(paramQQAppInterface);
      return;
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), localHashMap);
    }
    label129:
    a(paramQQAppInterface, paramArrayOfByte, paramQZoneNotifyServlet);
  }
  
  private static boolean a(entrance_cfg paramentrance_cfg1, entrance_cfg paramentrance_cfg2)
  {
    if ((paramentrance_cfg1 == null) && (paramentrance_cfg2 == null)) {}
    do
    {
      return true;
      if (paramentrance_cfg1 == null) {
        return false;
      }
      if (paramentrance_cfg2 == null) {
        return false;
      }
    } while ((paramentrance_cfg1.iEntranceId == paramentrance_cfg2.iEntranceId) && (TextUtils.equals(paramentrance_cfg1.sEntranceAction, paramentrance_cfg2.sEntranceAction)) && (TextUtils.equals(paramentrance_cfg1.sEntranceName, paramentrance_cfg2.sEntranceName)) && (TextUtils.equals(paramentrance_cfg1.sEntranceIcon, paramentrance_cfg2.sEntranceIcon)));
    return false;
  }
  
  public static boolean a(mobile_count_rsp_new parammobile_count_rsp_new, HashMap paramHashMap, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "onResponse");
    }
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if (parammobile_count_rsp_new == null) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        do
        {
          return bool2;
          bool2 = bool1;
        } while (parammobile_count_rsp_new.stMapCountInfo == null);
        bool2 = bool1;
      } while (parammobile_count_rsp_new.stMapCountInfo.size() == 0);
      bool2 = bool1;
    } while (paramHashMap == null);
    int i = 1;
    bool1 = bool3;
    label74:
    if (i < 100)
    {
      count_info localcount_info = (count_info)parammobile_count_rsp_new.stMapCountInfo.get(Integer.valueOf(i));
      if (localcount_info == null) {
        break label719;
      }
      QZoneCountInfo localQZoneCountInfo = new QZoneCountInfo();
      if (localcount_info.stCount == null) {
        break label716;
      }
      localQZoneCountInfo.jdField_a_of_type_Long = localcount_info.stCount.uCount;
      localQZoneCountInfo.jdField_a_of_type_Int = localcount_info.stCount.iControl;
      if (QLog.isDevelopLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 4, "onResponse unread cout: " + localcount_info.stCount.uCount + "unread type: " + i);
        QLog.d("Q.lebanew", 2, "qzone redtypeinfo:onResponse unread cout: " + localcount_info.stCount.uCount + "unread type: " + i);
      }
      if ((i != 1) || (localQZoneCountInfo.jdField_a_of_type_Long <= 0L) || (parammobile_count_rsp_new.isPreLoad != 1) || (TextUtils.isEmpty(parammobile_count_rsp_new.undealCountTime)) || (LocalMultiProcConfig.getString4Uin("qzone_passive_undealtime", "", paramQQAppInterface.getLongAccountUin()).equals(parammobile_count_rsp_new.undealCountTime))) {
        break label716;
      }
      bool1 = true;
      QZoneCountUserInfo localQZoneCountUserInfo = null;
      Object localObject = localQZoneCountUserInfo;
      if (parammobile_count_rsp_new.mapTransData != null)
      {
        byte[] arrayOfByte = (byte[])parammobile_count_rsp_new.mapTransData.get("PassiveFeedsPush");
        localObject = localQZoneCountUserInfo;
        if (arrayOfByte != null) {
          localObject = (PassiveFeedsPush)JceUtils.a(PassiveFeedsPush.class, arrayOfByte);
        }
      }
      if ((localcount_info.vecUinList != null) && (localcount_info.vecUinList.size() > 0))
      {
        int j = 0;
        while (j < localcount_info.vecUinList.size())
        {
          localQZoneCountUserInfo = new QZoneCountUserInfo();
          localQZoneCountUserInfo.jdField_a_of_type_Long = ((feed_host_info)localcount_info.vecUinList.get(j)).uUin;
          if (((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo != null)
          {
            localQZoneCountUserInfo.jdField_a_of_type_Int = ((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo.iYellowType;
            localQZoneCountUserInfo.b = ((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo.iYellowLevel;
            localQZoneCountUserInfo.jdField_a_of_type_Byte = ((feed_host_info)localcount_info.vecUinList.get(j)).OpuinYellowInfo.isAnnualVip;
          }
          if ((localObject != null) && (((PassiveFeedsPush)localObject).stBubbleSkin != null) && (localQZoneCountUserInfo.jdField_a_of_type_Long == ((PassiveFeedsPush)localObject).stBubbleSkin.lUin)) {
            localQZoneCountUserInfo.jdField_a_of_type_NS_QMALL_COVERPassiveFeedsPush = ((PassiveFeedsPush)localObject);
          }
          localQZoneCountInfo.jdField_a_of_type_JavaUtilArrayList.add(localQZoneCountUserInfo);
          j += 1;
        }
        localQZoneCountInfo.jdField_a_of_type_JavaLangString = ((feed_host_info)localcount_info.vecUinList.get(0)).actiondesc;
        if (QLog.isDevelopLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "onResponse unread list first uin: " + ((feed_host_info)localcount_info.vecUinList.get(0)).uUin + ",actiondesc: " + ((feed_host_info)localcount_info.vecUinList.get(0)).actiondesc);
        }
      }
      localQZoneCountInfo.b = localcount_info.trace_info;
      paramHashMap.put(Integer.valueOf(i), localQZoneCountInfo);
    }
    label298:
    label716:
    label719:
    for (;;)
    {
      i += 1;
      break label74;
      bool2 = bool1;
      if (parammobile_count_rsp_new.extendinfo == null) {
        break;
      }
      bool2 = bool1;
      if (paramQQAppInterface == null) {
        break;
      }
      a(paramQQAppInterface.c(), parammobile_count_rsp_new.extendinfo);
      return bool1;
      break label298;
    }
  }
  
  private static boolean a(ArrayList paramArrayList, entrance_cfg paramentrance_cfg)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return false;
      if (paramentrance_cfg != null)
      {
        int i = 0;
        while (i < paramArrayList.size())
        {
          if (a(paramentrance_cfg, (entrance_cfg)paramArrayList.get(i))) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static byte[] a(long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Map paramMap, String paramString2)
  {
    if (paramLong == 0L) {
      return null;
    }
    paramString1 = new mobile_count_req();
    paramString1.iRelationType = 1;
    paramString1.iVisitQZoneType = paramInt3;
    paramString1.mapTimeStamp = b(paramLong);
    paramString1.mapLastGetTime = a(Long.valueOf(paramLong));
    paramString1.stMapCountInfo = paramMap;
    paramString1.extendinfo = a(paramLong);
    paramString1.lastUndealCountTime = paramString2;
    return QZoneFeedCountPackeger.a(paramString1, "getUndealCount", paramLong, paramInt1, paramInt2, paramInt4);
  }
  
  public static Map b(long paramLong)
  {
    Map localMap = a(LocalMultiProcConfig.getString("CTIME_MAP" + paramLong, ""));
    if (!localMap.containsKey(Integer.valueOf(0))) {
      localMap.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    return localMap;
  }
  
  public static void b(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getAccount();
      if (paramQQAppInterface != null)
      {
        LocalMultiProcConfig.putInt4Uin("qzone_feed_gray_mask", paramInt, Long.valueOf(paramQQAppInterface).longValue());
        Log.d("groffatest", "saveGrayOperate: " + paramInt);
      }
    }
  }
  
  public static void b(mobile_count_rsp_new parammobile_count_rsp_new, QbossGateWayRsp paramQbossGateWayRsp, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new.mapExtendinfo != null) && ("CLEARALL".equalsIgnoreCase((String)parammobile_count_rsp_new.mapExtendinfo.get("appid_2585"))))
    {
      LocalMultiProcConfig.putString4Uin("friendplusmenudata", "", paramQQAppInterface.getLongAccountUin());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "handlePlusMenuData:clearAll");
    }
    label52:
    label204:
    do
    {
      do
      {
        do
        {
          break label52;
          do
          {
            return;
          } while ((paramQbossGateWayRsp.mapAdv == null) || (paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2585)) == null));
          parammobile_count_rsp_new = (ArrayList)paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2585));
          if (parammobile_count_rsp_new.size() <= 0) {
            break label204;
          }
          parammobile_count_rsp_new = ((tAdvDesc)parammobile_count_rsp_new.get(0)).res_data;
          if (TextUtils.isEmpty(parammobile_count_rsp_new)) {
            break;
          }
          if (!parammobile_count_rsp_new.equals(LocalMultiProcConfig.getString4Uin("friendplusmenudata", "", paramQQAppInterface.getLongAccountUin()))) {
            LocalMultiProcConfig.putString4Uin("friendplusmenudata", parammobile_count_rsp_new, paramQQAppInterface.getLongAccountUin());
          }
        } while (!QLog.isColorLevel());
        QLog.i(jdField_a_of_type_JavaLangString, 2, "plusMenuData:" + parammobile_count_rsp_new);
        return;
      } while (!QLog.isColorLevel());
      QLog.i(jdField_a_of_type_JavaLangString, 2, "plusMenuData: null");
      return;
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "handlePlusMenuData advDescs.size() = 0");
  }
  
  public static void b(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {
      return;
    }
    QbossGateWayRsp localQbossGateWayRsp = new QbossGateWayRsp();
    Object localObject;
    boolean bool;
    if (parammobile_count_rsp_new.mapTransData != null)
    {
      localObject = (byte[])parammobile_count_rsp_new.mapTransData.get("QbossAdv");
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("handleSurpriseData:rsp.mapTransData != null,data == null ? ");
      if (localObject == null)
      {
        bool = true;
        QLog.d(str, 4, bool);
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject = new JceInputStream((byte[])localObject);
        ((JceInputStream)localObject).setServerEncoding("utf-8");
        localQbossGateWayRsp.readFrom((JceInputStream)localObject);
        c(parammobile_count_rsp_new, localQbossGateWayRsp, paramQQAppInterface);
        a(parammobile_count_rsp_new, localQbossGateWayRsp, paramQQAppInterface);
        b(parammobile_count_rsp_new, localQbossGateWayRsp, paramQQAppInterface);
        return;
        bool = false;
      }
      catch (Throwable localThrowable)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "handleSurpriseData error:", localThrowable);
        continue;
      }
      QLog.i(jdField_a_of_type_JavaLangString, 2, "handleSurpriseData rsp.mapTransData: null");
    }
  }
  
  private static boolean b(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    boolean bool = true;
    if (paramArrayList1 == null) {}
    int j;
    label82:
    for (;;)
    {
      return false;
      if ((paramArrayList2 != null) && (paramArrayList1.size() == paramArrayList2.size()) && (paramArrayList1.size() != 0))
      {
        int i = 1;
        j = 0;
        if (j >= paramArrayList1.size()) {
          break;
        }
        entrance_cfg localentrance_cfg = (entrance_cfg)paramArrayList1.get(j);
        if ((i != 0) && (a(paramArrayList2, localentrance_cfg))) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label82;
          }
          j += 1;
          break;
        }
      }
    }
    if (j == paramArrayList1.size()) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private static void c(int paramInt, QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("saveHasUserArchieveMemoryFlag:");
      if (paramInt != 0) {
        break label71;
      }
    }
    label71:
    for (String str = "未使用过记忆封存";; str = "已经使用过记忆封存")
    {
      QLog.d("ArchiveMemorySettingGuide", 2, str);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.getAccount();
        if (paramQQAppInterface != null) {
          LocalMultiProcConfig.putInt4Uin("qzone_memory_seal_key", paramInt, Long.valueOf(paramQQAppInterface).longValue());
        }
      }
      return;
    }
  }
  
  public static void c(mobile_count_rsp_new parammobile_count_rsp_new, QbossGateWayRsp paramQbossGateWayRsp, QQAppInterface paramQQAppInterface)
  {
    if ((parammobile_count_rsp_new.mapExtendinfo != null) && ("CLEARALL".equalsIgnoreCase((String)parammobile_count_rsp_new.mapExtendinfo.get("appid_2595"))))
    {
      LocalMultiProcConfig.putString4Uin("surprise_config", "", paramQQAppInterface.getLongAccountUin());
      QLog.w(jdField_a_of_type_JavaLangString, 1, "handleSurpriseData:clearAll");
    }
    while ((paramQbossGateWayRsp.mapAdv == null) || (paramQbossGateWayRsp.mapAdv.get(Integer.valueOf(2595)) == null)) {
      return;
    }
    parammobile_count_rsp_new = LocalMultiProcConfig.getString4Uin("surprise_config", "", paramQQAppInterface.getLongAccountUin());
    if (TextUtils.isEmpty(parammobile_count_rsp_new)) {
      parammobile_count_rsp_new = new JSONArray();
    }
    for (;;)
    {
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
            QLog.e(jdField_a_of_type_JavaLangString, 1, "parse advDesc.res_data error,catch an exception", localThrowable);
          }
        }
      }
      try
      {
        parammobile_count_rsp_new = new JSONArray(parammobile_count_rsp_new);
      }
      catch (Exception localException)
      {
        parammobile_count_rsp_new = new JSONArray();
        QLog.e(jdField_a_of_type_JavaLangString, 1, "parse local advDesc.res_data error,catch an exception", localException);
      }
    }
    LocalMultiProcConfig.putString4Uin("surprise_config", parammobile_count_rsp_new.toString(), paramQQAppInterface.getLongAccountUin());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "all configs:" + parammobile_count_rsp_new.toString());
  }
  
  private static void c(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {}
    while ((parammobile_count_rsp_new.stYellowInfo == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getCurrentAccountUin()))) {
      return;
    }
    QZoneVipInfoManager.a().a(parammobile_count_rsp_new.stYellowInfo.iYellowType, parammobile_count_rsp_new.stYellowInfo.iYellowLevel, parammobile_count_rsp_new.stYellowInfo.isAnnualVip, parammobile_count_rsp_new.stuStarInfo, parammobile_count_rsp_new.stuCombineDiamondInfo);
  }
  
  private static void d(mobile_count_rsp_new parammobile_count_rsp_new, QQAppInterface paramQQAppInterface)
  {
    if (parammobile_count_rsp_new == null) {}
    do
    {
      do
      {
        return;
        LocalMultiProcConfig.putInt4Uin("navigator_bar_style", parammobile_count_rsp_new.isShowNewStyles, paramQQAppInterface.getLongAccountUin());
      } while ((parammobile_count_rsp_new.mapEntranceCfg == null) || (parammobile_count_rsp_new.mapEntranceCfg.size() == 0));
      parammobile_count_rsp_new = (ArrayList)parammobile_count_rsp_new.mapEntranceCfg.get(Integer.valueOf(2));
    } while ((parammobile_count_rsp_new == null) || (parammobile_count_rsp_new.size() == 0));
    if (QLog.isDevelopLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 4, "handleNavigatorBarInfo rsp entracesize is:" + parammobile_count_rsp_new.size());
    }
    ThreadManager.post(new ahjq(paramQQAppInterface, parammobile_count_rsp_new), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic
 * JD-Core Version:    0.7.0.1
 */