package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearbybanner$Banners
  extends MessageMicro<Banners>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_banner_info", "uint32_slide_time" }, new Object[] { null, Integer.valueOf(0) }, Banners.class);
  public final PBRepeatMessageField<nearbybanner.BannerInfo> rpt_banner_info = PBField.initRepeatMessage(nearbybanner.BannerInfo.class);
  public final PBUInt32Field uint32_slide_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.group.nearbybanner.nearbybanner.Banners
 * JD-Core Version:    0.7.0.1
 */