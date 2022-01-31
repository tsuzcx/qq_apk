package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class mobileqq_qidian$GetCorpUinDetailInfoRspBody
  extends MessageMicro<GetCorpUinDetailInfoRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret", "msg_external_info", "rpt_msg_config_group_info" }, new Object[] { Integer.valueOf(0), null, null }, GetCorpUinDetailInfoRspBody.class);
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public mobileqq_qidian.ExternalInfo msg_external_info = new mobileqq_qidian.ExternalInfo();
  public final PBRepeatMessageField<mobileqq_qidian.ConfigGroupInfo> rpt_msg_config_group_info = PBField.initRepeatMessage(mobileqq_qidian.ConfigGroupInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.GetCorpUinDetailInfoRspBody
 * JD-Core Version:    0.7.0.1
 */