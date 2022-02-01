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
  public static final String TAG = "DecodeProbe";
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
    File[] arrayOfFile = null;
    if (paramFile.isDirectory()) {
      arrayOfFile = paramFile.listFiles();
    }
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
    HardwareDecodeProbe localHardwareDecodeProbe = this.mHardwareDecodeProbe;
    if (localHardwareDecodeProbe == null) {
      return 0L;
    }
    return localHardwareDecodeProbe.getDecodeFrameAvgCost();
  }
  
  public File getPicOutDir()
  {
    String str = getPicOutDirPath();
    if (!TextUtils.isEmpty(str)) {
      return new File(str);
    }
    return null;
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
    if (Build.VERSION.SDK_INT < 17) {
      return 10001;
    }
    if (failedEnsurePicOutDir()) {
      return 60000;
    }
    int i = this.mHardwareDecodeProbe.probe(paramString, getPicOutDirPath(), this.mSaveFrameSet);
    if (i != 0) {
      return i;
    }
    return 0;
  }
  
  public int probe(String paramString)
  {
    if (Build.VERSION.SDK_INT < 17) {
      return 10001;
    }
    if (failedEnsurePicOutDir()) {
      return 60000;
    }
    long l1 = System.currentTimeMillis();
    int i = this.mHardwareDecodeProbe.probe(paramString, getPicOutDirPath(), this.mSaveFrameSet);
    if (i != 0) {
      return i;
    }
    long l2 = System.currentTimeMillis();
    Object localObject1 = Logger.g();
    Object localObject2 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[probe] hw probe cost=");
    localStringBuilder.append(l2 - l1);
    localStringBuilder.append(", decode frame avg cost=");
    localStringBuilder.append(this.mHardwareDecodeProbe.getDecodeFrameAvgCost());
    ((ILogger)localObject1).d((String)localObject2, localStringBuilder.toString());
    l1 = System.currentTimeMillis();
    i = this.mSoftwareProbe.probe(paramString, getPicOutDirPath(), this.mSaveFrameSet);
    if (i != 0) {
      return i;
    }
    l2 = System.currentTimeMillis();
    paramString = Logger.g();
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[probe] sw probe cost=");
    ((StringBuilder)localObject2).append(l2 - l1);
    ((StringBuilder)localObject2).append(", decode frame avg cost=");
    ((StringBuilder)localObject2).append(SoftwareDecodeProbe.getDecodeFrameAvgCost());
    paramString.d((String)localObject1, ((StringBuilder)localObject2).toString());
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
    if (failedEnsurePicOutDir()) {
      return 60000;
    }
    int i = this.mSoftwareProbe.probe(paramString, getPicOutDirPath(), this.mSaveFrameSet);
    if (i != 0) {
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.miscellaneous.DecodeProbe
 * JD-Core Version:    0.7.0.1
 */