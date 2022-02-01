package com.tencent.mobileqq.location.net;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.location.LocationShareServiceHolder;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.TroopLbsSharePushInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x857.TroopTips0x857.LbsShareChangePushInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.NotifyMsgBody;

public class QQTroopLocationPushDecoder
{
  public static void a(AppInterface paramAppInterface, TroopTips0x857.NotifyMsgBody paramNotifyMsgBody)
  {
    paramNotifyMsgBody = (TroopTips0x857.LbsShareChangePushInfo)paramNotifyMsgBody.opt_lbs_share_change_plus_info.get();
    paramNotifyMsgBody = new TroopLbsSharePushInfo(paramNotifyMsgBody.uint32_msg_type.get(), paramNotifyMsgBody.uint64_group_id.get(), paramNotifyMsgBody.uint64_oper_uin.get(), paramNotifyMsgBody.bytes_ext_info.get().toByteArray());
    LocationShareServiceHolder.a(paramAppInterface).processTroopPush(paramNotifyMsgBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.QQTroopLocationPushDecoder
 * JD-Core Version:    0.7.0.1
 */