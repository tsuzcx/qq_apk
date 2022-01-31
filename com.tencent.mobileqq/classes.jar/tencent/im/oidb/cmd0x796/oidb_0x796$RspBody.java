package tencent.im.oidb.cmd0x796;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x796$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField errMsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0x796.ItemInfo> rpt_items = PBField.initRepeatMessage(oidb_0x796.ItemInfo.class);
  public oidb_0x796.ItemInfo stPagePointItem = new oidb_0x796.ItemInfo();
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_update = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rsp_seq = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56 }, new String[] { "uint32_result", "errMsg", "rpt_items", "stPagePointItem", "uint32_flag", "uint32_rsp_seq", "uint32_need_update" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x796.oidb_0x796.RspBody
 * JD-Core Version:    0.7.0.1
 */