package tencent.im.oidb.cmd0x7b4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.olympic.MqqLbs.LBSCheckInfo;
import tencent.im.oidb.olympic.MqqLbs.LBSInfo;

public final class cmd0x7b4$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_encrypt_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_lat = PBField.initInt32(900000000);
  public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  public MqqLbs.LBSCheckInfo msg_lbs_check_info = new MqqLbs.LBSCheckInfo();
  public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
  public cmd0x7b4.LBSSig msg_lbs_sig = new cmd0x7b4.LBSSig();
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lbs_accuracy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_map_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_occasion = PBField.initUInt32(0);
  public final PBUInt64Field uint64_adcode = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 48, 64, 98, 106, 114, 122, 128, 138, 160 }, new String[] { "int32_lat", "int32_lon", "uint32_app_id", "uint32_map_level", "uint32_req_occasion", "uint64_adcode", "bytes_cookie", "msg_lbs_sig", "msg_lbs_info", "msg_lbs_check_info", "uint32_lbs_accuracy", "bytes_encrypt_sig", "uint32_flag" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, null, null, null, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7b4.cmd0x7b4.ReqBody
 * JD-Core Version:    0.7.0.1
 */