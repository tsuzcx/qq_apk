package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.StickerInfo;
import mqq.app.AppRuntime;

public abstract interface IPicEmoticonInfo
{
  public static final int DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR = Color.parseColor("#21d9c6");
  public static final int DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR = Color.parseColor("#ffffff");
  public static final String ORIGINAL_EMOTION_COUNT_SP_FILE_NAME = "originalEmotionCountSp_";
  public static final int ORIGINAL_EMOTION_REWORD_COUNT = 21;
  public static final int TYPE_GIF = 3;
  public static final int TYPE_PNG = 2;
  
  public abstract Drawable getAioPreviewDrawable();
  
  public abstract Drawable getBigDrawable(Context paramContext, float paramFloat);
  
  public abstract Drawable getDefault();
  
  public abstract Drawable getDrawable(Context paramContext, float paramFloat);
  
  public abstract Emoticon getEmoticon();
  
  public abstract Drawable getFailed();
  
  public abstract Drawable getFiveInchDefault();
  
  public abstract Drawable getFiveInchFailed();
  
  public abstract int getImageType();
  
  public abstract URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean);
  
  public abstract <T> URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT);
  
  public abstract <T> URLDrawable getLoadingDrawable(String paramString, boolean paramBoolean1, boolean paramBoolean2, T paramT, int paramInt1, int paramInt2);
  
  public abstract int getVoiceLength();
  
  public abstract int getWaveBackgroundColor();
  
  public abstract int getWaveForegroundColor();
  
  public abstract int[] getWaveformArray();
  
  public abstract boolean isAPNG();
  
  public abstract boolean isAioPreviewExists();
  
  public abstract boolean isBigImageExists();
  
  public abstract boolean isNewSoundType();
  
  public abstract boolean isSound();
  
  public abstract void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable);
  
  public abstract void send(AppRuntime paramAppRuntime, Context paramContext, EditText paramEditText, Parcelable paramParcelable, boolean paramBoolean, int paramInt);
  
  public abstract void setEmoticon(Emoticon paramEmoticon);
  
  public abstract void setStickerInfo(StickerInfo paramStickerInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */