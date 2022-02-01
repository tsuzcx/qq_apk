package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class apollo_push_msgInfo$STPushMsgElem
  extends MessageMicro<STPushMsgElem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114 }, new String[] { "type", "showPlace", "priority", "pm1", "pm2", "pm3", "pm4" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null }, STPushMsgElem.class);
  public apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1 pm1 = new apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1();
  public apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2 pm2 = new apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2();
  public final PBRepeatMessageField<apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3> pm3 = PBField.initRepeatMessage(apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3.class);
  public final PBRepeatMessageField<apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4> pm4 = PBField.initRepeatMessage(apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4.class);
  public final PBInt32Field priority = PBField.initInt32(0);
  public final PBUInt32Field showPlace = PBField.initUInt32(0);
  public final PBInt32Field type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.apollo_push_msgInfo.STPushMsgElem
 * JD-Core Version:    0.7.0.1
 */