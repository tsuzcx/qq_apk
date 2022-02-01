package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$PatsElem
  extends MessageMicro<PatsElem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_pat_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pat_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_pat_type", "uint32_pat_count" }, new Object[] { localInteger, localInteger }, PatsElem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.PatsElem
 * JD-Core Version:    0.7.0.1
 */