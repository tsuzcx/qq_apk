package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;

public final class QQCircleDitto$StItemContainer
  extends MessageMicro<StItemContainer>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "title", "items", "urlInfo", "subTitle", "containerType", "styleType" }, new Object[] { "", null, null, "", Integer.valueOf(0), Integer.valueOf(0) }, StItemContainer.class);
  public final PBUInt32Field containerType = PBField.initUInt32(0);
  public final PBRepeatMessageField<QQCircleDitto.StItemInfo> items = PBField.initRepeatMessage(QQCircleDitto.StItemInfo.class);
  public final PBEnumField styleType = PBField.initEnum(0);
  public final PBStringField subTitle = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleDitto.StItemContainer
 * JD-Core Version:    0.7.0.1
 */