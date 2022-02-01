package tencent.im.nearfield_discuss;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class nearfield_discuss$ReqJoinDiscuss
  extends MessageMicro<ReqJoinDiscuss>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public nearfield_discuss.BusiReqHead msg_head = new nearfield_discuss.BusiReqHead();
  public nearfield_discuss.LBSInfo msg_lbs_info = new nearfield_discuss.LBSInfo();
  public final PBStringField str_number = PBField.initString("");
  public final PBUInt32Field uint32_join_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "msg_head", "msg_lbs_info", "str_number", "uint32_session_id", "uint32_join_type" }, new Object[] { null, null, "", localInteger, localInteger }, ReqJoinDiscuss.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.nearfield_discuss.nearfield_discuss.ReqJoinDiscuss
 * JD-Core Version:    0.7.0.1
 */