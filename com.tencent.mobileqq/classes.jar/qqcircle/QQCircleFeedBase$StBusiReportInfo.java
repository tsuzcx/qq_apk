package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class QQCircleFeedBase$StBusiReportInfo
  extends MessageMicro<StBusiReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public QQCircleFeedBase.StRecomReportInfo recom_report = new QQCircleFeedBase.StRecomReportInfo();
  public final PBBytesField tianji_report = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tianji_report", "recom_report" }, new Object[] { localByteStringMicro, null }, StBusiReportInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StBusiReportInfo
 * JD-Core Version:    0.7.0.1
 */