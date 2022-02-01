package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;

public final class oidb_cmd0x68b$RspChannelArticle
  extends MessageMicro<RspChannelArticle>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nearby_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pre_load_req_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_query_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rsp_ug_interface_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_set_top_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x68b.AdPosMap msg_ad_pos_map = new oidb_cmd0x68b.AdPosMap();
  public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_advertise_list = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
  public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_article_list = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
  public final PBRepeatMessageField<oidb_cmd0x68b.BackOffGroupInfo> rpt_back_off_group_info = PBField.initRepeatMessage(oidb_cmd0x68b.BackOffGroupInfo.class);
  public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_deleted_article_list = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
  public final PBUInt32Field uint32_is_no_more_data = PBField.initUInt32(0);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_cur_feeds_refresh_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_pos_ad_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 112, 122, 130, 138, 146, 152, 162, 170, 178 }, new String[] { "uint64_channel_id", "uint32_is_no_more_data", "rpt_article_list", "rpt_deleted_article_list", "bytes_set_top_cookie", "uint64_pos_ad_time", "rpt_advertise_list", "msg_ad_pos_map", "bytes_nearby_cookie", "bytes_pre_load_req_info", "uint64_cur_feeds_refresh_seq", "rpt_back_off_group_info", "bytes_rsp_ug_interface_data", "bytes_req_query_id" }, new Object[] { localLong, Integer.valueOf(0), null, null, localByteStringMicro1, localLong, null, null, localByteStringMicro2, localByteStringMicro3, localLong, null, localByteStringMicro4, localByteStringMicro5 }, RspChannelArticle.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle
 * JD-Core Version:    0.7.0.1
 */