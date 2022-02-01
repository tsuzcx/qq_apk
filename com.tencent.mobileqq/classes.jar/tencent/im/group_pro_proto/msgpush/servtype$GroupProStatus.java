package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class servtype$GroupProStatus
  extends MessageMicro<GroupProStatus>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_is_banned = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_enable = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_frozen = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_is_enable", "uint32_is_banned", "uint32_is_frozen" }, new Object[] { localInteger, localInteger, localInteger }, GroupProStatus.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.GroupProStatus
 * JD-Core Version:    0.7.0.1
 */