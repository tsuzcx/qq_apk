package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class cmd0xe07$Coordinate
  extends MessageMicro<Coordinate>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field X = PBField.initInt32(0);
  public final PBInt32Field Y = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "X", "Y" }, new Object[] { localInteger, localInteger }, Coordinate.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0xe07.cmd0xe07.Coordinate
 * JD-Core Version:    0.7.0.1
 */