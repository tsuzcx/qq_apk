package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.olympic.MqqLbs.LBSInfo;

public final class MqqLbsPack$ReqGetLBSRPList
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_encrypt_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_page_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_lat = PBField.initInt32(900000000);
  public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
  public MqqLbsPack.LBSSig msg_lbs_sig = new MqqLbsPack.LBSSig();
  public final PBUInt32Field uint32_lbs_accuracy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_occasion = PBField.initUInt32(0);
  public final PBUInt64Field uint64_adcode = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 56, 64, 82, 90, 96, 106 }, new String[] { "int32_lat", "int32_lon", "bytes_cookie", "bytes_pid", "uint64_poi_id", "bytes_page_cookie", "uint64_adcode", "uint32_req_occasion", "msg_lbs_sig", "msg_lbs_info", "uint32_lbs_accuracy", "bytes_encrypt_sig" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), null, null, Integer.valueOf(0), localByteStringMicro4 }, ReqGetLBSRPList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack.ReqGetLBSRPList
 * JD-Core Version:    0.7.0.1
 */