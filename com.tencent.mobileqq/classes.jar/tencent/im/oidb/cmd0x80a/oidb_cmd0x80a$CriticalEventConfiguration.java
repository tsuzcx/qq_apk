package tencent.im.oidb.cmd0x80a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0x80a$CriticalEventConfiguration
  extends MessageMicro<CriticalEventConfiguration>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "path_1", "path_2", "path_3", "filter_list" }, new Object[] { "", "", "", "" }, CriticalEventConfiguration.class);
  public final PBRepeatField<String> filter_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField path_1 = PBField.initString("");
  public final PBStringField path_2 = PBField.initString("");
  public final PBStringField path_3 = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.CriticalEventConfiguration
 * JD-Core Version:    0.7.0.1
 */