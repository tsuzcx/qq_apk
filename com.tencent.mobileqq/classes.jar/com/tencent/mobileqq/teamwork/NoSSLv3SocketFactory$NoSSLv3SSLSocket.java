package com.tencent.mobileqq.teamwork;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

class NoSSLv3SocketFactory$NoSSLv3SSLSocket
  extends NoSSLv3SocketFactory.DelegateSSLSocket
{
  private NoSSLv3SocketFactory$NoSSLv3SSLSocket(NoSSLv3SocketFactory paramNoSSLv3SocketFactory, SSLSocket paramSSLSocket)
  {
    super(paramNoSSLv3SocketFactory, paramSSLSocket);
  }
  
  public void setEnabledProtocols(String[] paramArrayOfString)
  {
    Object localObject = paramArrayOfString;
    if (paramArrayOfString != null)
    {
      localObject = paramArrayOfString;
      if (paramArrayOfString.length == 1)
      {
        localObject = paramArrayOfString;
        if ("SSLv3".equals(paramArrayOfString[0]))
        {
          paramArrayOfString = new ArrayList(Arrays.asList(this.a.getEnabledProtocols()));
          if (paramArrayOfString.size() > 1)
          {
            paramArrayOfString.remove("SSLv3");
            QLog.i("setEnabledProtocols", 1, "Removed SSLv3 from enabled protocols");
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("SSL stuck with protocol available for ");
            ((StringBuilder)localObject).append(String.valueOf(paramArrayOfString));
            QLog.i("setEnabledProtocols", 1, ((StringBuilder)localObject).toString());
          }
          localObject = (String[])paramArrayOfString.toArray(new String[paramArrayOfString.size()]);
        }
      }
    }
    if (localObject != null) {
      super.setEnabledProtocols((String[])localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.NoSSLv3SocketFactory.NoSSLv3SSLSocket
 * JD-Core Version:    0.7.0.1
 */