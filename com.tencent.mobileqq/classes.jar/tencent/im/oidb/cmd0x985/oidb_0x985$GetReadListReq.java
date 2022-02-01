package tencent.im.oidb.cmd0x985;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x985$GetReadListReq
  extends MessageMicro<GetReadListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_conf_uin", "uint32_msg_seq", "uint64_from_uin" }, new Object[] { localLong, Integer.valueOf(0), localLong }, GetReadListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x985.oidb_0x985.GetReadListReq
 * JD-Core Version:    0.7.0.1
 */