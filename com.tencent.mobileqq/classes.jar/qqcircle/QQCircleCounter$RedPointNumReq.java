package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCounter$RedPointNumReq
  extends MessageMicro<RedPointNumReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "uin", "redType", "feedtype" }, new Object[] { "", Integer.valueOf(1), Integer.valueOf(0) }, RedPointNumReq.class);
  public final PBInt32Field feedtype = PBField.initInt32(0);
  public final PBEnumField redType = PBField.initEnum(1);
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qqcircle.QQCircleCounter.RedPointNumReq
 * JD-Core Version:    0.7.0.1
 */