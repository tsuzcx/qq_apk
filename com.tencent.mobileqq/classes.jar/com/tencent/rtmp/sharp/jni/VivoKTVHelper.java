package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import java.util.StringTokenizer;

public class VivoKTVHelper
{
  private static final String KEY_EXT_SPKR = "vivo_ktv_ext_speaker";
  private static final String KEY_KTV_MODE = "vivo_ktv_mode";
  private static final String KEY_MIC_SRC = "vivo_ktv_rec_source";
  private static final String KEY_MIC_TYPE = "vivo_ktv_mic_type";
  private static final String KEY_PLAY_SRC = "vivo_ktv_play_source";
  private static final String KEY_PRESET = "vivo_ktv_preset_effect";
  private static final String KEY_VOL_MIC = "vivo_ktv_volume_mic";
  private static final String TAG = "VivoKTVHelper";
  private static VivoKTVHelper mVivoKTVHelper;
  private AudioManager mAudioManager;
  private Context mContext;
  private final Object mParamLock = new Object();
  
  public VivoKTVHelper(Context paramContext)
  {
    this.mContext = paramContext;
    this.mAudioManager = ((AudioManager)this.mContext.getSystemService("audio"));
  }
  
  public static VivoKTVHelper getInstance(Context paramContext)
  {
    if (mVivoKTVHelper == null) {
      mVivoKTVHelper = new VivoKTVHelper(paramContext);
    }
    return mVivoKTVHelper;
  }
  
  private int getKTVParam(String paramString)
  {
    if (Build.MODEL.trim().contains("vivo"))
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(this.mAudioManager.getParameters(paramString), "=");
      if ((localStringTokenizer.countTokens() == 2) && (paramString.equals(localStringTokenizer.nextToken()))) {
        return Integer.parseInt(localStringTokenizer.nextToken().trim());
      }
    }
    return 0;
  }
  
  public void closeKTVDevice()
  {
    this.mAudioManager.setParameters("vivo_ktv_mode=0");
  }
  
  public int getExtSpeakerParam()
  {
    return getKTVParam("vivo_ktv_ext_speaker");
  }
  
  public int getMicTypeParam()
  {
    return getKTVParam("vivo_ktv_mic_type");
  }
  
  public int getMicVolParam()
  {
    return getKTVParam("vivo_ktv_volume_mic");
  }
  
  public int getPlayFeedbackParam()
  {
    return getKTVParam("vivo_ktv_play_source");
  }
  
  public int getPreModeParam()
  {
    return getKTVParam("vivo_ktv_preset_effect");
  }
  
  public int getVoiceOutParam()
  {
    return getKTVParam("vivo_ktv_rec_source");
  }
  
  public boolean isDeviceSupportKaraoke()
  {
    if (Build.MODEL.trim().contains("vivo"))
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(this.mAudioManager.getParameters("vivo_ktv_mic_type"), "=");
      if (localStringTokenizer.countTokens() != 2) {
        return false;
      }
      if (localStringTokenizer.nextToken().equals("vivo_ktv_mic_type"))
      {
        int i = Integer.parseInt(localStringTokenizer.nextToken());
        if ((i == 1) || (i == 0)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void openKTVDevice()
  {
    this.mAudioManager.setParameters("vivo_ktv_mode=1");
    isDeviceSupportKaraoke();
  }
  
  public void setExtSpeakerParam(int paramInt)
  {
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vivo_ktv_ext_speaker");
        localStringBuilder.append("=");
        localStringBuilder.append(paramInt);
        this.mAudioManager.setParameters(localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void setMicVolParam(int paramInt)
  {
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vivo_ktv_volume_mic");
        localStringBuilder.append("=");
        localStringBuilder.append(paramInt);
        this.mAudioManager.setParameters(localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void setPlayFeedbackParam(int paramInt)
  {
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null)
      {
        AudioManager localAudioManager = this.mAudioManager;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vivo_ktv_play_source=");
        localStringBuilder.append(paramInt);
        localAudioManager.setParameters(localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void setPreModeParam(int paramInt)
  {
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null)
      {
        AudioManager localAudioManager = this.mAudioManager;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vivo_ktv_preset_effect=");
        localStringBuilder.append(paramInt);
        localAudioManager.setParameters(localStringBuilder.toString());
      }
      return;
    }
  }
  
  public void setVoiceOutParam(int paramInt)
  {
    synchronized (this.mParamLock)
    {
      if (this.mAudioManager != null)
      {
        AudioManager localAudioManager = this.mAudioManager;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("vivo_ktv_rec_source=");
        localStringBuilder.append(paramInt);
        localAudioManager.setParameters(localStringBuilder.toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.VivoKTVHelper
 * JD-Core Version:    0.7.0.1
 */