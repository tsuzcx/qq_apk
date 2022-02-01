package nearby_interact_state;

import appoint.define.appoint_define.FeedComment;
import appoint.define.appoint_define.RichText;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class interact_value$FreshThing
  extends MessageMicro<FreshThing>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_content_2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_content_3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField bytes_fresh_thing_comment_id = PBField.initString("");
  public final PBBytesField bytes_fresh_thing_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public appoint_define.FeedComment fresh_comment = new appoint_define.FeedComment();
  public appoint_define.RichText fresh_thing_info = new appoint_define.RichText();
  public final PBUInt32Field uint32_color_2_row = PBField.initUInt32(0);
  public final PBUInt32Field uint32_color_3_row = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64 }, new String[] { "bytes_fresh_thing_id", "bytes_fresh_thing_comment_id", "bytes_content_2", "fresh_comment", "bytes_content_3", "fresh_thing_info", "uint32_color_2_row", "uint32_color_3_row" }, new Object[] { localByteStringMicro1, "", localByteStringMicro2, null, localByteStringMicro3, null, Integer.valueOf(0), Integer.valueOf(0) }, FreshThing.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nearby_interact_state.interact_value.FreshThing
 * JD-Core Version:    0.7.0.1
 */