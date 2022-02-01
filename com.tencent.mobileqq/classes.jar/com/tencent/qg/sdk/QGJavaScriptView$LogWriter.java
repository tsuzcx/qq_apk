package com.tencent.qg.sdk;

import android.util.Log;
import java.io.Writer;

class QGJavaScriptView$LogWriter
  extends Writer
{
  private StringBuilder mBuilder = new StringBuilder();
  
  private void flushBuilder()
  {
    if (this.mBuilder.length() > 0)
    {
      Log.v("GLSurfaceView", this.mBuilder.toString());
      StringBuilder localStringBuilder = this.mBuilder;
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public void close()
  {
    flushBuilder();
  }
  
  public void flush()
  {
    flushBuilder();
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        flushBuilder();
      } else {
        this.mBuilder.append(c);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView.LogWriter
 * JD-Core Version:    0.7.0.1
 */