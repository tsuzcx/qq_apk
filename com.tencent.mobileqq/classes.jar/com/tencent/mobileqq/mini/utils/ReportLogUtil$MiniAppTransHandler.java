package com.tencent.mobileqq.mini.utils;

import android.os.Looper;
import android.os.Message;
import axqf;
import axvs;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

public class ReportLogUtil$MiniAppTransHandler
  extends axvs
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
    axqf localaxqf = (axqf)paramMessage.obj;
    if ((localaxqf == null) || (localaxqf.c != 65) || (localaxqf.b != 24)) {}
    do
    {
      do
      {
        return;
        if ((paramMessage.what != 1007) && (paramMessage.what != 1003)) {
          break;
        }
        QLog.d("BDH", 2, "handleMessage  STATUS_UPLOAD_FINISHED");
        paramMessage = new Bdh_extinfo.UploadPicExtInfo();
        try
        {
          paramMessage.mergeFrom(localaxqf.a);
          paramMessage = paramMessage.bytes_download_url.get().toStringUtf8();
          if (this.uploadLogListener != null) {
            this.uploadLogListener.onSuccess(paramMessage);
          }
          QLog.d("BDH", 2, "handleMessage :" + paramMessage);
          return;
        }
        catch (Exception paramMessage)
        {
          QLog.d("BDH", 2, "handleMessage " + paramMessage);
        }
      } while (this.uploadLogListener == null);
      this.uploadLogListener.onFail(paramMessage.getMessage());
      return;
      if (paramMessage.what != 1005) {
        break;
      }
      QLog.d("BDH", 2, "handleMessage  STATUS_SEND_ERROR");
    } while (this.uploadLogListener == null);
    this.uploadLogListener.onFail("send error, code:1005");
    return;
    if (paramMessage.what == 1001)
    {
      QLog.d("BDH", 2, "handleMessage  STATUS_SEND_START");
      return;
    }
    QLog.d("BDH", 2, "handleMessage  unkown:" + paramMessage.what);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.ReportLogUtil.MiniAppTransHandler
 * JD-Core Version:    0.7.0.1
 */