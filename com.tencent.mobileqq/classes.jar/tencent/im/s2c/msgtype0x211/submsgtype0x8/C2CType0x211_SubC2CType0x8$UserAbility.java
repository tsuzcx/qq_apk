package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class C2CType0x211_SubC2CType0x8$UserAbility
  extends MessageMicro<UserAbility>
{
  public static final int INT32_ABS_NET_REACHABLECHECK_FIELD_NUMBER = 20;
  public static final int INT32_ABS_NET_SPEED_TEST_FIELD_NUMBER = 21;
  public static final int INT32_ABS_UI_PROMPT_ONCLICK_FIELD_NUMBER = 30;
  public static final int INT32_ABS_UI_PROMPT_PASSIVE_FIELD_NUMBER = 31;
  public static final int INT32_ABS_WIFI_CLIENT_FIELD_NUMBER = 11;
  public static final int INT32_ABS_WIFI_FORCEDCONNECT_FIELD_NUMBER = 13;
  public static final int INT32_ABS_WIFI_FORCEDCREATE_FIELD_NUMBER = 12;
  public static final int INT32_ABS_WIFI_HOST_FIELD_NUMBER = 10;
  public static final int INT32_ABS_WIFI_PASSWORD_FIELD_NUMBER = 14;
  public static final int INT32_SYS_APP_FIELD_NUMBER = 3;
  public static final int INT32_SYS_QLVER_FIELD_NUMBER = 1;
  public static final int INT32_SYS_TERM_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_abs_net_reachablecheck = PBField.initInt32(0);
  public final PBInt32Field int32_abs_net_speed_test = PBField.initInt32(0);
  public final PBInt32Field int32_abs_ui_prompt_onclick = PBField.initInt32(0);
  public final PBInt32Field int32_abs_ui_prompt_passive = PBField.initInt32(0);
  public final PBInt32Field int32_abs_wifi_client = PBField.initInt32(0);
  public final PBInt32Field int32_abs_wifi_forcedconnect = PBField.initInt32(0);
  public final PBInt32Field int32_abs_wifi_forcedcreate = PBField.initInt32(0);
  public final PBInt32Field int32_abs_wifi_host = PBField.initInt32(0);
  public final PBInt32Field int32_abs_wifi_password = PBField.initInt32(0);
  public final PBInt32Field int32_sys_app = PBField.initInt32(0);
  public final PBInt32Field int32_sys_qlver = PBField.initInt32(0);
  public final PBInt32Field int32_sys_term = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 80, 88, 96, 104, 112, 160, 168, 240, 248 }, new String[] { "int32_sys_qlver", "int32_sys_term", "int32_sys_app", "int32_abs_wifi_host", "int32_abs_wifi_client", "int32_abs_wifi_forcedcreate", "int32_abs_wifi_forcedconnect", "int32_abs_wifi_password", "int32_abs_net_reachablecheck", "int32_abs_net_speed_test", "int32_abs_ui_prompt_onclick", "int32_abs_ui_prompt_passive" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, UserAbility.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.UserAbility
 * JD-Core Version:    0.7.0.1
 */