package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

class Dns$1
  implements Dns
{
  public List<InetAddress> lookup(String paramString)
  {
    if (paramString != null) {
      try
      {
        List localList = Arrays.asList(InetAddress.getAllByName(paramString));
        return localList;
      }
      catch (NullPointerException localNullPointerException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Broken system behaviour for dns lookup of ");
        localStringBuilder.append(paramString);
        paramString = new UnknownHostException(localStringBuilder.toString());
        paramString.initCause(localNullPointerException);
        throw paramString;
      }
    }
    throw new UnknownHostException("hostname == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okhttp3.Dns.1
 * JD-Core Version:    0.7.0.1
 */