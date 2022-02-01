package tencent.im.oidb.oidb_0xd1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd1e$FirstCommentCreateRsp
  extends MessageMicro<FirstCommentCreateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField actual_create_content = PBField.initString("");
  public final PBStringField comment_id = PBField.initString("");
  public final PBUInt32Field dirty_word_show_toast = PBField.initUInt32(0);
  public final PBUInt32Field link_comment_num = PBField.initUInt32(0);
  public final PBUInt32Field link_comment_over_times = PBField.initUInt32(0);
  public final PBRepeatMessageField<oidb_0xd1e.RptData> rpt_data = PBField.initRepeatMessage(oidb_0xd1e.RptData.class);
  public final PBStringField share_url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 114 }, new String[] { "comment_id", "link_comment_over_times", "link_comment_num", "dirty_word_show_toast", "actual_create_content", "share_url", "rpt_data" }, new Object[] { "", localInteger, localInteger, localInteger, "", "", null }, FirstCommentCreateRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp
 * JD-Core Version:    0.7.0.1
 */