package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype11
  extends MessageMicro<MsgElemInfo_servtype11>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_Doodle_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_Doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_resID = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_resMD5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField reserve_Info1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField reserve_Info2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_doodleData_offset = PBField.initUInt32(0);
  public final PBUInt32Field uint32_doodle_gif_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58, 66 }, new String[] { "bytes_resID", "bytes_resMD5", "reserve_Info1", "reserve_Info2", "uint32_doodleData_offset", "uint32_doodle_gif_id", "bytes_Doodle_url", "bytes_Doodle_md5" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localInteger, localInteger, localByteStringMicro5, localByteStringMicro6 }, MsgElemInfo_servtype11.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype11
 * JD-Core Version:    0.7.0.1
 */