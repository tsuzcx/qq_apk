package feedcloud;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FeedCloudRead$StGetCircleUnCareListRsp
  extends MessageMicro<StGetCircleUnCareListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "extInfo", "uinlist", "userlist" }, new Object[] { null, Integer.valueOf(0), null }, StGetCircleUnCareListRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatField<Integer> uinlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatMessageField<FeedCloudMeta.StUser> userlist = PBField.initRepeatMessage(FeedCloudMeta.StUser.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     feedcloud.FeedCloudRead.StGetCircleUnCareListRsp
 * JD-Core Version:    0.7.0.1
 */