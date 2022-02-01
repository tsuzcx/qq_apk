package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleSmallMsg$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "c2c_rsp_body", "group_rsp_body" }, new Object[] { null, null }, RspBody.class);
  public QQCircleSmallMsg.C2CRspBody c2c_rsp_body = new QQCircleSmallMsg.C2CRspBody();
  public QQCircleSmallMsg.GroupRspBody group_rsp_body = new QQCircleSmallMsg.GroupRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleSmallMsg.RspBody
 * JD-Core Version:    0.7.0.1
 */