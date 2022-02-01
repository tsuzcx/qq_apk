package tencent.im.oidb.cmd0xde0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xde0$GestureFeature
  extends MessageMicro<GestureFeature>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gesture_event" }, new Object[] { null }, GestureFeature.class);
  public final PBRepeatMessageField<oidb_cmd0xde0.GestureEvent> gesture_event = PBField.initRepeatMessage(oidb_cmd0xde0.GestureEvent.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xde0.oidb_cmd0xde0.GestureFeature
 * JD-Core Version:    0.7.0.1
 */