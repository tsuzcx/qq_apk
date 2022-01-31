package tencent.im.oidb.cmd0x954;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x954$ReqFeedsParam
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 80, 88, 96, 104 }, new String[] { "uint32_req_like_count", "uint32_req_comment_count", "uint32_req_read_count", "uint32_req_myself_publish", "uint32_school", "uint32_academy", "uint32_topic" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqFeedsParam.class);
  public final PBUInt32Field uint32_academy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_myself_publish = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_read_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_school = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x954.cmd0x954.ReqFeedsParam
 * JD-Core Version:    0.7.0.1
 */