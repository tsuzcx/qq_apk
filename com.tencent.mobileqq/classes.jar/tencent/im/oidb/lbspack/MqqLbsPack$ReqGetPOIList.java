package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.olympic.MqqLbs.LBSInfo;

public final class MqqLbsPack$ReqGetPOIList
  extends MessageMicro<ReqGetPOIList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_encrypt_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_lat = PBField.initInt32(900000000);
  public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
  public MqqLbsPack.LBSSig msg_lbs_sig = new MqqLbsPack.LBSSig();
  public final PBUInt32Field uint32_lbs_accuracy = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82, 90, 96, 106 }, new String[] { "int32_lat", "int32_lon", "msg_lbs_sig", "msg_lbs_info", "uint32_lbs_accuracy", "bytes_encrypt_sig" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), null, null, Integer.valueOf(0), localByteStringMicro }, ReqGetPOIList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack.ReqGetPOIList
 * JD-Core Version:    0.7.0.1
 */