package tencent.im.oidb.cmd0xb85;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class Oidb_0xb85$GetRankListReqBody
  extends MessageMicro<GetRankListReqBody>
{
  public static final int RANK_CUR_VAL = 0;
  public static final int RANK_MAX_VAL = 1;
  public static final int RANK_MIN_VAL = 2;
  public static final int RANK_ORDER_ASC = 1;
  public static final int RANK_ORDER_DESC = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "ranklist_id", "top_count", "rank_key", "rank_value_type", "rank_order_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(10), "", Integer.valueOf(0), Integer.valueOf(0) }, GetRankListReqBody.class);
  public final PBStringField rank_key = PBField.initString("");
  public final PBInt32Field rank_order_type = PBField.initInt32(0);
  public final PBInt32Field rank_value_type = PBField.initInt32(0);
  public final PBInt32Field ranklist_id = PBField.initInt32(0);
  public final PBInt32Field top_count = PBField.initInt32(10);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb85.Oidb_0xb85.GetRankListReqBody
 * JD-Core Version:    0.7.0.1
 */