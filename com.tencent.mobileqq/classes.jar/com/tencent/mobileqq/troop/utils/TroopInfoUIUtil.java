package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import android.text.TextUtils;

public class TroopInfoUIUtil
{
  public static Bundle a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, byte paramByte, long paramLong1, short paramShort, String paramString6, String paramString7, int paramInt2, String paramString8, String paramString9, boolean paramBoolean, String paramString10, long paramLong2, long paramLong3, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    localBundle.putInt("troop_info_from_ex", paramInt3);
    localBundle.putString("troop_code", paramString2);
    localBundle.putString("troop_info_name", paramString3);
    localBundle.putString("troop_info_owner", paramString4);
    localBundle.putString("troop_info_admi", paramString5);
    localBundle.putByte("troop_info_opt", paramByte);
    localBundle.putLong("troop_info_classext", paramLong1);
    localBundle.putShort("troop_info_faceid", paramShort);
    localBundle.putString("troop_info_fingermemo", paramString6);
    localBundle.putString("troop_info_school_location", paramString7);
    localBundle.putString("troop_info_school_schoolid", paramString8);
    localBundle.putInt("troop_info_school_grade", paramInt2);
    localBundle.putString("troop_info_loca", paramString9);
    localBundle.putBoolean("troop_info_is_member", paramBoolean);
    localBundle.putString("param_return_addr", paramString10);
    localBundle.putLong("TROOP_INFO_FLAG_EXT", paramLong2);
    localBundle.putLong("TROOP_INFO_AUTH_TYPE", paramLong3);
    return localBundle;
  }
  
  public static Bundle a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("troop_info_loca", paramString2);
    }
    localBundle.putInt("troop_info_lat", paramInt2);
    localBundle.putInt("troop_info_lon", paramInt3);
    localBundle.putInt("troop_info_cityid", paramInt4);
    return localBundle;
  }
  
  public static Bundle a(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", paramString1);
    localBundle.putInt("troop_info_from", paramInt);
    localBundle.putString("authSig", paramString2);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopInfoUIUtil
 * JD-Core Version:    0.7.0.1
 */