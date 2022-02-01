package com.tencent.mobileqq.mutualmark;

import android.content.res.Resources;
import android.text.TextUtils;
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
  public static int a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    Object localObject = MutualMarkConfProcessor.a().a(paramLong1);
    if ((localObject != null) && (((MutualMarkConfigIRType)localObject).a != null) && (((MutualMarkConfigIRType)localObject).a.size() > 0))
    {
      localObject = ((MutualMarkConfigIRType)localObject).a(paramLong2);
      if ((localObject != null) && (!TextUtils.isEmpty(((MutualMarkConfigIRType.TypeItem)localObject).c)))
      {
        int i = paramQQAppInterface.getApp().getResources().getIdentifier(((MutualMarkConfigIRType.TypeItem)localObject).c, "drawable", paramQQAppInterface.getApp().getPackageName());
        if (QLog.isColorLevel()) {
          QLog.i("MutualMarkConfigHelper", 2, "MutualMarkConfigIRType.TypeItem.iconPath:" + ((MutualMarkConfigIRType.TypeItem)localObject).c + ", imageResourceId:" + i);
        }
        if (i != 0) {
          return i;
        }
      }
    }
    return 0;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, paramString, paramLong1, paramLong2, false);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = MutualMarkAlienationHelper.a(paramQQAppInterface, paramString, paramLong1, paramLong2);
      if (i != 0) {
        return i;
      }
    }
    switch ((int)paramLong1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  return 0;
                                  if (paramLong2 == 0L) {
                                    return 2130850590;
                                  }
                                  if (paramLong2 == 1L) {
                                    return 2130850591;
                                  }
                                } while (paramLong2 != 2L);
                                return 2130850592;
                                if (paramLong2 == 0L) {
                                  return 2130850584;
                                }
                                if (paramLong2 == 1L) {
                                  return 2130850585;
                                }
                              } while (paramLong2 != 2L);
                              return 2130850586;
                              if (paramLong2 == 0L) {
                                return 2130850596;
                              }
                              if (paramLong2 == 1L) {
                                return 2130850597;
                              }
                            } while (paramLong2 != 2L);
                            return 2130850598;
                            if (paramLong2 == 0L) {
                              return 2130850587;
                            }
                            if (paramLong2 == 1L) {
                              return 2130850588;
                            }
                          } while (paramLong2 != 2L);
                          return 2130850589;
                          if (paramLong2 == 1L) {
                            return 2130850581;
                          }
                          if (paramLong2 == 2L) {
                            return 2130850582;
                          }
                        } while (paramLong2 != 3L);
                        return 2130850583;
                        int j;
                        if (paramLong2 == 1L)
                        {
                          j = a(paramQQAppInterface, paramLong1, paramLong2);
                          i = j;
                          if (j != 0) {
                            break;
                          }
                          return 2130850614;
                        }
                        if (paramLong2 == 2L)
                        {
                          j = a(paramQQAppInterface, paramLong1, paramLong2);
                          i = j;
                          if (j != 0) {
                            break;
                          }
                          return 2130850561;
                        }
                        if (paramLong2 == 3L) {
                          return 2130850574;
                        }
                        if (paramLong2 == 4L) {
                          return 2130850575;
                        }
                        if (paramLong2 == 5L) {
                          return 2130850576;
                        }
                      } while (paramLong2 != 6L);
                      return 2130850577;
                      if (paramLong2 == 1L) {
                        return 2130850618;
                      }
                    } while (paramLong2 != 2L);
                    return 2130850565;
                    if (paramLong2 == 1L) {
                      return 2130850606;
                    }
                  } while (paramLong2 != 2L);
                  return 2130850605;
                  if (paramLong2 == 1L) {
                    return 2130850612;
                  }
                } while (paramLong2 != 2L);
                return 2130850613;
                if (paramLong2 == 1L) {
                  return 2130850617;
                }
              } while (paramLong2 != 2L);
              return 2130850564;
            } while (paramLong2 != 1L);
            return 2130850611;
          } while ((!paramBoolean) || (paramLong2 != 1L));
          return 2130850609;
          if (paramLong2 == 1L) {
            return 2130850599;
          }
          if (paramLong2 == 2L) {
            return 2130850600;
          }
        } while (paramLong2 != 3L);
        return 2130850601;
        if (paramLong2 == 1L) {
          return 2130850578;
        }
        if (paramLong2 == 2L) {
          return 2130850579;
        }
      } while (paramLong2 != 3L);
      return 2130850580;
      if (paramLong2 == 1L) {
        return 2130850602;
      }
      if (paramLong2 == 2L) {
        return 2130850603;
      }
    } while (paramLong2 != 3L);
    return 2130850604;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, MutualMarkUtils.b(paramString2), MutualMarkUtils.a(paramString2));
  }
  
  public static MutualMarkConfigIRType a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    return MutualMarkConfProcessor.a().a(paramLong);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    return a(paramQQAppInterface, MutualMarkUtils.a(paramLong1, paramLong2));
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = MutualMarkConfProcessor.a().a(paramString);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.b;
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, long paramLong1, long paramLong2)
  {
    int i = a(paramQQAppInterface, paramString, paramLong1, paramLong2);
    if (i != 0) {
      return MutualMarkUtils.a(i);
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, paramString1, MutualMarkUtils.b(paramString2), MutualMarkUtils.a(paramString2));
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
    if (!b(paramQQAppInterface, paramLong1)) {}
    while ((IntimateUtil.a(paramLong1)) && (paramLong2 > 0L) && (!FriendIntimateRelationshipHelper.a())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mutualmark.MutualMarkConfigHelper
 * JD-Core Version:    0.7.0.1
 */