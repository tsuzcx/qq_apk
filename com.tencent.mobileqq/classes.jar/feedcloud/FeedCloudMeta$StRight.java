package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import ufo.UgcRight.RightInfo;

public final class FeedCloudMeta$StRight
  extends MessageMicro<StRight>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "ugcRight", "rightDisplayText", "iconUrl", "jumpUrl" }, new Object[] { null, "", "", "" }, StRight.class);
  public final PBStringField iconUrl = PBField.initString("");
  public final PBStringField jumpUrl = PBField.initString("");
  public final PBStringField rightDisplayText = PBField.initString("");
  public UgcRight.RightInfo ugcRight = new UgcRight.RightInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StRight
 * JD-Core Version:    0.7.0.1
 */