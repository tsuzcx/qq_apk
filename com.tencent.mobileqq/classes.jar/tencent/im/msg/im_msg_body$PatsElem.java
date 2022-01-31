package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$PatsElem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_pat_type", "uint32_pat_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PatsElem.class);
  public final PBUInt32Field uint32_pat_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pat_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.PatsElem
 * JD-Core Version:    0.7.0.1
 */