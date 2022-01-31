package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FudaiActiveReport$ActiveReportReq
  extends MessageMicro<ActiveReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82, 90, 96, 104, 112, 120, 128, 136, 144 }, new String[] { "act_id", "optime", "touin", "group_uin", "banner_id", "pendant_id", "vid", "game_id", "brand_id", "card_id", "fudai_id", "award_type", "cash_value", "entrance_remind", "fd_status_type", "share_source", "share_type", "follow_brand" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Boolean.valueOf(false) }, ActiveReportReq.class);
  public final PBUInt32Field act_id = PBField.initUInt32(0);
  public final PBEnumField award_type = PBField.initEnum(0);
  public final PBStringField banner_id = PBField.initString("");
  public final PBStringField brand_id = PBField.initString("");
  public final PBStringField card_id = PBField.initString("");
  public final PBUInt32Field cash_value = PBField.initUInt32(0);
  public final PBBoolField entrance_remind = PBField.initBool(false);
  public final PBEnumField fd_status_type = PBField.initEnum(0);
  public final PBBoolField follow_brand = PBField.initBool(false);
  public final PBStringField fudai_id = PBField.initString("");
  public final PBStringField game_id = PBField.initString("");
  public final PBUInt64Field group_uin = PBField.initUInt64(0L);
  public final PBUInt64Field optime = PBField.initUInt64(0L);
  public final PBStringField pendant_id = PBField.initString("");
  public final PBEnumField share_source = PBField.initEnum(1);
  public final PBEnumField share_type = PBField.initEnum(1);
  public final PBUInt64Field touin = PBField.initUInt64(0L);
  public final PBStringField vid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     fudai.FudaiActiveReport.ActiveReportReq
 * JD-Core Version:    0.7.0.1
 */