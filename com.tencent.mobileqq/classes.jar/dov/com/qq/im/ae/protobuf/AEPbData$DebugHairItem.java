package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class AEPbData$DebugHairItem
  extends MessageMicro<DebugHairItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "hair_style", "hair_length", "hair_shape", "hair_affinestyle", "head_road" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DebugHairItem.class);
  public final PBInt32Field hair_affinestyle = PBField.initInt32(0);
  public final PBInt32Field hair_length = PBField.initInt32(0);
  public final PBInt32Field hair_shape = PBField.initInt32(0);
  public final PBInt32Field hair_style = PBField.initInt32(0);
  public final PBInt32Field head_road = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEPbData.DebugHairItem
 * JD-Core Version:    0.7.0.1
 */