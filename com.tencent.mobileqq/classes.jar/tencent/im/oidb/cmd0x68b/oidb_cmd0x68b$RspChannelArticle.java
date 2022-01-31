package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$RspChannelArticle
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_set_top_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x68b.AdPosMap msg_ad_pos_map = new oidb_cmd0x68b.AdPosMap();
  public final PBRepeatMessageField rpt_advertise_list = PBField.initRepeatMessage(oidb_cmd0x68b.ArticleSummary.class);
  public final PBRepeatMessageField rpt_article_list = PBField.initRepeatMessage(oidb_cmd0x68b.ArticleSummary.class);
  public final PBRepeatMessageField rpt_deleted_article_list = PBField.initRepeatMessage(oidb_cmd0x68b.ArticleSummary.class);
  public final PBUInt32Field uint32_is_no_more_data = PBField.initUInt32(0);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pos_ad_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 112, 122, 130 }, new String[] { "uint64_channel_id", "uint32_is_no_more_data", "rpt_article_list", "rpt_deleted_article_list", "bytes_set_top_cookie", "uint64_pos_ad_time", "rpt_advertise_list", "msg_ad_pos_map" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, localByteStringMicro, Long.valueOf(0L), null, null }, RspChannelArticle.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle
 * JD-Core Version:    0.7.0.1
 */