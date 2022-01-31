package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.api.data.TransactionData;
import com.tencent.qapmsdk.impl.harvest.HttpLibType;
import com.tencent.qapmsdk.impl.harvest.RequestMethodType;
import com.tencent.qapmsdk.impl.socket.SocketError;
import com.tencent.qapmsdk.impl.socket.UrlBuilder;
import com.tencent.qapmsdk.impl.socket.UrlBuilder.Scheme;
import com.tencent.qapmsdk.impl.util.StringUtil;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class QAPMTransactionState
{
  private static final String TAG = "QAPM_Impl_QAPMTransactionState";
  public static final int URL_LIMIT = 1024;
  private String addressAllStr = "";
  private String allGetRequestParams;
  private String appData;
  private int appPhase;
  private long bytesReceived;
  private long bytesSent;
  private String carrier;
  private String cdnVendorName;
  private int connectType;
  private String contentType;
  private boolean controllerDispatch;
  private int dnsElapse;
  private long endTime;
  private int errorCode;
  private String exception = null;
  private int firstPacketPeriod = -1;
  private String formattedUrlParams = null;
  public volatile boolean hasParseUrlParams = false;
  private HttpLibType httpLibType;
  private boolean inQueue = false;
  private String ipAddress;
  private String ipList;
  private boolean isStatusCodeCalled;
  private String methodType;
  private int port;
  private int queueTime;
  private long queueTimeStamp;
  private long requestEndTime;
  public ConcurrentHashMap<String, String> requestHeaderParam = new ConcurrentHashMap();
  private RequestMethodType requestMethod;
  public HashMap<String, Object> responseHeaderParam = new HashMap();
  private long responseStartTime;
  private int sslHandShakeTime;
  private long startTime;
  private QAPMTransactionState.State state;
  private int statusCode;
  private int tcpHandShakeTime;
  private TransactionData transactionData;
  private int tyIdRandomInt;
  private String url;
  private UrlBuilder urlBuilder = new UrlBuilder();
  private String urlParams = null;
  private String userActionId;
  
  public QAPMTransactionState()
  {
    try
    {
      this.startTime = System.currentTimeMillis();
      this.tcpHandShakeTime = -1;
      this.sslHandShakeTime = -1;
      this.carrier = "Other";
      this.state = QAPMTransactionState.State.READY;
      this.errorCode = SocketError.OK.getExceptionValue();
      this.requestMethod = RequestMethodType.GET;
      this.httpLibType = HttpLibType.URLConnection;
      this.dnsElapse = 0;
      this.ipList = "";
      this.ipAddress = "";
      this.isStatusCodeCalled = false;
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", "QAPMTransactionState,", " ID:", String.valueOf(Thread.currentThread().getId()), " name : ", Thread.currentThread().getName() });
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "error init QAPMTransactionState e:", localException.getMessage() });
    }
  }
  
  public QAPMTransactionState(boolean paramBoolean)
  {
    try
    {
      this.startTime = System.currentTimeMillis();
      this.tcpHandShakeTime = -1;
      this.sslHandShakeTime = -1;
      this.carrier = "Other";
      this.state = QAPMTransactionState.State.READY;
      this.errorCode = SocketError.OK.getExceptionValue();
      this.requestMethod = RequestMethodType.GET;
      this.httpLibType = HttpLibType.URLConnection;
      this.dnsElapse = 0;
      this.ipList = "";
      this.ipAddress = "";
      this.isStatusCodeCalled = false;
      if (!paramBoolean) {}
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "error init QAPMTransactionState e:", localException.getMessage() });
    }
  }
  
  private void checkActionData(String paramString, TransactionData paramTransactionData)
  {
    if (paramTransactionData.getSslHandShakeTime() > paramTransactionData.getTime()) {
      paramTransactionData.setSslHandShakeTime(-1);
    }
    if (paramTransactionData.getTcpHandShakeTime() > paramTransactionData.getTime()) {
      paramTransactionData.setTcpHandShakeTime(-1);
    }
    if (countHttpTime(paramTransactionData))
    {
      paramTransactionData.setSslHandShakeTime(-1);
      paramTransactionData.setTcpHandShakeTime(-1);
      paramTransactionData.setDnsElapse(-1);
      if (paramTransactionData.getTime() < paramTransactionData.getFirstPackageTime()) {
        paramTransactionData.setFirstPackageTime(paramTransactionData.getTime());
      }
    }
  }
  
  private boolean countHttpTime(TransactionData paramTransactionData)
  {
    if (paramTransactionData == null) {}
    while (paramTransactionData.getSslHandShakeTime() + paramTransactionData.getTcpHandShakeTime() + paramTransactionData.getFirstPackageTime() + paramTransactionData.getDnsElapse() < paramTransactionData.getTime()) {
      return false;
    }
    return true;
  }
  
  private void setOtherTimeInfo(TransactionData paramTransactionData)
  {
    if ((paramTransactionData != null) && (this.url != null)) {
      checkActionData(StringUtil.getHostFromUrl(this.url), paramTransactionData);
    }
  }
  
  private TransactionData toTransactionData()
  {
    if (!isComplete()) {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "toTransactionData() called on incomplete TransactionState" });
    }
    if (this.url == null)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", "Attempted to convert a TransactionState instance with no URL into a TransactionData" });
      return null;
    }
    if (this.transactionData == null) {
      this.transactionData = new TransactionData(this.url, this.carrier, this.startTime, (int)(this.endTime - this.startTime), this.statusCode, this.errorCode, this.bytesSent, this.bytesReceived, this.appData, this.formattedUrlParams, this.urlParams, this.requestMethod, this.httpLibType, this.dnsElapse, this.ipAddress, this.tcpHandShakeTime, this.sslHandShakeTime, this.firstPacketPeriod, this.cdnVendorName, this.contentType, this.appPhase, this.userActionId, this.allGetRequestParams, this.queueTime);
    }
    setOtherTimeInfo(this.transactionData);
    return this.transactionData;
  }
  
  public TransactionData end()
  {
    if (!isComplete())
    {
      this.state = QAPMTransactionState.State.COMPLETE;
      this.endTime = System.currentTimeMillis();
    }
    return toTransactionData();
  }
  
  public String getAddressAllStr()
  {
    return this.addressAllStr;
  }
  
  public String getAllGetRequestParams()
  {
    return this.allGetRequestParams;
  }
  
  public String getAppData()
  {
    return this.appData;
  }
  
  public int getAppPhase()
  {
    return this.appPhase;
  }
  
  public long getBytesReceived()
  {
    return this.bytesReceived;
  }
  
  public long getBytesSent()
  {
    return this.bytesSent;
  }
  
  public String getCdnVendorName()
  {
    return this.cdnVendorName;
  }
  
  public int getConnectType()
  {
    return this.connectType;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getException()
  {
    return this.exception;
  }
  
  public int getFirstPacketRecived()
  {
    return (int)(this.responseStartTime - this.requestEndTime);
  }
  
  public String getFormattedUrlParams()
  {
    return this.formattedUrlParams;
  }
  
  public HttpLibType getHttpLibType()
  {
    return this.httpLibType;
  }
  
  public String getHttpPath()
  {
    return this.urlBuilder.getHttpPath();
  }
  
  public String getMethodType()
  {
    return this.methodType;
  }
  
  public int getQueueTime()
  {
    return this.queueTime;
  }
  
  public long getQueueTimeStamp()
  {
    return this.queueTimeStamp;
  }
  
  public String getRequestMethod()
  {
    return this.requestMethod.name();
  }
  
  public RequestMethodType getRequestMethodType()
  {
    return this.requestMethod;
  }
  
  public String getScheme()
  {
    return this.urlBuilder.getScheme().getName();
  }
  
  public int getSslHandShakeTime()
  {
    return this.sslHandShakeTime;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public QAPMTransactionState.State getState()
  {
    return this.state;
  }
  
  public int getStatusCode()
  {
    return this.statusCode;
  }
  
  public int getTcpHandShakeTime()
  {
    return this.tcpHandShakeTime;
  }
  
  public int getTyIdRandomInt()
  {
    return this.tyIdRandomInt;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public String getUrlParams()
  {
    return this.urlParams;
  }
  
  public String getUserActionId()
  {
    return this.userActionId;
  }
  
  public boolean ifInQueue()
  {
    return this.inQueue;
  }
  
  public boolean isComplete()
  {
    return this.state.ordinal() >= QAPMTransactionState.State.COMPLETE.ordinal();
  }
  
  public boolean isControllerDispatch()
  {
    return this.controllerDispatch;
  }
  
  public boolean isError()
  {
    return (this.statusCode >= 400) || (this.statusCode == -1);
  }
  
  public boolean isSent()
  {
    return this.state.ordinal() >= QAPMTransactionState.State.SENT.ordinal();
  }
  
  public void markAsEnqueue()
  {
    this.inQueue = true;
  }
  
  public void setAddress(String paramString)
  {
    this.urlBuilder.setHostAddress(paramString);
  }
  
  public void setAddressAllStr(String paramString)
  {
    this.addressAllStr = paramString;
  }
  
  public void setAllGetRequestParams(String paramString)
  {
    this.allGetRequestParams = paramString;
  }
  
  public void setAppData(String paramString)
  {
    if (!isComplete())
    {
      this.appData = paramString;
      if ("".equals(paramString)) {}
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setAppData(...) called on TransactionState in ", this.state.toString(), " state" });
  }
  
  public void setAppPhase(int paramInt)
  {
    this.appPhase = paramInt;
  }
  
  public void setBytesReceived(long paramLong)
  {
    if (!isComplete())
    {
      this.bytesReceived = paramLong;
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", String.valueOf(paramLong), "bytes received" });
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setBytesReceived(...) called on TransactionState in ", this.state.toString(), " state" });
  }
  
  public void setBytesSent(long paramLong)
  {
    if (!isComplete())
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", String.valueOf(paramLong), " bytes sent" });
      this.bytesSent = paramLong;
      this.state = QAPMTransactionState.State.SENT;
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setBytesSent(...) called on TransactionState in ", this.state.toString(), " state" });
  }
  
  public void setBytesSentAfterComplete(long paramLong)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", "After Complete ", String.valueOf(paramLong), " bytes sent." });
    this.bytesSent = paramLong;
    this.state = QAPMTransactionState.State.SENT;
  }
  
  public void setCarrier(String paramString)
  {
    if (!isSent())
    {
      this.carrier = paramString;
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setCarrier(...) called on TransactionState in ", this.state.toString(), " state" });
  }
  
  public void setCdnVendorName(String paramString)
  {
    this.cdnVendorName = paramString;
  }
  
  public void setConnectType(int paramInt)
  {
    this.connectType = paramInt;
  }
  
  public void setContentType(String paramString)
  {
    this.contentType = paramString;
  }
  
  public void setControllerDispatch(boolean paramBoolean)
  {
    this.controllerDispatch = paramBoolean;
  }
  
  public void setDnsElapse(int paramInt)
  {
    this.dnsElapse = paramInt;
  }
  
  public void setErrorCode(int paramInt, String paramString)
  {
    if (!isComplete())
    {
      this.errorCode = paramInt;
      this.exception = paramString;
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", "errorCode:", String.valueOf(this.errorCode), ", errorInfo:", this.exception });
      return;
    }
    if (this.transactionData != null) {
      this.transactionData.setErrorCode(paramInt);
    }
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setErrorCode(...) called on TransactionState in ", this.state.toString(), " state" });
  }
  
  public void setException(String paramString)
  {
    this.exception = paramString;
  }
  
  public void setFormattedUrlParams(String paramString)
  {
    if ((this.urlParams != null) && (!this.urlParams.isEmpty())) {
      if (!paramString.isEmpty()) {
        paramString = this.urlParams + "&" + paramString;
      }
    }
    for (;;)
    {
      String str = paramString;
      if (paramString != null)
      {
        str = paramString;
        if (paramString.endsWith("&")) {
          str = paramString.substring(0, paramString.length() - 1);
        }
      }
      if ((str != null) && (str.length() > 1024)) {}
      for (this.formattedUrlParams = str.substring(0, 1024);; this.formattedUrlParams = str)
      {
        this.hasParseUrlParams = true;
        return;
        paramString = this.urlParams;
        break;
      }
    }
  }
  
  public void setHost(String paramString)
  {
    this.urlBuilder.setHostname(paramString);
  }
  
  public void setHttpLibType(HttpLibType paramHttpLibType)
  {
    this.httpLibType = paramHttpLibType;
  }
  
  public void setHttpPath(String paramString)
  {
    this.urlBuilder.setHttpPath(paramString);
  }
  
  public void setMethodType(String paramString)
  {
    this.methodType = paramString;
  }
  
  public void setNewUrlParams(String paramString)
  {
    this.urlParams = paramString;
  }
  
  public void setPort(int paramInt)
  {
    this.urlBuilder.setHostPort(paramInt);
  }
  
  public void setQueueTime(int paramInt)
  {
    this.queueTime = paramInt;
  }
  
  public void setQueueTimeStamp(long paramLong)
  {
    this.queueTimeStamp = paramLong;
  }
  
  public void setRequestMethod(RequestMethodType paramRequestMethodType)
  {
    this.requestMethod = paramRequestMethodType;
  }
  
  public void setScheme(UrlBuilder.Scheme paramScheme)
  {
    this.urlBuilder.setScheme(paramScheme);
  }
  
  public void setSslHandShakeTime(int paramInt)
  {
    this.sslHandShakeTime = paramInt;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public void setState(int paramInt)
  {
    if (paramInt == QAPMTransactionState.State.READY.ordinal()) {
      this.state = QAPMTransactionState.State.READY;
    }
    do
    {
      return;
      if (paramInt == QAPMTransactionState.State.SENT.ordinal())
      {
        this.state = QAPMTransactionState.State.SENT;
        return;
      }
    } while (paramInt != QAPMTransactionState.State.COMPLETE.ordinal());
    this.state = QAPMTransactionState.State.COMPLETE;
  }
  
  public void setStatusCode(int paramInt)
  {
    if (!isComplete())
    {
      this.statusCode = paramInt;
      if (paramInt == 200) {
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMTransactionState", "set status code:", String.valueOf(paramInt) });
      }
      return;
    }
    this.statusCode = paramInt;
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setStatusCode(...) called on TransactionState in ", this.state.toString(), " state" });
  }
  
  public void setTcpHandShakeTime(int paramInt)
  {
    this.tcpHandShakeTime = paramInt;
  }
  
  public void setTyIdRandomInt(int paramInt)
  {
    this.tyIdRandomInt = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    String str = StringUtil.changeUrl(paramString);
    if (str != null)
    {
      paramString = str;
      if (str != null)
      {
        paramString = str;
        if (str.length() > 1024) {
          paramString = str.substring(0, 1024);
        }
      }
      if (!isSent()) {
        this.url = paramString;
      }
    }
    else
    {
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMTransactionState", "setUrl(...) called on TransactionState in ", this.state.toString(), " state" });
  }
  
  public void setUrlParams(String paramString)
  {
    this.urlParams = paramString;
  }
  
  public void setUrlValue(String paramString)
  {
    if (paramString == null)
    {
      this.url = "";
      return;
    }
    this.url = paramString;
  }
  
  public void setUserActionId(String paramString)
  {
    this.userActionId = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url:" + this.url);
    localStringBuilder.append("statusCode:" + this.statusCode);
    localStringBuilder.append("errorCode:" + this.errorCode);
    localStringBuilder.append("bytesSent:" + this.bytesSent);
    localStringBuilder.append("bytesReceived:" + this.bytesReceived);
    localStringBuilder.append("startTime:" + this.startTime);
    localStringBuilder.append("endTime:" + this.endTime);
    localStringBuilder.append("appData:" + this.appData);
    localStringBuilder.append("carrier:" + this.carrier);
    localStringBuilder.append("state:" + this.state.ordinal());
    localStringBuilder.append("contentType:" + this.contentType);
    if (this.transactionData != null) {
      localStringBuilder.append("trancastionData:" + this.transactionData.toString());
    }
    if (this.formattedUrlParams != null) {
      localStringBuilder.append("formattedUrlParams:" + this.formattedUrlParams);
    }
    localStringBuilder.append("Requestmethodtype:" + this.requestMethod);
    localStringBuilder.append("httplibType:" + this.httpLibType);
    localStringBuilder.append("urlBuilder:" + this.urlBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMTransactionState
 * JD-Core Version:    0.7.0.1
 */