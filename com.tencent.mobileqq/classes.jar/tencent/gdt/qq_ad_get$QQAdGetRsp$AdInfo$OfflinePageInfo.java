package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGetRsp$AdInfo$OfflinePageInfo
  extends MessageMicro<OfflinePageInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "offline_landing_page", "offline_json_url", "offline_json_key", "offline_id" }, new Object[] { "", "", "", Integer.valueOf(0) }, OfflinePageInfo.class);
  public final PBInt32Field offline_id = PBField.initInt32(0);
  public final PBStringField offline_json_key = PBField.initString("");
  public final PBStringField offline_json_url = PBField.initString("");
  public final PBStringField offline_landing_page = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.OfflinePageInfo
 * JD-Core Version:    0.7.0.1
 */