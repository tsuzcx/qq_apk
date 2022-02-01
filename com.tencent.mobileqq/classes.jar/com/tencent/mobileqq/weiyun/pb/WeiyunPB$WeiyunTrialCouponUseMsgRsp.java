package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class WeiyunPB$WeiyunTrialCouponUseMsgRsp
  extends MessageMicro<WeiyunTrialCouponUseMsgRsp>
{
  public static final int USER_STATICS_LEVEL_FIELD_NUMBER = 20;
  public static final int WEIYUN_VIP_FLAG_FIELD_NUMBER = 10;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field user_statics_level = PBField.initInt32(0);
  public final PBInt32Field weiyun_vip_flag = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160 }, new String[] { "weiyun_vip_flag", "user_statics_level" }, new Object[] { localInteger, localInteger }, WeiyunTrialCouponUseMsgRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.pb.WeiyunPB.WeiyunTrialCouponUseMsgRsp
 * JD-Core Version:    0.7.0.1
 */