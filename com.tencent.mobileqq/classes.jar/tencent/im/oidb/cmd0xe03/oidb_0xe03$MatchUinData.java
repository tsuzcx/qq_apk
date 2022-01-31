package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe03$MatchUinData
  extends MessageMicro<MatchUinData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_company = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_constellation = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_declaration = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_long_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_school = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_voice_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0xe03.schoolInfo> rpt_school_info = PBField.initRepeatMessage(oidb_0xe03.schoolInfo.class);
  public final PBRepeatMessageField<oidb_0xe03.ProfileTagInfo> rpt_tag = PBField.initRepeatMessage(oidb_0xe03.ProfileTagInfo.class);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_popularity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_voice_duration = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 72, 80, 90, 98, 114, 120 }, new String[] { "uint32_age", "bytes_constellation", "bytes_city", "bytes_school", "rpt_tag", "bytes_company", "bytes_declaration", "bytes_voice_url", "uint32_voice_duration", "uint32_sex", "bytes_long_nick", "bytes_nick", "rpt_school_info", "uint32_popularity" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, null, Integer.valueOf(0) }, MatchUinData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe03.oidb_0xe03.MatchUinData
 * JD-Core Version:    0.7.0.1
 */