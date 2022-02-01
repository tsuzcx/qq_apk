package org.light;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;

public class RendererConfig
{
  public static final int INIT_ALL_SEG = 0;
  public static final int INIT_BG_SEG = 2;
  public static final int INIT_CLEAN = 1;
  public String bundlePath = "";
  public String decryptPath = "";
  public boolean enablePerfReport = false;
  public boolean enablePerfVramTrace = false;
  public boolean englishPerfKey = false;
  public int initMode = 0;
  public int perfRunMode = 0;
  
  public RendererConfig()
  {
    setDefaultDecryptPath();
  }
  
  public RendererConfig(String paramString)
  {
    this.bundlePath = paramString;
    setDefaultDecryptPath();
  }
  
  private void setDefaultDecryptPath()
  {
    try
    {
      this.decryptPath = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext().getFilesDir().getAbsolutePath();
      return;
    }
    catch (Exception localException)
    {
      Log.e("RendererConfig", localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.RendererConfig
 * JD-Core Version:    0.7.0.1
 */