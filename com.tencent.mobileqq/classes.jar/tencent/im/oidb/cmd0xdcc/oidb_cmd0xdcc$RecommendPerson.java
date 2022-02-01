package tencent.im.oidb.cmd0xdcc;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xdcc$RecommendPerson
  extends MessageMicro<RecommendPerson>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_alghrithm = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_keyword = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recall = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint64_uin", "bytes_reason", "bytes_keyword", "bytes_alghrithm", "bytes_recall" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RecommendPerson.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.RecommendPerson
 * JD-Core Version:    0.7.0.1
 */