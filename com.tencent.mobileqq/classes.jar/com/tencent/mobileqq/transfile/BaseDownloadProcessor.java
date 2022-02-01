package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ipv6.IpStrategy;
import com.tencent.mobileqq.transfile.ipv6.IpStrategyFactory;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class BaseDownloadProcessor
  extends BaseTransProcessor
{
  public static final boolean IS_MAIN_PROCESS;
  public static final String PTT_VIDEO_DOWNLOAD_DOMAIN = "grouptalk.c2c.qq.com";
  public static final boolean S_CAN_PRINT_URL = true;
  private static int mPicDownloadPort = 80;
  private static boolean sPicDownloadPortInited = false;
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
    int i = MobileQQ.sProcessId;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    IS_MAIN_PROCESS = bool;
  }
  
  public BaseDownloadProcessor() {}
  
  public BaseDownloadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    if (paramTransferRequest.mDownCallBack != null) {
      try
      {
        this.mDownCallBacks.add(paramTransferRequest.mDownCallBack);
      }
      finally {}
    }
    this.mTimeoutProfile = BaseTransProcessorStaticVariable.TIMEOUT_PROFILE;
    this.mIpStrategy = IpStrategyFactory.createDownStrategy();
    this.mNetType = NetConnInfoCenter.getActiveNetIpFamily(true);
  }
  
  public static byte[] bytesFromHexString(String paramString)
  {
    if (paramString.length() % 2 != 0) {
      return null;
    }
    try
    {
      localObject = new byte[paramString.length() / 2];
      paramString = paramString.toCharArray();
      int i = 0;
      while (i < paramString.length)
      {
        StringBuilder localStringBuilder = new StringBuilder(2);
        localStringBuilder.append(paramString[i]);
        localStringBuilder.append(paramString[(i + 1)]);
        localObject[(i / 2)] = ((byte)Integer.parseInt(localStringBuilder.toString(), 16));
        i += 2;
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bytesFromHexString Exception=");
        ((StringBuilder)localObject).append(paramString.getMessage());
        QLog.d("PIC_TAG", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public static int getPicDownloadPort()
  {
    if (!sPicDownloadPortInited)
    {
      try
      {
        Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), "");
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("getPicDownloadPort:");
          localStringBuilder2.append((String)localObject);
          QLog.d("BaseTransProcessor", 2, localStringBuilder2.toString());
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 9) {
          mPicDownloadPort = Integer.valueOf(localObject[9]).intValue();
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2;
        if (QLog.isColorLevel())
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("getPicDownloadPort e:");
          localStringBuilder2.append(localException.toString());
          QLog.d("BaseTransProcessor", 2, localStringBuilder2.toString());
        }
      }
      sPicDownloadPortInited = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getPicDownloadPort return ");
      localStringBuilder1.append(mPicDownloadPort);
      QLog.d("BaseTransProcessor", 2, localStringBuilder1.toString());
    }
    return mPicDownloadPort;
  }
  
  public void accountChanged()
  {
    this.mProcessorReport.setError(9366, "transfileController destroy", null, null);
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
    if ((paramString1 != null) && (paramString1.length() == 32)) {
      paramString1 = bytesFromHexString(paramString1);
    } else {
      paramString1 = null;
    }
    Object localObject = paramString1;
    if (paramString1 == null)
    {
      localObject = paramString1;
      if (paramString2 != null)
      {
        int i = paramString2.indexOf(".");
        String str = paramString2;
        if (i > 0) {
          str = paramString2.substring(0, i);
        }
        if (str.length() == 32) {
          return bytesFromHexString(str);
        }
        if (str.length() == 38)
        {
          paramString2 = str.substring(1, 37).replace("-", "");
          localObject = paramString1;
          if (paramString2.length() == 32) {
            return bytesFromHexString(paramString2);
          }
        }
        else
        {
          localObject = paramString1;
          if (str.length() == 34)
          {
            paramString2 = str.substring(1, 33);
            localObject = paramString1;
            if (paramString2.length() == 32) {
              localObject = bytesFromHexString(paramString2);
            }
          }
        }
      }
    }
    return localObject;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void reportForServerMonitor(NetResp paramNetResp, boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject1;
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq)) && (((HttpNetReq)this.mNetReq).mReqUrl != null))
    {
      localObject1 = ((HttpNetReq)this.mNetReq).mReqUrl;
      this.mRSMReporter.mUrl = ((String)localObject1);
    }
    for (;;)
    {
      try
      {
        localObject1 = new URL((String)localObject1);
        Object localObject2 = ((URL)localObject1).getHost();
        int i = ((URL)localObject1).getPort();
        this.mRSMReporter.mServerIp = ((String)localObject2);
        this.mRSMReporter.mServerPort = String.valueOf(i);
        localObject1 = this.mRSMReporter;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramNetResp.mHttpCode);
        ((StringBuilder)localObject2).append("");
        ((RMServMonitorReport)localObject1).mHttpErrCode = ((StringBuilder)localObject2).toString();
        this.mRSMReporter.mMD5 = this.mUiRequest.mMd5;
        this.mRSMReporter.mUUID = paramString2;
        this.mRSMReporter.mFailCode = String.valueOf(paramNetResp.mErrCode);
        this.mRSMReporter.mErrDesc = paramNetResp.mErrDesc;
        if (paramNetResp.mErrCode != -9527) {
          break label281;
        }
        paramNetResp = (String)paramNetResp.mRespProperties.get("netresp_param_reason");
        this.mRSMReporter.mReason = paramNetResp;
        this.mRSMReporter.doReportForServerMonitor(paramString1, paramBoolean, this.mProcessorReport.reason, this.mProcessorReport.errDesc, this.mUiRequest.mUinType, this.mUiRequest.mPeerUin, false, this.mProcessorReport.mStepTrans);
        return;
      }
      catch (Throwable paramNetResp)
      {
        QLog.e("BaseTransProcessor", 1, "reportForServerMonitor err.", paramNetResp);
      }
      return;
      label281:
      paramNetResp = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */