package com.tencent.mobileqq.mini.share;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;

public class MiniArkShareAsyncTransProcessorHandler
  extends TransProcessorHandler
{
  private static final String TAG = "MiniArkShareImageTransP";
  private final IMiniCallback cmdCallback;
  
  public MiniArkShareAsyncTransProcessorHandler(Looper paramLooper, IMiniCallback paramIMiniCallback)
  {
    super(paramLooper);
    this.cmdCallback = paramIMiniCallback;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject1 = (FileMsg)paramMessage.obj;
    if ((localObject1 != null) && (((FileMsg)localObject1).commandId == 62))
    {
      if (((FileMsg)localObject1).fileType != 24) {
        return;
      }
      if ((paramMessage.what != 1007) && (paramMessage.what != 1003))
      {
        if (paramMessage.what == 1005)
        {
          QLog.e("MiniArkShareImageTransP", 2, "handleMessage send error");
          paramMessage = this.cmdCallback;
          if (paramMessage != null) {
            try
            {
              paramMessage.onCallbackResult(false, new Bundle());
            }
            catch (Throwable paramMessage)
            {
              paramMessage.printStackTrace();
            }
          }
          paramMessage = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramMessage instanceof QQAppInterface)) {
            ((ITransFileController)((QQAppInterface)paramMessage).getRuntimeService(ITransFileController.class)).removeHandle(this);
          }
        }
      }
      else
      {
        Object localObject2 = new Bdh_extinfo.UploadPicExtInfo();
        try
        {
          ((Bdh_extinfo.UploadPicExtInfo)localObject2).mergeFrom(((FileMsg)localObject1).bdhExtendInfo);
          paramMessage = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_file_resid.get().toStringUtf8();
          localObject1 = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_download_url.get().toStringUtf8();
          localObject2 = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_thumb_download_url.get().toStringUtf8();
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("handleMessage ");
          ((StringBuilder)localObject3).append(paramMessage);
          ((StringBuilder)localObject3).append(" ");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(" ");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.d("MiniArkShareImageTransP", 2, ((StringBuilder)localObject3).toString());
          if (this.cmdCallback != null)
          {
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("imageUUID", paramMessage);
            ((Bundle)localObject3).putString("imageUrl", (String)localObject1);
            ((Bundle)localObject3).putString("imageThumbUrl", (String)localObject2);
            try
            {
              this.cmdCallback.onCallbackResult(true, (Bundle)localObject3);
            }
            catch (Throwable paramMessage)
            {
              paramMessage.printStackTrace();
            }
          }
          paramMessage = BaseApplicationImpl.getApplication().getRuntime();
        }
        catch (InvalidProtocolBufferMicroException paramMessage)
        {
          QLog.d("MiniArkShareImageTransP", 2, "handleMessage ", paramMessage);
          paramMessage = this.cmdCallback;
          if (paramMessage != null) {
            try
            {
              paramMessage.onCallbackResult(false, new Bundle());
            }
            catch (Throwable paramMessage)
            {
              QLog.d("MiniArkShareImageTransP", 2, "handleMessage ", paramMessage);
            }
          }
        }
        if ((paramMessage instanceof QQAppInterface)) {
          ((ITransFileController)((QQAppInterface)paramMessage).getRuntimeService(ITransFileController.class)).removeHandle(this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncTransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */