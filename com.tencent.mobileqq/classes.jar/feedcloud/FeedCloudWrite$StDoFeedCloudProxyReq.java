package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudWrite$StDoFeedCloudProxyReq
  extends MessageMicro<StDoFeedCloudProxyReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "proxyType", "proxyInfo" }, new Object[] { null, Integer.valueOf(0), null }, StDoFeedCloudProxyReq.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StProxyInfo proxyInfo = new FeedCloudMeta.StProxyInfo();
  public final PBInt32Field proxyType = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StDoFeedCloudProxyReq
 * JD-Core Version:    0.7.0.1
 */