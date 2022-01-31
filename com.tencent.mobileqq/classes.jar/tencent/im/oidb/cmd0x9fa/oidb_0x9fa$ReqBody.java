package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9fa$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "uint32_appid", "uint32_cmdid", "int32_channel", "msg_add_hate_group", "msg_channel_status", "msg_channel_set", "msg_get_hate_group", "msg_get_web_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null }, ReqBody.class);
  public final PBInt32Field int32_channel = PBField.initInt32(0);
  public oidb_0x9fa.AddFeedbackHateGroupCmd msg_add_hate_group = new oidb_0x9fa.AddFeedbackHateGroupCmd();
  public oidb_0x9fa.SetRecommendChannelCmd msg_channel_set = new oidb_0x9fa.SetRecommendChannelCmd();
  public oidb_0x9fa.QueryRecommendChannelCmd msg_channel_status = new oidb_0x9fa.QueryRecommendChannelCmd();
  public oidb_0x9fa.GetFeedbackHateGroupCmd msg_get_hate_group = new oidb_0x9fa.GetFeedbackHateGroupCmd();
  public oidb_0x9fa.GetSimilarGroupWebInfo msg_get_web_info = new oidb_0x9fa.GetSimilarGroupWebInfo();
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmdid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9fa.oidb_0x9fa.ReqBody
 * JD-Core Version:    0.7.0.1
 */