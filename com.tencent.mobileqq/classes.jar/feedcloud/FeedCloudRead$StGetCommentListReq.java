package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetCommentListReq
  extends MessageMicro<StGetCommentListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<FeedCloudCommon.BytesEntry> busiTranparent = PBField.initRepeatMessage(FeedCloudCommon.BytesEntry.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField feedAttchInfo = PBField.initString("");
  public final PBStringField feedId = PBField.initString("");
  public final PBInt32Field from = PBField.initInt32(0);
  public final PBStringField likeKey = PBField.initString("");
  public final PBUInt32Field listNum = PBField.initUInt32(0);
  public final PBStringField userId = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58, 66, 74 }, new String[] { "extInfo", "userId", "feedId", "listNum", "from", "feedAttchInfo", "busiReqData", "likeKey", "busiTranparent" }, new Object[] { null, "", "", Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro, "", null }, StGetCommentListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetCommentListReq
 * JD-Core Version:    0.7.0.1
 */