package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetFollowTagListRsp
  extends MessageMicro<StGetFollowTagListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attachInfo = PBField.initString("");
  public final PBBytesField busiRspData = PBField.initBytes(ByteStringMicro.EMPTY);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field hasNext = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> tagInfos = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "extInfo", "attachInfo", "hasNext", "tagInfos", "busiRspData" }, new Object[] { null, "", Integer.valueOf(0), null, localByteStringMicro }, StGetFollowTagListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetFollowTagListRsp
 * JD-Core Version:    0.7.0.1
 */