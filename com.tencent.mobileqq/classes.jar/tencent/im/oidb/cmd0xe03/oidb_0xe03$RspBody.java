package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe03$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_match_fail_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_matchopcode = PBField.initEnum(1);
  public final PBEnumField enum_matchopretcode = PBField.initEnum(0);
  public oidb_0xe03.MatchInfo msg_match_info = new oidb_0xe03.MatchInfo();
  public final PBRepeatMessageField<oidb_0xe03.TagInfo> rpt_tag = PBField.initRepeatMessage(oidb_0xe03.TagInfo.class);
  public final PBRepeatField<ByteStringMicro> rpt_tips_wording = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field uint32_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_default_tag_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_switch = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  public final PBRepeatField<Long> uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 72, 82, 90, 98, 104, 112 }, new String[] { "uint64_uin", "enum_matchopcode", "enum_matchopretcode", "msg_match_info", "uint32_switch", "uint32_default_tag_id", "rpt_tag", "rpt_tips_wording", "bytes_match_fail_wording", "uint32_count", "uint64_uin_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe03.oidb_0xe03.RspBody
 * JD-Core Version:    0.7.0.1
 */