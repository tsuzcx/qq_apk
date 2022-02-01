package com.tencent.trpcprotocol.qqexpand.entrance.entrance;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Entrance$EntranceGetRsp
  extends MessageMicro<EntranceGetRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "res", "ctrl", "banner_mgr", "entrance_mgr", "entrance_switch_text" }, new Object[] { null, null, null, null, "" }, EntranceGetRsp.class);
  public Entrance.BannerManager banner_mgr = new Entrance.BannerManager();
  public Entrance.GetCtrl ctrl = new Entrance.GetCtrl();
  public Entrance.EntranceManager entrance_mgr = new Entrance.EntranceManager();
  public final PBStringField entrance_switch_text = PBField.initString("");
  public Entrance.Result res = new Entrance.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trpcprotocol.qqexpand.entrance.entrance.Entrance.EntranceGetRsp
 * JD-Core Version:    0.7.0.1
 */