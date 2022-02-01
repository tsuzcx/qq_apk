package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class QQCirclePay$StPayRetryDetail
  extends MessageMicro<StPayRetryDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26, 34 }, new String[] { "todoState", "stateInfo", "desc" }, new Object[] { Integer.valueOf(0), null, null }, StPayRetryDetail.class);
  public QQCirclePay.PayDescription desc = new QQCirclePay.PayDescription();
  public QQCirclePay.StStateInfo stateInfo = new QQCirclePay.StStateInfo();
  public final PBInt32Field todoState = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCirclePay.StPayRetryDetail
 * JD-Core Version:    0.7.0.1
 */