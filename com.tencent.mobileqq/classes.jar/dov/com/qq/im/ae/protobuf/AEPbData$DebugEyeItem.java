package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class AEPbData$DebugEyeItem
  extends MessageMicro<DebugEyeItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "eyelids_left", "eyelids_right", "eyelids_weight", "eyelids_leftpos", "eyelids_rightpos" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DebugEyeItem.class);
  public final PBInt32Field eyelids_left = PBField.initInt32(0);
  public final PBInt32Field eyelids_leftpos = PBField.initInt32(0);
  public final PBInt32Field eyelids_right = PBField.initInt32(0);
  public final PBInt32Field eyelids_rightpos = PBField.initInt32(0);
  public final PBInt32Field eyelids_weight = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEPbData.DebugEyeItem
 * JD-Core Version:    0.7.0.1
 */