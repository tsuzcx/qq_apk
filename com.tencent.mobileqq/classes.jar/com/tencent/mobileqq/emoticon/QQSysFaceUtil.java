package com.tencent.mobileqq.emoticon;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import apub;
import aqbs;
import aqbu;
import arev;
import arfa;
import bblk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QQSysFaceUtil
{
  public static int MAX_ANIM_EMO_COUNT = 100;
  public static int MIN_ANIM_EMO_COUNT = 0;
  public static final int NEW_SYSFACE_INDEX = 260;
  public static final String TAG = "SysFaceUtil";
  private static int sAnimEmoCount = -1;
  
  static
  {
    MIN_ANIM_EMO_COUNT = 10;
  }
  
  public static int convertToLocal(int paramInt)
  {
    int i = arev.a().a(1).b(paramInt);
    if (i == -1)
    {
      if (paramInt < bblk.b.length) {
        return bblk.b[paramInt];
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "unrecognized serverId:", Integer.valueOf(paramInt) });
      return paramInt;
    }
    return i;
  }
  
  public static int convertToServer(int paramInt)
  {
    int i = arev.a().a(1).a(paramInt);
    if (i == -1)
    {
      if (paramInt < bblk.a.length) {
        return bblk.a[paramInt];
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
      return paramInt;
    }
    return i;
  }
  
  public static int getAnimEmoCount()
  {
    if (sAnimEmoCount == -1)
    {
      long l = System.currentTimeMillis();
      aqbu localaqbu = (aqbu)apub.a().a(545);
      if (!android.text.TextUtils.isEmpty(localaqbu.a.a)) {
        sAnimEmoCount = parseAnimCountByModel(localaqbu.a.a, Build.MODEL);
      }
      if ((sAnimEmoCount == -1) && (!android.text.TextUtils.isEmpty(localaqbu.a.b))) {
        sAnimEmoCount = parseAnimCountByVersion(localaqbu.a.b, Build.VERSION.SDK_INT);
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "animCount:", Integer.valueOf(sAnimEmoCount), ", parseCostTime = [", System.currentTimeMillis() - l + "]" });
    }
    if (sAnimEmoCount < MIN_ANIM_EMO_COUNT) {
      sAnimEmoCount = MIN_ANIM_EMO_COUNT;
    }
    for (;;)
    {
      return sAnimEmoCount;
      if (sAnimEmoCount > MAX_ANIM_EMO_COUNT) {
        sAnimEmoCount = MAX_ANIM_EMO_COUNT;
      } else if (sAnimEmoCount == -1) {
        sAnimEmoCount = MIN_ANIM_EMO_COUNT;
      }
    }
  }
  
  public static String getEMCode(int paramInt)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arev.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof arfa)) {
      return ((arfa)localQQSysAndEmojiResInfo).b(paramInt);
    }
    return null;
  }
  
  public static String getEMCode(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arev.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof arfa)) {
      return ((arfa)localQQSysAndEmojiResInfo).a(paramString);
    }
    return null;
  }
  
  public static String getFaceDescription(int paramInt)
  {
    String str2 = arev.a().a(1).a(paramInt);
    String str1 = str2;
    if (android.text.TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (paramInt < EmotcationConstants.SYS_EMOTICON_SYMBOL.length) {
        str1 = EmotcationConstants.SYS_EMOTICON_SYMBOL[paramInt];
      }
    }
    return str1;
  }
  
  public static Drawable getFaceDrawable(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid sysface static index: " + paramInt);
    }
    Object localObject;
    if (paramInt < EmotcationConstants.VALID_SYS_EMOTCATION_COUNT)
    {
      localObject = BaseApplicationImpl.getContext().getResources();
      paramInt = EmotcationConstants.STATIC_SYS_EMOTCATION_RESOURCE[paramInt];
      if (BaseApplicationImpl.sImageCache != null) {
        localObject = com.tencent.mobileqq.text.TextUtils.getResourceDrawableThroughImageCache((Resources)localObject, paramInt);
      }
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      return ((Resources)localObject).getDrawable(paramInt);
      localDrawable = arev.a().a(1).a(paramInt);
      localObject = localDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("SysFaceUtil", 2, "getFaceDrawable in new way");
    return localDrawable;
  }
  
  public static Drawable getFaceGifDrawable(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid sysface gif index: " + paramInt);
    }
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arev.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof arfa)) {
      return ((arfa)localQQSysAndEmojiResInfo).b(paramInt);
    }
    return null;
  }
  
  public static final String getFaceString(int paramInt)
  {
    return String.valueOf(new char[] { '\024', (char)paramInt });
  }
  
  public static int getLocalIdFromEMCode(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arev.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof arfa)) {
      return ((arfa)localQQSysAndEmojiResInfo).a(paramString);
    }
    return -1;
  }
  
  public static ArrayList<Integer> getOrderList()
  {
    Object localObject = arev.a().a(1).a();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      return localObject;
    }
    localObject = SystemEmoticonInfo.getSysEmotionOrder();
    ArrayList localArrayList = new ArrayList(localObject.length);
    int i = 0;
    while (i < localObject.length)
    {
      localArrayList.add(Integer.valueOf(localObject[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean isApolloEmoticon(int paramInt)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arev.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof arfa)) {
      return ((arfa)localQQSysAndEmojiResInfo).d(paramInt);
    }
    return false;
  }
  
  public static boolean isEmoReady(int paramInt)
  {
    return arev.a().a(1).a(paramInt);
  }
  
  public static boolean isStaticFace(int paramInt)
  {
    Object localObject = arev.a().a(1);
    if ((localObject instanceof arfa))
    {
      localObject = (arfa)localObject;
      try
      {
        boolean bool = ((arfa)localObject).c(paramInt);
        return bool;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        return false;
      }
    }
    return false;
  }
  
  public static boolean isValidFaceId(int paramInt)
  {
    if ((paramInt == 255) || (paramInt == 511) || (paramInt == 250)) {}
    while ((paramInt < 0) || (paramInt > 65535)) {
      return false;
    }
    return true;
  }
  
  public static int maxServerId()
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arev.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof arfa))
    {
      int j = ((arfa)localQQSysAndEmojiResInfo).c();
      int i = j;
      if (j == 0) {
        i = bblk.b.length;
      }
      return i;
    }
    return 0;
  }
  
  protected static int parseAnimCountByModel(String paramString1, String paramString2)
  {
    int i = 0;
    int k = -1;
    try
    {
      paramString1 = paramString1.split("\\|");
      int m = paramString1.length;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          String[] arrayOfString = paramString1[i].split(":");
          if ((arrayOfString.length == 2) && (paramString2.equalsIgnoreCase(arrayOfString[0]))) {
            j = Integer.parseInt(arrayOfString[1]);
          }
        }
        else
        {
          return j;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramString1)
    {
      QLog.e("SysFaceUtil", 1, "parseAnimCountByModel error!", paramString1);
    }
  }
  
  protected static int parseAnimCountByVersion(String paramString, int paramInt)
  {
    int i = 0;
    int k = 10;
    for (;;)
    {
      try
      {
        paramString = paramString.split("\\|");
        int m = paramString.length;
        int j = k;
        if (i < m)
        {
          String[] arrayOfString1 = paramString[i].split(":");
          if (arrayOfString1.length == 2)
          {
            String[] arrayOfString2 = arrayOfString1[0].split("-");
            if (((android.text.TextUtils.isEmpty(arrayOfString2[0])) || (paramInt >= Integer.parseInt(arrayOfString2[0]))) && ((arrayOfString2.length <= 1) || (android.text.TextUtils.isEmpty(arrayOfString2[1])) || (paramInt < Integer.parseInt(arrayOfString2[1])))) {
              j = Integer.parseInt(arrayOfString1[1]);
            }
          }
        }
        else
        {
          return j;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("SysFaceUtil", 1, "parseAnimCountByVersion error!", paramString);
        return 10;
      }
      i += 1;
    }
  }
  
  public static void preLoadEmoDrawable()
  {
    arev.a().a(1).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysFaceUtil
 * JD-Core Version:    0.7.0.1
 */