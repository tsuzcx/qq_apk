package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudMeta$StUser
  extends MessageMicro<StUser>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field birthday = PBField.initUInt64(0L);
  public final PBUInt32Field blackState = PBField.initUInt32(0);
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField desc = PBField.initString("");
  public final PBUInt32Field followState = PBField.initUInt32(0);
  public final PBUInt32Field frdState = PBField.initUInt32(0);
  public FeedCloudMeta.StIconInfo icon = new FeedCloudMeta.StIconInfo();
  public final PBStringField id = PBField.initString("");
  public final PBStringField location = PBField.initString("");
  public FeedCloudMeta.StTagMedalInfo medal = new FeedCloudMeta.StTagMedalInfo();
  public final PBStringField nick = PBField.initString("");
  public final PBUInt32Field relationState = PBField.initUInt32(0);
  public final PBStringField school = PBField.initString("");
  public final PBUInt32Field sex = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64, 74, 90, 98, 104, 112, 120, 130 }, new String[] { "id", "nick", "icon", "desc", "followState", "type", "sex", "birthday", "school", "location", "busiData", "frdState", "relationState", "blackState", "medal" }, new Object[] { "", "", null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, StUser.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StUser
 * JD-Core Version:    0.7.0.1
 */