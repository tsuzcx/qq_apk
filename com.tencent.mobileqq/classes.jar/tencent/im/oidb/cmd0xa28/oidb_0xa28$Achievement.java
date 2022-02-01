package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa28$Achievement
  extends MessageMicro<Achievement>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_score = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_mvp_level = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_round = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_super = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_mvp_level", "uint64_super", "bytes_score", "uint64_round" }, new Object[] { localLong, localLong, localByteStringMicro, localLong }, Achievement.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa28.oidb_0xa28.Achievement
 * JD-Core Version:    0.7.0.1
 */