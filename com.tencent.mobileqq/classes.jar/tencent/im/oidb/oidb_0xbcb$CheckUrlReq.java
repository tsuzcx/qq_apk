package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xbcb$CheckUrlReq
  extends MessageMicro<CheckUrlReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField ark_name = PBField.initString("");
  public final PBBoolField is_ark = PBField.initBool(false);
  public final PBBoolField is_finish = PBField.initBool(false);
  public final PBUInt64Field msg_chatid = PBField.initUInt64(0L);
  public final PBUInt32Field msg_from = PBField.initUInt32(0);
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBStringField original_url = PBField.initString("");
  public final PBStringField plateform = PBField.initString("");
  public final PBStringField qq_pf_to = PBField.initString("");
  public final PBStringField qua = PBField.initString("");
  public final PBStringField refer = PBField.initString("");
  public final PBStringField req_type = PBField.initString("");
  public final PBUInt64Field send_uin = PBField.initUInt64(0L);
  public final PBUInt64Field service_type = PBField.initUInt64(0L);
  public final PBUInt32Field src_platform = PBField.initUInt32(0);
  public final PBRepeatField<String> src_urls = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatField<String> url = PBField.initRepeat(PBStringField.__repeatHelper__);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64, 72, 82, 90, 96, 106, 112, 122, 128, 138 }, new String[] { "url", "refer", "plateform", "qq_pf_to", "msg_type", "msg_from", "msg_chatid", "service_type", "send_uin", "req_type", "original_url", "is_ark", "ark_name", "is_finish", "src_urls", "src_platform", "qua" }, new Object[] { "", "", "", "", localInteger, localInteger, localLong, localLong, localLong, "", "", localBoolean, "", localBoolean, "", localInteger, "" }, CheckUrlReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xbcb.CheckUrlReq
 * JD-Core Version:    0.7.0.1
 */