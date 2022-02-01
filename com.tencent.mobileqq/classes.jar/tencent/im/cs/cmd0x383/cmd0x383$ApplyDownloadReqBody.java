package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyDownloadReqBody
  extends MessageMicro<ApplyDownloadReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "uint32_bus_id", "str_file_path", "bool_thumbnail_req", "uint32_url_type", "bool_preview_req" }, new Object[] { Integer.valueOf(0), "", Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false) }, ApplyDownloadReqBody.class);
  public final PBBoolField bool_preview_req = PBField.initBool(false);
  public final PBBoolField bool_thumbnail_req = PBField.initBool(false);
  public final PBStringField str_file_path = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyDownloadReqBody
 * JD-Core Version:    0.7.0.1
 */