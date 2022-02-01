package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;

public final class oidb_cmd0x68b$CommentInfoList
  extends MessageMicro<CommentInfoList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_comment_info_list" }, new Object[] { null }, CommentInfoList.class);
  public final PBRepeatMessageField<articlesummary.CommentInfo> rpt_comment_info_list = PBField.initRepeatMessage(articlesummary.CommentInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.CommentInfoList
 * JD-Core Version:    0.7.0.1
 */