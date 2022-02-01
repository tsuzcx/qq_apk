package tencent.im.oidb.cmd0x66b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x66b$RspLikeInfo
  extends MessageMicro<RspLikeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_new = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 481608, 481616 }, new String[] { "uint32_total", "uint32_new" }, new Object[] { localInteger, localInteger }, RspLikeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspLikeInfo
 * JD-Core Version:    0.7.0.1
 */