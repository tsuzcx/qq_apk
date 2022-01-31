package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyDownloadReq
  extends MessageMicro<ApplyDownloadReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_ext_uintype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_https_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_owner_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 4000, 4008 }, new String[] { "uint64_uin", "bytes_uuid", "uint32_owner_type", "uint32_ext_uintype", "uint32_need_https_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ApplyDownloadReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyDownloadReq
 * JD-Core Version:    0.7.0.1
 */