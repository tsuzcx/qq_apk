package tencent.im.oidb.cmd0xe61;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe61$BeancurdCubeInfoResult
  extends MessageMicro<BeancurdCubeInfoResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "beancurdCubeInfo" }, new Object[] { Integer.valueOf(0), null }, BeancurdCubeInfoResult.class);
  public oidb_0xe61.BeancurdCubeInfo beancurdCubeInfo = new oidb_0xe61.BeancurdCubeInfo();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe61.oidb_0xe61.BeancurdCubeInfoResult
 * JD-Core Version:    0.7.0.1
 */