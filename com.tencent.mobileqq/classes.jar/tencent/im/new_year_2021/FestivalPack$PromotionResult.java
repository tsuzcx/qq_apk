package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FestivalPack$PromotionResult
  extends MessageMicro<PromotionResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField open_luck_desc = PBField.initString("");
  public final PBStringField open_luck_pic = PBField.initString("");
  public final PBStringField open_luck_title = PBField.initString("");
  public final PBInt32Field open_luck_word_id = PBField.initInt32(0);
  public final PBInt32Field promotion_id = PBField.initInt32(0);
  public final PBInt32Field star_id = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "promotion_id", "open_luck_word_id", "star_id", "open_luck_title", "open_luck_desc", "open_luck_pic" }, new Object[] { localInteger, localInteger, localInteger, "", "", "" }, PromotionResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.PromotionResult
 * JD-Core Version:    0.7.0.1
 */