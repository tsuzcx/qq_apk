package com.tencent.mobileqq.ocr.api.impl;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

class PicOcrServiceImpl$1
  extends TransProcessorHandler
{
  PicOcrServiceImpl$1(PicOcrServiceImpl paramPicOcrServiceImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    Bdh_extinfo.CommFileExtRsp localCommFileExtRsp;
    Object localObject;
    if (localFileMsg != null)
    {
      if (localFileMsg.commandId != 76) {
        return;
      }
      int i = paramMessage.what;
      if (i != 1008) {}
      switch (i)
      {
      default: 
        return;
      case 1005: 
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage upload error:");
          paramMessage.append(localFileMsg.serverPath);
          QLog.d("PicOcrServiceImpl", 2, paramMessage.toString());
          return;
        }
        break;
      case 1004: 
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage upload cancel:");
          paramMessage.append(localFileMsg.serverPath);
          QLog.d("PicOcrServiceImpl", 2, paramMessage.toString());
          return;
        }
        break;
      case 1003: 
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("handleMessage success resId:");
          paramMessage.append(localFileMsg.serverPath);
          QLog.d("PicOcrServiceImpl", 2, paramMessage.toString());
          return;
        }
        break;
      case 1001: 
        if (QLog.isColorLevel())
        {
          QLog.i("PicOcrServiceImpl", 2, "handleMessage start!");
          return;
          localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
          localObject = "";
          paramMessage = (Message)localObject;
          if (localFileMsg.bdhExtendInfo == null) {
            break;
          }
        }
        break;
      }
    }
    try
    {
      localCommFileExtRsp.mergeFrom(localFileMsg.bdhExtendInfo);
      paramMessage = (Message)localObject;
      if (!localCommFileExtRsp.bytes_download_url.has()) {
        break label285;
      }
      paramMessage = localCommFileExtRsp.bytes_download_url.get().toStringUtf8();
    }
    catch (Exception paramMessage)
    {
      label275:
      label285:
      break label275;
    }
    QLog.i("PicOcrServiceImpl", 2, "extRsp.mergeFrom(file.bdhExtendInfo) failed!");
    paramMessage = (Message)localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMessage finished resId:");
      ((StringBuilder)localObject).append(localFileMsg.serverPath);
      ((StringBuilder)localObject).append(", url:");
      ((StringBuilder)localObject).append(paramMessage);
      QLog.d("PicOcrServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramMessage))
    {
      PicOcrServiceImpl.access$000(this.a).f = paramMessage;
      if (PicOcrServiceImpl.access$100(this.a) != null)
      {
        paramMessage = (PicOcrHandler)PicOcrServiceImpl.access$100(this.a).getBusinessHandler(PicOcrHandler.jdField_a_of_type_JavaLangString);
        if (paramMessage != null) {
          paramMessage.a(PicOcrServiceImpl.access$000(this.a).f, PicOcrServiceImpl.access$000(this.a).jdField_b_of_type_Long, PicOcrServiceImpl.access$000(this.a).d, PicOcrServiceImpl.access$000(this.a).e, PicOcrServiceImpl.access$000(this.a).jdField_a_of_type_Int, (int)PicOcrServiceImpl.access$000(this.a).jdField_a_of_type_Long, PicOcrServiceImpl.access$000(this.a).jdField_b_of_type_Int, PicOcrServiceImpl.access$000(this.a).c, PicOcrServiceImpl.access$000(this.a).jdField_a_of_type_Boolean, PicOcrServiceImpl.access$000(this.a).jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.PicOcrServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */