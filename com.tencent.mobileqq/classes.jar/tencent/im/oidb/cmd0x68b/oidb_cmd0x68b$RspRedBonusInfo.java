package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x68b$RspRedBonusInfo
  extends MessageMicro<RspRedBonusInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_turntable_url = PBField.initString("");
  public final PBUInt32Field uint32_accumlated_days = PBField.initUInt32(0);
  public final PBUInt32Field uint32_required_days = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_accumlated_days", "uint32_required_days", "str_turntable_url" }, new Object[] { localInteger, localInteger, "" }, RspRedBonusInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspRedBonusInfo
 * JD-Core Version:    0.7.0.1
 */