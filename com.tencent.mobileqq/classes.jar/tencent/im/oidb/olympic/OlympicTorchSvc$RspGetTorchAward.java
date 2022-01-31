package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OlympicTorchSvc$RspGetTorchAward
  extends MessageMicro<RspGetTorchAward>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public OlympicTorchSvc.RspHead msg_rsp_head = new OlympicTorchSvc.RspHead();
  public torch_transfer.TorchbearerInfo msg_torchbearer_info = new torch_transfer.TorchbearerInfo();
  public final PBUInt32Field uint32_delay_time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 82 }, new String[] { "msg_rsp_head", "msg_torchbearer_info", "uint32_delay_time", "bytes_sig" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspGetTorchAward.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.olympic.OlympicTorchSvc.RspGetTorchAward
 * JD-Core Version:    0.7.0.1
 */