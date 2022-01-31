package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudRead$StGetFeedDetailReq
  extends MessageMicro<StGetFeedDetailReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField adAttchInfo = PBField.initString("");
  public final PBBytesField adres = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bizReqData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField feedId = PBField.initString("");
  public final PBInt32Field from = PBField.initInt32(0);
  public final PBBoolField useUGCStore = PBField.initBool(false);
  public final PBStringField userId = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 58, 66, 72 }, new String[] { "extInfo", "from", "userId", "feedId", "createTime", "adres", "adAttchInfo", "bizReqData", "useUGCStore" }, new Object[] { null, Integer.valueOf(0), "", "", Long.valueOf(0L), localByteStringMicro1, "", localByteStringMicro2, Boolean.valueOf(false) }, StGetFeedDetailReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetFeedDetailReq
 * JD-Core Version:    0.7.0.1
 */