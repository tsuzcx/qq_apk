package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class FeedCloudTagbasesvr$StPublishTagBaseInfoReq
  extends MessageMicro<StPublishTagBaseInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "publishType" }, new Object[] { Integer.valueOf(0) }, StPublishTagBaseInfoReq.class);
  public final PBEnumField publishType = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagbasesvr.StPublishTagBaseInfoReq
 * JD-Core Version:    0.7.0.1
 */