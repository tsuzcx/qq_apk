package localpb.uniteGrayTip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UniteGrayTip$HightlightParam
  extends MessageMicro<HightlightParam>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66, 74, 82 }, new String[] { "start", "end", "uin", "needUpdateNick", "actionType", "icon", "textColor", "mMsgActionData", "mMsg_A_ActionData", "iconAlt" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", "", "" }, HightlightParam.class);
  public final PBUInt32Field actionType = PBField.initUInt32(0);
  public final PBUInt32Field end = PBField.initUInt32(0);
  public final PBStringField icon = PBField.initString("");
  public final PBStringField iconAlt = PBField.initString("");
  public final PBStringField mMsgActionData = PBField.initString("");
  public final PBStringField mMsg_A_ActionData = PBField.initString("");
  public final PBUInt32Field needUpdateNick = PBField.initUInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
  public final PBUInt32Field textColor = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     localpb.uniteGrayTip.UniteGrayTip.HightlightParam
 * JD-Core Version:    0.7.0.1
 */