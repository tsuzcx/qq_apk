package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.trunk.Qworkflow.Qworkflow.AppID;

public final class oidb_0x592$RecallScheduleReq
  extends MessageMicro<RecallScheduleReq>
{
  public static final int CLOSE = 0;
  public static final int OPEN = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_silent_switch = PBField.initEnum(0);
  public Qworkflow.AppID msg_notify_source_id = new Qworkflow.AppID();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_workflow_id", "enum_silent_switch", "msg_notify_source_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, RecallScheduleReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.RecallScheduleReq
 * JD-Core Version:    0.7.0.1
 */