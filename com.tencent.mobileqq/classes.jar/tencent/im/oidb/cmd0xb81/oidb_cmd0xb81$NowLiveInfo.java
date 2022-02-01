package tencent.im.oidb.cmd0xb81;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb81$NowLiveInfo
  extends MessageMicro<NowLiveInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "content_type", "channel_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, NowLiveInfo.class);
  public final PBUInt64Field channel_id = PBField.initUInt64(0L);
  public final PBUInt32Field content_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb81.oidb_cmd0xb81.NowLiveInfo
 * JD-Core Version:    0.7.0.1
 */