package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.ProtocolException;
import org.apache.http.StatusLine;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.IdentityInputStream;

public class c
  implements d
{
  MsfCore a;
  
  public c(MsfCore paramMsfCore)
  {
    this.a = paramMsfCore;
  }
  
  protected int a(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
    localByteBuffer.put(paramArrayOfByte).flip();
    return localByteBuffer.getInt();
  }
  
  public void a()
  {
    this.a.sender.k();
  }
  
  public void a(MsfSocketInputBuffer paramMsfSocketInputBuffer, int paramInt)
  {
    do
    {
      Object localObject1 = new MsfHttpRespParse(paramMsfSocketInputBuffer).parse();
      if (MsfHttpRespParse.canResponseHaveBody((MsfHttpResp)localObject1)) {
        if (((MsfHttpResp)localObject1).getContentLen() != -1) {
          ((MsfHttpResp)localObject1).setContent(new ContentLengthInputStream(paramMsfSocketInputBuffer, ((MsfHttpResp)localObject1).getContentLen()));
        } else if (((MsfHttpResp)localObject1).getTransferEncoding().equalsIgnoreCase("chunked")) {
          ((MsfHttpResp)localObject1).setContent(new ChunkedInputStream(paramMsfSocketInputBuffer));
        } else {
          ((MsfHttpResp)localObject1).setContent(new IdentityInputStream(paramMsfSocketInputBuffer));
        }
      }
      int i = ((MsfHttpResp)localObject1).getStatusLine().getStatusCode();
      if (i < 200)
      {
        if (i != 100)
        {
          paramMsfSocketInputBuffer = new StringBuilder();
          paramMsfSocketInputBuffer.append("Unexpected response: ");
          paramMsfSocketInputBuffer.append(((MsfHttpResp)localObject1).getStatusLine());
          throw new ProtocolException(paramMsfSocketInputBuffer.toString());
        }
      }
      else
      {
        byte[] arrayOfByte1 = new byte[20480];
        Object localObject2 = new ArrayList();
        i = 0;
        for (;;)
        {
          int k = ((MsfHttpResp)localObject1).getContent().read(arrayOfByte1);
          if (k <= 0) {
            break;
          }
          int j = i + k;
          byte[] arrayOfByte2 = new byte[k];
          System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
          ((ArrayList)localObject2).add(arrayOfByte2);
          i = j;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" read ");
            localStringBuilder.append(arrayOfByte2.length);
            QLog.d("MSF.C.NetConnTag", 2, localStringBuilder.toString());
            i = j;
          }
        }
        if (((ArrayList)localObject2).size() == 1)
        {
          this.a.sender.a((byte[])((ArrayList)localObject2).get(0), paramInt);
        }
        else
        {
          localObject1 = new byte[i];
          localObject2 = ((ArrayList)localObject2).iterator();
          i = 0;
          while (((Iterator)localObject2).hasNext())
          {
            arrayOfByte1 = (byte[])((Iterator)localObject2).next();
            System.arraycopy(arrayOfByte1, 0, localObject1, i, arrayOfByte1.length);
            i += arrayOfByte1.length;
          }
          this.a.sender.a((byte[])localObject1, paramInt);
        }
      }
    } while (paramMsfSocketInputBuffer.hasBufferedData());
  }
  
  public byte[] a(com.tencent.mobileqq.msf.core.d paramd, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, arrayOfByte1.length);
    int j = a(arrayOfByte1);
    if (paramArrayOfByte.length > j)
    {
      ArrayList localArrayList = new ArrayList();
      int k = 0;
      int i = 0;
      int m;
      for (;;)
      {
        m = i;
        if (paramArrayOfByte.length < j) {
          break;
        }
        byte[] arrayOfByte2 = new byte[j];
        System.arraycopy(paramArrayOfByte, k, arrayOfByte2, 0, arrayOfByte2.length);
        byte[] arrayOfByte3 = b(paramd, paramString1, paramString2, arrayOfByte2);
        i += arrayOfByte3.length;
        localArrayList.add(arrayOfByte3);
        k += arrayOfByte2.length;
        if (k >= paramArrayOfByte.length)
        {
          m = i;
          break;
        }
        System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, arrayOfByte1.length);
        j = a(arrayOfByte1);
      }
      paramd = new byte[m];
      paramString1 = localArrayList.iterator();
      i = 0;
      while (paramString1.hasNext())
      {
        paramString2 = (byte[])paramString1.next();
        System.arraycopy(paramString2, 0, paramd, i, paramString2.length);
        i += paramString2.length;
      }
      return paramd;
    }
    return b(paramd, paramString1, paramString2, paramArrayOfByte);
  }
  
  protected byte[] b(com.tencent.mobileqq.msf.core.d paramd, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramString1 = new StringBuilder();
    paramString1.append("POST / HTTP/1.1\r\nConnection: Keep-Alive\r\nHost: ");
    paramString1.append(paramd.c());
    paramString1.append(":");
    paramString1.append(paramd.f());
    paramString1.append("\r\nAccept: */*\r\nUser-Agent: javaMsfClient\r\nContent-Type: application/x-www-form-urlencoded\r\nContent-Length: ");
    paramString1.append(paramArrayOfByte.length);
    paramString1.append("\r\n\r\n");
    paramd = paramString1.toString().getBytes();
    paramString1 = new byte[paramd.length + paramArrayOfByte.length];
    System.arraycopy(paramd, 0, paramString1, 0, paramd.length);
    System.arraycopy(paramArrayOfByte, 0, paramString1, paramd.length, paramArrayOfByte.length);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c
 * JD-Core Version:    0.7.0.1
 */