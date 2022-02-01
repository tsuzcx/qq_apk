package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleRankinglist$SimpleRankItem
  extends MessageMicro<SimpleRankItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field listType = PBField.initInt32(0);
  public final PBInt32Field rank = PBField.initInt32(0);
  public final PBStringField rankTitle = PBField.initString("");
  public final PBStringField tagId = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "rank", "listType", "rankTitle", "tagId" }, new Object[] { localInteger, localInteger, "", "" }, SimpleRankItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleRankinglist.SimpleRankItem
 * JD-Core Version:    0.7.0.1
 */