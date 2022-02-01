package tencent.im.oidb.cmd0xe5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe5c$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "type", "video_rsp_body", "topic_rsp_body", "watch_rsp_body" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
  public cmd0xe5c.TopicRspBody topic_rsp_body = new cmd0xe5c.TopicRspBody();
  public final PBUInt32Field type = PBField.initUInt32(0);
  public cmd0xe5c.VideoRspBody video_rsp_body = new cmd0xe5c.VideoRspBody();
  public cmd0xe5c.WatchRspBody watch_rsp_body = new cmd0xe5c.WatchRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5c.cmd0xe5c.RspBody
 * JD-Core Version:    0.7.0.1
 */