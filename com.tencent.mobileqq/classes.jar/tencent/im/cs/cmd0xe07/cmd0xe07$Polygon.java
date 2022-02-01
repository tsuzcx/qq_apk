package tencent.im.cs.cmd0xe07;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0xe07$Polygon
  extends MessageMicro<Polygon>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "coordinates" }, new Object[] { null }, Polygon.class);
  public final PBRepeatMessageField<cmd0xe07.Coordinate> coordinates = PBField.initRepeatMessage(cmd0xe07.Coordinate.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0xe07.cmd0xe07.Polygon
 * JD-Core Version:    0.7.0.1
 */