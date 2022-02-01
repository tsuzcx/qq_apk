package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudMeta$StProxyInfo
  extends MessageMicro<StProxyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField appProtocol = PBField.initString("");
  public final PBInt32Field cmdId = PBField.initInt32(0);
  public final PBBytesField reqBody = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field subCmdId = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "cmdId", "subCmdId", "appProtocol", "reqBody" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro }, StProxyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StProxyInfo
 * JD-Core Version:    0.7.0.1
 */