package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class servtype$LiveChannelInfoFilter
  extends MessageMicro<LiveChannelInfoFilter>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_is_need_anchor_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_need_name = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_need_room_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_is_need_room_id", "uint32_is_need_anchor_uin", "uint32_is_need_name" }, new Object[] { localInteger, localInteger, localInteger }, LiveChannelInfoFilter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.LiveChannelInfoFilter
 * JD-Core Version:    0.7.0.1
 */