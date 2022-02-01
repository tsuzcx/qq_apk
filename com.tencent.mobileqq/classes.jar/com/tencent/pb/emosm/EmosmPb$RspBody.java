package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmosmPb$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 138, 146, 154, 160 }, new String[] { "uint32_sub_cmd", "int32_result", "msg_subcmd0x1_rsp_deltab", "msg_subcmd0x2_rsp_fetchtab", "msg_subcmd0x3_rsp_fetchbq", "msg_subcmd0x5_recommend", "msg_subcmd0x6_collect_auth", "msg_subcmd0x7_rsp", "msg_subcmd0x8_rsp_addtab", "msg_subcmd0x9_rsp", "msg_subcmd0x10_rsp", "msg_subcmd0x11_rsp", "msg_subcmd0x12_rsp", "msg_subcmd0x13_rsp", "msg_subcmd0x14_rsp_fetchtab_mac", "msg_subcmd0x18_rsp", "msg_subcmd0x19_rsp", "uint32_business_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(0) }, RspBody.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public EmosmPb.SubCmd0x10MoveOrderRsp msg_subcmd0x10_rsp = new EmosmPb.SubCmd0x10MoveOrderRsp();
  public EmosmPb.SubCmd0x11Rsp msg_subcmd0x11_rsp = new EmosmPb.SubCmd0x11Rsp();
  public EmosmPb.SubCmd0x12Rsp msg_subcmd0x12_rsp = new EmosmPb.SubCmd0x12Rsp();
  public EmosmPb.SubCmd0x13Rsp msg_subcmd0x13_rsp = new EmosmPb.SubCmd0x13Rsp();
  public EmosmPb.SubCmd0x14RspFetchTabMac msg_subcmd0x14_rsp_fetchtab_mac = new EmosmPb.SubCmd0x14RspFetchTabMac();
  public EmosmPb.SubCmd0x18Rsp msg_subcmd0x18_rsp = new EmosmPb.SubCmd0x18Rsp();
  public EmosmPb.SubCmd0x19Rsp msg_subcmd0x19_rsp = new EmosmPb.SubCmd0x19Rsp();
  public EmosmPb.SubCmd0x1RspDelTab msg_subcmd0x1_rsp_deltab = new EmosmPb.SubCmd0x1RspDelTab();
  public EmosmPb.SubCmd0x2RspFetchTab msg_subcmd0x2_rsp_fetchtab = new EmosmPb.SubCmd0x2RspFetchTab();
  public EmosmPb.SubCmd0x3RspFetchBq msg_subcmd0x3_rsp_fetchbq = new EmosmPb.SubCmd0x3RspFetchBq();
  public EmosmPb.SubCmd0x5RspBQRecommend msg_subcmd0x5_recommend = new EmosmPb.SubCmd0x5RspBQRecommend();
  public EmosmPb.SubCmd0x6Rsp msg_subcmd0x6_collect_auth = new EmosmPb.SubCmd0x6Rsp();
  public EmosmPb.SubCmd0x7Rsp msg_subcmd0x7_rsp = new EmosmPb.SubCmd0x7Rsp();
  public EmosmPb.SubCmd0x8RspAddTab msg_subcmd0x8_rsp_addtab = new EmosmPb.SubCmd0x8RspAddTab();
  public EmosmPb.SubCmd0x9BqAssocRsp msg_subcmd0x9_rsp = new EmosmPb.SubCmd0x9BqAssocRsp();
  public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.RspBody
 * JD-Core Version:    0.7.0.1
 */