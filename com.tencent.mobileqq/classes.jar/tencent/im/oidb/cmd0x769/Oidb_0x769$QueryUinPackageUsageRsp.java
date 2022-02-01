package tencent.im.oidb.cmd0x769;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x769$QueryUinPackageUsageRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field left_uin_num = PBField.initUInt64(0L);
  public final PBUInt64Field max_uin_num = PBField.initUInt64(0L);
  public final PBUInt32Field proportion = PBField.initUInt32(0);
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBRepeatMessageField uin_package_used_list = PBField.initRepeatMessage(Oidb_0x769.UinPackageUsedInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 82 }, new String[] { "status", "left_uin_num", "max_uin_num", "proportion", "uin_package_used_list" }, new Object[] { localInteger, localLong, localLong, localInteger, null }, QueryUinPackageUsageRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x769.Oidb_0x769.QueryUinPackageUsageRsp
 * JD-Core Version:    0.7.0.1
 */