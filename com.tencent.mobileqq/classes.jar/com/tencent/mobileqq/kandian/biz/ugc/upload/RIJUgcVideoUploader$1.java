package com.tencent.mobileqq.kandian.biz.ugc.upload;

import android.os.Message;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class RIJUgcVideoUploader$1
  extends TransProcessorHandler
{
  RIJUgcVideoUploader$1(RIJUgcVideoUploader paramRIJUgcVideoUploader) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (FileMsg)paramMessage.obj;
    if ((localObject != null) && (((FileMsg)localObject).fileType == 24))
    {
      if (((FileMsg)localObject).commandId != 54) {
        return;
      }
      if (RIJUgcVideoUploader.a(this.a) != null)
      {
        if (((FileMsg)localObject).uniseq != RIJUgcVideoUploader.a(this.a)) {
          return;
        }
        StringBuilder localStringBuilder;
        switch (paramMessage.what)
        {
        case 1004: 
        default: 
          return;
        case 1005: 
          paramMessage = new StringBuilder();
          paramMessage.append("mVideoTransProcessorHandler send error:");
          paramMessage.append(((FileMsg)localObject).errorCode);
          QLog.e("RIJUGC.RIJUgcVideoUploader", 1, paramMessage.toString());
          RIJUgcVideoUploader.a(this.a).a(((FileMsg)localObject).errorCode, "");
          RIJUgcVideoUploader.a(this.a);
          return;
        case 1003: 
          QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "mVideoTransProcessorHandler send finished!");
          paramMessage = new bigFileUpload.BigFileExtRsp();
          try
          {
            paramMessage.mergeFrom(((FileMsg)localObject).bdhExtendInfo);
            int i = paramMessage.int32_retcode.get();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("mVideoTransProcessorHandler rsp.errorCode:");
            localStringBuilder.append(i);
            QLog.d("RIJUGC.RIJUgcVideoUploader", 1, localStringBuilder.toString());
            if (i == 0)
            {
              if (paramMessage.bytes_download_url.has())
              {
                paramMessage = paramMessage.bytes_download_url.get().toStringUtf8();
                RIJUgcVideoUploader.a(this.a).a(paramMessage);
              }
              else
              {
                RIJUgcVideoUploader.a(this.a).a(-1, "not has download url");
              }
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("mVideoTransProcessorHandler rsp.error info:");
              localStringBuilder.append(paramMessage.bytes_msg.get().toStringUtf8());
              QLog.e("RIJUGC.RIJUgcVideoUploader", 1, localStringBuilder.toString());
              RIJUgcVideoUploader.a(this.a).a(((FileMsg)localObject).errorCode, paramMessage.bytes_msg.get().toStringUtf8());
            }
          }
          catch (Exception paramMessage)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("upload success but parse exception, e=");
            ((StringBuilder)localObject).append(QLog.getStackTraceString(paramMessage));
            QLog.e("RIJUGC.RIJUgcVideoUploader", 1, ((StringBuilder)localObject).toString());
          }
          RIJUgcVideoUploader.a(this.a);
          return;
        case 1002: 
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("mVideoTransProcessorHandler transfer=");
            paramMessage.append(((FileMsg)localObject).transferedSize);
            paramMessage.append(", total=");
            paramMessage.append(((FileMsg)localObject).fileSize);
            QLog.d("RIJUGC.RIJUgcVideoUploader", 2, paramMessage.toString());
          }
          RIJUgcVideoUploader.a(this.a).a(((FileMsg)localObject).transferedSize, ((FileMsg)localObject).fileSize);
          return;
        }
        paramMessage = new JSONObject();
        try
        {
          paramMessage.put("uniseq", RIJUgcVideoUploader.a(this.a));
          paramMessage.put("localPath", RIJUgcVideoUploader.a(this.a));
        }
        catch (Exception localException)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("uploadListener.onStart, e=");
          localStringBuilder.append(QLog.getStackTraceString(localException));
          QLog.e("RIJUGC.RIJUgcVideoUploader", 1, localStringBuilder.toString());
        }
        RIJUgcVideoUploader.a(this.a).a(paramMessage.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcVideoUploader.1
 * JD-Core Version:    0.7.0.1
 */