package tencent.im.oidb.cmd0xa2a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa2a$GroupOnlineInfo
  extends MessageMicro<GroupOnlineInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field hok_num = PBField.initUInt32(0);
  public final PBUInt32Field online_num = PBField.initUInt32(0);
  public final PBUInt32Field star_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "group_id", "online_num", "star_num", "hok_num" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger }, GroupOnlineInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa2a.oidb_0xa2a.GroupOnlineInfo
 * JD-Core Version:    0.7.0.1
 */