package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCircleSmartMatchMusic$ConfInfo
  extends MessageMicro<ConfInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field isCollected = PBField.initInt32(0);
  public final PBInt32Field startPos = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "startPos", "isCollected" }, new Object[] { localInteger, localInteger }, ConfInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSmartMatchMusic.ConfInfo
 * JD-Core Version:    0.7.0.1
 */