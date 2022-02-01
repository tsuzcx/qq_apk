package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleRead$TagItem
  extends MessageMicro<TagItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field isFollow = PBField.initInt64(0L);
  public final PBInt32Field isShow = PBField.initInt32(0);
  public final PBInt64Field isTop = PBField.initInt64(0L);
  public final PBInt64Field joinNum = PBField.initInt64(0L);
  public final PBStringField name = PBField.initString("");
  public final PBInt32Field tagType = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48 }, new String[] { "name", "tagType", "joinNum", "isFollow", "isTop", "isShow" }, new Object[] { "", localInteger, localLong, localLong, localLong, localInteger }, TagItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRead.TagItem
 * JD-Core Version:    0.7.0.1
 */