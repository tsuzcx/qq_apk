package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearby_troop_hot$QunInfo
  extends MessageMicro<QunInfo>
{
  public static final int CNT_FIELD_NUMBER = 3;
  public static final int DESC_FIELD_NUMBER = 2;
  public static final int TITLE_FIELD_NUMBER = 1;
  public static final int URL_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "title", "desc", "cnt", "url" }, new Object[] { "", "", Integer.valueOf(0), "" }, QunInfo.class);
  public final PBUInt32Field cnt = PBField.initUInt32(0);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_hot.nearby_troop_hot.QunInfo
 * JD-Core Version:    0.7.0.1
 */