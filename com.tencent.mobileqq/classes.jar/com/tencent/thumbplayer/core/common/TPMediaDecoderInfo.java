package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.os.Build.VERSION;
import android.util.Range;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public final class TPMediaDecoderInfo
  implements Serializable
{
  private static final int DEFAULT_MAX_HEIGHT = 720;
  private static final int DEFAULT_MAX_WIDTH = 1280;
  private static final String TAG = "TPCodecUtils";
  private final boolean adaptiveDec;
  private int[] colorFormats;
  private final String decMimeType;
  private final String decName;
  private int maxFrameRate;
  private int maxHeight;
  private int maxLumaFrameRate;
  private int maxLumaHeight;
  private int maxLumaWidth;
  private int maxSupportedInstances;
  private int maxWidth;
  private TPMediaDecoderInfo.DecoderProfileLevel[] profileLevels;
  private final boolean secureDec;
  private final boolean softwareAudioDec;
  private final boolean softwareVideoDec;
  private final boolean tunnelingDec;
  
  public TPMediaDecoderInfo(String paramString1, String paramString2, MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    this.decName = paramString2;
    this.decMimeType = paramString1;
    boolean bool1 = isVideo();
    boolean bool2 = true;
    if ((bool1) && (isVideoSoftwareOnly(paramString2))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.softwareVideoDec = bool1;
    if ((isAudio()) && (isAudioSoftwareOnly(paramString2))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.softwareAudioDec = bool1;
    if ((paramCodecCapabilities != null) && (isAdaptive(paramCodecCapabilities))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.adaptiveDec = bool1;
    if ((paramCodecCapabilities != null) && (isTunneling(paramCodecCapabilities))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.tunnelingDec = bool1;
    if ((paramCodecCapabilities != null) && (isSecure(paramCodecCapabilities))) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.secureDec = bool1;
    if ((paramCodecCapabilities != null) && (paramCodecCapabilities.profileLevels != null) && (paramCodecCapabilities.profileLevels.length > 0))
    {
      paramString2 = new ArrayList();
      MediaCodecInfo.CodecProfileLevel[] arrayOfCodecProfileLevel = paramCodecCapabilities.profileLevels;
      int j = arrayOfCodecProfileLevel.length;
      int i = 0;
      while (i < j)
      {
        MediaCodecInfo.CodecProfileLevel localCodecProfileLevel = arrayOfCodecProfileLevel[i];
        paramString2.add(new TPMediaDecoderInfo.DecoderProfileLevel(this, localCodecProfileLevel.profile, localCodecProfileLevel.level));
        i += 1;
      }
      this.profileLevels = ((TPMediaDecoderInfo.DecoderProfileLevel[])paramString2.toArray(new TPMediaDecoderInfo.DecoderProfileLevel[paramString2.size()]));
    }
    else
    {
      this.profileLevels = new TPMediaDecoderInfo.DecoderProfileLevel[0];
    }
    if ((paramCodecCapabilities != null) && (paramCodecCapabilities.colorFormats != null) && (paramCodecCapabilities.colorFormats.length > 0)) {
      this.colorFormats = Arrays.copyOf(paramCodecCapabilities.colorFormats, paramCodecCapabilities.colorFormats.length);
    } else {
      this.colorFormats = new int[0];
    }
    this.maxSupportedInstances = getMaxSupportedInstances(paramCodecCapabilities);
    this.maxLumaFrameRate = 30;
    this.maxFrameRate = 30;
    this.maxWidth = 1280;
    this.maxHeight = 720;
    this.maxLumaWidth = 1280;
    this.maxLumaHeight = 720;
    if ((Build.VERSION.SDK_INT >= 21) && (paramString1.contains("video")) && (paramCodecCapabilities != null))
    {
      paramString1 = paramCodecCapabilities.getVideoCapabilities();
      if (paramString1 != null)
      {
        this.maxWidth = getMaxWidth(paramString1);
        this.maxHeight = getMaxHeight(paramString1);
        this.maxLumaFrameRate = getMaxSupportedFrameRate(paramString1);
        this.maxFrameRate = ((Integer)paramString1.getSupportedFrameRates().getUpper()).intValue();
      }
    }
  }
  
  private int getMaxHeight(MediaCodecInfo.VideoCapabilities paramVideoCapabilities)
  {
    if (paramVideoCapabilities != null) {
      paramVideoCapabilities = paramVideoCapabilities.getSupportedHeights();
    } else {
      paramVideoCapabilities = new Range(Integer.valueOf(0), Integer.valueOf(720));
    }
    return ((Integer)paramVideoCapabilities.getUpper()).intValue();
  }
  
  private final int getMaxSupportedFrameRate(MediaCodecInfo.VideoCapabilities paramVideoCapabilities)
  {
    if (paramVideoCapabilities == null) {
      return 30;
    }
    this.maxLumaWidth = ((Integer)paramVideoCapabilities.getSupportedWidthsFor(this.maxHeight).getUpper()).intValue();
    this.maxLumaHeight = ((Integer)paramVideoCapabilities.getSupportedHeightsFor(this.maxWidth).getUpper()).intValue();
    return ((Double)paramVideoCapabilities.getSupportedFrameRatesFor(this.maxWidth, this.maxLumaHeight).getUpper()).intValue();
  }
  
  private int getMaxSupportedInstances(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    if ((paramCodecCapabilities != null) && (Build.VERSION.SDK_INT >= 23)) {
      return paramCodecCapabilities.getMaxSupportedInstances();
    }
    return 1;
  }
  
  private int getMaxWidth(MediaCodecInfo.VideoCapabilities paramVideoCapabilities)
  {
    if (paramVideoCapabilities != null) {
      paramVideoCapabilities = paramVideoCapabilities.getSupportedWidths();
    } else {
      paramVideoCapabilities = new Range(Integer.valueOf(0), Integer.valueOf(1280));
    }
    return ((Integer)paramVideoCapabilities.getUpper()).intValue();
  }
  
  private boolean isAdaptive(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (Build.VERSION.SDK_INT >= 19) && (paramCodecCapabilities.isFeatureSupported("adaptive-playback"));
  }
  
  private boolean isAudioSoftwareOnly(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    } else {
      paramString = paramString.toLowerCase();
    }
    return (paramString.startsWith("omx.google.")) || (paramString.startsWith("c2.android.")) || (paramString.startsWith("c2.google."));
  }
  
  private boolean isSecure(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (Build.VERSION.SDK_INT >= 21) && (paramCodecCapabilities.isFeatureSupported("secure-playback"));
  }
  
  private boolean isTunneling(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return (Build.VERSION.SDK_INT >= 21) && (paramCodecCapabilities.isFeatureSupported("tunneled-playback"));
  }
  
  private boolean isVideoSoftwareOnly(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    } else {
      paramString = paramString.toLowerCase();
    }
    return (paramString.startsWith("omx.google.")) || (paramString.startsWith("omx.ffmpeg.")) || ((paramString.startsWith("omx.sec.")) && (paramString.contains(".sw."))) || (paramString.equals("omx.qcom.video.decoder.hevcswvdec")) || ((paramString.startsWith("omx.qti.video.decoder")) && (paramString.contains("sw"))) || (paramString.startsWith("c2.android.")) || (paramString.startsWith("c2.google."));
  }
  
  public final int[] getColorFormats()
  {
    return this.colorFormats;
  }
  
  public final int getDecoderLumaHeight()
  {
    return this.maxLumaHeight;
  }
  
  public final int getDecoderLumaWidth()
  {
    return this.maxLumaWidth;
  }
  
  public final int getDecoderMaxFrameRate()
  {
    return this.maxFrameRate;
  }
  
  public final int getDecoderMaxFrameRateForMaxLuma()
  {
    return this.maxLumaFrameRate;
  }
  
  public final int getDecoderMaxHeight()
  {
    return this.maxHeight;
  }
  
  public final int getDecoderMaxWidth()
  {
    return this.maxWidth;
  }
  
  public final String getDecoderMimeType()
  {
    return this.decMimeType;
  }
  
  public final String getDecoderName()
  {
    return this.decName;
  }
  
  public final TPMediaDecoderInfo.DecoderProfileLevel getMaxProfileLevel()
  {
    int i = 0;
    Object localObject = new TPMediaDecoderInfo.DecoderProfileLevel(this, 0, 0);
    TPMediaDecoderInfo.DecoderProfileLevel[] arrayOfDecoderProfileLevel = this.profileLevels;
    int m = arrayOfDecoderProfileLevel.length;
    int k;
    for (int j = 0; i < m; j = k)
    {
      TPMediaDecoderInfo.DecoderProfileLevel localDecoderProfileLevel = arrayOfDecoderProfileLevel[i];
      k = j;
      if (localDecoderProfileLevel.level >= j)
      {
        k = localDecoderProfileLevel.level;
        localObject = localDecoderProfileLevel;
      }
      i += 1;
    }
    return localObject;
  }
  
  public final int getMaxSupportedInstances()
  {
    return this.maxSupportedInstances;
  }
  
  public final TPMediaDecoderInfo.DecoderProfileLevel[] getProfileLevels()
  {
    return this.profileLevels;
  }
  
  public boolean isAudio()
  {
    String str = this.decMimeType;
    if (str == null) {
      return false;
    }
    return str.startsWith("audio/");
  }
  
  public final boolean isAudioSofwareDecoder()
  {
    return this.softwareAudioDec;
  }
  
  public final boolean isSecureDecoder()
  {
    return this.secureDec;
  }
  
  public boolean isVideo()
  {
    String str = this.decMimeType;
    if (str == null) {
      return false;
    }
    return str.startsWith("video/");
  }
  
  public final boolean isVideoSofwareDecoder()
  {
    return this.softwareVideoDec;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPMediaDecoderInfo
 * JD-Core Version:    0.7.0.1
 */