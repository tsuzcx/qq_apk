package com.tencent.trpcprotocol.qqva.post.post;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GestureGiftCoordinateBean$Coordinate
  extends MessageMicro<Coordinate>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field giftID = PBField.initUInt32(0);
  public final PBUInt32Field x = PBField.initUInt32(0);
  public final PBUInt32Field y = PBField.initUInt32(0);
  public final PBUInt32Field z = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "x", "y", "z", "giftID" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, Coordinate.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqva.post.post.GestureGiftCoordinateBean.Coordinate
 * JD-Core Version:    0.7.0.1
 */