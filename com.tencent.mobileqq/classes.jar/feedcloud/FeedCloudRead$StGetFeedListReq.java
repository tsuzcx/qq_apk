package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetFeedListReq
  extends MessageMicro<StGetFeedListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField adAttchInfo = PBField.initString("");
  public final PBBytesField adres = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField busiReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField dstUserId = PBField.initString("");
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StFeed feed = new FeedCloudMeta.StFeed();
  public final PBStringField feedAttchInfo = PBField.initString("");
  public final PBInt32Field from = PBField.initInt32(0);
  public final PBBoolField isMiddlePage = PBField.initBool(false);
  public final PBUInt32Field listNum = PBField.initUInt32(0);
  public final PBInt32Field source = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 80, 90, 98, 104 }, new String[] { "extInfo", "listNum", "from", "feed", "adres", "adAttchInfo", "feedAttchInfo", "source", "busiReqData", "dstUserId", "isMiddlePage" }, new Object[] { null, localInteger, localInteger, null, localByteStringMicro1, "", "", localInteger, localByteStringMicro2, "", Boolean.valueOf(false) }, StGetFeedListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetFeedListReq
 * JD-Core Version:    0.7.0.1
 */