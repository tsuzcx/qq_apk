package com.tencent.tkd.topicsdk.imagecompress;

import com.tencent.tkd.topicsdk.framework.TLog;
import java.io.IOException;
import java.io.InputStream;

public abstract class InputStreamAdapter
  implements InputStreamProvider
{
  private InputStream a;
  
  public InputStream a()
  {
    a();
    this.a = b();
    return this.a;
  }
  
  public void a()
  {
    if (this.a != null) {}
    try
    {
      this.a.close();
      return;
    }
    catch (IOException localIOException)
    {
      TLog.d("InputStreamAdapter", localIOException.toString());
      return;
    }
    finally
    {
      this.a = null;
    }
  }
  
  public boolean a()
  {
    String str = a();
    if (str == null) {
      return false;
    }
    return str.toLowerCase().endsWith("gif");
  }
  
  public abstract InputStream b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.InputStreamAdapter
 * JD-Core Version:    0.7.0.1
 */