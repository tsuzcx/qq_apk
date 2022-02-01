package com.tencent.mobileqq.vas.adv.common.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class vac_adv_get$VacFeedsAdvRsp
  extends MessageMicro<VacFeedsAdvRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field adv_export_cnt = PBField.initInt32(0);
  public final PBStringField attach_info = PBField.initString("");
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBRepeatMessageField<vac_adv_get.VacFeedsAdvMetaMsg> vac_adv_msgs = PBField.initRepeatMessage(vac_adv_get.VacFeedsAdvMetaMsg.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "err_code", "err_msg", "vac_adv_msgs", "attach_info", "adv_export_cnt" }, new Object[] { localInteger, "", null, "", localInteger }, VacFeedsAdvRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get.VacFeedsAdvRsp
 * JD-Core Version:    0.7.0.1
 */