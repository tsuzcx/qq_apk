package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.olympic.MqqLbs.LBSInfo;

public final class MqqLbsPack$ReqGetLBSPID
  extends MessageMicro<ReqGetLBSPID>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_encrypt_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_lat = PBField.initInt32(900000000);
  public final PBInt32Field int32_lon = PBField.initInt32(900000000);
  public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
  public MqqLbsPack.LBSSig msg_lbs_sig = new MqqLbsPack.LBSSig();
  public MqqLbsPack.PoiInfo msg_poi_info = new MqqLbsPack.PoiInfo();
  public MqqLbsPack.SelectedUinInfo uin_grp_dis_info = new MqqLbsPack.SelectedUinInfo();
  public final PBUInt32Field uint32_lbs_accuracy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qa = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(900000000);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 82, 90, 96, 106 }, new String[] { "int32_lat", "int32_lon", "msg_poi_info", "uin_grp_dis_info", "uint32_qa", "msg_lbs_sig", "msg_lbs_info", "uint32_lbs_accuracy", "bytes_encrypt_sig" }, new Object[] { localInteger2, localInteger2, null, null, localInteger1, null, null, localInteger1, localByteStringMicro }, ReqGetLBSPID.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack.ReqGetLBSPID
 * JD-Core Version:    0.7.0.1
 */