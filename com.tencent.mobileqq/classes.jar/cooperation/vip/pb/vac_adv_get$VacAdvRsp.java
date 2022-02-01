package cooperation.vip.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class vac_adv_get$VacAdvRsp
  extends MessageMicro<VacAdvRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField attach_info = PBField.initString("");
  public final PBBytesField busi_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public vac_adv_get.RewardRspInfo reward_rsp_info = new vac_adv_get.RewardRspInfo();
  public final PBRepeatMessageField<vac_adv_get.VacAdvMetaMsg> vac_adv_msgs = PBField.initRepeatMessage(vac_adv_get.VacAdvMetaMsg.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "err_code", "err_msg", "vac_adv_msgs", "attach_info", "reward_rsp_info", "busi_buffer" }, new Object[] { Integer.valueOf(0), "", null, "", null, localByteStringMicro }, VacAdvRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.VacAdvRsp
 * JD-Core Version:    0.7.0.1
 */