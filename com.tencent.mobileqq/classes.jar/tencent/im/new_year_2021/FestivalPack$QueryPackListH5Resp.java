package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FestivalPack$QueryPackListH5Resp
  extends MessageMicro<QueryPackListH5Resp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "pack_list" }, new Object[] { null }, QueryPackListH5Resp.class);
  public final PBRepeatMessageField<Pack2021.Pack> pack_list = PBField.initRepeatMessage(Pack2021.Pack.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.QueryPackListH5Resp
 * JD-Core Version:    0.7.0.1
 */