package tencent.im.oidb.cmd0x472;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x472$RspChannelArticle
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "uint64_channel_id", "rpt_article_list" }, new Object[] { Long.valueOf(0L), null }, RspChannelArticle.class);
  public final PBRepeatMessageField rpt_article_list = PBField.initRepeatMessage(Oidb_0x472.ArticleSummary.class);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x472.Oidb_0x472.RspChannelArticle
 * JD-Core Version:    0.7.0.1
 */