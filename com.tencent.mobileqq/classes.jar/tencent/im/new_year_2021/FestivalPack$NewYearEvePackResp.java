package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$NewYearEvePackResp
  extends MessageMicro<NewYearEvePackResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field interval = PBField.initUInt32(0);
  public Pack2021.Pack pack = new Pack2021.Pack();
  public final PBRepeatMessageField<Pack2021.Pack> pack_list = PBField.initRepeatMessage(Pack2021.Pack.class);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBUInt32Field share_forbidden = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 64 }, new String[] { "promotion_id", "pack", "pack_list", "interval", "share_forbidden" }, new Object[] { localInteger, null, null, localInteger, localInteger }, NewYearEvePackResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.NewYearEvePackResp
 * JD-Core Version:    0.7.0.1
 */