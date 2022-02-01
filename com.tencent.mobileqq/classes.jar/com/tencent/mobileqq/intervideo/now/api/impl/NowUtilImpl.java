package com.tencent.mobileqq.intervideo.now.api.impl;

import android.content.Context;
import com.tencent.mobileqq.intervideo.now.NowUtil;
import com.tencent.mobileqq.intervideo.now.api.INowUtil;

public class NowUtilImpl
  implements INowUtil
{
  public boolean checkNowApkExist(String paramString1, String paramString2)
  {
    return NowUtil.a(paramString1, paramString2);
  }
  
  public boolean copyNowApkToCommonDir(String paramString1, String paramString2, String paramString3)
  {
    return NowUtil.a(paramString1, paramString2, paramString3);
  }
  
  public boolean delete(String paramString)
  {
    return NowUtil.a(paramString);
  }
  
  public String getCommonNowPath()
  {
    return NowUtil.b();
  }
  
  public String getCommonNowTempPath()
  {
    return NowUtil.a();
  }
  
  public boolean isExists(String paramString)
  {
    return NowUtil.b(paramString);
  }
  
  public boolean isH5Test()
  {
    return NowUtil.a();
  }
  
  public void pauseNowDownloadInQQ(Context paramContext)
  {
    NowUtil.a(paramContext);
  }
  
  public boolean renameTo(String paramString1, String paramString2)
  {
    return NowUtil.b(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.api.impl.NowUtilImpl
 * JD-Core Version:    0.7.0.1
 */