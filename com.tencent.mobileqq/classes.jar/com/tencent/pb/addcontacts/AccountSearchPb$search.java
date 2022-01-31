package com.tencent.pb.addcontacts;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AccountSearchPb$search
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 82, 88, 96, 106, 114, 122, 130 }, new String[] { "start", "count", "end", "keyword", "list", "highlight", "msg_user_location", "bool_location_group", "filtertype", "recommend_list", "hotword_record", "article_more_url", "result_items" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, "", null, Boolean.valueOf(false), Integer.valueOf(0), null, null, "", null }, search.class);
  public final PBStringField article_more_url = PBField.initString("");
  public final PBBoolField bool_location_group = PBField.initBool(false);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBUInt32Field end = PBField.initUInt32(0);
  public final PBInt32Field filtertype = PBField.initInt32(0);
  public final PBRepeatField highlight = PBField.initRepeat(PBStringField.__repeatHelper__);
  public AccountSearchPb.hotwordrecord hotword_record = new AccountSearchPb.hotwordrecord();
  public final PBStringField keyword = PBField.initString("");
  public final PBRepeatMessageField list = PBField.initRepeatMessage(AccountSearchPb.record.class);
  public AccountSearchPb.Location msg_user_location = new AccountSearchPb.Location();
  public final PBRepeatMessageField recommend_list = PBField.initRepeatMessage(AccountSearchPb.record.class);
  public final PBRepeatMessageField result_items = PBField.initRepeatMessage(AccountSearchPb.ResultItem.class);
  public final PBInt32Field start = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.addcontacts.AccountSearchPb.search
 * JD-Core Version:    0.7.0.1
 */