package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MqqLbsPack$RspGetPOIList
  extends MessageMicro<RspGetPOIList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_search_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public MqqLbsPack.RspHead msg_head = new MqqLbsPack.RspHead();
  public final PBRepeatMessageField<MqqLbsPack.PoiInfo> rpt_msg_poi_info_list = PBField.initRepeatMessage(MqqLbsPack.PoiInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_head", "rpt_msg_poi_info_list", "bytes_search_id" }, new Object[] { null, null, localByteStringMicro }, RspGetPOIList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack.RspGetPOIList
 * JD-Core Version:    0.7.0.1
 */