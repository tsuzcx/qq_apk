package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleEnvHub$ExposeTipsRsp
  extends MessageMicro<ExposeTipsRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tips" }, new Object[] { null }, ExposeTipsRsp.class);
  public QQCircleEnvHub.Tips tips = new QQCircleEnvHub.Tips();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleEnvHub.ExposeTipsRsp
 * JD-Core Version:    0.7.0.1
 */