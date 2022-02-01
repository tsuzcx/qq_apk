package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCirclePrivateMsgShow$PMGiftInfo
  extends MessageMicro<PMGiftInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "giftType", "giftCnt", "display" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, PMGiftInfo.class);
  public QQCirclePrivateMsgShow.PMGiftDisplayInfo display = new QQCirclePrivateMsgShow.PMGiftDisplayInfo();
  public final PBUInt32Field giftCnt = PBField.initUInt32(0);
  public final PBEnumField giftType = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCirclePrivateMsgShow.PMGiftInfo
 * JD-Core Version:    0.7.0.1
 */