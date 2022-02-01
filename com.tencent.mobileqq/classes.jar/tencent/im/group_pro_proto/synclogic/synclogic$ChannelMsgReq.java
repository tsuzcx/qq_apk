package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class synclogic$ChannelMsgReq
  extends MessageMicro<ChannelMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "channel_param", "with_version_flag" }, new Object[] { null, Integer.valueOf(0) }, ChannelMsgReq.class);
  public synclogic.ChannelParam channel_param = new synclogic.ChannelParam();
  public final PBUInt32Field with_version_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgReq
 * JD-Core Version:    0.7.0.1
 */