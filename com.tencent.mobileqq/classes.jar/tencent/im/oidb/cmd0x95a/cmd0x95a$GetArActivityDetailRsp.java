package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x95a$GetArActivityDetailRsp
  extends MessageMicro<GetArActivityDetailRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "uint64_uin", "uint32_activity_id", "uint32_activity_type", "str_activity_name", "str_head_pic_url", "str_activity_desc", "rpt_str_identify_pic_url", "str_identify_pic_wording" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "" }, GetArActivityDetailRsp.class);
  public final PBRepeatField<String> rpt_str_identify_pic_url = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_activity_desc = PBField.initString("");
  public final PBStringField str_activity_name = PBField.initString("");
  public final PBStringField str_head_pic_url = PBField.initString("");
  public final PBStringField str_identify_pic_wording = PBField.initString("");
  public final PBUInt32Field uint32_activity_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_activity_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.GetArActivityDetailRsp
 * JD-Core Version:    0.7.0.1
 */