package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudRead$StGetPrivateMsgInfoRsp
  extends MessageMicro<StGetPrivateMsgInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "userInfo" }, new Object[] { null }, StGetPrivateMsgInfoRsp.class);
  public final PBRepeatMessageField<FeedCloudRead.PrivateMsgUserInfo> userInfo = PBField.initRepeatMessage(FeedCloudRead.PrivateMsgUserInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetPrivateMsgInfoRsp
 * JD-Core Version:    0.7.0.1
 */