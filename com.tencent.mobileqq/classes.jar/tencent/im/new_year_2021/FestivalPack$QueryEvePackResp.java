package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$QueryEvePackResp
  extends MessageMicro<QueryEvePackResp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "pack_count", "pack" }, new Object[] { Integer.valueOf(0), null }, QueryEvePackResp.class);
  public final PBRepeatMessageField<Pack2021.Pack> pack = PBField.initRepeatMessage(Pack2021.Pack.class);
  public final PBUInt32Field pack_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.QueryEvePackResp
 * JD-Core Version:    0.7.0.1
 */