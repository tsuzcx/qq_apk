package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$NegFeedback
  extends MessageMicro<NegFeedback>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_type_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_f_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_type_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_type_id", "bytes_type_desc", "uint32_id", "uint32_f_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro, localInteger, localInteger }, NegFeedback.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.NegFeedback
 * JD-Core Version:    0.7.0.1
 */