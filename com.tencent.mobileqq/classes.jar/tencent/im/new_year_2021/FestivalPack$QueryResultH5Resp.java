package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class FestivalPack$QueryResultH5Resp
  extends MessageMicro<QueryResultH5Resp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 24, 32, 40, 64 }, new String[] { "problem_succ_num", "money_num", "gift_num", "defeat_ratio" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, QueryResultH5Resp.class);
  public final PBUInt32Field defeat_ratio = PBField.initUInt32(0);
  public final PBUInt32Field gift_num = PBField.initUInt32(0);
  public final PBUInt32Field money_num = PBField.initUInt32(0);
  public final PBUInt32Field problem_succ_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.new_year_2021.FestivalPack.QueryResultH5Resp
 * JD-Core Version:    0.7.0.1
 */