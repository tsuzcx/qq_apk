package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TroopTips0x857$GoldMsgTipsElem
  extends MessageMicro<GoldMsgTipsElem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "type", "billno", "result", "amount", "total", "interval", "finish", "uin", "action" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, GoldMsgTipsElem.class);
  public final PBUInt32Field action = PBField.initUInt32(0);
  public final PBUInt32Field amount = PBField.initUInt32(0);
  public final PBStringField billno = PBField.initString("");
  public final PBUInt32Field finish = PBField.initUInt32(0);
  public final PBUInt32Field interval = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBRepeatField<Long> uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.GoldMsgTipsElem
 * JD-Core Version:    0.7.0.1
 */