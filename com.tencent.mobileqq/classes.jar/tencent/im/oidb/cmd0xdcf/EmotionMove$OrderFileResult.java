package tencent.im.oidb.cmd0xdcf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class EmotionMove$OrderFileResult
  extends MessageMicro<OrderFileResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26, 32, 40 }, new String[] { "filename", "bid", "max_roam_size", "uint32_emoji_type" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, OrderFileResult.class);
  public final PBStringField bid = PBField.initString("");
  public final PBRepeatField<String> filename = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field max_roam_size = PBField.initUInt32(0);
  public final PBRepeatField<Integer> uint32_emoji_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcf.EmotionMove.OrderFileResult
 * JD-Core Version:    0.7.0.1
 */