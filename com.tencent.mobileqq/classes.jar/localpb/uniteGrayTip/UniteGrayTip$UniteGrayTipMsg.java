package localpb.uniteGrayTip;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UniteGrayTip$UniteGrayTipMsg
  extends MessageMicro<UniteGrayTipMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public UniteGrayTip.BusinessData business_data = new UniteGrayTip.BusinessData();
  public final PBBytesField business_related = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field graytip_id = PBField.initUInt32(0);
  public final PBStringField graytip_key = PBField.initString("");
  public final PBUInt32Field graytip_level = PBField.initUInt32(0);
  public final PBRepeatField<Integer> graytip_mutex_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatMessageField<UniteGrayTip.HightlightParam> hightlight_item = PBField.initRepeatMessage(UniteGrayTip.HightlightParam.class);
  public final PBUInt32Field isLocalTroopMsg = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64, 74 }, new String[] { "graytip_id", "graytip_level", "graytip_mutex_id", "graytip_key", "content", "business_related", "hightlight_item", "isLocalTroopMsg", "business_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", localByteStringMicro, null, Integer.valueOf(0), null }, UniteGrayTipMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     localpb.uniteGrayTip.UniteGrayTip.UniteGrayTipMsg
 * JD-Core Version:    0.7.0.1
 */