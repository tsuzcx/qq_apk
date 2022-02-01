package nearby_interact_state;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class interact_value$InteractValue
  extends MessageMicro<InteractValue>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_one_interact" }, new Object[] { null }, InteractValue.class);
  public final PBRepeatMessageField<interact_value.OneInteract> rpt_one_interact = PBField.initRepeatMessage(interact_value.OneInteract.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     nearby_interact_state.interact_value.InteractValue
 * JD-Core Version:    0.7.0.1
 */