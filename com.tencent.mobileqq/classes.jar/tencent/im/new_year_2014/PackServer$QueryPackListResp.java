package tencent.im.new_year_2014;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackServer$QueryPackListResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "from_index", "total_count", "count", "data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, QueryPackListResp.class);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBRepeatMessageField data = PBField.initRepeatMessage(PackData.Pack.class);
  public final PBUInt32Field from_index = PBField.initUInt32(0);
  public final PBUInt32Field total_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.new_year_2014.PackServer.QueryPackListResp
 * JD-Core Version:    0.7.0.1
 */