package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class VacAdvGetAccess$VacCpsGoodsListReq
  extends MessageMicro<VacCpsGoodsListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "uid", "keyword", "category_list", "page_nu", "page_size" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VacCpsGoodsListReq.class);
  public final PBRepeatField<Integer> category_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBStringField keyword = PBField.initString("");
  public final PBInt32Field page_nu = PBField.initInt32(0);
  public final PBInt32Field page_size = PBField.initInt32(0);
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.VacAdvGetAccess.VacCpsGoodsListReq
 * JD-Core Version:    0.7.0.1
 */