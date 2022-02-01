package com.tencent.mobileqq.emoticonview;

import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class VoiceGifFactory
{
  public static final String TAG = "VoiceGifFactory";
  
  public static AbstractGifImage getVoiceGifObject(File paramFile, int paramInt, boolean paramBoolean)
  {
    try
    {
      if (NativeGifFactory.isUseNewGif()) {
        return new VoiceGifImageV2(paramFile, paramInt, paramBoolean);
      }
      paramFile = new VoiceGifImage(paramFile, paramInt, paramBoolean);
      return paramFile;
    }
    catch (IOException paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("VoiceGifFactory", 2, "getVoiceGifObject exception. msg:" + paramFile.getMessage());
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.VoiceGifFactory
 * JD-Core Version:    0.7.0.1
 */