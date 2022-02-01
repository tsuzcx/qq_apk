package tencent.im.group_pro_proto.synclogic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class synclogic$FirstViewReq
  extends MessageMicro<FirstViewReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field last_msg_time = PBField.initUInt64(0L);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt32Field udc_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "last_msg_time", "udc_flag", "seq" }, new Object[] { Long.valueOf(0L), localInteger, localInteger }, FirstViewReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.synclogic.synclogic.FirstViewReq
 * JD-Core Version:    0.7.0.1
 */