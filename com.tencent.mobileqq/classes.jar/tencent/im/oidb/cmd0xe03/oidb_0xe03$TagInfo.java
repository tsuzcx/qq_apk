package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe03$TagInfo
  extends MessageMicro<TagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_hot_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_tag_id", "bytes_tag", "uint32_hot_flag" }, new Object[] { localInteger, localByteStringMicro, localInteger }, TagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe03.oidb_0xe03.TagInfo
 * JD-Core Version:    0.7.0.1
 */