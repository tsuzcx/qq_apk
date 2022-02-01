package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.medal.common.MedalInfo;

public final class cmd0x7a8$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_new_count = PBField.initInt32(0);
  public final PBInt32Field int32_upgrade_count = PBField.initInt32(0);
  public final PBRepeatMessageField<common.MedalInfo> rpt_msg_medal = PBField.initRepeatMessage(common.MedalInfo.class);
  public final PBStringField str_nick = PBField.initString("");
  public final PBStringField str_prompt_params = PBField.initString("");
  public final PBUInt32Field uint32_fri_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_metal_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_metal_rank = PBField.initUInt32(0);
  public final PBUInt32Field uint32_metal_total = PBField.initUInt32(0);
  public final PBUInt32Field uint32_now = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_point = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 64, 72, 80, 90, 96 }, new String[] { "str_nick", "uint32_metal_rank", "uint32_fri_count", "uint32_metal_count", "uint32_metal_total", "rpt_msg_medal", "uint32_total_point", "int32_new_count", "int32_upgrade_count", "str_prompt_params", "uint32_now" }, new Object[] { "", localInteger, localInteger, localInteger, localInteger, null, localInteger, localInteger, localInteger, "", localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7a8.RspBody
 * JD-Core Version:    0.7.0.1
 */