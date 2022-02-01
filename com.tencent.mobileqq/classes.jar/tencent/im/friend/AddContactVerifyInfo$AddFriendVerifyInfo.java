package tencent.im.friend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AddContactVerifyInfo$AddFriendVerifyInfo
  extends MessageMicro<AddFriendVerifyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_type", "str_url", "str_verify_info" }, new Object[] { Integer.valueOf(0), "", "" }, AddFriendVerifyInfo.class);
  public final PBStringField str_url = PBField.initString("");
  public final PBStringField str_verify_info = PBField.initString("");
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.friend.AddContactVerifyInfo.AddFriendVerifyInfo
 * JD-Core Version:    0.7.0.1
 */