package msf.registerproxy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class register_proxy$SvcRegisterProxyMsgResp
  extends MessageMicro<SvcRegisterProxyMsgResp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField c2c_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<register_proxy.DiscussList> discuss_list = PBField.initRepeatMessage(register_proxy.DiscussList.class);
  public final PBUInt32Field discuss_list_flag = PBField.initUInt32(0);
  public final PBRepeatMessageField<register_proxy.SvcPbResponsePullDisMsgProxy> discuss_msg = PBField.initRepeatMessage(register_proxy.SvcPbResponsePullDisMsgProxy.class);
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBRepeatMessageField<register_proxy.SvcResponsePbPullGroupMsgProxy> gourp_msg = PBField.initRepeatMessage(register_proxy.SvcResponsePbPullGroupMsgProxy.class);
  public final PBRepeatMessageField<register_proxy.GroupList> group_list = PBField.initRepeatMessage(register_proxy.GroupList.class);
  public register_proxy.SvcResponseMsgInfo msg_info = new register_proxy.SvcResponseMsgInfo();
  public final PBBytesField pub_account_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 66, 74, 82, 90, 96 }, new String[] { "result", "err_msg", "flag", "seq", "msg_info", "group_list", "discuss_list", "gourp_msg", "discuss_msg", "c2c_msg", "pub_account_msg", "discuss_list_flag" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localInteger, null, null, null, null, null, localByteStringMicro2, localByteStringMicro3, localInteger }, SvcRegisterProxyMsgResp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     msf.registerproxy.register_proxy.SvcRegisterProxyMsgResp
 * JD-Core Version:    0.7.0.1
 */