package tencent.im.oidb.cmd0xded;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xded$ClassifyInfo
  extends MessageMicro<ClassifyInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField icon_hover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0xded.Node node = new oidb_0xded.Node();
  public final PBRepeatMessageField<oidb_0xded.Node> second_class = PBField.initRepeatMessage(oidb_0xded.Node.class);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "node", "second_class", "icon_url", "icon_hover_url", "color" }, new Object[] { null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ClassifyInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xded.oidb_0xded.ClassifyInfo
 * JD-Core Version:    0.7.0.1
 */