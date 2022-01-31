package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_common$LocalInfo
  extends MessageMicro<LocalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 41, 49 }, new String[] { "distance_description", "store_name", "store_url", "store_address", "store_longitude", "store_latitude" }, new Object[] { "", "", "", "", Double.valueOf(0.0D), Double.valueOf(0.0D) }, LocalInfo.class);
  public final PBStringField distance_description = PBField.initString("");
  public final PBStringField store_address = PBField.initString("");
  public final PBDoubleField store_latitude = PBField.initDouble(0.0D);
  public final PBDoubleField store_longitude = PBField.initDouble(0.0D);
  public final PBStringField store_name = PBField.initString("");
  public final PBStringField store_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_common.LocalInfo
 * JD-Core Version:    0.7.0.1
 */