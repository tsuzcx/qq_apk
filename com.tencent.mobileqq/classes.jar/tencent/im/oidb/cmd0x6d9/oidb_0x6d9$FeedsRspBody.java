package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.cs.group_file_common.group_file_common.FeedsResult;

public final class oidb_0x6d9$FeedsRspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "rpt_feeds_result_list" }, new Object[] { Integer.valueOf(0), "", "", null }, FeedsRspBody.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBRepeatMessageField rpt_feeds_result_list = PBField.initRepeatMessage(group_file_common.FeedsResult.class);
  public final PBStringField str_client_wording = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsRspBody
 * JD-Core Version:    0.7.0.1
 */