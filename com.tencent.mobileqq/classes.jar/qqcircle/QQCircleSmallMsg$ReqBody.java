package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleSmallMsg$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "c2c_req_body", "group_req_body" }, new Object[] { null, null }, ReqBody.class);
  public QQCircleSmallMsg.C2CReqBody c2c_req_body = new QQCircleSmallMsg.C2CReqBody();
  public QQCircleSmallMsg.GroupReqBody group_req_body = new QQCircleSmallMsg.GroupReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleSmallMsg.ReqBody
 * JD-Core Version:    0.7.0.1
 */