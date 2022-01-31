package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xcf4$MutualMarkInfo
  extends MessageMicro<MutualMarkInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "eMutualMarkType", "uint32_level", "uint32_days", "eMutualMarkNewType", "msg_special_word_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), null }, MutualMarkInfo.class);
  public final PBEnumField eMutualMarkNewType = PBField.initEnum(1);
  public final PBEnumField eMutualMarkType = PBField.initEnum(0);
  public oidb_0xcf4.SpecialWordInfo msg_special_word_info = new oidb_0xcf4.SpecialWordInfo();
  public final PBUInt32Field uint32_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualMarkInfo
 * JD-Core Version:    0.7.0.1
 */