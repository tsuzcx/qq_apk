package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xf4d$DanmuBaseInfo
  extends MessageMicro<DanmuBaseInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField danmu_content = PBField.initString("");
  public final PBStringField danmu_id = PBField.initString("");
  public final PBUInt32Field danmu_source = PBField.initUInt32(0);
  public final PBUInt32Field danmu_type = PBField.initUInt32(0);
  public final PBInt64Field post_delta_time = PBField.initInt64(0L);
  public final PBStringField rowkey = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50 }, new String[] { "danmu_id", "danmu_type", "danmu_source", "danmu_content", "post_delta_time", "rowkey" }, new Object[] { "", localInteger, localInteger, "", Long.valueOf(0L), "" }, DanmuBaseInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf4d.oidb_0xf4d.DanmuBaseInfo
 * JD-Core Version:    0.7.0.1
 */