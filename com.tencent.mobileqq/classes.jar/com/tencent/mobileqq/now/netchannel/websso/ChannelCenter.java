package com.tencent.mobileqq.now.netchannel.websso;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.now.wnsilivehead.WnsHeadProto.ForwardReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class ChannelCenter
{
  private static ChannelCenter a;
  private WebServiceSSO b;
  private volatile boolean c = false;
  private Handler d = new Handler(Looper.getMainLooper());
  
  private WnsHeadProto.ForwardReq a(byte[] paramArrayOfByte)
  {
    WnsHeadProto.ForwardReq localForwardReq = new WnsHeadProto.ForwardReq();
    localForwardReq.platform.set(16130);
    localForwardReq.busi_buf.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localForwardReq.version.set(Config.a());
    localForwardReq.version_code.set(Config.b());
    localForwardReq.a2.set(UserInfoMgr.a().k());
    localForwardReq.uid.set(UserInfoMgr.a().i());
    localForwardReq.tinyid.set(UserInfoMgr.a().j());
    localForwardReq.stream_type.set(1);
    localForwardReq.original_id.set(String.valueOf(UserInfoMgr.e()));
    localForwardReq.original_id_type.set(1);
    localForwardReq.original_key.set(UserInfoMgr.g());
    if (this.b.a()) {
      localForwardReq.target_env.set(1);
    }
    return localForwardReq;
  }
  
  public static ChannelCenter b()
  {
    if (a == null)
    {
      a = new ChannelCenter();
      a.a(false);
    }
    return a;
  }
  
  public static void c()
  {
    ChannelCenter localChannelCenter = a;
    if (localChannelCenter != null)
    {
      localChannelCenter.a();
      a = null;
    }
  }
  
  protected void a()
  {
    d();
    this.c = true;
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, IChannelListener paramIChannelListener)
  {
    String str = String.format("0x%x_0x%x", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramArrayOfByte = a(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebServiceSSO--start send cmd=");
    localStringBuilder.append(paramInt1);
    Log.i("ChannelCenter", localStringBuilder.toString());
    try
    {
      this.b.a(str, paramArrayOfByte.toByteArray(), new ChannelCenter.1(this, paramInt1, paramIChannelListener));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte.getMessage();
      Log.i("ChannelCenter", paramArrayOfByte);
      this.d.post(new ChannelCenter.2(this, paramInt1, paramIChannelListener, paramArrayOfByte));
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1400015341;
    } else {
      i = 1400005918;
    }
    int j;
    if (paramBoolean) {
      j = 7747;
    } else {
      j = 3256;
    }
    UserInfoMgr.a();
    this.b = new WebServiceSSO(i, j, String.valueOf(i), UserInfoMgr.e(), "", 0);
    b(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  public void d()
  {
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.ChannelCenter
 * JD-Core Version:    0.7.0.1
 */