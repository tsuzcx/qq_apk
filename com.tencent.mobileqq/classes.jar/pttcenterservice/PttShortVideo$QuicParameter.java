package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$QuicParameter
  extends MessageMicro<QuicParameter>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_enable_quic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_encryption_ver = PBField.initUInt32(1);
  public final PBUInt32Field uint32_fec_ver = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_enable_quic", "uint32_encryption_ver", "uint32_fec_ver" }, new Object[] { localInteger, Integer.valueOf(1), localInteger }, QuicParameter.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.QuicParameter
 * JD-Core Version:    0.7.0.1
 */