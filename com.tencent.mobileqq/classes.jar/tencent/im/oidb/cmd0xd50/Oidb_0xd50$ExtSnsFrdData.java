package tencent.im.oidb.cmd0xd50;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xd50$ExtSnsFrdData
  extends MessageMicro<ExtSnsFrdData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ksing_switch = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_lbs_share = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_music_switch = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mutualmark_alienation = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mutualmark_score = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field frd_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 728010, 808010, 1128010, 1208010, 1448010 }, new String[] { "frd_uin", "bytes_music_switch", "bytes_mutualmark_alienation", "bytes_mutualmark_score", "bytes_ksing_switch", "bytes_lbs_share" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, ExtSnsFrdData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd50.Oidb_0xd50.ExtSnsFrdData
 * JD-Core Version:    0.7.0.1
 */