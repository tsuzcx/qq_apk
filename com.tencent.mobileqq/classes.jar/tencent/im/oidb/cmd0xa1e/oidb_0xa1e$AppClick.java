package tencent.im.oidb.cmd0xa1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa1e$AppClick
  extends MessageMicro<AppClick>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "appid", "click_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, AppClick.class);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBUInt32Field click_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa1e.oidb_0xa1e.AppClick
 * JD-Core Version:    0.7.0.1
 */