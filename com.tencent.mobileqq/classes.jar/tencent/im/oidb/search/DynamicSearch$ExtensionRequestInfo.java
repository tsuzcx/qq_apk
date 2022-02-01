package tencent.im.oidb.search;

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

public final class DynamicSearch$ExtensionRequestInfo
  extends MessageMicro<ExtensionRequestInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField action = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field key_word_src = PBField.initUInt32(0);
  public final PBFloatField latitude = PBField.initFloat(0.0F);
  public final PBFloatField longitude = PBField.initFloat(0.0F);
  public final PBInt32Field radius = PBField.initInt32(0);
  public final PBBytesField region = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> rpt_pubacc_local_result = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Float localFloat = Float.valueOf(0.0F);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 29, 32, 42, 50, 56, 64 }, new String[] { "action", "latitude", "longitude", "radius", "city", "region", "key_word_src", "rpt_pubacc_local_result" }, new Object[] { localByteStringMicro1, localFloat, localFloat, localInteger, localByteStringMicro2, localByteStringMicro3, localInteger, Long.valueOf(0L) }, ExtensionRequestInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.search.DynamicSearch.ExtensionRequestInfo
 * JD-Core Version:    0.7.0.1
 */