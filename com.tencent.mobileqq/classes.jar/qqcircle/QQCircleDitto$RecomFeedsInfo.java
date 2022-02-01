package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleDitto$RecomFeedsInfo
  extends MessageMicro<RecomFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiReport = PBField.initBytes(ByteStringMicro.EMPTY);
  public QQCircleDitto.StCircleDittoDataNew dittoData = new QQCircleDitto.StCircleDittoDataNew();
  public final PBUInt32Field dittoID = PBField.initUInt32(0);
  public final PBInt32Field index = PBField.initInt32(0);
  public final PBUInt32Field pattonID = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "dittoID", "pattonID", "dittoData", "index", "busiReport" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro }, RecomFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleDitto.RecomFeedsInfo
 * JD-Core Version:    0.7.0.1
 */