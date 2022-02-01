package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobileqq_mp$UpdateResponseItem
  extends MessageMicro<UpdateResponseItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField decrypt = PBField.initBool(false);
  public final PBStringField download_url = PBField.initString("");
  public final PBStringField md5 = PBField.initString("");
  public final PBUInt32Field module_id = PBField.initUInt32(0);
  public final PBUInt32Field module_state = PBField.initUInt32(0);
  public final PBUInt32Field module_version = PBField.initUInt32(0);
  public final PBStringField pwd = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 58 }, new String[] { "module_id", "module_version", "module_state", "download_url", "md5", "decrypt", "pwd" }, new Object[] { localInteger, localInteger, localInteger, "", "", Boolean.valueOf(false), "" }, UpdateResponseItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.UpdateResponseItem
 * JD-Core Version:    0.7.0.1
 */