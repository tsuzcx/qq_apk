package tencent.im.oidb.cmd0xe2e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe2e$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "client", "group_id", "group_type", "mode" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public oidb_0xe2e.ClientInfo client = new oidb_0xe2e.ClientInfo();
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field group_type = PBField.initUInt32(0);
  public final PBUInt32Field mode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe2e.oidb_0xe2e.ReqBody
 * JD-Core Version:    0.7.0.1
 */