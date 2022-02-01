package com.tencent.mobileqq.transfile;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPtt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PttUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPttUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.manager.ProxyIpManager;

public class JSPttUploadProcessor
  extends BaseUploadProcessor
{
  public static final String TAG = "JSPttUploadProcessor";
  String mFileKey;
  
  public JSPttUploadProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    this.mProxyIpList = ((ProxyIpManager)this.app.getManager(3)).getProxyIp(4);
  }
  
  private int doCheckParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    String str = this.mUiRequest.mLocalPath;
    if ((str == null) || ("".equals(str)))
    {
      setError(9302, getExpStackString(new Exception("filePath null")));
      onError();
      return -1;
    }
    if (str != null)
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        setError(9042, getExpStackString(new Exception("sendFile not exist " + str)));
        onError();
        return -1;
      }
      if (!localFile.canRead())
      {
        setError(9070, getExpStackString(new Exception("sendFile not readable " + this.file.filePath)));
        onError();
        return -1;
      }
      this.mExtName = "amr";
      long l = localFile.length();
      this.file.fileSize = l;
      this.mFileSize = l;
      if (l <= 0L)
      {
        setError(9071, getExpStackString(new Exception("file size 0 " + str)));
        onError();
        return -1;
      }
    }
    return 0;
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
    if (this.mRaf == null) {
      try
      {
        this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
        if (this.mRaf == null)
        {
          setError(9303, "read file error");
          onError();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.mRaf = null;
        }
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
    paramArrayOfByte = replaceUrlWithProxyIp(localStringBuilder.toString(), this.mIpList);
    BaseTransProcessor.addProxyIpToList(this.mProxyIpList, this.mIpList);
    return paramArrayOfByte;
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.C2CPttUpResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "JSPttUpProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.mSendByQuickHttp);
        }
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if (paramRichProtoReq.result == 0)
        {
          if (paramRichProtoReq.isExist) {
            this.mResid = paramRichProtoReq.uuid;
          }
          for (;;)
          {
            i += 1;
            break;
            this.mResid = paramRichProtoReq.uuid;
            this.mUkey = paramRichProtoReq.mUkey;
            this.mIpList = paramRichProtoReq.ipList;
            this.mTransferedSize = 0L;
            this.mBlockSize = paramRichProtoReq.blockSize;
            ((IPublicAccountH5AbilityPtt)QRoute.api(IPublicAccountH5AbilityPtt.class)).setServerIdForPtt(this.mResid);
            sendFile();
          }
        }
        onError();
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
    Object localObject1 = null;
    super.onResp(paramNetResp);
    this.mNetReq = null;
    int i = paramNetResp.mHttpCode;
    for (;;)
    {
      long l2;
      try
      {
        if (paramNetResp.mResult != 0) {
          break label505;
        }
        if (paramNetResp.mRespProperties.get("User-ReturnCode") == null) {
          break label579;
        }
        l3 = Long.parseLong((String)paramNetResp.mRespProperties.get("User-ReturnCode"));
        if ((l3 != 0L) && (l3 != 9223372036854775807L))
        {
          copyStatisInfoFromNetResp(this.mStepTrans, paramNetResp, false);
          setError(-9527, null, getHttpDataReason(i, l3), this.mStepTrans);
          onError();
          return;
        }
        str2 = (String)paramNetResp.mRespProperties.get("Range");
        if (str2 == null) {
          break label587;
        }
      }
      catch (Exception paramNetResp)
      {
        String str2;
        String str1;
        setError(9343, BaseTransProcessor.getExceptionMessage(new Exception("decode unknown exception")), "", this.mStepTrans);
        onError();
        return;
      }
      try
      {
        i = Integer.parseInt(str2);
        l1 = i;
        l2 = l1;
        if (l1 == 9223372036854775807L)
        {
          str1 = (String)paramNetResp.mRespProperties.get("X-Range");
          localObject1 = str1;
          l2 = l1;
          if (str1 == null) {}
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
      try
      {
        i = Integer.parseInt(str1);
        l2 = i;
        localObject1 = str1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        l2 = 9223372036854775807L;
        Object localObject2 = localException2;
        continue;
        logRichMediaEvent("decodeHttpResp", "from " + this.mTransferedSize + " to " + l2 + " userReturnCode:" + l3);
        if (l2 > this.mTransferedSize) {
          break label420;
        }
        if (this.mServerRollbackCount >= 3) {
          break label460;
        }
        logRichMediaEvent("procHttpRespBody", "server offset rollback");
        this.mServerRollbackCount += 1;
        this.file.transferedSize = l2;
        this.mTransferedSize = l2;
        copyStatisInfoFromNetResp(this.mStepTrans, paramNetResp, true);
        if (l2 >= this.mFileSize) {
          break label500;
        }
        sendFile();
        return;
        copyStatisInfoFromNetResp(this.mStepTrans, paramNetResp, false);
        setError(-9527, "", getServerReason(this.httpOkFailPre, this.errorHttpRollback), this.mStepTrans);
        onError();
        return;
        onSuccess();
        return;
      }
      if (l2 == 9223372036854775807L)
      {
        copyStatisInfoFromNetResp(this.mStepTrans, paramNetResp, false);
        setError(-9527, "no header range:" + str2 + " x-range:" + localObject1, getServerReason(this.httpOkFailPre, this.errorHttpBadResp), this.mStepTrans);
        PttInfoCollector.reportNoRange(true);
        onError();
        return;
      }
      label420:
      label460:
      label500:
      label505:
      if ((paramNetResp.mErrCode == 9364) && (this.mNetworkChgRetryCount < 3))
      {
        logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
        this.mNetworkChgRetryCount += 1;
        clearReprotInfo();
        sendRequest();
        return;
      }
      copyStatisInfoFromNetResp(this.mStepTrans, paramNetResp, false);
      setError(paramNetResp.mErrCode, paramNetResp.mErrDesc);
      onError();
      return;
      label579:
      long l3 = 9223372036854775807L;
      continue;
      label587:
      long l1 = 9223372036854775807L;
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
    this.mStepUrl.logStartTime();
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
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("requestStart", localRichProtoReq.toString());
      }
    } while (!canDoNextStep());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.JSPttUploadProcessor
 * JD-Core Version:    0.7.0.1
 */