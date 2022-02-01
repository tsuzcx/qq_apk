package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicDiscovery$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bucket_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public final PBBytesField jce_rsp_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field result_code = PBField.initUInt32(0);
  public final PBRepeatMessageField<DynamicDiscovery.Result> result_items = PBField.initRepeatMessage(DynamicDiscovery.Result.class);
  public final PBBytesField rsp_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 58 }, new String[] { "result_items", "result_code", "error_msg", "expire_time", "bucket_id", "rsp_ext", "jce_rsp_buffer" }, new Object[] { null, localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.search.DynamicDiscovery.RspBody
 * JD-Core Version:    0.7.0.1
 */