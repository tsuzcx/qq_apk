package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleFeedBase$StKuoliePasterData
  extends MessageMicro<StKuoliePasterData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField center_x = PBField.initFloat(0.0F);
  public final PBFloatField center_y = PBField.initFloat(0.0F);
  public final PBInt32Field click_type = PBField.initInt32(0);
  public final PBStringField content = PBField.initString("");
  public final PBFloatField height = PBField.initFloat(0.0F);
  public final PBStringField highlight_words = PBField.initString("");
  public final PBStringField kuolie_id = PBField.initString("");
  public final PBFloatField rotation = PBField.initFloat(0.0F);
  public final PBStringField scheme = PBField.initString("");
  public final PBBytesField trans_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFloatField width = PBField.initFloat(0.0F);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 29, 37, 45, 53, 58, 66, 72, 82, 90 }, new String[] { "kuolie_id", "center_x", "center_y", "width", "height", "rotation", "scheme", "content", "click_type", "trans_info", "highlight_words" }, new Object[] { "", localFloat, localFloat, localFloat, localFloat, localFloat, "", "", Integer.valueOf(0), localByteStringMicro, "" }, StKuoliePasterData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StKuoliePasterData
 * JD-Core Version:    0.7.0.1
 */