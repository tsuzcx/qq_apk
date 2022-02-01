package com.tencent.mobileqq.gallery.picocr;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

class PicOcrManager$1
  extends TransProcessorHandler
{
  PicOcrManager$1(PicOcrManager paramPicOcrManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((localFileMsg == null) || (localFileMsg.commandId != 76)) {}
    do
    {
      String str;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                switch (paramMessage.what)
                {
                case 1002: 
                case 1006: 
                case 1007: 
                default: 
                  return;
                }
              } while (!QLog.isColorLevel());
              QLog.i("PicOcrManager", 2, "handleMessage start!");
              return;
            } while (!QLog.isColorLevel());
            QLog.d("PicOcrManager", 2, "handleMessage success resId:" + localFileMsg.serverPath);
            return;
            Bdh_extinfo.CommFileExtRsp localCommFileExtRsp = new Bdh_extinfo.CommFileExtRsp();
            str = "";
            paramMessage = str;
            if (localFileMsg.bdhExtendInfo != null) {}
            try
            {
              localCommFileExtRsp.mergeFrom(localFileMsg.bdhExtendInfo);
              paramMessage = str;
              if (localCommFileExtRsp.bytes_download_url.has()) {
                paramMessage = localCommFileExtRsp.bytes_download_url.get().toStringUtf8();
              }
            }
            catch (Exception paramMessage)
            {
              for (;;)
              {
                QLog.i("PicOcrManager", 2, "extRsp.mergeFrom(file.bdhExtendInfo) failed!");
                paramMessage = str;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("PicOcrManager", 2, "handleMessage finished resId:" + localFileMsg.serverPath + ", url:" + paramMessage);
            }
          } while (TextUtils.isEmpty(paramMessage));
          PicOcrManager.a(this.a).f = paramMessage;
          paramMessage = (PicOcrHandler)PicOcrManager.a(this.a).getBusinessHandler(BusinessHandlerFactory.PIC_NEW_OCR_HANDLER);
        } while (paramMessage == null);
        paramMessage.a(PicOcrManager.a(this.a).f, PicOcrManager.a(this.a).jdField_b_of_type_Long, PicOcrManager.a(this.a).d, PicOcrManager.a(this.a).e, PicOcrManager.a(this.a).jdField_a_of_type_Int, (int)PicOcrManager.a(this.a).jdField_a_of_type_Long, PicOcrManager.a(this.a).jdField_b_of_type_Int, PicOcrManager.a(this.a).c, PicOcrManager.a(this.a).jdField_a_of_type_Boolean, PicOcrManager.a(this.a).jdField_a_of_type_JavaLangString);
        return;
      } while (!QLog.isColorLevel());
      QLog.d("PicOcrManager", 2, "handleMessage upload error:" + localFileMsg.serverPath);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("PicOcrManager", 2, "handleMessage upload cancel:" + localFileMsg.serverPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gallery.picocr.PicOcrManager.1
 * JD-Core Version:    0.7.0.1
 */