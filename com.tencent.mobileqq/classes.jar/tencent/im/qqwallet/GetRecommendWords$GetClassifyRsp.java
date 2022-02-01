package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetRecommendWords$GetClassifyRsp
  extends MessageMicro<GetClassifyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<GetRecommendWords.Classify> classify = PBField.initRepeatMessage(GetRecommendWords.Classify.class);
  public final PBInt32Field code = PBField.initInt32(0);
  public final PBStringField message = PBField.initString("");
  public final PBInt32Field ver = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "code", "message", "ver", "classify" }, new Object[] { localInteger, "", localInteger, null }, GetClassifyRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.GetRecommendWords.GetClassifyRsp
 * JD-Core Version:    0.7.0.1
 */