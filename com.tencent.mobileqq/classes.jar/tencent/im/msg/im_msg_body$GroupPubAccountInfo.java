package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$GroupPubAccountInfo
  extends MessageMicro<GroupPubAccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_pub_account" }, new Object[] { Long.valueOf(0L) }, GroupPubAccountInfo.class);
  public final PBUInt64Field uint64_pub_account = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.GroupPubAccountInfo
 * JD-Core Version:    0.7.0.1
 */