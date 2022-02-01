package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCounter$AllPushTransInfo
  extends MessageMicro<AllPushTransInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField author = PBField.initString("");
  public final PBInt64Field createTs = PBField.initInt64(0L);
  public final PBStringField feedId = PBField.initString("");
  public final PBInt32Field msgType = PBField.initInt32(0);
  public final PBInt32Field pageType = PBField.initInt32(0);
  public final PBEnumField redType = PBField.initEnum(1);
  public final PBStringField taskTransfer = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56 }, new String[] { "feedId", "author", "createTs", "msgType", "taskTransfer", "pageType", "redType" }, new Object[] { "", "", Long.valueOf(0L), localInteger, "", localInteger, Integer.valueOf(1) }, AllPushTransInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleCounter.AllPushTransInfo
 * JD-Core Version:    0.7.0.1
 */