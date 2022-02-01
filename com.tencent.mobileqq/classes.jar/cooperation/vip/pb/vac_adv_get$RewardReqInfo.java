package cooperation.vip.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class vac_adv_get$RewardReqInfo
  extends MessageMicro<RewardReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField reward_item = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField reward_type = PBField.initEnum(1);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "reward_type", "reward_item" }, new Object[] { Integer.valueOf(1), localByteStringMicro }, RewardReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.vac_adv_get.RewardReqInfo
 * JD-Core Version:    0.7.0.1
 */