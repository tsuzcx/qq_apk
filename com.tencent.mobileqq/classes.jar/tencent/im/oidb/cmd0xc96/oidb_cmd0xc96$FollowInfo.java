package tencent.im.oidb.cmd0xc96;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc96$FollowInfo
  extends MessageMicro<FollowInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "openid", "is_followed", "follow_time" }, new Object[] { "", Boolean.valueOf(false), Integer.valueOf(0) }, FollowInfo.class);
  public final PBUInt32Field follow_time = PBField.initUInt32(0);
  public final PBBoolField is_followed = PBField.initBool(false);
  public final PBStringField openid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.FollowInfo
 * JD-Core Version:    0.7.0.1
 */