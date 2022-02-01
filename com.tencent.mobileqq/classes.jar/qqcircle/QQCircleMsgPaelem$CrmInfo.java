package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleMsgPaelem$CrmInfo
  extends MessageMicro<CrmInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_service_type", "msg_instance" }, new Object[] { Integer.valueOf(0), null }, CrmInfo.class);
  public QQCircleMsgPaelem.InstanceInfo msg_instance = new QQCircleMsgPaelem.InstanceInfo();
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleMsgPaelem.CrmInfo
 * JD-Core Version:    0.7.0.1
 */