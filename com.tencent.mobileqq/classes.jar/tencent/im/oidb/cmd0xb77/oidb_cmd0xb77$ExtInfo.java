package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb77$ExtInfo
  extends MessageMicro<ExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88, 98, 104, 112, 120 }, new String[] { "rpt_custom_featureid", "apns_wording", "uint32_group_savedb_flag", "receiver_appid", "msg_seq" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ExtInfo.class);
  public final PBStringField apns_wording = PBField.initString("");
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  public final PBUInt32Field receiver_appid = PBField.initUInt32(0);
  public final PBRepeatField<Integer> rpt_custom_featureid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_group_savedb_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ExtInfo
 * JD-Core Version:    0.7.0.1
 */