package com.tencent.upload.network.base;

import com.tencent.upload.uinterface.IUploadSoLoader;
import com.tencent.upload.utils.UploadLog;

public class UploadSoDefaultLoader
  implements IUploadSoLoader
{
  public String getSoVersion()
  {
    return "v1.3";
  }
  
  public boolean loadLibrary(String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadLibrary :");
      localStringBuilder.append(paramString);
      UploadLog.d("UploadSoDefaultLoader", localStringBuilder.toString());
      return true;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error :");
      localStringBuilder.append(paramString.toString());
      UploadLog.e("UploadSoDefaultLoader", localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.base.UploadSoDefaultLoader
 * JD-Core Version:    0.7.0.1
 */