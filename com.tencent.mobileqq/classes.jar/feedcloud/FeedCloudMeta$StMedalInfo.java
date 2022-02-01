package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudMeta$StMedalInfo
  extends MessageMicro<StMedalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField backgroundUrl = PBField.initString("");
  public final PBStringField describe = PBField.initString("");
  public final PBStringField iconUrl = PBField.initString("");
  public final PBBoolField isHighLight = PBField.initBool(false);
  public final PBBoolField isNew = PBField.initBool(false);
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBStringField medalID = PBField.initString("");
  public final PBStringField medalName = PBField.initString("");
  public final PBInt32Field rank = PBField.initInt32(0);
  public final PBInt32Field reportValue = PBField.initInt32(0);
  public final PBInt32Field type = PBField.initInt32(0);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66, 74, 82, 88 }, new String[] { "type", "medalName", "medalID", "rank", "isHighLight", "isNew", "jumpUrl", "iconUrl", "backgroundUrl", "describe", "reportValue" }, new Object[] { localInteger, "", "", localInteger, localBoolean, localBoolean, "", "", "", "", localInteger }, StMedalInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StMedalInfo
 * JD-Core Version:    0.7.0.1
 */