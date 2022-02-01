package tencent.im.s2c.msgtype0x210.submsgtype0x94;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Submsgtype0x94$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_folder_msg = PBField.initString("");
  public final PBStringField str_jump_url = PBField.initString("");
  public final PBStringField str_task_info = PBField.initString("");
  public final PBStringField str_type_color = PBField.initString("");
  public final PBStringField str_type_name = PBField.initString("");
  public final PBUInt32Field uint32_discount_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_discover_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_ts = PBField.initUInt32(0);
  public final PBUInt32Field uint32_folder_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mine_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_nearby_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_only_discount_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_only_discover_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_only_mine_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_only_nearby_reddot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_period_of_validity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_ts = PBField.initUInt32(0);
  public final PBUInt32Field uint32_task_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_task_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 64, 72, 80, 88, 96, 104, 112, 120, 130, 138, 146, 154 }, new String[] { "uint32_task_id", "uint32_folder_reddot_flag", "uint32_discover_reddot_flag", "uint32_start_ts", "uint32_end_ts", "uint32_period_of_validity", "str_folder_msg", "uint32_discount_reddot_flag", "uint32_nearby_reddot_flag", "uint32_mine_reddot_flag", "uint32_only_discover_reddot_flag", "uint32_only_discount_reddot_flag", "uint32_only_nearby_reddot_flag", "uint32_only_mine_reddot_flag", "uint32_task_type", "str_task_info", "str_type_name", "str_type_color", "str_jump_url" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, "", localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, "", "", "", "" }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x94.Submsgtype0x94.MsgBody
 * JD-Core Version:    0.7.0.1
 */