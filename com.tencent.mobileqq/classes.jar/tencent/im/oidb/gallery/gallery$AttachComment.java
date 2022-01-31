package tencent.im.oidb.gallery;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.Comment;

public final class gallery$AttachComment
  extends MessageMicro<AttachComment>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "comment_info", "comment_icons" }, new Object[] { null, null }, AttachComment.class);
  public final PBRepeatMessageField<gallery.CommentIcon> comment_icons = PBField.initRepeatMessage(gallery.CommentIcon.class);
  public oidb_cmd0xc46.Comment comment_info = new oidb_cmd0xc46.Comment();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.gallery.gallery.AttachComment
 * JD-Core Version:    0.7.0.1
 */