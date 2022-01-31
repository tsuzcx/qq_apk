package tencent.im.oidb.cmd0xc7a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xc7a$GetUinInfoRsp
  extends MessageMicro<GetUinInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "uin_infos" }, new Object[] { null }, GetUinInfoRsp.class);
  public final PBRepeatMessageField<oidb_cmd0xc7a.UinInfo> uin_infos = PBField.initRepeatMessage(oidb_cmd0xc7a.UinInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc7a.oidb_cmd0xc7a.GetUinInfoRsp
 * JD-Core Version:    0.7.0.1
 */