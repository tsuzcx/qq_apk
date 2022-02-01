package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class articlesummary$GroupRecommendAccount
  extends MessageMicro<GroupRecommendAccount>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_class = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<articlesummary.RecommendAccountInfo> rpt_recommend_account_info = PBField.initRepeatMessage(articlesummary.RecommendAccountInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_class", "rpt_recommend_account_info" }, new Object[] { localByteStringMicro, null }, GroupRecommendAccount.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.GroupRecommendAccount
 * JD-Core Version:    0.7.0.1
 */