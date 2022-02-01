package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import msf.msgsvc.msg_ctrl.MsgCtrl;

public final class group_file_common$FeedsInfo
  extends MessageMicro<FeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public msg_ctrl.MsgCtrl msg_ctrl = new msg_ctrl.MsgCtrl();
  public final PBStringField str_file_id = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feed_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50 }, new String[] { "uint32_bus_id", "str_file_id", "uint32_msg_random", "bytes_ext", "uint32_feed_flag", "msg_ctrl" }, new Object[] { localInteger, "", localInteger, localByteStringMicro, localInteger, null }, FeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.group_file_common.group_file_common.FeedsInfo
 * JD-Core Version:    0.7.0.1
 */