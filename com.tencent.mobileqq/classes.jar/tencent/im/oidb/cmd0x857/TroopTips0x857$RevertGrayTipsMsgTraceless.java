package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$RevertGrayTipsMsgTraceless
  extends MessageMicro<RevertGrayTipsMsgTraceless>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_from = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tips_seq_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_from", "uint64_to", "group_code", "uint64_busi_id", "uint64_tips_seq_id" }, new Object[] { localLong, localLong, localLong, localLong, localLong }, RevertGrayTipsMsgTraceless.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.RevertGrayTipsMsgTraceless
 * JD-Core Version:    0.7.0.1
 */