package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;

public final class QQCircleFeedBase$StTabInfo
  extends MessageMicro<StTabInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attachInfo = PBField.initString("");
  public final PBStringField dtPgID = PBField.initString("");
  public final PBInt32Field pageId = PBField.initInt32(0);
  public final PBStringField serverCallee = PBField.initString("");
  public final PBInt32Field sourceType = PBField.initInt32(0);
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBStringField tabName = PBField.initString("");
  public final PBUInt32Field tabType = PBField.initUInt32(0);
  public final PBStringField tagId = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudCommon.Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 56, 64, 74, 82 }, new String[] { "tabName", "tabType", "tagId", "status", "attachInfo", "urlInfo", "sourceType", "pageId", "serverCallee", "dtPgID" }, new Object[] { "", localInteger, "", localInteger, "", null, localInteger, localInteger, "", "" }, StTabInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StTabInfo
 * JD-Core Version:    0.7.0.1
 */