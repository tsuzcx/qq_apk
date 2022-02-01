package cooperation.ilive.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQALive$GetOpenInfoRsp
  extends MessageMicro<GetOpenInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "sOpenId", "sAccessToken", "vecExtInfo" }, new Object[] { "", "", null }, GetOpenInfoRsp.class);
  public final PBStringField sAccessToken = PBField.initString("");
  public final PBStringField sOpenId = PBField.initString("");
  public final PBRepeatMessageField<QQALive.ExtInfo> vecExtInfo = PBField.initRepeatMessage(QQALive.ExtInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.pb.QQALive.GetOpenInfoRsp
 * JD-Core Version:    0.7.0.1
 */