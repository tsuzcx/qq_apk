package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class faceroam_sso$RspUserInfo
  extends MessageMicro<RspUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField bid = PBField.initString("");
  public final PBRepeatField<String> delete_file = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> filename = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field max_roam_size = PBField.initUInt32(0);
  public final PBRepeatField<Integer> uint32_emoji_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "filename", "delete_file", "bid", "max_roam_size", "uint32_emoji_type" }, new Object[] { "", "", "", localInteger, localInteger }, RspUserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.faceroam_sso.faceroam_sso.RspUserInfo
 * JD-Core Version:    0.7.0.1
 */