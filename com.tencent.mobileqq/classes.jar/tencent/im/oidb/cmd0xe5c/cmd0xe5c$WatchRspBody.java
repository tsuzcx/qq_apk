package tencent.im.oidb.cmd0xe5c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xe5c$WatchRspBody
  extends MessageMicro<WatchRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "type", "is_expired", "is_deleted", "from", "video", "topic" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), null, null, null }, WatchRspBody.class);
  public cmd0xe5c.UserInfo from = new cmd0xe5c.UserInfo();
  public final PBBoolField is_deleted = PBField.initBool(false);
  public final PBBoolField is_expired = PBField.initBool(false);
  public cmd0xe5c.TopicInfo topic = new cmd0xe5c.TopicInfo();
  public final PBUInt32Field type = PBField.initUInt32(0);
  public cmd0xe5c.VideoInfo video = new cmd0xe5c.VideoInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe5c.cmd0xe5c.WatchRspBody
 * JD-Core Version:    0.7.0.1
 */