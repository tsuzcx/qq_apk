package com.tencent.mobileqq.uniformdownload.data;

import com.tencent.mobileqq.uniformdownload.util.IUniformDownloaderListener;
import java.util.HashMap;
import java.util.Map;

public class UniformDownloaderListenerMgr
{
  private Map<String, IUniformDownloaderListener> a = new HashMap();
  
  public IUniformDownloaderListener a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = (IUniformDownloaderListener)this.a.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, IUniformDownloaderListener paramIUniformDownloaderListener)
  {
    if ((paramString != null) && (paramIUniformDownloaderListener != null)) {}
    try
    {
      this.a.put(paramString, paramIUniformDownloaderListener);
    }
    finally {}
  }
  
  public IUniformDownloaderListener b(String paramString)
  {
    try
    {
      paramString = (IUniformDownloaderListener)this.a.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.data.UniformDownloaderListenerMgr
 * JD-Core Version:    0.7.0.1
 */