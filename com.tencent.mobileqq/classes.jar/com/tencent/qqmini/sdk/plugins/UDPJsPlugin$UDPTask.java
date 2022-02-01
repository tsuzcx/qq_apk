package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.core.utils.thread.NioSelectorThread;
import com.tencent.qqmini.sdk.core.utils.thread.NioSelectorThread.NioHandler;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
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

class UDPJsPlugin$UDPTask
  implements NioSelectorThread.NioHandler
{
  private final DatagramChannel channel;
  private final IJsService jsService;
  private final ByteBuffer receiveBuffer;
  private final byte[] receiveByteArray;
  final int taskId;
  
  UDPJsPlugin$UDPTask(UDPJsPlugin paramUDPJsPlugin, IJsService paramIJsService)
  {
    this.jsService = paramIJsService;
    try
    {
      this.taskId = UDPJsPlugin.access$100().getAndIncrement();
      this.channel = DatagramChannel.open();
      this.channel.configureBlocking(false);
      this.receiveByteArray = new byte[8192];
      this.receiveBuffer = ByteBuffer.wrap(this.receiveByteArray);
      return;
    }
    catch (IOException paramUDPJsPlugin)
    {
      onError(paramUDPJsPlugin.getMessage());
      throw paramUDPJsPlugin;
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
    }
    catch (Exception paramSelectionKey)
    {
      onError(paramSelectionKey.getMessage());
    }
    return true;
  }
  
  void onClose()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("udpTaskId", this.taskId);
      localJSONObject.put("event", "close");
      UDPJsPlugin.access$400(this.this$0, "onUDPTaskEventCallback", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  void onError(String paramString)
  {
    UDPJsPlugin.access$300(this.this$0, paramString, this.taskId);
  }
  
  void onListening()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("udpTaskId", this.taskId);
      localJSONObject.put("event", "listening");
      UDPJsPlugin.access$200(this.this$0, "onUDPTaskEventCallback", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  void onReceive(byte[] paramArrayOfByte, int paramInt, SocketAddress paramSocketAddress)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("udpTaskId", this.taskId);
      localJSONObject.put("event", "message");
      NativeBuffer.packNativeBuffer(this.jsService, paramArrayOfByte, 0, paramInt, NativeBuffer.TYPE_BUFFER_NATIVE, "message", localJSONObject);
      paramArrayOfByte = new JSONObject();
      if ((paramSocketAddress instanceof InetSocketAddress))
      {
        paramSocketAddress = (InetSocketAddress)paramSocketAddress;
        InetAddress localInetAddress = paramSocketAddress.getAddress();
        boolean bool = localInetAddress instanceof Inet4Address;
        if (bool) {
          paramArrayOfByte.put("family", "IPv4");
        } else {
          paramArrayOfByte.put("family", "IPv6");
        }
        paramArrayOfByte.put("address", localInetAddress.getHostAddress());
        paramArrayOfByte.put("port", paramSocketAddress.getPort());
      }
      paramArrayOfByte.put("size", paramInt);
      localJSONObject.put("remoteInfo", paramArrayOfByte);
      UDPJsPlugin.access$500(this.this$0, "onUDPTaskEventCallback", localJSONObject.toString());
      return;
    }
    catch (JSONException paramArrayOfByte) {}
  }
  
  public void send(byte[] paramArrayOfByte, int paramInt1, int paramInt2, SocketAddress paramSocketAddress)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte);
    paramArrayOfByte.position(paramInt1);
    paramArrayOfByte.limit(paramInt1 + paramInt2);
    this.channel.send(paramArrayOfByte, paramSocketAddress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.UDPJsPlugin.UDPTask
 * JD-Core Version:    0.7.0.1
 */