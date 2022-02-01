package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetRecommendWords$Classify
  extends MessageMicro<Classify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "name", "items" }, new Object[] { "", null }, Classify.class);
  public final PBRepeatMessageField<GetRecommendWords.ClassifyItem> items = PBField.initRepeatMessage(GetRecommendWords.ClassifyItem.class);
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.qqwallet.GetRecommendWords.Classify
 * JD-Core Version:    0.7.0.1
 */