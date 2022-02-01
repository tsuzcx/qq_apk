package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.ptt.api.impl.PttInfoCollectorImpl;
import com.tencent.mobileqq.ptt.temp.api.IPttTempApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPttUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JSPttUploadProcessor
  extends BaseUploadProcessor
{
  public static final String TAG = "JSPttUploadProcessor";
  String mFileKey;
  
  public JSPttUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
  }
  
  private int doCheckParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    Object localObject1 = this.mUiRequest.mLocalPath;
    if ((localObject1 != null) && (!"".equals(localObject1)))
    {
      if (localObject1 != null)
      {
        Object localObject2 = new File((String)localObject1);
        StringBuilder localStringBuilder;
        if (!((File)localObject2).exists())
        {
          localObject2 = this.mProcessorReport;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("sendFile not exist ");
          localStringBuilder.append((String)localObject1);
          ((ProcessorReport)localObject2).setError(9042, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
          onError();
          return -1;
        }
        if (!((File)localObject2).canRead())
        {
          localObject1 = this.mProcessorReport;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sendFile not readable ");
          ((StringBuilder)localObject2).append(this.file.filePath);
          ((ProcessorReport)localObject1).setError(9070, getExpStackString(new Exception(((StringBuilder)localObject2).toString())), null, null);
          onError();
          return -1;
        }
        this.mExtName = "amr";
        long l = ((File)localObject2).length();
        this.file.fileSize = l;
        this.mFileSize = l;
        if (l <= 0L)
        {
          localObject2 = this.mProcessorReport;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("file size 0 ");
          localStringBuilder.append((String)localObject1);
          ((ProcessorReport)localObject2).setError(9071, getExpStackString(new Exception(localStringBuilder.toString())), null, null);
          onError();
          return -1;
        }
      }
      return 0;
    }
    this.mProcessorReport.setError(9302, getExpStackString(new Exception("filePath null")), null, null);
    onError();
    return -1;
  }
  
  private void doStart(boolean paramBoolean)
  {
    if (!paramBoolean) {
      sendMessageToUpdate(1001);
    }
    this.file.closeInputStream();
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      onError();
      return;
    }
    if (this.mRaf == null)
    {
      try
      {
        this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        this.mRaf = null;
      }
      if (this.mRaf == null)
      {
        this.mProcessorReport.setError(9303, "read file error", null, null);
        onError();
        return;
      }
    }
    sendRequest();
  }
  
  public int checkParam()
  {
    super.checkParam();
    return doCheckParam();
  }
  
  protected String getConnUrl(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.mIpList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localServerAddr.mIp);
    if (localServerAddr.port != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localServerAddr.port);
    }
    localStringBuilder.append("/qqcommfileupload?ver=");
    localStringBuilder.append(100);
    localStringBuilder.append("&ukey=");
    localStringBuilder.append(this.mUkey);
    localStringBuilder.append("&filekey=");
    localStringBuilder.append(this.mMd5Str);
    localStringBuilder.append("&filesize=");
    localStringBuilder.append(this.mFileSize);
    localStringBuilder.append("&bmd5=");
    localStringBuilder.append(MD5.toMD5(paramArrayOfByte));
    localStringBuilder.append("&range=");
    localStringBuilder.append(this.mTransferedSize);
    localStringBuilder.append("&voice_codec=0");
    return localStringBuilder.toString();
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPttUpResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mProcessorReport.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("JSPttUpProcessor.onBusiProtoResp:isSendByQuickHttp=");
          localStringBuilder.append(this.mProcessorReport.mSendByQuickHttp);
          QLog.e("http_sideway", 2, localStringBuilder.toString());
        }
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result == 0)
        {
          if (paramRichProtoReq.isExist)
          {
            this.mResid = paramRichProtoReq.uuid;
          }
          else
          {
            this.mResid = paramRichProtoReq.uuid;
            this.mUkey = paramRichProtoReq.mUkey;
            this.mIpList = paramRichProtoReq.ipList;
            this.mTransferedSize = 0L;
            this.mBlockSize = paramRichProtoReq.blockSize;
            ((IPttTempApi)QRoute.api(IPttTempApi.class)).setJsPttServerId(this.mResid);
            sendFile();
          }
          i += 1;
        }
        else
        {
          onError();
        }
      }
    }
  }
  
  void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    doReport(false);
  }
  
  public void onResp(NetResp paramNetResp)
  {
    super.onResp(paramNetResp);
    Object localObject1 = null;
    this.mNetReq = null;
    int i = paramNetResp.mHttpCode;
    try
    {
      if (paramNetResp.mResult != 0) {
        break label591;
      }
      if (paramNetResp.mRespProperties.get("User-ReturnCode") == null) {
        break label725;
      }
      l3 = Long.parseLong((String)paramNetResp.mRespProperties.get("User-ReturnCode"));
    }
    catch (Exception paramNetResp)
    {
      for (;;)
      {
        String str;
        long l2;
        Object localObject3;
        Object localObject2;
        continue;
        long l3 = 9223372036854775807L;
        continue;
        long l1 = 9223372036854775807L;
      }
    }
    if ((l3 != 0L) && (l3 != 9223372036854775807L))
    {
      this.mProcessorReport.copyStaticsInfoFromNetResp(this.mProcessorReport.mStepTrans, paramNetResp, false);
      paramNetResp = this.mProcessorReport;
      localObject1 = this.mProcessorReport;
      paramNetResp.setError(-9527, null, ProcessorReport.getHttpDataReason(i, l3), this.mProcessorReport.mStepTrans);
      onError();
      return;
    }
    str = (String)paramNetResp.mRespProperties.get("Range");
    if (str != null)
    {
      try
      {
        i = Integer.parseInt(str);
        l1 = i;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        break label733;
      }
      l2 = l1;
      if (l1 == 9223372036854775807L)
      {
        localObject3 = (String)paramNetResp.mRespProperties.get("X-Range");
        localObject1 = localObject3;
        l2 = l1;
        if (localObject3 != null) {
          try
          {
            i = Integer.parseInt((String)localObject3);
            l2 = i;
            localObject1 = localObject3;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            l2 = 9223372036854775807L;
            localObject2 = localObject3;
          }
        }
      }
      if (l2 == 9223372036854775807L)
      {
        this.mProcessorReport.copyStaticsInfoFromNetResp(this.mProcessorReport.mStepTrans, paramNetResp, false);
        paramNetResp = this.mProcessorReport;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("no header range:");
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(" x-range:");
        ((StringBuilder)localObject3).append((String)localObject2);
        localObject2 = ((StringBuilder)localObject3).toString();
        localObject3 = this.mProcessorReport;
        paramNetResp.setError(-9527, (String)localObject2, ProcessorReport.getServerReason("Q", -9531L), this.mProcessorReport.mStepTrans);
        new PttInfoCollectorImpl().reportNoRange(true);
        onError();
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("from ");
      ((StringBuilder)localObject2).append(this.mTransferedSize);
      ((StringBuilder)localObject2).append(" to ");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(" userReturnCode:");
      ((StringBuilder)localObject2).append(l3);
      logRichMediaEvent("decodeHttpResp", ((StringBuilder)localObject2).toString());
      if (l2 <= this.mTransferedSize) {
        if (this.mServerRollbackCount < 3)
        {
          logRichMediaEvent("procHttpRespBody", "server offset rollback");
          this.mServerRollbackCount += 1;
        }
        else
        {
          this.mProcessorReport.copyStaticsInfoFromNetResp(this.mProcessorReport.mStepTrans, paramNetResp, false);
          paramNetResp = this.mProcessorReport;
          localObject2 = this.mProcessorReport;
          paramNetResp.setError(-9527, "", ProcessorReport.getServerReason("Q", -9530L), this.mProcessorReport.mStepTrans);
          onError();
          return;
        }
      }
      this.file.transferedSize = l2;
      this.mTransferedSize = l2;
      this.mProcessorReport.copyStaticsInfoFromNetResp(this.mProcessorReport.mStepTrans, paramNetResp, true);
      if (l2 < this.mFileSize)
      {
        sendFile();
        return;
      }
      onSuccess();
      return;
      label591:
      if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
      {
        logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
        this.mNetworkChgRetryCount += 1;
        clearReprotInfo();
        sendRequest();
        return;
      }
      this.mProcessorReport.copyStaticsInfoFromNetResp(this.mProcessorReport.mStepTrans, paramNetResp, false);
      this.mProcessorReport.setError(paramNetResp.mErrCode, paramNetResp.mErrDesc, null, null);
      onError();
      return;
      paramNetResp = this.mProcessorReport;
      localObject2 = this.mProcessorReport;
      paramNetResp.setError(9343, ProcessorReport.getExceptionMessage(new Exception("decode unknown exception")), "", this.mProcessorReport.mStepTrans);
      onError();
      return;
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    sendMessageToUpdate(1003);
    doReport(true);
  }
  
  void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PttUpReq localPttUpReq = new RichProto.RichProtoReq.PttUpReq();
    localPttUpReq.selfUin = this.mUiRequest.mSelfUin;
    localPttUpReq.peerUin = this.mUiRequest.mPeerUin;
    localPttUpReq.secondUin = this.mUiRequest.mSecondId;
    localPttUpReq.uinType = this.mUiRequest.mUinType;
    localPttUpReq.fileName = this.mFileName;
    localPttUpReq.fileSize = ((int)this.mFileSize);
    localPttUpReq.md5 = this.mLocalMd5;
    localPttUpReq.voiceType = 0;
    localPttUpReq.voiceLength = 1;
    localPttUpReq.audioPanelType = this.mUiRequest.mPttUploadPanel;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "c2c_ptt_up";
    localRichProtoReq.reqs.add(localPttUpReq);
    localRichProtoReq.protoReqMgr = getProtoReqManager();
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    if (QLog.isColorLevel()) {
      logRichMediaEvent("requestStart", localRichProtoReq.toString());
    }
    if (!canDoNextStep()) {
      return;
    }
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  protected void setMtype()
  {
    if ((this.mNetReq != null) && ((this.mNetReq instanceof HttpNetReq))) {
      ((HttpNetReq)this.mNetReq).mReqUrl = MsfSdkUtils.insertMtype("pttCu", ((HttpNetReq)this.mNetReq).mReqUrl);
    }
  }
  
  public void start()
  {
    super.start();
    doStart(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.JSPttUploadProcessor
 * JD-Core Version:    0.7.0.1
 */