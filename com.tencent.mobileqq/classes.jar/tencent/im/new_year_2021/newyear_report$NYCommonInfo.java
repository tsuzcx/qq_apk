package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class newyear_report$NYCommonInfo
  extends MessageMicro<NYCommonInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uin", "adcode", "plat", "report_array" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "" }, NYCommonInfo.class);
  public final PBStringField adcode = PBField.initString("");
  public final PBUInt32Field plat = PBField.initUInt32(0);
  public final PBStringField report_array = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.new_year_2021.newyear_report.NYCommonInfo
 * JD-Core Version:    0.7.0.1
 */