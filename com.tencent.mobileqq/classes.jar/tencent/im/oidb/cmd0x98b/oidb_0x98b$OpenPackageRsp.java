package tencent.im.oidb.cmd0x98b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x98b$OpenPackageRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_failed_notice = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField rpt_pack_list = PBField.initRepeatMessage(oidb_0x98b.ItemInfo.class);
  public final PBUInt32Field uint32_can_retry = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_pack_list", "bytes_failed_notice", "uint32_can_retry" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0) }, OpenPackageRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98b.oidb_0x98b.OpenPackageRsp
 * JD-Core Version:    0.7.0.1
 */