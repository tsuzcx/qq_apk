package tencent.im.oidb.cmd0xcf8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xcf8$ConfigGroupInfo
  extends MessageMicro<ConfigGroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "config_info" }, new Object[] { null }, ConfigGroupInfo.class);
  public final PBRepeatMessageField<oidb_cmd0xcf8.ConfigInfo> config_info = PBField.initRepeatMessage(oidb_cmd0xcf8.ConfigInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.ConfigGroupInfo
 * JD-Core Version:    0.7.0.1
 */