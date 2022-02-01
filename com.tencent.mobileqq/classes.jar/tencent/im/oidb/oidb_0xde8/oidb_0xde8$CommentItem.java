package tencent.im.oidb.oidb_0xde8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xde8$CommentItem
  extends MessageMicro<CommentItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_comment = PBField.initString("");
  public final PBUInt64Field uint64_comment_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_target_comment_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_target_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "uint64_comment_id", "str_comment", "uint64_target_comment_id", "uint64_target_uin", "uint64_comment_uin", "uint64_time" }, new Object[] { localLong, "", localLong, localLong, localLong, localLong }, CommentItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xde8.oidb_0xde8.CommentItem
 * JD-Core Version:    0.7.0.1
 */