package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa2a$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "group_id", "lbs_info", "is_private" }, new Object[] { Long.valueOf(0L), null, Boolean.valueOf(false) }, ReqBody.class);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBBoolField is_private = PBField.initBool(false);
  public oidb_0xa2a.LBSInfo lbs_info = new oidb_0xa2a.LBSInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody
 * JD-Core Version:    0.7.0.1
 */