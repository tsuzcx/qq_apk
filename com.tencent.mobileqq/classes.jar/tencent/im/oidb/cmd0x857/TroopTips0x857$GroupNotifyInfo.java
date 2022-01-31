package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$GroupNotifyInfo
  extends MessageMicro<GroupNotifyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field opt_uint32_auto_pull_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint32_auto_pull_flag", "opt_bytes_feeds_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GroupNotifyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.GroupNotifyInfo
 * JD-Core Version:    0.7.0.1
 */