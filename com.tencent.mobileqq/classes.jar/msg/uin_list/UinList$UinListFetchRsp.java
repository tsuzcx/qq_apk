package msg.uin_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UinList$UinListFetchRsp
  extends MessageMicro<UinListFetchRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_result", "friend_list" }, new Object[] { Integer.valueOf(0), null }, UinListFetchRsp.class);
  public final PBRepeatMessageField<UinList.C2C> friend_list = PBField.initRepeatMessage(UinList.C2C.class);
  public final PBInt32Field int32_result = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     msg.uin_list.UinList.UinListFetchRsp
 * JD-Core Version:    0.7.0.1
 */