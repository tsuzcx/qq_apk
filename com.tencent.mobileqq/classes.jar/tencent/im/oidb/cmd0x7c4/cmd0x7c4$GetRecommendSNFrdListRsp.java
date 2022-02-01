package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7c4$GetRecommendSNFrdListRsp
  extends MessageMicro<GetRecommendSNFrdListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<cmd0x7c4.OneFrdData> rpt_msg_one_frd_data = PBField.initRepeatMessage(cmd0x7c4.OneFrdData.class);
  public final PBUInt32Field uint32_next_start_idx = PBField.initUInt32(0);
  public final PBUInt32Field uint32_over = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_uin", "uint32_sequence", "uint32_over", "uint32_next_start_idx", "rpt_msg_one_frd_data" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, null }, GetRecommendSNFrdListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetRecommendSNFrdListRsp
 * JD-Core Version:    0.7.0.1
 */