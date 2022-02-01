package tencent.im.group_pro_proto.oidb0xf62;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.group_pro_proto.common.common.MsgHead;

public final class Oidb0xf62$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field err_type = PBField.initUInt32(0);
  public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public common.MsgHead head = new common.MsgHead();
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field send_time = PBField.initUInt32(0);
  public Oidb0xf62.TransSvrInfo trans_svr_info = new Oidb0xf62.TransSvrInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50 }, new String[] { "result", "errmsg", "send_time", "head", "err_type", "trans_svr_info" }, new Object[] { localInteger, localByteStringMicro, localInteger, null, localInteger, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.oidb0xf62.Oidb0xf62.RspBody
 * JD-Core Version:    0.7.0.1
 */