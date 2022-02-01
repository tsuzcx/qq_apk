package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetSessionInfoRsp
  extends MessageMicro<StGetSessionInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field expireTime = PBField.initUInt32(0);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBUInt32Field sessionType = PBField.initUInt32(0);
  public final PBBytesField sessonID = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField subSessonID = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField transInfo = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "extInfo", "sessonID", "subSessonID", "transInfo", "expireTime", "sessionType" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger, localInteger }, StGetSessionInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetSessionInfoRsp
 * JD-Core Version:    0.7.0.1
 */