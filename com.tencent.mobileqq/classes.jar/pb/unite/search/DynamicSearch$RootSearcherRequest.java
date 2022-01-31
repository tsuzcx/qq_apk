package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DynamicSearch$RootSearcherRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field business = PBField.initUInt32(0);
  public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField ocean_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field page_size = PBField.initUInt32(0);
  public final PBRepeatField rpt_busi_mask = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field use_all_mask = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 32, 80, 90, 402, 408 }, new String[] { "business", "page_size", "rpt_busi_mask", "cookie", "ocean_data", "use_all_mask" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, RootSearcherRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     pb.unite.search.DynamicSearch.RootSearcherRequest
 * JD-Core Version:    0.7.0.1
 */