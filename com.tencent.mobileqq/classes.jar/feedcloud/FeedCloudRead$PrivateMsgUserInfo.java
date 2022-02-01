package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudRead$PrivateMsgUserInfo
  extends MessageMicro<PrivateMsgUserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uin", "nick", "logo" }, new Object[] { Long.valueOf(0L), "", "" }, PrivateMsgUserInfo.class);
  public final PBStringField logo = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.PrivateMsgUserInfo
 * JD-Core Version:    0.7.0.1
 */