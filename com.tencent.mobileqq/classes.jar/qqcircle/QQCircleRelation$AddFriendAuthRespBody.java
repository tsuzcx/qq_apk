package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleRelation$AddFriendAuthRespBody
  extends MessageMicro<AddFriendAuthRespBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "sint32_result", "bytes_err_msg" }, new Object[] { Integer.valueOf(0), "" }, AddFriendAuthRespBody.class);
  public final PBStringField bytes_err_msg = PBField.initString("");
  public final PBSInt32Field sint32_result = PBField.initSInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleRelation.AddFriendAuthRespBody
 * JD-Core Version:    0.7.0.1
 */