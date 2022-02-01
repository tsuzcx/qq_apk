package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleCountergroup$InvitationTicket
  extends MessageMicro<InvitationTicket>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "groupID", "InvitationCode" }, new Object[] { Long.valueOf(0L), "" }, InvitationTicket.class);
  public final PBStringField InvitationCode = PBField.initString("");
  public final PBUInt64Field groupID = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleCountergroup.InvitationTicket
 * JD-Core Version:    0.7.0.1
 */