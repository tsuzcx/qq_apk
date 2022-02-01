package tencent.im.oidb.cmd0x626;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x626$TinyIDInfoReq
  extends MessageMicro<TinyIDInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_tinyid" }, new Object[] { Long.valueOf(0L) }, TinyIDInfoReq.class);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x626.Oidb_0x626.TinyIDInfoReq
 * JD-Core Version:    0.7.0.1
 */