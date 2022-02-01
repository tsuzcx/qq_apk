package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudMeta$StRelationInfo
  extends MessageMicro<StRelationInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField id = PBField.initString("");
  public final PBUInt64Field imBitMap = PBField.initUInt64(0L);
  public final PBBoolField isBlock = PBField.initBool(false);
  public final PBBoolField isBlocked = PBField.initBool(false);
  public final PBBoolField isFriend = PBField.initBool(false);
  public final PBBoolField isUncare = PBField.initBool(false);
  public final PBUInt32Field relation = PBField.initUInt32(0);
  public final PBUInt32Field relationState = PBField.initUInt32(0);
  public final PBUInt32Field score = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Boolean localBoolean = Boolean.valueOf(false);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "id", "relation", "busiData", "relationState", "score", "isBlock", "isBlocked", "isFriend", "isUncare", "imBitMap" }, new Object[] { "", localInteger, localByteStringMicro, localInteger, localInteger, localBoolean, localBoolean, localBoolean, localBoolean, Long.valueOf(0L) }, StRelationInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudMeta.StRelationInfo
 * JD-Core Version:    0.7.0.1
 */