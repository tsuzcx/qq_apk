package tencent.im.oidb.cmd0xe5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe5c$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "type", "videoReqBody", "topicReqBody", "watch_word_req_body" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
  public cmd0xe5c.TopicReqBody topicReqBody = new cmd0xe5c.TopicReqBody();
  public final PBUInt32Field type = PBField.initUInt32(0);
  public cmd0xe5c.VideoReqBody videoReqBody = new cmd0xe5c.VideoReqBody();
  public cmd0xe5c.WatchWordReqBody watch_word_req_body = new cmd0xe5c.WatchWordReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5c.cmd0xe5c.ReqBody
 * JD-Core Version:    0.7.0.1
 */