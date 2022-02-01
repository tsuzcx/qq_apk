package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$PcSupportDef
  extends MessageMicro<PcSupportDef>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> rpt_ptls_not_support = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_ptls_support = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_mac_ptl_begin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mac_ptl_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pc_ptl_begin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pc_ptl_end = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uint32_pc_ptl_begin", "uint32_pc_ptl_end", "uint32_mac_ptl_begin", "uint32_mac_ptl_end", "rpt_ptls_support", "rpt_ptls_not_support" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, PcSupportDef.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.PcSupportDef
 * JD-Core Version:    0.7.0.1
 */