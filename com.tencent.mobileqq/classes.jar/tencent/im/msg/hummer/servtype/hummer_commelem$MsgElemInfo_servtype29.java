package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class hummer_commelem$MsgElemInfo_servtype29
  extends MessageMicro<MsgElemInfo_servtype29>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_luckybag_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_luckybag_msg" }, new Object[] { localByteStringMicro }, MsgElemInfo_servtype29.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype29
 * JD-Core Version:    0.7.0.1
 */