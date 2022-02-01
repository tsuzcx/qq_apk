package tencent.im.oidb.cmd0xe16;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_cmd0xe16$ParamInfo
  extends MessageMicro<ParamInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_diffuse_to_friends = PBField.initBool(false);
  public final PBBoolField bool_only_biu = PBField.initBool(false);
  public final PBBoolField bool_with_biu = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "bool_with_biu", "bool_diffuse_to_friends", "bool_only_biu" }, new Object[] { localBoolean, localBoolean, localBoolean }, ParamInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe16.oidb_cmd0xe16.ParamInfo
 * JD-Core Version:    0.7.0.1
 */