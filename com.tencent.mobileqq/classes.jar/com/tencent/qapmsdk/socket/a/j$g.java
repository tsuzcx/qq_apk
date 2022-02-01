package com.tencent.qapmsdk.socket.a;

import com.tencent.qapmsdk.socket.b.b;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.ByteString;

class j$g
  extends j.b
{
  j$g(boolean paramBoolean, com.tencent.qapmsdk.socket.c.a parama)
  {
    super(paramBoolean, parama);
  }
  
  void a(List<b> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (localb.g.utf8().startsWith("content-encoding"))
      {
        if ("gzip".equalsIgnoreCase(localb.h.utf8())) {
          this.g.y = true;
        }
      }
      else if (localb.g.utf8().startsWith("transfer-encoding"))
      {
        if ("chunked".equalsIgnoreCase(localb.h.utf8())) {
          this.g.z = true;
        }
      }
      else if (!localb.g.utf8().startsWith("content-length")) {}
      try
      {
        this.g.A = Long.parseLong(localb.h.utf8());
      }
      catch (Exception localException)
      {
        label143:
        label312:
        break label143;
      }
      break label312;
      if (localb.g.utf8().startsWith("content-type")) {
        this.g.n = com.tencent.qapmsdk.impl.g.a.a(localb.h.utf8());
      } else if (localb.g.utf8().equals(":status")) {
        this.g.C = Integer.decode(localb.h.utf8()).intValue();
      } else if (localb.g.utf8().equals(":method")) {
        this.g.h = localb.h.utf8();
      } else if (localb.g.utf8().equals(":scheme")) {
        this.g.c = localb.h.utf8();
      } else if (localb.g.utf8().equals(":path")) {
        this.g.i = localb.h.utf8();
      }
      if (this.f) {
        this.g.H.put(localb.g.utf8(), localb.h.utf8());
      } else {
        this.g.I.put(localb.g.utf8(), localb.h.utf8());
      }
    }
  }
  
  void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.j.write(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = this.j.toByteArray();
    for (;;)
    {
      Object localObject1 = a(paramArrayOfByte);
      if (localObject1 == null) {
        break;
      }
      if (((String)localObject1).length() == 0)
      {
        this.h = true;
        return;
      }
      Object localObject2;
      if (((String)localObject1).startsWith("Content-Encoding:"))
      {
        if ("gzip".equalsIgnoreCase(((String)localObject1).substring(17, ((String)localObject1).length()).trim())) {
          this.g.y = true;
        }
      }
      else if (((String)localObject1).startsWith("Transfer-Encoding:"))
      {
        if ("chunked".equalsIgnoreCase(((String)localObject1).substring(18, ((String)localObject1).length()).trim())) {
          this.g.z = true;
        }
      }
      else if (((String)localObject1).startsWith("Content-Length:")) {
        localObject2 = ((String)localObject1).substring(15, ((String)localObject1).length()).trim();
      }
      try
      {
        this.g.A = Long.parseLong((String)localObject2);
      }
      catch (Exception localException)
      {
        label174:
        break label174;
      }
      break label277;
      if (((String)localObject1).startsWith("Content-Type:"))
      {
        localObject2 = ((String)localObject1).substring(13, ((String)localObject1).length()).trim();
        this.g.n = com.tencent.qapmsdk.impl.g.a.a((String)localObject2);
      }
      else if ((this.g.g != null) && (((String)localObject1).startsWith(this.g.g)))
      {
        localObject2 = ((String)localObject1).split(" ");
        if (localObject2.length > 2) {
          this.g.C = Integer.decode(localObject2[1]).intValue();
        }
      }
      label277:
      localObject1 = ((String)localObject1).split(":");
      if (localObject1.length == 2) {
        if (this.f) {
          this.g.H.put(localObject1[0].trim(), localObject1[1].trim());
        } else {
          this.g.I.put(localObject1[0].trim(), localObject1[1].trim());
        }
      }
    }
  }
  
  byte[] a()
  {
    byte[] arrayOfByte1 = this.j.toByteArray();
    byte[] arrayOfByte2 = new byte[this.i];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.a.j.g
 * JD-Core Version:    0.7.0.1
 */