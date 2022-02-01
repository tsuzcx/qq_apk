package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class landing_page_collect_data$LandingPageCollectData$SubordinateProductInfo
  extends MessageMicro<SubordinateProductInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "id", "real_id", "pkg_url", "pkg_md5" }, new Object[] { "", "", "", "" }, SubordinateProductInfo.class);
  public final PBStringField id = PBField.initString("");
  public final PBStringField pkg_md5 = PBField.initString("");
  public final PBStringField pkg_url = PBField.initString("");
  public final PBStringField real_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.landing_page_collect_data.LandingPageCollectData.SubordinateProductInfo
 * JD-Core Version:    0.7.0.1
 */