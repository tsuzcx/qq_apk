package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqwalletaio_resv$qqwalletaio_body_resv
  extends MessageMicro<qqwalletaio_body_resv>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_client_extend = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_poem_rule = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_rareword_rule = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_pfa_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subchannel = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "uint32_pfa_type", "bytes_feeds_id", "uint32_subchannel", "bytes_poem_rule", "bytes_client_extend", "bytes_rareword_rule" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, qqwalletaio_body_resv.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.qqwallet.qqwalletaio_resv.qqwalletaio_body_resv
 * JD-Core Version:    0.7.0.1
 */