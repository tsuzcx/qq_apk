package com.tencent.mobileqq.mini.share;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import ayqm;
import ayvv;
import ayvz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;

public class MiniArkShareAsyncTransProcessorHandler
  extends ayvz
{
  private static final String TAG = "MiniArkShareImageTransP";
  private final CmdCallback cmdCallback;
  
  public MiniArkShareAsyncTransProcessorHandler(Looper paramLooper, CmdCallback paramCmdCallback)
  {
    super(paramLooper);
    this.cmdCallback = paramCmdCallback;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject1 = (ayqm)paramMessage.obj;
    if ((localObject1 == null) || (((ayqm)localObject1).c != 62) || (((ayqm)localObject1).b != 24)) {}
    for (;;)
    {
      return;
      if ((paramMessage.what == 1007) || (paramMessage.what == 1003))
      {
        Object localObject2 = new Bdh_extinfo.UploadPicExtInfo();
        try
        {
          ((Bdh_extinfo.UploadPicExtInfo)localObject2).mergeFrom(((ayqm)localObject1).a);
          paramMessage = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_file_resid.get().toStringUtf8();
          localObject1 = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_download_url.get().toStringUtf8();
          localObject2 = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_thumb_download_url.get().toStringUtf8();
          QLog.d("MiniArkShareImageTransP", 2, "handleMessage " + paramMessage + " " + (String)localObject1 + " " + (String)localObject2);
          if (this.cmdCallback != null)
          {
            localBundle = new Bundle();
            localBundle.putString("imageUUID", paramMessage);
            localBundle.putString("imageUrl", (String)localObject1);
            localBundle.putString("imageThumbUrl", (String)localObject2);
          }
        }
        catch (InvalidProtocolBufferMicroException paramMessage)
        {
          for (;;)
          {
            Bundle localBundle;
            label201:
            QLog.d("MiniArkShareImageTransP", 2, "handleMessage ", paramMessage);
            if (this.cmdCallback != null) {
              try
              {
                this.cmdCallback.onCmdResult(false, new Bundle());
              }
              catch (RemoteException paramMessage)
              {
                QLog.d("MiniArkShareImageTransP", 2, "handleMessage ", paramMessage);
              }
            }
          }
        }
        try
        {
          this.cmdCallback.onCmdResult(true, localBundle);
          paramMessage = BaseApplicationImpl.getApplication().getRuntime();
          if (!(paramMessage instanceof QQAppInterface)) {
            continue;
          }
          ((QQAppInterface)paramMessage).a().b(this);
          return;
        }
        catch (RemoteException paramMessage)
        {
          paramMessage.printStackTrace();
          break label201;
        }
      }
      if (paramMessage.what != 1005) {
        continue;
      }
      QLog.e("MiniArkShareImageTransP", 2, "handleMessage send error");
      if (this.cmdCallback != null) {}
      try
      {
        this.cmdCallback.onCmdResult(false, new Bundle());
        paramMessage = BaseApplicationImpl.getApplication().getRuntime();
        if (!(paramMessage instanceof QQAppInterface)) {
          continue;
        }
        ((QQAppInterface)paramMessage).a().b(this);
        return;
      }
      catch (RemoteException paramMessage)
      {
        for (;;)
        {
          paramMessage.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncTransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */