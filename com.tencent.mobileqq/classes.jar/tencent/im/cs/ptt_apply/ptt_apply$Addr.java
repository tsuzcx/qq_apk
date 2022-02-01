package tencent.im.cs.ptt_apply;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ptt_apply$Addr
  extends MessageMicro<Addr>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_inner_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ip_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_out_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_out_port = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_out_ip", "uint32_out_port", "uint32_inner_ip", "uint32_inner_port", "uint32_ip_type" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger }, Addr.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.ptt_apply.ptt_apply.Addr
 * JD-Core Version:    0.7.0.1
 */