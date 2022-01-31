package com.tencent.pb.addcontacts;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;

public final class AccountSearchPb$record
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field account_flag = PBField.initUInt32(0);
  public final PBUInt64Field account_id = PBField.initUInt64(0L);
  public final PBStringField accout = PBField.initString("");
  public final PBUInt32Field age = PBField.initUInt32(0);
  public final PBStringField article_author = PBField.initString("");
  public final PBStringField article_create_time = PBField.initString("");
  public final PBStringField article_short_url = PBField.initString("");
  public final PBStringField brief = PBField.initString("");
  public final PBUInt32Field city = PBField.initUInt32(0);
  public final PBStringField city_name = PBField.initString("");
  public final PBUInt32Field class_index = PBField.initUInt32(0);
  public final PBStringField class_name = PBField.initString("");
  public final PBUInt64Field code = PBField.initUInt64(0L);
  public final PBUInt32Field country = PBField.initUInt32(0);
  public final PBStringField country_name = PBField.initString("");
  public final PBUInt64Field flag = PBField.initUInt64(0L);
  public final PBStringField mobile = PBField.initString("");
  public final PBRepeatMessageField msg_group_labels = PBField.initRepeatMessage(AccountSearchPb.Label.class);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field number = PBField.initUInt32(0);
  public final PBUInt32Field province = PBField.initUInt32(0);
  public final PBStringField province_name = PBField.initString("");
  public final PBUInt64Field relation = PBField.initUInt64(0L);
  public RichStatus richStatus;
  public final PBUInt32Field sex = PBField.initUInt32(0);
  public final PBBytesField sign = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField source = PBField.initEnum(1);
  public final PBStringField title_image = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field video_account = PBField.initUInt32(0);
  public final PBUInt32Field video_article = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 66, 72, 80, 88, 98, 106, 112, 120, 128, 136, 146, 154, 162, 170, 176, 186, 194, 202, 210, 216, 242, 248, 256 }, new String[] { "uin", "code", "source", "name", "sex", "age", "accout", "brief", "number", "flag", "relation", "mobile", "sign", "country", "province", "city", "class_index", "class_name", "country_name", "province_name", "city_name", "account_flag", "title_image", "article_short_url", "article_create_time", "article_author", "account_id", "msg_group_labels", "video_account", "video_article" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", "", "", "", Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0) }, record.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.addcontacts.AccountSearchPb.record
 * JD-Core Version:    0.7.0.1
 */