package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class gallery$ReportExData
  extends MessageMicro<ReportExData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "request_timestamp", "mf_seq", "alid", "sort_func" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), "" }, ReportExData.class);
  public final PBUInt64Field alid = PBField.initUInt64(0L);
  public final PBStringField mf_seq = PBField.initString("");
  public final PBUInt64Field request_timestamp = PBField.initUInt64(0L);
  public final PBStringField sort_func = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery.ReportExData
 * JD-Core Version:    0.7.0.1
 */