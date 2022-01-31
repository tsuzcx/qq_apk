package tencent.im.oidb.cmd0x69f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x69f$ChildChannelInfo
  extends MessageMicro<ChildChannelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_channel_id" }, new Object[] { Integer.valueOf(0) }, ChildChannelInfo.class);
  public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChildChannelInfo
 * JD-Core Version:    0.7.0.1
 */