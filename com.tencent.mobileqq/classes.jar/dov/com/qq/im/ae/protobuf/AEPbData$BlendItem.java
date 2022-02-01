package dov.com.qq.im.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AEPbData$BlendItem
  extends MessageMicro<BlendItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21 }, new String[] { "bs_key", "bs_value" }, new Object[] { "", Float.valueOf(0.0F) }, BlendItem.class);
  public final PBStringField bs_key = PBField.initString("");
  public final PBFloatField bs_value = PBField.initFloat(0.0F);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.protobuf.AEPbData.BlendItem
 * JD-Core Version:    0.7.0.1
 */