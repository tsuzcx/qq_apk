package tencent.im.oidb.cmd0xf51;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xf51$CommGrayTipsInfo
  extends MessageMicro<CommGrayTipsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_busi_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tips_seq_id = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_busi_id", "uint64_tips_seq_id" }, new Object[] { localLong, localLong }, CommGrayTipsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf51.oidb_cmd0xf51.CommGrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */