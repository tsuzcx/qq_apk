package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype13
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_sys_head_id", "uint32_head_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, MsgElemInfo_servtype13.class);
  public final PBUInt32Field uint32_head_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sys_head_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13
 * JD-Core Version:    0.7.0.1
 */