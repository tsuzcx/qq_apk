package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class EmosmPb$SubCmd0x5ReqBQRecommend
  extends MessageMicro<SubCmd0x5ReqBQRecommend>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "int32_last_recommend_version" }, new Object[] { Integer.valueOf(0) }, SubCmd0x5ReqBQRecommend.class);
  public final PBInt32Field int32_last_recommend_version = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.emosm.EmosmPb.SubCmd0x5ReqBQRecommend
 * JD-Core Version:    0.7.0.1
 */