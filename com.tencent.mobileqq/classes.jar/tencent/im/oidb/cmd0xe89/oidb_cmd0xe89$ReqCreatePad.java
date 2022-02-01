package tencent.im.oidb.cmd0xe89;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xe89$ReqCreatePad
  extends MessageMicro<ReqCreatePad>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0xe89.Atext> msg_atext = PBField.initRepeatMessage(oidb_cmd0xe89.Atext.class);
  public final PBUInt32Field uint32_doc_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uint32_doc_type", "bytes_title", "msg_atext", "uint64_uin", "uint32_src_type" }, new Object[] { localInteger, localByteStringMicro, null, Long.valueOf(0L), localInteger }, ReqCreatePad.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.ReqCreatePad
 * JD-Core Version:    0.7.0.1
 */