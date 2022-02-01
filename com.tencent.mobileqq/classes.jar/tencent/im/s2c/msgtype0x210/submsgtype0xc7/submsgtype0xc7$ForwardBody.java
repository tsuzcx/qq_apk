package tencent.im.s2c.msgtype0x210.submsgtype0xc7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0xc7$ForwardBody
  extends MessageMicro<ForwardBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public submsgtype0xc7.HotFriendNotify msg_hot_friend_notify = new submsgtype0xc7.HotFriendNotify();
  public submsgtype0xc7.RelationalChainChange msg_relational_chain_change = new submsgtype0xc7.RelationalChainChange();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24002, 32002 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_hot_friend_notify", "msg_relational_chain_change" }, new Object[] { localInteger, localInteger, null, null }, ForwardBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ForwardBody
 * JD-Core Version:    0.7.0.1
 */