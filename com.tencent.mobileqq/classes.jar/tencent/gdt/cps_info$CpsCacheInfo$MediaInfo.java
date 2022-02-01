package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cps_info$CpsCacheInfo$MediaInfo
  extends MessageMicro<MediaInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "trace_id", "user_id" }, new Object[] { "", "" }, MediaInfo.class);
  public final PBStringField trace_id = PBField.initString("");
  public final PBStringField user_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.cps_info.CpsCacheInfo.MediaInfo
 * JD-Core Version:    0.7.0.1
 */