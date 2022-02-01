package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class QQCirclePay$StPayComm
  extends MessageMicro<StPayComm>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field myMoney = PBField.initInt64(0L);
  public final PBInt64Field myMoneyWithdrawal = PBField.initInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "myMoney", "myMoneyWithdrawal" }, new Object[] { localLong, localLong }, StPayComm.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCirclePay.StPayComm
 * JD-Core Version:    0.7.0.1
 */