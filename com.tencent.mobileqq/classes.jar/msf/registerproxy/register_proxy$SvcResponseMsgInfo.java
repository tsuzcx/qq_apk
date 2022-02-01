package msf.registerproxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class register_proxy$SvcResponseMsgInfo
  extends MessageMicro<SvcResponseMsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_num", "discuss_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SvcResponseMsgInfo.class);
  public final PBUInt32Field discuss_num = PBField.initUInt32(0);
  public final PBUInt32Field group_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     msf.registerproxy.register_proxy.SvcResponseMsgInfo
 * JD-Core Version:    0.7.0.1
 */