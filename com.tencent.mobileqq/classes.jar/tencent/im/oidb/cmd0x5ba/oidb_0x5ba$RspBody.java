package tencent.im.oidb.cmd0x5ba;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x5ba$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x5ba.RewardItem msg_resource = new oidb_0x5ba.RewardItem();
  public oidb_0x5ba.Reward msg_rewards = new oidb_0x5ba.Reward();
  public final PBStringField string_privilege_desc = PBField.initString("");
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_reward_privilege = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50 }, new String[] { "uint32_result", "bytes_errmsg", "msg_rewards", "msg_resource", "uint32_reward_privilege", "string_privilege_desc" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, Integer.valueOf(0), "" }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5ba.oidb_0x5ba.RspBody
 * JD-Core Version:    0.7.0.1
 */