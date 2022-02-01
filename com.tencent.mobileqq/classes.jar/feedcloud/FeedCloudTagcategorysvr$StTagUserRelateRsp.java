package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class FeedCloudTagcategorysvr$StTagUserRelateRsp
  extends MessageMicro<StTagUserRelateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "names" }, new Object[] { null }, StTagUserRelateRsp.class);
  public final PBRepeatMessageField<FeedCloudTagcategorysvr.StTagUserRelateName> names = PBField.initRepeatMessage(FeedCloudTagcategorysvr.StTagUserRelateName.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudTagcategorysvr.StTagUserRelateRsp
 * JD-Core Version:    0.7.0.1
 */