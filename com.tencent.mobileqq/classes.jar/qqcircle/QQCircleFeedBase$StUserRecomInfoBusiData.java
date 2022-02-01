package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StUserRecomInfoBusiData
  extends MessageMicro<StUserRecomInfoBusiData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "pattonType", "recomSource", "bannerData" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, StUserRecomInfoBusiData.class);
  public QQCircleFeedBase.StUinBannerData bannerData = new QQCircleFeedBase.StUinBannerData();
  public final PBUInt32Field pattonType = PBField.initUInt32(0);
  public final PBUInt32Field recomSource = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StUserRecomInfoBusiData
 * JD-Core Version:    0.7.0.1
 */