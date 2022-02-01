package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8dd$ReqCtrl
  extends MessageMicro<ReqCtrl>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_req_ad = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_anchor = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_check_in = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_from_web = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_none = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_people_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_recommend_cookie = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_safe = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_self = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_sort_algorithm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_third_line = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_tinyid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_uin = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104 }, new String[] { "uint32_req_uin", "uint32_req_tinyid", "uint32_req_anchor", "uint32_req_ad", "uint32_req_self", "uint32_req_safe", "uint32_req_check_in", "uint32_req_people_number", "uint32_req_none", "uint32_req_third_line", "uint32_req_sort_algorithm", "uint32_req_from_web", "uint32_req_recommend_cookie" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, ReqCtrl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8dd.oidb_0x8dd.ReqCtrl
 * JD-Core Version:    0.7.0.1
 */