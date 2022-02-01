package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Pack2021$QuestionInfo
  extends MessageMicro<QuestionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBUInt32Field question_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "promotion_id", "question_id" }, new Object[] { localInteger, localInteger }, QuestionInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.new_year_2021.Pack2021.QuestionInfo
 * JD-Core Version:    0.7.0.1
 */