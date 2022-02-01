package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudHead$FCHead
  extends MessageMicro<FCHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudHead.AuthInfo AuthInfo = new FeedCloudHead.AuthInfo();
  public final PBBytesField bizData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField deviceInfo = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudCommon.Entry> extInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  public final PBInt32Field fcAppid = PBField.initInt32(0);
  public final PBStringField qua = PBField.initString("");
  public final PBEnumField reqFrom = PBField.initEnum(1);
  public final PBInt64Field retCode = PBField.initInt64(0L);
  public final PBStringField retMsg = PBField.initString("");
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBStringField tracerID = PBField.initString("");
  public final PBStringField userIP = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 56, 66, 74, 82, 88, 96 }, new String[] { "userIP", "seq", "qua", "deviceInfo", "tracerID", "AuthInfo", "retCode", "retMsg", "bizData", "extInfo", "reqFrom", "fcAppid" }, new Object[] { "", localLong, "", "", "", null, localLong, "", localByteStringMicro, null, Integer.valueOf(1), Integer.valueOf(0) }, FCHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudHead.FCHead
 * JD-Core Version:    0.7.0.1
 */