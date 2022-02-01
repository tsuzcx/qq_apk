package com.tencent.mobileqq.identification;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqconnectface.api.IVideoService;
import mqq.app.AppRuntime;

public class FaceVideo
  implements IVideoService
{
  public boolean a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)paramAppRuntime).isUsingCameraOnVideo();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceVideo
 * JD-Core Version:    0.7.0.1
 */