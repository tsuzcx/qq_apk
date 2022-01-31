package pb.unify.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UnifySearchCommon$ExtensionRequestInfo
  extends MessageMicro<ExtensionRequestInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField action = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field adcode = PBField.initUInt32(0);
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field key_word_src = PBField.initUInt32(0);
  public final PBFloatField latitude = PBField.initFloat(0.0F);
  public final PBFloatField longitude = PBField.initFloat(0.0F);
  public final PBInt32Field radius = PBField.initInt32(0);
  public final PBBytesField region = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> rpt_pubacc_local_result = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 29, 32, 42, 50, 56, 64, 72 }, new String[] { "action", "latitude", "longitude", "radius", "city", "region", "key_word_src", "rpt_pubacc_local_result", "adcode" }, new Object[] { localByteStringMicro1, Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ExtensionRequestInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pb.unify.search.UnifySearchCommon.ExtensionRequestInfo
 * JD-Core Version:    0.7.0.1
 */