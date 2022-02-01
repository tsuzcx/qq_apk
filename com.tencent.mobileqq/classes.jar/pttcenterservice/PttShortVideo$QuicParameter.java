package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$QuicParameter
  extends MessageMicro<QuicParameter>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_enable_quic", "uint32_encryption_ver", "uint32_fec_ver" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }, QuicParameter.class);
  public final PBUInt32Field uint32_enable_quic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_encryption_ver = PBField.initUInt32(1);
  public final PBUInt32Field uint32_fec_ver = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.QuicParameter
 * JD-Core Version:    0.7.0.1
 */