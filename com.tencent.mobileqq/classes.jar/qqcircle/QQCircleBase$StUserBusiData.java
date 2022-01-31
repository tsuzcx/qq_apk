package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQCircleBase$StUserBusiData
  extends MessageMicro<StUserBusiData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 50, 58, 64 }, new String[] { "fansNum", "followNum", "feedNum", "schoolInfos", "companyInfos", "certification" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, Integer.valueOf(0) }, StUserBusiData.class);
  public final PBInt32Field certification = PBField.initInt32(0);
  public final PBRepeatMessageField<QQCircleBase.UserCircleInfo> companyInfos = PBField.initRepeatMessage(QQCircleBase.UserCircleInfo.class);
  public final PBInt64Field fansNum = PBField.initInt64(0L);
  public final PBInt32Field feedNum = PBField.initInt32(0);
  public final PBInt64Field followNum = PBField.initInt64(0L);
  public final PBRepeatMessageField<QQCircleBase.UserCircleInfo> schoolInfos = PBField.initRepeatMessage(QQCircleBase.UserCircleInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleBase.StUserBusiData
 * JD-Core Version:    0.7.0.1
 */