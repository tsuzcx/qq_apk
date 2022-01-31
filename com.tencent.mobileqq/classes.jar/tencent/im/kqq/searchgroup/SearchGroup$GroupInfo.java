package tencent.im.kqq.searchgroup;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SearchGroup$GroupInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64, 74, 82, 88, 98, 104, 112, 120, 128, 136, 144, 152, 162, 168, 176 }, new String[] { "dwGroupCode", "dwGroupUin", "dwGroupOwnerId", "dwCurMemberNum", "dwMaxMemberNum", "sGroupName", "sGroupFingerMem", "dwGroupFaceId", "sGroupFaceUrl", "sGroupTag", "dwGroupClass", "sGroupClassText", "dwGroupLevel", "bSameCity", "bGroupFull", "bGroupAllow", "bGroupIn", "dwGroupHotDegree", "dwGroupFlagExt", "sGroupLocation", "dwGroupOption", "dwAuthGroupType" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", Integer.valueOf(0), "", Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, GroupInfo.class);
  public final PBBoolField bGroupAllow = PBField.initBool(false);
  public final PBBoolField bGroupFull = PBField.initBool(false);
  public final PBBoolField bGroupIn = PBField.initBool(false);
  public final PBBoolField bSameCity = PBField.initBool(false);
  public final PBUInt32Field dwAuthGroupType = PBField.initUInt32(0);
  public final PBUInt32Field dwCurMemberNum = PBField.initUInt32(0);
  public final PBUInt32Field dwGroupClass = PBField.initUInt32(0);
  public final PBUInt32Field dwGroupCode = PBField.initUInt32(0);
  public final PBUInt32Field dwGroupFaceId = PBField.initUInt32(0);
  public final PBUInt32Field dwGroupFlagExt = PBField.initUInt32(0);
  public final PBUInt32Field dwGroupHotDegree = PBField.initUInt32(0);
  public final PBUInt32Field dwGroupLevel = PBField.initUInt32(0);
  public final PBUInt32Field dwGroupOption = PBField.initUInt32(0);
  public final PBUInt32Field dwGroupOwnerId = PBField.initUInt32(0);
  public final PBUInt32Field dwGroupUin = PBField.initUInt32(0);
  public final PBUInt32Field dwMaxMemberNum = PBField.initUInt32(0);
  public final PBStringField sGroupClassText = PBField.initString("");
  public final PBStringField sGroupFaceUrl = PBField.initString("");
  public final PBStringField sGroupFingerMem = PBField.initString("");
  public final PBStringField sGroupLocation = PBField.initString("");
  public final PBStringField sGroupName = PBField.initString("");
  public final PBStringField sGroupTag = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.kqq.searchgroup.SearchGroup.GroupInfo
 * JD-Core Version:    0.7.0.1
 */