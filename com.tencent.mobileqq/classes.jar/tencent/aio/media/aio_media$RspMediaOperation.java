package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class aio_media$RspMediaOperation
  extends MessageMicro<RspMediaOperation>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_result" }, new Object[] { null }, RspMediaOperation.class);
  public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.aio.media.aio_media.RspMediaOperation
 * JD-Core Version:    0.7.0.1
 */