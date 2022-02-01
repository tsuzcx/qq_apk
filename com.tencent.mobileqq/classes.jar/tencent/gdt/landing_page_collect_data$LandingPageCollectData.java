package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class landing_page_collect_data$LandingPageCollectData
  extends MessageMicro<LandingPageCollectData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field avail_height = PBField.initUInt32(0);
  public final PBUInt32Field browsing_percent = PBField.initUInt32(0);
  public final PBUInt32Field browsing_percent_end = PBField.initUInt32(0);
  public final PBUInt32Field browsing_percent_start = PBField.initUInt32(0);
  public final PBUInt32Field browsing_time = PBField.initUInt32(0);
  public final PBUInt32Field browsing_time_on_area = PBField.initUInt32(0);
  public final PBUInt32Field click_offset_x = PBField.initUInt32(0);
  public final PBUInt32Field click_offset_y = PBField.initUInt32(0);
  public final PBUInt32Field client_height = PBField.initUInt32(0);
  public final PBUInt32Field landing_error_code = PBField.initUInt32(0);
  public final PBUInt32Field landing_page_action_type = PBField.initUInt32(0);
  public final PBUInt64Field latency_ms = PBField.initUInt64(0L);
  public final PBStringField schemeid = PBField.initString("");
  public final PBStringField screen_height = PBField.initString("");
  public final PBStringField screen_width = PBField.initString("");
  public final PBUInt32Field scroll_top = PBField.initUInt32(0);
  public landing_page_collect_data.LandingPageCollectData.SubordinateProductInfo subordinate_product_info = new landing_page_collect_data.LandingPageCollectData.SubordinateProductInfo();
  public final PBUInt32Field xj_page_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58, 66, 72, 80, 88, 96, 104, 112, 120, 128, 136, 146 }, new String[] { "landing_page_action_type", "latency_ms", "landing_error_code", "browsing_time", "schemeid", "browsing_percent", "screen_height", "screen_width", "avail_height", "client_height", "scroll_top", "click_offset_x", "click_offset_y", "browsing_percent_start", "browsing_percent_end", "browsing_time_on_area", "xj_page_id", "subordinate_product_info" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localInteger, "", localInteger, "", "", localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, null }, LandingPageCollectData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.landing_page_collect_data.LandingPageCollectData
 * JD-Core Version:    0.7.0.1
 */