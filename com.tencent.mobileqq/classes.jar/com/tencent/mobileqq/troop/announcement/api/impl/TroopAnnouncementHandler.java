package com.tencent.mobileqq.troop.announcement.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHandler;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi.FeedItem;
import com.tencent.mobileqq.troop.announcement.api.TroopAnnouncementObserver;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.TroopAnnouncementHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.trunk.group_feeds.group_feeds.GroupFeedsMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GroupFeedsRecord;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.ReqBody;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.ResultMsg;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.RspBody;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.SourceID;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopAnnouncementHandler
  extends TroopBaseHandler
  implements ITroopAnnouncementHandler
{
  private static HashMap<String, Boolean> a = new HashMap();
  
  public TroopAnnouncementHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt2, String paramString2, short paramShort, boolean paramBoolean)
  {
    paramString1 = new TroopAnnouncementHandler.1(this, paramLong2, paramString2, paramInt1, paramLong1, paramLong3, paramString1, paramInt2, paramShort, paramBoolean);
    this.appRuntime.addDefaultObservers(paramString1);
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt2, String paramString2, short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)this.appRuntime.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
    byte[] arrayOfByte = localITroopInfoHandler.a(paramLong2);
    Boolean localBoolean = Boolean.valueOf(true);
    if ((!paramBoolean2) && (arrayOfByte != null))
    {
      short s = (short)arrayOfByte.length;
      if ("OidbSvc.0x852_35".equals(paramString2))
      {
        a.put(paramString1, localBoolean);
        a(paramInt1, paramLong1, paramLong2, s, arrayOfByte, paramLong3, paramString1, paramInt2);
        return;
      }
      if ("OidbSvc.0x852_48".equals(paramString2)) {
        a(paramInt1, paramLong1, paramLong2, s, arrayOfByte, paramShort, paramBoolean1);
      }
      return;
    }
    if ("OidbSvc.0x852_35".equals(paramString2)) {
      a.put(paramString1, localBoolean);
    }
    a(paramInt1, paramLong1, paramLong2, paramLong3, paramString1, paramInt2, paramString2, paramShort, paramBoolean1);
    localITroopInfoHandler.a(paramLong2, "SUBCMD_GET_TROOP_AUTH_FOR_ANNOUNCEMENT");
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, short paramShort, byte[] paramArrayOfByte, long paramLong3, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAnnouncementHandler", 2, "send get notices");
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x852_35");
    paramArrayOfByte = a(paramLong2, paramShort, paramArrayOfByte, paramString);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2130);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(35);
    if (paramArrayOfByte != null) {
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    localToServiceMsg.putWupBuffer(localOIDBSSOPkg.toByteArray());
    localToServiceMsg.extraData.putInt("appId", paramInt1);
    localToServiceMsg.extraData.putLong("troopUin", paramLong1);
    localToServiceMsg.extraData.putLong("troopCode", paramLong2);
    localToServiceMsg.extraData.putLong("userUin", paramLong3);
    localToServiceMsg.extraData.putString("feedsId", paramString);
    localToServiceMsg.extraData.putInt("time", paramInt2);
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    localToServiceMsg.extraData.putString("REQ_TAG", a());
    this.appRuntime.sendToService(localToServiceMsg);
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2, short paramShort1, byte[] paramArrayOfByte, short paramShort2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAnnouncementHandler", 2, "send get troop guide");
    }
    int i = (int)paramLong2;
    String str = this.appRuntime.getCurrentAccountUin();
    long l2 = 0L;
    long l1;
    try
    {
      l1 = Long.valueOf(str.trim()).longValue();
      l1 &= 0xFFFFFFFF;
    }
    catch (Exception localException)
    {
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopAnnouncementHandler", 2, localException.getMessage());
        l1 = l2;
      }
    }
    int j = (int)(System.currentTimeMillis() / 1000L);
    int k = (int)(System.currentTimeMillis() / 1000L);
    byte[] arrayOfByte = new byte[16];
    int m = 47 + paramShort1;
    int n = (short)m;
    try
    {
      Object localObject1 = new ByteArrayOutputStream();
      Object localObject2 = new DataOutputStream((OutputStream)localObject1);
      ((DataOutputStream)localObject2).writeInt(m);
      ((DataOutputStream)localObject2).write(1);
      ((DataOutputStream)localObject2).writeShort(n);
      ((DataOutputStream)localObject2).writeInt(i);
      ((DataOutputStream)localObject2).writeInt((int)l1);
      ((DataOutputStream)localObject2).writeShort(paramShort2);
      ((DataOutputStream)localObject2).writeInt(-1);
      ((DataOutputStream)localObject2).writeInt(1);
      ((DataOutputStream)localObject2).writeInt(j);
      ((DataOutputStream)localObject2).writeInt(k);
      ((DataOutputStream)localObject2).writeShort(paramShort1);
      ((DataOutputStream)localObject2).write(paramArrayOfByte);
      ((DataOutputStream)localObject2).write(arrayOfByte);
      paramArrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
      ((DataOutputStream)localObject2).close();
      ((ByteArrayOutputStream)localObject1).close();
      localObject1 = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x852_48");
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2130);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(48);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("appId", paramInt);
      ((ToServiceMsg)localObject1).extraData.putLong("troopUin", paramLong1);
      ((ToServiceMsg)localObject1).extraData.putLong("troopCode", paramLong2);
      ((ToServiceMsg)localObject1).extraData.putInt("feedType", paramShort2);
      ((ToServiceMsg)localObject1).extraData.putBoolean("aioRequest", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putBoolean("req_pb_protocol_flag", true);
      ((ToServiceMsg)localObject1).extraData.putString("REQ_TAG", a());
      this.appRuntime.sendToService((ToServiceMsg)localObject1);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAnnouncementHandler", 2, paramArrayOfByte.getMessage());
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      Object localObject2 = paramToServiceMsg.extraData.getString("from");
      Object localObject1 = new oidb_0x8f9.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
      if ("getLatestTroopMemo".equals(localObject2))
      {
        paramFromServiceMsg = null;
        paramObject = null;
        int i = j;
        if (j == 0)
        {
          j = ((oidb_0x8f9.RspBody)localObject1).msg_result_msg.uint32_result.get();
          i = j;
          if (j == 0)
          {
            localObject2 = ((oidb_0x8f9.RspBody)localObject1).rpt_feeds_recored.get();
            paramFromServiceMsg = paramObject;
            if (localObject2 != null)
            {
              paramFromServiceMsg = paramObject;
              if (((List)localObject2).size() > 0) {
                paramFromServiceMsg = (oidb_0x8f9.GroupFeedsRecord)((List)localObject2).get(0);
              }
            }
            i = j;
            bool = true;
            break label141;
          }
        }
        boolean bool = false;
        label141:
        long l1 = paramToServiceMsg.extraData.getLong("group_code");
        j = ((oidb_0x8f9.RspBody)localObject1).msg_source_id.uint32_source_type.get();
        long l2 = ((oidb_0x8f9.RspBody)localObject1).msg_source_id.uint64_source_code.get();
        if ((bool) && ((j != 1) || (l1 != l2)) && (QLog.isColorLevel())) {
          QLog.i("TroopAnnouncementHandler", 2, String.format("0x8f9_14 [%s, %s, %s]", new Object[] { Integer.valueOf(j), Long.valueOf(l2), Long.valueOf(l1) }));
        }
        paramToServiceMsg = this.appRuntime;
        paramObject = "";
        localObject2 = (ITroopInfoService)paramToServiceMsg.getRuntimeService(ITroopInfoService.class, "");
        localObject1 = String.valueOf(l1);
        TroopInfo localTroopInfo = ((ITroopInfoService)localObject2).getTroopInfo((String)localObject1);
        paramToServiceMsg = paramObject;
        if (bool)
        {
          paramToServiceMsg = paramObject;
          if (localTroopInfo != null)
          {
            paramToServiceMsg = paramObject;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              a(paramFromServiceMsg, localTroopInfo);
              ((ITroopInfoService)localObject2).updateEntity(localTroopInfo);
              paramToServiceMsg = localTroopInfo.getLatestMemo();
            }
          }
        }
        notifyUI(TroopAnnouncementObserver.a, bool, new Object[] { localObject1, paramToServiceMsg });
        if (QLog.isColorLevel()) {
          QLog.i("TroopAnnouncementHandler", 2, String.format("0x8f9_14 latest memo suc: %s, uin: %s, re: %s, data: %s", new Object[] { Boolean.valueOf(bool), localObject1, Integer.valueOf(i), paramFromServiceMsg }));
        }
      }
      else if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("0x8f9_14 unknow from:  ");
        paramToServiceMsg.append((String)localObject2);
        QLog.i("TroopAnnouncementHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    QLog.i("TroopAnnouncementHandler", 1, "0x8f9_6 req or resp is null.");
  }
  
  private void a(oidb_0x8f9.GroupFeedsRecord paramGroupFeedsRecord, TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {
      return;
    }
    if (paramGroupFeedsRecord != null) {
      try
      {
        group_feeds.GroupFeedsMessage localGroupFeedsMessage = (group_feeds.GroupFeedsMessage)paramGroupFeedsRecord.msg_feeds_content.get();
        paramGroupFeedsRecord = ((ITroopAnnouncementHelperApi)QRoute.api(ITroopAnnouncementHelperApi.class)).decodeToFeedItem(String.valueOf(paramGroupFeedsRecord.uint32_feeds_type.get()), localGroupFeedsMessage.toByteArray(), true);
        if (paramGroupFeedsRecord != null) {
          paramTroopInfo.strLastAnnouncement = paramGroupFeedsRecord.jdField_c_of_type_JavaLangString;
        } else {
          paramTroopInfo.strLastAnnouncement = "";
        }
      }
      catch (Throwable paramGroupFeedsRecord)
      {
        paramGroupFeedsRecord.printStackTrace();
        paramTroopInfo.strLastAnnouncement = "";
      }
    } else {
      paramTroopInfo.strLastAnnouncement = "";
    }
    if (paramTroopInfo.strLastAnnouncement == null) {
      paramTroopInfo.strLastAnnouncement = "";
    }
    if (QLog.isColorLevel())
    {
      paramGroupFeedsRecord = new StringBuilder();
      paramGroupFeedsRecord.append("setLastMemoData : ");
      paramGroupFeedsRecord.append(paramTroopInfo.strLastAnnouncement);
      QLog.i("TroopAnnouncementHandler", 2, paramGroupFeedsRecord.toString());
    }
  }
  
  private static byte[] a(long paramLong, short paramShort, byte[] paramArrayOfByte, String paramString)
  {
    int j = (int)paramLong;
    byte[] arrayOfByte1 = new byte[32];
    int i = 0;
    Arrays.fill(arrayOfByte1, (byte)0);
    paramString = paramString.getBytes();
    while ((i < 32) && (i < paramString.length))
    {
      arrayOfByte1[i] = paramString[i];
      i += 1;
    }
    i = (int)(System.currentTimeMillis() / 1000L);
    int k = (int)(System.currentTimeMillis() / 1000L);
    byte[] arrayOfByte2 = new byte[16];
    int m = 65 + paramShort;
    int n = (short)m;
    try
    {
      paramString = new ByteArrayOutputStream();
      DataOutputStream localDataOutputStream = new DataOutputStream(paramString);
      localDataOutputStream.writeInt(m);
      localDataOutputStream.write(1);
      localDataOutputStream.writeShort(n);
      localDataOutputStream.writeInt(j);
      localDataOutputStream.write(arrayOfByte1);
      localDataOutputStream.writeInt(i);
      localDataOutputStream.writeInt(k);
      localDataOutputStream.writeShort(paramShort);
      localDataOutputStream.write(paramArrayOfByte);
      localDataOutputStream.write(arrayOfByte2);
      paramArrayOfByte = paramString.toByteArray();
      localDataOutputStream.close();
      paramString.close();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAnnouncementHandler", 2, paramArrayOfByte.getMessage());
      }
    }
    return null;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAnnouncementHandler", 2, "handleGetTroopNotification");
    }
    int i = paramToServiceMsg.extraData.getInt("appId");
    long l1 = paramToServiceMsg.extraData.getLong("troopUin");
    long l2 = paramToServiceMsg.extraData.getLong("troopCode");
    String str = paramToServiceMsg.extraData.getString("feedsId");
    paramFromServiceMsg = (byte[])paramObject;
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
    {
      int j = paramToServiceMsg.uint32_result.get();
      if (j != 0)
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("0x852_35 cResult=");
          paramToServiceMsg.append(j);
          QLog.d("TroopAnnouncementHandler", 2, paramToServiceMsg.toString());
        }
        a.remove(str);
        return;
      }
      try
      {
        paramToServiceMsg = new DataInputStream(new ByteArrayInputStream(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()));
        paramToServiceMsg.readInt();
        paramToServiceMsg = a(paramToServiceMsg, false);
        TroopAnnouncementHandlerProcessorConfig.a().a(this.appRuntime, l1, l2, i, paramToServiceMsg, str);
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopAnnouncementHandler", 2, paramToServiceMsg.getMessage());
        }
      }
      a.remove(str);
      return;
    }
    a.remove(str);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() != 1000) {
      return;
    }
    int i = paramToServiceMsg.extraData.getInt("appId");
    long l1 = paramToServiceMsg.extraData.getLong("troopUin");
    long l2 = paramToServiceMsg.extraData.getLong("troopCode");
    String str = paramToServiceMsg.extraData.getString("feedsId");
    int j = paramToServiceMsg.extraData.getInt("feedType");
    boolean bool = paramToServiceMsg.extraData.getBoolean("aioRequest", false);
    paramFromServiceMsg = (byte[])paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("TroopAnnouncementHandler", 2, "handle get troop guide");
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
    }
    if (paramToServiceMsg != null)
    {
      if (!paramToServiceMsg.uint32_result.has()) {
        return;
      }
      int k = paramToServiceMsg.uint32_result.get();
      if (k != 0)
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("oidb0x852_48 cResult=");
          paramToServiceMsg.append(k);
          paramToServiceMsg.append(", troop = ");
          paramToServiceMsg.append(l2);
          paramToServiceMsg.append(", feedType = ");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append(", aioRequest = ");
          paramToServiceMsg.append(bool);
          QLog.d("TroopAnnouncementHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      paramToServiceMsg = new DataInputStream(new ByteArrayInputStream(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()));
      TroopAnnouncementHandlerProcessorConfig.a().a(this.appRuntime, l1, l2, i, str, j, bool, paramToServiceMsg);
    }
  }
  
  public ITroopAnnouncementHelperApi.FeedItem a(DataInputStream paramDataInputStream, boolean paramBoolean)
  {
    paramDataInputStream.read();
    paramDataInputStream.readShort();
    int k = paramDataInputStream.readShort();
    paramDataInputStream.readInt();
    int m = paramDataInputStream.readInt();
    byte[] arrayOfByte2 = new byte[32];
    Arrays.fill(arrayOfByte2, (byte)0);
    paramDataInputStream.read(arrayOfByte2);
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    int n = paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.readInt();
    paramDataInputStream.skip(paramDataInputStream.readShort() * 5);
    paramDataInputStream.skip(16L);
    byte[] arrayOfByte1 = new byte[paramDataInputStream.readInt()];
    paramDataInputStream.read(arrayOfByte1);
    paramDataInputStream = new String(arrayOfByte2);
    int j = paramDataInputStream.indexOf(0);
    int i = j;
    if (j == -1) {
      i = paramDataInputStream.length();
    }
    paramDataInputStream = paramDataInputStream.substring(0, i);
    paramDataInputStream = ((ITroopAnnouncementHelperApi)QRoute.api(ITroopAnnouncementHelperApi.class)).decodeToFeedItem(paramDataInputStream, arrayOfByte1, paramBoolean);
    if (paramDataInputStream != null)
    {
      if (m < 0) {
        paramDataInputStream.a = (m & 0xFFFFFFFF);
      } else {
        paramDataInputStream.a = m;
      }
      paramDataInputStream.jdField_c_of_type_Int = n;
      paramDataInputStream.b = k;
    }
    return paramDataInputStream;
  }
  
  protected String a()
  {
    return "TroopAnnouncementHandler";
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2, short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt1, paramLong1, paramLong2, paramLong3, paramString, paramInt2, "OidbSvc.0x852_35", paramShort, paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  public void a(String paramString)
  {
    long l;
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      l = 0L;
    }
    if (l == 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getLatestTroopMemo group code is 0! groupCode: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("TroopAnnouncementHandler", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = new oidb_0x8f9.SourceID();
    ((oidb_0x8f9.SourceID)localObject1).uint32_source_type.set(1);
    ((oidb_0x8f9.SourceID)localObject1).uint64_source_code.set(l);
    Object localObject2 = new oidb_0x8f9.ReqBody();
    ((oidb_0x8f9.ReqBody)localObject2).msg_source_id.set((MessageMicro)localObject1);
    localObject1 = makeOIDBPkg("OidbSvc.0x8f9_14", 2297, 14, ((oidb_0x8f9.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putString("from", "getLatestTroopMemo");
    ((ToServiceMsg)localObject1).extraData.putLong("group_code", l);
    super.sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("sendPbRequest. cmd=");
      ((StringBuilder)localObject2).append(((ToServiceMsg)localObject1).getServiceCmd());
      QLog.d("TroopAnnouncementHandler", 2, ((StringBuilder)localObject2).toString());
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getLatestTroopMemo code: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("TroopAnnouncementHandler", 4, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(String paramString1, String paramString2, short paramShort)
  {
    SharedPreferences localSharedPreferences = this.appRuntime.getApplicationContext().getSharedPreferences("troop_new_guid", 0);
    if (!localSharedPreferences.getBoolean(paramString1, false)) {}
    try
    {
      localSharedPreferences.edit().putBoolean(paramString1, true).commit();
      long l = Long.parseLong(paramString1);
      a(0, Long.parseLong(paramString2), l, Long.parseLong(this.appRuntime.getCurrentAccountUin()), "", (int)System.currentTimeMillis(), "OidbSvc.0x852_48", paramShort, true, true);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      label88:
      break label88;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAnnouncementHandler", 2, "troopCode not long type!");
    }
  }
  
  public boolean a(String paramString)
  {
    if (a.containsKey(paramString)) {
      return ((Boolean)a.get(paramString)).booleanValue();
    }
    return false;
  }
  
  public void b(int paramInt1, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt2, short paramShort, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt1, paramLong1, paramLong2, paramLong3, paramString, paramInt2, "OidbSvc.0x852_48", paramShort, paramBoolean1, paramBoolean2);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x8f9_14");
      this.allowCmdSet.add("OidbSvc.0x852_35");
      this.allowCmdSet.add("OidbSvc.0x852_48");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopAnnouncementObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("TroopAnnouncementHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopAnnouncementHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0x8f9_14".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x852_35".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x852_48".equals(paramFromServiceMsg.getServiceCmd())) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAnnouncementHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.announcement.api.impl.TroopAnnouncementHandler
 * JD-Core Version:    0.7.0.1
 */