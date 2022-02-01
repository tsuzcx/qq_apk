package com.tencent.mobileqq.mini.utils;

import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;

public class ReportLogUtil$MiniAppTransHandler
  extends TransProcessorHandler
{
  ReportLogUtil.UploadLogListener uploadLogListener;
  
  public ReportLogUtil$MiniAppTransHandler(Looper paramLooper, ReportLogUtil.UploadLogListener paramUploadLogListener)
  {
    super(paramLooper);
    this.uploadLogListener = paramUploadLogListener;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject = (FileMsg)paramMessage.obj;
    if ((localObject != null) && (((FileMsg)localObject).commandId == 65))
    {
      if (((FileMsg)localObject).fileType != 24) {
        return;
      }
      if ((paramMessage.what != 1007) && (paramMessage.what != 1003))
      {
        if (paramMessage.what == 1005)
        {
          QLog.d("BDH", 2, "handleMessage  STATUS_SEND_ERROR");
          paramMessage = this.uploadLogListener;
          if (paramMessage != null) {
            paramMessage.onFail("send error, code:1005");
          }
        }
        else
        {
          if (paramMessage.what == 1001)
          {
            QLog.d("BDH", 2, "handleMessage  STATUS_SEND_START");
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleMessage  unkown:");
          ((StringBuilder)localObject).append(paramMessage.what);
          QLog.d("BDH", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        QLog.d("BDH", 2, "handleMessage  STATUS_UPLOAD_FINISHED");
        paramMessage = new Bdh_extinfo.UploadPicExtInfo();
        try
        {
          paramMessage.mergeFrom(((FileMsg)localObject).bdhExtendInfo);
          paramMessage = paramMessage.bytes_download_url.get().toStringUtf8();
          if (this.uploadLogListener != null) {
            this.uploadLogListener.onSuccess(paramMessage);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleMessage :");
          ((StringBuilder)localObject).append(paramMessage);
          QLog.d("BDH", 2, ((StringBuilder)localObject).toString());
          return;
        }
        catch (Exception paramMessage)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleMessage ");
          ((StringBuilder)localObject).append(paramMessage);
          QLog.d("BDH", 2, ((StringBuilder)localObject).toString());
          localObject = this.uploadLogListener;
          if (localObject != null) {
            ((ReportLogUtil.UploadLogListener)localObject).onFail(paramMessage.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ReportLogUtil.MiniAppTransHandler
 * JD-Core Version:    0.7.0.1
 */