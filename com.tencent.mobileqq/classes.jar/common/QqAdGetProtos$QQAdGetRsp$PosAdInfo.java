package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QqAdGetProtos$QQAdGetRsp$PosAdInfo
  extends MessageMicro<PosAdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "ret", "msg", "pos_id", "ads_info" }, new Object[] { Integer.valueOf(0), "", "", null }, PosAdInfo.class);
  public final PBRepeatMessageField<QqAdGetProtos.QQAdGetRsp.AdInfo> ads_info = PBField.initRepeatMessage(QqAdGetProtos.QQAdGetRsp.AdInfo.class);
  public final PBStringField msg = PBField.initString("");
  public final PBStringField pos_id = PBField.initString("");
  public final PBInt32Field ret = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.PosAdInfo
 * JD-Core Version:    0.7.0.1
 */