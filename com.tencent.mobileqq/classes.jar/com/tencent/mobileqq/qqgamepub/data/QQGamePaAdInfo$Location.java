package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQGamePaAdInfo$Location
  extends MessageMicro<Location>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field coordinatesType = PBField.initUInt32(0);
  public final PBInt32Field latitude = PBField.initInt32(0);
  public final PBInt32Field longitude = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "latitude", "longitude", "coordinatesType" }, new Object[] { localInteger, localInteger, localInteger }, Location.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGamePaAdInfo.Location
 * JD-Core Version:    0.7.0.1
 */