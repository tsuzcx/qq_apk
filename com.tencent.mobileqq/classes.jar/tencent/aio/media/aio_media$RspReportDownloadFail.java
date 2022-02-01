package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class aio_media$RspReportDownloadFail
  extends MessageMicro<RspReportDownloadFail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_result" }, new Object[] { null }, RspReportDownloadFail.class);
  public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.aio.media.aio_media.RspReportDownloadFail
 * JD-Core Version:    0.7.0.1
 */