package com.tencent.qapmsdk.socket.handler;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.TrafficMonitor;
import com.tencent.qapmsdk.socket.TrafficMonitor.TrafficConfig;
import com.tencent.qapmsdk.socket.hpack.Decode;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import com.tencent.qapmsdk.socket.model.Utf8Checker;
import com.tencent.qapmsdk.socket.util.ThreadUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

class TrafficIOStreamHandlerManager$DefaultTrafficOutputStreamHandler
  implements ITrafficOutputStreamHandler
{
  private static final long DELAY_TIME = 500L;
  private static final String TAG = "QAPM_Socket_TrafficOutputStream";
  private boolean canHandlerHttp1;
  private boolean canHandlerHttp2;
  private TrafficIOStreamHandlerManager.DefaultTrafficOutputStreamHandler.DumpOutputStreamTask dumpOutputStreamTask = new TrafficIOStreamHandlerManager.DefaultTrafficOutputStreamHandler.DumpOutputStreamTask(this);
  private boolean finish;
  private TrafficIOStreamHandlerManager.Package outputStreamPackage;
  private String outputTag;
  private String path;
  
  public void onOutput(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, SocketInfo paramSocketInfo)
  {
    boolean bool;
    if ((this.finish) || (TextUtils.isEmpty(this.outputTag)) || ((paramSocketInfo.path != null) && (!paramSocketInfo.path.equals(this.path))))
    {
      this.finish = false;
      this.path = paramSocketInfo.path;
      paramSocketInfo.resetForOutput();
      this.outputTag = TrafficIOStreamHandlerManager.access$300(paramSocketInfo);
      this.outputStreamPackage = new TrafficIOStreamHandlerManager.Package(true, paramSocketInfo);
      if ((paramSocketInfo.version == null) || (!paramSocketInfo.version.startsWith("HTTP/1"))) {
        break label623;
      }
      bool = true;
    }
    for (;;)
    {
      this.canHandlerHttp1 = bool;
      label136:
      TrafficIOStreamHandlerManager.Header localHeader;
      TrafficIOStreamHandlerManager.Body localBody;
      if ((paramSocketInfo.version != null) && (paramSocketInfo.version.startsWith("HTTP/2")))
      {
        bool = true;
        this.canHandlerHttp2 = bool;
        paramSocketInfo.sendBytes += paramInt2;
        if ((TrafficMonitor.config().isVerbose()) && (paramInt2 > 0) && (this.canHandlerHttp1))
        {
          localHeader = this.outputStreamPackage.header;
          localBody = this.outputStreamPackage.body;
          if (localHeader.isCompleted) {
            break label635;
          }
          localHeader.parse(paramArrayOfByte, paramInt1, paramInt2);
          if (localHeader.isCompleted)
          {
            this.outputTag = TrafficIOStreamHandlerManager.access$300(paramSocketInfo);
            localBody.remain = paramSocketInfo.contentLength;
            paramSocketInfo = localHeader.baos.toByteArray();
            localBody.parse(paramSocketInfo, localHeader.offset, paramSocketInfo.length - localHeader.offset);
          }
          label267:
          if ((localHeader.isCompleted) && (localBody.isCompleted) && (this.canHandlerHttp1))
          {
            Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "http1 write finish >>>> ", this.outputTag });
            this.finish = true;
          }
        }
        if ((TrafficMonitor.config().isVerbose()) && (paramInt2 > 0) && (this.canHandlerHttp2))
        {
          paramSocketInfo = new Decode(new ByteArrayInputStream(paramArrayOfByte));
          localHeader = this.outputStreamPackage.header;
          localBody = this.outputStreamPackage.body;
        }
      }
      try
      {
        paramSocketInfo.readFrame(new TrafficIOStreamHandlerManager.Http2Handle(this.outputStreamPackage));
        if ((localHeader.isCompleted) && (localBody.isCompleted) && (this.canHandlerHttp2))
        {
          Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "http2 write finish >>>> ", this.outputTag });
          this.finish = true;
        }
        label449:
        ThreadUtils.replaceSingle(this.dumpOutputStreamTask.acquire(paramInt2), 500L);
        if ((TrafficMonitor.config().canLog()) && (!this.canHandlerHttp1))
        {
          if ((this.outputStreamPackage == null) || (this.outputStreamPackage.size() <= 0) || (this.canHandlerHttp2)) {
            break label646;
          }
          paramArrayOfByte = this.outputStreamPackage.toByteArray();
          this.outputStreamPackage.reset();
        }
        for (;;)
        {
          paramSocketInfo = paramArrayOfByte;
          if (!new Utf8Checker().isPlaintext(paramArrayOfByte)) {
            paramSocketInfo = ("binary " + paramArrayOfByte.length + "-bytes body omitted").getBytes();
          }
          Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficOutputStream", "write >>> [", this.outputTag + "]\n", new String(paramSocketInfo) });
          return;
          label623:
          bool = false;
          break;
          bool = false;
          break label136;
          label635:
          localBody.parse(paramArrayOfByte, paramInt1, paramInt2);
          break label267;
          label646:
          paramSocketInfo = new byte[paramInt2];
          System.arraycopy(paramArrayOfByte, paramInt1, paramSocketInfo, 0, paramInt2);
          paramArrayOfByte = paramSocketInfo;
        }
      }
      catch (Exception paramSocketInfo)
      {
        break label449;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficIOStreamHandlerManager.DefaultTrafficOutputStreamHandler
 * JD-Core Version:    0.7.0.1
 */