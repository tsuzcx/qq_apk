package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class searchtab$Item3
  extends MessageMicro
{
  public static final int STR_DESC1_FIELD_NUMBER = 3;
  public static final int STR_DESC2_FIELD_NUMBER = 4;
  public static final int STR_IMG_URL_FIELD_NUMBER = 2;
  public static final int STR_NAME_FIELD_NUMBER = 1;
  public static final int STR_TRANSFER_URL_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "str_name", "str_img_url", "str_desc1", "str_desc2", "str_transfer_url" }, new Object[] { "", "", "", "", "" }, Item3.class);
  public final PBStringField str_desc1 = PBField.initString("");
  public final PBStringField str_desc2 = PBField.initString("");
  public final PBStringField str_img_url = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBStringField str_transfer_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.troop_search_searchtab.searchtab.Item3
 * JD-Core Version:    0.7.0.1
 */