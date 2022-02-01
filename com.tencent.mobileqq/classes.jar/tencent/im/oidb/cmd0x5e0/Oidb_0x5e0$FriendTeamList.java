package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x5e0$FriendTeamList
  extends MessageMicro<FriendTeamList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16 }, new String[] { "uint32_update_flag" }, new Object[] { Integer.valueOf(0) }, FriendTeamList.class);
  public final PBUInt32Field uint32_update_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.FriendTeamList
 * JD-Core Version:    0.7.0.1
 */