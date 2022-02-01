package tencent.im.usercategory;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class ExtendFriendUserCategory$GetUserStatusReq
  extends MessageMicro<GetUserStatusReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField ReqForbiddenInfo = PBField.initBool(false);
  public final PBBoolField ReqHasPersonalLabelsFlag = PBField.initBool(false);
  public final PBBoolField ReqHasWangzheRecord = PBField.initBool(false);
  public final PBBoolField ReqLastLoginTime = PBField.initBool(false);
  public final PBBoolField ReqUsedNewMatchFlag = PBField.initBool(false);
  public final PBBoolField ReqUserCategory = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "ReqUserCategory", "ReqUsedNewMatchFlag", "ReqHasPersonalLabelsFlag", "ReqForbiddenInfo", "ReqHasWangzheRecord", "ReqLastLoginTime" }, new Object[] { localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean }, GetUserStatusReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.usercategory.ExtendFriendUserCategory.GetUserStatusReq
 * JD-Core Version:    0.7.0.1
 */