package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype35
  extends MessageMicro<MsgElemInfo_servtype35>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_global_padid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_token = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_get_rev = PBField.initUInt32(0);
  public final PBUInt32Field uint32_his_edit_uin_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "bytes_token", "bytes_global_padid", "uint32_get_rev", "uint32_his_edit_uin_num" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, localInteger }, MsgElemInfo_servtype35.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype35
 * JD-Core Version:    0.7.0.1
 */