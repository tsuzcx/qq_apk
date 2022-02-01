package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StHomeButtonBubbleData
  extends MessageMicro<StHomeButtonBubbleData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "triggerFeedIndex" }, new Object[] { Integer.valueOf(0) }, StHomeButtonBubbleData.class);
  public final PBUInt32Field triggerFeedIndex = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StHomeButtonBubbleData
 * JD-Core Version:    0.7.0.1
 */