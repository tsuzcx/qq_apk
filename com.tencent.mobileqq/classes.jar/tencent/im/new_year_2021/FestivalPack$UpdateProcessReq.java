package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$UpdateProcessReq
  extends MessageMicro<UpdateProcessReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBRepeatField<Integer> question_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "promotion_id", "question_list" }, new Object[] { localInteger, localInteger }, UpdateProcessReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.UpdateProcessReq
 * JD-Core Version:    0.7.0.1
 */