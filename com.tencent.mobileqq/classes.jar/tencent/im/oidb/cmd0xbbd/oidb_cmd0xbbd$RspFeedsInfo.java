package tencent.im.oidb.cmd0xbbd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;

public final class oidb_cmd0xbbd$RspFeedsInfo
  extends MessageMicro<RspFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_feeds_id", "uint32_feeds_type", "msg_article_summary" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspFeedsInfo.class);
  public articlesummary.ArticleSummary msg_article_summary = new articlesummary.ArticleSummary();
  public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.RspFeedsInfo
 * JD-Core Version:    0.7.0.1
 */