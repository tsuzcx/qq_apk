package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype13
  extends MessageMicro<MsgElemInfo_servtype13>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_head_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sys_head_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_sys_head_id", "uint32_head_flag" }, new Object[] { localInteger, localInteger }, MsgElemInfo_servtype13.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13
 * JD-Core Version:    0.7.0.1
 */