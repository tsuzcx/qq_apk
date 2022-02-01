package msg.uin_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UinList$UinListUploadReq
  extends MessageMicro<UinListUploadReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_cmd", "friend_list" }, new Object[] { Integer.valueOf(0), null }, UinListUploadReq.class);
  public final PBRepeatMessageField<UinList.C2C> friend_list = PBField.initRepeatMessage(UinList.C2C.class);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     msg.uin_list.UinList.UinListUploadReq
 * JD-Core Version:    0.7.0.1
 */