package tencent.sso.roam;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Roam$RoamQualifyReq
  extends MessageMicro<RoamQualifyReq>
{
  public static final int HEAD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "head" }, new Object[] { null }, RoamQualifyReq.class);
  public Roam.RoamReqHead head = new Roam.RoamReqHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.sso.roam.Roam.RoamQualifyReq
 * JD-Core Version:    0.7.0.1
 */