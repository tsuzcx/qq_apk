package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.aj;
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
    this.a.sender.i();
  }
  
  public void a(MsfSocketInputBuffer paramMsfSocketInputBuffer, int paramInt)
  {
    Object localObject2 = new MsfHttpRespParse(paramMsfSocketInputBuffer).parse();
    if (MsfHttpRespParse.canResponseHaveBody((MsfHttpResp)localObject2))
    {
      if (((MsfHttpResp)localObject2).getContentLen() == -1) {
        break label104;
      }
      ((MsfHttpResp)localObject2).setContent(new ContentLengthInputStream(paramMsfSocketInputBuffer, ((MsfHttpResp)localObject2).getContentLen()));
    }
    for (;;)
    {
      i = ((MsfHttpResp)localObject2).getStatusLine().getStatusCode();
      if (i >= 200) {
        break;
      }
      if (i == 100) {
        break label287;
      }
      throw new ProtocolException("Unexpected response: " + ((MsfHttpResp)localObject2).getStatusLine());
      label104:
      if (((MsfHttpResp)localObject2).getTransferEncoding().equalsIgnoreCase("chunked")) {
        ((MsfHttpResp)localObject2).setContent(new ChunkedInputStream(paramMsfSocketInputBuffer));
      } else {
        ((MsfHttpResp)localObject2).setContent(new IdentityInputStream(paramMsfSocketInputBuffer));
      }
    }
    byte[] arrayOfByte1 = new byte[20480];
    Object localObject1 = new ArrayList();
    int i = 0;
    for (;;)
    {
      int k = ((MsfHttpResp)localObject2).getContent().read(arrayOfByte1);
      if (k <= 0) {
        break;
      }
      int j = i + k;
      byte[] arrayOfByte2 = new byte[k];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
      ((ArrayList)localObject1).add(arrayOfByte2);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.NetConnTag", 2, " read " + arrayOfByte2.length);
        i = j;
      }
    }
    if (((ArrayList)localObject1).size() == 1) {
      this.a.sender.a((byte[])((ArrayList)localObject1).get(0), paramInt);
    }
    label287:
    while (!paramMsfSocketInputBuffer.hasBufferedData())
    {
      return;
      localObject2 = new byte[i];
      localObject1 = ((ArrayList)localObject1).iterator();
      for (i = 0; ((Iterator)localObject1).hasNext(); i = arrayOfByte1.length + i)
      {
        arrayOfByte1 = (byte[])((Iterator)localObject1).next();
        System.arraycopy(arrayOfByte1, 0, localObject2, i, arrayOfByte1.length);
      }
      this.a.sender.a((byte[])localObject2, paramInt);
    }
  }
  
  public byte[] a(com.tencent.mobileqq.msf.core.d paramd, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, arrayOfByte1.length);
    int k = a(arrayOfByte1);
    if (paramArrayOfByte.length > k)
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int i = 0;
      for (;;)
      {
        int m = i;
        if (paramArrayOfByte.length >= k)
        {
          byte[] arrayOfByte2 = new byte[k];
          System.arraycopy(paramArrayOfByte, j, arrayOfByte2, 0, arrayOfByte2.length);
          byte[] arrayOfByte3 = b(paramd, paramString1, paramString2, arrayOfByte2);
          i += arrayOfByte3.length;
          localArrayList.add(arrayOfByte3);
          j += arrayOfByte2.length;
          if (j >= paramArrayOfByte.length) {
            m = i;
          }
        }
        else
        {
          paramd = new byte[m];
          paramString1 = localArrayList.iterator();
          for (i = 0; paramString1.hasNext(); i = paramString2.length + i)
          {
            paramString2 = (byte[])paramString1.next();
            System.arraycopy(paramString2, 0, paramd, i, paramString2.length);
          }
        }
        System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, arrayOfByte1.length);
        k = a(arrayOfByte1);
      }
      return paramd;
    }
    return b(paramd, paramString1, paramString2, paramArrayOfByte);
  }
  
  protected byte[] b(com.tencent.mobileqq.msf.core.d paramd, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    paramd = ("POST / HTTP/1.1\r\nConnection: Keep-Alive\r\nHost: " + paramd.c() + ":" + paramd.f() + "\r\nAccept: */*\r\nUser-Agent: javaMsfClient\r\nContent-Type: application/x-www-form-urlencoded\r\nContent-Length: " + paramArrayOfByte.length + "\r\n\r\n").getBytes();
    paramString1 = new byte[paramd.length + paramArrayOfByte.length];
    System.arraycopy(paramd, 0, paramString1, 0, paramd.length);
    System.arraycopy(paramArrayOfByte, 0, paramString1, paramd.length, paramArrayOfByte.length);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.c
 * JD-Core Version:    0.7.0.1
 */