package com.tencent.mobileqq.videoplatform.util;

import com.tencent.mobileqq.videoplatform.api.IRegisterTVideo;
import com.tencent.mobileqq.videoplatform.imp.RegisterTVideoImp;

public class RegisterTVideoUtil
{
  private static IRegisterTVideo sRegisterTVideo = new RegisterTVideoImp();
  
  public static void registerTVideo()
  {
    sRegisterTVideo.registerTVideo();
  }
  
  public static void setRegisterTVideoImp(IRegisterTVideo paramIRegisterTVideo)
  {
    sRegisterTVideo = paramIRegisterTVideo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.util.RegisterTVideoUtil
 * JD-Core Version:    0.7.0.1
 */