package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f9$GetLiteMailListByUinReq
  extends MessageMicro<GetLiteMailListByUinReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0x8f9.LiteMailFilter msg_filter = new oidb_0x8f9.LiteMailFilter();
  public final PBRepeatMessageField<oidb_0x8f9.LiteMailBrief> rpt_msg_litemail_list = PBField.initRepeatMessage(oidb_0x8f9.LiteMailBrief.class);
  public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_end_time", "rpt_msg_litemail_list", "uint32_amount", "msg_filter" }, new Object[] { localInteger, null, localInteger, null }, GetLiteMailListByUinReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GetLiteMailListByUinReq
 * JD-Core Version:    0.7.0.1
 */