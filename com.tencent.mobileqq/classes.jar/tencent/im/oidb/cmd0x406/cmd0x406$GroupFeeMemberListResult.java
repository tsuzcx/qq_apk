package tencent.im.oidb.cmd0x406;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x406$GroupFeeMemberListResult
  extends MessageMicro<GroupFeeMemberListResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_page_index = PBField.initInt32(0);
  public final PBRepeatMessageField<cmd0x406.GroupFeeMember> msg_member_list = PBField.initRepeatMessage(cmd0x406.GroupFeeMember.class);
  public final PBUInt32Field uint32_member_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "int32_page_index", "uint32_member_type", "msg_member_list" }, new Object[] { localInteger, localInteger, null }, GroupFeeMemberListResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMemberListResult
 * JD-Core Version:    0.7.0.1
 */