package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicContentRecommend$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cache_time = PBField.initUInt32(0);
  public final PBBytesField error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field result_code = PBField.initUInt32(0);
  public final PBRepeatMessageField result_items = PBField.initRepeatMessage(DynamicContentRecommend.ContentRecommend.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "result_items", "result_code", "error_msg", "cache_time" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     pb.unite.search.DynamicContentRecommend.RspBody
 * JD-Core Version:    0.7.0.1
 */