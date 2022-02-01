package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper.QuicBundle;
import com.tencent.mobileqq.msf.core.quic.a;
import com.tencent.mobileqq.msf.core.quicksend.g;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.util.Random;
import org.apache.http.util.ByteArrayBuffer;

public class f
  implements b
{
  private static final String d = "LightQuicEngine";
  boolean a = false;
  boolean b = false;
  Object c = null;
  private a e = null;
  private long f = -1L;
  private String g;
  private int h;
  private int i = 10000;
  private int j = 10000;
  private String k;
  
  private String a(String paramString, int paramInt)
  {
    Object localObject = new Random(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("r=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(String.valueOf(((Random)localObject).nextInt(100000)));
    localObject = localStringBuilder.toString();
    if (paramString.contains("?"))
    {
      if (paramString.endsWith("?"))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)localObject);
        return localStringBuilder.toString();
      }
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("&");
      paramString.append((String)localObject);
      return paramString.toString();
    }
    paramString = new StringBuilder();
    paramString.append("?");
    paramString.append((String)localObject);
    return paramString.toString();
  }
  
  private int[] a(String paramString)
  {
    BufferedReader localBufferedReader = new BufferedReader(new CharArrayReader(paramString.toCharArray()));
    int m = 0;
    try
    {
      Object localObject;
      do
      {
        for (;;)
        {
          localObject = localBufferedReader.readLine();
          if (localObject == null) {
            break label101;
          }
          if (!((String)localObject).startsWith("Content-Length")) {
            break;
          }
          localObject = ((String)localObject).split(":");
          if ((localObject != null) && (localObject.length == 2)) {
            m = Integer.parseInt(localObject[1].trim());
          }
        }
      } while (!TextUtils.isEmpty((CharSequence)localObject));
      int n = paramString.indexOf("\r\n\r\n");
      n += 4;
      break label103;
      label101:
      n = 0;
      label103:
      localBufferedReader.close();
      return new int[] { m, n };
    }
    finally
    {
      localBufferedReader.close();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(Object paramObject)
  {
    this.c = paramObject;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(String paramString1, int paramInt, String paramString2, g paramg)
  {
    this.g = paramString1;
    this.h = paramInt;
    long l = System.currentTimeMillis();
    this.f = this.e.a();
    this.b = this.e.a(this.f, this.g, this.h, this.i);
    paramg.j = (System.currentTimeMillis() - l);
    paramString1 = new StringBuilder();
    paramString1.append("connect ");
    paramString1.append(this.g);
    paramString1.append(":");
    paramString1.append(this.h);
    paramString1.append(" ");
    paramString1.append(this.b);
    QLog.d("LightQuicEngine", 1, paramString1.toString());
    return this.b;
  }
  
  public byte[] a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, String paramString, g paramg)
  {
    int i5 = paramToServiceMsg.getRequestSsoSeq();
    long l1 = SystemClock.elapsedRealtime();
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("http://");
    paramToServiceMsg.append(this.g);
    paramToServiceMsg.append(":");
    paramToServiceMsg.append(this.h);
    paramToServiceMsg = paramToServiceMsg.toString();
    paramg = new StringBuilder();
    paramg.append(paramToServiceMsg);
    paramg.append(a(paramToServiceMsg, i5));
    this.k = paramg.toString();
    this.k = MsfSdkUtils.insertMtype(paramString, this.k);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("try connect ");
    paramToServiceMsg.append(this.k);
    paramToServiceMsg.append(" timeout:");
    paramToServiceMsg.append(this.i);
    paramToServiceMsg.append(" ssoseq:");
    paramToServiceMsg.append(i5);
    paramToServiceMsg.append(" sendByXG:");
    paramToServiceMsg.append(this.a);
    paramString = paramToServiceMsg.toString();
    paramToServiceMsg = "LightQuicEngine";
    QLog.d("LightQuicEngine", 1, paramString);
    paramString = new StringBuilder();
    paramString.append("/");
    paramg = this.k;
    paramString.append(paramg.substring(paramg.indexOf("?")));
    paramString = paramString.toString();
    paramg = new StringBuffer();
    paramg.append("POST ");
    paramg.append(paramString);
    paramg.append(" HTTP/1.1\r\n");
    paramg.append("User-Agent: aqq\r\n");
    paramg.append("content-type: oct\r\n");
    paramg.append("Connection: Keep-Alive\r\n");
    paramg.append("Accept-Encoding: \r\n");
    paramg.append("Host: ");
    paramg.append(this.g);
    paramg.append("\r\n");
    paramg.append("Content-Length: ");
    paramg.append(paramArrayOfByte.length);
    paramg.append("\r\n\r\n");
    paramg = paramg.toString().getBytes();
    paramString = paramToServiceMsg;
    for (;;)
    {
      try
      {
        m = this.e.a(this.f, paramg, paramg.length, this.j);
        paramString = paramToServiceMsg;
        n = this.e.a(this.f, paramArrayOfByte, paramArrayOfByte.length, this.j);
        paramString = paramToServiceMsg;
        paramArrayOfByte = new StringBuilder();
        paramString = paramToServiceMsg;
        paramArrayOfByte.append("httpSend sendByXG:");
        paramString = paramToServiceMsg;
        paramArrayOfByte.append(this.a);
        paramString = paramToServiceMsg;
        paramArrayOfByte.append(" ssoseq:");
        paramString = paramToServiceMsg;
        paramArrayOfByte.append(i5);
        paramString = paramToServiceMsg;
        paramArrayOfByte.append(" len:");
        paramString = paramToServiceMsg;
        paramArrayOfByte.append(m + n);
        paramString = paramToServiceMsg;
        QLog.d("LightQuicEngine", 1, paramArrayOfByte.toString());
        paramString = paramToServiceMsg;
        paramg = new ByteArrayBuffer(512);
        m = 0;
        i1 = 0;
        n = 0;
        paramString = paramToServiceMsg;
        paramArrayOfByte = this.e.a(this.f, 512, this.j);
        paramString = paramToServiceMsg;
        i3 = paramArrayOfByte.retcode;
        paramString = paramToServiceMsg;
        if (paramArrayOfByte.retcode <= 0)
        {
          paramString = paramToServiceMsg;
          this.b = false;
          i2 = i1;
          i1 = n;
          n = i2;
          i2 = i3;
        }
        else
        {
          paramString = paramToServiceMsg;
          m += paramArrayOfByte.data_len;
          paramString = paramToServiceMsg;
          paramg.append(paramArrayOfByte.data, 0, paramArrayOfByte.data_len);
          paramString = paramToServiceMsg;
          paramArrayOfByte = a(new String(paramg.toByteArray()));
          n = paramArrayOfByte[0];
          i1 = paramArrayOfByte[1];
          if ((n <= 0) || (i1 <= 0)) {
            continue;
          }
          paramString = paramToServiceMsg;
          i4 = n - (paramg.length() - i1);
          paramString = paramToServiceMsg;
          boolean bool = QLog.isColorLevel();
          if (!bool) {
            break label1051;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        int m;
        int n;
        int i1;
        int i4;
        label734:
        long l2;
        paramArrayOfByte = paramString;
        if (QLog.isColorLevel()) {
          QLog.d(paramArrayOfByte, 2, paramToServiceMsg.getMessage(), paramToServiceMsg);
        }
        c();
        paramToServiceMsg.printStackTrace();
        return null;
      }
      try
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("parseHttpHeader contentLen=");
        paramArrayOfByte.append(n);
        paramArrayOfByte.append(" bodyOffset=");
        paramArrayOfByte.append(i1);
        paramArrayOfByte.append(" remainBytes=");
        paramArrayOfByte.append(i4);
        paramArrayOfByte = paramArrayOfByte.toString();
      }
      catch (Exception paramArrayOfByte) {}
      try
      {
        QLog.d(paramToServiceMsg, 2, paramArrayOfByte);
        if (i4 <= 0) {
          break label1082;
        }
        paramArrayOfByte = this.e;
      }
      catch (Exception paramArrayOfByte)
      {
        paramString = paramToServiceMsg;
        paramToServiceMsg = paramArrayOfByte;
        paramArrayOfByte = paramString;
        continue;
        i2 = i3;
        continue;
        continue;
      }
      try
      {
        paramArrayOfByte = paramArrayOfByte.a(this.f, i4, this.j);
        i3 = paramArrayOfByte.retcode;
        if (paramArrayOfByte.retcode <= 0)
        {
          this.b = false;
          break label1054;
        }
        m += paramArrayOfByte.data_len;
        paramg.append(paramArrayOfByte.data, 0, paramArrayOfByte.data_len);
        i2 = i4;
        if (paramArrayOfByte.data_len <= 0) {
          break label1061;
        }
        i2 = i4 - paramArrayOfByte.data_len;
      }
      catch (Exception paramString)
      {
        paramArrayOfByte = paramToServiceMsg;
        paramToServiceMsg = paramString;
      }
    }
    paramArrayOfByte = paramToServiceMsg;
    if (QLog.isDevelopLevel())
    {
      paramString = new byte[i1];
      System.arraycopy(paramg.toByteArray(), 0, paramString, 0, i1);
      paramString = new String(paramString);
      try
      {
        QLog.d(paramArrayOfByte, 2, paramString);
        l2 = SystemClock.elapsedRealtime();
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("httpRecv ssoseq:");
        paramToServiceMsg.append(i5);
        paramToServiceMsg.append(" content_len:");
        paramToServiceMsg.append(n);
        paramToServiceMsg.append(" costtime:");
        paramToServiceMsg.append(l2 - l1);
        paramToServiceMsg.append(" ret=");
        paramToServiceMsg.append(i2);
        paramToServiceMsg.append(" data_len=");
        paramToServiceMsg.append(m);
        QLog.d(paramArrayOfByte, 1, paramToServiceMsg.toString());
        paramToServiceMsg = new byte[n];
        System.arraycopy(paramg.toByteArray(), i1, paramToServiceMsg, 0, n);
        return paramToServiceMsg;
      }
      catch (Exception paramToServiceMsg) {}
      for (;;)
      {
        i2 = i1;
        i1 = n;
        n = i2;
        break;
        label1051:
        break label734;
        label1054:
        label1061:
        do
        {
          i2 = i3;
          break;
        } while (i2 <= 0);
      }
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
  {
    this.b = false;
    this.e.a(this.f);
    this.e.b(this.f);
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.f
 * JD-Core Version:    0.7.0.1
 */