package tencent.im.oidb.qqmusic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MusicSongInfoMatch$CMsgResponse
  extends MessageMicro<CMsgResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field code = PBField.initUInt64(0L);
  public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field reqtype = PBField.initUInt32(0);
  public final PBUInt32Field subcode = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "code", "subcode", "msg", "data", "reqtype" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, CMsgResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qqmusic.MusicSongInfoMatch.CMsgResponse
 * JD-Core Version:    0.7.0.1
 */