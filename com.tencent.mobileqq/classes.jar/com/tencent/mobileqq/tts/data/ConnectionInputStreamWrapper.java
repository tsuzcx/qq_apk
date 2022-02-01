package com.tencent.mobileqq.tts.data;

import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import javax.net.ssl.HttpsURLConnection;

public class ConnectionInputStreamWrapper
  extends InputStream
{
  private final InputStream jdField_a_of_type_JavaIoInputStream;
  private final HttpsURLConnection jdField_a_of_type_JavaxNetSslHttpsURLConnection;
  
  public ConnectionInputStreamWrapper(HttpsURLConnection paramHttpsURLConnection, InputStream paramInputStream)
  {
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection = paramHttpsURLConnection;
    this.jdField_a_of_type_JavaIoInputStream = paramInputStream;
  }
  
  public void close()
  {
    super.close();
    this.jdField_a_of_type_JavaxNetSslHttpsURLConnection.disconnect();
    QLog.d("ConnectionInputStream", 1, new Object[] { "[close] connection disconnect.", this.jdField_a_of_type_JavaxNetSslHttpsURLConnection });
  }
  
  public int read()
  {
    return this.jdField_a_of_type_JavaIoInputStream.read();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tts.data.ConnectionInputStreamWrapper
 * JD-Core Version:    0.7.0.1
 */