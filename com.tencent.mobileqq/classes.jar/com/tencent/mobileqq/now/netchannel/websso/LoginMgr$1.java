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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("login faile, errCode=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", errMsg=");
    ((StringBuilder)localObject).append(paramString);
    Log.d("now_live_login_mgr", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr$Listener;
    if (localObject != null) {
      ((LoginMgr.Listener)localObject).a(paramInt, paramString);
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
        localObject = new LoginMergedProto.LoginRsp();
        ((LoginMergedProto.LoginRsp)localObject).mergeFrom(paramArrayOfByte);
        UserInfoMgr.a().a(((LoginMergedProto.LoginRsp)localObject).account_base_info.uid.get());
        UserInfoMgr.a().b(((LoginMergedProto.LoginRsp)localObject).account_base_info.tinyid.get());
        UserInfoMgr.a().a(((LoginMergedProto.LoginRsp)localObject).tickets.auth_key.get());
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr;
        if (((LoginMergedProto.LoginRsp)localObject).result.get() != 0) {
          break label193;
        }
        bool = true;
        LoginMgr.a(paramArrayOfByte, bool);
        if (this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr$Listener != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr$Listener.a(((LoginMergedProto.LoginRsp)localObject).result.get(), ((LoginMergedProto.LoginRsp)localObject).errMsg.get());
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("login parse exception, errMsg=");
        ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
        Log.d("now_live_login_mgr", ((StringBuilder)localObject).toString());
        paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr$Listener;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.a(1000001, "login parse exception");
        }
      }
      return;
      label193:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.LoginMgr.1
 * JD-Core Version:    0.7.0.1
 */