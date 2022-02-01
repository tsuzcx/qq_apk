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
      this.mBuilder.delete(0, this.mBuilder.length());
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
    if (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        flushBuilder();
      }
      for (;;)
      {
        i += 1;
        break;
        this.mBuilder.append(c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.QGJavaScriptView.LogWriter
 * JD-Core Version:    0.7.0.1
 */