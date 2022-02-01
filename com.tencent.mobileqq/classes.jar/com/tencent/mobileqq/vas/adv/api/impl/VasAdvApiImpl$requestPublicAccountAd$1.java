package com.tencent.mobileqq.vas.adv.api.impl;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.adv.base.VasAdvBizCallback;
import com.tencent.mobileqq.vas.adv.base.service.VasAdvService;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.common.pb.AdvPush.AdvPushReq;
import com.tencent.mobileqq.vas.adv.common.pb.AdvPush.UserInfo;
import cooperation.qzone.QUA;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VasAdvApiImpl$requestPublicAccountAd$1
  implements Runnable
{
  VasAdvApiImpl$requestPublicAccountAd$1(VasAdvApiImpl paramVasAdvApiImpl, long paramLong) {}
  
  public final void run()
  {
    AdvPush.AdvPushReq localAdvPushReq = new AdvPush.AdvPushReq();
    Object localObject = localAdvPushReq.user_info;
    AdvPush.UserInfo localUserInfo = new AdvPush.UserInfo();
    localUserInfo.uin.set(VasAdvSupport.a.a().a());
    localUserInfo.app.set("app");
    localUserInfo.os.set("and");
    localUserInfo.version.set("8.7.0");
    localUserInfo.qua.set(QUA.getQUA3());
    ((AdvPush.UserInfo)localObject).set((MessageMicro)localUserInfo);
    localObject = new JSONObject();
    ((JSONObject)localObject).put("device_info", VasAdvSupport.a.a().a("1018ec"));
    localAdvPushReq.gdt_args.set(((JSONObject)localObject).toString());
    VasAdvService.a.a(localAdvPushReq, (VasAdvBizCallback)new VasAdvApiImpl.requestPublicAccountAd.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.api.impl.VasAdvApiImpl.requestPublicAccountAd.1
 * JD-Core Version:    0.7.0.1
 */