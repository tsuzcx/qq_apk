package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacCpsGoodsListRsp
  extends MessageMicro<VacCpsGoodsListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "err_code", "err_msg", "total_num", "good_infos" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null }, VacCpsGoodsListRsp.class);
  public final PBInt32Field err_code = PBField.initInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBRepeatMessageField<VacAdvGetAccess.GoodsInfo> good_infos = PBField.initRepeatMessage(VacAdvGetAccess.GoodsInfo.class);
  public final PBInt32Field total_num = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.VacCpsGoodsListRsp
 * JD-Core Version:    0.7.0.1
 */