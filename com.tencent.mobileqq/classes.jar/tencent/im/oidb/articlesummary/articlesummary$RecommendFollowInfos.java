package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$RecommendFollowInfos
  extends MessageMicro<RecommendFollowInfos>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_account_next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_card_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<articlesummary.GroupRecommendAccount> rpt_group_recommend_account = PBField.initRepeatMessage(articlesummary.GroupRecommendAccount.class);
  public final PBRepeatMessageField<articlesummary.RecommendAccountInfo> rpt_recommend_account_info = PBField.initRepeatMessage(articlesummary.RecommendAccountInfo.class);
  public final PBUInt32Field uint32_card_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_full_card = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58 }, new String[] { "uint32_show_full_card", "rpt_recommend_account_info", "bytes_account_next_cookie", "uint32_card_style", "bytes_card_title", "bytes_jump_url", "rpt_group_recommend_account" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, null }, RecommendFollowInfos.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.RecommendFollowInfos
 * JD-Core Version:    0.7.0.1
 */