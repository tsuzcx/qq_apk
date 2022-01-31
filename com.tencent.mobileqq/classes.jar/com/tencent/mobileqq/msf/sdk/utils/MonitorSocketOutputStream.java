package com.tencent.mobileqq.msf.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.net.c.g;
import com.tencent.mobileqq.msf.core.net.l;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class MonitorSocketOutputStream
  extends OutputStream
{
  private Context context;
  private OutputStream mOutputStream;
  private c monitorSocketImpl;
  private String refer;
  private String urlTag = "";
  
  public MonitorSocketOutputStream(OutputStream paramOutputStream, c paramc, Context paramContext)
  {
    this.mOutputStream = paramOutputStream;
    this.monitorSocketImpl = paramc;
    this.context = paramContext;
  }
  
  public static String getMType(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    String str1 = c.j;
    int i = paramInt1;
    int j = paramInt1;
    if ((i >= paramInt2 + paramInt1) || (i + 1 == paramInt2)) {}
    String str2;
    label100:
    do
    {
      return str1;
      int k = j;
      if (paramArrayOfByte[i] == 13)
      {
        k = j;
        if (paramArrayOfByte[(i + 1)] == 10)
        {
          str2 = new String(paramArrayOfByte, j, i - j);
          j = str2.indexOf("mType=");
          if (j != -1) {
            break label100;
          }
          k = i + 2;
        }
      }
      i += 1;
      j = k;
      break;
      paramInt1 = str2.indexOf("&", j + 6);
      if (paramInt1 != -1) {
        break label148;
      }
      paramInt1 = str2.indexOf(" ", j + 6);
    } while (paramInt1 == -1);
    return str2.substring(j + 6, paramInt1);
    label148:
    return str2.substring(j + 6, paramInt1);
  }
  
  public static String getRefer(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt;
    Object localObject1;
    if (i < paramArrayOfByte.length) {
      if ((paramArrayOfByte[i] == 13) && (paramArrayOfByte[(i + 1)] == 10))
      {
        localObject1 = new String(paramArrayOfByte, paramInt, i - paramInt).trim().split(" ");
        if (localObject1.length == 2) {
          localObject1 = localObject1[0];
        }
      }
    }
    for (;;)
    {
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
        localObject1 = "";
        continue;
        i += 1;
        break;
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new String(paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt);
      }
      paramArrayOfByte = (byte[])localObject1;
      if (((String)localObject1).length() > 100) {
        paramArrayOfByte = ((String)localObject1).substring(0, 42);
      }
      return paramArrayOfByte;
      localObject1 = null;
    }
  }
  
  private void initKnownMType()
  {
    if ((this.monitorSocketImpl.f.contains("beacon")) || (this.monitorSocketImpl.f.contains("feedback"))) {
      this.monitorSocketImpl.i = "beacon";
    }
    do
    {
      do
      {
        return;
        if (this.monitorSocketImpl.f.contains("map"))
        {
          this.monitorSocketImpl.i = "Map";
          return;
        }
        if ((this.monitorSocketImpl.f.toLowerCase().contains("tmassistant")) || (this.monitorSocketImpl.f.contains("apkupdate")))
        {
          this.monitorSocketImpl.i = "yingyongbao";
          return;
        }
        if (this.monitorSocketImpl.f.contains("smtt"))
        {
          this.monitorSocketImpl.i = "Web";
          return;
        }
        if (this.monitorSocketImpl.f.contains("readinjoy"))
        {
          this.monitorSocketImpl.i = "Readinjoy";
          return;
        }
        if ((this.monitorSocketImpl.f.contains("biz")) || (this.monitorSocketImpl.f.contains("troop")))
        {
          this.monitorSocketImpl.i = "AppDepart";
          return;
        }
        if ((this.monitorSocketImpl.f.contains("highway")) && (TextUtils.isEmpty(this.refer)))
        {
          this.monitorSocketImpl.i = "highway";
          return;
        }
      } while (TextUtils.isEmpty(this.refer));
      if (this.refer.contains("beacon"))
      {
        this.monitorSocketImpl.i = "beacon";
        this.refer = "/mType=beacon";
        return;
      }
      if (this.refer.contains("mstat/report"))
      {
        this.monitorSocketImpl.i = "MTA";
        return;
      }
    } while (!this.refer.contains("comdata"));
    this.monitorSocketImpl.i = "comdata";
  }
  
  public void close()
    throws IOException
  {
    this.mOutputStream.close();
  }
  
  public void flush()
    throws IOException
  {
    this.mOutputStream.flush();
  }
  
  public void getSocketInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 1;
    this.monitorSocketImpl.i = c.j;
    try
    {
      Object localObject = new byte[4];
      System.arraycopy(paramArrayOfByte, 0, localObject, 0, localObject.length);
      if (new String((byte[])localObject).equals("POST")) {
        this.refer = getRefer(paramArrayOfByte, 5);
      }
      for (this.urlTag = ("http://" + this.monitorSocketImpl.b + ":" + this.monitorSocketImpl.c + this.refer);; this.urlTag = ("http://" + this.monitorSocketImpl.b + ":" + this.monitorSocketImpl.c + this.refer))
      {
        if (i != 0)
        {
          localObject = new String(paramArrayOfByte, paramInt1, paramInt2);
          if ((localObject != null) && (QLog.isColorLevel()))
          {
            j = ((String)localObject).indexOf("\r\n");
            if (j > 0) {
              QLog.d("MSF.D.MonitorSocket", 2, ((String)localObject).substring(0, j));
            }
          }
          int j = ((String)localObject).indexOf("Host: ");
          if (j >= 0)
          {
            int k = ((String)localObject).indexOf("\r\n", j);
            this.monitorSocketImpl.a = ((String)localObject).substring(j + "Host: ".length(), k);
          }
          this.monitorSocketImpl.i = getMType(paramArrayOfByte, paramInt1, paramInt2);
        }
        if ((this.monitorSocketImpl.i.equals(c.j)) || (this.monitorSocketImpl.i.equals("Other")) || (this.monitorSocketImpl.i.contains("beacon?"))) {
          initKnownMType();
        }
        if (((this.monitorSocketImpl.i.equals(c.j)) || (this.monitorSocketImpl.i.equals("Other"))) && (!TextUtils.isEmpty(this.refer)))
        {
          paramInt1 = this.refer.indexOf("?");
          if (paramInt1 <= 0) {
            break;
          }
          this.monitorSocketImpl.i = this.refer.substring(0, paramInt1);
        }
        if ((i != 0) && (this.monitorSocketImpl.i.equals(c.j)))
        {
          if (!this.monitorSocketImpl.a.contains(".qq.com")) {
            break label576;
          }
          this.monitorSocketImpl.i = this.monitorSocketImpl.a.substring(0, this.monitorSocketImpl.a.indexOf(".qq.com"));
        }
        if (i == 0) {
          return;
        }
        paramArrayOfByte = new StringBuilder();
        localObject = this.monitorSocketImpl;
        ((c)localObject).a += this.refer;
        return;
        if (!new String((byte[])localObject).equals("GET ")) {
          break label623;
        }
        this.refer = getRefer(paramArrayOfByte, 4);
      }
    }
    catch (Exception paramArrayOfByte)
    {
      while (QLog.isColorLevel())
      {
        QLog.d("MSF.D.MonitorSocket", 2, "getSocketInfo exception!", paramArrayOfByte);
        return;
        if (this.refer.length() < 20)
        {
          this.monitorSocketImpl.i = this.refer;
          continue;
          label576:
          if ((this.monitorSocketImpl.a.contains(".com")) || (this.monitorSocketImpl.a.contains(".cn")))
          {
            this.monitorSocketImpl.i = this.monitorSocketImpl.a;
            continue;
            label623:
            i = 0;
          }
        }
      }
    }
  }
  
  public int hashCode()
  {
    return this.mOutputStream.hashCode();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.mOutputStream.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int j = 2;
    this.mOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
    if (MonitorSocketImplFactory.isServerSocket(toString())) {
      return;
    }
    label609:
    label1007:
    label1012:
    label1015:
    for (;;)
    {
      int i;
      try
      {
        if ((this.monitorSocketImpl.d != null) && (this.monitorSocketImpl.d.contains(":MSF")))
        {
          i = NetConnInfoCenter.getSystemNetworkType();
          if (i != 0) {
            break label1015;
          }
          localObject = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
          if (localObject == null) {
            break label1015;
          }
          i = ((NetworkInfo)localObject).getType();
          if (i != 1) {
            continue;
          }
          i = j;
          if (this.monitorSocketImpl.i == null) {
            getSocketInfo(paramArrayOfByte, paramInt1, paramInt2);
          }
          if ((this.monitorSocketImpl.d == null) || (!this.monitorSocketImpl.d.contains(":MSF"))) {
            break label807;
          }
          if (!l.n.contains(toString())) {
            continue;
          }
          paramArrayOfByte = null;
          if (paramArrayOfByte == null) {
            break;
          }
          paramArrayOfByte.a = this.monitorSocketImpl.d;
          paramArrayOfByte.k = System.currentTimeMillis();
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "analyze netflow failed.", paramArrayOfByte);
        return;
        i = AppNetConnInfo.getSystemNetworkType();
        continue;
        if (MonitorSocketImplFactory.isNetworkTypeMobile(i) != true) {
          break label1012;
        }
        i = 1;
        continue;
        if (BaseApplication.exclusiveStreamList.contains(toString()))
        {
          if (!QLog.isColorLevel()) {
            break label1007;
          }
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.e + "|write|" + paramInt2 + "|" + i + "|BigData|" + BaseApplication.monitor.getSTATUS());
          paramArrayOfByte = null;
          continue;
        }
        if (!g.g.contains(toString())) {
          break label609;
        }
        paramArrayOfByte = this.monitorSocketImpl;
        localObject = (b)c.n.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
        if (localObject == null)
        {
          localObject = new b(this.monitorSocketImpl.b, null, this.monitorSocketImpl.c, c.k, paramInt2, i);
          ((b)localObject).h = "QualityTest";
          ((b)localObject).i = BaseApplication.monitor.getSTATUS();
          ((b)localObject).j = this.monitorSocketImpl.e.hashCode();
          paramArrayOfByte = this.monitorSocketImpl;
          c.n.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localObject);
          if (((b)localObject).l == null) {
            this.monitorSocketImpl.a(((b)localObject).j, c.k);
          }
          paramArrayOfByte = (byte[])localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MSF.D.MonitorSocket", 2, "|" + this.monitorSocketImpl.e + "|write|" + paramInt2 + "|" + i + "|" + "QualityTest.PushList" + "|" + BaseApplication.monitor.getSTATUS());
          paramArrayOfByte = (byte[])localObject;
          continue;
        }
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "write OOM.");
        return;
      }
      paramArrayOfByte = this.monitorSocketImpl;
      c.n.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), ((b)localObject).a(paramInt2));
      continue;
      paramArrayOfByte = this.monitorSocketImpl;
      Object localObject = (b)c.n.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
      if (localObject == null)
      {
        localObject = new b(this.monitorSocketImpl.b, null, this.monitorSocketImpl.c, c.k, paramInt2, i);
        ((b)localObject).i = BaseApplication.monitor.getSTATUS();
        ((b)localObject).h = this.monitorSocketImpl.i;
        ((b)localObject).j = this.monitorSocketImpl.e.hashCode();
        paramArrayOfByte = this.monitorSocketImpl;
        c.n.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localObject);
      }
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject;
        if (((b)localObject).l != null) {
          break;
        }
        this.monitorSocketImpl.a(((b)localObject).j, c.k);
        paramArrayOfByte = (byte[])localObject;
        break;
        paramArrayOfByte = this.monitorSocketImpl;
        c.n.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), ((b)localObject).a(paramInt2));
      }
      if (this.monitorSocketImpl.i != null)
      {
        paramArrayOfByte = this.monitorSocketImpl;
        paramArrayOfByte = (b)c.n.get(Integer.valueOf(this.monitorSocketImpl.e.hashCode()));
        if (paramArrayOfByte == null)
        {
          localObject = new b(this.monitorSocketImpl.b, this.monitorSocketImpl.a, this.monitorSocketImpl.c, c.k, paramInt2, i);
          ((b)localObject).h = this.monitorSocketImpl.i;
          ((b)localObject).j = this.monitorSocketImpl.e.hashCode();
          paramArrayOfByte = this.monitorSocketImpl;
          c.n.put(Integer.valueOf(this.monitorSocketImpl.e.hashCode()), localObject);
        }
        for (;;)
        {
          ((b)localObject).i = BaseApplication.monitor.getSTATUS();
          paramArrayOfByte = (byte[])localObject;
          if (((b)localObject).l != null) {
            break;
          }
          this.monitorSocketImpl.a(((b)localObject).j, c.k);
          paramArrayOfByte = (byte[])localObject;
          break;
          localObject = paramArrayOfByte.a(paramInt2);
          ((b)localObject).h = this.monitorSocketImpl.i;
        }
      }
      paramArrayOfByte = null;
      continue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketOutputStream
 * JD-Core Version:    0.7.0.1
 */