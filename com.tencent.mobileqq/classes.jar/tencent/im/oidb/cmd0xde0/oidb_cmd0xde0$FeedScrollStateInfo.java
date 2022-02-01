package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xde0$FeedScrollStateInfo
  extends MessageMicro<FeedScrollStateInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField enter_active_zone_speed = PBField.initFloat(0.0F);
  public final PBStringField feeds_id = PBField.initString("");
  public final PBInt64Field start_bottom = PBField.initInt64(0L);
  public final PBInt64Field start_top = PBField.initInt64(0L);
  public final PBInt64Field stop_bottom = PBField.initInt64(0L);
  public final PBInt64Field stop_top = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 53, 56, 64, 72, 80 }, new String[] { "feeds_id", "enter_active_zone_speed", "start_top", "start_bottom", "stop_top", "stop_bottom" }, new Object[] { "", Float.valueOf(0.0F), localLong, localLong, localLong, localLong }, FeedScrollStateInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.FeedScrollStateInfo
 * JD-Core Version:    0.7.0.1
 */