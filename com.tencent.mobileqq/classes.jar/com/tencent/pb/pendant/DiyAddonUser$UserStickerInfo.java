package com.tencent.pb.pendant;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DiyAddonUser$UserStickerInfo
  extends MessageMicro<UserStickerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56 }, new String[] { "type", "stickerid", "angle", "text", "fontid", "fontcolor", "fonttype" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0) }, UserStickerInfo.class);
  public final PBUInt32Field angle = PBField.initUInt32(0);
  public final PBStringField fontcolor = PBField.initString("");
  public final PBUInt32Field fontid = PBField.initUInt32(0);
  public final PBUInt32Field fonttype = PBField.initUInt32(0);
  public final PBUInt32Field stickerid = PBField.initUInt32(0);
  public final PBStringField text = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.pendant.DiyAddonUser.UserStickerInfo
 * JD-Core Version:    0.7.0.1
 */