package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad$QQAdGetRsp$RedPointInfo
  extends MessageMicro<RedPointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "task_id", "tab_id", "begin_time", "end_time", "delay_second", "red_type", "red_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RedPointInfo.class);
  public final PBUInt32Field begin_time = PBField.initUInt32(0);
  public final PBUInt32Field delay_second = PBField.initUInt32(0);
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBUInt32Field red_type = PBField.initUInt32(0);
  public final PBStringField red_url = PBField.initString("");
  public final PBInt32Field tab_id = PBField.initInt32(0);
  public final PBInt32Field task_id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qq_ad.QQAdGetRsp.RedPointInfo
 * JD-Core Version:    0.7.0.1
 */