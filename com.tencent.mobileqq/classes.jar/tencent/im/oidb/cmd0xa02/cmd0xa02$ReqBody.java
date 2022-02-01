package tencent.im.oidb.cmd0xa02;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0xa02$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int RPT_TINYID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_tinyid" }, new Object[] { null }, ReqBody.class);
  public final PBRepeatMessageField<cmd0xa02.TinyID> rpt_tinyid = PBField.initRepeatMessage(cmd0xa02.TinyID.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa02.cmd0xa02.ReqBody
 * JD-Core Version:    0.7.0.1
 */