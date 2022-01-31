package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyLinkFileReqBody
  extends MessageMicro<ApplyLinkFileReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_src_bus_id", "str_src_file_path", "uint32_dst_bus_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, ApplyLinkFileReqBody.class);
  public final PBStringField str_src_file_path = PBField.initString("");
  public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyLinkFileReqBody
 * JD-Core Version:    0.7.0.1
 */