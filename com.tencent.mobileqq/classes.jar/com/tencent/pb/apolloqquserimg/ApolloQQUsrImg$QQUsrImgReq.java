package com.tencent.pb.apolloqquserimg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ApolloQQUsrImg$QQUsrImgReq
  extends MessageMicro<QQUsrImgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field type = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "type" }, new Object[] { localLong, localLong }, QQUsrImgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.apolloqquserimg.ApolloQQUsrImg.QQUsrImgReq
 * JD-Core Version:    0.7.0.1
 */