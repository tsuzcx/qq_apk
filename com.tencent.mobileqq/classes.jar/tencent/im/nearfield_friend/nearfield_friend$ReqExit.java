package tencent.im.nearfield_friend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class nearfield_friend$ReqExit
  extends MessageMicro<ReqExit>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "session_id" }, new Object[] { "" }, ReqExit.class);
  public final PBStringField session_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.nearfield_friend.nearfield_friend.ReqExit
 * JD-Core Version:    0.7.0.1
 */