package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FeedCloudWrite$StDoFeedCloudProxyRsp
  extends MessageMicro<StDoFeedCloudProxyRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "proxyInfo" }, new Object[] { null, null }, StDoFeedCloudProxyRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudMeta.StProxyInfo proxyInfo = new FeedCloudMeta.StProxyInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     feedcloud.FeedCloudWrite.StDoFeedCloudProxyRsp
 * JD-Core Version:    0.7.0.1
 */