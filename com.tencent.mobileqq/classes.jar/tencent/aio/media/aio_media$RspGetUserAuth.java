package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class aio_media$RspGetUserAuth
  extends MessageMicro<RspGetUserAuth>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "msg_result", "bool_allow_member_start" }, new Object[] { null, Boolean.valueOf(true) }, RspGetUserAuth.class);
  public final PBBoolField bool_allow_member_start = PBField.initBool(true);
  public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.aio.media.aio_media.RspGetUserAuth
 * JD-Core Version:    0.7.0.1
 */