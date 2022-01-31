package tencent.im.oidb.cmd0xc78;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc78$ImgInfo
  extends MessageMicro<ImgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "md5", "sha1", "width", "height", "qr_decode_type", "qr_code_result" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "", "" }, ImgInfo.class);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBStringField md5 = PBField.initString("");
  public final PBStringField qr_code_result = PBField.initString("");
  public final PBStringField qr_decode_type = PBField.initString("");
  public final PBStringField sha1 = PBField.initString("");
  public final PBUInt32Field width = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc78.oidb_cmd0xc78.ImgInfo
 * JD-Core Version:    0.7.0.1
 */