package tencent.im.usercategory;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class ExtendFriendUserCategory$GetUserStatusReq
  extends MessageMicro<GetUserStatusReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "ReqUserCategory", "ReqUsedNewMatchFlag", "ReqHasPersonalLabelsFlag", "ReqForbiddenInfo" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) }, GetUserStatusReq.class);
  public final PBBoolField ReqForbiddenInfo = PBField.initBool(false);
  public final PBBoolField ReqHasPersonalLabelsFlag = PBField.initBool(false);
  public final PBBoolField ReqUsedNewMatchFlag = PBField.initBool(false);
  public final PBBoolField ReqUserCategory = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusReq
 * JD-Core Version:    0.7.0.1
 */