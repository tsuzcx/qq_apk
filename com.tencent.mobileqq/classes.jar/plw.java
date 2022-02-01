import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class plw
{
  public static String a()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
      Object localObject = localInetAddress.getHostAddress();
      return localObject;
    }
    catch (SocketException localSocketException) {}
    return "0.0.0.0";
  }
  
  protected static String a(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
  }
  
  public static String a(Context paramContext)
  {
    Object localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
    {
      if (((NetworkInfo)localObject).getType() != 0) {
        break label104;
      }
      try
      {
        InetAddress localInetAddress;
        do
        {
          paramContext = NetworkInterface.getNetworkInterfaces();
          while (!((Enumeration)localObject).hasMoreElements())
          {
            if (!paramContext.hasMoreElements()) {
              break;
            }
            localObject = ((NetworkInterface)paramContext.nextElement()).getInetAddresses();
          }
          localInetAddress = (InetAddress)((Enumeration)localObject).nextElement();
        } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
        paramContext = localInetAddress.getHostAddress();
        return paramContext;
      }
      catch (SocketException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    label104:
    do
    {
      return null;
      if (((NetworkInfo)localObject).getType() == 1) {
        return a(((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getIpAddress());
      }
    } while (((NetworkInfo)localObject).getType() != 9);
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     plw
 * JD-Core Version:    0.7.0.1
 */