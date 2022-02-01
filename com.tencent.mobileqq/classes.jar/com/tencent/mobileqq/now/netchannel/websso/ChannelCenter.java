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
  private static ChannelCenter jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private WebServiceSSO jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public static ChannelCenter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter == null)
    {
      jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter = new ChannelCenter();
      jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter.a(false);
    }
    return jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter;
  }
  
  private WnsHeadProto.ForwardReq a(byte[] paramArrayOfByte)
  {
    WnsHeadProto.ForwardReq localForwardReq = new WnsHeadProto.ForwardReq();
    localForwardReq.platform.set(16130);
    localForwardReq.busi_buf.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    localForwardReq.version.set(Config.a());
    localForwardReq.version_code.set(Config.a());
    localForwardReq.a2.set(UserInfoMgr.a().d());
    localForwardReq.uid.set(UserInfoMgr.a().b());
    localForwardReq.tinyid.set(UserInfoMgr.a().c());
    localForwardReq.stream_type.set(1);
    localForwardReq.original_id.set(String.valueOf(UserInfoMgr.a()));
    localForwardReq.original_id_type.set(1);
    localForwardReq.original_key.set(UserInfoMgr.b());
    if (this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO.a()) {
      localForwardReq.target_env.set(1);
    }
    return localForwardReq;
  }
  
  public static void b()
  {
    if (jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter != null)
    {
      jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter.a();
      jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoChannelCenter = null;
    }
  }
  
  protected void a()
  {
    c();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte, IChannelListener paramIChannelListener)
  {
    String str = String.format("0x%x_0x%x", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramArrayOfByte = a(paramArrayOfByte);
    Log.i("ChannelCenter", "WebServiceSSO--start send cmd=" + paramInt1);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO.a(str, paramArrayOfByte.toByteArray(), new ChannelCenter.1(this, paramInt1, paramIChannelListener));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte.getMessage();
      Log.i("ChannelCenter", paramArrayOfByte);
      this.jdField_a_of_type_AndroidOsHandler.post(new ChannelCenter.2(this, paramInt1, paramIChannelListener, paramArrayOfByte));
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = 1400015341;
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (int j = 7747;; j = 3256)
    {
      UserInfoMgr.a();
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO = new WebServiceSSO(i, j, String.valueOf(i), UserInfoMgr.a(), "", 0);
      b(paramBoolean);
      return;
      i = 1400005918;
      break;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO.a(paramBoolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoWebServiceSSO.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.ChannelCenter
 * JD-Core Version:    0.7.0.1
 */