package tencent.im.oidb.cmd0x83e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x83e$CommentExtInfo
  extends MessageMicro<CommentExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_comment_gif" }, new Object[] { null }, CommentExtInfo.class);
  public final PBRepeatMessageField<oidb_cmd0x83e.OneCommentGif> rpt_comment_gif = PBField.initRepeatMessage(oidb_cmd0x83e.OneCommentGif.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.CommentExtInfo
 * JD-Core Version:    0.7.0.1
 */