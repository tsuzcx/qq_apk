package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetFollowListReq
  extends MessageMicro<StGetFollowListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attachInfo = PBField.initString("");
  public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBEnumField filterRelation = PBField.initEnum(0);
  public final PBUInt32Field followMethod = PBField.initUInt32(0);
  public final PBUInt32Field sortType = PBField.initUInt32(0);
  public final PBStringField userId = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48, 56, 64 }, new String[] { "extInfo", "userId", "attachInfo", "count", "busiReqData", "filterRelation", "sortType", "followMethod" }, new Object[] { null, "", "", localInteger, localByteStringMicro, localInteger, localInteger, localInteger }, StGetFollowListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetFollowListReq
 * JD-Core Version:    0.7.0.1
 */