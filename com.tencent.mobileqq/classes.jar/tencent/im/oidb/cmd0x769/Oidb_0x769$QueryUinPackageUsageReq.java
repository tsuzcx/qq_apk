package tencent.im.oidb.cmd0x769;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x769$QueryUinPackageUsageReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "type", "uin_file_size" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, QueryUinPackageUsageReq.class);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt64Field uin_file_size = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x769.Oidb_0x769.QueryUinPackageUsageReq
 * JD-Core Version:    0.7.0.1
 */