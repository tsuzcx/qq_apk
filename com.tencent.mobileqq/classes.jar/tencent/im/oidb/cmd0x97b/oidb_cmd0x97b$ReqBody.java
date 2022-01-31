package tencent.im.oidb.cmd0x97b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x97b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "uint64_uin", "uint32_req_ctrl_bits", "uint32_like_total", "uint32_publish_feeds_total", "uint32_sign_in", "uint32_medal", "uint32_column_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_column_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_total = PBField.initUInt32(0);
  public final PBUInt32Field uint32_medal = PBField.initUInt32(0);
  public final PBUInt32Field uint32_publish_feeds_total = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_ctrl_bits = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sign_in = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.ReqBody
 * JD-Core Version:    0.7.0.1
 */