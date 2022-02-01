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
  private static LoginMgr c;
  private boolean a = false;
  private boolean b = false;
  
  public static LoginMgr a()
  {
    if (c == null)
    {
      c = new LoginMgr();
      ChannelCenter.b().b(NowQQLiveHelper.d());
    }
    return c;
  }
  
  public static void b()
  {
    c = null;
  }
  
  public void a(LoginMgr.Listener paramListener)
  {
    LoginMergedProto.LoginReq localLoginReq = new LoginMergedProto.LoginReq();
    LoginMergedProto.LoginTicketInfo localLoginTicketInfo = new LoginMergedProto.LoginTicketInfo();
    localLoginTicketInfo.client_version.set(0);
    localLoginTicketInfo.login_type.set(0);
    localLoginTicketInfo.client_type.set(16130);
    LoginMergedProto.TicketInfo localTicketInfo = new LoginMergedProto.TicketInfo();
    localLoginTicketInfo.account_id.set(UserInfoMgr.f());
    localLoginTicketInfo.auth_appid.set("16");
    localTicketInfo.auth_key.set(UserInfoMgr.h());
    localLoginTicketInfo.ticket_info.set(localTicketInfo);
    localLoginReq.login_ticket_info.set(localLoginTicketInfo);
    ChannelCenter.b().a(30840, 1, localLoginReq.toByteArray(), new LoginMgr.1(this, paramListener));
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public void d()
  {
    this.a = true;
    LoginMergedProto.LogoutReq localLogoutReq = new LoginMergedProto.LogoutReq();
    ChannelCenter.b().a(30840, 2, localLogoutReq.toByteArray(), new LoginMgr.2(this));
    ChannelCenter.c();
    UserInfoMgr.b();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.netchannel.websso.LoginMgr
 * JD-Core Version:    0.7.0.1
 */