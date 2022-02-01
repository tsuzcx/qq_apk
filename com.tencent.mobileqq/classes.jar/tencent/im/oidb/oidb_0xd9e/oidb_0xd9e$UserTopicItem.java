package tencent.im.oidb.oidb_0xd9e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd9e$UserTopicItem
  extends MessageMicro<UserTopicItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_topic = PBField.initString("");
  public final PBUInt32Field uint32_frd_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_topic_id", "str_topic", "uint32_total_num", "uint32_frd_num" }, new Object[] { localInteger, "", localInteger, localInteger }, UserTopicItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd9e.oidb_0xd9e.UserTopicItem
 * JD-Core Version:    0.7.0.1
 */