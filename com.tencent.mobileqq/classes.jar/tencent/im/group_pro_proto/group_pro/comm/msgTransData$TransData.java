package tencent.im.group_pro_proto.group_pro.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class msgTransData$TransData
  extends MessageMicro<TransData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_client_identity" }, new Object[] { null }, TransData.class);
  public msgTransData.ClientIdentity rpt_client_identity = new msgTransData.ClientIdentity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.group_pro.comm.msgTransData.TransData
 * JD-Core Version:    0.7.0.1
 */