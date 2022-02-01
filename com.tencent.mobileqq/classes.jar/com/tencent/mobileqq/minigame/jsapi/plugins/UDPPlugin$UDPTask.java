package com.tencent.mobileqq.minigame.jsapi.plugins;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.utils.NioSelectorThread;
import com.tencent.mobileqq.mini.utils.NioSelectorThread.NioHandler;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

class UDPPlugin$UDPTask
  implements NioSelectorThread.NioHandler
{
  private final DatagramChannel channel;
  private final ByteBuffer receiveBuffer;
  private final byte[] receiveByteArray;
  final int taskId;
  
  UDPPlugin$UDPTask(UDPPlugin paramUDPPlugin)
  {
    try
    {
      this.taskId = UDPPlugin.access$000().getAndIncrement();
      this.channel = DatagramChannel.open();
      this.channel.configureBlocking(false);
      this.receiveByteArray = new byte[8192];
      this.receiveBuffer = ByteBuffer.wrap(this.receiveByteArray);
      return;
    }
    catch (IOException paramUDPPlugin)
    {
      onError(paramUDPPlugin.getMessage());
      throw paramUDPPlugin;
    }
  }
  
  public int bind()
  {
    try
    {
      this.channel.socket().bind(null);
      NioSelectorThread.getInstance().registerChannel(this.channel, 1, this);
      onListening();
      int i = this.channel.socket().getLocalPort();
      return i;
    }
    catch (IOException localIOException)
    {
      onError(localIOException.getMessage());
      throw localIOException;
    }
  }
  
  public void close()
  {
    try
    {
      this.channel.close();
      onClose();
      return;
    }
    catch (IOException localIOException)
    {
      onError(localIOException.getMessage());
      throw localIOException;
    }
  }
  
  public boolean handle(SelectionKey paramSelectionKey)
  {
    try
    {
      if (paramSelectionKey.isReadable())
      {
        this.receiveBuffer.clear();
        paramSelectionKey = this.channel.receive(this.receiveBuffer);
        this.receiveBuffer.flip();
        onReceive(this.receiveByteArray, this.receiveBuffer.limit(), paramSelectionKey);
      }
      return true;
    }
    catch (IOException paramSelectionKey)
    {
      for (;;)
      {
        onError(paramSelectionKey.getMessage());
      }
    }
  }
  
  void onClose()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("udpTaskId", this.taskId);
      localJSONObject.put("event", "close");
      UDPPlugin.access$100(this.this$0).evaluateSubcribeJS("onUDPTaskEventCallback", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  void onError(String paramString)
  {
    UDPPlugin.access$200(this.this$0, paramString, this.taskId);
  }
  
  void onListening()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("udpTaskId", this.taskId);
      localJSONObject.put("event", "listening");
      UDPPlugin.access$100(this.this$0).evaluateSubcribeJS("onUDPTaskEventCallback", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  void onReceive(@NonNull byte[] paramArrayOfByte, int paramInt, @Nullable SocketAddress paramSocketAddress)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("udpTaskId", this.taskId);
      localJSONObject.put("event", "message");
      NativeBuffer.packNativeBuffer(paramArrayOfByte, 0, paramInt, NativeBuffer.TYPE_BUFFER_NATIVE, "message", localJSONObject, (ITNativeBufferPool)this.this$0.jsPluginEngine.getNativeBufferPool());
      paramArrayOfByte = new JSONObject();
      InetAddress localInetAddress;
      if ((paramSocketAddress instanceof InetSocketAddress))
      {
        paramSocketAddress = (InetSocketAddress)paramSocketAddress;
        localInetAddress = paramSocketAddress.getAddress();
        if (!(localInetAddress instanceof Inet4Address)) {
          break label161;
        }
        paramArrayOfByte.put("family", "IPv4");
      }
      for (;;)
      {
        paramArrayOfByte.put("address", localInetAddress.getHostAddress());
        paramArrayOfByte.put("port", paramSocketAddress.getPort());
        paramArrayOfByte.put("size", paramInt);
        localJSONObject.put("remoteInfo", paramArrayOfByte);
        UDPPlugin.access$100(this.this$0).evaluateSubcribeJS("onUDPTaskEventCallback", localJSONObject.toString(), 0);
        return;
        label161:
        paramArrayOfByte.put("family", "IPv6");
      }
      return;
    }
    catch (JSONException paramArrayOfByte) {}
  }
  
  public void send(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, @NonNull SocketAddress paramSocketAddress)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.position(paramInt1);
    paramArrayOfByte.limit(paramInt1 + paramInt2);
    this.channel.send(paramArrayOfByte, paramSocketAddress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.UDPPlugin.UDPTask
 * JD-Core Version:    0.7.0.1
 */