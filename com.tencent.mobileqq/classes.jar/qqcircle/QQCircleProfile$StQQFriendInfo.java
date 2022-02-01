package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleProfile$StQQFriendInfo
  extends MessageMicro<StQQFriendInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField relationType = PBField.initEnum(0);
  public final PBUInt32Field uin = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "relationType" }, new Object[] { localInteger, localInteger }, StQQFriendInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StQQFriendInfo
 * JD-Core Version:    0.7.0.1
 */