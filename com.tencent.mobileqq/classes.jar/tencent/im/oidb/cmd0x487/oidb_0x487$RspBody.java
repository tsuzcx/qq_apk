package tencent.im.oidb.cmd0x487;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x487$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField msg_groups = PBField.initRepeatMessage(oidb_0x487.GroupList.class);
  public final PBUInt32Field uint32_follow_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_groups_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_privilege_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_remind_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56 }, new String[] { "uint32_result", "bytes_errmsg", "msg_groups", "uint32_privilege_flag", "uint32_groups_flag", "uint32_follow_state", "uint32_remind_flag" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x487.oidb_0x487.RspBody
 * JD-Core Version:    0.7.0.1
 */