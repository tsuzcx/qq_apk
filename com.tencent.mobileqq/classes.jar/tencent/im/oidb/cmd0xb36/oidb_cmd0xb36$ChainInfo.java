package tencent.im.oidb.cmd0xb36;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb36$ChainInfo
  extends MessageMicro<ChainInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56, 64 }, new String[] { "id", "type", "uin", "desc", "pic", "created", "expired", "is_joined" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ChainInfo.class);
  public final PBUInt32Field created = PBField.initUInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBUInt32Field expired = PBField.initUInt32(0);
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBUInt32Field is_joined = PBField.initUInt32(0);
  public final PBRepeatField<String> pic = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb36.oidb_cmd0xb36.ChainInfo
 * JD-Core Version:    0.7.0.1
 */