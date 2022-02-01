package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$QueryQualificationResp
  extends MessageMicro<QueryQualificationResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field lottery_additional_cnt = PBField.initUInt32(0);
  public final PBUInt32Field lottery_additional_total = PBField.initUInt32(0);
  public final PBUInt32Field lottery_cnt = PBField.initUInt32(0);
  public final PBUInt32Field lottery_share_cnt = PBField.initUInt32(0);
  public final PBUInt32Field lottery_share_total = PBField.initUInt32(0);
  public final PBUInt32Field lottery_total = PBField.initUInt32(0);
  public final PBUInt32Field participants = PBField.initUInt32(0);
  public final PBUInt32Field process = PBField.initUInt32(0);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "process", "lottery_cnt", "lottery_total", "participants", "promotion_id", "lottery_additional_cnt", "lottery_additional_total", "lottery_share_cnt", "lottery_share_total" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, QueryQualificationResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.QueryQualificationResp
 * JD-Core Version:    0.7.0.1
 */