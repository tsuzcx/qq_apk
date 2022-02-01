package com.tencent.mobileqq.now.netchannel.websso;

import android.util.Log;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.AccountBaseInfo;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginRsp;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.TicketInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

class LoginMgr$1
  implements IChannelListener
{
  LoginMgr$1(LoginMgr paramLoginMgr, LoginMgr.Listener paramListener) {}
  
  public void a(int paramInt, String paramString)
  {
    Log.d("now_live_login_mgr", "login faile, errCode=" + paramInt + ", errMsg=" + paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr$Listener != null) {
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr$Listener.a(paramInt, paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (LoginMgr.a(this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr)) {
      return;
    }
    for (;;)
    {
      try
      {
        Log.d("now_live_login_mgr", "login success");
        LoginMergedProto.LoginRsp localLoginRsp = new LoginMergedProto.LoginRsp();
        localLoginRsp.mergeFrom(paramArrayOfByte);
        UserInfoMgr.a().a(localLoginRsp.account_base_info.uid.get());
        UserInfoMgr.a().b(localLoginRsp.account_base_info.tinyid.get());
        UserInfoMgr.a().a(localLoginRsp.tickets.auth_key.get());
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr;
        if (localLoginRsp.result.get() != 0) {
          break label185;
        }
        bool = true;
        LoginMgr.a(paramArrayOfByte, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr$Listener == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr$Listener.a(localLoginRsp.result.get(), localLoginRsp.errMsg.get());
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.d("now_live_login_mgr", "login parse exception, errMsg=" + paramArrayOfByte.getMessage());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr$Listener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr$Listener.a(1000001, "login parse exception");
      return;
      label185:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.LoginMgr.1
 * JD-Core Version:    0.7.0.1
 */