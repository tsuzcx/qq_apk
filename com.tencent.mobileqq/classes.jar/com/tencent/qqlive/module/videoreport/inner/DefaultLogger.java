package com.tencent.qqlive.module.videoreport.inner;

import android.util.Log;
import com.tencent.qqlive.module.videoreport.ILogger;

public class DefaultLogger
  implements ILogger
{
  private static final String PRE_FIX = "DT#";
  
  public void d(String paramString1, String paramString2)
  {
    Log.d("DT#" + paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    Log.e("DT#" + paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2)
  {
    Log.i("DT#" + paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2)
  {
    Log.v("DT#" + paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2)
  {
    Log.w("DT#" + paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.inner.DefaultLogger
 * JD-Core Version:    0.7.0.1
 */