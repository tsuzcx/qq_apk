package tencent.im.oidb.cmd0xe1b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.kandian.flaginfo.flag_info.FlagInfo;

public final class oidb_0xe1b$SetFlagInfoRsp
  extends MessageMicro<SetFlagInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_flag_info_list" }, new Object[] { null }, SetFlagInfoRsp.class);
  public final PBRepeatMessageField<flag_info.FlagInfo> rpt_msg_flag_info_list = PBField.initRepeatMessage(flag_info.FlagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe1b.oidb_0xe1b.SetFlagInfoRsp
 * JD-Core Version:    0.7.0.1
 */