package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mutualmark$SpecialWordAttribute
  extends MessageMicro<SpecialWordAttribute>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_card_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_card_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public mutualmark.SpecialWordCardGetInfo msg_max_special_word_card_get_info = new mutualmark.SpecialWordCardGetInfo();
  public mutualmark.SpecialWordCardGetInfo msg_min_special_word_card_get_info = new mutualmark.SpecialWordCardGetInfo();
  public final PBUInt64Field uint64_last_off_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_on_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_set_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_set_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_word_light_up_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 66, 74 }, new String[] { "bytes_card_id", "bytes_card_color", "uint64_set_uin", "uint64_last_set_time", "uint64_last_on_time", "uint64_last_off_time", "uint64_word_light_up_time", "msg_min_special_word_card_get_info", "msg_max_special_word_card_get_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localLong, localLong, localLong, localLong, localLong, null, null }, SpecialWordAttribute.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.mutualmark.mutualmark.SpecialWordAttribute
 * JD-Core Version:    0.7.0.1
 */