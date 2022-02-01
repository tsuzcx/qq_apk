package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudEeveeUndealmsg$SignalMsg
  extends MessageMicro<SignalMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField msgid = PBField.initString("");
  public final PBBytesField signalBuff = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "signalBuff", "msgid" }, new Object[] { localByteStringMicro, "" }, SignalMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeUndealmsg.SignalMsg
 * JD-Core Version:    0.7.0.1
 */