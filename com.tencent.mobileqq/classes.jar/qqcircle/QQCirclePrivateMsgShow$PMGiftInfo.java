package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCirclePrivateMsgShow$PMGiftInfo
  extends MessageMicro<PMGiftInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public QQCirclePrivateMsgShow.PMGiftDisplayInfo display = new QQCirclePrivateMsgShow.PMGiftDisplayInfo();
  public final PBUInt32Field giftCnt = PBField.initUInt32(0);
  public final PBEnumField giftType = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "giftType", "giftCnt", "display" }, new Object[] { localInteger, localInteger, null }, PMGiftInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgShow.PMGiftInfo
 * JD-Core Version:    0.7.0.1
 */