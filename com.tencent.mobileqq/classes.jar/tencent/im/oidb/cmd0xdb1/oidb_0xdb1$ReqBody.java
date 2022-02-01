package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xdb1$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0xdb1.LBSInfo msg_lbs_info = new oidb_0xdb1.LBSInfo();
  public final PBUInt32Field uint32_get_online_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_get_search_keywords = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_get_search_keywords", "uint32_get_online_num", "msg_lbs_info" }, new Object[] { localInteger, localInteger, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdb1.oidb_0xdb1.ReqBody
 * JD-Core Version:    0.7.0.1
 */