package tencent.im.oidb.cmd0xe82;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xe82$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public cmd0xe82.ClientInfo client = new cmd0xe82.ClientInfo();
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field group_type = PBField.initUInt32(0);
  public final PBUInt32Field miniapp_protect = PBField.initUInt32(0);
  public final PBUInt32Field mode = PBField.initUInt32(0);
  public final PBUInt32Field redpoint = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48 }, new String[] { "client", "group_id", "group_type", "mode", "miniapp_protect", "redpoint" }, new Object[] { null, Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe82.cmd0xe82.ReqBody
 * JD-Core Version:    0.7.0.1
 */