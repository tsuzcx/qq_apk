package tencent.im.oidb.cmd0x74b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x74b$VideoHeadInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_url", "uint32_video_size" }, new Object[] { "", Integer.valueOf(0) }, VideoHeadInfo.class);
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field uint32_video_size = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo
 * JD-Core Version:    0.7.0.1
 */