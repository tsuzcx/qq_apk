package tencent.im.oidb.cmd0x8f6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x8f6$DecreaseUnreadMailCountReq
  extends MessageMicro<DecreaseUnreadMailCountReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_type", "uint32_amount", "rpt_msg_indexes", "msg_recalled_index", "uint32_data_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0) }, DecreaseUnreadMailCountReq.class);
  public oidb_cmd0x8f6.LiteMailIndex msg_recalled_index = new oidb_cmd0x8f6.LiteMailIndex();
  public final PBRepeatMessageField<oidb_cmd0x8f6.LiteMailIndex> rpt_msg_indexes = PBField.initRepeatMessage(oidb_cmd0x8f6.LiteMailIndex.class);
  public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
  public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.DecreaseUnreadMailCountReq
 * JD-Core Version:    0.7.0.1
 */