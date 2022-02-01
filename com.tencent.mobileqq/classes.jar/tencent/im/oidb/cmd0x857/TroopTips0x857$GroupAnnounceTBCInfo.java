package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$GroupAnnounceTBCInfo
  extends MessageMicro<GroupAnnounceTBCInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field action = PBField.initUInt32(0);
  public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "feeds_id", "group_id", "action" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, GroupAnnounceTBCInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.GroupAnnounceTBCInfo
 * JD-Core Version:    0.7.0.1
 */