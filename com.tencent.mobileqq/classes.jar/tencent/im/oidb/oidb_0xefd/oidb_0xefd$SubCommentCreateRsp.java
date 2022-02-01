package tencent.im.oidb.oidb_0xefd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xefd$SubCommentCreateRsp
  extends MessageMicro<SubCommentCreateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 794 }, new String[] { "sub_comment_id", "link_comment_over_times", "link_comment_num", "dirty_word_show_toast", "str_comment" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, SubCommentCreateRsp.class);
  public final PBUInt32Field dirty_word_show_toast = PBField.initUInt32(0);
  public final PBUInt32Field link_comment_num = PBField.initUInt32(0);
  public final PBUInt32Field link_comment_over_times = PBField.initUInt32(0);
  public final PBStringField str_comment = PBField.initString("");
  public final PBInt32Field sub_comment_id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xefd.oidb_0xefd.SubCommentCreateRsp
 * JD-Core Version:    0.7.0.1
 */