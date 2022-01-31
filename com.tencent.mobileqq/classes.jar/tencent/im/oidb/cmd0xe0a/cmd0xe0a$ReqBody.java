package tencent.im.oidb.cmd0xe0a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe0a$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "client", "group_id", "group_type", "mode" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public cmd0xe0a.ClientInfo client = new cmd0xe0a.ClientInfo();
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field group_type = PBField.initUInt32(0);
  public final PBUInt32Field mode = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe0a.cmd0xe0a.ReqBody
 * JD-Core Version:    0.7.0.1
 */