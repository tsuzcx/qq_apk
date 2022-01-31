package tencent.im.pb.qqsport;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQSportsOrbit$OrbitReq
  extends MessageMicro<OrbitReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "reqHeader", "tracePath", "isOver", "num" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, OrbitReq.class);
  public final PBInt32Field isOver = PBField.initInt32(0);
  public final PBInt32Field num = PBField.initInt32(0);
  public QQSportsOrbit.OrbitHeader reqHeader = new QQSportsOrbit.OrbitHeader();
  public final PBRepeatMessageField<QQSportsOrbit.OrbitPoint> tracePath = PBField.initRepeatMessage(QQSportsOrbit.OrbitPoint.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.pb.qqsport.QQSportsOrbit.OrbitReq
 * JD-Core Version:    0.7.0.1
 */