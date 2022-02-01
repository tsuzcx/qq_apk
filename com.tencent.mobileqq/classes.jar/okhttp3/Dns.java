package okhttp3;

import java.net.InetAddress;
import java.util.List;

public abstract interface Dns
{
  public static final Dns SYSTEM = new Dns.1();
  
  public abstract List<InetAddress> lookup(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okhttp3.Dns
 * JD-Core Version:    0.7.0.1
 */