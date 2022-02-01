package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StPageRedPointInfo
  extends MessageMicro<StPageRedPointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField appid = PBField.initString("");
  public final PBStringField extend = PBField.initString("");
  public final PBInt64Field lastVisitTime = PBField.initInt64(0L);
  public final PBUInt32Field pushTime = PBField.initUInt32(0);
  public QQCircleFeedBase.StQQProfilePointInfo qqProfileInfo = new QQCircleFeedBase.StQQProfilePointInfo();
  public final PBUInt32Field redTotalNum = PBField.initUInt32(0);
  public final PBUInt32Field redType = PBField.initUInt32(0);
  public final PBBytesField transInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 58, 186 }, new String[] { "appid", "redType", "redTotalNum", "pushTime", "extend", "lastVisitTime", "transInfo", "qqProfileInfo" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), localByteStringMicro, null }, StPageRedPointInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StPageRedPointInfo
 * JD-Core Version:    0.7.0.1
 */