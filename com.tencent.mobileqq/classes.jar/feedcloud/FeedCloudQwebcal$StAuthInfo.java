package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudQwebcal$StAuthInfo
  extends MessageMicro<StAuthInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<FeedCloudCommon.Entry> Extinfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField openid = PBField.initString("");
  public final PBStringField platform = PBField.initString("");
  public final PBBytesField sessionkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBStringField uin = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 66 }, new String[] { "uin", "sig", "platform", "type", "appid", "openid", "sessionkey", "Extinfo" }, new Object[] { "", localByteStringMicro1, "", Integer.valueOf(0), "", "", localByteStringMicro2, null }, StAuthInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudQwebcal.StAuthInfo
 * JD-Core Version:    0.7.0.1
 */