package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="uin")
public class ShieldListInfo
  extends Entity
{
  public static final int SHIELD_LIST_DEFAULT_SRC_SUB_ID = 0;
  public static final int SHIELD_LIST_INFO_FLAG_IS_SHIELD = 1;
  public static final int SHIELD_LIST_INFO_FLAG_NOT_SHIELD = 0;
  public static final int SHIELD_LIST_SOURCE_AUDIO_ROOM = 167;
  public static final int SHIELD_LIST_SOURCE_CONFESS = 156;
  public static final int SHIELD_LIST_SOURCE_GAME_BUDDY = 168;
  public static final int SHIELD_LIST_SOURCE_GAME_MSG = 164;
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
  public static final int SHIELD_LIST_SOURCE_MATCH_CAMPUS_CHAT = 166;
  public static final int SHIELD_LIST_SOURCE_MATCH_CHAT = 163;
  public static final int SHIELD_LIST_SOURCE_MOVIE_TICKET = 153;
  public static final int SHIELD_LIST_SOURCE_QQ_CIRCLE = 165;
  public int flags;
  public int source_id;
  public int source_sub_id;
  @unique
  public String uin;
  
  public static int AIO_TYPE_2_SOURCE_ID(int paramInt)
  {
    int i = 25;
    if (paramInt != 22) {
      if (paramInt != 1036)
      {
        if (paramInt != 10002) {
          if (paramInt != 10004)
          {
            if ((paramInt == 24) || (paramInt == 25)) {
              break label262;
            }
            if (paramInt != 1000)
            {
              if (paramInt != 1001)
              {
                if (paramInt != 1009)
                {
                  if (paramInt != 1010)
                  {
                    if (paramInt != 1044)
                    {
                      if (paramInt != 1045)
                      {
                        switch (paramInt)
                        {
                        default: 
                          switch (paramInt)
                          {
                          default: 
                            switch (paramInt)
                            {
                            default: 
                              return -1;
                            case 10010: 
                              return 167;
                            case 10009: 
                              return 168;
                            case 10008: 
                              return 165;
                            }
                            return 164;
                          case 1024: 
                            return 26;
                          case 1023: 
                            return 24;
                          case 1022: 
                            return 21;
                          case 1021: 
                            return 23;
                          case 1020: 
                            return 132;
                          }
                        case 1006: 
                          return 8;
                        case 1005: 
                          return 10;
                        case 1004: 
                          return 7;
                        }
                        return 50003;
                      }
                      return 166;
                    }
                    return 163;
                  }
                  return 11;
                }
                return 18;
              }
            }
            else {
              return 6;
            }
          }
          else
          {
            return 153;
          }
        }
        return 9;
      }
      else
      {
        return 2164;
      }
    }
    label262:
    i = 27;
    return i;
  }
  
  public static int SOURCE_ID_2_AIO_TYPE(int paramInt)
  {
    if (paramInt != 18)
    {
      if (paramInt != 21)
      {
        if (paramInt != 132)
        {
          if (paramInt != 153)
          {
            if (paramInt != 2164)
            {
              if (paramInt != 50003)
              {
                switch (paramInt)
                {
                default: 
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      return -1;
                    case 168: 
                      return 10009;
                    case 167: 
                      return 10010;
                    case 166: 
                      return 1045;
                    case 165: 
                      return 10008;
                    case 164: 
                      return 10007;
                    }
                    return 1044;
                  case 27: 
                    return 22;
                  case 26: 
                    return 1024;
                  case 25: 
                    return 1025;
                  case 24: 
                    return 1023;
                  }
                  return 1021;
                case 11: 
                  return 1010;
                case 10: 
                  return 1005;
                case 9: 
                  return 1001;
                case 8: 
                  return 1006;
                case 7: 
                  return 1004;
                }
                return 1000;
              }
              return 1003;
            }
            return 1036;
          }
          return 10004;
        }
        return 1020;
      }
      return 1022;
    }
    return 1009;
  }
  
  private void shieldMsg(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean isShieldMsg()
  {
    return this.flags == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.ShieldListInfo
 * JD-Core Version:    0.7.0.1
 */