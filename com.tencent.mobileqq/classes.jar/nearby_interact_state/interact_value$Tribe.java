package nearby_interact_state;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class interact_value$Tribe
  extends MessageMicro<Tribe>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_content_2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_content_3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_content_txt2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_content_txt3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ref_cid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_color_2_row = PBField.initUInt32(0);
  public final PBUInt32Field uint32_color_3_row = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 72, 80 }, new String[] { "uint32_bid", "bytes_pid", "bytes_cid", "bytes_ref_cid", "bytes_content_txt2", "bytes_content_2", "bytes_content_txt3", "bytes_content_3", "uint32_color_2_row", "uint32_color_3_row" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0) }, Tribe.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nearby_interact_state.interact_value.Tribe
 * JD-Core Version:    0.7.0.1
 */