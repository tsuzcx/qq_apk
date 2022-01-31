package tencent.im.oidb.cmd0xe16;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xe16$ContentInfo
  extends MessageMicro<ContentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_rowkey", "uint32_src" }, new Object[] { "", Integer.valueOf(0) }, ContentInfo.class);
  public final PBStringField str_rowkey = PBField.initString("");
  public final PBUInt32Field uint32_src = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ContentInfo
 * JD-Core Version:    0.7.0.1
 */