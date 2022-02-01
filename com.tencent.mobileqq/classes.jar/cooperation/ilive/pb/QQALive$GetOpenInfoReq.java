package cooperation.ilive.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class QQALive$GetOpenInfoReq
  extends MessageMicro<GetOpenInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "vecExtInfo" }, new Object[] { null }, GetOpenInfoReq.class);
  public final PBRepeatMessageField<QQALive.ExtInfo> vecExtInfo = PBField.initRepeatMessage(QQALive.ExtInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.pb.QQALive.GetOpenInfoReq
 * JD-Core Version:    0.7.0.1
 */