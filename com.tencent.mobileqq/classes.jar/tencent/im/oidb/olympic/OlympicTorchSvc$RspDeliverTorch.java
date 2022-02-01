package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OlympicTorchSvc$RspDeliverTorch
  extends MessageMicro<RspDeliverTorch>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public OlympicTorchSvc.RspHead msg_rsp_head = new OlympicTorchSvc.RspHead();
  public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_min_update_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 82 }, new String[] { "msg_rsp_head", "uint32_min_update_time", "uint32_expire_time", "bytes_sig" }, new Object[] { null, localInteger, localInteger, localByteStringMicro }, RspDeliverTorch.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.olympic.OlympicTorchSvc.RspDeliverTorch
 * JD-Core Version:    0.7.0.1
 */