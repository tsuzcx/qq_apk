package cooperation.ilive.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQALive$ExtInfo
  extends MessageMicro<ExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "sKey", "sValue" }, new Object[] { "", "" }, ExtInfo.class);
  public final PBStringField sKey = PBField.initString("");
  public final PBStringField sValue = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.pb.QQALive.ExtInfo
 * JD-Core Version:    0.7.0.1
 */