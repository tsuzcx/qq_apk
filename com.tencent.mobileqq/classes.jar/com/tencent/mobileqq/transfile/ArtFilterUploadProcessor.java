package com.tencent.mobileqq.transfile;

import aiom;
import aion;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.biz.qqstory.takevideo.EditVideoArtFilter;
import com.tencent.biz.qqstory.takevideo.artfilter.ArtFilterModule;
import com.tencent.biz.qqstory.takevideo.artfilter.FilterUploadInfo;
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

public class ArtFilterUploadProcessor
  extends BaseUploadProcessor
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  public ArtFilterModule a;
  public FilterUploadInfo a;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  long jdField_b_of_type_Long = 0L;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  public int c;
  public long c;
  public long d;
  long e = 0L;
  public long f = 0L;
  long g;
  long h = 0L;
  long i = 0L;
  long j = 0L;
  private int w;
  
  public ArtFilterUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest, String paramString)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterModule = ArtFilterModule.a();
    this.jdField_l_of_type_JavaLangString = paramString;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "cancelTask taskId:" + this.jdField_c_of_type_Int + " mRichProtoReq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq + " mTrans:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction + " mNetReq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
    {
      RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.cancelTransaction();
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
    }
    return 0;
  }
  
  public void a()
  {
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localPicUpReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localPicUpReq.e = "";
    localPicUpReq.f = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localPicUpReq.jdField_a_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    localPicUpReq.jdField_a_of_type_Long = this.q;
    localPicUpReq.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    localPicUpReq.jdField_c_of_type_Int = this.o;
    localPicUpReq.jdField_d_of_type_Int = this.p;
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int == 1006) {}
    for (boolean bool = true;; bool = false)
    {
      localPicUpReq.jdField_c_of_type_Boolean = bool;
      localPicUpReq.jdField_b_of_type_Boolean = this.jdField_l_of_type_Boolean;
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "art_filter_up";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localPicUpReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getProtoReqManager();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().preConnect();
      this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "sendTransferRequest:" + localRichProtoReq);
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
      RichProtoProc.a(localRichProtoReq);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, FilterUploadInfo paramFilterUploadInfo, boolean paramBoolean)
  {
    this.w = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterFilterUploadInfo = paramFilterUploadInfo;
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "FilterUploadInfo:" + paramFilterUploadInfo);
    }
    if (paramFilterUploadInfo == null) {
      return;
    }
    this.q = paramFilterUploadInfo.jdField_a_of_type_Long;
    this.jdField_a_of_type_ArrayOfByte = paramFilterUploadInfo.jdField_a_of_type_ArrayOfByte;
    this.jdField_d_of_type_JavaLangString = paramFilterUploadInfo.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = (EditVideoArtFilter.jdField_a_of_type_JavaLangString + paramFilterUploadInfo.jdField_b_of_type_Long + "_" + paramInt2 + ".png");
    this.p = paramFilterUploadInfo.jdField_a_of_type_Int;
    this.o = paramFilterUploadInfo.jdField_b_of_type_Int;
    this.i = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "start()  needUploadImg:" + paramBoolean + " mUky:" + this.jdField_l_of_type_JavaLangString);
    }
    if ((!paramBoolean) && (this.jdField_l_of_type_JavaLangString != null))
    {
      ao_();
      return;
    }
    a();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    boolean bool;
    Object localObject;
    if (paramInt == 0)
    {
      bool = true;
      this.j = SystemClock.uptimeMillis();
      localObject = new Bundle();
      ((Bundle)localObject).putInt("param_art_filter_task_id", this.jdField_c_of_type_Int);
      ((Bundle)localObject).putInt("param_art_filter_task_result", paramInt);
      ((Bundle)localObject).putInt("param_art_filter_style_id", this.jdField_b_of_type_Int);
      ((Bundle)localObject).putString("param_art_filter_resource_path", this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterFilterUploadInfo.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject).putString("param_art_filter_output_path", this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "ReturnFilterResult  callbackId:" + this.w + " taskId:" + this.jdField_b_of_type_Int + " styleId:" + this.jdField_c_of_type_Int + " errorCode:" + paramInt + " errorFrom:" + paramString + " bundle:" + localObject);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterModule.callbackResult(this.w, EIPCResult.createSuccessResult((Bundle)localObject));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterModule.jdField_a_of_type_AndroidUtilSparseArray.remove(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_JavaUtilHashMap.put("uploadFileSize", String.valueOf(this.q));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(paramInt));
      this.jdField_a_of_type_JavaUtilHashMap.put("step", String.valueOf(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("filterId", String.valueOf(this.jdField_b_of_type_Int));
      localObject = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_b_of_type_Boolean != true) {
        break label587;
      }
    }
    label587:
    for (paramString = "1";; paramString = "0")
    {
      ((HashMap)localObject).put("isuploadOriginalPic", paramString);
      long l1 = 0L;
      long l2 = 0L;
      long l3 = 0L;
      long l4 = 0L;
      if (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long) {
        l1 = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long;
      }
      if (this.jdField_d_of_type_Long > this.jdField_c_of_type_Long) {
        l2 = this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
      }
      if (this.f > this.e) {
        l3 = this.f - this.e;
      }
      if (this.h > this.jdField_g_of_type_Long) {
        l4 = this.h - this.jdField_g_of_type_Long;
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("wup_Costtime", String.valueOf(l1));
      this.jdField_a_of_type_JavaUtilHashMap.put("original_Costtime", String.valueOf(l2));
      this.jdField_a_of_type_JavaUtilHashMap.put("filter_Costtime", String.valueOf(l3));
      this.jdField_a_of_type_JavaUtilHashMap.put("download_Costtime", String.valueOf(l4));
      if (!QLog.isColorLevel()) {
        break label604;
      }
      paramString = new StringBuilder();
      localObject = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (this.jdField_a_of_type_JavaUtilHashMap.get(str) != null)
        {
          paramString.append("&");
          paramString.append(str);
          paramString.append("=");
          paramString.append((String)this.jdField_a_of_type_JavaUtilHashMap.get(str));
        }
      }
      bool = false;
      break;
    }
    QLog.d("ArtFilterUploadProcessor", 2, paramString.toString());
    label604:
    StatisticCollector.a(BaseApplication.getContext()).a(null, "afCosttimeAndFlowReport", bool, this.j - this.i, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
  }
  
  public void a(NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    super.a(paramNetResp);
    this.h = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "getDownLoadResponse: " + paramNetResp);
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("downloadFileSize", String.valueOf(paramNetResp.jdField_a_of_type_Long));
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int = 5;
      a(0, null);
      return;
    }
    if (paramNetResp.jdField_a_of_type_JavaLangString != null) {
      QLog.d("ArtFilterUploadProcessor", 1, "download dailed, mErrCode" + paramNetResp.jdField_b_of_type_Int + "mErrDesc:" + paramNetResp.jdField_a_of_type_JavaLangString);
    }
    a(paramNetResp.jdField_b_of_type_Int, paramNetResp.jdField_a_of_type_JavaLangString);
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    } while (paramRichProtoResp == null);
    int k = 0;
    label26:
    if (k < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
    {
      paramRichProtoReq = (RichProto.RichProtoResp.C2CPicUpResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(k);
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "getTransferResp:" + paramRichProtoReq);
      }
      if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
        break label142;
      }
      this.jdField_l_of_type_JavaLangString = paramRichProtoReq.jdField_c_of_type_JavaLangString;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterModule.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterFilterUploadInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterArtFilterModule.jdField_a_of_type_JavaLangString = paramRichProtoReq.jdField_c_of_type_JavaLangString;
        an_();
      }
    }
    for (;;)
    {
      k += 1;
      break label26;
      break;
      label142:
      a(paramRichProtoReq.jdField_c_of_type_Int, "getTransferError");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public final void an_()
  {
    if (this.jdField_a_of_type_Boolean) {}
    int k;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "ArtFilterUploadProcessor.sendFile()");
      }
      aiom localaiom = new aiom(this);
      byte[] arrayOfByte = HexUtil.a(this.jdField_l_of_type_JavaLangString);
      Object localObject = new CSDataHighwayHead.FilterExtendinfo();
      ((CSDataHighwayHead.FilterExtendinfo)localObject).uint32_filter_flag.set(1);
      CSDataHighwayHead.C2CCommonExtendinfo localC2CCommonExtendinfo = new CSDataHighwayHead.C2CCommonExtendinfo();
      localC2CCommonExtendinfo.uint32_info_id.set(1);
      localC2CCommonExtendinfo.msg_filter_extendinfo.set((MessageMicro)localObject);
      localObject = localC2CCommonExtendinfo.toByteArray();
      this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 1, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterFilterUploadInfo.jdField_a_of_type_JavaLangString, (int)this.r, arrayOfByte, this.jdField_a_of_type_ArrayOfByte, localaiom, (byte[])localObject);
      k = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction);
      this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        QLog.d("ArtFilterUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + k + " T_ID:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " MD5:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoArtfilterFilterUploadInfo.jdField_a_of_type_ArrayOfByte + " uuid:" + this.jdField_g_of_type_JavaLangString + " Path:" + this.jdField_b_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath);
      }
    } while (k == 0);
    a(k, "submit transaction error");
  }
  
  public void ao_()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject1 = new aion(this);
    Object localObject2 = new CSDataHighwayHead.FilterExtendinfo();
    ((CSDataHighwayHead.FilterExtendinfo)localObject2).uint32_filter_flag.set(2);
    CSDataHighwayHead.C2CCommonExtendinfo localC2CCommonExtendinfo = new CSDataHighwayHead.C2CCommonExtendinfo();
    localC2CCommonExtendinfo.uint32_info_id.set(1);
    CSDataHighwayHead.FilterStyle localFilterStyle = new CSDataHighwayHead.FilterStyle();
    localFilterStyle.style_id.set(this.jdField_b_of_type_Int);
    localFilterStyle.style_name.set(ByteStringMicro.copyFrom(HexUtil.a(this.jdField_b_of_type_JavaLangString)));
    CSDataHighwayHead.ImageFilterRequest localImageFilterRequest = new CSDataHighwayHead.ImageFilterRequest();
    String str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin() + this.jdField_b_of_type_Int + this.jdField_b_of_type_JavaLangString + this.jdField_d_of_type_JavaLangString + SystemClock.uptimeMillis();
    localImageFilterRequest.session_id.set(ByteStringMicro.copyFromUtf8(str));
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "SendFilterFilter sessionId:" + str);
    }
    localImageFilterRequest.uin.set(Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()).longValue());
    localImageFilterRequest.style.set(localFilterStyle);
    localImageFilterRequest.width.set(this.o);
    localImageFilterRequest.height.set(this.p);
    ((CSDataHighwayHead.FilterExtendinfo)localObject2).msg_image_filter_request.set(localImageFilterRequest);
    localC2CCommonExtendinfo.msg_filter_extendinfo.set((MessageMicro)localObject2);
    localObject2 = localC2CCommonExtendinfo.toByteArray();
    localObject1 = new RequestFilter(String.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()), 1, this.jdField_l_of_type_JavaLangString.getBytes(), 15000L, (IRequestCallback)localObject1, (byte[])localObject2, null, 0);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().SubmitAckRequest((RequestAck)localObject1);
    this.e = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Int = 3;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramString;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_Boolean = true;
    localHttpNetReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localHttpNetReq.e = 0;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    if (QLog.isColorLevel()) {
      QLog.d("ArtFilterUploadProcessor", 2, "sendDownLoadRequest req:" + localHttpNetReq);
    }
    this.jdField_g_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Int = 4;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ArtFilterUploadProcessor
 * JD-Core Version:    0.7.0.1
 */