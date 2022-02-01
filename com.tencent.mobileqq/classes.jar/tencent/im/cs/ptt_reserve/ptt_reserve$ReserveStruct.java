package tencent.im.cs.ptt_reserve;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ptt_reserve$ReserveStruct
  extends MessageMicro<ReserveStruct>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_general_flags = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_redpack_score_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_voice_text_abs = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_autototext_voice = PBField.initUInt32(0);
  public final PBUInt32Field uint32_change_voice = PBField.initUInt32(0);
  public final PBUInt32Field uint32_color_text_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_redpack_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 40, 50, 56, 66 }, new String[] { "uint32_change_voice", "bytes_general_flags", "uint32_color_text_id", "uint32_redpack_type", "bytes_redpack_score_id", "uint32_autototext_voice", "bytes_voice_text_abs" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localInteger, localByteStringMicro2, localInteger, localByteStringMicro3 }, ReserveStruct.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct
 * JD-Core Version:    0.7.0.1
 */