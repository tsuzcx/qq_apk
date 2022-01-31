package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudNotifyWrite$StNotifyUserDo
  extends MessageMicro<StNotifyUserDo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field type = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "busiRspData" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, StNotifyUserDo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudNotifyWrite.StNotifyUserDo
 * JD-Core Version:    0.7.0.1
 */