package cooperation.qqcircle.report.outbox;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.requests.QCircleBaseRequest;
import feedcloud.FeedCloudCommon.BytesEntry;

public class QCircleReportOutboxRequest
  extends QCircleBaseRequest
{
  public static final String KEY_RESPONSE_DATA = "response_data";
  private byte[] mRequestByteData;
  private String mRequestCmdName;
  
  public QCircleReportOutboxRequest(String paramString, byte[] paramArrayOfByte)
  {
    this.mRequestCmdName = paramString;
    this.mRequestByteData = paramArrayOfByte;
    setRetryCount(2);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudCommon.BytesEntry localBytesEntry = new FeedCloudCommon.BytesEntry();
    localBytesEntry.key.set("response_data");
    localBytesEntry.value.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    return localBytesEntry;
  }
  
  public String getCmdName()
  {
    return this.mRequestCmdName;
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequestByteData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.outbox.QCircleReportOutboxRequest
 * JD-Core Version:    0.7.0.1
 */