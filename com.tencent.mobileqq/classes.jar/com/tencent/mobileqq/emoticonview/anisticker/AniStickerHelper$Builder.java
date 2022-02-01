package com.tencent.mobileqq.emoticonview.anisticker;

import android.support.annotation.DrawableRes;
import com.tencent.mobileqq.data.AniStickerInfo;
import org.jetbrains.annotations.NotNull;

public final class AniStickerHelper$Builder
{
  AniStickerAnimationListener listener;
  int localId;
  AniStickerLottieView lottieView;
  @DrawableRes
  int placeholderDrawable;
  boolean randomAniSticker;
  String randomKey;
  String resultId;
  public boolean showLastFrame;
  boolean showLoading = true;
  AniStickerInfo stickerInfo;
  String surpriseId;
  String svgLocalPath;
  public int viewHeight = AniStickerHelper.LOTTIE_ANIM_SIZE;
  public int viewWidth = AniStickerHelper.LOTTIE_ANIM_SIZE;
  
  public AniStickerHelper$Builder(@NotNull AniStickerLottieView paramAniStickerLottieView)
  {
    this.lottieView = paramAniStickerLottieView;
  }
  
  public Builder build()
  {
    return this;
  }
  
  public Builder height(int paramInt)
  {
    this.viewHeight = paramInt;
    return this;
  }
  
  public Builder listener(AniStickerAnimationListener paramAniStickerAnimationListener)
  {
    this.listener = paramAniStickerAnimationListener;
    return this;
  }
  
  public Builder localId(int paramInt)
  {
    this.localId = paramInt;
    return this;
  }
  
  public Builder placeholderDrawable(@DrawableRes int paramInt)
  {
    this.placeholderDrawable = paramInt;
    return this;
  }
  
  public Builder randomAniSticker(boolean paramBoolean)
  {
    this.randomAniSticker = paramBoolean;
    return this;
  }
  
  public Builder randomKey(String paramString)
  {
    this.randomKey = paramString;
    return this;
  }
  
  public Builder resultId(String paramString)
  {
    this.resultId = paramString;
    return this;
  }
  
  public Builder showLastFrame(boolean paramBoolean)
  {
    this.showLastFrame = paramBoolean;
    return this;
  }
  
  public Builder showLoading(boolean paramBoolean)
  {
    this.showLoading = paramBoolean;
    return this;
  }
  
  public Builder stickerInfo(AniStickerInfo paramAniStickerInfo)
  {
    this.stickerInfo = paramAniStickerInfo;
    return this;
  }
  
  public Builder surpriseId(String paramString)
  {
    this.surpriseId = paramString;
    return this;
  }
  
  public Builder svgLocalPath(String paramString)
  {
    this.svgLocalPath = paramString;
    return this;
  }
  
  public Builder width(int paramInt)
  {
    this.viewWidth = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.Builder
 * JD-Core Version:    0.7.0.1
 */