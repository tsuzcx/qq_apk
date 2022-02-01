package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x95a$GetArActivityRedRsp
  extends MessageMicro<GetArActivityRedRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_red_switch = PBField.initUInt32(0);
  public final PBUInt64Field uint64_server_activity_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_red_switch", "uint64_server_activity_id" }, new Object[] { localLong, Integer.valueOf(0), localLong }, GetArActivityRedRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.GetArActivityRedRsp
 * JD-Core Version:    0.7.0.1
 */