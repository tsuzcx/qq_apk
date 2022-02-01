package com.tencent.mobileqq.hotchat.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.hotchat.api.IHotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatStateWrapper;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoCell;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.soso.location.data.SosoWifi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x62c.oidb_cmd0x62c.ReqBody;
import tencent.im.oidb.cmd0x62c.oidb_cmd0x62c.RspBody;
import tencent.im.oidb.cmd0x62c.oidb_cmd0x62c.TinyIDInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupNextVisitor;
import tencent.im.oidb.cmd0x897.cmd0x897.GroupUinCode;
import tencent.im.oidb.cmd0x897.cmd0x897.ReqBody;
import tencent.im.oidb.cmd0x897.cmd0x897.RspBody;
import tencent.im.oidb.cmd0x897.cmd0x897.VisitorInfo;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.RspBody;
import tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ExitPublicGroupReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.KickPublicGroupVisitorReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.ReqBody;
import tencent.im.oidb.cmd0x89b.oidb_0x89b.RspBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.ReqBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.RspBody;
import tencent.im.oidb.cmd0x8b2.oidb_0x8b2.ReqBody;
import tencent.im.oidb.cmd0x8b2.oidb_0x8b2.RspBody;
import tencent.im.oidb.cmd0x8b3.oidb_0x8b3.ReqBody;
import tencent.im.oidb.cmd0x8b3.oidb_0x8b3.groupinfo;
import tencent.im.oidb.cmd0xa81.oidb_0xa81.ReqBody;
import tencent.im.oidb.cmd0xa81.oidb_0xa81.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;
import tencent.im.oidb.hotchat.CreateHotChat.ReqBody;
import tencent.im.oidb.hotchat.CreateHotChat.RspBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.ReqBody;
import tencent.im.oidb.hotchat.GetJoinedHotChatList.RspBody;
import tencent.im.oidb.hotchat.LBS.Attribute;
import tencent.im.oidb.hotchat.LBS.Cell;
import tencent.im.oidb.hotchat.LBS.GPS;
import tencent.im.oidb.hotchat.LBS.LBSInfo;
import tencent.im.oidb.hotchat.LBS.Wifi;
import tencent.im.oidb.hotchat.oidb_0x81f.GetAuthDataReq;
import tencent.im.oidb.hotchat.oidb_0x81f.GetAuthDataRsp;
import tencent.im.oidb.hotchat.oidb_0x81f.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x81f.RspBody;
import tencent.im.oidb.hotchat.oidb_0x823.KickPublicGroupVisitorReqBody;
import tencent.im.oidb.hotchat.oidb_0x823.KickPublicGroupVisitorRspBody;
import tencent.im.oidb.hotchat.oidb_0x823.PlayerDeviceInfo;
import tencent.im.oidb.hotchat.oidb_0x823.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x823.RspBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.ReqBody;
import tencent.im.oidb.hotchat.oidb_0x8ab.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

