package tencent.im.oidb.cmd0x769;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Oidb_0x769$DeviceInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "brand", "model", "os", "cpu", "memory", "storage", "screen", "camera" }, new Object[] { "", "", null, null, null, null, null, null }, DeviceInfo.class);
  public final PBStringField brand = PBField.initString("");
  public Oidb_0x769.Camera camera = new Oidb_0x769.Camera();
  public Oidb_0x769.CPU cpu = new Oidb_0x769.CPU();
  public Oidb_0x769.Memory memory = new Oidb_0x769.Memory();
  public final PBStringField model = PBField.initString("");
  public Oidb_0x769.OS os = new Oidb_0x769.OS();
  public Oidb_0x769.Screen screen = new Oidb_0x769.Screen();
  public Oidb_0x769.Storage storage = new Oidb_0x769.Storage();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x769.Oidb_0x769.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */