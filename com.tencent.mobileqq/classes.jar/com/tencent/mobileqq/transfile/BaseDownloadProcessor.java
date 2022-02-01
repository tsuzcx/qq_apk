package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.ipv6.IpStrategy;
import com.tencent.mobileqq.transfile.ipv6.IpStrategyFactory;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseDownloadProcessor
  extends BaseTransProcessor
{
  public static final boolean IS_MAIN_PROCESS;
  public static final String PTT_VIDEO_DOWNLOAD_DOMAIN = "grouptalk.c2c.qq.com";
  public static final boolean S_CAN_PRINT_URL = true;
  private static int mPicDownloadPort;
  private static boolean sPicDownloadPortInited;
  QQAppInterface app;
  protected boolean mDirectMsgUrlDown = false;
  public ArrayList<DownCallBack> mDownCallBacks = new ArrayList();
  String mDownDomain;
  public boolean mHasIpv6List;
  ArrayList<ServerAddr> mIpList = new ArrayList();
  protected IpStrategy mIpStrategy;
  public boolean mIpv6First;
  protected boolean mIsHttpsDownload;
  int mLastProgress = 0;
  protected int mNetType;
  long mRecvLen = 0L;
  int mReqUrlCount = 0;
  String mRespUrl = null;
  String mStorageSource = null;
  protected OldEngineDPCProfile mTimeoutProfile;
  long mTotolLen = 0L;
  String mUrlPath;
  
  static
  {
    boolean bool = true;
    sPicDownloadPortInited = false;
    mPicDownloadPort = 80;
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      IS_MAIN_PROCESS = bool;
      return;
      bool = false;
    }
  }
  
  public BaseDownloadProcessor() {}
  
  public BaseDownloadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    this.app = ((QQAppInterface)this.app);
    if (paramTransferRequest.mDownCallBack != null) {}
    try
    {
      this.mDownCallBacks.add(paramTransferRequest.mDownCallBack);
      this.mTimeoutProfile = BaseTransProcessorStaticVariable.TIMEOUT_PROFILE;
      this.mIpStrategy = IpStrategyFactory.createDownStrategy();
      this.mNetType = NetConnInfoCenter.getActiveNetIpFamily(true);
      return;
    }
    finally {}
  }
  
  public static byte[] bytesFromHexString(String paramString)
  {
    if (paramString.length() % 2 != 0) {}
    do
    {
      return null;
      try
      {
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        paramString = paramString.toCharArray();
        int i = 0;
        while (i < paramString.length)
        {
          StringBuilder localStringBuilder = new StringBuilder(2);
          localStringBuilder.append(paramString[i]).append(paramString[(i + 1)]);
          arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(localStringBuilder.toString(), 16));
          i += 2;
        }
        return arrayOfByte;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG", 2, "bytesFromHexString Exception=" + paramString.getMessage());
    return null;
  }
  
  public static int getPicDownloadPort()
  {
    if (!sPicDownloadPortInited) {}
    try
    {
      Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("BaseTransProcessor", 2, "getPicDownloadPort:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 9) {
        mPicDownloadPort = Integer.valueOf(localObject[9]).intValue();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseTransProcessor", 2, "getPicDownloadPort e:" + localException.toString());
        }
      }
    }
    sPicDownloadPortInited = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "getPicDownloadPort return " + mPicDownloadPort);
    }
    return mPicDownloadPort;
  }
  
  public void accountChanged()
  {
    setError(9366, "transfileController destroy");
    onError();
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG", 2, "accountChanged transfileController destroy");
    }
    super.accountChanged();
  }
  
  public void addDownCallback(DownCallBack paramDownCallBack)
  {
    try
    {
      this.mDownCallBacks.add(paramDownCallBack);
      return;
    }
    finally {}
  }
  
  byte[] getMd5InBytesOfGroup(String paramString1, String paramString2)
  {
    String str = null;
    Object localObject = str;
    if (paramString1 != null)
    {
      localObject = str;
      if (paramString1.length() == 32) {
        localObject = bytesFromHexString(paramString1);
      }
    }
    paramString1 = (String)localObject;
    if (localObject == null)
    {
      paramString1 = (String)localObject;
      if (paramString2 != null)
      {
        int i = paramString2.indexOf(".");
        str = paramString2;
        if (i > 0) {
          str = paramString2.substring(0, i);
        }
        if (str.length() != 32) {
          break label85;
        }
        paramString1 = bytesFromHexString(str);
      }
    }
    label85:
    do
    {
      do
      {
        do
        {
          return paramString1;
          if (str.length() != 38) {
            break;
          }
          paramString2 = str.substring(1, 37).replace("-", "");
          paramString1 = (String)localObject;
        } while (paramString2.length() != 32);
        return bytesFromHexString(paramString2);
        paramString1 = (String)localObject;
      } while (str.length() != 34);
      paramString2 = str.substring(1, 33);
      paramString1 = (String)localObject;
    } while (paramString2.length() != 32);
    return bytesFromHexString(paramString2);
  }
  
  protected boolean isUploadProcessor()
  {
    return false;
  }
  
  public void removeDownCallBack(DownCallBack paramDownCallBack)
  {
    try
    {
      if (this.mDownCallBacks != null) {
        this.mDownCallBacks.remove(paramDownCallBack);
      }
      return;
    }
    finally {}
  }
  
  public void reportForIpv6(boolean paramBoolean, long paramLong)
  {
    int j = 1;
    if (this.mIpv6First) {
      this.mReportInfo.put("param_is_ipv6", String.valueOf(1));
    }
    HashMap localHashMap = this.mReportInfo;
    if (this.mHasIpv6List)
    {
      i = 1;
      localHashMap.put("param_hasV6List", String.valueOf(i));
      localHashMap = this.mReportInfo;
      if (!this.mIpv6First) {
        break label99;
      }
    }
    label99:
    for (int i = j;; i = 0)
    {
      localHashMap.put("param_ipv6First", String.valueOf(i));
      super.reportForIpv6(paramBoolean, paramLong);
      return;
      i = 0;
      break;
    }
  }
  
  protected void reportForServerMonitor(NetResp paramNetResp, boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject;
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq)) && (((HttpNetReq)this.mNetReq).mReqUrl != null))
    {
      localObject = ((HttpNetReq)this.mNetReq).mReqUrl;
      this.mRSMReporter.mUrl = ((String)localObject);
    }
    try
    {
      localObject = new URL((String)localObject);
      String str = ((URL)localObject).getHost();
      int i = ((URL)localObject).getPort();
      this.mRSMReporter.mServerIp = str;
      this.mRSMReporter.mServerPort = String.valueOf(i);
      this.mRSMReporter.mHttpErrCode = (paramNetResp.mHttpCode + "");
      this.mRSMReporter.mMD5 = this.mUiRequest.mMd5;
      this.mRSMReporter.mUUID = paramString2;
      this.mRSMReporter.mFailCode = String.valueOf(paramNetResp.mErrCode);
      this.mRSMReporter.mErrDesc = paramNetResp.mErrDesc;
      if (paramNetResp.mErrCode == -9527) {}
      for (paramNetResp = (String)paramNetResp.mRespProperties.get("netresp_param_reason");; paramNetResp = null)
      {
        this.mRSMReporter.mReason = paramNetResp;
        doReportForServerMonitor(paramString1, paramBoolean);
        return;
      }
      return;
    }
    catch (Throwable paramNetResp)
    {
      QLog.e("BaseTransProcessor", 1, "reportForServerMonitor err.", paramNetResp);
    }
  }
  
  protected ArrayList<ServerAddr> selectIpList(ArrayList<ServerAddr> paramArrayList1, ArrayList<ServerAddr> paramArrayList2)
  {
    this.mHasIpv6List = false;
    this.mIpv6First = false;
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      this.mHasIpv6List = true;
    }
    paramArrayList1 = this.mIpStrategy.selectIpList(paramArrayList1, paramArrayList2, this.mNetType);
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      paramArrayList2 = (ServerAddr)paramArrayList1.get(0);
      if ((paramArrayList2 != null) && (paramArrayList2.isIpv6)) {
        this.mIpv6First = true;
      }
    }
    return paramArrayList1;
  }
  
  public void start()
  {
    try
    {
      if (this.file != null)
      {
        this.file.status = 2001;
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "start ");
        }
      }
      super.start();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */