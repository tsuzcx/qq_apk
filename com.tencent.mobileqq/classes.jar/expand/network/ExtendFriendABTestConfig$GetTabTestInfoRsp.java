package expand.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ExtendFriendABTestConfig$GetTabTestInfoRsp
  extends MessageMicro<GetTabTestInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "grayPolicyInfoList" }, new Object[] { null }, GetTabTestInfoRsp.class);
  public final PBRepeatMessageField<ExtendFriendABTestConfig.GrayPolicyInfo> grayPolicyInfoList = PBField.initRepeatMessage(ExtendFriendABTestConfig.GrayPolicyInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     expand.network.ExtendFriendABTestConfig.GetTabTestInfoRsp
 * JD-Core Version:    0.7.0.1
 */