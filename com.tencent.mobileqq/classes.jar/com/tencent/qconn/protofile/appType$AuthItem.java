package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appType$AuthItem
  extends MessageMicro<AuthItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField api_list = PBField.initString("");
  public final PBSInt32Field default_flag = PBField.initSInt32(0);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBSInt32Field is_new = PBField.initSInt32(0);
  public final PBStringField logo_url = PBField.initString("");
  public final PBStringField title = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50 }, new String[] { "default_flag", "id", "title", "api_list", "is_new", "logo_url" }, new Object[] { localInteger, localInteger, "", "", localInteger, "" }, AuthItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qconn.protofile.appType.AuthItem
 * JD-Core Version:    0.7.0.1
 */