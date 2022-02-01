package tencent.im.oidb.cmd0x48b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x48b$GetblockListReq
  extends MessageMicro<GetblockListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_last_get_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_idx = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_start_idx", "uint32_req_num", "uint32_last_get_time" }, new Object[] { localInteger, localInteger, localInteger }, GetblockListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x48b.oidb_0x48b.GetblockListReq
 * JD-Core Version:    0.7.0.1
 */