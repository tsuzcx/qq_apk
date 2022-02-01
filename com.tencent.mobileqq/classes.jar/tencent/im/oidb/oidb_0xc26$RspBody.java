package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xc26$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_newuser = PBField.initBool(false);
  public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField em_rsp_data_type = PBField.initEnum(1);
  public final PBRepeatField<Integer> rpt_entry_close = PBField.initRepeat(PBEnumField.__repeatHelper__);
  public final PBRepeatMessageField<oidb_0xc26.EntryDelay> rpt_entry_delays = PBField.initRepeatMessage(oidb_0xc26.EntryDelay.class);
  public final PBRepeatField<Integer> rpt_entry_inuse = PBField.initRepeat(PBEnumField.__repeatHelper__);
  public final PBRepeatMessageField<oidb_0xc26.MayKnowPerson> rpt_msg_persons = PBField.initRepeatMessage(oidb_0xc26.MayKnowPerson.class);
  public final PBRepeatMessageField<oidb_0xc26.RecommendInfo> rpt_msg_rgroup_items = PBField.initRepeatMessage(oidb_0xc26.RecommendInfo.class);
  public final PBRepeatMessageField<oidb_0xc26.TabInfo> rpt_msg_tables = PBField.initRepeatMessage(oidb_0xc26.TabInfo.class);
  public final PBUInt32Field uint32_add_page_list_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_list_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_up = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_gap = PBField.initUInt32(0);
  public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(1);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 64, 72, 80, 90, 96, 106, 114 }, new String[] { "rpt_msg_persons", "rpt_entry_inuse", "rpt_entry_close", "uint32_next_gap", "uint32_timestamp", "uint32_msg_up", "rpt_entry_delays", "uint32_list_switch", "uint32_add_page_list_switch", "em_rsp_data_type", "rpt_msg_rgroup_items", "bool_is_newuser", "rpt_msg_tables", "bytes_cookies" }, new Object[] { null, localInteger2, localInteger2, localInteger1, localInteger1, localInteger1, null, localInteger1, localInteger1, localInteger2, null, Boolean.valueOf(false), null, localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc26.RspBody
 * JD-Core Version:    0.7.0.1
 */