package tencent.sso.roam;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Roam$RoamQualifyRsp
  extends MessageMicro
{
  public static final int HEAD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "head" }, new Object[] { null }, RoamQualifyRsp.class);
  public Roam.RoamRspHead head = new Roam.RoamRspHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.sso.roam.Roam.RoamQualifyRsp
 * JD-Core Version:    0.7.0.1
 */