package tencent.im.oidb.cmd0xe3b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe3b$HighlightTitle
  extends MessageMicro<HighlightTitle>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_highlight_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_title_type = PBField.initEnum(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_highlight_title", "enum_title_type", "uint64_uin" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, HighlightTitle.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe3b.oidb_0xe3b.HighlightTitle
 * JD-Core Version:    0.7.0.1
 */