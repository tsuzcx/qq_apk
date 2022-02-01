package com.tencent.mobileqq.tts.data;

import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import javax.net.ssl.HttpsURLConnection;

public class ConnectionInputStreamWrapper
  extends InputStream
{
  private final HttpsURLConnection a;
  private final InputStream b;
  
  public ConnectionInputStreamWrapper(HttpsURLConnection paramHttpsURLConnection, InputStream paramInputStream)
  {
    this.a = paramHttpsURLConnection;
    this.b = paramInputStream;
  }
  
  public void close()
  {
    super.close();
    this.a.disconnect();
    QLog.d("ConnectionInputStream", 1, new Object[] { "[close] connection disconnect.", this.a });
  }
  
  public int read()
  {
    return this.b.read();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tts.data.ConnectionInputStreamWrapper
 * JD-Core Version:    0.7.0.1
 */