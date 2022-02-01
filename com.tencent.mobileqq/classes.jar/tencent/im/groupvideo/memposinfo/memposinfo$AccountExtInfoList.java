package tencent.im.groupvideo.memposinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class memposinfo$AccountExtInfoList
  extends MessageMicro<AccountExtInfoList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_account_ext_info" }, new Object[] { null }, AccountExtInfoList.class);
  public final PBRepeatMessageField<memposinfo.AccountExtInfo> msg_account_ext_info = PBField.initRepeatMessage(memposinfo.AccountExtInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.groupvideo.memposinfo.memposinfo.AccountExtInfoList
 * JD-Core Version:    0.7.0.1
 */