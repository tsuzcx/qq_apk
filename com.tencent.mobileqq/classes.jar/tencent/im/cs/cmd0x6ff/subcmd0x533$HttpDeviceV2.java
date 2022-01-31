package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class subcmd0x533$HttpDeviceV2
  extends MessageMicro<HttpDeviceV2>
{
  public static final int Android = 1;
  public static final int IOS = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "platform" }, new Object[] { Integer.valueOf(0) }, HttpDeviceV2.class);
  public final PBEnumField platform = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x533.HttpDeviceV2
 * JD-Core Version:    0.7.0.1
 */