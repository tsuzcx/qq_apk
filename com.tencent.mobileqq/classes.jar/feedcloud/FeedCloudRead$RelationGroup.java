package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$RelationGroup
  extends MessageMicro<RelationGroup>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attachInfo = PBField.initString("");
  public final PBStringField gid = PBField.initString("");
  public final PBInt32Field groupFlag = PBField.initInt32(0);
  public final PBUInt32Field hasNext = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBRepeatMessageField<FeedCloudMeta.StRelationInfo> relationInfo = PBField.initRepeatMessage(FeedCloudMeta.StRelationInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "gid", "name", "relationInfo", "attachInfo", "hasNext", "groupFlag" }, new Object[] { "", "", null, "", localInteger, localInteger }, RelationGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.RelationGroup
 * JD-Core Version:    0.7.0.1
 */