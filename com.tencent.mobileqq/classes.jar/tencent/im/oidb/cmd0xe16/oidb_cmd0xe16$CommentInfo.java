package tencent.im.oidb.cmd0xe16;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xe16$CommentInfo
  extends MessageMicro<CommentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "str_comment", "rpt_media_data_list", "str_comment_id", "str_sub_comment_id", "uint64_sub_author" }, new Object[] { "", null, "", "", Long.valueOf(0L) }, CommentInfo.class);
  public final PBRepeatMessageField<oidb_cmd0xe16.MediaData> rpt_media_data_list = PBField.initRepeatMessage(oidb_cmd0xe16.MediaData.class);
  public final PBStringField str_comment = PBField.initString("");
  public final PBStringField str_comment_id = PBField.initString("");
  public final PBStringField str_sub_comment_id = PBField.initString("");
  public final PBUInt64Field uint64_sub_author = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.CommentInfo
 * JD-Core Version:    0.7.0.1
 */