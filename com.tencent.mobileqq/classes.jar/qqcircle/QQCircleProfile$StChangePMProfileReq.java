package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class QQCircleProfile$StChangePMProfileReq
  extends MessageMicro<StChangePMProfileReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "profileData" }, new Object[] { null }, StChangePMProfileReq.class);
  public QQCircleProfile.StPMProfileData profileData = new QQCircleProfile.StPMProfileData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StChangePMProfileReq
 * JD-Core Version:    0.7.0.1
 */