@KeepClassConstructor
public class HotChatHandler
  extends BusinessHandler
  implements IHotChatHandler
{
  public static final String EXIT_HOT_CHAT_FAIL = HardCodeUtil.a(2131705641);
  public static final String EXIT_HOT_CHAT_SUCCESS = HardCodeUtil.a(2131705650);
  public static final String JOIN_HOT_CHAT_FAIL = HardCodeUtil.a(2131705649);
  private static final String TAG = "HotChatHandler";
  public QQAppInterface app;
  private volatile boolean mIsReqiringMyHotChat = false;
  private HashSet<String> pushCmd;
  
  HotChatHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.app = paramQQAppInterface;
  }
  
  private void createHotChat(Common.WifiPOIInfo paramWifiPOIInfo, boolean paramBoolean, int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool) {
      NearbyUtils.a("HotChatHandler", new Object[] { "createHotChat", Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), paramWifiPOIInfo });
    }
    if (paramWifiPOIInfo == null) {
      return;
    }
    Object localObject = paramWifiPOIInfo.uint32_wifi_poi_type;
    if (paramBoolean) {
      i = 1;
    }
    ((PBUInt32Field)localObject).set(i);
    localObject = HotChatInfo.createHotChat(paramWifiPOIInfo, paramBoolean, paramInt);
    CreateHotChat.ReqBody localReqBody = new CreateHotChat.ReqBody();
    localReqBody.create_req_info.setHasFlag(true);
    localReqBody.create_req_info.set(paramWifiPOIInfo);
    if (paramBoolean)
    {
      paramWifiPOIInfo = getLBSInfo(true);
      if (paramWifiPOIInfo != null) {
        localReqBody.lbs_info.set(paramWifiPOIInfo);
      }
      paramInt = 1;
    }
    else
    {
      paramInt = 0;
    }
    paramWifiPOIInfo = makeOIDBPkg("OidbSvc.0x8a2", 2210, paramInt, localReqBody.toByteArray(), 10000L);
    paramWifiPOIInfo.extraData.putSerializable("HOT_CHAT_INFO", (Serializable)localObject);
    sendPbReq(paramWifiPOIInfo);
  }
  
  public static LBS.LBSInfo getLBSInfo(boolean paramBoolean)
  {
    LBS.LBSInfo localLBSInfo = new LBS.LBSInfo();
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).reqRawLbsData(3600000L, HotChatHandler.class.getSimpleName());
    Object localObject1 = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getRawSosoInfo();
    if ((localObject1 != null) && (((SosoLbsInfo)localObject1).mLocation != null))
    {
      Object localObject2 = new LBS.GPS();
      ((LBS.GPS)localObject2).latitude.set((int)(((SosoLbsInfo)localObject1).mLocation.mLat84 * 1000000.0D));
      ((LBS.GPS)localObject2).longitude.set((int)(((SosoLbsInfo)localObject1).mLocation.mLon84 * 1000000.0D));
      ((LBS.GPS)localObject2).altitude.set(-1);
      ((LBS.GPS)localObject2).coordinate.set(0);
      localLBSInfo.gps.set((MessageMicro)localObject2);
      Object localObject3;
      if (((SosoLbsInfo)localObject1).mWifis != null)
      {
        localObject2 = ((SosoLbsInfo)localObject1).mWifis.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SosoWifi)((Iterator)localObject2).next();
          LBS.Wifi localWifi = new LBS.Wifi();
          localWifi.mac.set(((SosoWifi)localObject3).mMac);
          localWifi.rssi.set(((SosoWifi)localObject3).mRssi);
          localLBSInfo.rpt_wifi.add(localWifi);
        }
      }
      if (((SosoLbsInfo)localObject1).mCells != null)
      {
        localObject1 = ((SosoLbsInfo)localObject1).mCells.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SosoCell)((Iterator)localObject1).next();
          localObject3 = new LBS.Cell();
          ((LBS.Cell)localObject3).mcc.set(((SosoCell)localObject2).mMcc);
          ((LBS.Cell)localObject3).mnc.set(((SosoCell)localObject2).mMnc);
          ((LBS.Cell)localObject3).lac.set(((SosoCell)localObject2).mLac);
          ((LBS.Cell)localObject3).cellid.set(((SosoCell)localObject2).mCellId);
          ((LBS.Cell)localObject3).rssi.set(((SosoCell)localObject2).mRss);
          localLBSInfo.rpt_cell.add((MessageMicro)localObject3);
        }
      }
      localObject1 = new LBS.Attribute();
      localObject2 = DeviceInfoUtil.a();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((LBS.Attribute)localObject1).imei.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      }
      localObject2 = DeviceInfoUtil.b();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((LBS.Attribute)localObject1).imsi.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      }
      localLBSInfo.attribute.set((MessageMicro)localObject1);
      return localLBSInfo;
    }
    return null;
  }
  
  public static String getToday()
  {
    Date localDate = new Date();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(localDate);
    localCalendar.add(5, 1);
    localDate = localCalendar.getTime();
    return new SimpleDateFormat("yyyyMMdd").format(localDate);
  }
  
  private void handleAtAllRemainCountResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str2;
    Object[] arrayOfObject;
    String str1;
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      str2 = paramToServiceMsg.extraData.getString("troopCode");
      arrayOfObject = new Object[4];
      arrayOfObject[0] = str2;
      arrayOfObject[1] = Boolean.valueOf(false);
      str1 = "";
      arrayOfObject[2] = "";
      arrayOfObject[3] = "";
      if (paramObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.hotchat.remainCount", 2, "time out or error");
        }
        notifyUI(1053, false, arrayOfObject);
        return;
      }
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(1053, false, arrayOfObject);
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    label282:
    label304:
    label459:
    label481:
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramObject = new cmd0x8a7.RspBody();
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      boolean bool;
      label236:
      break label481;
    }
    try
    {
      paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      bool = paramObject.bool_can_at_all.get();
      if (!paramObject.bytes_prompt_msg_1.has()) {
        break label521;
      }
      paramToServiceMsg = paramObject.bytes_prompt_msg_1.get().toStringUtf8();
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      break label459;
      paramToServiceMsg = "";
      break label236;
      i = 0;
      break label282;
      j = 0;
      break label304;
    }
    paramFromServiceMsg = str1;
    if (paramObject.bytes_prompt_msg_2.has()) {
      paramFromServiceMsg = paramObject.bytes_prompt_msg_2.get().toStringUtf8();
    }
    if (paramObject.uint32_remain_at_all_count_for_group.has())
    {
      i = paramObject.uint32_remain_at_all_count_for_group.get();
      if (!paramObject.uint32_remain_at_all_count_for_uin.has()) {
        break label534;
      }
      j = paramObject.uint32_remain_at_all_count_for_uin.get();
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handleGetAtAllRemainCountInfo:");
        paramObject.append("troopCode:");
        paramObject.append(str2);
        paramObject.append(",groupRemainCnt:");
        paramObject.append(i);
        paramObject.append(",memberRemainCount:");
        paramObject.append(j);
        paramObject.append(", beCanAtAll:");
        paramObject.append(bool);
        paramObject.append(",tips1:");
        paramObject.append(paramToServiceMsg);
        paramObject.append(",tips2:");
        paramObject.append(paramFromServiceMsg);
        QLog.d("Q.hotchat.remainCount", 2, paramObject.toString());
      }
      try
      {
        notifyUI(1053, true, new Object[] { str2, Boolean.valueOf(bool), paramToServiceMsg, paramFromServiceMsg });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        break label459;
      }
      notifyUI(1053, false, arrayOfObject);
      return;
      notifyUI(1053, false, arrayOfObject);
      return;
      notifyUI(1053, false, arrayOfObject);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.hotchat.remainCount", 2, "req == null || res == null");
      }
      return;
    }
  }
  
  private void handleCreateHotChatResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = HardCodeUtil.a(2131705646);
    HotChatInfo localHotChatInfo = (HotChatInfo)paramToServiceMsg.extraData.getSerializable("HOT_CHAT_INFO");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isWifiHotChat", false);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label105:
      int i;
      break label105;
    }
    paramToServiceMsg = null;
    if (paramToServiceMsg == null)
    {
      notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
      return;
    }
    if (!paramToServiceMsg.uint32_result.has())
    {
      notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
      return;
    }
    i = paramToServiceMsg.uint32_result.get();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleCreateHotChatResp result ");
      paramFromServiceMsg.append(i);
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
    }
    if (i == 0) {
      paramFromServiceMsg = new CreateHotChat.RspBody();
    }
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      long l1 = Utils.a(paramFromServiceMsg.uint32_group_code.get());
      long l2 = Utils.a(paramFromServiceMsg.uint32_group_uin.get());
      localHotChatInfo.troopUin = String.valueOf(l1);
      localHotChatInfo.troopCode = String.valueOf(l2);
      localHotChatInfo.state = 0;
      ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(localHotChatInfo, 4);
      notifyUI(1032, true, new Object[] { HardCodeUtil.a(2131705636), localHotChatInfo.troopCode, localHotChatInfo.troopUin, localHotChatInfo.name, Boolean.valueOf(bool) });
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      label388:
      break label388;
    }
    notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, str, localHotChatInfo.name });
    return;
    if (i != 1283) {
      switch (i)
      {
      default: 
        paramToServiceMsg = HardCodeUtil.a(2131705655);
        break;
      case 1294: 
        paramToServiceMsg = HardCodeUtil.a(2131705652);
        break;
      case 1293: 
        paramToServiceMsg = HardCodeUtil.a(2131705643);
        break;
      case 1292: 
        paramToServiceMsg = HardCodeUtil.a(2131705638);
        break;
      case 1291: 
        paramToServiceMsg = HardCodeUtil.a(2131705642);
        break;
      case 1290: 
        paramToServiceMsg = HardCodeUtil.a(2131705651);
        break;
      }
    } else {
      paramToServiceMsg = HardCodeUtil.a(2131705648);
    }
    notifyUI(1032, false, new Object[] { localHotChatInfo.troopUin, paramToServiceMsg, localHotChatInfo.name });
  }
  
  private void handleCreateHotChatRespErrorOrTimeOut(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (HotChatInfo)paramToServiceMsg.extraData.get("HOT_CHAT_INFO");
    notifyUI(1032, false, new Object[] { paramToServiceMsg.troopUin, HardCodeUtil.a(2131705653), paramToServiceMsg.name });
  }
  
  private void handleDismissHotChat(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("groupcode");
    Object localObject = null;
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
      paramObject = paramToServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramToServiceMsg = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
      paramObject = paramToServiceMsg;
    }
    int j = -1;
    int i = j;
    if (paramObject != null)
    {
      i = j;
      if (paramObject.uint32_result.has()) {
        i = paramObject.uint32_result.get();
      }
    }
    if (i == 0)
    {
      paramFromServiceMsg = new oidb_0xa81.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg = localObject;
        if (paramFromServiceMsg.str_err_msg.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_err_msg.get().toStringUtf8();
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramToServiceMsg = localObject;
        if (QLog.isColorLevel())
        {
          QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
          paramToServiceMsg = localObject;
        }
      }
      paramFromServiceMsg = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      paramObject = paramFromServiceMsg.a(str);
      if (paramObject != null) {
        paramFromServiceMsg.a(paramObject, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
      }
      notifyUI(1038, true, new Object[] { str, Integer.valueOf(i), paramToServiceMsg });
    }
    else
    {
      notifyUI(1038, false, new Object[] { str, Integer.valueOf(i), null });
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleDismissHotChat,result= ");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(",groupcode=");
      paramToServiceMsg.append(str);
      QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  private void handleDismissHotChatTimeOutOrError(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("groupuin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1038, false, new Object[] { str, Integer.valueOf(i), paramToServiceMsg });
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleDismissHotChatTimeOutOrError,result= ");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",groupuin=");
      paramFromServiceMsg.append(str);
      paramFromServiceMsg.append(",groupcode=");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
    }
  }
  
  private void handleError(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<---handleError serviceCmd:");
      localStringBuilder.append(str);
      QLog.d("HotChatHandler", 2, localStringBuilder.toString());
    }
    if ("OidbSvc.0x8a4".equals(str))
    {
      handleGetMyHostChatListRespError(paramToServiceMsg, paramFromServiceMsg, false);
      return;
    }
    if ("OidbSvc.0x89b_3".equals(str))
    {
      reqJoinOrExitHotChat(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x823_0".equals(str)) {
      return;
    }
    if ("OidbSvc.0x8a2".equals(str))
    {
      handleCreateHotChatRespErrorOrTimeOut(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x8ab".equals(str))
    {
      handleQuickJoinHotChatErrorOrTimeOut(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x8b3".equals(str))
    {
      handleSetHotChatAnnounceTimeOutOrError(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x8b2".equals(str))
    {
      if (paramToServiceMsg != null)
      {
        if (paramToServiceMsg.extraData == null) {
          return;
        }
        int i = paramToServiceMsg.extraData.getInt("serviceType");
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleError, cmd:");
          localStringBuilder.append(str);
          localStringBuilder.append("|serviceType:");
          localStringBuilder.append(i);
          QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, localStringBuilder.toString());
        }
        if (i != 2) {
          return;
        }
        handleGetHotChatAnnounceTimeOutOrError(paramToServiceMsg, paramFromServiceMsg);
      }
    }
    else
    {
      if ("OidbSvc.0xa81".equals(str))
      {
        handleDismissHotChatTimeOutOrError(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x88d_0".equals(str))
      {
        handleGetUserCreateHotChatAnnounceTimeOutOrError(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x89a_0".equals(str))
      {
        handleSetUserCreateHotChatAnnounceTimeOutOrError(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0xa8b".equals(str)) {
        return;
      }
      if ("OidbSvc.0x897_0".equals(str))
      {
        handleGetHotChatTroopMemberList(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x88d_1".equals(str))
      {
        handleGetTroopInfo(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x8a3_7".equals(str)) {
        return;
      }
      if ("OidbSvc.0x8a7_0".equals(str))
      {
        handleAtAllRemainCountResponse(paramToServiceMsg, paramFromServiceMsg, null);
        return;
      }
      if ("OidbSvc.0x62c_4".equals(str)) {
        handleGetUinByTinyId(paramToServiceMsg, paramFromServiceMsg, null);
      }
    }
  }
  
  private void handleExitHotChatResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleExitHotChatResp()");
    }
    String str2;
    String str1;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      str2 = EXIT_HOT_CHAT_FAIL;
      str1 = paramToServiceMsg.extraData.getString("troopUin");
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        notifyUI(1033, false, new Object[] { str1, str2 });
        return;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label100:
      int i;
      break label100;
    }
    paramFromServiceMsg = null;
    if (paramFromServiceMsg == null)
    {
      notifyUI(1033, false, new Object[] { str1, str2 });
      return;
    }
    if (!paramFromServiceMsg.uint32_result.has())
    {
      notifyUI(1033, false, new Object[] { str1, str2 });
      return;
    }
    i = paramFromServiceMsg.uint32_result.get();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleExitHotChatResp result ");
      paramFromServiceMsg.append(i);
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
    }
    if (i == 0)
    {
      paramToServiceMsg = (HotChatManager.HotChatStateWrapper)paramToServiceMsg.extraData.getSerializable("targetHotChatState");
      paramFromServiceMsg = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      paramFromServiceMsg.a(paramFromServiceMsg.a(str1), paramToServiceMsg);
      notifyUI(1033, true, new Object[] { str1, HardCodeUtil.a(2131705650) });
      return;
    }
    notifyUI(1033, false, new Object[] { str1, str2 });
  }
  
  private void handleExtHotChatRespErrorOrTimeOut(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandler", 2, "handleExtHotChatRespErrorOrTimeOut()");
    }
    paramFromServiceMsg = EXIT_HOT_CHAT_FAIL;
    notifyUI(1033, false, new Object[] { paramToServiceMsg.extraData.getString("troopUin"), paramFromServiceMsg });
  }
  
  /* Error */
  private void handleGetHotChatAnnounce(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 136	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 717
    //   7: invokevirtual 721	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   10: astore 7
    //   12: aload_1
    //   13: getfield 136	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 723
    //   19: invokevirtual 396	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 8
    //   24: new 418	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   27: dup
    //   28: invokespecial 419	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   31: astore_1
    //   32: aload_1
    //   33: aload_3
    //   34: checkcast 421	[B
    //   37: checkcast 421	[B
    //   40: invokevirtual 425	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   43: pop
    //   44: aload_1
    //   45: astore_3
    //   46: goto +30 -> 76
    //   49: astore_2
    //   50: goto +6 -> 56
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_1
    //   57: astore_3
    //   58: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +15 -> 76
    //   64: ldc 14
    //   66: iconst_2
    //   67: aload_2
    //   68: invokevirtual 583	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   71: invokestatic 406	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: aload_1
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull +25 -> 102
    //   80: aload_3
    //   81: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   84: invokevirtual 431	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   87: ifeq +15 -> 102
    //   90: aload_3
    //   91: getfield 428	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   94: invokevirtual 434	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   97: istore 4
    //   99: goto +6 -> 105
    //   102: iconst_m1
    //   103: istore 4
    //   105: iload 4
    //   107: ifne +354 -> 461
    //   110: new 725	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody
    //   113: dup
    //   114: invokespecial 726	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:<init>	()V
    //   117: astore 6
    //   119: aload 6
    //   121: aload_3
    //   122: getfield 437	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   125: invokevirtual 441	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   128: invokevirtual 445	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   131: invokevirtual 727	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   134: pop
    //   135: aload 6
    //   137: getfield 730	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_group_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   140: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   143: ifeq +18 -> 161
    //   146: aload 6
    //   148: getfield 730	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_group_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   151: invokevirtual 441	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   154: invokevirtual 460	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   157: astore_1
    //   158: goto +5 -> 163
    //   161: aconst_null
    //   162: astore_1
    //   163: aload 6
    //   165: getfield 733	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_jumping_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   168: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   171: ifeq +18 -> 189
    //   174: aload 6
    //   176: getfield 733	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:string_jumping_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   179: invokevirtual 441	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   182: invokevirtual 460	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   185: astore_2
    //   186: goto +5 -> 191
    //   189: aconst_null
    //   190: astore_2
    //   191: aload 6
    //   193: getfield 737	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:uint64_administrator_uin	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   196: invokevirtual 740	com/tencent/mobileqq/pb/PBRepeatField:has	()Z
    //   199: ifeq +15 -> 214
    //   202: aload 6
    //   204: getfield 737	tencent/im/oidb/cmd0x8b2/oidb_0x8b2$RspBody:uint64_administrator_uin	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   207: invokevirtual 743	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   210: astore_3
    //   211: goto +5 -> 216
    //   214: aconst_null
    //   215: astore_3
    //   216: aload_3
    //   217: astore 6
    //   219: aload_2
    //   220: astore_3
    //   221: aload 6
    //   223: astore_2
    //   224: goto +38 -> 262
    //   227: astore_3
    //   228: goto +14 -> 242
    //   231: astore_3
    //   232: aconst_null
    //   233: astore_2
    //   234: goto +8 -> 242
    //   237: astore_3
    //   238: aconst_null
    //   239: astore_2
    //   240: aconst_null
    //   241: astore_1
    //   242: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   245: ifeq +13 -> 258
    //   248: ldc 14
    //   250: iconst_2
    //   251: aload_3
    //   252: invokevirtual 591	java/lang/Exception:toString	()Ljava/lang/String;
    //   255: invokestatic 406	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   258: aload_2
    //   259: astore_3
    //   260: aconst_null
    //   261: astore_2
    //   262: aload_0
    //   263: getfield 48	com/tencent/mobileqq/hotchat/app/HotChatHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   266: getstatic 554	com/tencent/mobileqq/app/QQManagerFactory:HOT_CHAT_MANAGER	I
    //   269: invokevirtual 560	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   272: checkcast 562	com/tencent/mobileqq/app/HotChatManager
    //   275: astore 6
    //   277: aload 6
    //   279: aload 8
    //   281: invokevirtual 594	com/tencent/mobileqq/app/HotChatManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   284: astore 9
    //   286: aload 9
    //   288: ifnull +127 -> 415
    //   291: aload_1
    //   292: ifnonnull +14 -> 306
    //   295: aload 9
    //   297: getfield 746	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   300: ifnonnull +18 -> 318
    //   303: goto +21 -> 324
    //   306: aload_1
    //   307: aload 9
    //   309: getfield 746	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   312: invokevirtual 626	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifne +9 -> 324
    //   318: aload 9
    //   320: iconst_0
    //   321: putfield 749	com/tencent/mobileqq/data/HotChatInfo:memoShowed	Z
    //   324: aload 9
    //   326: aload_1
    //   327: putfield 746	com/tencent/mobileqq/data/HotChatInfo:memo	Ljava/lang/String;
    //   330: aload 9
    //   332: aload_3
    //   333: putfield 752	com/tencent/mobileqq/data/HotChatInfo:memoUrl	Ljava/lang/String;
    //   336: new 224	java/util/ArrayList
    //   339: dup
    //   340: invokespecial 753	java/util/ArrayList:<init>	()V
    //   343: astore 10
    //   345: aload_2
    //   346: ifnull +55 -> 401
    //   349: aload_2
    //   350: invokeinterface 758 1 0
    //   355: ifle +46 -> 401
    //   358: iconst_0
    //   359: istore 5
    //   361: iload 5
    //   363: aload_2
    //   364: invokeinterface 758 1 0
    //   369: if_icmpge +32 -> 401
    //   372: aload 10
    //   374: aload_2
    //   375: iload 5
    //   377: invokeinterface 761 2 0
    //   382: checkcast 763	java/lang/Long
    //   385: invokestatic 766	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   388: invokevirtual 768	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   391: pop
    //   392: iload 5
    //   394: iconst_1
    //   395: iadd
    //   396: istore 5
    //   398: goto -37 -> 361
    //   401: aload 9
    //   403: aload 10
    //   405: putfield 772	com/tencent/mobileqq/data/HotChatInfo:adminUins	Ljava/util/List;
    //   408: aload 6
    //   410: aload 9
    //   412: invokevirtual 775	com/tencent/mobileqq/app/HotChatManager:a	(Lcom/tencent/mobileqq/data/HotChatInfo;)V
    //   415: aload_0
    //   416: sipush 1036
    //   419: iconst_1
    //   420: bipush 6
    //   422: anewarray 58	java/lang/Object
    //   425: dup
    //   426: iconst_0
    //   427: aload 8
    //   429: aastore
    //   430: dup
    //   431: iconst_1
    //   432: aload 7
    //   434: aastore
    //   435: dup
    //   436: iconst_2
    //   437: iload 4
    //   439: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   442: aastore
    //   443: dup
    //   444: iconst_3
    //   445: aload_1
    //   446: aastore
    //   447: dup
    //   448: iconst_4
    //   449: aload_3
    //   450: aastore
    //   451: dup
    //   452: iconst_5
    //   453: aload_2
    //   454: aastore
    //   455: invokevirtual 410	com/tencent/mobileqq/hotchat/app/HotChatHandler:notifyUI	(IZLjava/lang/Object;)V
    //   458: goto +52 -> 510
    //   461: aconst_null
    //   462: astore_1
    //   463: aload_0
    //   464: sipush 1036
    //   467: iconst_0
    //   468: bipush 6
    //   470: anewarray 58	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: aload 8
    //   477: aastore
    //   478: dup
    //   479: iconst_1
    //   480: aload 7
    //   482: aastore
    //   483: dup
    //   484: iconst_2
    //   485: iload 4
    //   487: invokestatic 70	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   490: aastore
    //   491: dup
    //   492: iconst_3
    //   493: aconst_null
    //   494: aastore
    //   495: dup
    //   496: iconst_4
    //   497: aconst_null
    //   498: aastore
    //   499: dup
    //   500: iconst_5
    //   501: aconst_null
    //   502: aastore
    //   503: invokevirtual 410	com/tencent/mobileqq/hotchat/app/HotChatHandler:notifyUI	(IZLjava/lang/Object;)V
    //   506: aconst_null
    //   507: astore_3
    //   508: aload_3
    //   509: astore_2
    //   510: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   513: ifeq +89 -> 602
    //   516: new 471	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 472	java/lang/StringBuilder:<init>	()V
    //   523: astore 6
    //   525: aload 6
    //   527: ldc_w 777
    //   530: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 6
    //   536: iload 4
    //   538: invokevirtual 485	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 6
    //   544: ldc_w 779
    //   547: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 6
    //   553: aload_1
    //   554: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 6
    //   560: ldc_w 781
    //   563: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: aload 6
    //   569: aload_3
    //   570: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 6
    //   576: ldc_w 783
    //   579: invokevirtual 478	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: pop
    //   583: aload 6
    //   585: aload_2
    //   586: invokevirtual 786	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: ldc_w 663
    //   593: iconst_2
    //   594: aload 6
    //   596: invokevirtual 499	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 406	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	HotChatHandler
    //   0	603	1	paramToServiceMsg	ToServiceMsg
    //   0	603	2	paramFromServiceMsg	FromServiceMsg
    //   0	603	3	paramObject	Object
    //   97	440	4	i	int
    //   359	38	5	j	int
    //   117	478	6	localObject	Object
    //   10	471	7	arrayOfByte	byte[]
    //   22	454	8	str	String
    //   284	127	9	localHotChatInfo	HotChatInfo
    //   343	61	10	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   32	44	49	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   24	32	53	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   191	211	227	java/lang/Exception
    //   163	186	231	java/lang/Exception
    //   119	158	237	java/lang/Exception
  }
  
  private void handleGetHotChatAnnounceTimeOutOrError(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troop_uin");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1036, false, new Object[] { paramToServiceMsg, arrayOfByte, Integer.valueOf(i), "", "", null });
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetHotChatAnnounceTimeOutOrError,result= ");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(",uid=");
      paramToServiceMsg.append(arrayOfByte);
      QLog.i("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, paramToServiceMsg.toString());
    }
  }
  
  private void handleGetHotChatTroopMemberList(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("uitag"));
    Integer localInteger = Integer.valueOf(1);
    if ((paramFromServiceMsg != null) && (paramObject != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramObject != null) && (paramObject.uint32_result.has()) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null)) {
        paramFromServiceMsg = new cmd0x897.RspBody();
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label278:
      int i;
      break label391;
    }
    try
    {
      paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
      if (paramFromServiceMsg.uint32_result.has())
      {
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          if (!paramFromServiceMsg.rpt_msg_grp_visitor_info.isEmpty()) {
            notifyUI(1046, true, new Object[] { Integer.valueOf(0), paramFromServiceMsg.rpt_msg_grp_visitor_info.get(), paramToServiceMsg });
          } else {
            notifyUI(1046, false, new Object[] { Integer.valueOf(2), null, paramToServiceMsg });
          }
        }
        else {
          notifyUI(1046, false, new Object[] { Integer.valueOf(3), null, paramToServiceMsg });
        }
      }
      else {
        notifyUI(1046, false, new Object[] { localInteger, null, paramToServiceMsg });
      }
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      break label278;
    }
    notifyUI(1046, false, new Object[] { localInteger, null, paramToServiceMsg });
    if (QLog.isColorLevel())
    {
      i = -1;
      if (paramFromServiceMsg.uint32_result.has()) {
        i = paramFromServiceMsg.uint32_result.get();
      }
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetHotChatTroopMemberList.result=");
      paramToServiceMsg.append(i);
      QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
    }
    return;
    notifyUI(1046, false, new Object[] { localInteger, null, paramToServiceMsg });
    return;
    label391:
    notifyUI(1046, false, new Object[] { localInteger, null, paramToServiceMsg });
    return;
    notifyUI(1046, false, new Object[] { localInteger, null, paramToServiceMsg });
  }
  
  private void handleGetMyHostChatListRespError(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, boolean paramBoolean)
  {
    this.mIsReqiringMyHotChat = false;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetMyHostChatListRespError timeOut: ");
      paramToServiceMsg.append(paramBoolean);
      QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
    }
    notifyUI(1031, false, null);
    if (paramBoolean) {
      ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(null, false);
    }
  }
  
  private void handleGetMyHotChatListResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool4 = false;
    this.mIsReqiringMyHotChat = false;
    if (paramObject == null) {
      return;
    }
    boolean bool2;
    if (paramToServiceMsg.extraData.getInt("serviceType", 0) == 2) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    GetJoinedHotChatList.RspBody localRspBody = new GetJoinedHotChatList.RspBody();
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramFromServiceMsg.uint32_result.has())
      {
        j = paramFromServiceMsg.uint32_result.get();
        paramToServiceMsg = localRspBody;
        i = j;
        bool3 = bool1;
        if (j != 0) {
          break label180;
        }
      }
    }
    catch (Exception paramToServiceMsg)
    {
      boolean bool3;
      label159:
      label162:
      label180:
      break label159;
    }
    try
    {
      localRspBody.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = localRspBody;
      i = j;
      bool3 = bool1;
    }
    catch (Exception paramToServiceMsg)
    {
      i = j;
      break label162;
    }
    i = 0;
    paramToServiceMsg = null;
    bool3 = false;
    break label180;
    i = 0;
    bool3 = bool1;
    paramToServiceMsg = localRspBody;
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetMyHotChatListResp isSuccess: ");
      paramFromServiceMsg.append(bool3);
      paramFromServiceMsg.append(", result:");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",resp=");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
    }
    if (paramToServiceMsg != null)
    {
      paramFromServiceMsg = paramToServiceMsg.rpt_msg_wifi_poi_info.get();
      paramToServiceMsg = new ArrayList();
      bool1 = bool4;
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        bool1 = false;
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (Common.WifiPOIInfo)paramFromServiceMsg.next();
          if (paramObject.uint32_wifi_poi_type.get() == 1) {
            bool3 = true;
          } else {
            bool3 = false;
          }
          paramObject = HotChatInfo.createHotChat(paramObject, bool3);
          paramToServiceMsg.add(paramObject);
          if (bool2)
          {
            paramObject.isGameRoom = true;
            bool1 = true;
          }
        }
      }
      ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramToServiceMsg, bool2);
      if (bool2) {
        new Handler(Looper.getMainLooper()).post(new HotChatHandler.2(this, bool1, paramToServiceMsg));
      }
      notifyUI(1031, true, null);
      return;
    }
    notifyUI(1031, false, null);
  }
  
  private void handleGetTroopInfo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str;
    boolean bool;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      str = paramToServiceMsg.extraData.getString("troopCode");
      bool = paramToServiceMsg.extraData.getBoolean("isHotChat");
      paramToServiceMsg = new Object[3];
      paramToServiceMsg[0] = str;
      paramToServiceMsg[1] = Integer.valueOf(-1);
      paramToServiceMsg[2] = Boolean.valueOf(bool);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleGetTroopInfo isHotChat = ");
        localStringBuilder.append(bool);
        QLog.d("HotChatHandler", 2, localStringBuilder.toString());
      }
      if ((paramObject != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null)) {
        paramObject = new oidb_0x88d.RspBody();
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label348:
      break label368;
    }
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = paramObject.stzrspgroupinfo.get();
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
        int i = paramFromServiceMsg.uint32_result.get();
        if (i == 0)
        {
          notifyUI(1047, true, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool), (oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get() });
          return;
        }
        notifyUI(1047, false, new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool) });
        return;
      }
      notifyUI(1047, false, paramToServiceMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label348;
    }
    notifyUI(1047, false, paramToServiceMsg);
    return;
    notifyUI(1047, false, paramToServiceMsg);
    return;
    label368:
    notifyUI(1047, false, paramToServiceMsg);
    return;
    notifyUI(1047, false, paramToServiceMsg);
  }
  
  private void handleGetUserCreateHotChatAnnounce(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("groupcode");
    Object localObject3 = null;
    Object localObject4 = null;
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramObject) {}
      paramFromServiceMsg = paramToServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramObject)
    {
      paramToServiceMsg = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("HotChatHandler", 2, paramObject.toString());
      paramFromServiceMsg = paramToServiceMsg;
    }
    int j = -1;
    int i = j;
    if (paramFromServiceMsg != null)
    {
      i = j;
      if (paramFromServiceMsg.uint32_result.has()) {
        i = paramFromServiceMsg.uint32_result.get();
      }
    }
    paramToServiceMsg = Long.valueOf(0L);
    int k;
    if (i == 0)
    {
      paramObject = new oidb_0x88d.RspBody();
      k = i;
    }
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        k = i;
        if (!paramObject.stzrspgroupinfo.has()) {
          break label780;
        }
        k = i;
        Object localObject1 = paramObject.stzrspgroupinfo.get();
        paramObject = localObject3;
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        if (localObject1 == null) {
          break label712;
        }
        k = i;
        paramObject = localObject3;
        paramFromServiceMsg = paramToServiceMsg;
        j = i;
        if (((List)localObject1).size() <= 0) {
          break label712;
        }
        k = i;
        paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)((List)localObject1).get(0);
        j = i;
        k = i;
        if (paramFromServiceMsg.uint32_result.has())
        {
          k = i;
          j = paramFromServiceMsg.uint32_result.get();
        }
        if (j == 0)
        {
          k = j;
          if (!paramFromServiceMsg.stgroupinfo.has()) {
            break label786;
          }
          k = j;
          localGroupInfo = (oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get();
          if (localGroupInfo == null) {
            break label792;
          }
          k = j;
          if (localGroupInfo.string_group_memo.has())
          {
            k = j;
            localObject1 = localGroupInfo.string_group_memo.get().toStringUtf8();
          }
          else
          {
            localObject1 = null;
          }
          paramFromServiceMsg = paramToServiceMsg;
          paramObject = localObject1;
          localObject3 = paramToServiceMsg;
          localObject4 = localObject1;
          try
          {
            if (localGroupInfo.uint64_group_owner.has())
            {
              localObject3 = paramToServiceMsg;
              localObject4 = localObject1;
              paramFromServiceMsg = Long.valueOf(localGroupInfo.uint64_group_owner.get());
              paramObject = localObject1;
            }
            localObject3 = paramFromServiceMsg;
            localObject4 = paramObject;
            paramToServiceMsg = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
            localObject3 = paramFromServiceMsg;
            localObject4 = paramObject;
            localObject1 = paramToServiceMsg.a(str);
            if (localObject1 != null)
            {
              if (paramObject == null)
              {
                localObject3 = paramFromServiceMsg;
                localObject4 = paramObject;
                if (((HotChatInfo)localObject1).memo == null) {
                  continue;
                }
              }
              else
              {
                localObject3 = paramFromServiceMsg;
                localObject4 = paramObject;
                if (paramObject.equals(((HotChatInfo)localObject1).memo)) {
                  continue;
                }
              }
              localObject3 = paramFromServiceMsg;
              localObject4 = paramObject;
              ((HotChatInfo)localObject1).memoShowed = false;
              localObject3 = paramFromServiceMsg;
              localObject4 = paramObject;
              ((HotChatInfo)localObject1).memo = paramObject;
              localObject3 = paramFromServiceMsg;
              localObject4 = paramObject;
              ((HotChatInfo)localObject1).memoUrl = null;
              localObject3 = paramFromServiceMsg;
              localObject4 = paramObject;
              ((HotChatInfo)localObject1).ownerUin = String.valueOf(paramFromServiceMsg);
              localObject3 = paramFromServiceMsg;
              localObject4 = paramObject;
              paramToServiceMsg.a((HotChatInfo)localObject1);
            }
            localObject3 = paramFromServiceMsg;
            localObject4 = paramObject;
            notifyUI(1039, true, new Object[] { str, Integer.valueOf(j), paramObject, paramFromServiceMsg });
          }
          catch (Exception localException1)
          {
            paramToServiceMsg = localObject4;
            k = j;
            continue;
          }
        }
        else
        {
          k = j;
          notifyUI(1039, false, new Object[] { str, Integer.valueOf(j), null, paramToServiceMsg });
          paramObject = localObject3;
          paramFromServiceMsg = paramToServiceMsg;
        }
      }
      catch (Exception localException2)
      {
        localObject3 = paramToServiceMsg;
        paramToServiceMsg = localObject4;
        paramObject = paramToServiceMsg;
        paramFromServiceMsg = (FromServiceMsg)localObject3;
        j = k;
        if (!QLog.isColorLevel()) {
          break label712;
        }
      }
      QLog.i("HotChatHandler", 2, localException2.toString());
      paramObject = paramToServiceMsg;
      paramFromServiceMsg = (FromServiceMsg)localObject3;
      j = k;
      break label712;
      notifyUI(1039, false, new Object[] { str, Integer.valueOf(i), null, paramToServiceMsg });
      j = i;
      paramFromServiceMsg = paramToServiceMsg;
      paramObject = localObject3;
      label712:
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetUserCreateHotChatAnnounce,result= ");
        paramToServiceMsg.append(j);
        paramToServiceMsg.append(",memo=");
        paramToServiceMsg.append(paramObject);
        paramToServiceMsg.append(",troopOwner=");
        paramToServiceMsg.append(paramFromServiceMsg);
        QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
      }
      return;
      label780:
      Object localObject2 = null;
      continue;
      label786:
      oidb_0x88d.GroupInfo localGroupInfo = null;
      continue;
      label792:
      paramObject = null;
      paramFromServiceMsg = paramToServiceMsg;
    }
  }
  
  private void handleGetUserCreateHotChatAnnounceTimeOutOrError(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1039, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "", Long.valueOf(0L) });
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetUserCreateHotChatAnnounceTimeOutOrError,result= ");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",groupcode=");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
    }
  }
  
  private void handleJoinOrExitHotChat(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("kick", false))
    {
      handleKickHotChatMemberResp(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isJoin")) {
      return;
    }
    handleExitHotChatResp(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void handleKickHotChatMemberByGlobalAmdminResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("groupuin");
    String str4 = paramToServiceMsg.extraData.getString("groupcode");
    String str2 = paramToServiceMsg.extraData.getString("memberuin");
    String str3 = paramToServiceMsg.extraData.getString("nickname");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
      paramObject = paramToServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramToServiceMsg = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
      paramObject = paramToServiceMsg;
    }
    int i;
    if ((paramObject != null) && (paramObject.uint32_result.has())) {
      i = paramObject.uint32_result.get();
    } else {
      i = -1;
    }
    if (i == 0)
    {
      paramToServiceMsg = new oidb_0x823.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        if (paramToServiceMsg.msg_kick_visitor.has()) {
          paramToServiceMsg = (oidb_0x823.KickPublicGroupVisitorRspBody)paramToServiceMsg.msg_kick_visitor.get();
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
        }
      }
      paramToServiceMsg = this.app;
      paramFromServiceMsg = String.valueOf(str4);
      paramObject = new StringBuilder();
      paramObject.append(str3);
      paramObject.append(BaseApplicationImpl.getContext().getString(2131693198));
      AddMessageHelper.a(paramToServiceMsg, paramFromServiceMsg, paramObject.toString(), 1, false, true);
      notifyUI(1052, true, new Object[] { str1, Integer.valueOf(i), str2, null });
    }
    else
    {
      notifyUI(1052, false, new Object[] { str1, Integer.valueOf(i), str2, null });
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleKickHotChatMemberByGlobalAmdminResp,result= ");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(",groupuin=");
      paramToServiceMsg.append(str1);
      paramToServiceMsg.append(",memberUin=");
      paramToServiceMsg.append(str2);
      paramToServiceMsg.append(",strErr=");
      paramToServiceMsg.append(null);
      QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, paramToServiceMsg.toString());
    }
  }
  
  private void handleKickHotChatMemberErrorOrTimeout(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramToServiceMsg.extraData.getString("groupuin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("memberuin");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1037, false, new Object[] { str, Integer.valueOf(i), paramToServiceMsg, null });
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleKickHotChatMemberErrorOrTimeout,result= ");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",groupuin=");
      paramFromServiceMsg.append(str);
      paramFromServiceMsg.append(",memberUin=");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
    }
  }
  
  private void handleKickHotChatMemberResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("groupuin");
    String str4 = paramToServiceMsg.extraData.getString("groupcode");
    String str2 = paramToServiceMsg.extraData.getString("memberuin");
    String str3 = paramToServiceMsg.extraData.getString("nickname");
    Object localObject = null;
    StringBuilder localStringBuilder = null;
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
      paramObject = paramToServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramToServiceMsg = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
      paramObject = paramToServiceMsg;
    }
    int i;
    if ((paramObject != null) && (paramObject.uint32_result.has())) {
      i = paramObject.uint32_result.get();
    } else {
      i = -1;
    }
    if (i == 0)
    {
      paramFromServiceMsg = new oidb_0x89b.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg = localStringBuilder;
        if (paramFromServiceMsg.str_err_msg.has()) {
          paramToServiceMsg = paramFromServiceMsg.str_err_msg.get();
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramToServiceMsg = localStringBuilder;
        if (QLog.isColorLevel())
        {
          QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
          paramToServiceMsg = localStringBuilder;
        }
      }
      paramFromServiceMsg = this.app;
      paramObject = String.valueOf(str4);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str3);
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131693198));
      AddMessageHelper.a(paramFromServiceMsg, paramObject, localStringBuilder.toString(), 1, false, true);
      notifyUI(1037, true, new Object[] { str1, Integer.valueOf(i), str2, paramToServiceMsg });
    }
    else
    {
      notifyUI(1037, false, new Object[] { str1, Integer.valueOf(i), str2, null });
      paramToServiceMsg = localObject;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleKickHotChatMemberResp,result= ");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",groupuin=");
      paramFromServiceMsg.append(str1);
      paramFromServiceMsg.append(",memberUin=");
      paramFromServiceMsg.append(str2);
      paramFromServiceMsg.append(",strErr=");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
    }
  }
  
  private void handleOIDB0x88D(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    int i = paramToServiceMsg.extraData.getInt("serviceType");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive, cmd:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("|serviceType:");
      localStringBuilder.append(i);
      QLog.d("HotChatHandler", 2, localStringBuilder.toString());
    }
    if (6 == i) {
      handleGetUserCreateHotChatAnnounce(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private void handleOIDBSvc0x882(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, String paramString)
  {
    if (paramToServiceMsg != null)
    {
      if (paramToServiceMsg.extraData == null) {
        return;
      }
      int i = paramToServiceMsg.extraData.getInt("serviceType");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive, cmd:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("|serviceType:");
        localStringBuilder.append(i);
        QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, localStringBuilder.toString());
      }
      if (i == 2)
      {
        handleGetHotChatAnnounce(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ((i == 5) || (i == 6)) {
        handleSetHotChatAdminFlag(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  private void handleOidbSvc0X8B2(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, String paramString)
  {
    if (paramToServiceMsg != null)
    {
      if (paramToServiceMsg.extraData == null) {
        return;
      }
      int i = paramToServiceMsg.extraData.getInt("serviceType");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleTimeOut, cmd:");
        localStringBuilder.append(paramString);
        localStringBuilder.append("|serviceType:");
        localStringBuilder.append(i);
        QLog.d("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, localStringBuilder.toString());
      }
      if (i == 2) {
        handleGetHotChatAnnounceTimeOutOrError(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  @NotNull
  private HotChatInfo handlePoiInfo(ToServiceMsg paramToServiceMsg, int paramInt1, int paramInt2, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt3)
  {
    HotChatInfo localHotChatInfo1 = HotChatInfo.createHotChat(paramWifiPOIInfo, false, paramInt1);
    paramInt1 = paramToServiceMsg.extraData.getInt("apolloGameId");
    if (paramInt1 > 0)
    {
      localHotChatInfo1.apolloGameId = paramInt1;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleQuickJoinHotChat jionHotChat, apolloGameId:");
        paramToServiceMsg.append(paramInt1);
        QLog.d("HotChatHandler", 2, paramToServiceMsg.toString());
      }
    }
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("PttShow", new Object[] { "handleQuickJoinHotChat", localHotChatInfo1 });
    }
    paramToServiceMsg = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    Object localObject = processHotChat(localHotChatInfo1, paramToServiceMsg);
    if (paramInt3 == 1)
    {
      paramToServiceMsg.a(localHotChatInfo1, paramInt2);
    }
    else if (paramInt3 == 2)
    {
      HotChatInfo localHotChatInfo2 = paramToServiceMsg.a(localHotChatInfo1.troopUin);
      if (localHotChatInfo2 == null)
      {
        paramToServiceMsg.a(localHotChatInfo1, 4);
      }
      else if (paramInt2 == 1)
      {
        paramToServiceMsg.a(localHotChatInfo1, paramInt2);
      }
      else
      {
        localHotChatInfo2.updateHotChatInfo(localHotChatInfo1);
        EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
        localEntityManager.update(localHotChatInfo2);
        localEntityManager.close();
      }
    }
    if (paramWifiPOIInfo.uint64_exit_group_code.has())
    {
      long l = paramWifiPOIInfo.uint64_exit_group_code.get();
      paramWifiPOIInfo = paramToServiceMsg.a();
      if ((localObject != null) && (paramWifiPOIInfo.size() > 0))
      {
        paramWifiPOIInfo = paramWifiPOIInfo.iterator();
        while (paramWifiPOIInfo.hasNext())
        {
          localObject = (HotChatInfo)paramWifiPOIInfo.next();
          if ((((HotChatInfo)localObject).adminLevel == 0) && (String.valueOf(l).equals(((HotChatInfo)localObject).troopUin))) {
            paramToServiceMsg.a((HotChatInfo)localObject, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_LEFT_OVERCOUNT);
          }
        }
      }
    }
    return localHotChatInfo1;
  }
  
  private void handleQuickJoinHotChat(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("hotnamecode");
    int j = paramToServiceMsg.extraData.getInt("HOTCHAT_EXTRA_FLAG");
    int k = paramToServiceMsg.extraData.getInt("preHotChatState");
    oidb_0x8ab.RspBody localRspBody = new oidb_0x8ab.RspBody();
    int m = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = null;
    Object localObject = null;
    if (m == 0)
    {
      try
      {
        if (localRspBody.poi_info.has()) {
          paramFromServiceMsg = (Common.WifiPOIInfo)localRspBody.poi_info.get();
        } else {
          paramFromServiceMsg = null;
        }
        try
        {
          if (localRspBody.join_poi_status.has()) {
            i = localRspBody.join_poi_status.get();
          } else {
            i = 0;
          }
        }
        catch (Exception paramObject) {}
        if (!QLog.isColorLevel()) {
          break label145;
        }
      }
      catch (Exception paramObject)
      {
        paramFromServiceMsg = null;
      }
      QLog.i("HotChatHandler", 2, paramObject.toString());
      label145:
      int i = 0;
      if (paramFromServiceMsg != null) {
        paramToServiceMsg = handlePoiInfo(paramToServiceMsg, j, k, paramFromServiceMsg, i);
      } else {
        paramToServiceMsg = localObject;
      }
      notifyUI(1034, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), str });
    }
    else
    {
      notifyUI(1034, false, new Object[] { null, null, Integer.valueOf(m), str });
      paramObject = null;
      paramToServiceMsg = paramFromServiceMsg;
      paramFromServiceMsg = paramObject;
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handleQuickJoinHotChat, ");
      paramObject.append(m);
      paramObject.append(",");
      paramObject.append(paramToServiceMsg);
      paramObject.append(",");
      paramObject.append(paramFromServiceMsg);
      QLog.i("HotChatHandler", 2, paramObject.toString());
    }
  }
  
  private void handleQuickJoinHotChatErrorOrTimeOut(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    System.out.println("-----> handleQuickJoinHotChatErrorOrTimeOut");
  }
  
  private void handleSetHotChatAdminFlag(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("uins");
    int k = paramToServiceMsg.extraData.getInt("serviceType");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
      paramObject = paramToServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramToServiceMsg = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
      paramObject = paramToServiceMsg;
    }
    int i;
    if ((paramObject != null) && (paramObject.uint32_result.has())) {
      i = paramObject.uint32_result.get();
    } else {
      i = -1;
    }
    if (i == 0)
    {
      paramToServiceMsg = new oidb_0x8b2.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
        }
      }
      paramToServiceMsg = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      paramFromServiceMsg = paramToServiceMsg.a(str);
      if (paramFromServiceMsg != null)
      {
        if ((localArrayList != null) && (localArrayList.size() > 0))
        {
          int j = 0;
          while (j < localArrayList.size())
          {
            paramObject = (String)localArrayList.get(j);
            if ((k == 5) && (!paramFromServiceMsg.adminUins.contains(paramObject))) {
              paramFromServiceMsg.adminUins.add(paramObject);
            } else if ((k == 6) && (paramFromServiceMsg.adminUins.contains(paramObject))) {
              paramFromServiceMsg.adminUins.remove(paramObject);
            }
            j += 1;
          }
        }
        paramToServiceMsg.a(paramFromServiceMsg);
      }
      notifyUI(1050, true, new Object[] { str, arrayOfByte, Integer.valueOf(i), Integer.valueOf(k), localArrayList });
    }
    else
    {
      notifyUI(1050, false, new Object[] { str, arrayOfByte, Integer.valueOf(i), Integer.valueOf(k), localArrayList });
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleSetHotChatAdminFlag==>,operaUins=");
      paramToServiceMsg.append(localArrayList);
      QLog.i("HotChatHandlerQ.hotchat.setadmin", 2, paramToServiceMsg.toString());
    }
  }
  
  private void handleSetHotChatAnnounce(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("uid");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
      paramObject = paramToServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramToServiceMsg = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
      paramObject = paramToServiceMsg;
    }
    int j = -1;
    int i = j;
    if (paramObject != null)
    {
      i = j;
      if (paramObject.uint32_result.has()) {
        i = paramObject.uint32_result.get();
      }
    }
    if (i == 0) {
      notifyUI(1035, true, new Object[] { arrayOfByte, Integer.valueOf(i), null });
    } else {
      notifyUI(1035, false, new Object[] { arrayOfByte, Integer.valueOf(i), null });
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleSetHotChatAnnounce,result= ");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(",strErr=");
      paramToServiceMsg.append(null);
      QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  private void handleSetHotChatAnnounceTimeOutOrError(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getByteArray("uid");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1035, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "" });
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleSetHotChatAnnounceTimeOutOrError,result= ");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",uid=");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
    }
  }
  
  private void handleSetUserCreateHotChatAnnounce(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("groupcode");
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
      paramObject = paramToServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramToServiceMsg = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
      paramObject = paramToServiceMsg;
    }
    int j = -1;
    int i = j;
    if (paramObject != null)
    {
      i = j;
      if (paramObject.uint32_result.has()) {
        i = paramObject.uint32_result.get();
      }
    }
    if (i == 0)
    {
      notifyUI(1040, true, new Object[] { str, Integer.valueOf(i), null });
    }
    else
    {
      paramToServiceMsg = new oidb_0x89a.RspBody();
      try
      {
        paramToServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg.str_errorinfo.has();
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
        }
      }
      notifyUI(1040, false, new Object[] { str, Integer.valueOf(i), null });
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleSetUserCreateHotChatAnnounce,result= ");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(",strErr=");
      paramToServiceMsg.append(null);
      QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  private void handleSetUserCreateHotChatAnnounceTimeOutOrError(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("groupcode");
    int i = paramFromServiceMsg.getResultCode();
    notifyUI(1040, false, new Object[] { paramToServiceMsg, Integer.valueOf(i), "" });
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleSetUserCreateHotChatAnnounce,result= ");
      paramFromServiceMsg.append(i);
      paramFromServiceMsg.append(",groupcode=");
      paramFromServiceMsg.append(paramToServiceMsg);
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
    }
  }
  
  private void handleTimeOut(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<---handleTimeOut serviceCmd:");
      localStringBuilder.append(str);
      QLog.d("HotChatHandler", 2, localStringBuilder.toString());
    }
    if ("OidbSvc.0x8a4".equals(str))
    {
      handleGetMyHostChatListRespError(paramToServiceMsg, paramFromServiceMsg, true);
      return;
    }
    if ("OidbSvc.0x89b_3".equals(str))
    {
      reqJoinOrExitHotChat(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x823_0".equals(str)) {
      return;
    }
    if ("OidbSvc.0x8a2".equals(str))
    {
      handleCreateHotChatRespErrorOrTimeOut(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x8ab".equals(str))
    {
      handleQuickJoinHotChatErrorOrTimeOut(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x8b3".equals(str))
    {
      handleSetHotChatAnnounceTimeOutOrError(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x8b2".equals(str))
    {
      handleOidbSvc0X8B2(paramToServiceMsg, paramFromServiceMsg, str);
      return;
    }
    if ("OidbSvc.0xa81".equals(str))
    {
      handleDismissHotChatTimeOutOrError(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x88d_0".equals(str))
    {
      handleGetUserCreateHotChatAnnounceTimeOutOrError(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x89a_0".equals(str))
    {
      handleSetUserCreateHotChatAnnounceTimeOutOrError(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0xa8b".equals(str)) {
      return;
    }
    if ("OidbSvc.0x897_0".equals(str))
    {
      handleGetHotChatTroopMemberList(paramToServiceMsg, paramFromServiceMsg, null);
      return;
    }
    if ("OidbSvc.0x88d_1".equals(str))
    {
      handleGetTroopInfo(paramToServiceMsg, paramFromServiceMsg, null);
      return;
    }
    if ("OidbSvc.0x8a7_0".equals(str)) {
      handleAtAllRemainCountResponse(paramToServiceMsg, paramFromServiceMsg, null);
    }
  }
  
  @Nullable
  private List<HotChatInfo> processHotChat(HotChatInfo paramHotChatInfo, HotChatManager paramHotChatManager)
  {
    List localList = paramHotChatManager.a();
    if ((localList != null) && (localList.size() > 0))
    {
      int i = localList.size() - 1;
      while (i >= 0)
      {
        HotChatInfo localHotChatInfo = (HotChatInfo)localList.get(i);
        if ((localHotChatInfo != null) && (localHotChatInfo.userCreate == paramHotChatInfo.userCreate) && (Utils.a(localHotChatInfo.uuid, paramHotChatInfo.uuid)) && (!Utils.a(localHotChatInfo.troopUin, paramHotChatInfo.troopUin)))
        {
          if (QLog.isColorLevel()) {
            NearbyUtils.a("HotChatHandler", new Object[] { "handleQuickJoinHotChat_check", String.format("userCreate:%d, uuid:%s, local:[%s,%s], server:[%s,%s]", new Object[] { Integer.valueOf(localHotChatInfo.userCreate), localHotChatInfo.uuid, localHotChatInfo.troopUin, localHotChatInfo.troopCode, paramHotChatInfo.troopUin, paramHotChatInfo.troopCode }) });
          }
          paramHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL);
        }
        i -= 1;
      }
    }
    return localList;
  }
  
  private void reqJoinOrExitHotChat(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getBoolean("kick", false))
    {
      handleKickHotChatMemberErrorOrTimeout(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isJoin")) {
      return;
    }
    handleExtHotChatRespErrorOrTimeOut(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public void closeHotChatPie(String paramString)
  {
    notifyUI(1056, true, new Object[] { paramString, EXIT_HOT_CHAT_SUCCESS });
  }
  
  public void deleteMember(String paramString1, String paramString2, String paramString3)
  {
    QQAppInterface localQQAppInterface = this.app;
    String str = String.valueOf(paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString3);
    localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131693198));
    AddMessageHelper.a(localQQAppInterface, str, localStringBuilder.toString(), 1, false, true);
    notifyUI(1037, true, new Object[] { paramString1, Integer.valueOf(0), paramString2, "" });
  }
  
  public boolean dismissHotChat(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dismissHotChat.groupcode=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("HotChatHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = new oidb_0xa81.ReqBody();
    long l = Long.valueOf(paramString).longValue();
    ((oidb_0xa81.ReqBody)localObject).uint64_groupcode.set(l);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dismissHotChat.intcode=");
      localStringBuilder.append(l);
      QLog.i("HotChatHandler", 2, localStringBuilder.toString());
    }
    localObject = makeOIDBPkg("OidbSvc.0xa81", 2689, 0, ((oidb_0xa81.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("groupcode", paramString);
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public void exitHotChat(IHotChatInfo paramIHotChatInfo, IHotChatStateWrapper paramIHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatHandler", new Object[] { "exitHotChat", paramIHotChatInfo, paramIHotChatStateWrapper });
    }
    if (paramIHotChatInfo == null)
    {
      notifyUI(1033, false, new Object[] { "", EXIT_HOT_CHAT_FAIL });
      return;
    }
    Object localObject = new oidb_0x89b.ExitPublicGroupReqBody();
    ((oidb_0x89b.ExitPublicGroupReqBody)localObject).uint64_visitor_uin.set(TroopFileHandler.a(this.app.getCurrentAccountUin()));
    oidb_0x89b.ReqBody localReqBody = new oidb_0x89b.ReqBody();
    localReqBody.uint64_group_code.set(TroopFileHandler.a(paramIHotChatInfo.getTroopUin()));
    localReqBody.uint32_req_type.set(5);
    localReqBody.msg_exit_group.set((MessageMicro)localObject);
    localObject = makeOIDBPkg("OidbSvc.0x89b_3", 2203, 3, localReqBody.toByteArray(), 10000L);
    ((ToServiceMsg)localObject).extraData.putBoolean("isJoin", false);
    ((ToServiceMsg)localObject).extraData.putString("troopUin", paramIHotChatInfo.getTroopUin());
    ((ToServiceMsg)localObject).extraData.putSerializable("targetHotChatState", (HotChatManager.HotChatStateWrapper)paramIHotChatStateWrapper);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x8a4");
      this.allowCmdSet.add("OidbSvc.0x89b_3");
      this.allowCmdSet.add("OidbSvc.0x823_0");
      this.allowCmdSet.add("OidbSvc.0x8a2");
      this.allowCmdSet.add("OidbSvc.0x8ab");
      this.allowCmdSet.add("OidbSvc.0x8b3");
      this.allowCmdSet.add("OidbSvc.0x8b2");
      this.allowCmdSet.add("OidbSvc.0x81f");
      this.allowCmdSet.add("OidbSvc.0xa81");
      this.allowCmdSet.add("OidbSvc.0x88d_0");
      this.allowCmdSet.add("OidbSvc.0x89a_0");
      this.allowCmdSet.add("OidbSvc.0x435");
      this.allowCmdSet.add("OidbSvc.0x897_0");
      this.allowCmdSet.add("OidbSvc.0x88d_1");
      this.allowCmdSet.add("OidbSvc.0xa8b");
      this.allowCmdSet.add("OidbSvc.0x8a3_7");
      this.allowCmdSet.add("OidbSvc.0x8a7_0");
      this.allowCmdSet.add("OidbSvc.0x62c_4");
    }
    return this.allowCmdSet;
  }
  
  public void getGlobalAdmin(long paramLong, String paramString)
  {
    Object localObject = new oidb_0x81f.ReqBody();
    ((oidb_0x81f.ReqBody)localObject).uint64_uin.set(paramLong);
    try
    {
      ((oidb_0x81f.ReqBody)localObject).gc.set(Long.parseLong(paramString));
      paramString = new oidb_0x81f.GetAuthDataReq();
      paramString.uint32_auth.set(1);
      ((oidb_0x81f.ReqBody)localObject).msg_auth_data.set(paramString);
      paramString = makeOIDBPkg("OidbSvc.0x81f", 2079, 0, ((oidb_0x81f.ReqBody)localObject).toByteArray());
      paramString.extraData.putLong("uin", paramLong);
      sendPbReq(paramString);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label89:
      break label89;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getGlobalAdmin, NumberFormatException. troopUin:");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("HotChatHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean getHotChatAnnounce(byte[] paramArrayOfByte, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getHotChatAnnounce.uid=");
      ((StringBuilder)localObject).append(new String(paramArrayOfByte));
      ((StringBuilder)localObject).append(", troopUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("HotChatHandlerQ.hotchat.oidb_0x8b2", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      localObject = new oidb_0x8b2.ReqBody();
      ((oidb_0x8b2.ReqBody)localObject).string_hot_group_id.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      localObject = makeOIDBPkg("OidbSvc.0x8b2", 2226, 2, ((oidb_0x8b2.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putInt("serviceType", 2);
      ((ToServiceMsg)localObject).extraData.putByteArray("uid", paramArrayOfByte);
      ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return true;
    }
    return false;
  }
  
  public void getHotChatAtAllRemainCount(String paramString1, String paramString2)
  {
    Object localObject = new cmd0x8a7.ReqBody();
    ((cmd0x8a7.ReqBody)localObject).uint32_sub_cmd.set(1);
    ((cmd0x8a7.ReqBody)localObject).uint32_limit_interval_type_for_uin.set(2);
    ((cmd0x8a7.ReqBody)localObject).uint32_limit_interval_type_for_group.set(1);
    try
    {
      ((cmd0x8a7.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((cmd0x8a7.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString2));
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(2215);
      paramString1.uint32_result.set(0);
      paramString1.uint32_service_type.set(1);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8a7.ReqBody)localObject).toByteArray()));
      localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "OidbSvc.0x8a7_0");
      ((ToServiceMsg)localObject).extraData.putString("troopCode", paramString2);
      ((ToServiceMsg)localObject).putWupBuffer(paramString1.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label148:
      break label148;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAnonymousChatNick error, NumberFormatException, uin : ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", troopUin : ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("Q.hotchat.remainCount", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void getHotChatMemberList(String paramString, long paramLong, int paramInt, boolean paramBoolean, int... paramVarArgs)
  {
    Object localObject = new cmd0x897.VisitorInfo();
    ((cmd0x897.VisitorInfo)localObject).uint64_visitor_uin.set(0L);
    ((cmd0x897.VisitorInfo)localObject).uint32_visitor_faceid.set(0);
    ((cmd0x897.VisitorInfo)localObject).string_visitor_nick.set(ByteStringMicro.copyFrom(new byte[0]));
    cmd0x897.GroupUinCode localGroupUinCode = new cmd0x897.GroupUinCode();
    try
    {
      localGroupUinCode.uint64_group_code.set(Long.parseLong(paramString));
    }
    catch (NumberFormatException paramString)
    {
      label65:
      break label65;
    }
    if (QLog.isColorLevel()) {
      QLog.e("HotChatHandler", 2, "get open troop member list, send pb request, params : troopUin / troop Code, NumberFormatException");
    }
    paramString = new cmd0x897.GroupNextVisitor();
    paramString.msg_group_uin_code.set(localGroupUinCode);
    paramString.uint64_next_visitor.set(paramInt);
    paramString.msg_req_field.set((MessageMicro)localObject);
    if (paramInt == 0)
    {
      if (paramBoolean) {
        paramString.uint32_guest_field.set(1);
      }
      paramString.uint32_administrator_field.set(1);
    }
    if ((paramVarArgs.length > 0) && (paramVarArgs[0] > 0)) {
      paramString.uint32_max_count.set(paramVarArgs[0]);
    } else {
      paramString.uint32_max_count.set(0);
    }
    paramVarArgs = new cmd0x897.ReqBody();
    localObject = new ArrayList();
    ((List)localObject).add(paramString);
    paramVarArgs.rpt_msg_grp_next_visitor.set((List)localObject);
    paramString = makeOIDBPkg("OidbSvc.0x897_0", 2199, 0, paramVarArgs.toByteArray());
    paramString.extraData.putLong("uitag", paramLong);
    sendPbReq(paramString);
  }
  
  public void getHotChatTroopInfo(String paramString, boolean paramBoolean)
  {
    Object localObject = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject).uint32_appid.set(0);
    oidb_0x88d.ReqGroupInfo localReqGroupInfo = new oidb_0x88d.ReqGroupInfo();
    localReqGroupInfo.uint64_group_code.set(Long.parseLong(paramString));
    localReqGroupInfo.uint32_last_get_group_name_time.set(0);
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    localGroupInfo.string_group_class_text.set(ByteStringMicro.copyFrom(new byte[0]));
    localGroupInfo.string_group_finger_memo.set(ByteStringMicro.copyFrom(new byte[0]));
    localGroupInfo.string_group_name.set(ByteStringMicro.copyFrom(new byte[0]));
    localGroupInfo.uint32_group_visitor_cur_num.set(0);
    localGroupInfo.uint32_group_member_num.set(0);
    localGroupInfo.uint32_group_class_ext.set(0);
    int i = (int)(System.currentTimeMillis() / 1000L);
    localGroupInfo.uint32_group_aio_skin_timestamp.set(i);
    localGroupInfo.uint32_group_board_skin_timestamp.set(i);
    localGroupInfo.uint32_group_cover_skin_timestamp.set(i);
    localReqGroupInfo.stgroupinfo.set(localGroupInfo);
    ((oidb_0x88d.ReqBody)localObject).stzreqgroupinfo.add(localReqGroupInfo);
    localObject = makeOIDBPkg("OidbSvc.0x88d_1", 2189, 1, ((oidb_0x88d.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("troopCode", paramString);
    ((ToServiceMsg)localObject).extraData.putBoolean("isHotChat", paramBoolean);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void getMyHotChatList()
  {
    getMyHotChatList(0);
    if (SharedPreUtils.h(this.app.getApplication(), getCurrentAccountUin())) {
      getMyHotChatList(2);
    }
    if (SharedPreUtils.g(this.app.getApplication(), getCurrentAccountUin())) {
      ((WerewolvesHandler)this.app.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(new HotChatHandler.1(this));
    }
  }
  
  public void getMyHotChatList(int paramInt)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a("HotChatHandler", new Object[] { "getMyHotChatList()", Boolean.valueOf(this.mIsReqiringMyHotChat) });
    }
    long l = Long.parseLong(this.app.getAccount());
    Object localObject = new GetJoinedHotChatList.ReqBody();
    ((GetJoinedHotChatList.ReqBody)localObject).uint64_uin.set(l);
    ((GetJoinedHotChatList.ReqBody)localObject).uint32_req_type.set(3);
    localObject = makeOIDBPkg("OidbSvc.0x8a4", 2212, paramInt, ((GetJoinedHotChatList.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).setTimeout(10000L);
    ((ToServiceMsg)localObject).extraData.putInt("serviceType", paramInt);
    sendPbReq((ToServiceMsg)localObject);
    this.mIsReqiringMyHotChat = true;
  }
  
  public Set<String> getPushCommandList()
  {
    HashSet localHashSet = this.pushCmd;
    if ((localHashSet == null) || (localHashSet.size() == 0))
    {
      this.pushCmd = new HashSet();
      this.pushCmd.add("OidbSvc.0x88d_0");
      this.pushCmd.add("OidbSvc.0x88d_1");
      this.pushCmd.add("OidbSvc.0x89a_0");
      this.pushCmd.add("OidbSvc.0x8a4");
      this.pushCmd.add("OidbSvc.0x8a2");
      this.pushCmd.add("OidbSvc.0x89b_3");
      this.pushCmd.add("OidbSvc.0x823_0");
      this.pushCmd.add("OidbSvc.0x8ab");
      this.pushCmd.add("OidbSvc.0x8b3");
      this.pushCmd.add("OidbSvc.0x8b2");
      this.pushCmd.add("OidbSvc.0x81f");
      this.pushCmd.add("OidbSvc.0xa81");
      this.pushCmd.add("OidbSvc.0x435");
      this.pushCmd.add("OidbSvc.0xa8b");
      this.pushCmd.add("OidbSvc.0x8a3_7");
      this.pushCmd.add("OidbSvc.0x897_0");
      this.pushCmd.add("OidbSvc.0x62c_4");
    }
    return this.pushCmd;
  }
  
  public void getUinByTinyId(ArrayList<String> paramArrayList)
  {
    oidb_cmd0x62c.ReqBody localReqBody = new oidb_cmd0x62c.ReqBody();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(Long.valueOf((String)paramArrayList.get(i)));
      i += 1;
    }
    localReqBody.uint64_tinyid.set(localArrayList);
    sendPbReq(makeOIDBPkg("OidbSvc.0x62c_4", 1580, 4, localReqBody.toByteArray(), 10000L));
  }
  
  public boolean getUserCreateHotChatAnnounce(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getUserCreateHotChatAnnounce.groupcode=");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("HotChatHandler", 2, ((StringBuilder)localObject1).toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(1L);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_memo.set(ByteStringMicro.copyFrom("1".getBytes()));
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.valueOf(paramString).longValue());
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.app.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = makeOIDBPkg("OidbSvc.0x88d_0", 2189, 6, ((oidb_0x88d.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("groupcode", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("serviceType", 6);
    sendPbReq((ToServiceMsg)localObject1);
    return true;
  }
  
  public void handleGetGlobalAdmin(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append(paramToServiceMsg.extraData.getLong("uin"));
    paramFromServiceMsg.append("");
    String str = paramFromServiceMsg.toString();
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = paramToServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg) {}
      paramObject = paramToServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramToServiceMsg = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.i("HotChatHandler", 2, paramFromServiceMsg.toString());
      paramObject = paramToServiceMsg;
    }
    int j = -1;
    int i = j;
    if (paramObject != null)
    {
      i = j;
      if (paramObject.uint32_result.has()) {
        i = paramObject.uint32_result.get();
      }
    }
    if (i == 0) {
      paramToServiceMsg = new oidb_0x81f.RspBody();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        if (paramToServiceMsg.msg_auth_data.has())
        {
          paramToServiceMsg = (oidb_0x81f.GetAuthDataRsp)paramToServiceMsg.msg_auth_data.get();
          j = paramToServiceMsg.uint32_auth.get();
          try
          {
            paramFromServiceMsg = (HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
            if (j != 0) {
              break label388;
            }
            bool = true;
            paramFromServiceMsg.a(bool);
            i = j;
            if (j != 0) {
              break label277;
            }
            paramFromServiceMsg.a(paramToServiceMsg.uint64_timestamp.get());
            i = j;
          }
          catch (Exception paramToServiceMsg)
          {
            continue;
          }
        }
        else
        {
          i = 0;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        j = 0;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
          i = j;
        }
      }
      label277:
      notifyUI(1051, true, new Object[] { str, Integer.valueOf(i) });
      break label332;
      notifyUI(1051, false, new Object[] { str, Integer.valueOf(0) });
      i = 0;
      label332:
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetGlobalAdmin==>,uin=");
        paramToServiceMsg.append(str);
        paramToServiceMsg.append("|auth:");
        paramToServiceMsg.append(i);
        QLog.i("HotChatHandlerQ.hotchat.setadmin", 2, paramToServiceMsg.toString());
      }
      return;
      label388:
      boolean bool = false;
    }
  }
  
  protected void handleGetHotChatMsgTimeOutOrError(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramFromServiceMsg.getResultCode();
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    String str = paramToServiceMsg.extraData.getString("uuid");
    long l = paramToServiceMsg.extraData.getLong("lStartMsgSeq");
    int j = paramToServiceMsg.extraData.getInt("lStartMsgSeq");
    int k = paramToServiceMsg.extraData.getInt("nOrder");
    int m = paramToServiceMsg.extraData.getInt("nFlag");
    if (m == 2) {
      notifyUI(1045, false, new Object[] { Integer.valueOf(i), paramFromServiceMsg, str, Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(0L), null });
    }
  }
  
  public void handleGetUinByTinyId(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((paramToServiceMsg != null) && (paramObject != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.has())
        {
          if (paramToServiceMsg.uint32_result.get() == 0)
          {
            paramFromServiceMsg = new oidb_cmd0x62c.RspBody();
            try
            {
              paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
              new ArrayList();
              paramToServiceMsg = paramFromServiceMsg.msg_tinyid_info.get();
              int i = 0;
              while (i < paramToServiceMsg.size())
              {
                localArrayList2.add(String.valueOf(((oidb_cmd0x62c.TinyIDInfo)paramToServiceMsg.get(i)).uint64_tinyid.get()));
                localArrayList1.add(String.valueOf(((oidb_cmd0x62c.TinyIDInfo)paramToServiceMsg.get(i)).uint64_uin.get()));
                i += 1;
              }
              notifyUI(1058, true, new Object[] { localArrayList1, localArrayList2 });
              return;
            }
            catch (InvalidProtocolBufferMicroException paramToServiceMsg)
            {
              notifyUI(1058, false, new Object[] { localArrayList1, localArrayList2 });
              if (QLog.isColorLevel()) {
                QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
              }
            }
          }
          return;
        }
        notifyUI(1058, false, new Object[] { localArrayList1, localArrayList2 });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("HotChatHandler", 2, paramToServiceMsg.toString());
        }
        notifyUI(1058, false, new Object[] { localArrayList1, localArrayList2 });
        return;
      }
    }
    notifyUI(1058, false, new Object[] { localArrayList1, localArrayList2 });
  }
  
  public void insertAtTroopMem(String paramString1, String paramString2, String paramString3)
  {
    notifyUI(1054, true, new Object[] { paramString1, paramString2, paramString3 });
  }
  
  public boolean isTodayWiFiReportedAndSave(LBS.Wifi paramWifi)
  {
    Object localObject1 = BaseApplicationImpl.getApplication();
    boolean bool3 = false;
    boolean bool1 = false;
    localObject1 = ((BaseApplicationImpl)localObject1).getSharedPreferences("qb_hc_hotchat_global", 0);
    String str = ((SharedPreferences)localObject1).getString("qb_hc_report_wifi_cache2", "");
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isTodayWiFiReported wifiCache = ");
      ((StringBuilder)localObject2).append(str);
      QLog.d("HotChatHandler", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramWifi.essid.get().toStringUtf8());
    ((StringBuilder)localObject2).append(paramWifi.mac.get());
    localObject2 = MD5Utils.encodeHexStr(((StringBuilder)localObject2).toString());
    boolean bool2 = bool3;
    try
    {
      if (TextUtils.isEmpty(str))
      {
        bool2 = bool3;
        paramWifi = new JSONObject();
      }
      else
      {
        bool2 = bool3;
        paramWifi = new JSONObject(str);
      }
      bool2 = bool3;
      long l1 = paramWifi.optLong((String)localObject2, 0L);
      bool2 = bool3;
      long l2 = System.currentTimeMillis();
      if (l2 - l1 > 86400000L) {
        bool1 = true;
      }
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        paramWifi.put((String)localObject2, l2);
        bool2 = bool1;
        ((SharedPreferences)localObject1).edit().putString("qb_hc_report_wifi_cache2", paramWifi.toString()).commit();
        bool2 = bool1;
      }
    }
    catch (Exception paramWifi)
    {
      paramWifi.printStackTrace();
      ((SharedPreferences)localObject1).edit().putString("qb_hc_report_wifi_cache2", "").commit();
    }
    if (QLog.isColorLevel())
    {
      paramWifi = new StringBuilder();
      paramWifi.append("isTodayWiFiReported isNeed = ");
      paramWifi.append(bool2);
      QLog.d("HotChatHandler", 2, paramWifi.toString());
    }
    return bool2;
  }
  
  public void joinHotChat(Object paramObject, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Common.WifiPOIInfo localWifiPOIInfo = (Common.WifiPOIInfo)paramObject;
    if (QLog.isColorLevel()) {}
    try
    {
      paramObject = new StringBuilder();
      paramObject.append("joinHotChat() WifiPOIInfo = ");
      paramObject.append(localWifiPOIInfo.bytes_name.get().toStringUtf8());
      paramObject.append(", ");
      paramObject.append(localWifiPOIInfo.bytes_uid.get().toStringUtf8());
      QLog.i("HotChatHandler", 2, paramObject.toString());
    }
    catch (Exception paramObject)
    {
      label81:
      int i;
      break label81;
    }
    i = 0;
    paramObject = null;
    if (localWifiPOIInfo.uint32_group_uin.has()) {
      paramObject = String.valueOf(Utils.a(localWifiPOIInfo.uint32_group_uin.get()));
    }
    if ((paramObject == null) || (paramObject.equals("")) || (paramObject.equals("0"))) {
      i = 1;
    }
    if (i != 0)
    {
      createHotChat(localWifiPOIInfo, paramBoolean, paramInt2);
      return;
    }
    try
    {
      quickJoinHotChat(localWifiPOIInfo.bytes_uid.get().toStringUtf8(), paramInt2, true, paramInt1);
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
      return;
    }
  }
  
  public boolean kickHotChatMember(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("kickHotChatMember.groupcode=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",groupuin=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",memberuin=");
      ((StringBuilder)localObject).append(paramString3);
      QLog.i("HotChatHandler", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (this.app.getHotChatMng(true).b()) {
        return kickHotChatMemberByGlobalAdmin(paramString1, paramString2, paramString3, paramString4, paramInt);
      }
      localObject = new oidb_0x89b.KickPublicGroupVisitorReqBody();
      ((oidb_0x89b.KickPublicGroupVisitorReqBody)localObject).rpt_uint64_visitor_uin.add(Long.valueOf(paramString3));
      oidb_0x89b.ReqBody localReqBody = new oidb_0x89b.ReqBody();
      localReqBody.uint64_group_uin.set(Long.valueOf(paramString2).longValue());
      localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
      localReqBody.uint32_req_type.set(6);
      localReqBody.msg_kick_visitor.set((MessageMicro)localObject);
      localObject = makeOIDBPkg("OidbSvc.0x89b_3", 2203, 5, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("groupcode", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("groupuin", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("memberuin", paramString3);
      ((ToServiceMsg)localObject).extraData.putBoolean("kick", true);
      ((ToServiceMsg)localObject).extraData.putString("nickname", paramString4);
      sendPbReq((ToServiceMsg)localObject);
      return true;
    }
    return false;
  }
  
  public boolean kickHotChatMemberByGlobalAdmin(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("kickHotChatMemberByGlobalAdmin.groupcode=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",groupuin=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(",memberuin=");
      ((StringBuilder)localObject1).append(paramString3);
      QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty(paramString3)) {
        return false;
      }
      localObject2 = new ArrayList();
    }
    try
    {
      ((List)localObject2).add(Long.valueOf(Long.parseLong(paramString3)));
      localObject1 = new oidb_0x823.KickPublicGroupVisitorReqBody();
      ((oidb_0x823.KickPublicGroupVisitorReqBody)localObject1).rpt_uint64_visitor_uin.set((List)localObject2);
      localObject2 = new oidb_0x823.PlayerDeviceInfo();
      ((oidb_0x823.PlayerDeviceInfo)localObject2).int32_client_type.set(1);
      ((oidb_0x823.PlayerDeviceInfo)localObject2).uint32_portal.set(paramInt);
      oidb_0x823.ReqBody localReqBody = new oidb_0x823.ReqBody();
      localReqBody.msg_kick_visitor.set((MessageMicro)localObject1);
      localReqBody.uint64_group_uin.set(Long.valueOf(paramString2).longValue());
      localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
      localReqBody.msg_req_info.set((MessageMicro)localObject2);
      localObject1 = makeOIDBPkg("OidbSvc.0x823_0", 2083, 0, localReqBody.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("groupcode", paramString1);
      ((ToServiceMsg)localObject1).extraData.putString("groupuin", paramString2);
      ((ToServiceMsg)localObject1).extraData.putString("memberuin", paramString3);
      ((ToServiceMsg)localObject1).extraData.putBoolean("kick", true);
      ((ToServiceMsg)localObject1).extraData.putString("nickname", paramString4);
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    catch (NumberFormatException paramString1)
    {
      label315:
      break label315;
    }
    if (QLog.isColorLevel()) {
      QLog.i("HotChatHandlerQ.hotchat.hotchat_kick_mem_by_global_admin", 2, "kickHotChatMemberByGlobalAdmin.NumberFormatException");
    }
    return false;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return HotChatObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.d("HotChatHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if (paramFromServiceMsg.getResultCode() == 1002)
    {
      handleTimeOut(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      handleError(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x8a4".equals(str))
    {
      handleGetMyHotChatListResp(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x89b_3".equals(str))
    {
      handleJoinOrExitHotChat(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x823_0".equals(str))
    {
      handleKickHotChatMemberByGlobalAmdminResp(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x8a2".equals(str))
    {
      handleCreateHotChatResp(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x8ab".equals(str))
    {
      handleQuickJoinHotChat(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x8b3".equals(str))
    {
      handleSetHotChatAnnounce(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x8b2".equals(str))
    {
      handleOIDBSvc0x882(paramToServiceMsg, paramFromServiceMsg, paramObject, str);
      return;
    }
    if ("OidbSvc.0x81f".equals(str))
    {
      handleGetGlobalAdmin(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xa81".equals(str))
    {
      handleDismissHotChat(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x88d_0".equals(str))
    {
      handleOIDB0x88D(paramToServiceMsg, paramFromServiceMsg, paramObject, str);
      return;
    }
    if ("OidbSvc.0x89a_0".equals(str))
    {
      handleSetUserCreateHotChatAnnounce(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x435".equals(str)) {
      return;
    }
    if ("OidbSvc.0x897_0".equals(str))
    {
      handleGetHotChatTroopMemberList(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x88d_1".equals(str))
    {
      handleGetTroopInfo(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x8a3_7".equals(str)) {
      return;
    }
    if ("OidbSvc.0x8a7_0".equals(str))
    {
      handleAtAllRemainCountResponse(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x62c_4".equals(str)) {
      handleGetUinByTinyId(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void openHotChatMemberProfileCard(String paramString1, String paramString2)
  {
    notifyUI(1057, true, new Object[] { paramString1, paramString2 });
  }
  
  public boolean quickJoinHotChat(String paramString, int paramInt, boolean paramBoolean)
  {
    return quickJoinHotChat(paramString, paramInt, paramBoolean, 4);
  }
  
  public boolean quickJoinHotChat(String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return quickJoinHotChat(paramString, paramInt1, paramBoolean, paramInt2, -1);
  }
  
  public boolean quickJoinHotChat(String paramString, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      Object localObject2 = getLBSInfo(false);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!paramBoolean) {
          localObject1 = new LBS.LBSInfo();
        }
      }
      if (localObject1 == null)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("quickJoinHotChat, lbs is null, needLBS = ");
          paramString.append(paramBoolean);
          QLog.i("HotChatHandler", 2, paramString.toString());
        }
        return false;
      }
      localObject2 = new oidb_0x8ab.ReqBody();
      ((oidb_0x8ab.ReqBody)localObject2).hotnamecode.set(ByteStringMicro.copyFromUtf8(paramString));
      ((oidb_0x8ab.ReqBody)localObject2).lbs_info.set((MessageMicro)localObject1);
      ((oidb_0x8ab.ReqBody)localObject2).version_flag.set(1);
      localObject1 = makeOIDBPkg("OidbSvc.0x8ab", 2219, 0, ((oidb_0x8ab.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putString("hotnamecode", paramString);
      ((ToServiceMsg)localObject1).extraData.putInt("HOTCHAT_EXTRA_FLAG", paramInt1);
      ((ToServiceMsg)localObject1).extraData.putInt("preHotChatState", paramInt2);
      if (paramInt3 > 0) {
        ((ToServiceMsg)localObject1).extraData.putInt("apolloGameId", paramInt3);
      }
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    return false;
  }
  
  public void sendGiftToPerson(String paramString1, String paramString2)
  {
    notifyUI(1055, true, new Object[] { paramString1, paramString2 });
  }
  
  public void setHotChatAdminFlag(AppInterface paramAppInterface, String paramString, List<Long> paramList, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setHotChatAdminFlag:|serviceType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("HotChatHandlerQ.hotchat.setadmin", 2, ((StringBuilder)localObject).toString());
    }
    oidb_0x8b2.ReqBody localReqBody;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if ((paramInt != 5) && (paramInt != 6))
      {
        if (QLog.isColorLevel()) {
          QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, "serviceType is not correct!");
        }
        return;
      }
      localReqBody = new oidb_0x8b2.ReqBody();
    }
    try
    {
      localReqBody.uint64_group_code.set(Long.parseLong(paramString));
      HotChatInfo localHotChatInfo = ((HotChatManager)paramAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
      localObject = null;
      paramAppInterface = (AppInterface)localObject;
      if (localHotChatInfo != null)
      {
        paramAppInterface = (AppInterface)localObject;
        if (localHotChatInfo.uuid != null)
        {
          paramAppInterface = localHotChatInfo.uuid.getBytes();
          localReqBody.string_hot_group_id.set(ByteStringMicro.copyFrom(paramAppInterface));
        }
      }
      localReqBody.uint64_administrator_uin.set(paramList);
      localObject = makeOIDBPkg("OidbSvc.0x8b2", 2226, paramInt, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).extraData.putInt("serviceType", paramInt);
      ((ToServiceMsg)localObject).extraData.putByteArray("uid", paramAppInterface);
      ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
      paramAppInterface = new ArrayList();
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        paramString = new StringBuilder();
        paramString.append(paramList.get(paramInt));
        paramString.append("");
        paramAppInterface.add(paramString.toString());
        paramInt += 1;
      }
      ((ToServiceMsg)localObject).extraData.putStringArrayList("uins", paramAppInterface);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException paramAppInterface)
    {
      label323:
      break label323;
    }
    if (QLog.isColorLevel())
    {
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("NumberFormatException ,troopUinis not correct,");
      paramAppInterface.append(paramString);
      QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, paramAppInterface.toString());
    }
    return;
    if (QLog.isColorLevel()) {
      QLog.e("HotChatHandlerQ.hotchat.setadmin", 2, "memberUins is empty!");
    }
  }
  
  public boolean setHotChatAnnounce(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setHotChatAnnounce.memo=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",url=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",uid=");
      ((StringBuilder)localObject).append(new String(paramArrayOfByte));
      QLog.i("HotChatHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return false;
      }
      localObject = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        localObject = "";
      }
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "";
      }
      paramString2 = new oidb_0x8b3.ReqBody();
      paramString2.string_hot_group_id.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      oidb_0x8b3.groupinfo localgroupinfo = new oidb_0x8b3.groupinfo();
      localgroupinfo.string_group_memo.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
      localgroupinfo.string_jumping_url.set(ByteStringMicro.copyFrom(paramString1.getBytes()));
      paramString2.st_group_info.set(localgroupinfo);
      paramString1 = makeOIDBPkg("OidbSvc.0x8b3", 2227, 0, paramString2.toByteArray());
      paramString1.extraData.putByteArray("uid", paramArrayOfByte);
      sendPbReq(paramString1);
      return true;
    }
    return false;
  }
  
  public boolean setUserCreateHotChatAnnounce(String paramString1, String paramString2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setUserCreateHotChatAnnounce.groupcode=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",memo=");
      ((StringBuilder)localObject).append(paramString2);
      QLog.i("HotChatHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      if (paramString2 == null) {
        return false;
      }
      localObject = new oidb_0x89a.groupinfo();
      ((oidb_0x89a.groupinfo)localObject).string_group_memo.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
      paramString2 = this.app.getCurrentAccountUin();
      oidb_0x89a.ReqBody localReqBody = new oidb_0x89a.ReqBody();
      localReqBody.uint64_group_code.set(Long.valueOf(paramString1).longValue());
      localReqBody.uint64_original_operator_uin.set(Long.valueOf(paramString2).longValue());
      localReqBody.st_group_info.set((MessageMicro)localObject);
      paramString2 = makeOIDBPkg("OidbSvc.0x89a_0", 2202, 0, localReqBody.toByteArray());
      paramString2.extraData.putString("groupcode", paramString1);
      sendPbReq(paramString2);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatHandler
 * JD-Core Version:    0.7.0.1
 */