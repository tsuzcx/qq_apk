package tencent.im.oidb.cmd0xf00;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf00$GroupInfoExt
  extends MessageMicro<GroupInfoExt>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_lucky_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_essential_msg_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_light_char_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reserver = PBField.initUInt32(0);
  public final PBUInt32Field uint32_star_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_lucky_word_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint32_reserver", "uint64_lucky_word_id", "uint32_light_char_num", "bytes_lucky_word", "uint32_star_id", "uint32_essential_msg_switch" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localByteStringMicro, localInteger, localInteger }, GroupInfoExt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf00.oidb_0xf00.GroupInfoExt
 * JD-Core Version:    0.7.0.1
 */