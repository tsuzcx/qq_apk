package com.tencent.oskplayer.miscellaneous;

import android.support.annotation.NonNull;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import com.tencent.oskplayer.support.util.OskFile;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.annotations.CalledByNative;

public class SoftwareDecodeProbe
  implements IMediaPlayer.OnPreparedListener
{
  public static final String TAG = "SoftwareDecodeProbe";
  static long mDecodeFrameAvgCost = 2147483647L;
  static Object mLockObject = new Object();
  static int mMaxFrameNo;
  static volatile SoftwareDecodeProbe.SwProbeCallback mProbeCallback;
  static int mProbeError;
  static Set<Integer> mSaveFrames = new HashSet();
  static String mSavedDir;
  IjkMediaPlayer mProber;
  
  public static long getDecodeFrameAvgCost()
  {
    return mDecodeFrameAvgCost;
  }
  
  @CalledByNative
  public static int getMaxNeedSaveFrameNo()
  {
    return mMaxFrameNo;
  }
  
  @CalledByNative
  public static String getSavedDir()
  {
    return mSavedDir;
  }
  
  @CalledByNative
  public static boolean needSaveFrame(int paramInt)
  {
    return mSaveFrames.contains(Integer.valueOf(paramInt));
  }
  
  @CalledByNative
  public static void onProbeDone(int paramInt, long paramLong)
  {
    ??? = Logger.g();
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onProbeDone] errorCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", avgCost=");
    localStringBuilder.append(paramLong);
    ((ILogger)???).i(str, localStringBuilder.toString());
    mProbeError = paramInt;
    mDecodeFrameAvgCost = paramLong;
    synchronized (mLockObject)
    {
      mLockObject.notifyAll();
      return;
    }
  }
  
  @CalledByNative
  public static void onProbeOneFrame(int paramInt)
  {
    if (mProbeCallback != null) {
      mProbeCallback.onSwProbeOneFrame(paramInt);
    }
  }
  
  public static void setProbeCallback(SoftwareDecodeProbe.SwProbeCallback paramSwProbeCallback)
  {
    mProbeCallback = paramSwProbeCallback;
  }
  
  public void onPrepared(IMediaPlayer paramIMediaPlayer)
  {
    try
    {
      paramIMediaPlayer.start();
      return;
    }
    catch (Exception paramIMediaPlayer)
    {
      ILogger localILogger = Logger.g();
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[probe] start error, ");
      localStringBuilder.append(paramIMediaPlayer.toString());
      localILogger.e(str, localStringBuilder.toString());
      mProbeError = 20002;
    }
  }
  
  public int probe(@NonNull String arg1, @NonNull String paramString2, Set<Integer> paramSet)
  {
    if ((OskFile.isLocalFile(???)) && (!new File(???).canRead()))
    {
      paramString2 = Logger.g();
      paramSet = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[decode] file cannot read, ");
      ((StringBuilder)localObject).append(???);
      paramString2.e(paramSet, ((StringBuilder)localObject).toString());
      return 20015;
    }
    Object localObject = new File(paramString2);
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      return 20004;
    }
    mSavedDir = paramString2;
    mSaveFrames.clear();
    mMaxFrameNo = -1;
    paramString2 = paramSet.iterator();
    while (paramString2.hasNext())
    {
      paramSet = (Integer)paramString2.next();
      mMaxFrameNo = Math.max(mMaxFrameNo, paramSet.intValue());
      mSaveFrames.add(paramSet);
    }
    paramString2 = Logger.g();
    paramSet = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[probe] mMaxFrameNo=");
    ((StringBuilder)localObject).append(mMaxFrameNo);
    ((StringBuilder)localObject).append(", savedDir=");
    ((StringBuilder)localObject).append(mSavedDir);
    paramString2.d(paramSet, ((StringBuilder)localObject).toString());
    this.mProber = new IjkMediaPlayer();
    this.mProber.setOption(4, "decoder_probe_mode", 1L);
    this.mProber.setOption(4, "max-fps", -1L);
    this.mProber.setOnPreparedListener(this);
    try
    {
      this.mProber.setDataSource(???);
      this.mProber.prepareAsync();
      mProbeError = 20003;
      try
      {
        synchronized (mLockObject)
        {
          mLockObject.wait(60000L);
        }
      }
      catch (InterruptedException paramString2)
      {
        paramSet = Logger.g();
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[probe] InterruptedException, ");
        localStringBuilder.append(paramString2.toString());
        paramSet.e((String)localObject, localStringBuilder.toString());
        ??? = Logger.g();
        paramString2 = TAG;
        paramSet = new StringBuilder();
        paramSet.append("[probe] probe done, ");
        paramSet.append(mProbeError);
        ???.d(paramString2, paramSet.toString());
        return mProbeError;
      }
      throw paramString2;
    }
    catch (Exception ???)
    {
      paramString2 = Logger.g();
      paramSet = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[probe] setDataSource error, ");
      ((StringBuilder)localObject).append(???.toString());
      paramString2.e(paramSet, ((StringBuilder)localObject).toString());
    }
    return 20001;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.miscellaneous.SoftwareDecodeProbe
 * JD-Core Version:    0.7.0.1
 */