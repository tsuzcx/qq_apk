package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xfc2$ApplyDownloadReq
  extends MessageMicro<ApplyDownloadReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "str_fileid", "uint32_support_encrypt", "bool_thumbnail" }, new Object[] { "", Integer.valueOf(0), Boolean.valueOf(false) }, ApplyDownloadReq.class);
  public final PBBoolField bool_thumbnail = PBField.initBool(false);
  public final PBStringField str_fileid = PBField.initString("");
  public final PBUInt32Field uint32_support_encrypt = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ApplyDownloadReq
 * JD-Core Version:    0.7.0.1
 */