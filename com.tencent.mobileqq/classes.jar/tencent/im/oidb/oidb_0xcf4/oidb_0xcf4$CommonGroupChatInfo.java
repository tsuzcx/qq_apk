package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xcf4$CommonGroupChatInfo
  extends MessageMicro<CommonGroupChatInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0xcf4.OneGroupInfo msg_one_group_info = new oidb_0xcf4.OneGroupInfo();
  public final PBRepeatMessageField<oidb_0xcf4.OneGroupInfo> rpt_msg_one_group_info = PBField.initRepeatMessage(oidb_0xcf4.OneGroupInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "rpt_msg_one_group_info", "msg_one_group_info", "bytes_wording" }, new Object[] { null, null, localByteStringMicro }, CommonGroupChatInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.CommonGroupChatInfo
 * JD-Core Version:    0.7.0.1
 */