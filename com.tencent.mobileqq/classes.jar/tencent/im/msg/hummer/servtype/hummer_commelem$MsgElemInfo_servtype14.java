package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype14
  extends MessageMicro<MsgElemInfo_servtype14>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField reserve_Info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_id", "reserve_Info" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, MsgElemInfo_servtype14.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype14
 * JD-Core Version:    0.7.0.1
 */