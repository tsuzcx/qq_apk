package tencent.im.group.group_label;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class GroupLabel$UinInfo
  extends MessageMicro<UinInfo>
{
  public static final int INT64_LATITUDE_FIELD_NUMBER = 2;
  public static final int INT64_LONGITUDE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field int64_latitude = PBField.initInt64(0L);
  public final PBInt64Field int64_longitude = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "int64_longitude", "int64_latitude" }, new Object[] { localLong, localLong }, UinInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.group.group_label.GroupLabel.UinInfo
 * JD-Core Version:    0.7.0.1
 */