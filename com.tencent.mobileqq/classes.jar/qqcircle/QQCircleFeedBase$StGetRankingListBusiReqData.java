package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleFeedBase$StGetRankingListBusiReqData
  extends MessageMicro<StGetRankingListBusiReqData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tagName" }, new Object[] { "" }, StGetRankingListBusiReqData.class);
  public final PBStringField tagName = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StGetRankingListBusiReqData
 * JD-Core Version:    0.7.0.1
 */