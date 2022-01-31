package com.tencent.qapmsdk.socket.handler;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.report.TrafficMonitorReport;
import com.tencent.qapmsdk.socket.TrafficMonitor;
import com.tencent.qapmsdk.socket.TrafficMonitor.TrafficConfig;
import com.tencent.qapmsdk.socket.hpack.Decode;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import com.tencent.qapmsdk.socket.model.SocketTracer;
import com.tencent.qapmsdk.socket.model.Utf8Checker;
import com.tencent.qapmsdk.socket.util.ArrayUtils;
import com.tencent.qapmsdk.socket.util.ThreadUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

class TrafficIOStreamHandlerManager$DefaultTrafficInputStreamHandler
  implements ITrafficInputStreamHandler
{
  private static final long DELAY_TIME = 500L;
  private static final String TAG = "QAPM_Socket_TrafficInputStream";
  private List<Byte> byteList = new ArrayList();
  private boolean canHandlerHttp1;
  private boolean canHandlerHttp2;
  private TrafficIOStreamHandlerManager.DefaultTrafficInputStreamHandler.DumpInputStreamTask dumpInputStreamTask = new TrafficIOStreamHandlerManager.DefaultTrafficInputStreamHandler.DumpInputStreamTask(this);
  private boolean finish;
  private TrafficIOStreamHandlerManager.Package inputSteamPackage;
  private String inputTag;
  private String path;
  
  public void onClose()
  {
    if (this.byteList.size() > 0)
    {
      ThreadUtils.replaceSingle(this.dumpInputStreamTask.acquire(this.byteList.size()), 500L);
      if ((TrafficMonitor.config().isVerbose()) && (!this.canHandlerHttp1) && (this.inputSteamPackage != null))
      {
        TrafficIOStreamHandlerManager.Body localBody = this.inputSteamPackage.body;
        if (localBody.baos.size() > 0) {
          localBody.baos.reset();
        }
        Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "input stream close ", this.inputTag });
      }
      this.byteList.clear();
    }
  }
  
  public void onInput(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, @Nullable SocketInfo paramSocketInfo)
  {
    boolean bool;
    if (paramSocketInfo != null) {
      if ((this.finish) || (TextUtils.isEmpty(this.inputTag)) || ((paramSocketInfo.path != null) && (!paramSocketInfo.path.equals(this.path))))
      {
        this.finish = false;
        this.path = paramSocketInfo.path;
        paramSocketInfo.resetForInput();
        this.inputTag = TrafficIOStreamHandlerManager.access$300(paramSocketInfo);
        this.inputSteamPackage = new TrafficIOStreamHandlerManager.Package(false, paramSocketInfo);
        if ((paramSocketInfo.version == null) || (!paramSocketInfo.version.startsWith("HTTP/1"))) {
          break label576;
        }
        bool = true;
      }
    }
    for (;;)
    {
      this.canHandlerHttp1 = bool;
      label141:
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramSocketInfo.version != null) && (paramSocketInfo.version.startsWith("HTTP/2")))
      {
        bool = true;
        this.canHandlerHttp2 = bool;
        paramSocketInfo.receivedBytes += paramInt2;
        if ((TrafficMonitor.config().isVerbose()) && (paramInt3 > 0) && (this.canHandlerHttp1) && (this.inputSteamPackage != null))
        {
          localObject1 = this.inputSteamPackage.header;
          localObject2 = this.inputSteamPackage.body;
          if (((TrafficIOStreamHandlerManager.Header)localObject1).isCompleted) {
            break label588;
          }
          ((TrafficIOStreamHandlerManager.Header)localObject1).parse(paramArrayOfByte, paramInt1, paramInt3);
          if (((TrafficIOStreamHandlerManager.Header)localObject1).isCompleted)
          {
            if (paramSocketInfo != null)
            {
              this.inputTag = TrafficIOStreamHandlerManager.access$300(paramSocketInfo);
              ((TrafficIOStreamHandlerManager.Body)localObject2).remain = paramSocketInfo.contentLength;
            }
            localObject3 = ((TrafficIOStreamHandlerManager.Header)localObject1).baos.toByteArray();
            ((TrafficIOStreamHandlerManager.Body)localObject2).parse((byte[])localObject3, ((TrafficIOStreamHandlerManager.Header)localObject1).offset, localObject3.length - ((TrafficIOStreamHandlerManager.Header)localObject1).offset);
          }
          label286:
          if ((((TrafficIOStreamHandlerManager.Header)localObject1).isCompleted) && (((TrafficIOStreamHandlerManager.Body)localObject2).isCompleted) && (this.canHandlerHttp1))
          {
            Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "http1 read finished <<< ", this.inputTag });
            this.finish = true;
          }
        }
        if ((TrafficMonitor.config().isVerbose()) && (paramInt2 > 0) && (this.canHandlerHttp2) && (this.inputSteamPackage != null))
        {
          localObject1 = new Decode(new ByteArrayInputStream(paramArrayOfByte));
          localObject2 = this.inputSteamPackage.header;
          localObject3 = this.inputSteamPackage.body;
        }
      }
      try
      {
        ((Decode)localObject1).readFrame(new TrafficIOStreamHandlerManager.Http2Handle(this.inputSteamPackage));
        if ((((TrafficIOStreamHandlerManager.Header)localObject2).isCompleted) && (((TrafficIOStreamHandlerManager.Body)localObject3).isCompleted) && (this.canHandlerHttp2))
        {
          Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "http2 read finished <<< ", this.inputTag });
          this.finish = true;
        }
        label475:
        if (paramInt3 == 1) {
          this.byteList.add(Byte.valueOf(paramArrayOfByte[0]));
        }
        label576:
        label588:
        do
        {
          do
          {
            if ((this.finish) && (paramSocketInfo != null))
            {
              if (!paramSocketInfo.hasSaved)
              {
                TrafficMonitorReport.getInstance().addSocketToQueue(paramSocketInfo);
                paramSocketInfo.hasSaved = true;
              }
              SocketTracer.addSocketInfoToMap(paramSocketInfo.protocol + "://" + paramSocketInfo.host + paramSocketInfo.path, paramSocketInfo);
            }
            return;
            bool = false;
            break;
            bool = false;
            break label141;
            ((TrafficIOStreamHandlerManager.Body)localObject2).parse(paramArrayOfByte, paramInt1, paramInt3);
            break label286;
          } while (paramInt3 <= 1);
          ThreadUtils.replaceSingle(this.dumpInputStreamTask.acquire(paramInt3), 500L);
          if ((TrafficMonitor.config().canLog()) && (!this.canHandlerHttp1))
          {
            if ((this.inputSteamPackage == null) || (this.inputSteamPackage.size() <= 0) || (this.canHandlerHttp2)) {
              break label967;
            }
            paramArrayOfByte = this.inputSteamPackage.toByteArray();
            this.inputSteamPackage.reset();
            localObject1 = paramArrayOfByte;
            if (!new Utf8Checker().isPlaintext(paramArrayOfByte)) {
              localObject1 = ("binary " + paramArrayOfByte.length + "-bytes body omitted").getBytes();
            }
            Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "read <<< [", this.inputTag, "]\n", new String((byte[])localObject1) });
          }
        } while (this.byteList.size() <= 0);
        label676:
        ThreadUtils.replaceSingle(this.dumpInputStreamTask.acquire(this.byteList.size()), 500L);
        if ((TrafficMonitor.config().canLog()) && (!this.canHandlerHttp1))
        {
          if ((this.inputSteamPackage == null) || (this.inputSteamPackage.size() <= 0) || (this.canHandlerHttp2)) {
            break label989;
          }
          paramArrayOfByte = this.inputSteamPackage.toByteArray();
          this.inputSteamPackage.reset();
        }
        for (;;)
        {
          localObject1 = paramArrayOfByte;
          if (!new Utf8Checker().isPlaintext(paramArrayOfByte)) {
            localObject1 = ("binary " + paramArrayOfByte.length + "-bytes body omitted").getBytes();
          }
          Logger.INSTANCE.d(new String[] { "QAPM_Socket_TrafficInputStream", "read <<< [", this.inputTag, "]\n", new String((byte[])localObject1) });
          this.byteList.clear();
          break;
          label967:
          localObject1 = new byte[paramInt3];
          System.arraycopy(paramArrayOfByte, paramInt1, localObject1, 0, paramInt3);
          paramArrayOfByte = (byte[])localObject1;
          break label676;
          label989:
          paramArrayOfByte = ArrayUtils.toPrimitive((Byte[])this.byteList.toArray(new Byte[0]));
        }
      }
      catch (Exception localException)
      {
        break label475;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficIOStreamHandlerManager.DefaultTrafficInputStreamHandler
 * JD-Core Version:    0.7.0.1
 */