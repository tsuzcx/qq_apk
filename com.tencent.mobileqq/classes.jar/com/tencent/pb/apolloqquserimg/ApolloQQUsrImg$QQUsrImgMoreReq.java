package com.tencent.pb.apolloqquserimg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ApolloQQUsrImg$QQUsrImgMoreReq
  extends MessageMicro<QQUsrImgMoreReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attach_info = PBField.initString("");
  public final PBUInt64Field is_dynamic = PBField.initUInt64(0L);
  public final PBUInt64Field type = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uin", "attach_info", "type", "is_dynamic" }, new Object[] { localLong, "", localLong, localLong }, QQUsrImgMoreReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.apolloqquserimg.ApolloQQUsrImg.QQUsrImgMoreReq
 * JD-Core Version:    0.7.0.1
 */