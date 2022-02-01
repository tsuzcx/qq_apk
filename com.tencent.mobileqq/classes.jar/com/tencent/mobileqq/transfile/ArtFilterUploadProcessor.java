package com.tencent.mobileqq.transfile;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.IRequestCallback;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.C2CCommonExtendinfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.FilterExtendinfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.FilterStyle;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.ImageFilterRequest;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.segment.RequestFilter;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ybn;
import ybp;

public class ArtFilterUploadProcessor
  extends BaseUploadProcessor
{
  public static final String CURRENT_TASK_COUNT = "current_TaskCount";
  public static final String DETAIL_PIC_COSTTIME = "detailPic_Costtime";
  public static final String DOWNLOAD_COSTTIME = "download_Costtime";
  public static final String DOWNLOAD_FILE_SIZE = "downloadFileSize";
  public static final String ERRORCODE_REPORT = "errorcode";
  public static final String FILTER_COSTTIME = "filter_Costtime";
  public static final String FILTER_ID = "filterId";
  public static final String IS_UPLOAD_ORIGINAL_PIC = "isuploadOriginalPic";
  public static final String ORIGINAL_COSTTIME = "original_Costtime";
  public static final String REPORT_TAG = "afCosttimeAndFlowReport";
  public static final int STEP_BEGIN = 1;
  public static final int STEP_DOWNLOAD = 4;
  public static final int STEP_FILTER = 3;
  public static final int STEP_FIN = 5;
  public static final int STEP_ORIGIN_IMG = 2;
  public static final String STEP_REPORT = "step";
  public static final String TAG = "ArtFilterUploadProcessor";
  public static final String TEG_COSTTIME = "teg_Costtime";
  public static final String UPLOAD_FILE_SIZE = "uploadFileSize";
  public static final String WUP_COSTTIME = "wup_Costtime";
  public ybn artFilterModule = ybn.a();
  private int callbackId;
  int currentStep;
  long endAllTime = 0L;
  long endDownloadTime = 0L;
  long endFilterTime = 0L;
  long endOringinnalPicTime = 0L;
  long endRequestTime = 0L;
  String fileOutputPath;
  boolean isCanceld = false;
  ybp mFilterUploadInfo;
  boolean needUploadImg;
  long startAllTime = 0L;
  long startDownloadTime = 0L;
  long startFilterTime = 0L;
  long startOringinPicTime = 0L;
  long startRequestTime = 0L;
  int styleId;
  String styleName;
  public int taskId;
  
  public ArtFilterUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest, String paramString)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.mUkey = paramString;
  }
  
  public void begin(int paramInt1, int paramInt2, String paramString, int paramInt3, ybp paramybp, boolean paramBoolean)
  {
    this.callbackId = paramInt1;
    this.styleId = paramInt2;
    this.styleName = paramString;
    this.taskId = paramInt3;
    this.mFilterUploadInfo = paramybp;
    this.needUploadImg = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "FilterUploadInfo:" + paramybp);
    }
    if (paramybp == null) {
      return;
    }
    this.mFileSize = paramybp.jdField_a_of_type_Long;
    this.mLocalMd5 = paramybp.jdField_a_of_type_ArrayOfByte;
    this.mFileName = paramybp.jdField_b_of_type_JavaLangString;
    this.fileOutputPath = (EditVideoArtFilter.jdField_a_of_type_JavaLangString + paramybp.jdField_b_of_type_Long + "_" + paramInt2 + ".png");
    this.mHeight = paramybp.jdField_a_of_type_Int;
    this.mWidth = paramybp.jdField_b_of_type_Int;
    this.startAllTime = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "start()  needUploadImg:" + paramBoolean + " mUky:" + this.mUkey);
    }
    if ((!paramBoolean) && (this.mUkey != null))
    {
      sendFilterToBDHServer();
      return;
    }
    sendRequest();
  }
  
  public int cancel()
  {
    this.isCanceld = true;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "cancelTask taskId:" + this.taskId + " mRichProtoReq:" + this.mRichProtoReq + " mTrans:" + this.mTrans + " mNetReq:" + this.mNetReq);
    }
    if (this.mRichProtoReq != null)
    {
      RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
      this.mRichProtoReq = null;
    }
    if (this.mTrans != null)
    {
      this.mTrans.cancelTransaction();
      this.mTrans = null;
    }
    if (this.mNetReq != null)
    {
      this.mNetEngine.cancelReq(this.mNetReq);
      this.mNetReq = null;
    }
    return 0;
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (this.isCanceld) {}
    do
    {
      return;
      this.mRichProtoReq = null;
      this.endRequestTime = SystemClock.uptimeMillis();
    } while (paramRichProtoResp == null);
    int i = 0;
    label26:
    if (i < paramRichProtoResp.resps.size())
    {
      paramRichProtoReq = (RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoResp.resps.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "getTransferResp:" + paramRichProtoReq);
      }
      if (paramRichProtoReq.result != 0) {
        break label142;
      }
      this.mUkey = paramRichProtoReq.mUkey;
      if (this.artFilterModule.jdField_b_of_type_JavaLangString.equals(this.mFilterUploadInfo.jdField_a_of_type_JavaLangString))
      {
        this.artFilterModule.jdField_a_of_type_JavaLangString = paramRichProtoReq.mUkey;
        sendFile();
      }
    }
    for (;;)
    {
      i += 1;
      break label26;
      break;
      label142:
      returnResult(paramRichProtoReq.result, "getTransferError");
    }
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (this.isCanceld) {
      return;
    }
    super.onResp(paramNetResp);
    this.endDownloadTime = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "getDownLoadResponse: " + paramNetResp);
    }
    this.mReportInfo.put("downloadFileSize", String.valueOf(paramNetResp.mTotalFileLen));
    if (paramNetResp.mResult == 0)
    {
      this.currentStep = 5;
      returnResult(0, null);
      return;
    }
    if (paramNetResp.mErrDesc != null) {
      QLog.d("ArtFilterUploadProcessor", 1, "download dailed, mErrCode" + paramNetResp.mErrCode + "mErrDesc:" + paramNetResp.mErrDesc);
    }
    returnResult(paramNetResp.mErrCode, paramNetResp.mErrDesc);
  }
  
  public void reportKey(String paramString1, String paramString2)
  {
    this.mReportInfo.put(paramString1, paramString2);
  }
  
  public void returnResult(int paramInt, String paramString)
  {
    if (this.isCanceld) {
      return;
    }
    boolean bool;
    Object localObject;
    if (paramInt == 0)
    {
      bool = true;
      this.endAllTime = SystemClock.uptimeMillis();
      localObject = new Bundle();
      ((Bundle)localObject).putInt("param_art_filter_task_id", this.taskId);
      ((Bundle)localObject).putInt("param_art_filter_task_result", paramInt);
      ((Bundle)localObject).putInt("param_art_filter_style_id", this.styleId);
      ((Bundle)localObject).putString("param_art_filter_resource_path", this.mFilterUploadInfo.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putString("param_art_filter_output_path", this.fileOutputPath);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "ReturnFilterResult  callbackId:" + this.callbackId + " taskId:" + this.styleId + " styleId:" + this.taskId + " errorCode:" + paramInt + " errorFrom:" + paramString + " bundle:" + localObject);
      }
      this.artFilterModule.callbackResult(this.callbackId, EIPCResult.createSuccessResult((Bundle)localObject));
      this.artFilterModule.jdField_a_of_type_AndroidUtilSparseArray.remove(this.styleId);
      this.mReportInfo.put("uploadFileSize", String.valueOf(this.mFileSize));
      this.mReportInfo.put("param_FailCode", String.valueOf(paramInt));
      this.mReportInfo.put("step", String.valueOf(this.currentStep));
      this.mReportInfo.put("filterId", String.valueOf(this.styleId));
      localObject = this.mReportInfo;
      if (this.needUploadImg != true) {
        break label579;
      }
    }
    label579:
    for (paramString = "1";; paramString = "0")
    {
      ((HashMap)localObject).put("isuploadOriginalPic", paramString);
      long l1 = 0L;
      long l2 = 0L;
      long l3 = 0L;
      long l4 = 0L;
      if (this.endRequestTime > this.startRequestTime) {
        l1 = this.endRequestTime - this.startRequestTime;
      }
      if (this.endOringinnalPicTime > this.startOringinPicTime) {
        l2 = this.endOringinnalPicTime - this.startOringinPicTime;
      }
      if (this.endFilterTime > this.startFilterTime) {
        l3 = this.endFilterTime - this.startFilterTime;
      }
      if (this.endDownloadTime > this.startDownloadTime) {
        l4 = this.endDownloadTime - this.startDownloadTime;
      }
      this.mReportInfo.put("wup_Costtime", String.valueOf(l1));
      this.mReportInfo.put("original_Costtime", String.valueOf(l2));
      this.mReportInfo.put("filter_Costtime", String.valueOf(l3));
      this.mReportInfo.put("download_Costtime", String.valueOf(l4));
      if (!QLog.isColorLevel()) {
        break label596;
      }
      paramString = new StringBuilder();
      localObject = this.mReportInfo.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (this.mReportInfo.get(str) != null)
        {
          paramString.append("&");
          paramString.append(str);
          paramString.append("=");
          paramString.append((String)this.mReportInfo.get(str));
        }
      }
      bool = false;
      break;
    }
    QLog.d("ArtFilterUploadProcessor", 2, paramString.toString());
    label596:
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "afCosttimeAndFlowReport", bool, this.endAllTime - this.startAllTime, this.mFileSize, this.mReportInfo, "");
  }
  
  public void sendDownLoadRequest(String paramString)
  {
    if (this.isCanceld) {
      return;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = this;
    localHttpNetReq.mReqUrl = paramString;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mNeedIpConnect = true;
    localHttpNetReq.mOutPath = this.fileOutputPath;
    localHttpNetReq.mPrioty = 0;
    localHttpNetReq.mBreakDownFix = mPicBreakDownFixForOldHttpEngine;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "sendDownLoadRequest req:" + localHttpNetReq);
    }
    this.startDownloadTime = SystemClock.uptimeMillis();
    this.currentStep = 4;
    this.mNetEngine.sendReq(localHttpNetReq);
    this.mNetReq = localHttpNetReq;
  }
  
  public final void sendFile()
  {
    if (this.isCanceld) {}
    int i;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "ArtFilterUploadProcessor.sendFile()");
      }
      ArtFilterUploadProcessor.1 local1 = new ArtFilterUploadProcessor.1(this);
      byte[] arrayOfByte = HexUtil.hexStr2Bytes(this.mUkey);
      Object localObject = new CSDataHighwayHead.FilterExtendinfo();
      ((CSDataHighwayHead.FilterExtendinfo)localObject).uint32_filter_flag.set(1);
      CSDataHighwayHead.C2CCommonExtendinfo localC2CCommonExtendinfo = new CSDataHighwayHead.C2CCommonExtendinfo();
      localC2CCommonExtendinfo.uint32_info_id.set(1);
      localC2CCommonExtendinfo.msg_filter_extendinfo.set((MessageMicro)localObject);
      localObject = localC2CCommonExtendinfo.toByteArray();
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 1, this.mFilterUploadInfo.jdField_a_of_type_JavaLangString, (int)this.mStartOffset, arrayOfByte, this.mLocalMd5, local1, (byte[])localObject);
      i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      this.startOringinPicTime = SystemClock.uptimeMillis();
      this.currentStep = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " MD5:" + this.mFilterUploadInfo.jdField_a_of_type_ArrayOfByte + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath);
      }
    } while (i == 0);
    returnResult(i, "submit transaction error");
  }
  
  void sendFilterToBDHServer()
  {
    if (this.isCanceld) {
      return;
    }
    Object localObject1 = new ArtFilterUploadProcessor.2(this);
    Object localObject2 = new CSDataHighwayHead.FilterExtendinfo();
    ((CSDataHighwayHead.FilterExtendinfo)localObject2).uint32_filter_flag.set(2);
    CSDataHighwayHead.C2CCommonExtendinfo localC2CCommonExtendinfo = new CSDataHighwayHead.C2CCommonExtendinfo();
    localC2CCommonExtendinfo.uint32_info_id.set(1);
    CSDataHighwayHead.FilterStyle localFilterStyle = new CSDataHighwayHead.FilterStyle();
    localFilterStyle.style_id.set(this.styleId);
    localFilterStyle.style_name.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.styleName)));
    CSDataHighwayHead.ImageFilterRequest localImageFilterRequest = new CSDataHighwayHead.ImageFilterRequest();
    String str = this.app.getCurrentAccountUin() + this.styleId + this.styleName + this.mFileName + SystemClock.uptimeMillis();
    localImageFilterRequest.session_id.set(ByteStringMicro.copyFromUtf8(str));
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "SendFilterFilter sessionId:" + str);
    }
    localImageFilterRequest.uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
    localImageFilterRequest.style.set(localFilterStyle);
    localImageFilterRequest.width.set(this.mWidth);
    localImageFilterRequest.height.set(this.mHeight);
    ((CSDataHighwayHead.FilterExtendinfo)localObject2).msg_image_filter_request.set(localImageFilterRequest);
    localC2CCommonExtendinfo.msg_filter_extendinfo.set((MessageMicro)localObject2);
    localObject2 = localC2CCommonExtendinfo.toByteArray();
    localObject1 = new RequestFilter(String.valueOf(this.app.getCurrentAccountUin()), 1, this.mUkey.getBytes(), 15000L, (IRequestCallback)localObject1, (byte[])localObject2, null, 0);
    this.app.getHwEngine().SubmitAckRequest((RequestAck)localObject1);
    this.startFilterTime = SystemClock.uptimeMillis();
    this.currentStep = 3;
  }
  
  public void sendRequest()
  {
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.selfUin = this.app.getCurrentAccountUin();
    localPicUpReq.peerUin = this.mUiRequest.mPeerUin;
    localPicUpReq.secondUin = "";
    localPicUpReq.uinType = this.mUiRequest.mUinType;
    localPicUpReq.fileName = this.mFileName;
    localPicUpReq.fileSize = this.mFileSize;
    localPicUpReq.md5 = this.mLocalMd5;
    localPicUpReq.width = this.mWidth;
    localPicUpReq.height = this.mHeight;
    if (this.mUiRequest.mUinType == 1006) {}
    for (boolean bool = true;; bool = false)
    {
      localPicUpReq.isContact = bool;
      localPicUpReq.isRaw = this.mIsRawPic;
      localRichProtoReq.callback = this;
      localRichProtoReq.protoKey = "art_filter_up";
      localRichProtoReq.reqs.add(localPicUpReq);
      localRichProtoReq.protoReqMgr = this.app.getProtoReqManager();
      this.app.getHwEngine().preConnect();
      this.mStepUrl.logStartTime();
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "sendTransferRequest:" + localRichProtoReq);
      }
      this.startRequestTime = SystemClock.uptimeMillis();
      this.currentStep = 1;
      this.mRichProtoReq = localRichProtoReq;
      RichProtoProc.procRichProtoReq(localRichProtoReq);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ArtFilterUploadProcessor
 * JD-Core Version:    0.7.0.1
 */