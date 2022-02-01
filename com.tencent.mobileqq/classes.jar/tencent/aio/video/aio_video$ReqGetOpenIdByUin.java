package tencent.aio.video;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_video$ReqGetOpenIdByUin
  extends MessageMicro<ReqGetOpenIdByUin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "app_id", "target_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, ReqGetOpenIdByUin.class);
  public final PBUInt32Field app_id = PBField.initUInt32(0);
  public final PBUInt64Field target_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.aio.video.aio_video.ReqGetOpenIdByUin
 * JD-Core Version:    0.7.0.1
 */