package tencent.im.oidb.oidb_0xd4a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonGroupChatInfo;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.DnaInfo;

public final class oidb_0xd4a$NotFriendData
  extends MessageMicro<NotFriendData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0xcf4.CommonGroupChatInfo msg_common_group_chat_info = new oidb_0xcf4.CommonGroupChatInfo();
  public final PBRepeatMessageField<oidb_0xcf4.DnaInfo> rpt_msg_dna_info = PBField.initRepeatMessage(oidb_0xcf4.DnaInfo.class);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 98, 114 }, new String[] { "uint64_from_uin", "uint64_to_uin", "msg_common_group_chat_info", "rpt_msg_dna_info" }, new Object[] { localLong, localLong, null, null }, NotFriendData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd4a.oidb_0xd4a.NotFriendData
 * JD-Core Version:    0.7.0.1
 */