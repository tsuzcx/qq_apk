package tencent.im.oidb.cc_sso_report_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cc_sso_report_svr$VideoInfo
  extends MessageMicro<VideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "busitype", "video_type", "file_size", "video_duration", "encode_type", "weight", "height", "rate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "" }, VideoInfo.class);
  public final PBUInt32Field busitype = PBField.initUInt32(0);
  public final PBUInt32Field encode_type = PBField.initUInt32(0);
  public final PBUInt64Field file_size = PBField.initUInt64(0L);
  public final PBUInt64Field height = PBField.initUInt64(0L);
  public final PBStringField rate = PBField.initString("");
  public final PBUInt64Field video_duration = PBField.initUInt64(0L);
  public final PBUInt32Field video_type = PBField.initUInt32(0);
  public final PBUInt64Field weight = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.VideoInfo
 * JD-Core Version:    0.7.0.1
 */