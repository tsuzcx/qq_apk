package com.tencent.qqmini.sdk.minigame.plugins;

import bdgr;
import bdhp;
import bdhq;
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
  implements bdhq
{
  private final DatagramChannel channel;
  private final ByteBuffer receiveBuffer;
  private final byte[] receiveByteArray;
  final int taskId;
  
  UDPJsPlugin$UDPTask(UDPJsPlugin paramUDPJsPlugin)
  {
    try
    {
      this.taskId = UDPJsPlugin.access$000().getAndIncrement();
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
      bdhp.a().a(this.channel, 1, this);
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
      UDPJsPlugin.access$300(this.this$0, "onUDPTaskEventCallback", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  void onError(String paramString)
  {
    UDPJsPlugin.access$200(this.this$0, paramString, this.taskId);
  }
  
  void onListening()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("udpTaskId", this.taskId);
      localJSONObject.put("event", "listening");
      UDPJsPlugin.access$100(this.this$0, "onUDPTaskEventCallback", localJSONObject.toString());
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
      bdgr.a(UDPJsPlugin.access$400(this.this$0), paramArrayOfByte, 0, paramInt, bdgr.a, "message", localJSONObject);
      paramArrayOfByte = new JSONObject();
      InetAddress localInetAddress;
      if ((paramSocketAddress instanceof InetSocketAddress))
      {
        paramSocketAddress = (InetSocketAddress)paramSocketAddress;
        localInetAddress = paramSocketAddress.getAddress();
        if (!(localInetAddress instanceof Inet4Address)) {
          break label149;
        }
        paramArrayOfByte.put("family", "IPv4");
      }
      for (;;)
      {
        paramArrayOfByte.put("address", localInetAddress.getHostAddress());
        paramArrayOfByte.put("port", paramSocketAddress.getPort());
        paramArrayOfByte.put("size", paramInt);
        localJSONObject.put("remoteInfo", paramArrayOfByte);
        UDPJsPlugin.access$500(this.this$0, "onUDPTaskEventCallback", localJSONObject.toString());
        return;
        label149:
        paramArrayOfByte.put("family", "IPv6");
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.UDPJsPlugin.UDPTask
 * JD-Core Version:    0.7.0.1
 */