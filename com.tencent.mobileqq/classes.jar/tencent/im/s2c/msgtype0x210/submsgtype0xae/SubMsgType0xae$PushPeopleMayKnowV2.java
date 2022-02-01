package tencent.im.s2c.msgtype0x210.submsgtype0xae;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SubMsgType0xae$PushPeopleMayKnowV2
  extends MessageMicro<PushPeopleMayKnowV2>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_role_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
  public final PBRepeatMessageField<SubMsgType0xae.PersonMayKnow> rpt_msg_friend_list = PBField.initRepeatMessage(SubMsgType0xae.PersonMayKnow.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 18, 26 }, new String[] { "fixed32_timestamp", "rpt_msg_friend_list", "bytes_role_name" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro }, PushPeopleMayKnowV2.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PushPeopleMayKnowV2
 * JD-Core Version:    0.7.0.1
 */