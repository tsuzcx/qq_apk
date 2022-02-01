package com.tencent.mobileqq.vip;

import QC.LoginInfo;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.service.Cmd2HandlerMapHelper;
import com.tencent.mobileqq.service.VasService;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;

public class JceProtocol
  extends AbsProtocol
{
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, JceStruct> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private String b;
  private String c = "req";
  private String d = "rsp";
  
  @Deprecated
  public JceProtocol(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString1;
    if (!Cmd2HandlerMapHelper.a(paramString2)) {
      Cmd2HandlerMapHelper.a(paramString2, new String[] { BusinessHandlerFactory.SVIP_HANDLER });
    }
  }
  
  public JceProtocol(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2);
    if (paramInt == 2)
    {
      this.c = "stReq";
      this.d = "stRsp";
    }
  }
  
  public JceProtocol(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramString2);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString1;
    Cmd2HandlerMapHelper.a(paramString2, BusinessHandlerFactory.SVIP_HANDLER);
    this.c = paramString3;
    this.d = paramString4;
  }
  
  public static LoginInfo a()
  {
    try
    {
      Object localObject = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject == null) {
        return null;
      }
      String str = ((AppInterface)localObject).getCurrentAccountUin();
      localObject = ((TicketManager)((AppInterface)localObject).getManager(2)).getSkey(str);
      LoginInfo localLoginInfo = new LoginInfo();
      localLoginInfo.lUin = Long.parseLong(str);
      localLoginInfo.iKeyType = 1;
      localLoginInfo.sSKey = ((String)localObject);
      localLoginInfo.iOpplat = 2;
      localLoginInfo.sClientVer = DeviceInfoUtil.c();
      return localLoginInfo;
    }
    catch (Exception localException)
    {
      QLog.e("JceProtocol", 1, localException, new Object[0]);
    }
    return null;
  }
  
  public static String a(ToServiceMsg paramToServiceMsg)
  {
    return paramToServiceMsg.getServiceCmd() + "_" + paramToServiceMsg.extraData.get(BaseBusinessHandler.SEQ_KEY);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = a(paramToServiceMsg);
    VasService.a(paramToServiceMsg);
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramToServiceMsg))
    {
      paramFromServiceMsg = (JceStruct)this.jdField_a_of_type_JavaUtilHashMap.get(paramToServiceMsg);
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramToServiceMsg);
      return paramUniPacket.getByClass(this.d, paramFromServiceMsg);
    }
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, int paramInt)
  {
    paramUniPacket.setServantName(this.b);
    paramUniPacket.setFuncName(paramToServiceMsg.extraData.getString("funcName"));
    paramUniPacket.setRequestId(paramInt);
    paramUniPacket.put(this.c, paramToServiceMsg.extraData.get("req"));
  }
  
  public void a(String paramString, JceStruct paramJceStruct1, JceStruct paramJceStruct2, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    Object localObject = a(this.b, this.jdField_a_of_type_JavaLangString, paramString, paramJceStruct1);
    if (localObject != null)
    {
      a((JceStruct)localObject, paramBusinessObserver);
      return;
    }
    localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    paramBusinessObserver = ((SVIPHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).createToServiceMsg(this.jdField_a_of_type_JavaLangString, paramBusinessObserver, paramBoolean);
    String str = a(paramBusinessObserver);
    this.jdField_a_of_type_JavaUtilHashMap.put(str, paramJceStruct2);
    VasService.a(this, str);
    paramBusinessObserver.extraData.putSerializable("req", paramJceStruct1);
    paramBusinessObserver.extraData.putString("funcName", paramString);
    ((QQAppInterface)localObject).sendToService(paramBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.JceProtocol
 * JD-Core Version:    0.7.0.1
 */