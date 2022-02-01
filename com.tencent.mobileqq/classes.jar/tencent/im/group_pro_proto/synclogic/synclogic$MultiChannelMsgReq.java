package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class synclogic$MultiChannelMsgReq
  extends MessageMicro<MultiChannelMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_channel_params", "seq" }, new Object[] { null, Integer.valueOf(0) }, MultiChannelMsgReq.class);
  public final PBRepeatMessageField<synclogic.ChannelParam> rpt_channel_params = PBField.initRepeatMessage(synclogic.ChannelParam.class);
  public final PBUInt32Field seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.synclogic.synclogic.MultiChannelMsgReq
 * JD-Core Version:    0.7.0.1
 */