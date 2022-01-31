package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqconnect$MiniAppInfo
  extends MessageMicro<MiniAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 88, 98, 104, 114, 120 }, new String[] { "super_uin", "owner_type", "owner_name", "owner_id_card_type", "owner_id_card", "owner_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0) }, MiniAppInfo.class);
  public final PBStringField owner_id_card = PBField.initString("");
  public final PBUInt32Field owner_id_card_type = PBField.initUInt32(0);
  public final PBStringField owner_name = PBField.initString("");
  public final PBUInt32Field owner_status = PBField.initUInt32(0);
  public final PBUInt32Field owner_type = PBField.initUInt32(0);
  public final PBUInt64Field super_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.MiniAppInfo
 * JD-Core Version:    0.7.0.1
 */