package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class AEPbData$DebugGlassesItem
  extends MessageMicro<DebugGlassesItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "glasses_shape", "glasses_size", "glasses_colordiff", "glasses_slide", "glasses_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DebugGlassesItem.class);
  public final PBInt32Field glasses_colordiff = PBField.initInt32(0);
  public final PBInt32Field glasses_shape = PBField.initInt32(0);
  public final PBInt32Field glasses_size = PBField.initInt32(0);
  public final PBInt32Field glasses_slide = PBField.initInt32(0);
  public final PBInt32Field glasses_type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEPbData.DebugGlassesItem
 * JD-Core Version:    0.7.0.1
 */