package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class topic_info$RowkeyInfo
  extends MessageMicro<RowkeyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field add_time = PBField.initUInt64(0L);
  public final PBUInt32Field chapter = PBField.initUInt32(0);
  public final PBUInt32Field content_type = PBField.initUInt32(0);
  public final PBUInt32Field end_ts = PBField.initUInt32(0);
  public final PBUInt32Field pay_type = PBField.initUInt32(0);
  public final PBStringField rowkey = PBField.initString("");
  public final PBStringField show_text = PBField.initString("");
  public final PBUInt32Field start_ts = PBField.initUInt32(0);
  public final PBUInt32Field weight = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 74 }, new String[] { "add_time", "rowkey", "start_ts", "end_ts", "content_type", "pay_type", "weight", "chapter", "show_text" }, new Object[] { Long.valueOf(0L), "", localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, "" }, RowkeyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.RowkeyInfo
 * JD-Core Version:    0.7.0.1
 */