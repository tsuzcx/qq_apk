package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleFeedBase$StSingleRecomReportInfo
  extends MessageMicro<StSingleRecomReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField reportData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField reportID = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "reportID", "reportData" }, new Object[] { "", localByteStringMicro }, StSingleRecomReportInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StSingleRecomReportInfo
 * JD-Core Version:    0.7.0.1
 */