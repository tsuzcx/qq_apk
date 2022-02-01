package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$QueryPackListReq
  extends MessageMicro<QueryPackListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field count = PBField.initInt32(0);
  public final PBUInt32Field from_index = PBField.initUInt32(0);
  public final PBStringField skey = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "from_index", "count", "skey" }, new Object[] { localInteger, localInteger, "" }, QueryPackListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.QueryPackListReq
 * JD-Core Version:    0.7.0.1
 */