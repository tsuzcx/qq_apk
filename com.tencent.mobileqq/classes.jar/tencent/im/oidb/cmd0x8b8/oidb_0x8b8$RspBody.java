package tencent.im.oidb.cmd0x8b8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x8b8$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_0x8b8.GroupPicListInfo> rpt_msg_pic_list_info = PBField.initRepeatMessage(oidb_0x8b8.GroupPicListInfo.class);
  public final PBRepeatField<Integer> rpt_uint32_pic_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_default_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pic_cnt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "uint32_result", "uint64_group_uin", "uint32_sequence", "uint32_subcmd", "uint32_default_id", "uint32_pic_cnt", "rpt_uint32_pic_list", "rpt_msg_pic_list_info" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger, localInteger, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b8.oidb_0x8b8.RspBody
 * JD-Core Version:    0.7.0.1
 */