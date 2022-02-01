package com.tencent.mobileqq.emoticonview;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class AniStickerLottieProcessor
  extends IQConfigProcessor<AniStickerLottieProcessor.LottieEmoSwitchData>
{
  private static final int CONFIG_ID = 761;
  private static final String KEY = "lottieEmoSwitch";
  private static final String TAG = "AniStickerLottieProcessor";
  
  public static boolean isLottieAvailable()
  {
    AniStickerLottieProcessor.LottieEmoSwitchData localLottieEmoSwitchData = (AniStickerLottieProcessor.LottieEmoSwitchData)QConfigManager.b().b(761);
    if (localLottieEmoSwitchData != null) {
      return localLottieEmoSwitchData.isLottieAvailable();
    }
    return false;
  }
  
  public Class<AniStickerLottieProcessor.LottieEmoSwitchData> clazz()
  {
    return AniStickerLottieProcessor.LottieEmoSwitchData.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  @NonNull
  public AniStickerLottieProcessor.LottieEmoSwitchData migrateOldOrDefaultContent(int paramInt)
  {
    return new AniStickerLottieProcessor.LottieEmoSwitchData();
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  @Nullable
  public AniStickerLottieProcessor.LottieEmoSwitchData onParsed(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0];
      paramArrayOfQConfItem = new AniStickerLottieProcessor.LottieEmoSwitchData(paramArrayOfQConfItem.a, paramArrayOfQConfItem.b);
      paramArrayOfQConfItem.parse();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed. data:");
        localStringBuilder.append(paramArrayOfQConfItem.toStr());
        QLog.d("AniStickerLottieProcessor", 2, localStringBuilder.toString());
      }
      return paramArrayOfQConfItem;
    }
    return null;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed failCode=");
      localStringBuilder.append(paramInt);
      QLog.d("AniStickerLottieProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public void onUpdate(AniStickerLottieProcessor.LottieEmoSwitchData paramLottieEmoSwitchData)
  {
    if (paramLottieEmoSwitchData != null) {
      paramLottieEmoSwitchData.parse();
    }
  }
  
  public int type()
  {
    return 761;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.AniStickerLottieProcessor
 * JD-Core Version:    0.7.0.1
 */