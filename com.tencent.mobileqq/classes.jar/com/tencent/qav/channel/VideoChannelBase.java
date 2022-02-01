package com.tencent.qav.channel;

import SharpSvrPack.MultiVideoMsg;
import SharpSvrPack.SharpVideoMsg;
import VideoSvrPack.VideoCallMsg;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.qav.log.AVLog;
import java.util.ArrayList;

public abstract class VideoChannelBase
  implements VideoChannelInterface
{
  private VideoChannelCallback a;
  private VideoChannelSupportCallback b;
  
  private void a(MultiVideoMsg paramMultiVideoMsg)
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("MultiVideo");
    localUniPacket.setFuncName("MultiVideos2cack");
    localUniPacket.put("MultiVideoMsg", paramMultiVideoMsg);
    j(localUniPacket.encode());
  }
  
  private void a(SharpVideoMsg paramSharpVideoMsg)
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setServantName("SharpSvr");
    localUniPacket.setFuncName("s2cack");
    localUniPacket.put("SharpVideoMsg", paramSharpVideoMsg);
    h(localUniPacket.encode());
  }
  
  private boolean a(int paramInt)
  {
    VideoChannelSupportCallback localVideoChannelSupportCallback = this.b;
    if (localVideoChannelSupportCallback != null) {
      return localVideoChannelSupportCallback.a(paramInt);
    }
    return true;
  }
  
  private boolean b(int paramInt)
  {
    VideoChannelSupportCallback localVideoChannelSupportCallback = this.b;
    if (localVideoChannelSupportCallback != null) {
      return localVideoChannelSupportCallback.b(paramInt);
    }
    return true;
  }
  
  private Bundle k(byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("buffer", paramArrayOfByte);
    return localBundle;
  }
  
  protected abstract long a();
  
  protected abstract void a(long paramLong, byte[] paramArrayOfByte);
  
  public void a(VideoChannelCallback paramVideoChannelCallback)
  {
    this.a = paramVideoChannelCallback;
  }
  
  public void a(VideoChannelSupportCallback paramVideoChannelSupportCallback)
  {
    this.b = paramVideoChannelSupportCallback;
  }
  
  public void a(String paramString, int paramInt)
  {
    VideoChannelCallback localVideoChannelCallback = this.a;
    if (localVideoChannelCallback != null) {
      localVideoChannelCallback.receiveGatewayMsg(paramString, paramInt);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.a != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (SharpVideoMsg)localUniPacket.getByClass("SharpVideoMsg", new SharpVideoMsg());
      if (a(paramArrayOfByte.type))
      {
        a(paramArrayOfByte);
        this.a.receiveSharpVideoMsg(k(paramArrayOfByte.video_buff));
      }
    }
  }
  
  protected abstract void b();
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.a != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (SharpVideoMsg)localUniPacket.getByClass("SharpVideoMsg", new SharpVideoMsg());
      if (a(paramArrayOfByte.type)) {
        this.a.receiveSharpVideoAck(k(paramArrayOfByte.video_buff));
      }
    }
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (this.a != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (MultiVideoMsg)localUniPacket.getByClass("MultiVideoMsg", new MultiVideoMsg());
      AVLog.c("VideoChannelBase", String.format("receiveMultiVideoMsg type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramArrayOfByte.type), Short.valueOf(paramArrayOfByte.csCmd) }));
      if (b(paramArrayOfByte.type))
      {
        a(paramArrayOfByte);
        this.a.receiveMultiVideoMsg(k(paramArrayOfByte.video_buff));
      }
    }
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    if (this.a != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (MultiVideoMsg)localUniPacket.getByClass("MultiVideoMsg", new MultiVideoMsg());
      AVLog.c("VideoChannelBase", String.format("receiveMultiVideoAck type=0x%X csCmd=0x%X", new Object[] { Byte.valueOf(paramArrayOfByte.type), Short.valueOf(paramArrayOfByte.csCmd) }));
      if (b(paramArrayOfByte.type)) {
        this.a.receiveMultiVideoAck(k(paramArrayOfByte.video_buff));
      }
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    if (this.a != null)
    {
      UniPacket localUniPacket = new UniPacket(true);
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      paramArrayOfByte = (VideoCallMsg)localUniPacket.getByClass("VideoCallMsg", new VideoCallMsg());
      this.a.receiveVideoConfig(k(paramArrayOfByte.vMsg));
    }
  }
  
  protected abstract void f(byte[] paramArrayOfByte);
  
  protected abstract void g(byte[] paramArrayOfByte);
  
  protected abstract void h(byte[] paramArrayOfByte);
  
  protected abstract void i(byte[] paramArrayOfByte);
  
  protected abstract void j(byte[] paramArrayOfByte);
  
  public void sendGetGatewayMsg()
  {
    b();
  }
  
  public void sendGetVideoConfig(byte[] paramArrayOfByte)
  {
    long l = a();
    VideoCallMsg localVideoCallMsg = new VideoCallMsg();
    localVideoCallMsg.ver = 1;
    localVideoCallMsg.type = 1;
    localVideoCallMsg.lUin = l;
    localVideoCallMsg.uDateTime = ((int)(System.currentTimeMillis() / 1000L));
    localVideoCallMsg.vMsg = paramArrayOfByte;
    paramArrayOfByte = new UniPacket();
    paramArrayOfByte.setServantName("VideoSvc");
    paramArrayOfByte.setFuncName("SendVideoMsg");
    paramArrayOfByte.put("VideoCallMsg", localVideoCallMsg);
    f(paramArrayOfByte.encode());
  }
  
  public void sendLogReportMsg(long paramLong, byte[] paramArrayOfByte)
  {
    a(paramLong, paramArrayOfByte);
  }
  
  public void sendMultiVideoMsg(long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    long l = a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong1));
    MultiVideoMsg localMultiVideoMsg = new MultiVideoMsg();
    localMultiVideoMsg.ver = 0;
    localMultiVideoMsg.type = 1;
    localMultiVideoMsg.csCmd = ((short)(int)paramLong2);
    localMultiVideoMsg.from_uin = l;
    localMultiVideoMsg.to_uin = localArrayList;
    localMultiVideoMsg.video_buff = paramArrayOfByte;
    paramArrayOfByte = new UniPacket();
    paramArrayOfByte.setServantName("MultiVideo");
    paramArrayOfByte.setFuncName("MultiVideoMsg");
    paramArrayOfByte.put("MultiVideoMsg", localMultiVideoMsg);
    i(paramArrayOfByte.encode());
  }
  
  public void sendSharpVideoMsg(long paramLong, byte[] paramArrayOfByte)
  {
    long l = a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    SharpVideoMsg localSharpVideoMsg = new SharpVideoMsg();
    localSharpVideoMsg.ver = 1;
    localSharpVideoMsg.type = 1;
    localSharpVideoMsg.from_uin = l;
    localSharpVideoMsg.to_uin = localArrayList;
    localSharpVideoMsg.video_buff = paramArrayOfByte;
    paramArrayOfByte = new UniPacket();
    paramArrayOfByte.setServantName("SharpSvr");
    paramArrayOfByte.setFuncName("c2s");
    paramArrayOfByte.put("SharpVideoMsg", localSharpVideoMsg);
    g(paramArrayOfByte.encode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qav.channel.VideoChannelBase
 * JD-Core Version:    0.7.0.1
 */