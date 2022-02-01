package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xb54$UnionNlpInfo
  extends MessageMicro<UnionNlpInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_union_chann = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_union_tag = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_union_tag", "bytes_union_chann" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, UnionNlpInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.UnionNlpInfo
 * JD-Core Version:    0.7.0.1
 */