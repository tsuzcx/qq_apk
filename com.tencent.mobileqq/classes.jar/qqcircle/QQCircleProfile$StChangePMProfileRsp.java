package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleProfile$StChangePMProfileRsp
  extends MessageMicro<StChangePMProfileRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "errCode", "errMsg", "profileData" }, new Object[] { Integer.valueOf(0), "", null }, StChangePMProfileRsp.class);
  public final PBInt32Field errCode = PBField.initInt32(0);
  public final PBStringField errMsg = PBField.initString("");
  public QQCircleProfile.StPMProfileData profileData = new QQCircleProfile.StPMProfileData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StChangePMProfileRsp
 * JD-Core Version:    0.7.0.1
 */