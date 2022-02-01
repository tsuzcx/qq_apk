package com.tencent.thumbplayer.core.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import java.util.Arrays;

@TargetApi(21)
public final class TPAudioPassThroughCapabilities
{
  public static final TPAudioPassThroughCapabilities DEFAULT_AUDIO_CAPABILITIES = new TPAudioPassThroughCapabilities(new int[] { 2 }, 8);
  private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
  private static final TPAudioPassThroughCapabilities EXTERNAL_SURROUND_SOUND_CAPABILITIES = new TPAudioPassThroughCapabilities(new int[] { 2, 5, 6 }, 8);
  private static final String EXTERNAL_SURROUND_SOUND_KEY = "external_surround_sound_enabled";
  private final int maxChannelCount;
  private final int[] supportedEncodings;
  
  public TPAudioPassThroughCapabilities(@Nullable int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt != null)
    {
      this.supportedEncodings = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
      Arrays.sort(this.supportedEncodings);
    }
    for (;;)
    {
      this.maxChannelCount = paramInt;
      return;
      this.supportedEncodings = new int[0];
    }
  }
  
  public static TPAudioPassThroughCapabilities getCapabilities(Context paramContext)
  {
    return getCapabilities(paramContext, paramContext.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
  }
  
  @SuppressLint({"InlinedApi"})
  static TPAudioPassThroughCapabilities getCapabilities(Context paramContext, @Nullable Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0)) {
      return DEFAULT_AUDIO_CAPABILITIES;
    }
    return new TPAudioPassThroughCapabilities(paramIntent.getIntArrayExtra("android.media.extra.ENCODINGS"), paramIntent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof TPAudioPassThroughCapabilities)) {
        return false;
      }
      paramObject = (TPAudioPassThroughCapabilities)paramObject;
    } while ((Arrays.equals(this.supportedEncodings, paramObject.supportedEncodings)) && (this.maxChannelCount == paramObject.maxChannelCount));
    return false;
  }
  
  public int getMaxChannelCount()
  {
    return this.maxChannelCount;
  }
  
  public int hashCode()
  {
    return this.maxChannelCount + Arrays.hashCode(this.supportedEncodings) * 31;
  }
  
  public boolean supportsEncoding(int paramInt)
  {
    return Arrays.binarySearch(this.supportedEncodings, paramInt) >= 0;
  }
  
  public String toString()
  {
    return "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", supportedEncodings=" + Arrays.toString(this.supportedEncodings) + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPAudioPassThroughCapabilities
 * JD-Core Version:    0.7.0.1
 */