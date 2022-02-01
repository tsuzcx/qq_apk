package tencent.aio.media.open;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media_open$ReqOpenStart
  extends MessageMicro<ReqOpenStart>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_req_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_sign = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_aio_type = PBField.initEnum(1);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 34, 42 }, new String[] { "enum_aio_type", "uint64_id", "bytes_req_data", "bytes_req_sign" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, ReqOpenStart.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.aio.media.open.aio_media_open.ReqOpenStart
 * JD-Core Version:    0.7.0.1
 */