package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x885.oidb_0x885.RspBody;

public final class oidb_0x6cf$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ads_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_collection_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_inner_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rsp_ug_interface_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x885.RspBody msg_ad_rsp = new oidb_0x885.RspBody();
  public oidb_0x6cf.InterruptedWeishiAd msg_ecommerce_entrance_config = new oidb_0x6cf.InterruptedWeishiAd();
  public oidb_0x6cf.EntranceDownloadInfo msg_entrance_download_info = new oidb_0x6cf.EntranceDownloadInfo();
  public oidb_0x6cf.InterruptedWeishiAd msg_interrupted_ad_weishi = new oidb_0x6cf.InterruptedWeishiAd();
  public oidb_0x6cf.ArticleSummary req_article_summary = new oidb_0x6cf.ArticleSummary();
  public final PBRepeatMessageField<oidb_0x6cf.ArticleSummary> rpt_article_list = PBField.initRepeatMessage(oidb_0x6cf.ArticleSummary.class);
  public final PBRepeatMessageField<oidb_0x6cf.BackOffGroupInfo> rpt_back_off_group_info = PBField.initRepeatMessage(oidb_0x6cf.BackOffGroupInfo.class);
  public final PBUInt32Field uint32_auto_play_mode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  public final PBUInt64Field uint64_pos_ad_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 66, 74, 80, 90, 98, 106, 122, 130, 136 }, new String[] { "uint64_uin", "rpt_article_list", "bytes_inner_id", "req_article_summary", "uint64_pos_ad_time", "bytes_cookie", "msg_interrupted_ad_weishi", "msg_ecommerce_entrance_config", "bytes_ads_context", "uint32_is_end", "msg_ad_rsp", "msg_entrance_download_info", "rpt_back_off_group_info", "bytes_rsp_ug_interface_data", "bytes_collection_name", "uint32_auto_play_mode" }, new Object[] { Long.valueOf(0L), null, localByteStringMicro1, null, Long.valueOf(0L), localByteStringMicro2, null, null, localByteStringMicro3, localInteger, null, null, null, localByteStringMicro4, localByteStringMicro5, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody
 * JD-Core Version:    0.7.0.1
 */