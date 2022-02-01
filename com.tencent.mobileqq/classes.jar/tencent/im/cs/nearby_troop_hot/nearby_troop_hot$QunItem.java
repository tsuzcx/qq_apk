package tencent.im.cs.nearby_troop_hot;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class nearby_troop_hot$QunItem
  extends MessageMicro<QunItem>
{
  public static final int DESC_FIELD_NUMBER = 3;
  public static final int GPS_FIELD_NUMBER = 4;
  public static final int TITLE_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uin", "title", "desc", "gps" }, new Object[] { Long.valueOf(0L), "", "", null }, QunItem.class);
  public final PBStringField desc = PBField.initString("");
  public nearby_troop_hot.GPS gps = new nearby_troop_hot.GPS();
  public final PBStringField title = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.nearby_troop_hot.nearby_troop_hot.QunItem
 * JD-Core Version:    0.7.0.1
 */