package tencent.im.groupvideo.memposinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class memposinfo$AccountExtInfo
  extends MessageMicro<AccountExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_common_info", "msg_mini_program_info" }, new Object[] { null, null }, AccountExtInfo.class);
  public memposinfo.CommonInfo msg_common_info = new memposinfo.CommonInfo();
  public memposinfo.MiniProgramInfo msg_mini_program_info = new memposinfo.MiniProgramInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.groupvideo.memposinfo.memposinfo.AccountExtInfo
 * JD-Core Version:    0.7.0.1
 */