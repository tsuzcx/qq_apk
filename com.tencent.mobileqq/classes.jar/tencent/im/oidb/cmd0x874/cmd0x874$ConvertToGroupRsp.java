package tencent.im.oidb.cmd0x874;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x874$ConvertToGroupRsp
  extends MessageMicro<ConvertToGroupRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_conf_uin", "uint64_group_code" }, new Object[] { localLong, localLong }, ConvertToGroupRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x874.cmd0x874.ConvertToGroupRsp
 * JD-Core Version:    0.7.0.1
 */