package com.tencent.mobileqq.emoticonview;

import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

public class EmotionUtils
{
  private static final String TAG = "EmotionUtils";
  
  public static void startSoundDrawablePlay(URLDrawable paramURLDrawable)
  {
    Object localObject;
    if (paramURLDrawable != null)
    {
      localObject = paramURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof GifDrawable)))
      {
        localObject = ((GifDrawable)localObject).getImage();
        if ((localObject == null) || (!(localObject instanceof VoiceGifImage))) {
          break label72;
        }
        ((VoiceGifImage)localObject).stop();
        ((VoiceGifImage)localObject).start();
        paramURLDrawable.invalidateSelf();
        if (QLog.isColorLevel()) {
          QLog.d("EmotionUtils", 2, "soundgif startSoundDrawablePlay start");
        }
      }
    }
    label72:
    do
    {
      do
      {
        return;
      } while ((localObject == null) || (!(localObject instanceof VoiceGifImageV2)));
      ((VoiceGifImageV2)localObject).stop();
      ((VoiceGifImageV2)localObject).start();
      paramURLDrawable.invalidateSelf();
    } while (!QLog.isColorLevel());
    QLog.d("EmotionUtils", 2, "soundgif startSoundDrawablePlay start");
  }
  
  public static void stopSoundDrawablePlay(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof GifDrawable)))
      {
        paramURLDrawable = ((GifDrawable)paramURLDrawable).getImage();
        if ((paramURLDrawable == null) || (!(paramURLDrawable instanceof VoiceGifImage))) {
          break label61;
        }
        ((VoiceGifImage)paramURLDrawable).stop();
        if (QLog.isColorLevel()) {
          QLog.d("EmotionUtils", 2, "soundgif stopSoundDrawablePlay stop");
        }
      }
    }
    label61:
    do
    {
      do
      {
        return;
      } while ((paramURLDrawable == null) || (!(paramURLDrawable instanceof VoiceGifImageV2)));
      ((VoiceGifImageV2)paramURLDrawable).stop();
    } while (!QLog.isColorLevel());
    QLog.d("EmotionUtils", 2, "soundgif stopSoundDrawablePlay stop");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionUtils
 * JD-Core Version:    0.7.0.1
 */