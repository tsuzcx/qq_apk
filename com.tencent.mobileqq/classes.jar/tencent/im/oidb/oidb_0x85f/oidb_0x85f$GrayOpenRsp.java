package tencent.im.oidb.oidb_0x85f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x85f$GrayOpenRsp
  extends MessageMicro<GrayOpenRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_info_card_entry_guest_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_info_card_entry_host_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nearby_entry_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nearby_entry_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_nearby_entry_color = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_card = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_list = PBField.initUInt32(0);
  public final PBUInt64Field uint64_next_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66 }, new String[] { "uint32_show_card", "uint32_show_list", "uint64_next_time", "uint32_nearby_entry_color", "bytes_nearby_entry_wording", "bytes_info_card_entry_host_url", "bytes_info_card_entry_guest_url", "bytes_nearby_entry_url" }, new Object[] { localInteger, localInteger, Long.valueOf(0L), localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, GrayOpenRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x85f.oidb_0x85f.GrayOpenRsp
 * JD-Core Version:    0.7.0.1
 */