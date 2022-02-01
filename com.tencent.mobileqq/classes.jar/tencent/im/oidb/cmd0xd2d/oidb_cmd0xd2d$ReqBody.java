package tencent.im.oidb.cmd0xd2d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xd2d$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_req_uin", "uint32_req_category" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_req_category = PBField.initUInt32(0);
  public final PBUInt64Field uint64_req_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d.ReqBody
 * JD-Core Version:    0.7.0.1
 */