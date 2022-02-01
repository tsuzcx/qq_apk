package tencent.im.oidb.cmd0xf10;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf10$MsgInfo
  extends MessageMicro<MsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField add_digest_avatar = PBField.initString("");
  public final PBStringField add_digest_nick = PBField.initString("");
  public final PBUInt32Field add_digest_time = PBField.initUInt32(0);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBStringField jump_url = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xf10.MsgContent> msg_content = PBField.initRepeatMessage(oidb_0xf10.MsgContent.class);
  public final PBUInt32Field msg_random = PBField.initUInt32(0);
  public final PBUInt32Field msg_seq = PBField.initUInt32(0);
  public final PBStringField sender_avatar = PBField.initString("");
  public final PBStringField sender_nick = PBField.initString("");
  public final PBUInt32Field sender_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58, 66, 72, 82, 90 }, new String[] { "group_code", "msg_seq", "msg_random", "sender_avatar", "sender_nick", "sender_time", "add_digest_avatar", "add_digest_nick", "add_digest_time", "jump_url", "msg_content" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, "", "", localInteger, "", "", localInteger, "", null }, MsgInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf10.oidb_0xf10.MsgInfo
 * JD-Core Version:    0.7.0.1
 */