package tencent.im.oidb.cmd0x48b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x48b$GetblockListRsp
  extends MessageMicro<GetblockListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_0x48b.GetTotalblockInfo> rpt_msg_get_total_block_info = PBField.initRepeatMessage(oidb_0x48b.GetTotalblockInfo.class);
  public final PBUInt32Field uint32_get_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_start_idx = PBField.initUInt32(0);
  public final PBUInt32Field uint32_over = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_over", "uint32_next_start_idx", "uint32_get_time", "rpt_msg_get_total_block_info" }, new Object[] { localInteger, localInteger, localInteger, null }, GetblockListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x48b.oidb_0x48b.GetblockListRsp
 * JD-Core Version:    0.7.0.1
 */