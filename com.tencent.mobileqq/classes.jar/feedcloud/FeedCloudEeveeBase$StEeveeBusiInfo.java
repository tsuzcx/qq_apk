package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudEeveeBase$StEeveeBusiInfo
  extends MessageMicro<StEeveeBusiInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField appid = PBField.initEnum(0);
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField msgMainType = PBField.initEnum(101);
  public final PBEnumField msgSubType = PBField.initEnum(1010001);
  public final PBStringField pushStr = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "appid", "msgMainType", "msgSubType", "busiData", "pushStr" }, new Object[] { Integer.valueOf(0), Integer.valueOf(101), Integer.valueOf(1010001), localByteStringMicro, "" }, StEeveeBusiInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudEeveeBase.StEeveeBusiInfo
 * JD-Core Version:    0.7.0.1
 */