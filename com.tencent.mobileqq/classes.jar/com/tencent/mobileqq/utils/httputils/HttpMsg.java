package com.tencent.mobileqq.utils.httputils;

import com.tencent.mobileqq.transfile.TimeoutParam;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class HttpMsg
  extends BaseHttpMsg
{
  public static final String ACCEPT = "Accept";
  public static final String ACCEPT_ENCODING = "Accept-Encoding";
  public static final String ACCEPT_TYPE = "text/vnd.wap.wml,image/*,audio/*,text/vnd.sun.j2me.app-descriptor,application/*";
  public static final String CACHE_CONTROL = "cache-control";
  public static final String CDN_LOG_UUID = "X-NWS-LOG-UUID";
  public static final String CHARSET = "charset";
  public static final String CONNECTION = "Connection";
  public static final String CONTENTENCODING = "Content-Encoding";
  public static final String CONTENTRANGE = "content-range";
  public static final String CONTENT_LENGTH = "Content-Length";
  public static final String CONTENT_TYPE = "Content-Type";
  public static final String COOKIE = "Cookie";
  public static final String ERR_BIGPACHAGE = "the package is over max limit";
  public static final String ERR_CLOSE_OR_CANCEL = "HttpCommunicator closed or msg caceled!";
  public static final String ERR_HttpCommunicator_Closed = "httpcommunicator closed";
  public static final String ERR_PREEMPTED = "preempted by higher msg";
  public static final String ERR_User_Cancelled = "request cancelled";
  public static final String EXPIRES = "Expires";
  public static final String FILE_JAD = "jad";
  public static final String FILE_JAR = "jar";
  public static final String FILE_TEL = "wtai://wp/mc;";
  public static final String FILE_UNKNOWN = "unknown";
  public static final String HOST = "host";
  public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
  public static final String LAST_MODIFIED = "last-modified";
  public static final String LOCATION = "Location";
  public static final String MAX_AGE = "max-age";
  public static final String METHOD_GET = "GET";
  public static final String METHOD_POST = "POST";
  public static final String MTYPE = "mType";
  public static final String NO_CACHE = "no-cache";
  public static final int PACKAGE_BYTE = 2048;
  public static final String PRAGMA = "Pragma";
  public static String Param_Reason = "param_reason";
  public static final String QCOOKIE = "Q-Cookie";
  public static final String QQPROTOCOLVERSION = "2";
  public static final String RANGE = "Range";
  public static final String REFERER = "Referer";
  public static final String Report_HtTime = "X-httime";
  public static final String Report_PiccacheTime = "X-piccachetime";
  public static final String SET_COOKIE = "Set-Cookie";
  public static final String SET_QCOOKIE = "Set-Q-Cookie";
  public static final String TAG = "Q.richmedia.HttpMsg";
  public static final String TRANSFERENCODING = "Transfer-Encoding";
  public static final String TYPE_HTML = "text/html";
  public static final String TYPE_IMAGE = "image";
  public static final String TYPE_JAD = "text/vnd.sun.j2me.app-descriptor";
  public static final String TYPE_JAR = "application/java-archive";
  public static final String TYPE_MUL_PARTS = "multipart/form-data";
  public static final String TYPE_TEXT = "text/plain";
  public static final String TYPE_WBXML = "application/vnd.wap.wbxml";
  public static final String TYPE_XHTML = "application/vnd.wap.xhtml+xml";
  public static final String TYPE_XHTML2 = "application/xhtml+xml";
  public static final String USERRANGE = "User-Range";
  public static final String USERRETURNCODE = "User-ReturnCode";
  public static final String USER_AGENT = "User-Agent";
  public static final String UTF8 = "utf-8";
  public static final String XERROR = "X-ErrNo";
  public static final String XRANGE = "X-Range";
  public static final String XRetryFlag = "X-RtFlag";
  public static final String XUSERRETURNCODE = "X-User-ReturnCode";
  public static final String X_CACHE_LOOKUP = "X-Cache-Lookup";
  public static final String ZERO = "0";
  private boolean bDataSlice = false;
  private boolean bInstanceFollowRedirects = true;
  public boolean bReportRedirects = false;
  final boolean bVerifyPayment;
  public boolean bViaWhiteShark = false;
  public int busiType = -1;
  private String connectString;
  public long cost = 0L;
  public int data_slice_type;
  public long detailErrcode;
  public int errCode;
  public String errString = null;
  public int fileType = -1;
  public int flow;
  public AtomicBoolean hasFinished;
  public long inQueueCost = 0L;
  public long inQueueStartTime = 0L;
  public boolean isCmwapRetried = false;
  public boolean isRequestInCmwap = false;
  public Object lockForSyncSend = null;
  public boolean mCanPrintUrl = true;
  public int mCmwapConnectionType = 0;
  public HttpURLConnection mConn = null;
  public boolean mHaveIpConnect = false;
  public AtomicBoolean mIsCancel = new AtomicBoolean(false);
  public boolean mIsHostIP;
  public boolean mIsHttps;
  public boolean mIsPreStructPic;
  public AtomicBoolean mIsPreempted = new AtomicBoolean(false);
  public boolean mIsSync;
  public boolean mNeedNotReferer = false;
  public String mReqHost;
  public boolean mUseByteArrayPool = false;
  public String msgId;
  public int netType;
  private final IHttpCommunicatorListener processor;
  public String rawReqHeader;
  public String rawRespHeader;
  private String realConnectString;
  private byte[] recvData;
  private String requestMethod = "GET";
  public HashMap<String, String> requestPropertys = new HashMap();
  public int responseCode = -1;
  public HashMap<String, String> responsePropertys = new HashMap();
  private byte[] sendData;
  private int serial = 0;
  public long startTime = 0L;
  public int threadPriority = 201;
  public TimeoutParam timeoutParam;
  public long totalBlockLen = 0L;
  public long totalLen = 0L;
  public String[] whiteList_type;
  
  public HttpMsg(String paramString, byte[] paramArrayOfByte, IHttpCommunicatorListener paramIHttpCommunicatorListener)
  {
    this(paramString, paramArrayOfByte, paramIHttpCommunicatorListener, false);
  }
  
  public HttpMsg(String paramString, byte[] paramArrayOfByte, IHttpCommunicatorListener paramIHttpCommunicatorListener, boolean paramBoolean)
  {
    this.connectString = paramString;
    if (paramString != null) {
      this.realConnectString = paramString.substring(0, paramString.length());
    } else {
      this.realConnectString = null;
    }
    this.processor = paramIHttpCommunicatorListener;
    if (paramArrayOfByte == null)
    {
      this.sendData = null;
    }
    else
    {
      this.sendData = new byte[paramArrayOfByte.length];
      paramString = this.sendData;
      System.arraycopy(paramArrayOfByte, 0, paramString, 0, paramString.length);
    }
    this.bVerifyPayment = paramBoolean;
  }
  
  public String getErrorString()
  {
    return this.errString;
  }
  
  public int getPriority()
  {
    return this.threadPriority;
  }
  
  public IHttpCommunicatorListener getProcessor()
  {
    return this.processor;
  }
  
  public String getRealUrl()
  {
    return this.realConnectString;
  }
  
  public byte[] getRecvData()
  {
    return this.recvData;
  }
  
  public String getRequestMethod()
  {
    return this.requestMethod;
  }
  
  public HashMap<String, String> getRequestPropertys()
  {
    return this.requestPropertys;
  }
  
  public int getResponseCode()
  {
    return this.responseCode;
  }
  
  public String getResponseProperty(String paramString)
  {
    return (String)this.responsePropertys.get(paramString);
  }
  
  public byte[] getSendData()
  {
    return this.sendData;
  }
  
  public int getSerial()
  {
    return this.serial;
  }
  
  public long getTotalLen()
  {
    return this.totalLen;
  }
  
  public String getUrl()
  {
    return this.connectString;
  }
  
  public String getUrlForLog()
  {
    String str2 = getUrl();
    String str1 = str2;
    if (!this.mCanPrintUrl) {
      str1 = TransFileUtil.getIpOrDomainFromURL(str2);
    }
    return str1;
  }
  
  public boolean isDataSlice()
  {
    return this.bDataSlice;
  }
  
  public boolean isInstanceFollowRedirects()
  {
    return this.bInstanceFollowRedirects;
  }
  
  public boolean isViaWhiteShark()
  {
    return this.bViaWhiteShark;
  }
  
  public boolean permitRetry()
  {
    if ((this.responsePropertys.containsKey("X-RtFlag")) && ("0".equals(this.responsePropertys.get("X-RtFlag"))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpMsg", 2, "permitRetry : X-RtFlag = 0");
      }
      return false;
    }
    int i = this.errCode;
    if ((i != 9048) && (i != 9057) && (i != 9020) && (i != 9022) && (i != 9366)) {
      return i != 9058;
    }
    return false;
  }
  
  public void refresh()
  {
    resetTranFlag();
    this.errCode = 0;
    this.responseCode = 0;
    this.errString = null;
    this.recvData = null;
  }
  
  public void resetTranFlag()
  {
    this.mIsCancel.set(false);
    this.mIsPreempted.set(false);
    AtomicBoolean localAtomicBoolean = this.hasFinished;
    if (localAtomicBoolean != null) {
      localAtomicBoolean.set(false);
    }
    this.mConn = null;
  }
  
  public void setConnectString(String paramString)
  {
    this.connectString = paramString;
  }
  
  public void setDataSlice(boolean paramBoolean)
  {
    this.bDataSlice = paramBoolean;
  }
  
  public void setHttpErrorCode(int paramInt1, int paramInt2, String paramString)
  {
    this.errCode = paramInt1;
    this.responseCode = paramInt2;
    this.errString = paramString;
  }
  
  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.bInstanceFollowRedirects = paramBoolean;
  }
  
  public void setPriority(int paramInt)
  {
    if (paramInt == 5)
    {
      this.threadPriority = 201;
      return;
    }
    if (paramInt == 1)
    {
      this.threadPriority = 202;
      return;
    }
    if (paramInt == 10)
    {
      this.threadPriority = 200;
      return;
    }
    this.threadPriority = paramInt;
  }
  
  public void setRealUrl(String paramString)
  {
    this.realConnectString = paramString;
  }
  
  public void setRecvData(byte[] paramArrayOfByte)
  {
    this.recvData = paramArrayOfByte;
  }
  
  public void setRequestMethod(String paramString)
  {
    this.requestMethod = paramString;
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      this.requestPropertys.put(paramString1, paramString2);
    }
  }
  
  public void setResponseCode(int paramInt)
  {
    this.responseCode = paramInt;
  }
  
  public void setResponseProperty(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      this.responsePropertys.put(paramString1, paramString2);
    }
  }
  
  public void setSendData(byte[] paramArrayOfByte)
  {
    this.sendData = paramArrayOfByte;
  }
  
  public void setSerial(int paramInt)
  {
    this.serial = paramInt;
  }
  
  public void setUrl(String paramString)
  {
    this.connectString = paramString;
    paramString = this.connectString;
    this.realConnectString = paramString.substring(0, paramString.length());
  }
  
  public void setViaWhiteShark(boolean paramBoolean)
  {
    this.bViaWhiteShark = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpMsg
 * JD-Core Version:    0.7.0.1
 */