package tencent.im.oidb.cmd0xc78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc78$AppFileMsgInfo
  extends MessageMicro<AppFileMsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "md5", "sha1", "file_size" }, new Object[] { "", "", Integer.valueOf(0) }, AppFileMsgInfo.class);
  public final PBUInt32Field file_size = PBField.initUInt32(0);
  public final PBStringField md5 = PBField.initString("");
  public final PBStringField sha1 = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.AppFileMsgInfo
 * JD-Core Version:    0.7.0.1
 */