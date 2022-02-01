package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class aio_media$RspCollect
  extends MessageMicro<RspCollect>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_result" }, new Object[] { null }, RspCollect.class);
  public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.aio.media.aio_media.RspCollect
 * JD-Core Version:    0.7.0.1
 */