package tencent.im.oidb.oidb_0xd1e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd1e$FirstCommentCreateRsp
  extends MessageMicro<FirstCommentCreateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "comment_id", "link_comment_over_times" }, new Object[] { "", Integer.valueOf(0) }, FirstCommentCreateRsp.class);
  public final PBStringField comment_id = PBField.initString("");
  public final PBUInt32Field link_comment_over_times = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd1e.oidb_0xd1e.FirstCommentCreateRsp
 * JD-Core Version:    0.7.0.1
 */