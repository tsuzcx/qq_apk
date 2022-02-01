package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xcf4$MutualScoreCard
  extends MessageMicro<MutualScoreCard>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_button_describe = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_button_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_level_describe = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_type_describe = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField eMutualMarkNewType = PBField.initEnum(1);
  public final PBUInt32Field uint32_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_score = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 82, 88, 98, 106, 114, 122 }, new String[] { "eMutualMarkNewType", "uint32_level", "uint32_days", "bytes_title", "uint32_score", "bytes_type_describe", "bytes_level_describe", "bytes_button_describe", "bytes_button_url" }, new Object[] { Integer.valueOf(1), localInteger, localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, MutualScoreCard.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualScoreCard
 * JD-Core Version:    0.7.0.1
 */