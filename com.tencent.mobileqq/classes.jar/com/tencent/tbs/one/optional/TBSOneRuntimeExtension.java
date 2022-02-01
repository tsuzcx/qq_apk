package com.tencent.tbs.one.optional;

import com.tencent.tbs.one.TBSOneCallback;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public abstract class TBSOneRuntimeExtension
{
  public void cancel(int paramInt) {}
  
  public int shouldInterceptComponentResponse(String paramString1, String paramString2, int paramInt, Map<String, Object> paramMap, InputStream paramInputStream, File paramFile, TBSOneCallback<Void> paramTBSOneCallback)
  {
    return 0;
  }
  
  public int shouldInterceptDEPSResponse(String paramString, Map<String, Object> paramMap, InputStream paramInputStream, File paramFile, TBSOneCallback<Void> paramTBSOneCallback)
  {
    return 0;
  }
  
  public int shouldOverrideInstallationJob(String paramString1, String paramString2, int paramInt, Map<String, Object> paramMap, File paramFile, TBSOneCallback<Void> paramTBSOneCallback)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.optional.TBSOneRuntimeExtension
 * JD-Core Version:    0.7.0.1
 */