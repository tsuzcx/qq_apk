package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackShareReport$ReportShareReq
  extends MessageMicro<ReportShareReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field combo_count = PBField.initUInt32(0);
  public final PBUInt32Field promotion_id = PBField.initUInt32(0);
  public final PBUInt32Field share_channel = PBField.initUInt32(0);
  public final PBUInt32Field share_error = PBField.initUInt32(0);
  public final PBUInt32Field share_type = PBField.initUInt32(0);
  public final PBUInt32Field swipe_count = PBField.initUInt32(0);
  public final PBUInt32Field win_goods_count = PBField.initUInt32(0);
  public final PBUInt32Field win_money_count = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "promotion_id", "share_type", "share_channel", "swipe_count", "combo_count", "win_money_count", "win_goods_count", "share_error" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, ReportShareReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.new_year_report.PackShareReport.ReportShareReq
 * JD-Core Version:    0.7.0.1
 */