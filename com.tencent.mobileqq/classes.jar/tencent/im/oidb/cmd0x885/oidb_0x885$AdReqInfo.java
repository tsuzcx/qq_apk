package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x885$AdReqInfo
  extends MessageMicro<AdReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58, 66, 74, 80, 88, 98, 106, 112, 120 }, new String[] { "uint64_ad_channel_id", "int32_req_type", "msg_game_component_info", "int32_first_refresh", "int32_second_request", "rpt_feeds_context", "string_article_id", "msg_kol_info", "string_deep_link_version", "int32_scene_id", "int32_revision_video", "string_content_id", "string_account_id", "present_from", "source_channel_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), null, "", null, "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L) }, AdReqInfo.class);
  public final PBInt32Field int32_first_refresh = PBField.initInt32(0);
  public final PBInt32Field int32_req_type = PBField.initInt32(0);
  public final PBInt32Field int32_revision_video = PBField.initInt32(0);
  public final PBInt32Field int32_scene_id = PBField.initInt32(0);
  public final PBInt32Field int32_second_request = PBField.initInt32(0);
  public oidb_0x885.GameComponentInfo msg_game_component_info = new oidb_0x885.GameComponentInfo();
  public oidb_0x885.KolInfo msg_kol_info = new oidb_0x885.KolInfo();
  public final PBUInt32Field present_from = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0x885.FeedsItem> rpt_feeds_context = PBField.initRepeatMessage(oidb_0x885.FeedsItem.class);
  public final PBUInt64Field source_channel_id = PBField.initUInt64(0L);
  public final PBStringField string_account_id = PBField.initString("");
  public final PBStringField string_article_id = PBField.initString("");
  public final PBStringField string_content_id = PBField.initString("");
  public final PBStringField string_deep_link_version = PBField.initString("");
  public final PBUInt64Field uint64_ad_channel_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.AdReqInfo
 * JD-Core Version:    0.7.0.1
 */