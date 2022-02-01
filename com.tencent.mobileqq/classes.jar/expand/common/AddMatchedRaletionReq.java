package expand.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class AddMatchedRaletionReq
  extends MessageMicro<AddMatchedRaletionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "UserInfo", "MatchUserInfo" }, new Object[] { null, null }, AddMatchedRaletionReq.class);
  public MatchedInfo MatchUserInfo = new MatchedInfo();
  public MatchedInfo UserInfo = new MatchedInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     expand.common.AddMatchedRaletionReq
 * JD-Core Version:    0.7.0.1
 */