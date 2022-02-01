package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleSwitch$ReqCommon_V2
  extends MessageMicro<ReqCommon_V2>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field iAppId = PBField.initInt32(0);
  public final PBInt32Field iDeviceType = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "iAppId", "iDeviceType" }, new Object[] { localInteger, localInteger }, ReqCommon_V2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSwitch.ReqCommon_V2
 * JD-Core Version:    0.7.0.1
 */