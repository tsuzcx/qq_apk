package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MqqLbsPack$LbsPackInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_addr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cft_pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
  public MqqLbsPack.SelectedUinInfo uin_grp_dis_info = new MqqLbsPack.SelectedUinInfo();
  public final PBUInt32Field uint32_priority = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qa = PBField.initUInt32(0);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_set_pack_poi = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 58, 160, 170, 178, 242 }, new String[] { "bytes_pid", "uint64_uin", "bytes_cft_pack_id", "uint32_status", "uint32_priority", "uint32_qa", "uin_grp_dis_info", "uint64_set_pack_poi", "bytes_name", "bytes_addr", "bytes_auth_key" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, LbsPackInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack.LbsPackInfo
 * JD-Core Version:    0.7.0.1
 */