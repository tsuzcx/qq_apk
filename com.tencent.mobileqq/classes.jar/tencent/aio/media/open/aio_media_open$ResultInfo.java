package tencent.aio.media.open;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class aio_media_open$ResultInfo
  extends MessageMicro<ResultInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_show_err = PBField.initBool(false);
  public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_result", "bytes_errmsg", "bool_show_err" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Boolean.valueOf(false) }, ResultInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.aio.media.open.aio_media_open.ResultInfo
 * JD-Core Version:    0.7.0.1
 */