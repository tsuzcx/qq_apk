package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class FeedCloudToastshowsvr$StGetToastDetailRsp
  extends MessageMicro<StGetToastDetailRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "toastInfo" }, new Object[] { null, null }, StGetToastDetailRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public FeedCloudToastshowsvr.StToast toastInfo = new FeedCloudToastshowsvr.StToast();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudToastshowsvr.StGetToastDetailRsp
 * JD-Core Version:    0.7.0.1
 */