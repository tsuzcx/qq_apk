package tencent.im.oidb.cmd0xbed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbed$RspChannelArticle
  extends MessageMicro<RspChannelArticle>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_channel_id", "uint32_channel_type", "rpt_article_list", "uint32_is_no_more_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, RspChannelArticle.class);
  public final PBRepeatMessageField<oidb_cmd0xbed.ArticleSummary> rpt_article_list = PBField.initRepeatMessage(oidb_cmd0xbed.ArticleSummary.class);
  public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_no_more_data = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.RspChannelArticle
 * JD-Core Version:    0.7.0.1
 */