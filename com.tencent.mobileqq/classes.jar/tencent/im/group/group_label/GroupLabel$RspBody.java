package tencent.im.group.group_label;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class GroupLabel$RspBody
  extends MessageMicro<RspBody>
{
  public static final int BYTES_ERROR_FIELD_NUMBER = 1;
  public static final int RPT_GROUP_INFO_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<GroupLabel.GroupInfo> rpt_group_info = PBField.initRepeatMessage(GroupLabel.GroupInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_error", "rpt_group_info" }, new Object[] { localByteStringMicro, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group.group_label.GroupLabel.RspBody
 * JD-Core Version:    0.7.0.1
 */