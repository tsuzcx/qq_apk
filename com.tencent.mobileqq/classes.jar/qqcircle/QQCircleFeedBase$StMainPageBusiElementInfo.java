package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StMainPageBusiElementInfo
  extends MessageMicro<StMainPageBusiElementInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field elementKey = PBField.initUInt32(0);
  public final PBUInt32Field elementType = PBField.initUInt32(0);
  public final PBUInt32Field visibility = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "elementKey", "elementType", "content", "visibility" }, new Object[] { localInteger, localInteger, "", localInteger }, StMainPageBusiElementInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StMainPageBusiElementInfo
 * JD-Core Version:    0.7.0.1
 */