package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class FeedCloudRead$StGetCircleUnCareListReq
  extends MessageMicro<StGetCircleUnCareListReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBInt32Field flag = PBField.initInt32(0);
  public final PBInt32Field rightType = PBField.initInt32(0);
  public final PBInt32Field type = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "extInfo", "rightType", "type", "flag" }, new Object[] { null, localInteger, localInteger, localInteger }, StGetCircleUnCareListReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetCircleUnCareListReq
 * JD-Core Version:    0.7.0.1
 */