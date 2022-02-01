package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleCounter$RedPointInfo
  extends MessageMicro<RedPointInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public QQCircleCounter.AllPushPointInfo allPushInfo = new QQCircleCounter.AllPushPointInfo();
  public final PBStringField appid = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField extend = PBField.initString("");
  public QQCircleCounter.GroupPointInfo groupInfo = new QQCircleCounter.GroupPointInfo();
  public final PBInt64Field lastVisitTime = PBField.initInt64(0L);
  public QQCircleCounter.OutLayerPointInfo outLayerInfo = new QQCircleCounter.OutLayerPointInfo();
  public final PBUInt32Field pushTime = PBField.initUInt32(0);
  public QQCircleCounter.PymkRedPointInfo pymkRedInfo = new QQCircleCounter.PymkRedPointInfo();
  public QQCircleCounter.QQProfilePointInfo qqProfileInfo = new QQCircleCounter.QQProfilePointInfo();
  public QQCircleCounter.RedPointJumpInfo redJumpInfo = new QQCircleCounter.RedPointJumpInfo();
  public final PBUInt32Field redTotalNum = PBField.initUInt32(0);
  public final PBEnumField redType = PBField.initEnum(1);
  public final PBRepeatMessageField<QQCircleCounter.RedDisplayInfo> rptRedInfo = PBField.initRepeatMessage(QQCircleCounter.RedDisplayInfo.class);
  public QQCircleCounter.SmallRedPointInfoExt smallRedInfoExt = new QQCircleCounter.SmallRedPointInfoExt();
  public final PBEnumField tabType = PBField.initEnum(1);
  public final PBBytesField transInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField wording = PBField.initString("");
  
  static
  {
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(1);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 50, 56, 66, 72, 82, 90, 98, 170, 178, 186, 194, 202, 210 }, new String[] { "appid", "redType", "redTotalNum", "rptRedInfo", "pushTime", "extend", "lastVisitTime", "transInfo", "tabType", "redJumpInfo", "wording", "extInfo", "allPushInfo", "outLayerInfo", "qqProfileInfo", "groupInfo", "smallRedInfoExt", "pymkRedInfo" }, new Object[] { "", localInteger2, localInteger1, null, localInteger1, "", Long.valueOf(0L), localByteStringMicro, localInteger2, null, "", null, null, null, null, null, null, null }, RedPointInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleCounter.RedPointInfo
 * JD-Core Version:    0.7.0.1
 */