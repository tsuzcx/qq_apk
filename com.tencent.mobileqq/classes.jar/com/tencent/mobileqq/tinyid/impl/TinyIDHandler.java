package com.tencent.mobileqq.tinyid.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.cmd0xfe3.oidb_cmd0xfe3.ReqBody;
import tencent.im.oidb.cmd0xfe3.oidb_cmd0xfe3.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TinyIDHandler
  extends BusinessHandler
{
  public static final String a = "com.tencent.mobileqq.tinyid.impl.TinyIDHandler";
  private final String b = "0xfe3";
  private final String c = "0";
  private AtomicInteger d = new AtomicInteger(1000);
  private ConcurrentHashMap<String, TinyIDHandler.Listener> e = new ConcurrentHashMap();
  private AppInterface f;
  
  public TinyIDHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.f = paramAppInterface;
  }
  
  private String a(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#");
    localStringBuilder.append(paramString);
    localStringBuilder.append("&");
    localStringBuilder.append("0xfe3&");
    localStringBuilder.append("0&");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("#");
    paramString = localStringBuilder.toString();
    try
    {
      paramString = HexUtil.bytes2HexStr(MessageDigest.getInstance("SHA-256").digest(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("TinyID.TinyIDHandlerImpl", 1, paramString, new Object[0]);
    }
    return "";
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
      i = 1;
    } else {
      i = 0;
    }
    String str = (String)paramToServiceMsg.getAttribute("RequestID");
    TinyIDHandler.Listener localListener = (TinyIDHandler.Listener)this.e.get(str);
    if (i != 0) {}
    for (;;)
    {
      try
      {
        i = paramFromServiceMsg.getResultCode();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handleRespGetTinyID] 0xfe3, resultCode = [");
        localStringBuilder.append(i);
        localStringBuilder.append("], req = [");
        localStringBuilder.append(paramToServiceMsg);
        localStringBuilder.append("], res = [");
        localStringBuilder.append(paramFromServiceMsg);
        localStringBuilder.append("]");
        QLog.d("TinyID.TinyIDHandlerImpl", 1, localStringBuilder.toString());
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = paramFromServiceMsg;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          QLog.d("TinyID.TinyIDHandlerImpl", 1, "[handleRespGetTinyID] 0xfe3, pkg.mergeFrom error e =", paramFromServiceMsg);
        }
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = new oidb_cmd0xfe3.RspBody();
            try
            {
              paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            }
            catch (InvalidProtocolBufferMicroException paramToServiceMsg)
            {
              QLog.e("TinyID.TinyIDHandlerImpl", 1, "[handleRespGetTinyID] 0xfe3, rspBody.mergeFrom error: ", paramToServiceMsg);
            }
            paramToServiceMsg = paramFromServiceMsg.tiny_id.get();
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("[handleRespGetTinyID] 0xfe3, get TinyID:");
            paramFromServiceMsg.append(paramToServiceMsg.substring(0, 3));
            QLog.d("TinyID.TinyIDHandlerImpl", 1, paramFromServiceMsg.toString());
            if (localListener != null)
            {
              QLog.d("TinyID.TinyIDHandlerImpl", 1, "[handleRespGetTinyID] 0xfe3, call regist listener");
              localListener.a(str, paramToServiceMsg);
            }
          }
          else
          {
            QLog.d("TinyID.TinyIDHandlerImpl", 1, "handleReqGetTinyID: pkg.bytes_bodybuffer is null");
          }
        }
        else
        {
          if (!paramToServiceMsg.uint32_result.has()) {
            break label427;
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append(" pkg.uint32_result error code: ");
          paramFromServiceMsg.append(paramToServiceMsg.uint32_result.get());
          paramToServiceMsg = paramFromServiceMsg.toString();
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleReqGetTinyID:");
          paramFromServiceMsg.append(paramToServiceMsg);
          QLog.d("TinyID.TinyIDHandlerImpl", 1, paramFromServiceMsg.toString());
          a(str, localListener);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        a(str, localListener);
        QLog.d("TinyID.TinyIDHandlerImpl", 1, paramToServiceMsg, new Object[0]);
      }
      return;
      label427:
      paramToServiceMsg = " pkg.uint32_result do not have";
    }
  }
  
  public void a(TinyIDHandler.Listener paramListener)
  {
    oidb_cmd0xfe3.ReqBody localReqBody = new oidb_cmd0xfe3.ReqBody();
    String str = Integer.toString(this.d.getAndIncrement());
    this.e.put(str, paramListener);
    paramListener = this.appRuntime.getCurrentAccountUin();
    long l = System.currentTimeMillis() / 1000L;
    try
    {
      paramListener = a(paramListener, l);
      if (TextUtils.isEmpty(paramListener))
      {
        QLog.d("TinyID.TinyIDHandlerImpl", 1, "SHA256 hash sign failed");
        return;
      }
      localReqBody.sign.set(paramListener);
      localReqBody.post_time.set(l);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[reqGetTinyID] 0xfe3, SHA256 hash sign:");
      localStringBuilder.append(paramListener.substring(0, 3));
      QLog.d("TinyID.TinyIDHandlerImpl", 1, localStringBuilder.toString());
      QLog.d("TinyID.TinyIDHandlerImpl", 1, "[reqGetTinyID] 0xfe3, sign combined success, and send pb request");
      paramListener = makeOIDBPkg("OidbSvc.0xfe3", 4067, 0, localReqBody.toByteArray());
      paramListener.addAttribute("RequestID", str);
      sendPbReq(paramListener);
      return;
    }
    catch (Exception paramListener)
    {
      QLog.e("TinyID.TinyIDHandlerImpl", 1, "[reqGetTinyID] 0xfe3, combined sign Error: ", paramListener);
    }
  }
  
  public void a(String paramString, TinyIDHandler.Listener paramListener)
  {
    if (paramListener != null)
    {
      if (!this.e.containsKey(paramString)) {
        return;
      }
      this.e.remove(paramString);
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xfe3");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("onReceive, msgCmdFilter is true,cmd  = ");
        paramToServiceMsg.append(str);
        QLog.d("TinyID.TinyIDHandlerImpl", 1, paramToServiceMsg.toString());
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xfe3"))
      {
        QLog.d("TinyID.TinyIDHandlerImpl", 1, "[onReceive] 0xfe3, get TinyID message");
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    QLog.d("TinyID.TinyIDHandlerImpl", 1, "[onReceive] req or res is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tinyid.impl.TinyIDHandler
 * JD-Core Version:    0.7.0.1
 */