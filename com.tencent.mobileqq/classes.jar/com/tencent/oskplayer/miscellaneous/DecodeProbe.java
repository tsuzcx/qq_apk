package com.tencent.oskplayer.miscellaneous;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import com.tencent.oskplayer.support.util.OskFile;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@TargetApi(17)
public class DecodeProbe
{
  public static final String TAG = DecodeProbe.class.getSimpleName();
  private static final String outDirBasePath = "video_dec_probe";
  private static String outDirPath = "";
  HardwareDecodeProbe mHardwareDecodeProbe = new HardwareDecodeProbe();
  Set<Integer> mSaveFrameSet = new HashSet();
  SoftwareDecodeProbe mSoftwareProbe = new SoftwareDecodeProbe();
  
  private void deleteRecursive(File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    if (paramFile.isDirectory()) {}
    for (File[] arrayOfFile = paramFile.listFiles();; arrayOfFile = null)
    {
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          deleteRecursive(arrayOfFile[i]);
          i += 1;
        }
      }
      paramFile.delete();
      return;
    }
  }
  
  private boolean failedEnsurePicOutDir()
  {
    return TextUtils.isEmpty(OskFile.ensureFilesDir("video_dec_probe"));
  }
  
  public static DecodeProbe getInstance()
  {
    return DecodeProbe.SingletonHolder.access$100();
  }
  
  public void addSaveFrame(int... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.mSaveFrameSet.add(Integer.valueOf(paramVarArgs[i]));
      i += 1;
    }
  }
  
  public void cleanPicOutDir()
  {
    deleteRecursive(getPicOutDir());
  }
  
  public long getHwDecodeAvgCost()
  {
    if (this.mHardwareDecodeProbe == null) {
      return 0L;
    }
    return this.mHardwareDecodeProbe.getDecodeFrameAvgCost();
  }
  
  public File getPicOutDir()
  {
    File localFile = null;
    String str = getPicOutDirPath();
    if (!TextUtils.isEmpty(str)) {
      localFile = new File(str);
    }
    return localFile;
  }
  
  public String getPicOutDirPath()
  {
    if (TextUtils.isEmpty(outDirPath)) {
      outDirPath = OskFile.ensureFilesDir("video_dec_probe");
    }
    return outDirPath;
  }
  
  public long getSwDecodeAvgCost()
  {
    if (this.mSoftwareProbe == null) {
      return 0L;
    }
    return SoftwareDecodeProbe.getDecodeFrameAvgCost();
  }
  
  public int hwProbe(String paramString)
  {
    int i;
    if (Build.VERSION.SDK_INT < 17) {
      i = 10001;
    }
    int j;
    do
    {
      return i;
      if (failedEnsurePicOutDir()) {
        return 60000;
      }
      j = this.mHardwareDecodeProbe.probe(paramString, getPicOutDirPath(), this.mSaveFrameSet);
      i = j;
    } while (j != 0);
    return 0;
  }
  
  public int probe(String paramString)
  {
    int i;
    if (Build.VERSION.SDK_INT < 17) {
      i = 10001;
    }
    long l1;
    int j;
    do
    {
      do
      {
        return i;
        if (failedEnsurePicOutDir()) {
          return 60000;
        }
        l1 = System.currentTimeMillis();
        j = this.mHardwareDecodeProbe.probe(paramString, getPicOutDirPath(), this.mSaveFrameSet);
        i = j;
      } while (j != 0);
      l2 = System.currentTimeMillis();
      Logger.g().d(TAG, "[probe] hw probe cost=" + (l2 - l1) + ", decode frame avg cost=" + this.mHardwareDecodeProbe.getDecodeFrameAvgCost());
      l1 = System.currentTimeMillis();
      j = this.mSoftwareProbe.probe(paramString, getPicOutDirPath(), this.mSaveFrameSet);
      i = j;
    } while (j != 0);
    long l2 = System.currentTimeMillis();
    Logger.g().d(TAG, "[probe] sw probe cost=" + (l2 - l1) + ", decode frame avg cost=" + SoftwareDecodeProbe.getDecodeFrameAvgCost());
    return 0;
  }
  
  public void setHwProbeCallback(HardwareDecodeProbe.HwProbeCallback paramHwProbeCallback)
  {
    this.mHardwareDecodeProbe.setProbeCallback(paramHwProbeCallback);
  }
  
  public void setSwProbeCallback(SoftwareDecodeProbe.SwProbeCallback paramSwProbeCallback)
  {
    SoftwareDecodeProbe.setProbeCallback(paramSwProbeCallback);
  }
  
  public int swProbe(String paramString)
  {
    int i;
    if (failedEnsurePicOutDir()) {
      i = 60000;
    }
    int j;
    do
    {
      return i;
      j = this.mSoftwareProbe.probe(paramString, getPicOutDirPath(), this.mSaveFrameSet);
      i = j;
    } while (j != 0);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.oskplayer.miscellaneous.DecodeProbe
 * JD-Core Version:    0.7.0.1
 */