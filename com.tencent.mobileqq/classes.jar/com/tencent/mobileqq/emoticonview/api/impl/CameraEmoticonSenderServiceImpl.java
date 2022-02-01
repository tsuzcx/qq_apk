package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.ICameraEmoticonSenderService;
import com.tencent.mobileqq.emoticonview.sender.CameraEmoticonInfoSender;
import mqq.app.AppRuntime;

public class CameraEmoticonSenderServiceImpl
  implements ICameraEmoticonSenderService
{
  public void send(CameraEmoticonInfo paramCameraEmoticonInfo, AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable)
  {
    CameraEmoticonInfoSender.send(paramCameraEmoticonInfo, paramAppRuntime, paramContext, paramEditText, paramParcelable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.impl.CameraEmoticonSenderServiceImpl
 * JD-Core Version:    0.7.0.1
 */