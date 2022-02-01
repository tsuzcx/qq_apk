package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$QueryPackListResp
  extends MessageMicro<QueryPackListResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBUInt32Field from_index = PBField.initUInt32(0);
  public final PBRepeatMessageField<Pack2021.Pack> pack_list = PBField.initRepeatMessage(Pack2021.Pack.class);
  public final PBUInt32Field total_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "from_index", "total_count", "count", "pack_list" }, new Object[] { localInteger, localInteger, localInteger, null }, QueryPackListResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.QueryPackListResp
 * JD-Core Version:    0.7.0.1
 */