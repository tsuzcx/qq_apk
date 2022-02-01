package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0xb74.cmd0xb74.FusionBiuInfo;

public final class oidb_cmd0xb54$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_proteus_json_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_search_word_sid = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xb54.ArticleBusiness msg_article_business = new oidb_cmd0xb54.ArticleBusiness();
  public oidb_cmd0xb54.CoinInfo msg_coin_info = new oidb_cmd0xb54.CoinInfo();
  public cmd0xb74.FusionBiuInfo msg_fusion_biu_info = new cmd0xb74.FusionBiuInfo();
  public oidb_cmd0xb54.RspBiuCount msg_rsp_biu_count = new oidb_cmd0xb54.RspBiuCount();
  public oidb_cmd0xb54.RspTopic msg_rsp_topic = new oidb_cmd0xb54.RspTopic();
  public oidb_cmd0xb54.ShareNumItem msg_share_num = new oidb_cmd0xb54.ShareNumItem();
  public final PBRepeatMessageField<oidb_cmd0xb54.StyleCard> rpt_msg_style_card = PBField.initRepeatMessage(oidb_cmd0xb54.StyleCard.class);
  public final PBRepeatMessageField<oidb_cmd0xb54.RelatedSearchWord> rpt_related_search_word = PBField.initRepeatMessage(oidb_cmd0xb54.RelatedSearchWord.class);
  public final PBUInt32Field uint32_is_like = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "msg_rsp_topic", "msg_rsp_biu_count", "uint32_like_count", "uint32_is_like", "rpt_msg_style_card", "rpt_related_search_word", "bytes_search_word_sid", "msg_article_business", "msg_fusion_biu_info", "bytes_proteus_json_data", "msg_coin_info", "msg_share_num" }, new Object[] { null, null, localInteger, localInteger, null, null, localByteStringMicro1, null, null, localByteStringMicro2, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBody
 * JD-Core Version:    0.7.0.1
 */