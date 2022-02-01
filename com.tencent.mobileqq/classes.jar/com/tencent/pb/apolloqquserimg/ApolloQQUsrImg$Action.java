package com.tencent.pb.apolloqquserimg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ApolloQQUsrImg$Action
  extends MessageMicro<Action>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field act_id = PBField.initUInt64(0L);
  public final PBStringField act_type = PBField.initString("");
  public final PBStringField icon = PBField.initString("");
  public final PBUInt64Field is_dynamic = PBField.initUInt64(0L);
  public final PBUInt64Field type = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "act_id", "is_dynamic", "type", "act_type", "icon" }, new Object[] { localLong, localLong, localLong, "", "" }, Action.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.apolloqquserimg.ApolloQQUsrImg.Action
 * JD-Core Version:    0.7.0.1
 */