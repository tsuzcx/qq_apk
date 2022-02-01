package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb60$CheckUrlRsp
  extends MessageMicro<CheckUrlRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "is_authed", "next_req_duration" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0) }, CheckUrlRsp.class);
  public final PBBoolField is_authed = PBField.initBool(false);
  public final PBUInt32Field next_req_duration = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb60.CheckUrlRsp
 * JD-Core Version:    0.7.0.1
 */