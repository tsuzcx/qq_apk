package tencent.im.oidb.cmd0x487;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x487$GroupList
  extends MessageMicro<GroupList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_opt_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_groupcode", "uint64_opt_uin", "bytes_group_name" }, new Object[] { localLong, localLong, localByteStringMicro }, GroupList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x487.oidb_0x487.GroupList
 * JD-Core Version:    0.7.0.1
 */