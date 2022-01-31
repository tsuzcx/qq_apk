package tencent.im.oidb.cmd0xe2e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xe2e$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "app" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xe2e.App> app = PBField.initRepeatMessage(oidb_0xe2e.App.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2e.oidb_0xe2e.RspBody
 * JD-Core Version:    0.7.0.1
 */