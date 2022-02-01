package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class FeedCloudTagbasesvr$StPublishTagBaseInfoRsp
  extends MessageMicro<StPublishTagBaseInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudTagbasesvr.StEditTagInfo notOkInfo = new FeedCloudTagbasesvr.StEditTagInfo();
  public final PBEnumField publishResult = PBField.initEnum(0);
  public final PBEnumField publishStatus = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "publishResult", "notOkInfo", "publishStatus" }, new Object[] { localInteger, null, localInteger }, StPublishTagBaseInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StPublishTagBaseInfoRsp
 * JD-Core Version:    0.7.0.1
 */