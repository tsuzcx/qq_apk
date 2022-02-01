package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleCounter$RedPointTransInfo
  extends MessageMicro<RedPointTransInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "allPushTrans", "pymkRedTrans" }, new Object[] { null, null }, RedPointTransInfo.class);
  public QQCircleCounter.AllPushTransInfo allPushTrans = new QQCircleCounter.AllPushTransInfo();
  public QQCircleCounter.PymkRedTransfer pymkRedTrans = new QQCircleCounter.PymkRedTransfer();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleCounter.RedPointTransInfo
 * JD-Core Version:    0.7.0.1
 */