package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345$ReqBody$SubCmd0x1ReqBody
  extends MessageMicro<SubCmd0x1ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64 }, new String[] { "str_md5", "str_sha", "str_file_name", "uint64_file_size", "uint32_upload_type", "uint32_disscus_uin", "uint32_sender_uin", "uint32_costom_id" }, new Object[] { "", "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x1ReqBody.class);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_md5 = PBField.initString("");
  public final PBStringField str_sha = PBField.initString("");
  public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_disscus_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sender_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x1ReqBody
 * JD-Core Version:    0.7.0.1
 */