package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$QueryEvePackReq
  extends MessageMicro<QueryEvePackReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field pack_count = PBField.initUInt32(0);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "promotion_id", "pack_count" }, new Object[] { localInteger, localInteger }, QueryEvePackReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.QueryEvePackReq
 * JD-Core Version:    0.7.0.1
 */