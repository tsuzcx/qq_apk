package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QqAdGetProtos$QQAdGetRsp$AdInfo$DisplayInfo$BasicInfo
  extends MessageMicro<BasicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "img", "img_s", "txt", "desc", "pic_width", "pic_height" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, BasicInfo.class);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField img = PBField.initString("");
  public final PBStringField img_s = PBField.initString("");
  public final PBUInt32Field pic_height = PBField.initUInt32(0);
  public final PBUInt32Field pic_width = PBField.initUInt32(0);
  public final PBStringField txt = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo
 * JD-Core Version:    0.7.0.1
 */