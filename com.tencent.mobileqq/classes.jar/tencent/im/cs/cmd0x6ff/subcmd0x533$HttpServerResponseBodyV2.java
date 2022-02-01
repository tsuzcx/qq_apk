package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class subcmd0x533$HttpServerResponseBodyV2
  extends MessageMicro<HttpServerResponseBodyV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58, 64, 72 }, new String[] { "int32_tencent_errorcode", "string_tencent_errormsg", "int32_sougou_errorcode", "string_sougou_errormsg", "rpt_msg_cards", "string_request_class", "rpt_msg_container_properties", "bool_is_recommended", "int64_session_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", null, "", null, Boolean.valueOf(false), Long.valueOf(0L) }, HttpServerResponseBodyV2.class);
  public final PBBoolField bool_is_recommended = PBField.initBool(false);
  public final PBInt32Field int32_sougou_errorcode = PBField.initInt32(0);
  public final PBInt32Field int32_tencent_errorcode = PBField.initInt32(0);
  public final PBInt64Field int64_session_id = PBField.initInt64(0L);
  public final PBRepeatMessageField<subcmd0x533.HttpCardV2> rpt_msg_cards = PBField.initRepeatMessage(subcmd0x533.HttpCardV2.class);
  public final PBRepeatMessageField<subcmd0x533.HttpMapItem> rpt_msg_container_properties = PBField.initRepeatMessage(subcmd0x533.HttpMapItem.class);
  public final PBStringField string_request_class = PBField.initString("");
  public final PBStringField string_sougou_errormsg = PBField.initString("");
  public final PBStringField string_tencent_errormsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x533.HttpServerResponseBodyV2
 * JD-Core Version:    0.7.0.1
 */