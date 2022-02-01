package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class gallery_report$OnePicReported
  extends MessageMicro<OnePicReported>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "index", "come_in_time", "load_completed_time", "go_away_time", "pic_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, OnePicReported.class);
  public final PBUInt64Field come_in_time = PBField.initUInt64(0L);
  public final PBUInt64Field go_away_time = PBField.initUInt64(0L);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBUInt64Field load_completed_time = PBField.initUInt64(0L);
  public final PBUInt32Field pic_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery_report.OnePicReported
 * JD-Core Version:    0.7.0.1
 */