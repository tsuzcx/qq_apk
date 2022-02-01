package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f9$FeedsState
  extends MessageMicro<FeedsState>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_concern_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ignored_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_readed_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_concern_flag", "uint32_readed_flag", "uint32_ignored_flag" }, new Object[] { localInteger, localInteger, localInteger }, FeedsState.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.FeedsState
 * JD-Core Version:    0.7.0.1
 */