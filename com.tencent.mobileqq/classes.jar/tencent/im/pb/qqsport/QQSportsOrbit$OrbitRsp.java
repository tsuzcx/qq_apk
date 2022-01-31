package tencent.im.pb.qqsport;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQSportsOrbit$OrbitRsp
  extends MessageMicro<OrbitRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "retCode", "lastNum", "isOver", "rspHeader" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, OrbitRsp.class);
  public final PBInt32Field isOver = PBField.initInt32(0);
  public final PBInt32Field lastNum = PBField.initInt32(0);
  public final PBInt32Field retCode = PBField.initInt32(0);
  public QQSportsOrbit.OrbitHeader rspHeader = new QQSportsOrbit.OrbitHeader();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.pb.qqsport.QQSportsOrbit.OrbitRsp
 * JD-Core Version:    0.7.0.1
 */