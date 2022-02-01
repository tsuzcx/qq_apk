package tencent.im.s2c.msgtype0x210.submsgtype0x28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x28$FollowList
  extends MessageMicro<FollowList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_disable_cancel_chat = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seqno = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 1080 }, new String[] { "uint64_puin", "uint64_uin", "uint32_type", "uint32_seqno", "uint32_disable_cancel_chat" }, new Object[] { localLong, localLong, localInteger, localInteger, localInteger }, FollowList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28.FollowList
 * JD-Core Version:    0.7.0.1
 */