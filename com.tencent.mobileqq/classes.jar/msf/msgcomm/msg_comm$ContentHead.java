package msf.msgcomm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class msg_comm$ContentHead
  extends MessageMicro<ContentHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field auto_reply = PBField.initUInt32(0);
  public final PBUInt32Field div_seq = PBField.initUInt32(0);
  public final PBUInt32Field pkg_index = PBField.initUInt32(0);
  public final PBUInt32Field pkg_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "pkg_num", "pkg_index", "div_seq", "auto_reply" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, ContentHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.msgcomm.msg_comm.ContentHead
 * JD-Core Version:    0.7.0.1
 */