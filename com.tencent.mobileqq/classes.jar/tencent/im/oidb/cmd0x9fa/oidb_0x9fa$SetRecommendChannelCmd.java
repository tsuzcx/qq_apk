package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x9fa$SetRecommendChannelCmd
  extends MessageMicro<SetRecommendChannelCmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_channel" }, new Object[] { null }, SetRecommendChannelCmd.class);
  public final PBRepeatMessageField<oidb_0x9fa.ChannelInfo> msg_channel = PBField.initRepeatMessage(oidb_0x9fa.ChannelInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9fa.oidb_0x9fa.SetRecommendChannelCmd
 * JD-Core Version:    0.7.0.1
 */