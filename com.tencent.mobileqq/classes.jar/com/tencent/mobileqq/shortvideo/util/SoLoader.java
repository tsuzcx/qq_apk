package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import com.tencent.mobileqq.activity.richmedia.FileUtils;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.resource.ArtFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;

public class SoLoader
{
  public static int SV_SO_LOAD_STATUS_artfilter = -4;
  public static final String SV_SO_QMCF = "libQMCF.so";
  public static final String[] SV_SO_QMCF_SNPE = { "libsymphonypower.so", "libsymphony-cpu.so", "libSNPE.so", "libQMCF_snpe.so" };
  public static int[] SV_SO_QMCF_SNPE_LOAD_STATUS = { -4, -4, -4, -4 };
  private static final String TAG = "SoLoader";
  public static final int VIDEO_FILE_NOT_FIND = -2;
  public static final int VIDEO_INVALID_PARAM = -1;
  public static final int VIDEO_LOAD_ERROR = -3;
  public static final int VIDEO_LOAD_SUCCESS = 0;
  public static final int VIDEO_LOAD_UNINIT = -4;
  private static int VIDEO_SO_LOAD_STATUS = 0;
  public static final int VIDEO_SO_VERSION_ERR = -5;
  public static boolean bGetLicensed = false;
  private static boolean isQmcfSoExist = false;
  
  private static int LoadExtractedShortVideoFilterLib(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    if (!new File(paramString).exists()) {
      return -2;
    }
    try
    {
      System.load(paramString);
      return 0;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (SLog.isEnable())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LoadExtractedShortVideoFilterLib, path:");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", exp:");
        SLog.e("SoLoader", localStringBuilder.toString(), localUnsatisfiedLinkError);
      }
    }
    return -3;
  }
  
  public static boolean isLoadArtFilterSuccess()
  {
    if (SLog.isEnable()) {
      SLog.i("SoLoader", String.format("isLoadArtFilterSuccess, status=[%S]", new Object[] { Integer.valueOf(SV_SO_LOAD_STATUS_artfilter) }));
    }
    return SV_SO_LOAD_STATUS_artfilter == 0;
  }
  
  public static boolean isQmcfSoExist()
  {
    if (isQmcfSoExist) {
      return true;
    }
    String str = SdkContext.getInstance().getResources().getArtFilterResource().getSoPathDir();
    if (str == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("libQMCF.so");
    isQmcfSoExist = FileUtils.fileExists(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(SV_SO_QMCF_SNPE[4]);
    boolean bool = FileUtils.fileExists(localStringBuilder.toString());
    if (SLog.isEnable()) {
      SLog.i("SoLoader", String.format("isQmcfSoExist, qmcf[%s], snpe[%s]", new Object[] { Boolean.valueOf(isQmcfSoExist), Boolean.valueOf(bool) }));
    }
    return isQmcfSoExist;
  }
  
  public static boolean isQmcfSoUnLoaded()
  {
    return SV_SO_LOAD_STATUS_artfilter == -4;
  }
  
  private static boolean loadArtFilterSo()
  {
    if (isLoadArtFilterSuccess()) {
      return true;
    }
    if (SdkContext.getInstance().getResources() == null) {
      return false;
    }
    String str = SdkContext.getInstance().getResources().getArtFilterResource().getSoPathDir();
    Object localObject;
    if (SV_SO_LOAD_STATUS_artfilter != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(SV_SO_QMCF_SNPE[3]);
      if (!FileUtils.fileExists(((StringBuilder)localObject).toString())) {}
    }
    try
    {
      System.loadLibrary("c++_shared");
      if (SLog.isEnable()) {
        SLog.i("SoLoader", "load c++_shared success");
      }
      label100:
      int i = 0;
      while (i < SV_SO_QMCF_SNPE.length)
      {
        localObject = SV_SO_QMCF_SNPE_LOAD_STATUS;
        if (localObject[i] != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(SV_SO_QMCF_SNPE[i]);
          localObject[i] = LoadExtractedShortVideoFilterLib(localStringBuilder.toString());
        }
        if (SLog.isEnable()) {
          SLog.i("SoLoader", String.format("loadSnpeSo, idx[%d], bSuc[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(SV_SO_QMCF_SNPE_LOAD_STATUS[i]) }));
        }
        i += 1;
      }
      localObject = SV_SO_QMCF_SNPE_LOAD_STATUS;
      int k = localObject.length;
      i = 0;
      int j = 1;
      while (i < k)
      {
        if (localObject[i] != 0) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0) {
        QmcfManager.hasSNPESo = true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("libQMCF.so");
      SV_SO_LOAD_STATUS_artfilter = LoadExtractedShortVideoFilterLib(((StringBuilder)localObject).toString());
      boolean bool = isLoadArtFilterSuccess();
      if (SLog.isEnable()) {
        SLog.i("SoLoader", String.format("loadArtFilterSo, bSuc[%s], snpeSuc[%s], soPath[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(QmcfManager.hasSNPESo), str }));
      }
      return bool;
    }
    catch (Error localError)
    {
      break label100;
    }
  }
  
  public static boolean loadSvArtFilterSO(Context paramContext)
  {
    try
    {
      boolean bool = loadArtFilterSo();
      return bool;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SoLoader
 * JD-Core Version:    0.7.0.1
 */