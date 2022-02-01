package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleFeedBase$StSimpleFeed
  extends MessageMicro<StSimpleFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiReportInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field ctime = PBField.initUInt64(0L);
  public final PBStringField feedID = PBField.initString("");
  public final PBStringField userID = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "userID", "feedID", "ctime", "busiReportInfo" }, new Object[] { "", "", Long.valueOf(0L), localByteStringMicro }, StSimpleFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StSimpleFeed
 * JD-Core Version:    0.7.0.1
 */