package com.tencent.qqmini.sdk.request;

import NS_QWEB_PROTOCAL.PROTOCAL.StAuthInfo;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public abstract class ProtoBufRequest
{
  public static final int JSON_CONTENT_TYPE = 1;
  public static final String KEY_ERROR_MSG = "errMsg";
  public static final String KEY_RETURN_CODE = "retCode";
  public static final int PB_CONTENT_TYPE = 0;
  public static final String TAG = "ProtoBufRequest";
  private static volatile AtomicInteger sSeq = new AtomicInteger(0);
  public int seqNo;
  
  private String getTraceId()
  {
    String str = LoginManager.getInstance().getAccount();
    StringBuilder localStringBuilder = new StringBuilder(50);
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MMddHHmmss");
    Random localRandom = new Random();
    localRandom.setSeed(System.currentTimeMillis());
    localStringBuilder.append(str).append("_").append(localSimpleDateFormat.format(new Date())).append(System.currentTimeMillis() % 1000L).append("_").append(localRandom.nextInt(90000) + 10000);
    return localStringBuilder.toString();
  }
  
  protected byte[] decode(byte[] paramArrayOfByte)
  {
    PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
    try
    {
      localStQWebRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localStQWebRsp.busiBuff.get().toByteArray();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.d("ProtoBufRequest", "decode fail.", paramArrayOfByte);
    }
    return null;
  }
  
  public byte[] encode()
  {
    PROTOCAL.StQWebReq localStQWebReq = new PROTOCAL.StQWebReq();
    this.seqNo = sSeq.incrementAndGet();
    localStQWebReq.Seq.set(this.seqNo);
    localStQWebReq.traceid.set(getTraceId());
    if (QUAUtil.getQUA() != null) {
      localStQWebReq.qua.set(QUAUtil.getQUA());
    }
    Object localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (((ChannelProxy)localObject).getDeviceInfo() != null) {
      localStQWebReq.deviceInfo.set(((ChannelProxy)localObject).getDeviceInfo());
    }
    localStQWebReq.busiBuff.set(ByteStringMicro.copyFrom(getBusiBuf()));
    localStQWebReq.Module.set(getModule());
    localStQWebReq.Cmdname.set(getCmdName());
    localObject = new PROTOCAL.StAuthInfo();
    if (LoginManager.getInstance().getAccount() != null) {
      ((PROTOCAL.StAuthInfo)localObject).uin.set(LoginManager.getInstance().getAccount());
    }
    if (LoginManager.getInstance().getLoginSig() != null) {
      ((PROTOCAL.StAuthInfo)localObject).sig.set(ByteStringMicro.copyFrom(LoginManager.getInstance().getLoginSig()));
    }
    ((PROTOCAL.StAuthInfo)localObject).type.set(LoginManager.getInstance().getLoginType());
    if ((!QUAUtil.isQQApp()) && (LoginManager.getInstance().getPlatformId() != null)) {
      ((PROTOCAL.StAuthInfo)localObject).platform.set(LoginManager.getInstance().getPlatformId());
    }
    if (LoginManager.getInstance().getPayOpenId() != null) {
      ((PROTOCAL.StAuthInfo)localObject).openid.set(LoginManager.getInstance().getPayOpenId());
    }
    if (LoginManager.getInstance().getAppId() != null) {
      ((PROTOCAL.StAuthInfo)localObject).appid.set(LoginManager.getInstance().getAppId());
    }
    if (LoginManager.getInstance().getPayOpenKey() != null) {
      ((PROTOCAL.StAuthInfo)localObject).sessionkey.set(ByteStringMicro.copyFrom(LoginManager.getInstance().getPayOpenKey().getBytes()));
    }
    localStQWebReq.loginSig.set((MessageMicro)localObject);
    localStQWebReq.contentType.set(getContentType());
    QMLog.d("ProtoBufRequest", "cmd : " + localStQWebReq.Cmdname.get() + "  traceId:" + localStQWebReq.traceid.get());
    return localStQWebReq.toByteArray();
  }
  
  protected abstract byte[] getBusiBuf();
  
  protected abstract String getCmdName();
  
  public String getCmdString()
  {
    return "";
  }
  
  public int getContentType()
  {
    return 0;
  }
  
  protected abstract String getModule();
  
  public JSONObject getResponse(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = new PROTOCAL.StQWebRsp();
      ((PROTOCAL.StQWebRsp)localObject).mergeFrom(paramArrayOfByte);
      byte[] arrayOfByte = ((PROTOCAL.StQWebRsp)localObject).busiBuff.get().toByteArray();
      paramArrayOfByte = new JSONObject();
      paramArrayOfByte.put("retCode", ((PROTOCAL.StQWebRsp)localObject).retCode.get());
      paramArrayOfByte.put("errMsg", ((PROTOCAL.StQWebRsp)localObject).errMsg.get().toStringUtf8());
      localObject = getResponse(arrayOfByte, paramArrayOfByte);
      if (localObject != null) {
        return localObject;
      }
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      QMLog.e("ProtoBufRequest", "Failed to getResponse", paramArrayOfByte);
    }
    return null;
  }
  
  public abstract JSONObject getResponse(byte[] paramArrayOfByte, JSONObject paramJSONObject);
  
  public String toString()
  {
    return "ProtoBufRequest{seqNo=" + this.seqNo + ",CmdName=" + getCmdName() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.request.ProtoBufRequest
 * JD-Core Version:    0.7.0.1
 */