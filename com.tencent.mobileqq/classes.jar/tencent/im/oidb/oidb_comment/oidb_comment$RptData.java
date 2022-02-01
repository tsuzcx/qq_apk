package tencent.im.oidb.oidb_comment;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class oidb_comment$RptData
  extends MessageMicro<RptData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "data_type", "at_data", "herf_data", "text_data" }, new Object[] { Integer.valueOf(0), null, null, null }, RptData.class);
  public oidb_comment.AtData at_data = new oidb_comment.AtData();
  public final PBInt32Field data_type = PBField.initInt32(0);
  public oidb_comment.HerfData herf_data = new oidb_comment.HerfData();
  public oidb_comment.TextData text_data = new oidb_comment.TextData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_comment.oidb_comment.RptData
 * JD-Core Version:    0.7.0.1
 */