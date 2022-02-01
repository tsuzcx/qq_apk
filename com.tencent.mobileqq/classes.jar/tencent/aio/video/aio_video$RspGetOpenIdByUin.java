package tencent.aio.video;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class aio_video$RspGetOpenIdByUin
  extends MessageMicro<RspGetOpenIdByUin>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public aio_video.ErrInfo err_info = new aio_video.ErrInfo();
  public final PBBytesField open_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "err_info", "open_id" }, new Object[] { null, localByteStringMicro }, RspGetOpenIdByUin.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.aio.video.aio_video.RspGetOpenIdByUin
 * JD-Core Version:    0.7.0.1
 */