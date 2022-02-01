package com.tencent.mobileqq.msf.core.net.d.b;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.TreeMap;

public class e
  implements Runnable
{
  public static final String a = "FailedReason";
  public static final String b = "Endpoint";
  private static final String d = "UdpCall";
  public final h c;
  private final g e;
  private f f;
  private j g;
  private d h;
  
  public e(g paramg, h paramh)
  {
    this.e = paramg;
    this.c = paramh;
  }
  
  private void a(Map paramMap)
  {
    MsfCore.sCore.statReporter.a("MSF_WN_UdpFailedReason", true, 0L, 0L, paramMap, false, false);
  }
  
  public d a()
  {
    return this.h;
  }
  
  public void a(d paramd)
  {
    this.h = paramd;
  }
  
  public void a(f paramf)
  {
    this.f = paramf;
    this.e.b.a(this);
  }
  
  public void a(j paramj)
  {
    this.g = paramj;
  }
  
  public void run()
  {
    TreeMap localTreeMap = new TreeMap();
    Object localObject = this.h;
    i locali = null;
    int i = 0;
    label445:
    label454:
    label457:
    label486:
    Exception localException2;
    if (localObject == null)
    {
      QLog.e("UdpCall", 1, "[AsyncCall] error: endpointKey is null.");
      localObject = new Exception("EndpointKey is null.");
    }
    else if (this.g == null)
    {
      QLog.e("UdpCall", 1, new Object[] { "[AsyncCall] error: cannot acquire socket. Endpoint info: ", localObject });
      localObject = new Exception("UdpSocket is null.");
    }
    else
    {
      localObject = this.c.a();
      if ((localObject != null) && (((DatagramPacket)localObject).getLength() != 0))
      {
        try
        {
          QLog.d("UdpCall", 1, new Object[] { "[AsyncCall] send udp message. host: ", this.h.c(), "packet length: ", Integer.valueOf(((DatagramPacket)localObject).getLength()), ", socket hash: ", Integer.valueOf(this.g.hashCode()) });
          this.g.send((DatagramPacket)localObject);
          QLog.d("UdpCall", 1, new Object[] { "[AsyncCall] send udp message success. socket hash: ", Integer.valueOf(this.g.hashCode()) });
          localObject = a.c().a();
          DatagramPacket localDatagramPacket = new DatagramPacket((byte[])localObject, localObject.length);
          try
          {
            this.g.receive(localDatagramPacket);
            byte[] arrayOfByte = localDatagramPacket.getData();
            if ((arrayOfByte != null) && (arrayOfByte.length != 0))
            {
              if (localDatagramPacket.getLength() > localObject.length)
              {
                QLog.d("UdpCall", 1, new Object[] { "[AsyncCall] buffer size not enough. data size: ", Integer.valueOf(localDatagramPacket.getLength()), ", buffer size: ", Integer.valueOf(localObject.length) });
                localObject = new Exception("Message truncated");
                a.c().b();
              }
              else
              {
                QLog.d("UdpCall", 1, new Object[] { "[AsyncCall] response data, size:", Integer.valueOf(arrayOfByte.length) });
                locali = new i(localDatagramPacket);
                i = 1;
                localObject = null;
              }
            }
            else
            {
              QLog.d("UdpCall", 1, "[AsyncCall] receive 0.");
              localObject = new Exception("Receive empty message.");
            }
          }
          catch (IOException localIOException1)
          {
            QLog.e("UdpCall", 1, "[AsyncCall] IOException: ", localIOException1);
            break label454;
          }
          catch (PortUnreachableException localPortUnreachableException)
          {
            QLog.e("UdpCall", 1, "[AsyncCall] PortUnreachableException: ", localPortUnreachableException);
          }
          catch (SocketTimeoutException localSocketTimeoutException)
          {
            QLog.e("UdpCall", 1, "[AsyncCall] receive timeout", localSocketTimeoutException);
          }
          QLog.e("UdpCall", 1, "[AsyncCall] uncaught exception: ", localSocketException);
        }
        catch (Exception localException1) {}catch (IOException localIOException2)
        {
          break label445;
        }
        catch (UnknownHostException localUnknownHostException)
        {
          break label457;
        }
        catch (SocketException localSocketException)
        {
          break label486;
        }
        break label516;
        QLog.e("UdpCall", 1, "[AsyncCall] IOException: ", localSocketException);
        break label516;
        QLog.e("UdpCall", 1, "[AsyncCall] UnknownHostException: ", localSocketException);
        localTreeMap.put("Endpoint", this.h.a());
        break label516;
        QLog.e("UdpCall", 1, "[AsyncCall] SocketException: ", localSocketException);
      }
      else
      {
        QLog.e("UdpCall", 1, "[AsyncCall] packet is null.");
        localException2 = new Exception("Packet is null.");
      }
    }
    label516:
    if (i != 0)
    {
      this.f.a(this, locali);
    }
    else
    {
      this.f.a(this, localException2);
      localTreeMap.put("FailedReason", localException2.getMessage());
      a(localTreeMap);
    }
    this.e.b.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.d.b.e
 * JD-Core Version:    0.7.0.1
 */