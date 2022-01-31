package com.tencent.mobileqq.doutu;

import android.content.Intent;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.utils.HexUtil;

public class DoutuUtils
{
  public static void a(Intent paramIntent, PicUploadInfo paramPicUploadInfo)
  {
    paramPicUploadInfo.l = paramIntent.getStringExtra("doutuBigMd5");
    paramPicUploadInfo.e = paramIntent.getLongExtra("doutuBigFileSize", 0L);
    paramPicUploadInfo.m = paramIntent.getStringExtra("doutuThumbMD5");
    paramPicUploadInfo.n = paramIntent.getStringExtra("doutuSupplierName");
  }
  
  public static void a(MessageRecord paramMessageRecord, PicUploadInfo paramPicUploadInfo)
  {
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_md5", paramPicUploadInfo.l);
    paramMessageRecord.saveExtInfoToExtStr("doutu_big_file_size", String.valueOf(paramPicUploadInfo.e));
    paramMessageRecord.saveExtInfoToExtStr("doutu_thumb_md5", String.valueOf(paramPicUploadInfo.m));
    paramMessageRecord.saveExtInfoToExtStr("doutu_supplier_name", paramPicUploadInfo.n);
  }
  
  public static void a(MessageRecord paramMessageRecord, TransferRequest paramTransferRequest)
  {
    PicMessageExtraData localPicMessageExtraData = new PicMessageExtraData();
    localPicMessageExtraData.imageBizType = 3;
    localPicMessageExtraData.doutuSupplier = paramMessageRecord.getExtInfoFromExtStr("doutu_supplier_name");
    if ((paramMessageRecord instanceof MessageForPic)) {
      ((MessageForPic)paramMessageRecord).picExtraData = localPicMessageExtraData;
    }
    long l = Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("doutu_big_file_size")).longValue();
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("doutu_big_md5");
    if ((l > 0L) && (paramMessageRecord != null) && (paramMessageRecord.length() > 0))
    {
      paramTransferRequest.q = true;
      paramTransferRequest.g = l;
      paramTransferRequest.o = paramMessageRecord;
    }
  }
  
  public static void a(TransferRequest paramTransferRequest, RichProto.RichProtoReq.PicUpReq paramPicUpReq)
  {
    if (paramTransferRequest.q)
    {
      paramPicUpReq.jdField_a_of_type_Long = paramTransferRequest.g;
      if (paramTransferRequest.o != null) {
        paramPicUpReq.jdField_a_of_type_ArrayOfByte = HexUtil.a(paramTransferRequest.o);
      }
      paramPicUpReq.e = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuUtils
 * JD-Core Version:    0.7.0.1
 */