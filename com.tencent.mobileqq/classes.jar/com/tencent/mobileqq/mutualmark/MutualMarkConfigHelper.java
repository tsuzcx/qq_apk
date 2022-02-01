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
                    return 2130852300;
                  }
                  if (paramLong2 == 2L) {
                    return 2130852301;
                  }
                  if (paramLong2 != 3L) {
                    break;
                  }
                  return 2130852302;
                case 20: 
                  if (paramLong2 == 1L) {
                    return 2130852321;
                  }
                  if (paramLong2 == 2L) {
                    return 2130852322;
                  }
                  if (paramLong2 != 3L) {
                    break;
                  }
                  return 2130852323;
                case 19: 
                  if ((!paramBoolean) || (paramLong2 != 1L)) {
                    break;
                  }
                  return 2130852331;
                }
                break;
              case 8: 
                if (paramLong2 == 1L) {
                  return 2130852334;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130852335;
              case 7: 
                if (paramLong2 == 1L) {
                  return 2130852328;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130852327;
              case 6: 
                if (paramLong2 == 1L) {
                  return 2130852340;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130852287;
              case 5: 
                if (paramLong2 == 1L)
                {
                  i = b(paramAppInterface, paramLong1, paramLong2);
                  if (i != 0) {
                    return i;
                  }
                  return 2130852336;
                }
                if (paramLong2 == 2L)
                {
                  i = b(paramAppInterface, paramLong1, paramLong2);
                  if (i != 0) {
                    return i;
                  }
                  return 2130852283;
                }
                if (paramLong2 == 3L) {
                  return 2130852296;
                }
                if (paramLong2 == 4L) {
                  return 2130852297;
                }
                if (paramLong2 == 5L) {
                  return 2130852298;
                }
                if (paramLong2 != 6L) {
                  break;
                }
                return 2130852299;
              case 4: 
                if (paramLong2 == 1L) {
                  return 2130852303;
                }
                if (paramLong2 == 2L) {
                  return 2130852304;
                }
                if (paramLong2 != 3L) {
                  break;
                }
                return 2130852305;
              case 3: 
                if (paramLong2 == 0L) {
                  return 2130852309;
                }
                if (paramLong2 == 1L) {
                  return 2130852310;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130852311;
              case 2: 
                if (paramLong2 == 0L) {
                  return 2130852306;
                }
                if (paramLong2 == 1L) {
                  return 2130852307;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130852308;
              case 1: 
                if (paramLong2 == 0L) {
                  return 2130852312;
                }
                if (paramLong2 == 1L) {
                  return 2130852313;
                }
                if (paramLong2 != 2L) {
                  break;
                }
                return 2130852314;
              }
            }
            else
            {
              if (paramLong2 == 1L) {
                return 2130852324;
              }
              if (paramLong2 == 2L) {
                return 2130852325;
              }
              if (paramLong2 == 3L) {
                return 2130852326;
              }
            }
          }
          else
          {
            if (paramLong2 == 0L) {
              return 2130852318;
            }
            if (paramLong2 == 1L) {
              return 2130852319;
            }
            if (paramLong2 == 2L) {
              return 2130852320;
            }
          }
        }
        else if (paramLong2 == 1L) {
          return 2130852333;
        }
      }
    }
    else
    {
      if (paramLong2 == 1L) {
        return 2130852339;
      }
      if (paramLong2 == 2L) {
        return 2130852286;
      }
    }
    return 0;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return b(paramQQAppInterface, paramString1, MutualMarkUtils.b(paramString2), MutualMarkUtils.a(paramString2));
  }
  
  public static String a(AppInterface paramAppInterface, long paramLong1, long paramLong2)
  {
    return a(paramAppInterface, MutualMarkUtils.a(paramLong1, paramLong2));
  }
  
  public static String a(AppInterface paramAppInterface, String paramString)
  {
    paramAppInterface = MutualMarkConfProcessor.a().b(paramString);
    if (paramAppInterface != null) {
      return paramAppInterface.b;
    }
    return "";
  }
  
  public static String a(AppInterface paramAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = b(paramAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return MutualMarkUtils.b(i);
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
  
  public static int b(AppInterface paramAppInterface, long paramLong1, long paramLong2)
  {
    Object localObject = MutualMarkConfProcessor.a().b(paramLong1);
    if ((localObject != null) && (((MutualMarkConfigIRType)localObject).g != null) && (((MutualMarkConfigIRType)localObject).g.size() > 0))
    {
      localObject = ((MutualMarkConfigIRType)localObject).a(paramLong2);
      if ((localObject != null) && (!TextUtils.isEmpty(((MutualMarkConfigIRType.TypeItem)localObject).f)))
      {
        int i = paramAppInterface.getApp().getResources().getIdentifier(((MutualMarkConfigIRType.TypeItem)localObject).f, "drawable", paramAppInterface.getApp().getPackageName());
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("MutualMarkConfigIRType.TypeItem.iconPath:");
          paramAppInterface.append(((MutualMarkConfigIRType.TypeItem)localObject).f);
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
  
  public static int b(AppInterface paramAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramAppInterface, paramString, paramLong1, paramLong2, false);
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
  
  public static MutualMarkConfigIRType c(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return MutualMarkConfProcessor.a().b(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkConfigHelper
 * JD-Core Version:    0.7.0.1
 */