package com.tencent.qapmsdk.socket.handler;

import com.tencent.qapmsdk.impl.util.StringUtil;
import com.tencent.qapmsdk.socket.hpack.Header;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.ByteString;

class TrafficIOStreamHandlerManager$Header
  extends TrafficIOStreamHandlerManager.Data
{
  TrafficIOStreamHandlerManager$Header(boolean paramBoolean, SocketInfo paramSocketInfo)
  {
    super(paramBoolean, paramSocketInfo);
  }
  
  void parse(List<Header> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Header localHeader = (Header)paramList.next();
      if (localHeader.name.utf8().startsWith("content-encoding")) {
        if ("gzip".equalsIgnoreCase(localHeader.value.utf8())) {
          this.socketInfo.gzip = true;
        }
      }
      for (;;)
      {
        if (!this.isOutput) {
          break label350;
        }
        this.socketInfo.requestHeaders.put(localHeader.name.utf8(), localHeader.value.utf8());
        break;
        if (localHeader.name.utf8().startsWith("transfer-encoding"))
        {
          if ("chunked".equalsIgnoreCase(localHeader.value.utf8())) {
            this.socketInfo.chunked = true;
          }
        }
        else if (localHeader.name.utf8().startsWith("content-length")) {
          try
          {
            this.socketInfo.contentLength = Long.parseLong(localHeader.value.utf8());
          }
          catch (Exception localException) {}
        } else if (localHeader.name.utf8().startsWith("content-type")) {
          this.socketInfo.contentType = StringUtil.contentType(localHeader.value.utf8());
        } else if (localHeader.name.utf8().equals(":status")) {
          this.socketInfo.statusCode = Integer.decode(localHeader.value.utf8()).intValue();
        } else if (localHeader.name.utf8().equals(":method")) {
          this.socketInfo.method = localHeader.value.utf8();
        } else if (localHeader.name.utf8().equals(":scheme")) {
          this.socketInfo.protocol = localHeader.value.utf8();
        } else if (localHeader.name.utf8().equals(":path")) {
          this.socketInfo.path = localHeader.value.utf8();
        }
      }
      label350:
      this.socketInfo.responseHeaders.put(localHeader.name.utf8(), localHeader.value.utf8());
    }
  }
  
  void parse(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.baos.write(paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = this.baos.toByteArray();
    for (;;)
    {
      Object localObject1 = readLine(paramArrayOfByte);
      if (localObject1 != null)
      {
        if (((String)localObject1).length() == 0) {
          this.isCompleted = true;
        }
      }
      else {
        return;
      }
      if (((String)localObject1).startsWith("Content-Encoding:")) {
        if ("gzip".equalsIgnoreCase(((String)localObject1).substring("Content-Encoding:".length(), ((String)localObject1).length()).trim())) {
          this.socketInfo.gzip = true;
        }
      }
      for (;;)
      {
        localObject1 = ((String)localObject1).split(":");
        if (localObject1.length != 2) {
          break;
        }
        if (!this.isOutput) {
          break label344;
        }
        this.socketInfo.requestHeaders.put(localObject1[0].trim(), localObject1[1].trim());
        break;
        if (((String)localObject1).startsWith("Transfer-Encoding:"))
        {
          if ("chunked".equalsIgnoreCase(((String)localObject1).substring("Transfer-Encoding:".length(), ((String)localObject1).length()).trim())) {
            this.socketInfo.chunked = true;
          }
        }
        else if (((String)localObject1).startsWith("Content-Length:"))
        {
          String str = ((String)localObject1).substring("Content-Length:".length(), ((String)localObject1).length()).trim();
          try
          {
            this.socketInfo.contentLength = Long.parseLong(str);
          }
          catch (Exception localException) {}
        }
        else
        {
          Object localObject2;
          if (((String)localObject1).startsWith("Content-Type:"))
          {
            localObject2 = ((String)localObject1).substring("Content-Type:".length(), ((String)localObject1).length()).trim();
            this.socketInfo.contentType = StringUtil.contentType((String)localObject2);
          }
          else if ((this.socketInfo.version != null) && (((String)localObject1).startsWith(this.socketInfo.version)))
          {
            localObject2 = ((String)localObject1).split(" ");
            if (localObject2.length > 2) {
              this.socketInfo.statusCode = Integer.decode(localObject2[1]).intValue();
            }
          }
        }
      }
      label344:
      this.socketInfo.responseHeaders.put(localObject1[0].trim(), localObject1[1].trim());
    }
  }
  
  byte[] toByteArray()
  {
    byte[] arrayOfByte1 = this.baos.toByteArray();
    byte[] arrayOfByte2 = new byte[this.offset];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficIOStreamHandlerManager.Header
 * JD-Core Version:    0.7.0.1
 */