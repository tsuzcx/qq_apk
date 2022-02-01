package localpb.uniteGrayTip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UniteGrayTip$BusinessData
  extends MessageMicro<BusinessData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66, 74, 82 }, new String[] { "haveRead", "subType", "masterUin", "extUin", "taskId", "editState", "editTime", "editMsgData", "caidanAnimUrl", "caidanAnimUrlMd5" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Long.valueOf(0L), "", "", "" }, BusinessData.class);
  public final PBStringField caidanAnimUrl = PBField.initString("");
  public final PBStringField caidanAnimUrlMd5 = PBField.initString("");
  public final PBStringField editMsgData = PBField.initString("");
  public final PBUInt32Field editState = PBField.initUInt32(0);
  public final PBUInt64Field editTime = PBField.initUInt64(0L);
  public final PBStringField extUin = PBField.initString("");
  public final PBUInt32Field haveRead = PBField.initUInt32(0);
  public final PBStringField masterUin = PBField.initString("");
  public final PBUInt32Field subType = PBField.initUInt32(0);
  public final PBStringField taskId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     localpb.uniteGrayTip.UniteGrayTip.BusinessData
 * JD-Core Version:    0.7.0.1
 */