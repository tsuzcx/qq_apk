package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class FeedCloudCertification$GetUploadPresignedURLRsp
  extends MessageMicro<GetUploadPresignedURLRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "presignedURL", "objectName" }, new Object[] { null, "", "" }, GetUploadPresignedURLRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField objectName = PBField.initString("");
  public final PBStringField presignedURL = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     feedcloud.FeedCloudCertification.GetUploadPresignedURLRsp
 * JD-Core Version:    0.7.0.1
 */