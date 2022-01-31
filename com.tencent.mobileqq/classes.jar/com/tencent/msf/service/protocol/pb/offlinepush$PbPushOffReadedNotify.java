package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class offlinepush$PbPushOffReadedNotify
  extends MessageMicro
{
  public static final int CNOTIFYTYPE_FIELD_NUMBER = 1;
  public static final int SVR_IP_FIELD_NUMBER = 5;
  public static final int VC2CREADEDNOTIFY_FIELD_NUMBER = 2;
  public static final int VDISREADEDNOTIFY_FIELD_NUMBER = 4;
  public static final int VGROUPREADEDNOTIFY_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "cNotifyType", "vC2CReadedNotify", "vGroupReadedNotify", "vDisReadedNotify", "svr_ip" }, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, PbPushOffReadedNotify.class);
  public final PBUInt32Field cNotifyType = PBField.initUInt32(0);
  public final PBUInt32Field svr_ip = PBField.initUInt32(0);
  public final PBRepeatMessageField vC2CReadedNotify = PBField.initRepeatMessage(offlinepush.C2CMsgReadedNotify.class);
  public final PBRepeatMessageField vDisReadedNotify = PBField.initRepeatMessage(offlinepush.DisMsgReadedNotify.class);
  public final PBRepeatMessageField vGroupReadedNotify = PBField.initRepeatMessage(offlinepush.GroupMsgReadedNotify.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.offlinepush.PbPushOffReadedNotify
 * JD-Core Version:    0.7.0.1
 */