package tencent.im.usercategory;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ExtendFriendUserCategory$ForbiddenInfo
  extends MessageMicro<ForbiddenInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "isForbidden", "forbiddenEndTime", "forbiddenDuration" }, new Object[] { Boolean.valueOf(false), Long.valueOf(0L), Integer.valueOf(0) }, ForbiddenInfo.class);
  public final PBUInt32Field forbiddenDuration = PBField.initUInt32(0);
  public final PBUInt64Field forbiddenEndTime = PBField.initUInt64(0L);
  public final PBBoolField isForbidden = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.usercategory.ExtendFriendUserCategory.ForbiddenInfo
 * JD-Core Version:    0.7.0.1
 */