package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x58b$GetMultiConfInfoRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_conf_info" }, new Object[] { null }, GetMultiConfInfoRsp.class);
  public final PBRepeatMessageField msg_get_conf_info = PBField.initRepeatMessage(cmd0x58b.GetConfInfoRsp.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58b.cmd0x58b.GetMultiConfInfoRsp
 * JD-Core Version:    0.7.0.1
 */