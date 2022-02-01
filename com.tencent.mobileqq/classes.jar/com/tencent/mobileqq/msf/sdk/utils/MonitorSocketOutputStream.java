package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.c.k;
import com.tencent.mobileqq.msf.core.net.m;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MonitorSocketOutputStream
  extends OutputStream
{
  private Context context;
  private OutputStream mOutputStream;
  private c monitorSocketImpl;
  private String refer = null;
  private String urlTag = "";
  
  public MonitorSocketOutputStream(OutputStream paramOutputStream, c paramc, Context paramContext)
  {
    this.mOutputStream = paramOutputStream;
    this.monitorSocketImpl = paramc;
    this.context = paramContext;
  }
  
  public static String getMType(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    String str1 = c.k;
    int i = paramInt1;
    int k;
    for (int j = i; i < paramInt2 + paramInt1; j = k)
    {
      int m = i + 1;
      if (m == paramInt2) {
        return str1;
      }
      k = j;
      if (paramArrayOfByte[i] == 13)
      {
        k = j;
        if (paramArrayOfByte[m] == 10)
        {
          String str2 = new String(paramArrayOfByte, j, i - j);
          j = str2.indexOf("mType=");
          if (j == -1)
          {
            k = i + 2;
          }
          else
          {
            paramInt1 = j + 6;
            paramInt2 = str2.indexOf("&", paramInt1);
            if (paramInt2 == -1)
            {
              paramInt2 = str2.indexOf(" ", paramInt1);
              if (paramInt2 == -1) {
                break;
              }
              return str2.substring(paramInt1, paramInt2);
            }
            return str2.substring(paramInt1, paramInt2);
          }
        }
      }
      i = m;
    }
    return str1;
  }
  
  public static String getRefer(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt;
    while (i < paramArrayOfByte.length)
    {
      if ((paramArrayOfByte[i] == 13) && (paramArrayOfByte[(i + 1)] == 10))
      {
        localObject1 = new String(paramArrayOfByte, paramInt, i - paramInt).trim().split(" ");
        if (localObject1.length == 2)
        {
          localObject1 = localObject1[0];
          break label75;
        }
        localObject1 = "";
        break label75;
      }
      i += 1;
    }
    Object localObject1 = null;
    label75:
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      i = paramArrayOfByte.length - 1;
      for (;;)
      {
        localObject2 = localObject1;
        if (i < paramInt) {
          break;
        }
        if (paramArrayOfByte[i] == 32)
        {
          localObject1 = new String(paramArrayOfByte, paramInt, i - paramInt);
          localObject2 = ((String)localObject1).trim().split(" ");
          if (localObject2.length == 2) {
            localObject1 = localObject2[0];
          }
        }
        i -= 1;
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new String(paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt);
    }
    if (((String)localObject1).length() > 100) {
      return ((String)localObject1).substring(0, 42);
    }
    return localObject1;
  }
  
  private void initKnownMType()
  {
    if ((!this.monitorSocketImpl.f.contains("beacon")) && (!this.monitorSocketImpl.f.contains("feedback")))
    {
      if (this.monitorSocketImpl.f.contains("map"))
      {
        this.monitorSocketImpl.j = "Map";
        return;
      }
      if ((!this.monitorSocketImpl.f.toLowerCase().contains("tmassistant")) && (!this.monitorSocketImpl.f.contains("apkupdate")))
      {
        if (this.monitorSocketImpl.f.contains("smtt"))
        {
          this.monitorSocketImpl.j = "Web";
          return;
        }
        if (this.monitorSocketImpl.f.contains("readinjoy"))
        {
          this.monitorSocketImpl.j = "Readinjoy";
          return;
        }
        if ((!this.monitorSocketImpl.f.contains("biz")) && (!this.monitorSocketImpl.f.contains("troop")))
        {
          if ((this.monitorSocketImpl.f.contains("highway")) && (TextUtils.isEmpty(this.refer)))
          {
            this.monitorSocketImpl.j = "highway";
            return;
          }
          if (!TextUtils.isEmpty(this.refer))
          {
            if (this.refer.contains("beacon"))
            {
              this.monitorSocketImpl.j = "beacon";
              this.refer = "/mType=beacon";
              return;
            }
            if (this.refer.contains("mstat/report"))
            {
              this.monitorSocketImpl.j = "MTA";
              return;
            }
            if (this.refer.contains("comdata")) {
              this.monitorSocketImpl.j = "comdata";
            }
          }
        }
        else
        {
          this.monitorSocketImpl.j = "AppDepart";
        }
      }
      else
      {
        this.monitorSocketImpl.j = "yingyongbao";
      }
    }
    else
    {
      this.monitorSocketImpl.j = "beacon";
    }
  }
  
  public void close()
  {
    this.mOutputStream.close();
  }
  
  public void flush()
  {
    this.mOutputStream.flush();
  }
  
  public void getSocketInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.monitorSocketImpl.j = c.k;
    MonitorHttpInfo localMonitorHttpInfo = new MonitorHttpInfo();
    for (;;)
    {
      try
      {
        localObject = new byte[4];
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, localObject.length);
        bool = new String((byte[])localObject).equals("POST");
        if (bool)
        {
          this.refer = getRefer(paramArrayOfByte, 5);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("http://");
          ((StringBuilder)localObject).append(this.monitorSocketImpl.b);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append(this.monitorSocketImpl.c);
          ((StringBuilder)localObject).append(this.refer);
          this.urlTag = ((StringBuilder)localObject).toString();
          localMonitorHttpInfo.setMethod("POST");
          localMonitorHttpInfo.setHost(this.monitorSocketImpl.b);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.monitorSocketImpl.c);
          ((StringBuilder)localObject).append("");
          localMonitorHttpInfo.setPort(((StringBuilder)localObject).toString());
          localMonitorHttpInfo.setUrl(this.refer);
        }
        else
        {
          if (!new String((byte[])localObject).equals("GET ")) {
            break label898;
          }
          this.refer = getRefer(paramArrayOfByte, 4);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("http://");
          ((StringBuilder)localObject).append(this.monitorSocketImpl.b);
          ((StringBuilder)localObject).append(":");
          ((StringBuilder)localObject).append(this.monitorSocketImpl.c);
          ((StringBuilder)localObject).append(this.refer);
          this.urlTag = ((StringBuilder)localObject).toString();
          localMonitorHttpInfo.setMethod("GET");
          localMonitorHttpInfo.setHost(this.monitorSocketImpl.b);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.monitorSocketImpl.c);
          ((StringBuilder)localObject).append("");
          localMonitorHttpInfo.setPort(((StringBuilder)localObject).toString());
          localMonitorHttpInfo.setUrl(this.refer);
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject;
        boolean bool;
        int j;
        int k;
        c localc;
        if (!QLog.isColorLevel()) {
          break label891;
        }
        QLog.d("MSF.D.MonitorSocket", 2, "getSocketInfo exception!", paramArrayOfByte);
      }
      if (i != 0)
      {
        localObject = new String(paramArrayOfByte, paramInt1, paramInt2);
        bool = QLog.isColorLevel();
        if (bool)
        {
          j = ((String)localObject).indexOf("\r\n");
          if (j > 0) {
            QLog.d("MSF.D.MonitorSocket", 2, ((String)localObject).substring(0, j));
          }
        }
        j = ((String)localObject).indexOf("Host: ");
        if (j >= 0)
        {
          k = ((String)localObject).indexOf("\r\n", j);
          this.monitorSocketImpl.a = ((String)localObject).substring(j + 6, k);
          localMonitorHttpInfo.setHost(this.monitorSocketImpl.a);
        }
        this.monitorSocketImpl.j = getMType(paramArrayOfByte, paramInt1, paramInt2);
      }
      bool = this.monitorSocketImpl.j.equals(c.k);
      if ((bool) || (this.monitorSocketImpl.j.equals("Other")) || (this.monitorSocketImpl.j.contains("beacon?"))) {
        initKnownMType();
      }
      if (((this.monitorSocketImpl.j.equals(c.k)) || (this.monitorSocketImpl.j.equals("Other"))) && (!TextUtils.isEmpty(this.refer)))
      {
        j = this.refer.indexOf("?");
        if (j > 0) {
          this.monitorSocketImpl.j = this.refer.substring(0, j);
        } else if (this.refer.length() < 20) {
          this.monitorSocketImpl.j = this.refer;
        }
      }
      if ((i != 0) && (this.monitorSocketImpl.j.equals(c.k))) {
        if (this.monitorSocketImpl.a.contains(".qq.com")) {
          this.monitorSocketImpl.j = this.monitorSocketImpl.a.substring(0, this.monitorSocketImpl.a.indexOf(".qq.com"));
        } else if ((this.monitorSocketImpl.a.contains(".com")) || (this.monitorSocketImpl.a.contains(".cn"))) {
          this.monitorSocketImpl.j = this.monitorSocketImpl.a;
        }
      }
      if (i != 0)
      {
        localObject = new StringBuilder();
        localc = this.monitorSocketImpl;
        ((StringBuilder)localObject).append(localc.a);
        ((StringBuilder)localObject).append(this.refer);
        localc.a = ((StringBuilder)localObject).toString();
        try
        {
          localMonitorHttpInfo.setType(this.monitorSocketImpl.j);
          localObject = new byte[paramInt2];
          System.arraycopy(paramArrayOfByte, paramInt1, localObject, 0, paramInt2);
          localMonitorHttpInfo.setRequestBuffer((byte[])localObject);
          this.monitorSocketImpl.g = localMonitorHttpInfo;
          return;
        }
        catch (Throwable paramArrayOfByte)
        {
          if (!QLog.isColorLevel()) {
            break label891;
          }
        }
        QLog.d("MSF.D.MonitorSocket", 2, "array copy exception!", paramArrayOfByte);
        return;
      }
      label891:
      return;
      int i = 1;
      continue;
      label898:
      i = 0;
    }
  }
  
  public int hashCode()
  {
    return this.mOutputStream.hashCode();
  }
  
  public void write(int paramInt)
  {
    this.mOutputStream.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.mOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
    if (MonitorSocketImplFactory.isServerSocket(toString())) {
      return;
    }
    try
    {
      Object localObject = this.monitorSocketImpl.d;
      int j;
      if ((localObject != null) && (this.monitorSocketImpl.d.contains(":MSF"))) {
        j = NetConnInfoCenter.getSystemNetworkType();
      } else {
        j = AppNetConnInfo.getSystemNetworkType();
      }
      int i = j;
      if (j == 0)
      {
        localObject = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        i = j;
        if (localObject != null)
        {
          j = ((NetworkInfo)localObject).getType();
          if (j == 1)
          {
            i = 2;
          }
          else
          {
            i = j;
            if (MonitorSocketImplFactory.isNetworkTypeMobile(j) == true) {
              i = 1;
            }
          }
        }
      }
      if (this.monitorSocketImpl.j == null) {
        getSocketInfo(paramArrayOfByte, paramInt1, paramInt2);
      }
      localObject = null;
      if ((this.monitorSocketImpl.d != null) && (this.monitorSocketImpl.d.contains(":MSF")))
      {
        if (m.q.contains(toString()))
        {
          paramArrayOfByte = (byte[])localObject;
        }
        else
        {
          boolean bool = BaseApplication.exclusiveStreamList.contains(toString());
          if (bool)
          {
            paramArrayOfByte = (byte[])localObject;
            if (QLog.isColorLevel())
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("|");
              paramArrayOfByte.append(this.monitorSocketImpl.e);
              paramArrayOfByte.append("|write|");
              paramArrayOfByte.append(paramInt2);
              paramArrayOfByte.append("|");
              paramArrayOfByte.append(i);
              paramArrayOfByte.append("|BigData|");
              paramArrayOfByte.append(BaseApplication.monitor.getSTATUS());
              QLog.d("MSF.D.MonitorSocket", 2, paramArrayOfByte.toString());
              paramArrayOfByte = (byte[])localObject;
            }
          }
          else if (k.g.contains(toString()))
          {
            paramArrayOfByte = this.monitorSocketImpl;
            localObject = (b)c.o.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
            if (localObject == null)
            {
              localObject = new b(this.monitorSocketImpl.b, null, this.monitorSocketImpl.c, c.l, paramInt2, i);
              ((b)localObject).h = "QualityTest";
              ((b)localObject).i = BaseApplication.monitor.getSTATUS();
              ((b)localObject).j = this.monitorSocketImpl.e.hashCode();
              paramArrayOfByte = this.monitorSocketImpl;
              c.o.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localObject);
            }
            else
            {
              paramArrayOfByte = this.monitorSocketImpl;
              c.o.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), ((b)localObject).a(paramInt2));
            }
            if (((b)localObject).l == null) {
              this.monitorSocketImpl.a(((b)localObject).j, c.l);
            }
            paramArrayOfByte = (byte[])localObject;
            if (QLog.isColorLevel())
            {
              paramArrayOfByte = new StringBuilder();
              paramArrayOfByte.append("|");
              paramArrayOfByte.append(this.monitorSocketImpl.e);
              paramArrayOfByte.append("|write|");
              paramArrayOfByte.append(paramInt2);
              paramArrayOfByte.append("|");
              paramArrayOfByte.append(i);
              paramArrayOfByte.append("|");
              paramArrayOfByte.append("QualityTest.PushList");
              paramArrayOfByte.append("|");
              paramArrayOfByte.append(BaseApplication.monitor.getSTATUS());
              QLog.d("MSF.D.MonitorSocket", 2, paramArrayOfByte.toString());
              paramArrayOfByte = (byte[])localObject;
            }
          }
          else
          {
            paramArrayOfByte = this.monitorSocketImpl;
            localObject = (b)c.o.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
            if (localObject == null)
            {
              localObject = new b(this.monitorSocketImpl.b, null, this.monitorSocketImpl.c, c.l, paramInt2, i);
              ((b)localObject).i = BaseApplication.monitor.getSTATUS();
              ((b)localObject).h = this.monitorSocketImpl.j;
              ((b)localObject).j = this.monitorSocketImpl.e.hashCode();
              paramArrayOfByte = this.monitorSocketImpl;
              c.o.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localObject);
            }
            else
            {
              paramArrayOfByte = this.monitorSocketImpl;
              c.o.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), ((b)localObject).a(paramInt2));
            }
            paramArrayOfByte = (byte[])localObject;
            if (((b)localObject).l == null)
            {
              this.monitorSocketImpl.a(((b)localObject).j, c.l);
              paramArrayOfByte = (byte[])localObject;
            }
          }
        }
      }
      else
      {
        paramArrayOfByte = (byte[])localObject;
        if (this.monitorSocketImpl.j != null)
        {
          paramArrayOfByte = this.monitorSocketImpl;
          paramArrayOfByte = (b)c.o.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
          if (paramArrayOfByte == null)
          {
            localObject = new b(this.monitorSocketImpl.b, this.monitorSocketImpl.a, this.monitorSocketImpl.c, c.l, paramInt2, i);
            ((b)localObject).h = this.monitorSocketImpl.j;
            ((b)localObject).j = this.monitorSocketImpl.e.hashCode();
            paramArrayOfByte = this.monitorSocketImpl;
            c.o.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localObject);
          }
          else
          {
            localObject = paramArrayOfByte.a(paramInt2);
            ((b)localObject).h = this.monitorSocketImpl.j;
          }
          ((b)localObject).i = BaseApplication.monitor.getSTATUS();
          paramArrayOfByte = (byte[])localObject;
          if (((b)localObject).l == null)
          {
            this.monitorSocketImpl.a(((b)localObject).j, c.l);
            paramArrayOfByte = (byte[])localObject;
          }
        }
      }
      if (paramArrayOfByte == null) {
        break label1074;
      }
      paramArrayOfByte.a = this.monitorSocketImpl.d;
      paramArrayOfByte.k = System.currentTimeMillis();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.d("MSF.D.MonitorSocket", 1, "analyze netflow failed.", paramArrayOfByte);
      return;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      label1053:
      break label1053;
    }
    QLog.d("MSF.D.MonitorSocket", 1, "write OOM.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketOutputStream
 * JD-Core Version:    0.7.0.1
 */