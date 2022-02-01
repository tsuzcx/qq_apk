package tencent.im.oidb.cmd0xefe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xefe$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "friend_uin", "last_ts", "deleted" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, ReqBody.class);
  public final PBBoolField deleted = PBField.initBool(false);
  public final PBUInt64Field friend_uin = PBField.initUInt64(0L);
  public final PBInt64Field last_ts = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xefe.oidb_cmd0xefe.ReqBody
 * JD-Core Version:    0.7.0.1
 */