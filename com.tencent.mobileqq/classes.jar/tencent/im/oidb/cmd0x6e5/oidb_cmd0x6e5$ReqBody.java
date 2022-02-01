package tencent.im.oidb.cmd0x6e5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x6e5$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_req_all_interest_label_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_default_interest_label_id_list = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_last_interest_label_id_list = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 88, 96, 104 }, new String[] { "uint64_uin", "uint32_req_all_interest_label_list", "uint32_req_default_interest_label_id_list", "uint32_req_last_interest_label_id_list" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.ReqBody
 * JD-Core Version:    0.7.0.1
 */