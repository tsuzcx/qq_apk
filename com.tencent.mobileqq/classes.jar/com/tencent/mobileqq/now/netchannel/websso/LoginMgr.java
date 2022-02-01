package com.tencent.mobileqq.now.netchannel.websso;

import com.tencent.mobileqq.now.NowQQLiveHelper;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LoginTicketInfo;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.LogoutReq;
import com.tencent.mobileqq.now.loginmerge.LoginMergedProto.TicketInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class LoginMgr
{
  private static LoginMgr jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public static LoginMgr a()
  {
    if (jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr == null)
    {
      jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr = new LoginMgr();
      ChannelCenter.a().b(NowQQLiveHelper.b());
    }
    return jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr;
  }
  
  public static void a()
  {
    jdField_a_of_type_ComTencentMobileqqNowNetchannelWebssoLoginMgr = null;
  }
  
  public void a(LoginMgr.Listener paramListener)
  {
    LoginMergedProto.LoginReq localLoginReq = new LoginMergedProto.LoginReq();
    LoginMergedProto.LoginTicketInfo localLoginTicketInfo = new LoginMergedProto.LoginTicketInfo();
    localLoginTicketInfo.client_version.set(0);
    localLoginTicketInfo.login_type.set(0);
    localLoginTicketInfo.client_type.set(16130);
    LoginMergedProto.TicketInfo localTicketInfo = new LoginMergedProto.TicketInfo();
    localLoginTicketInfo.account_id.set(UserInfoMgr.a());
    localLoginTicketInfo.auth_appid.set("16");
    localTicketInfo.auth_key.set(UserInfoMgr.c());
    localLoginTicketInfo.ticket_info.set(localTicketInfo);
    localLoginReq.login_ticket_info.set(localLoginTicketInfo);
    ChannelCenter.a().a(30840, 1, localLoginReq.toByteArray(), new LoginMgr.1(this, paramListener));
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    LoginMergedProto.LogoutReq localLogoutReq = new LoginMergedProto.LogoutReq();
    ChannelCenter.a().a(30840, 2, localLogoutReq.toByteArray(), new LoginMgr.2(this));
    ChannelCenter.b();
    UserInfoMgr.a();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.LoginMgr
 * JD-Core Version:    0.7.0.1
 */