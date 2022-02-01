package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;

public final class QQCircleFeedBase$StTabInfo
  extends MessageMicro<StTabInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50 }, new String[] { "tabName", "tabType", "tagId", "status", "attachInfo", "urlInfo" }, new Object[] { "", Integer.valueOf(0), "", Integer.valueOf(0), "", null }, StTabInfo.class);
  public final PBStringField attachInfo = PBField.initString("");
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBStringField tabName = PBField.initString("");
  public final PBUInt32Field tabType = PBField.initUInt32(0);
  public final PBStringField tagId = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StTabInfo
 * JD-Core Version:    0.7.0.1
 */