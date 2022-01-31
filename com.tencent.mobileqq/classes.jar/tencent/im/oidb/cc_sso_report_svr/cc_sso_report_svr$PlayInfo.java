package tencent.im.oidb.cc_sso_report_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cc_sso_report_svr$PlayInfo
  extends MessageMicro<PlayInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "genurl_duration", "genurl_errcode", "prepare_duration", "play_duration", "play_errcode", "skipframe_cnt" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0) }, PlayInfo.class);
  public final PBUInt64Field genurl_duration = PBField.initUInt64(0L);
  public final PBUInt32Field genurl_errcode = PBField.initUInt32(0);
  public final PBUInt64Field play_duration = PBField.initUInt64(0L);
  public final PBStringField play_errcode = PBField.initString("");
  public final PBUInt64Field prepare_duration = PBField.initUInt64(0L);
  public final PBUInt32Field skipframe_cnt = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.PlayInfo
 * JD-Core Version:    0.7.0.1
 */