package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopNotifyApplicantInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.troop.TroopSystemNotificationConstants;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.api.observer.TroopNotificationObserver;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopNotificationHandler
  extends TroopBaseHandler
{
  public TroopNotificationHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (paramObject == null) {
        return;
      }
      ITroopNotificationService localITroopNotificationService = (ITroopNotificationService)this.appRuntime.getRuntimeService(ITroopNotificationService.class, "");
      if (localITroopNotificationService == null) {
        return;
      }
      paramToServiceMsg = new oidb_0x5eb.RspBody();
      if (parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0)
      {
        if (paramToServiceMsg.rpt_msg_uin_data.has()) {
          paramToServiceMsg = paramToServiceMsg.rpt_msg_uin_data.get();
        } else {
          paramToServiceMsg = null;
        }
        localITroopNotificationService.saveApplicantInfoListToCacheFrom0x5eb(c(paramToServiceMsg));
        notifyUI(TroopSystemNotificationConstants.a, true, new Object[] { paramToServiceMsg });
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte)
  {
    int i = ((oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom(paramArrayOfByte)).uint32_result.get();
    if ((i != 0) && (QLog.isColorLevel()))
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("TroopNotificationHandler onReceive return Error result:");
      paramArrayOfByte.append(i);
      paramArrayOfByte.append("cmd：");
      paramArrayOfByte.append(paramToServiceMsg.getServiceCmd());
      QLog.i("TroopNotificationHandler", 2, paramArrayOfByte.toString());
    }
  }
  
  private void a(List<Long> paramList)
  {
    if (!paramList.isEmpty())
    {
      if (paramList.size() > 70) {
        return;
      }
      Object localObject = new oidb_0x5eb.ReqBody();
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(paramList);
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_age.set(1);
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_gender.set(1);
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_city.set(1);
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_province.set(1);
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_country.set(1);
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_400_flag.set(1);
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_business_user.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_troopnotifycation", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("uins", paramList);
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (paramObject == null) {
        return;
      }
      if (!paramFromServiceMsg.isSuccess()) {
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label46:
      int k;
      ArrayList localArrayList;
      int i;
      int j;
      break label46;
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.bytes_bodybuffer.has()))
    {
      if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
        return;
      }
      if (paramToServiceMsg.uint32_result.get() != 0) {
        return;
      }
      paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      k = PkgTools.getShortData(paramToServiceMsg, 0);
      if (paramToServiceMsg.length != k * 10 + 2) {
        return;
      }
      paramFromServiceMsg = (ITroopNotificationService)this.appRuntime.getRuntimeService(ITroopNotificationService.class, "");
      if (paramFromServiceMsg == null) {
        return;
      }
      paramObject = new HashMap();
      localArrayList = new ArrayList();
      i = 0;
      j = 2;
      while (i < k)
      {
        long l = PkgTools.getLongData(paramToServiceMsg, j);
        localArrayList.add(Long.valueOf(l));
        j += 4;
        int m = PkgTools.getShortData(paramToServiceMsg, j);
        j = j + 2 + 4;
        paramObject.put(Long.valueOf(l), Integer.valueOf(m));
        i += 1;
      }
      paramFromServiceMsg.saveApplicantInfoToCacheFrom0x668(paramObject);
      notifyUI(TroopSystemNotificationConstants.a, true, new Object[] { localArrayList });
    }
  }
  
  private void b(List<Long> paramList)
  {
    if (!paramList.isEmpty())
    {
      if (paramList.size() > 70) {
        return;
      }
      int i = 0;
      while (i < paramList.size())
      {
        if ((Long)paramList.get(i) == null) {
          paramList.remove(i);
        }
        i += 1;
      }
      if (paramList.isEmpty()) {
        return;
      }
      short s = (short)paramList.size();
      Object localObject = ByteBuffer.allocate(paramList.size() * 4 + 2);
      ((ByteBuffer)localObject).putShort(s);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ByteBuffer)localObject).putInt((int)((Long)paramList.next()).longValue());
      }
      paramList = ((ByteBuffer)localObject).array();
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1640);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramList));
      a("OidbSvc.0x668", ((oidb_sso.OIDBSSOPkg)localObject).toByteArray(), null);
    }
  }
  
  private List<TroopNotifyApplicantInfo> c(List<oidb_0x5eb.UdcUinData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    ITroopNotificationService localITroopNotificationService = (ITroopNotificationService)this.appRuntime.getRuntimeService(ITroopNotificationService.class, "");
    if ((paramList != null) && (!paramList.isEmpty()) && (localITroopNotificationService != null))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (oidb_0x5eb.UdcUinData)localIterator.next();
        if (localObject != null)
        {
          long l = ((oidb_0x5eb.UdcUinData)localObject).uint64_uin.get();
          int i = ((oidb_0x5eb.UdcUinData)localObject).uint32_age.get();
          if (((oidb_0x5eb.UdcUinData)localObject).bytes_country.has()) {
            paramList = ((oidb_0x5eb.UdcUinData)localObject).bytes_country.get().toStringUtf8();
          } else {
            paramList = "";
          }
          String str1;
          if (((oidb_0x5eb.UdcUinData)localObject).bytes_province.has()) {
            str1 = ((oidb_0x5eb.UdcUinData)localObject).bytes_province.get().toStringUtf8();
          } else {
            str1 = "";
          }
          String str2;
          if (((oidb_0x5eb.UdcUinData)localObject).bytes_city.has()) {
            str2 = ((oidb_0x5eb.UdcUinData)localObject).bytes_city.get().toStringUtf8();
          } else {
            str2 = "";
          }
          int j = ((oidb_0x5eb.UdcUinData)localObject).uint32_gender.get();
          boolean bool;
          if ((((oidb_0x5eb.UdcUinData)localObject).uint32_400_flag.get() != 1) && (((oidb_0x5eb.UdcUinData)localObject).uint32_business_user.get() != 1)) {
            bool = false;
          } else {
            bool = true;
          }
          localObject = localITroopNotificationService.getApplicantInfo(Long.valueOf(l));
          if (localObject != null)
          {
            ((TroopNotifyApplicantInfo)localObject).b(j);
            ((TroopNotifyApplicantInfo)localObject).c(str2);
            ((TroopNotifyApplicantInfo)localObject).a(paramList);
            ((TroopNotifyApplicantInfo)localObject).b(str1);
            ((TroopNotifyApplicantInfo)localObject).a(i);
            ((TroopNotifyApplicantInfo)localObject).a(true);
            ((TroopNotifyApplicantInfo)localObject).c(bool);
            localArrayList.add(localObject);
          }
          else
          {
            localArrayList.add(new TroopNotifyApplicantInfo(l, i, paramList, str1, str2, j, bool, true));
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramString = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), paramString);
    paramString.putWupBuffer(paramArrayOfByte);
    if (paramBundle != null) {
      paramString.extraData = paramBundle;
    }
    sendPbReq(paramString);
  }
  
  public void a(List<Long> paramList, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramList == null) {
        return;
      }
      if (paramString.equals("OidbSvc.0x5eb_troopnotifycation"))
      {
        a(paramList);
        return;
      }
      if (paramString.equals("OidbSvc.0x668")) {
        b(paramList);
      }
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopNotificationObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TroopNotificationHandler onReceive resultCode:");
        ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
        ((StringBuilder)localObject).append("errMsg: ");
        ((StringBuilder)localObject).append(paramFromServiceMsg.getBusinessFailMsg());
        ((StringBuilder)localObject).append("serviceCmd: ");
        ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
        QLog.i("TroopNotificationHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = paramToServiceMsg.getServiceCmd();
      try
      {
        a(paramToServiceMsg, (byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("TroopNotificationHandler onReceive exception: ");
          localStringBuilder.append(localInvalidProtocolBufferMicroException.getMessage());
          localStringBuilder.append("cmd：");
          localStringBuilder.append(paramToServiceMsg.getServiceCmd());
          QLog.i("TroopNotificationHandler", 2, localStringBuilder.toString());
        }
      }
      if ("OidbSvc.0x5eb_troopnotifycation".equals(localObject))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x668".equals(localObject)) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    QLog.i("TroopNotificationHandler", 2, "TroopNotificationHandler onReceive res == null || req == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopNotificationHandler
 * JD-Core Version:    0.7.0.1
 */