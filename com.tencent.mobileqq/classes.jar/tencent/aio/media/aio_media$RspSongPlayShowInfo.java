package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$RspSongPlayShowInfo
  extends MessageMicro<RspSongPlayShowInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "msg_result", "uint32_join_num", "rpt_uint64_join_uins" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, RspSongPlayShowInfo.class);
  public aio_media.ResultInfo msg_result = new aio_media.ResultInfo();
  public final PBRepeatField<Long> rpt_uint64_join_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_join_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.aio.media.aio_media.RspSongPlayShowInfo
 * JD-Core Version:    0.7.0.1
 */