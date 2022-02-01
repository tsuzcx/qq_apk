package com.tencent.ttpic.baseutils.audio;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.net.Uri;
import com.tencent.ttpic.baseutils.io.FileUtils;
import java.io.IOException;

public class PlayerUtil
{
  private static AudioManager sManager;
  
  public static PlayerUtil.Player createPlayer(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramString.startsWith("assets://")) {
      return createPlayerFromAssets(paramContext, FileUtils.getRealPath(paramString), paramBoolean);
    }
    return createPlayerFromUri(paramContext, paramString, paramBoolean);
  }
  
  public static PlayerUtil.Player createPlayerFromAssets(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      localPlayer = new PlayerUtil.Player();
    }
    catch (IOException paramContext)
    {
      label44:
      label46:
      break label44;
    }
    try
    {
      paramContext = paramContext.getAssets().openFd(paramString);
      localPlayer.setDataSource(paramContext.getFileDescriptor(), paramContext.getStartOffset(), paramContext.getLength());
      paramContext.close();
      preparePlayer(localPlayer, paramBoolean);
      return localPlayer;
    }
    catch (IOException paramContext)
    {
      paramContext = localPlayer;
      break label46;
    }
    paramContext = null;
    destroyPlayer(paramContext);
    return null;
  }
  
  public static PlayerUtil.Player createPlayerFromUri(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      localPlayer = new PlayerUtil.Player();
    }
    catch (Exception paramContext)
    {
      label24:
      label26:
      break label24;
    }
    try
    {
      localPlayer.setDataSource(paramContext, Uri.parse(paramString));
      preparePlayer(localPlayer, paramBoolean);
      return localPlayer;
    }
    catch (Exception paramContext)
    {
      paramContext = localPlayer;
      break label26;
    }
    paramContext = null;
    destroyPlayer(paramContext);
    return null;
  }
  
  public static PlayerUtil.Recorder createRecorder(String paramString)
  {
    try
    {
      localRecorder = new PlayerUtil.Recorder();
    }
    catch (Exception paramString)
    {
      label62:
      label64:
      break label62;
    }
    try
    {
      localRecorder.setOutputFile(paramString);
      localRecorder.setAudioSource(1);
      localRecorder.setAudioChannels(1);
      localRecorder.setAudioSamplingRate(44100);
      localRecorder.setAudioEncodingBitRate(96000);
      localRecorder.setOutputFormat(2);
      localRecorder.setAudioEncoder(3);
      localRecorder.setOnErrorListener(new PlayerUtil.5());
      localRecorder.prepare();
      return localRecorder;
    }
    catch (Exception paramString)
    {
      paramString = localRecorder;
      break label64;
    }
    paramString = null;
    destroyRecorder(paramString);
    return null;
  }
  
  public static void destroyPlayer(PlayerUtil.Player paramPlayer)
  {
    if (paramPlayer != null)
    {
      paramPlayer.stop();
      paramPlayer.reset();
      paramPlayer.release();
    }
  }
  
  public static void destroyRecorder(PlayerUtil.Recorder paramRecorder)
  {
    if (paramRecorder != null)
    {
      paramRecorder.stop();
      paramRecorder.reset();
      paramRecorder.release();
    }
  }
  
  private static AudioManager getAudioManager(Context paramContext)
  {
    if (sManager == null) {
      sManager = (AudioManager)paramContext.getSystemService("audio");
    }
    return sManager;
  }
  
  public static int getMaxVolume(Context paramContext)
  {
    return getAudioManager(paramContext).getStreamMaxVolume(3);
  }
  
  public static int getVolume(Context paramContext)
  {
    return getAudioManager(paramContext).getStreamVolume(3);
  }
  
  public static boolean isSilentMode(Context paramContext)
  {
    int i = getAudioManager(paramContext).getRingerMode();
    if ((i != 0) && (i != 1))
    {
      if (i != 2) {}
      return false;
    }
    return true;
  }
  
  private boolean isSupportedAudioSamplingRate(int paramInt)
  {
    return AudioRecord.getMinBufferSize(paramInt, 16, 2) > 0;
  }
  
  public static void pauseAndSeekToOrigin(PlayerUtil.Player paramPlayer)
  {
    if (paramPlayer != null)
    {
      paramPlayer.pause();
      paramPlayer.seekTo(0);
    }
  }
  
  private static void preparePlayer(PlayerUtil.Player paramPlayer, boolean paramBoolean)
  {
    paramPlayer.setAudioStreamType(3);
    paramPlayer.setLooping(paramBoolean);
    paramPlayer.setOnCompletionListener(new PlayerUtil.1());
    paramPlayer.setOnErrorListener(new PlayerUtil.2());
    paramPlayer.prepare();
  }
  
  public static void seekPlayer(PlayerUtil.Player paramPlayer, int paramInt)
  {
    if (paramPlayer != null)
    {
      paramPlayer.setOnSeekCompleteListener(new PlayerUtil.4());
      paramPlayer.seekTo(paramInt);
    }
  }
  
  public static void setMute(Context paramContext, boolean paramBoolean)
  {
    getAudioManager(paramContext).setStreamMute(3, paramBoolean);
  }
  
  public static void setVolume(Context paramContext, int paramInt)
  {
    getAudioManager(paramContext).setStreamVolume(3, Math.min(Math.max(paramInt, 0), getMaxVolume(paramContext)), 8);
  }
  
  public static void startPlayer(PlayerUtil.Player paramPlayer, boolean paramBoolean)
  {
    if (paramPlayer != null)
    {
      if (paramBoolean)
      {
        paramPlayer.setOnSeekCompleteListener(new PlayerUtil.3());
        paramPlayer.seekTo(0);
        return;
      }
      paramPlayer.start();
    }
  }
  
  public static void startRecorder(PlayerUtil.Recorder paramRecorder)
  {
    if (paramRecorder != null) {
      paramRecorder.start();
    }
  }
  
  public static void stopPlayer(PlayerUtil.Player paramPlayer)
  {
    if (paramPlayer != null) {
      paramPlayer.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.audio.PlayerUtil
 * JD-Core Version:    0.7.0.1
 */