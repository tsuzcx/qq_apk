package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class fd_comm$MoneyPackInfo
  extends MessageMicro<MoneyPackInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField des = PBField.initString("");
  public final PBUInt32Field money = PBField.initUInt32(0);
  public final PBUInt32Field money_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "money", "des", "money_id" }, new Object[] { localInteger, "", localInteger }, MoneyPackInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     fudai.fd_comm.MoneyPackInfo
 * JD-Core Version:    0.7.0.1
 */