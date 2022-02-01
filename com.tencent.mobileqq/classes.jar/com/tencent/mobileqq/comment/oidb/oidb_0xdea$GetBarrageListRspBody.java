package com.tencent.mobileqq.comment.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdea$GetBarrageListRspBody
  extends MessageMicro<GetBarrageListRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_end = PBField.initBool(false);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBRepeatMessageField<oidb_0xdea.Comment> rpt_comment_list = PBField.initRepeatMessage(oidb_0xdea.Comment.class);
  public final PBRepeatField<Long> rpt_recall_del_seq_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField str_err_msg = PBField.initString("");
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field uint32_last_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_start_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time_interval = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 56, 66, 72, 88, 96 }, new String[] { "int32_ret_code", "str_err_msg", "str_wording", "bool_is_end", "uint32_total_count", "uint32_next_start_index", "rpt_comment_list", "rpt_recall_del_seq_list", "uint32_last_update_time", "uint32_time_interval" }, new Object[] { localInteger, "", "", Boolean.valueOf(false), localInteger, localInteger, null, Long.valueOf(0L), localInteger, localInteger }, GetBarrageListRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.comment.oidb.oidb_0xdea.GetBarrageListRspBody
 * JD-Core Version:    0.7.0.1
 */