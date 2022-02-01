package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$VideoChatConf
  extends MessageMicro<VideoChatConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 24 }, new String[] { "uint32_video_chat_num" }, new Object[] { Integer.valueOf(0) }, VideoChatConf.class);
  public final PBUInt32Field uint32_video_chat_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.VideoChatConf
 * JD-Core Version:    0.7.0.1
 */