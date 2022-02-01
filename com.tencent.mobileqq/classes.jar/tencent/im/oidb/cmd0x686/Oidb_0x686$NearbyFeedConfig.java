package tencent.im.oidb.cmd0x686;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x686$NearbyFeedConfig
  extends MessageMicro<NearbyFeedConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint32_publish_feed_min_level", "str_publish_feed_tips", "str_unable_publish_feed_tips", "uint32_publish_comment_min_level", "str_unable_publish_comment_tips" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "" }, NearbyFeedConfig.class);
  public final PBStringField str_publish_feed_tips = PBField.initString("");
  public final PBStringField str_unable_publish_comment_tips = PBField.initString("");
  public final PBStringField str_unable_publish_feed_tips = PBField.initString("");
  public final PBUInt32Field uint32_publish_comment_min_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_publish_feed_min_level = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyFeedConfig
 * JD-Core Version:    0.7.0.1
 */