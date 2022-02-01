package tencent.im.oidb.cmd0xeac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xeac$BatchReqBody
  extends MessageMicro<BatchReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "group_code", "msgs" }, new Object[] { Long.valueOf(0L), null }, BatchReqBody.class);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBRepeatMessageField<oidb_0xeac.MsgInfo> msgs = PBField.initRepeatMessage(oidb_0xeac.MsgInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xeac.oidb_0xeac.BatchReqBody
 * JD-Core Version:    0.7.0.1
 */