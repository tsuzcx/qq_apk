package com.tencent.mobileqq.mutualmark;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.MutualMarkConfBean;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.mutualmark.alienation.MutualMarkAlienationHelper;
import com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType;
import com.tencent.mobileqq.mutualmark.info.MutualMarkConfigIRType.TypeItem;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class MutualMarkConfigHelper
{
  public static int a(AppInterface paramAppInterface, long paramLong1, long paramLong2)
  {
    Object localObject = MutualMarkConfProcessor.a().a(paramLong1);
    if ((localObject != null) && (((MutualMarkConfigIRType)localObject).a != null) && (((MutualMarkConfigIRType)localObject).a.size() > 0))
    {
      localObject = ((MutualMarkConfigIRType)localObject).a(paramLong2);
      if ((localObject != null) && (!TextUtils.isEmpty(((MutualMarkConfigIRType.TypeItem)localObject).c)))
      {
        int i = paramAppInterface.getApp().getResources().getIdentifier(((MutualMarkConfigIRType.TypeItem)localObject).c, "drawable", paramAppInterface.getApp().getPackageName());
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("MutualMarkConfigIRType.TypeItem.iconPath:");
          paramAppInterface.append(((MutualMarkConfigIRType.TypeItem)localObject).c);
          paramAppInterface.append(", imageResourceId:");
          paramAppInterface.append(i);
          QLog.i("MutualMarkConfigHelper", 2, paramAppInterface.toString());
        }
        if (i != 0) {
          return i;
        }
      }
    }
    return 0;
  }
  
  public static int a(AppInterface paramAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramAppInterface, paramString, paramLong1, paramLong2, false);
  }
  
  public static int a(AppInterface paramAppInterface, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      i = MutualMarkAlienationHelper.a(paramAppInterface, paramString, paramLong1, paramLong2);
      if (i != 0) {
        return i;
      }
    }
    int i = (int)paramLong1;
    if (i != 12)
    {
      if (i != 13) {
        if (i != 17)
        {
          if (i != 26)
          {
            if (i != 28)
            {
              switch (i)
              {
              default: 
                switch (i)
                {
                default: 
                  break;
                case 21: 
                  if (paramLong2 == 1L) {
                    return 2130850504;
                  }
                  if (paramLong2 == 2L) {
                    return 2130850505;
                  }
                  if (paramLong2 != 3L) {
                    break;
                  }
                  return 2130850506;
                case 20: 
                  if (paramLong2 == 1L) {
                    return 2130850525;
                  }
                  if (paramLong2 == 2L) {
                    return 2130850526;
                  }
                  if (paramLong2 != 3L) {
                    break;
                  }
                  return 2130850527;
                case 19: 
                  if ((!paramBoolean) || (paramLong2 != 1L)) {
                    break;
                  }
                  return 2130850535;
                }
                break;
              case 8: 
                if (paramLong2 == 1L) {
                  return 2130850538;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130850539;
              case 7: 
                if (paramLong2 == 1L) {
                  return 2130850532;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130850531;
              case 6: 
                if (paramLong2 == 1L) {
                  return 2130850544;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130850491;
              case 5: 
                if (paramLong2 == 1L)
                {
                  i = a(paramAppInterface, paramLong1, paramLong2);
                  if (i != 0) {
                    return i;
                  }
                  return 2130850540;
                }
                if (paramLong2 == 2L)
                {
                  i = a(paramAppInterface, paramLong1, paramLong2);
                  if (i != 0) {
                    return i;
                  }
                  return 2130850487;
                }
                if (paramLong2 == 3L) {
                  return 2130850500;
                }
                if (paramLong2 == 4L) {
                  return 2130850501;
                }
                if (paramLong2 == 5L) {
                  return 2130850502;
                }
                if (paramLong2 != 6L) {
                  break;
                }
                return 2130850503;
              case 4: 
                if (paramLong2 == 1L) {
                  return 2130850507;
                }
                if (paramLong2 == 2L) {
                  return 2130850508;
                }
                if (paramLong2 != 3L) {
                  break;
                }
                return 2130850509;
              case 3: 
                if (paramLong2 == 0L) {
                  return 2130850513;
                }
                if (paramLong2 == 1L) {
                  return 2130850514;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130850515;
              case 2: 
                if (paramLong2 == 0L) {
                  return 2130850510;
                }
                if (paramLong2 == 1L) {
                  return 2130850511;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130850512;
              case 1: 
                if (paramLong2 == 0L) {
                  return 2130850516;
                }
                if (paramLong2 == 1L) {
                  return 2130850517;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130850518;
              }
            }
            else
            {
              if (paramLong2 == 1L) {
                return 2130850528;
              }
              if (paramLong2 == 2L) {
                return 2130850529;
              }
              if (paramLong2 == 3L) {
                return 2130850530;
              }
            }
          }
          else
          {
            if (paramLong2 == 0L) {
              return 2130850522;
            }
            if (paramLong2 == 1L) {
              return 2130850523;
            }
            if (paramLong2 == 2L) {
              return 2130850524;
            }
          }
        }
        else if (paramLong2 == 1L) {
          return 2130850537;
        }
      }
    }
    else
    {
      if (paramLong2 == 1L) {
        return 2130850543;
      }
      if (paramLong2 == 2L) {
        return 2130850490;
      }
    }
    return 0;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, MutualMarkUtils.b(paramString2), MutualMarkUtils.a(paramString2));
  }
  
  public static MutualMarkConfigIRType a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return MutualMarkConfProcessor.a().a(paramLong);
  }
  
  public static String a(AppInterface paramAppInterface, long paramLong1, long paramLong2)
  {
    return a(paramAppInterface, MutualMarkUtils.a(paramLong1, paramLong2));
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = MutualMarkConfProcessor.a().a(paramString);
    if (paramAppInterface != null) {
      return paramAppInterface.b;
    }
    return "";
  }
  
  public static String a(AppInterface paramAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = a(paramAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return MutualMarkUtils.a(i);
    }
    return "";
  }
  
  public static String a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    return a(paramAppInterface, paramString1, MutualMarkUtils.b(paramString2), MutualMarkUtils.a(paramString2));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (MutualMarkConfProcessor.a().a(paramLong)) && (b(paramQQAppInterface, paramLong));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return (MutualMarkConfProcessor.a().a(paramLong1, paramLong2)) && (b(paramQQAppInterface, paramLong1, paramLong2));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return (!IntimateUtil.a(paramLong)) || (FriendIntimateRelationshipHelper.a(paramQQAppInterface.getCurrentUin()));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!b(paramQQAppInterface, paramLong1)) {
      return false;
    }
    return (!IntimateUtil.a(paramLong1)) || (paramLong2 <= 0L) || (FriendIntimateRelationshipHelper.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkConfigHelper
 * JD-Core Version:    0.7.0.1
 */