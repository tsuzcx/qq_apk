package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class faceroam_sso$RspUserInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "filename", "delete_file", "bid", "max_roam_size", "uint32_emoji_type" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, RspUserInfo.class);
  public final PBStringField bid = PBField.initString("");
  public final PBRepeatField delete_file = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField filename = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field max_roam_size = PBField.initUInt32(0);
  public final PBRepeatField uint32_emoji_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.faceroam_sso.faceroam_sso.RspUserInfo
 * JD-Core Version:    0.7.0.1
 */