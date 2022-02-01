package expand.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.Serializable;

public final class ExtendFriendABTestConfig$GrayPolicyInfo
  extends MessageMicro<GrayPolicyInfo>
  implements Serializable
{
  static final transient MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "grayPolicyId", "paramsInfoList", "sGroupKey", "sStrategyType", "expKey" }, new Object[] { "", null, "", "", "" }, GrayPolicyInfo.class);
  public PBStringField expKey = PBField.initString("");
  public PBStringField grayPolicyId = PBField.initString("");
  public PBRepeatMessageField<ExtendFriendABTestConfig.paramsInfo> paramsInfoList = PBField.initRepeatMessage(ExtendFriendABTestConfig.paramsInfo.class);
  public PBStringField sGroupKey = PBField.initString("");
  public PBStringField sStrategyType = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     expand.network.ExtendFriendABTestConfig.GrayPolicyInfo
 * JD-Core Version:    0.7.0.1
 */