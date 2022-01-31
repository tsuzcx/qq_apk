package com.tencent.mobileqq.data;

import aukm;
import auma;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="uin")
public class ShieldListInfo
  extends aukm
{
  public static final int SHIELD_LIST_DEFAULT_SRC_SUB_ID = 0;
  public static final int SHIELD_LIST_INFO_FLAG_IS_SHIELD = 1;
  public static final int SHIELD_LIST_INFO_FLAG_NOT_SHIELD = 0;
  public static final int SHIELD_LIST_SOURCE_CONFESS = 156;
  public static final int SHIELD_LIST_SOURCE_ID_CIRCLE_GROUP = 23;
  public static final int SHIELD_LIST_SOURCE_ID_CM_GAME_TEMP = 2164;
  public static final int SHIELD_LIST_SOURCE_ID_CONTECT = 8;
  public static final int SHIELD_LIST_SOURCE_ID_CRM_EXT = 25;
  public static final int SHIELD_LIST_SOURCE_ID_CRM_TMP = 26;
  public static final int SHIELD_LIST_SOURCE_ID_DATE = 11;
  public static final int SHIELD_LIST_SOURCE_ID_DIS_TEMP = 7;
  public static final int SHIELD_LIST_SOURCE_ID_GRP_TEMP = 6;
  public static final int SHIELD_LIST_SOURCE_ID_INVALID = -1;
  public static final int SHIELD_LIST_SOURCE_ID_LBSFRIEND = 9;
  public static final int SHIELD_LIST_SOURCE_ID_OPEN_TROOP_TEMP = 132;
  public static final int SHIELD_LIST_SOURCE_ID_PC_QQ_SEARCH = 24;
  public static final int SHIELD_LIST_SOURCE_ID_RICH_STATE = 18;
  public static final int SHIELD_LIST_SOURCE_ID_STRANGER_FRIEND = 50003;
  public static final int SHIELD_LIST_SOURCE_ID_VALIDATION = 21;
  public static final int SHIELD_LIST_SOURCE_ID_WPA = 10;
  public static final int SHIELD_LIST_SOURCE_LIGHTALK = 27;
  public static final int SHIELD_LIST_SOURCE_LIMIT_CHAT = 159;
  public static final int SHIELD_LIST_SOURCE_MATCH_CHAT = 163;
  public static final int SHIELD_LIST_SOURCE_MOVIE_TICKET = 153;
  public int flags;
  public int source_id;
  public int source_sub_id;
  @auma
  public String uin;
  
  public static int AIO_TYPE_2_SOURCE_ID(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 1000: 
      return 6;
    case 1020: 
      return 132;
    case 1004: 
      return 7;
    case 1005: 
      return 10;
    case 1023: 
      return 24;
    case 1006: 
      return 8;
    case 1009: 
      return 18;
    case 1001: 
    case 10002: 
      return 9;
    case 1021: 
      return 23;
    case 1022: 
      return 21;
    case 1024: 
      return 26;
    case 1025: 
      return 25;
    case 1010: 
      return 11;
    case 1003: 
      return 50003;
    case 22: 
    case 24: 
    case 25: 
      return 27;
    case 10004: 
      return 153;
    case 1037: 
      return 159;
    case 1044: 
      return 163;
    }
    return 2164;
  }
  
  public static int SOURCE_ID_2_AIO_TYPE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 6: 
      return 1000;
    case 153: 
      return 10004;
    case 132: 
      return 1020;
    case 7: 
      return 1004;
    case 10: 
      return 1005;
    case 24: 
      return 1023;
    case 8: 
      return 1006;
    case 18: 
      return 1009;
    case 9: 
      return 1001;
    case 23: 
      return 1021;
    case 21: 
      return 1022;
    case 11: 
      return 1010;
    case 50003: 
      return 1003;
    case 27: 
      return 22;
    case 25: 
      return 1025;
    case 26: 
      return 1024;
    case 159: 
      return 1037;
    case 163: 
      return 1044;
    }
    return 1036;
  }
  
  private void shieldMsg(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.flags = i;
      return;
    }
  }
  
  public boolean isShieldMsg()
  {
    return this.flags == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ShieldListInfo
 * JD-Core Version:    0.7.0.1
 */