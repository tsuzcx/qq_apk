package tencent.im.oidb.ranklist_comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ranklist_comm$RankItem
  extends MessageMicro<RankItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "nick", "figure", "value", "rank" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, RankItem.class);
  public final PBStringField figure = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBInt32Field rank = PBField.initInt32(0);
  public final PBInt32Field value = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.ranklist_comm.ranklist_comm.RankItem
 * JD-Core Version:    0.7.0.1
 */