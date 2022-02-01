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
    int i;
    if (paramString == null) {
      i = -1;
    }
    do
    {
      return i;
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
        i = -3;
      }
    } while (!SLog.isEnable());
    SLog.e("SoLoader", "LoadExtractedShortVideoFilterLib, path:" + paramString + ", exp:", localUnsatisfiedLinkError);
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
    isQmcfSoExist = FileUtils.fileExists(str + "libQMCF.so");
    boolean bool = FileUtils.fileExists(str + SV_SO_QMCF_SNPE[4]);
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
    boolean bool = false;
    if (isLoadArtFilterSuccess()) {
      bool = true;
    }
    while (SdkContext.getInstance().getResources() == null) {
      return bool;
    }
    String str = SdkContext.getInstance().getResources().getArtFilterResource().getSoPathDir();
    if ((SV_SO_LOAD_STATUS_artfilter == 0) || (FileUtils.fileExists(str + SV_SO_QMCF_SNPE[3]))) {}
    try
    {
      System.loadLibrary("c++_shared");
      if (SLog.isEnable()) {
        SLog.i("SoLoader", "load c++_shared success");
      }
      label92:
      int i = 0;
      while (i < SV_SO_QMCF_SNPE.length)
      {
        if (SV_SO_QMCF_SNPE_LOAD_STATUS[i] != 0) {
          SV_SO_QMCF_SNPE_LOAD_STATUS[i] = LoadExtractedShortVideoFilterLib(str + SV_SO_QMCF_SNPE[i]);
        }
        if (SLog.isEnable()) {
          SLog.i("SoLoader", String.format("loadSnpeSo, idx[%d], bSuc[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(SV_SO_QMCF_SNPE_LOAD_STATUS[i]) }));
        }
        i += 1;
      }
      int[] arrayOfInt = SV_SO_QMCF_SNPE_LOAD_STATUS;
      int k = arrayOfInt.length;
      i = 0;
      int j = 1;
      while (i < k)
      {
        if (arrayOfInt[i] != 0) {
          j = 0;
        }
        i += 1;
      }
      if (j != 0) {
        QmcfManager.hasSNPESo = true;
      }
      SV_SO_LOAD_STATUS_artfilter = LoadExtractedShortVideoFilterLib(str + "libQMCF.so");
      bool = isLoadArtFilterSuccess();
      if (SLog.isEnable()) {
        SLog.i("SoLoader", String.format("loadArtFilterSo, bSuc[%s], snpeSuc[%s], soPath[%s]", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(QmcfManager.hasSNPESo), str }));
      }
      return bool;
    }
    catch (Error localError)
    {
      break label92;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.SoLoader
 * JD-Core Version:    0.7.0.1
 */