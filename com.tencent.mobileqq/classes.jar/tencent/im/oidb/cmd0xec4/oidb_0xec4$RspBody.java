package tencent.im.oidb.cmd0xec4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xec4$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_fetch_over = PBField.initBool(false);
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0xec4.Quest> msg_quest = PBField.initRepeatMessage(oidb_0xec4.Quest.class);
  public final PBUInt32Field uint32_answered_quest_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ret = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_quest_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48 }, new String[] { "msg_quest", "bool_is_fetch_over", "uint32_total_quest_num", "bytes_cookie", "uint32_ret", "uint32_answered_quest_num" }, new Object[] { null, Boolean.valueOf(false), localInteger, localByteStringMicro, localInteger, localInteger }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xec4.oidb_0xec4.RspBody
 * JD-Core Version:    0.7.0.1
 */