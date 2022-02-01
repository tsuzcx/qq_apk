package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$NewYearEvePackReq
  extends MessageMicro<NewYearEvePackReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "promotion_id", "action", "condition", "network", "business_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NewYearEvePackReq.class);
  public final PBUInt32Field action = PBField.initUInt32(0);
  public final PBUInt32Field business_id = PBField.initUInt32(0);
  public final PBUInt32Field condition = PBField.initUInt32(0);
  public final PBUInt32Field network = PBField.initUInt32(0);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.NewYearEvePackReq
 * JD-Core Version:    0.7.0.1
 */