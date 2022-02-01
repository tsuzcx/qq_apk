package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleProfile$StGetPMBeginShowMsgReq
  extends MessageMicro<StGetPMBeginShowMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "userId" }, new Object[] { "" }, StGetPMBeginShowMsgReq.class);
  public final PBStringField userId = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     qqcircle.QQCircleProfile.StGetPMBeginShowMsgReq
 * JD-Core Version:    0.7.0.1
 */