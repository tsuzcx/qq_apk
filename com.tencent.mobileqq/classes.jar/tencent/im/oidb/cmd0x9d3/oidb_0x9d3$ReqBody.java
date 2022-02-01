package tencent.im.oidb.cmd0x9d3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x9d3$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_comment_id = PBField.initString("");
  public final PBStringField str_feed_id = PBField.initString("");
  public final PBUInt32Field uint32_fetch_new_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fetch_old_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "str_feed_id", "str_comment_id", "uint32_fetch_old_count", "uint32_fetch_new_count" }, new Object[] { "", "", localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9d3.oidb_0x9d3.ReqBody
 * JD-Core Version:    0.7.0.1
 */