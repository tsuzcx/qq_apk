package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.DateUtils;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.GetFlagInfoReq;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.ReqBody;

public class RIJYoungsterModule
{
  public static void a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)RIJSPUtils.b("key_sp_readinjoy_youngster_last_pull_time", Long.valueOf(0L))).longValue();
    int i = 0;
    if (((Integer)RIJSPUtils.b("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 0) {
      i = 1;
    }
    if ((DateUtils.isSameDay(l1, l2)) && (i == 0)) {
      return;
    }
    QLog.e("RIJYoungsterModule", 2, "updateSelfYoungsterModeSetting.");
    RIJSPUtils.a("key_sp_readinjoy_youngster_last_pull_time", Long.valueOf(l1));
    oidb_0xe1b.ReqBody localReqBody = new oidb_0xe1b.ReqBody();
    localReqBody.uint32_req_type.set(1);
    oidb_0xe1b.GetFlagInfoReq localGetFlagInfoReq = new oidb_0xe1b.GetFlagInfoReq();
    localGetFlagInfoReq.rpt_uint64_uin_list.add(Long.valueOf(RIJQQAppInterfaceUtil.d()));
    localGetFlagInfoReq.uint32_need_teenager_flag.set(1);
    localReqBody.msg_get_flag_info_req.set(localGetFlagInfoReq);
    ProtoUtils.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), new RIJYoungsterModule.1(), localReqBody.toByteArray(), "OidbSvc.0xe1b", 3611, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.RIJYoungsterModule
 * JD-Core Version:    0.7.0.1
 */