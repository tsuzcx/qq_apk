package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleMsgPaelem$Crm_Trans
  extends MessageMicro<Crm_Trans>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_msg_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_flag", "str_msg_summary" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, Crm_Trans.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleMsgPaelem.Crm_Trans
 * JD-Core Version:    0.7.0.1
 */