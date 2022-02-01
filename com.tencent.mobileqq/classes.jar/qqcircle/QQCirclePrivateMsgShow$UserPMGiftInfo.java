package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCirclePrivateMsgShow$UserPMGiftInfo
  extends MessageMicro<UserPMGiftInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field certification = PBField.initUInt32(0);
  public final PBRepeatMessageField<QQCirclePrivateMsgShow.PMGiftInfo> giftInfos = PBField.initRepeatMessage(QQCirclePrivateMsgShow.PMGiftInfo.class);
  public final PBUInt32Field relation = PBField.initUInt32(0);
  public final PBStringField uid = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "uid", "relation", "certification", "giftInfos" }, new Object[] { "", localInteger, localInteger, null }, UserPMGiftInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo
 * JD-Core Version:    0.7.0.1
 */