package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PreloadInfoCheckUpdate$AppBehavior
  extends MessageMicro<AppBehavior>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBInt32Field click_num = PBField.initInt32(0);
  public final PBInt32Field click_red_num = PBField.initInt32(0);
  public final PBInt32Field red_state = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "appid", "click_num", "click_red_num", "red_state" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, AppBehavior.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.AppBehavior
 * JD-Core Version:    0.7.0.1
 */