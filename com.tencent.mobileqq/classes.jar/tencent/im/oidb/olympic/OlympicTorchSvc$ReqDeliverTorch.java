package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OlympicTorchSvc$ReqDeliverTorch
  extends MessageMicro<ReqDeliverTorch>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
  public final PBUInt32Field uint32_user_share = PBField.initUInt32(0);
  public final PBUInt64Field uint64_torch_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 82 }, new String[] { "uint64_torch_id", "msg_lbs_info", "uint32_user_share", "bytes_sig" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro }, ReqDeliverTorch.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.olympic.OlympicTorchSvc.ReqDeliverTorch
 * JD-Core Version:    0.7.0.1
 */