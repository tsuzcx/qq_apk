package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0x68b$RspGetFollowTabFeeds
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_feeds_type", "msg_article_summary" }, new Object[] { Integer.valueOf(0), null }, RspGetFollowTabFeeds.class);
  public oidb_cmd0x68b.ArticleSummary msg_article_summary = new oidb_cmd0x68b.ArticleSummary();
  public final PBEnumField uint32_feeds_type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabFeeds
 * JD-Core Version:    0.7.0.1
 */