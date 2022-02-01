package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class QQCircleEnvHub$UserLayerInfo
  extends MessageMicro<UserLayerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "isHaveLostUser" }, new Object[] { Boolean.valueOf(false) }, UserLayerInfo.class);
  public final PBBoolField isHaveLostUser = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleEnvHub.UserLayerInfo
 * JD-Core Version:    0.7.0.1
 */