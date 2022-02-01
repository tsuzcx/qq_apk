package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StTagInfo;

public final class QQCircleProfile$SetProfileReq
  extends MessageMicro<SetProfileReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBRepeatField<Long> groupIDList = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Integer> infoTypes = PBField.initRepeat(PBEnumField.__repeatHelper__);
  public final PBUInt32Field pattonType = PBField.initUInt32(0);
  public final PBRepeatMessageField<FeedCloudMeta.StTagInfo> showTagList = PBField.initRepeatMessage(FeedCloudMeta.StTagInfo.class);
  public final PBStringField sign = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "extInfo", "infoTypes", "sign", "showTagList", "pattonType", "groupIDList" }, new Object[] { null, localInteger, "", null, localInteger, Long.valueOf(0L) }, SetProfileReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleProfile.SetProfileReq
 * JD-Core Version:    0.7.0.1
 */