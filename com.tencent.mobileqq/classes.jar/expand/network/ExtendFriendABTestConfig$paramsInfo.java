package expand.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.Serializable;

public final class ExtendFriendABTestConfig$paramsInfo
  extends MessageMicro<paramsInfo>
  implements Serializable
{
  static final transient MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "value" }, new Object[] { "", "" }, paramsInfo.class);
  public PBStringField key = PBField.initString("");
  public PBStringField value = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     expand.network.ExtendFriendABTestConfig.paramsInfo
 * JD-Core Version:    0.7.0.1
 */