package com.tencent.trpcprotocol.qqexpand.entrance.entrance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Entrance$BannerManager
  extends MessageMicro<BannerManager>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "can_show", "title", "icon_url", "jump_url" }, new Object[] { Boolean.valueOf(false), "", "", "" }, BannerManager.class);
  public final PBBoolField can_show = PBField.initBool(false);
  public final PBStringField icon_url = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.BannerManager
 * JD-Core Version:    0.7.0.1
 */