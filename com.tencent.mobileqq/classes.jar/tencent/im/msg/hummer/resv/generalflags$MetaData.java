package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class generalflags$MetaData
  extends MessageMicro<MetaData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "data_from", "ext_nick" }, new Object[] { "", "" }, MetaData.class);
  public final PBStringField data_from = PBField.initString("");
  public final PBStringField ext_nick = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.resv.generalflags.MetaData
 * JD-Core Version:    0.7.0.1
 */