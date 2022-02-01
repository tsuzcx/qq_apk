package tencent.im.oidb.cmd0xea0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xea0$HorizontalAvatarsReport
  extends MessageMicro<HorizontalAvatarsReport>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "head_feeds_type", "show_limit_account" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, HorizontalAvatarsReport.class);
  public final PBUInt32Field head_feeds_type = PBField.initUInt32(0);
  public final PBUInt32Field show_limit_account = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xea0.oidb_cmd0xea0.HorizontalAvatarsReport
 * JD-Core Version:    0.7.0.1
 */