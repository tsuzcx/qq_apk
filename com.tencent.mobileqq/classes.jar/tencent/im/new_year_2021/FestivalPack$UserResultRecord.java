package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FestivalPack$UserResultRecord
  extends MessageMicro<UserResultRecord>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result_list" }, new Object[] { null }, UserResultRecord.class);
  public final PBRepeatMessageField<FestivalPack.PromotionResult> result_list = PBField.initRepeatMessage(FestivalPack.PromotionResult.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.UserResultRecord
 * JD-Core Version:    0.7.0.1
 */