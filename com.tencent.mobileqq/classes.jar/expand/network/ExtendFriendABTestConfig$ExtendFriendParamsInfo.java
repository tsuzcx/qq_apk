package expand.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.Serializable;

public final class ExtendFriendABTestConfig$ExtendFriendParamsInfo
  extends MessageMicro<ExtendFriendParamsInfo>
  implements Serializable
{
  static final transient MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, ExtendFriendParamsInfo.class);
  public PBStringField key = PBField.initString("");
  public PBStringField value = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     expand.network.ExtendFriendABTestConfig.ExtendFriendParamsInfo
 * JD-Core Version:    0.7.0.1
 */