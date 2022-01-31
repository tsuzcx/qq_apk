package com.tencent.mobileqq.intervideo.huiyin.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class FalcoLoginProto$LoginCheckReq
  extends MessageMicro<LoginCheckReq>
{
  public static final int IS_TEST_FIELD_NUMBER = 2;
  public static final int REFRESH_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "refresh", "is_test" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) }, LoginCheckReq.class);
  public final PBBoolField is_test = PBField.initBool(false);
  public final PBBoolField refresh = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.proto.FalcoLoginProto.LoginCheckReq
 * JD-Core Version:    0.7.0.1
 */