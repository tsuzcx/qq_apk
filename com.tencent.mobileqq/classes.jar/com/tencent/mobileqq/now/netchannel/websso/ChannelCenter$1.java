package com.tencent.mobileqq.now.netchannel.websso;

import android.os.Handler;
import android.util.Log;
import com.tencent.mobileqq.now.netchannel.tool.GZipUtil;
import com.tencent.mobileqq.now.wnsilivehead.WnsHeadProto.ForwardRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

class ChannelCenter$1
  implements SSOCallback
{
  ChannelCenter$1(ChannelCenter paramChannelCenter, int paramInt, IChannelListener paramIChannelListener) {}
  
  public void a(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebServiceSSO--onFail errCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString);
    Log.d("ChannelCenter", localStringBuilder.toString());
    if (ChannelCenter.a(this.c))
    {
      Log.d("ChannelCenter", "now live quit.");
      return;
    }
    this.b.a(paramInt, paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WebServiceSSO--onSuccess cmd=");
    ((StringBuilder)localObject).append(this.a);
    Log.i("ChannelCenter", ((StringBuilder)localObject).toString());
    if (ChannelCenter.a(this.c))
    {
      Log.d("ChannelCenter", "now live quit.");
      return;
    }
    WnsHeadProto.ForwardRsp localForwardRsp = new WnsHeadProto.ForwardRsp();
    try
    {
      localForwardRsp.mergeFrom(paramArrayOfByte);
      localObject = localForwardRsp.busi_buf.get().toByteArray();
      paramArrayOfByte = (byte[])localObject;
      if (localForwardRsp.stream_type.has())
      {
        int i = localForwardRsp.stream_type.get();
        paramArrayOfByte = (byte[])localObject;
        if (i == 1) {
          try
          {
            paramArrayOfByte = GZipUtil.a((byte[])localObject);
          }
          catch (Exception paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
            paramArrayOfByte = null;
          }
        }
      }
      if (paramArrayOfByte == null) {
        break label163;
      }
      ChannelCenter.b(this.c).post(new ChannelCenter.1.1(this, paramArrayOfByte));
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label150:
      label163:
      break label150;
    }
    this.b.a(1000001, "解析出错");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.ChannelCenter.1
 * JD-Core Version:    0.7.0.1
 */