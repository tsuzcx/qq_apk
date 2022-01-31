package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VipFunCallAndRing$TSsoRsp
  extends MessageMicro<TSsoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "i32_ret", "str_msg", "st_cmd0x1_rsp", "st_cmd0x2_rsp", "st_cmd0x3_rsp", "st_cmd0x4_rsp", "st_cmd0x5_rsp", "str_url", "str_act_wording" }, new Object[] { Integer.valueOf(0), "", null, null, null, null, null, "", "" }, TSsoRsp.class);
  public final PBInt32Field i32_ret = PBField.initInt32(0);
  public VipFunCallAndRing.TSsoCmd0x1Rsp st_cmd0x1_rsp = new VipFunCallAndRing.TSsoCmd0x1Rsp();
  public VipFunCallAndRing.TSsoCmd0x2Rsp st_cmd0x2_rsp = new VipFunCallAndRing.TSsoCmd0x2Rsp();
  public VipFunCallAndRing.TSsoCmd0x3Rsp st_cmd0x3_rsp = new VipFunCallAndRing.TSsoCmd0x3Rsp();
  public VipFunCallAndRing.TSsoCmd0x4Rsp st_cmd0x4_rsp = new VipFunCallAndRing.TSsoCmd0x4Rsp();
  public VipFunCallAndRing.TSsoCmd0x5Rsp st_cmd0x5_rsp = new VipFunCallAndRing.TSsoCmd0x5Rsp();
  public final PBStringField str_act_wording = PBField.initString("");
  public final PBStringField str_msg = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.funcall.VipFunCallAndRing.TSsoRsp
 * JD-Core Version:    0.7.0.1
 */