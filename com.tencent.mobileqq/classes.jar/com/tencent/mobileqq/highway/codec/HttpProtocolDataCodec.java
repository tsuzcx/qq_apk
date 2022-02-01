package com.tencent.mobileqq.highway.codec;

import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.msf.core.net.MsfHttpResp;
import com.tencent.mobileqq.msf.core.net.MsfHttpRespParse;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.InputStream;
import org.apache.http.StatusLine;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.IdentityInputStream;

public class HttpProtocolDataCodec
  extends TcpProtocolDataCodec
{
  public static final int HTTP_DEFAULT_PORT = 80;
  
  private byte[] createHttpReqData(EndPoint paramEndPoint, byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("POST /cgi-bin/httpconn?htcmd=0x6ff0082 HTTP/1.1\r\nConnection: Keep-Alive\r\nHost: ");
    ((StringBuilder)localObject).append(paramEndPoint.host);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramEndPoint.port);
    ((StringBuilder)localObject).append("\r\nAccept: */*\r\nUser-Agent: javaMsfClient\r\nContent-Type: application/x-www-form-urlencoded\r\nContent-Length: ");
    ((StringBuilder)localObject).append(paramArrayOfByte.length);
    ((StringBuilder)localObject).append("\r\n\r\n");
    paramEndPoint = ((StringBuilder)localObject).toString().getBytes();
    localObject = new byte[paramEndPoint.length + paramArrayOfByte.length];
    System.arraycopy(paramEndPoint, 0, localObject, 0, paramEndPoint.length);
    System.arraycopy(paramArrayOfByte, 0, localObject, paramEndPoint.length, paramArrayOfByte.length);
    return localObject;
  }
  
  public byte[] encodeC2SData(EndPoint paramEndPoint, HwRequest paramHwRequest, byte[] paramArrayOfByte)
  {
    return createHttpReqData(paramEndPoint, super.encodeC2SData(paramEndPoint, paramHwRequest, paramArrayOfByte));
  }
  
  public void onRecvData(MsfSocketInputBuffer paramMsfSocketInputBuffer)
  {
    do
    {
      MsfHttpResp localMsfHttpResp = new MsfHttpRespParse(paramMsfSocketInputBuffer).parse();
      if (MsfHttpRespParse.canResponseHaveBody(localMsfHttpResp)) {
        if (localMsfHttpResp.getContentLen() != -1) {
          localMsfHttpResp.setContent(new ContentLengthInputStream(paramMsfSocketInputBuffer, localMsfHttpResp.getContentLen()));
        } else if (localMsfHttpResp.getTransferEncoding().equalsIgnoreCase("chunked")) {
          localMsfHttpResp.setContent(new ChunkedInputStream(paramMsfSocketInputBuffer));
        } else {
          localMsfHttpResp.setContent(new IdentityInputStream(paramMsfSocketInputBuffer));
        }
      }
      if (localMsfHttpResp.getStatusLine().getStatusCode() >= 200)
      {
        byte[] arrayOfByte2 = new byte[20480];
        byte[] arrayOfByte1 = null;
        for (;;)
        {
          int i = localMsfHttpResp.getContent().read(arrayOfByte2);
          if (i <= 0) {
            break;
          }
          arrayOfByte1 = new byte[i];
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte1.length);
        }
        decodeS2CData(arrayOfByte1);
      }
    } while (paramMsfSocketInputBuffer.hasBufferedData());
  }
  
  public void setProtocolCodecListener(IProtocolCodecListener paramIProtocolCodecListener)
  {
    super.setProtocolCodecListener(paramIProtocolCodecListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.codec.HttpProtocolDataCodec
 * JD-Core Version:    0.7.0.1
 */