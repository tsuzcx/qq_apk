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
    if (paramString == null) {
      throw new UnknownHostException("hostname == null");
    }
    try
    {
      List localList = Arrays.asList(InetAddress.getAllByName(paramString));
      return localList;
    }
    catch (NullPointerException localNullPointerException)
    {
      paramString = new UnknownHostException("Broken system behaviour for dns lookup of " + paramString);
      paramString.initCause(localNullPointerException);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.Dns.1
 * JD-Core Version:    0.7.0.1
 */