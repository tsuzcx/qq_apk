package tencent.aio.video;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_video$RspGetUinByOpenId
  extends MessageMicro<RspGetUinByOpenId>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "err_info", "uin" }, new Object[] { null, Long.valueOf(0L) }, RspGetUinByOpenId.class);
  public aio_video.ErrInfo err_info = new aio_video.ErrInfo();
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.aio.video.aio_video.RspGetUinByOpenId
 * JD-Core Version:    0.7.0.1
 */