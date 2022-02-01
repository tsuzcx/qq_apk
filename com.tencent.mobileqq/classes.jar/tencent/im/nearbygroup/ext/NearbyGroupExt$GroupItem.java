package tencent.im.nearbygroup.ext;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.group.group_label.GroupLabel.Label;

public final class NearbyGroupExt$GroupItem
  extends MessageMicro<GroupItem>
{
  public static final int BYTES_GROUP_INTRO_FIELD_NUMBER = 3;
  public static final int BYTES_GROUP_NAME_FIELD_NUMBER = 2;
  public static final int RPT_LABEL_LIST_FIELD_NUMBER = 4;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_group_intro = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<GroupLabel.Label> rpt_label_list = PBField.initRepeatMessage(GroupLabel.Label.class);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_group_code", "bytes_group_name", "bytes_group_intro", "rpt_label_list" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null }, GroupItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.nearbygroup.ext.NearbyGroupExt.GroupItem
 * JD-Core Version:    0.7.0.1
 */