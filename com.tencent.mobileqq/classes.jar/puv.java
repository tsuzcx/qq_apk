import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor.1;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptMonitor.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

public class puv
{
  public static void a()
  {
    Object localObject = tdv.a().a();
    if (localObject != null)
    {
      QLog.d("RIJImageOptMonitor", 1, "executing jobs size: " + ((CopyOnWriteArrayList)localObject).size());
      if (((CopyOnWriteArrayList)localObject).size() > 0)
      {
        localObject = ((CopyOnWriteArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          QLog.d("RIJImageOptMonitor", 1, new Object[] { (tdw)((Iterator)localObject).next() });
        }
      }
    }
  }
  
  public static void a(tdw paramtdw)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new RIJImageOptMonitor.1(paramtdw), puu.a.a());
  }
  
  public static String[] a(String paramString)
  {
    try
    {
      InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(paramString);
      if ((arrayOfInetAddress != null) && (arrayOfInetAddress.length > 0))
      {
        String[] arrayOfString = new String[arrayOfInetAddress.length];
        int i = 0;
        for (;;)
        {
          paramString = arrayOfString;
          if (i >= arrayOfInetAddress.length) {
            break;
          }
          arrayOfString[i] = arrayOfInetAddress[i].getHostAddress();
          i += 1;
        }
        return paramString;
      }
    }
    catch (UnknownHostException paramString)
    {
      QLog.e("RIJImageOptMonitor", 1, paramString.getMessage());
      paramString = null;
    }
    return null;
  }
  
  public static void b(tdw paramtdw)
  {
    ThreadManager.post(new RIJImageOptMonitor.2(paramtdw), 2, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puv
 * JD-Core Version:    0.7.0.1
 */