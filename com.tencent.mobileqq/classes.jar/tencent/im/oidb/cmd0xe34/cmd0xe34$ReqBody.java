package tencent.im.oidb.cmd0xe34;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0xe34$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_bind_uin_info" }, new Object[] { null }, ReqBody.class);
  public final PBRepeatMessageField<cmd0xe34.BindUinInfo> rpt_bind_uin_info = PBField.initRepeatMessage(cmd0xe34.BindUinInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe34.cmd0xe34.ReqBody
 * JD-Core Version:    0.7.0.1
 */