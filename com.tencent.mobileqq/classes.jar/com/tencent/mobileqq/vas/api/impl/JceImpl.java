package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.Cmd2HandlerMapHelper;
import com.tencent.mobileqq.vas.api.AbsProtocol;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.api.IJce.Util;
import com.tencent.mobileqq.vas.api.IJceSSo;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class JceImpl
  extends AbsProtocol
  implements IJce
{
  private static String a = ((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName();
  private String mCmd;
  private HashMap<String, JceStruct> mJceRespMap = new HashMap();
  private String mReqType = "req";
  private String mRspType = "rsp";
  private String mServantName;
  
  public JceImpl() {}
  
  @Deprecated
  public JceImpl(String paramString1, String paramString2)
  {
    this.mCmd = paramString2;
    this.mServantName = paramString1;
    if (!Cmd2HandlerMapHelper.a(paramString2)) {
      Cmd2HandlerMapHelper.a(paramString2, new String[] { a });
    }
  }
  
  public JceImpl(String paramString1, String paramString2, int paramInt)
  {
    this(paramString1, paramString2);
    if (paramInt == 2)
    {
      this.mReqType = "stReq";
      this.mRspType = "stRsp";
    }
  }
  
  public JceImpl(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramString2);
    this.mCmd = paramString2;
    this.mServantName = paramString1;
    Cmd2HandlerMapHelper.a(paramString2, a);
    this.mReqType = paramString3;
    this.mRspType = paramString4;
  }
  
  public IJce build(String paramString1, String paramString2)
  {
    return new JceImpl(paramString1, paramString2);
  }
  
  public IJce build(String paramString1, String paramString2, int paramInt)
  {
    return new JceImpl(paramString1, paramString2, paramInt);
  }
  
  public IJce build(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return new JceImpl(paramString1, paramString2, paramString3, paramString4);
  }
  
  public Object decode(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, UniPacket paramUniPacket)
  {
    paramToServiceMsg = IJce.Util.a(paramToServiceMsg);
    ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).unRegisterSeqKey(paramToServiceMsg);
    if (this.mJceRespMap.containsKey(paramToServiceMsg))
    {
      paramFromServiceMsg = (JceStruct)this.mJceRespMap.get(paramToServiceMsg);
      this.mJceRespMap.remove(paramToServiceMsg);
      return paramUniPacket.getByClass(this.mRspType, paramFromServiceMsg);
    }
    return null;
  }
  
  public void encode(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket, int paramInt)
  {
    paramUniPacket.setServantName(this.mServantName);
    paramUniPacket.setFuncName(paramToServiceMsg.extraData.getString("funcName"));
    paramUniPacket.setRequestId(paramInt);
    paramUniPacket.put(this.mReqType, paramToServiceMsg.extraData.get("req"));
  }
  
  public String getCmd()
  {
    return this.mCmd;
  }
  
  @NotNull
  public String getManagerName()
  {
    return getClass().getName();
  }
  
  public void request(String paramString, JceStruct paramJceStruct1, JceStruct paramJceStruct2, BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (MobileQQ.processName == null) {
      return;
    }
    if (!MobileQQ.processName.equals(BaseApplication.getContext().getPackageName()))
    {
      ((IJceSSo)RemoteProxy.a(JceSSoImpl.class)).a(paramString, paramJceStruct1, paramJceStruct2, new JceImpl.1(this, paramBusinessObserver), paramBoolean, this);
      return;
    }
    Object localObject = interceptJce(this.mServantName, this.mCmd, paramString, paramJceStruct1);
    if (localObject != null)
    {
      onJceCallBack((JceStruct)localObject, paramBusinessObserver);
      return;
    }
    localObject = VasUtil.d();
    paramBusinessObserver = ((ISVIPHandler)((AppInterface)localObject).getBusinessHandler(a)).createToServiceMsg(this.mCmd, paramBusinessObserver, paramBoolean);
    String str = IJce.Util.a(paramBusinessObserver);
    this.mJceRespMap.put(str, paramJceStruct2);
    ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).registerSeqKey(this, str);
    paramBusinessObserver.extraData.putSerializable("req", paramJceStruct1);
    paramBusinessObserver.extraData.putString("funcName", paramString);
    ((AppInterface)localObject).sendToService(paramBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.JceImpl
 * JD-Core Version:    0.7.0.1
 */