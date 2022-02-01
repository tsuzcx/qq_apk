package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleCounter$PsvRedPointInfoReq
  extends MessageMicro<PsvRedPointInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "uin", "followfilter", "friendfilter", "feedtype" }, new Object[] { "", Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0) }, PsvRedPointInfoReq.class);
  public final PBInt32Field feedtype = PBField.initInt32(0);
  public final PBBoolField followfilter = PBField.initBool(false);
  public final PBBoolField friendfilter = PBField.initBool(false);
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleCounter.PsvRedPointInfoReq
 * JD-Core Version:    0.7.0.1
 */