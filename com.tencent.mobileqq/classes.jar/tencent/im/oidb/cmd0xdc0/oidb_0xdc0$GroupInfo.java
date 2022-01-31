package tencent.im.oidb.cmd0xdc0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xdc0$GroupInfo
  extends MessageMicro<GroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0xdc0.LocationInfo> rpt_location_list = PBField.initRepeatMessage(oidb_0xdc0.LocationInfo.class);
  public final PBUInt32Field uint32_order = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 90 }, new String[] { "bytes_name", "uint32_order", "rpt_location_list" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, GroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc0.oidb_0xdc0.GroupInfo
 * JD-Core Version:    0.7.0.1
 */