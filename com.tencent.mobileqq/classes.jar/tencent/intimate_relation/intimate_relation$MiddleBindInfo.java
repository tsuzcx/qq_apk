package tencent.intimate_relation;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intimate_relation$MiddleBindInfo
  extends MessageMicro<MiddleBindInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field bind_nums = PBField.initUInt32(0);
  public final PBUInt32Field bind_time = PBField.initUInt32(0);
  public final PBUInt32Field bind_type = PBField.initUInt32(0);
  public final PBUInt32Field latest_ts = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "bind_type", "bind_time", "bind_nums", "latest_ts" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, MiddleBindInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.intimate_relation.intimate_relation.MiddleBindInfo
 * JD-Core Version:    0.7.0.1
 */