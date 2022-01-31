package com.tencent.mobileqq.richstatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class richstatus_sticker$StickerInfo
  extends MessageMicro<StickerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 29, 37, 40 }, new String[] { "float_posX", "float_posY", "float_width", "float_height", "uint32_id" }, new Object[] { Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Float.valueOf(0.0F), Integer.valueOf(0) }, StickerInfo.class);
  public final PBFloatField float_height = PBField.initFloat(0.0F);
  public final PBFloatField float_posX = PBField.initFloat(0.0F);
  public final PBFloatField float_posY = PBField.initFloat(0.0F);
  public final PBFloatField float_width = PBField.initFloat(0.0F);
  public final PBUInt32Field uint32_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.richstatus_sticker.StickerInfo
 * JD-Core Version:    0.7.0.1
 */