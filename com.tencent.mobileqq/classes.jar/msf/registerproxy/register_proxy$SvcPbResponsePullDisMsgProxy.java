package msf.registerproxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class register_proxy$SvcPbResponsePullDisMsgProxy
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field member_seq = PBField.initUInt64(0L);
  public final PBBytesField msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "member_seq", "msg_content" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, SvcPbResponsePullDisMsgProxy.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     msf.registerproxy.register_proxy.SvcPbResponsePullDisMsgProxy
 * JD-Core Version:    0.7.0.1
 */