package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x3fe$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public final PBRepeatMessageField<cmd0x3fe.LevelInfo> rpt_msg_level_info = PBField.initRepeatMessage(cmd0x3fe.LevelInfo.class);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 80 }, new String[] { "int32_ret", "rpt_msg_level_info", "uint32_subcmd" }, new Object[] { localInteger, null, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x3fe.cmd0x3fe.RspBody
 * JD-Core Version:    0.7.0.1
 */