package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class FeedCloudWrite$FriendSysMsg
  extends MessageMicro<FriendSysMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_paster_info = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 402 }, new String[] { "bytes_paster_info" }, new Object[] { localByteStringMicro }, FriendSysMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.FriendSysMsg
 * JD-Core Version:    0.7.0.1
 */