package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleFeedBase$StGetRecomUserListBusiReqData
  extends MessageMicro<StGetRecomUserListBusiReqData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "desUserID" }, new Object[] { "" }, StGetRecomUserListBusiReqData.class);
  public final PBStringField desUserID = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StGetRecomUserListBusiReqData
 * JD-Core Version:    0.7.0.1
 */