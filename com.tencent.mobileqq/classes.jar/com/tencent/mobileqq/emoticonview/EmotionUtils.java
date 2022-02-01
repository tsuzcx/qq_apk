package com.tencent.mobileqq.emoticonview;

import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

public class EmotionUtils
{
  private static final String TAG = "EmotionUtils";
  
  public static void startSoundDrawablePlay(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      Object localObject = paramURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof GifDrawable)))
      {
        localObject = ((GifDrawable)localObject).getImage();
        if ((localObject != null) && ((localObject instanceof VoiceGifImage)))
        {
          localObject = (VoiceGifImage)localObject;
          ((VoiceGifImage)localObject).stop();
          ((VoiceGifImage)localObject).start();
          paramURLDrawable.invalidateSelf();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionUtils", 2, "soundgif startSoundDrawablePlay start");
          }
        }
        else if ((localObject != null) && ((localObject instanceof VoiceGifImageV2)))
        {
          localObject = (VoiceGifImageV2)localObject;
          ((VoiceGifImageV2)localObject).stop();
          ((VoiceGifImageV2)localObject).start();
          paramURLDrawable.invalidateSelf();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionUtils", 2, "soundgif startSoundDrawablePlay start");
          }
        }
      }
    }
  }
  
  public static void stopSoundDrawablePlay(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof GifDrawable)))
      {
        paramURLDrawable = ((GifDrawable)paramURLDrawable).getImage();
        if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VoiceGifImage)))
        {
          ((VoiceGifImage)paramURLDrawable).stop();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionUtils", 2, "soundgif stopSoundDrawablePlay stop");
          }
        }
        else if ((paramURLDrawable != null) && ((paramURLDrawable instanceof VoiceGifImageV2)))
        {
          ((VoiceGifImageV2)paramURLDrawable).stop();
          if (QLog.isColorLevel()) {
            QLog.d("EmotionUtils", 2, "soundgif stopSoundDrawablePlay stop");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionUtils
 * JD-Core Version:    0.7.0.1
 */