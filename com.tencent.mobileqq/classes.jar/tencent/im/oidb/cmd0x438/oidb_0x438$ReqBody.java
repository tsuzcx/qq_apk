package tencent.im.oidb.cmd0x438;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0x438$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "stReqInfo" }, new Object[] { null }, ReqBody.class);
  public final PBRepeatMessageField stReqInfo = PBField.initRepeatMessage(oidb_0x438.ReqInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x438.oidb_0x438.ReqBody
 * JD-Core Version:    0.7.0.1
 */