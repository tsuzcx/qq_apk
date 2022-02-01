package tencent.im.oidb.cmd0xf9b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xf9b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "locations" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_cmd0xf9b.Location> locations = PBField.initRepeatMessage(oidb_cmd0xf9b.Location.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf9b.oidb_cmd0xf9b.RspBody
 * JD-Core Version:    0.7.0.1
 */