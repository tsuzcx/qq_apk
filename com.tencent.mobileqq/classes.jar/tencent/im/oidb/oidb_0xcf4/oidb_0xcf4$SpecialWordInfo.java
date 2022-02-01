package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xcf4$SpecialWordInfo
  extends MessageMicro<SpecialWordInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_card_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_static_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wording_1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wording_2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_all_word_light_up_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_close_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mark_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recentchat_msg_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64 }, new String[] { "bytes_card_id", "bytes_static_url", "bytes_wording_1", "bytes_wording_2", "uint32_close_flag", "uint32_recentchat_msg_count", "uint32_all_word_light_up_days", "uint32_mark_days" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localInteger, localInteger, localInteger, localInteger }, SpecialWordInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.SpecialWordInfo
 * JD-Core Version:    0.7.0.1
 */