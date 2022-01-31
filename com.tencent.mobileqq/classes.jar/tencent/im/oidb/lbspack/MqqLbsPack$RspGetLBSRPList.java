package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MqqLbsPack$RspGetLBSRPList
  extends MessageMicro<RspGetLBSRPList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_page_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public MqqLbsPack.RspHead msg_head = new MqqLbsPack.RspHead();
  public final PBRepeatMessageField<MqqLbsPack.POIRPInfo> rpt_poi_info_list = PBField.initRepeatMessage(MqqLbsPack.POIRPInfo.class);
  public final PBUInt32Field uint32_flush_dist = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flush_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_get_award_range = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lbs_interval = PBField.initUInt32(0);
  public final PBUInt32Field uint32_patch_button_stat = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_map_grid = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 80, 88, 98, 104, 112, 120, 128 }, new String[] { "msg_head", "rpt_poi_info_list", "bytes_page_cookie", "uint32_flush_dist", "uint32_flush_time", "bytes_cookie", "uint32_lbs_interval", "uint32_show_map_grid", "uint32_patch_button_stat", "uint32_get_award_range" }, new Object[] { null, null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspGetLBSRPList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack.RspGetLBSRPList
 * JD-Core Version:    0.7.0.1
 */