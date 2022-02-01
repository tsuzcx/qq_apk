package tencent.im.oidb.cmd0x9fa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_0x9fa$GetFeedbackHateGroupCmd
  extends MessageMicro<GetFeedbackHateGroupCmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "page_no", "page_size" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetFeedbackHateGroupCmd.class);
  public final PBInt32Field page_no = PBField.initInt32(0);
  public final PBInt32Field page_size = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9fa.oidb_0x9fa.GetFeedbackHateGroupCmd
 * JD-Core Version:    0.7.0.1
 */