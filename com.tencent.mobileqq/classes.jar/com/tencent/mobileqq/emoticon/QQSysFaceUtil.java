package com.tencent.mobileqq.emoticon;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.AnimEmoCountConfBean;
import com.tencent.mobileqq.config.business.QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.data.AniStickerResultInfo;
import com.tencent.mobileqq.data.AniStickerSurpriseInfo;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QQSysFaceUtil
{
  public static final short[] LOCALE_TO_SERVER = { 13, 12, 27, 20, 39, 38, 97, 46, 63, 5, 9, 33, 16, 18, 106, 59, 55, 112, 21, 2, 6, 4, 19, 14, 11, 10, 26, 96, 66, 116, 22, 23, 15, 0, 32, 8, 109, 28, 42, 36, 1, 108, 30, 3, 103, 49, 101, 85, 105, 34, 29, 111, 76, 77, 78, 79, 118, 64, 61, 53, 89, 113, 117, 119, 124, 122, 60, 50, 75, 81, 56, 41, 121, 120, 67, 74, 69, 57, 37, 129, 54, 24, 25, 31, 35, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 43, 86, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9 };
  public static int MAX_ANIM_EMO_COUNT = 100;
  public static int MIN_ANIM_EMO_COUNT = 10;
  public static final int NEW_SYSFACE_INDEX = 260;
  public static final short[] SERVER_TO_LOCALE = { 33, 40, 19, 43, 21, 9, 20, 106, 35, 250, 25, 24, 1, 0, 23, 32, 12, -1, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, -1, 71, 38, 95, -1, -1, 7, -1, -1, 45, 67, -1, -1, 59, 80, 16, 70, 77, -1, 15, 66, 58, -1, 8, 57, -1, 28, 74, -1, 76, -1, -1, -1, -1, 75, 68, 52, 53, 54, 55, -1, 69, -1, -1, -1, 47, 96, -1, -1, 60, -1, -1, -1, -1, -1, -1, 27, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 61, 92, 93, 29, 62, 56, 63, 73, 72, 65, 94, 64, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219 };
  private static int[] SYS_EMOTION_ORDER = { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 164, 174, 171, 165, 166, 161, 167, 170, 169, 172, 173, 168, 175, 17, 60, 61, 92, 93, 163, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 108, 109, 110, 112, 116, 118, 119, 120, 123, 130, 140, 141, 180, 184, 176, 177, 182, 179, 185, 143, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 159, 160, 214, 215, 216, 187, 209, 198, 186, 189, 212, 188, 190, 201, 210, 191, 197, 203, 205, 193, 194, 211, 204, 192, 207, 213, 202, 196, 208, 200, 206, 195, 199 };
  public static final String TAG = "SysFaceUtil";
  private static int sAnimEmoCount = -1;
  
  public static boolean containsExpression(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      if (20 == paramString.codePointAt(i)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static int convertToLocal(int paramInt)
  {
    int i = QQSysAndEmojiResMgr.getInstance().getResImpl(1).getLocalId(paramInt);
    if (i == -1)
    {
      short[] arrayOfShort = SERVER_TO_LOCALE;
      if (paramInt < arrayOfShort.length) {
        return arrayOfShort[paramInt];
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "unrecognized serverId:", Integer.valueOf(paramInt) });
      return paramInt;
    }
    return i;
  }
  
  public static int convertToServer(int paramInt)
  {
    int i = QQSysAndEmojiResMgr.getInstance().getResImpl(1).getServerId(paramInt);
    if (i == -1)
    {
      short[] arrayOfShort = LOCALE_TO_SERVER;
      if (paramInt < arrayOfShort.length) {
        return arrayOfShort[paramInt];
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
      return paramInt;
    }
    return i;
  }
  
  public static String getAniStickerFullResPath(String paramString1, String paramString2)
  {
    return QQSysAndEmojiResMgr.getAniStickerFullResPath(paramString1, paramString2);
  }
  
  @Nullable
  public static AniStickerInfo getAniStickerInfo(int paramInt)
  {
    return ((QQSysFaceResImpl)QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getAniStickerInfo(paramInt);
  }
  
  @Nullable
  public static AniStickerInfo getAniStickerInfo(int paramInt, String paramString1, String paramString2)
  {
    AniStickerInfo localAniStickerInfo = getAniStickerInfo(paramInt);
    if (localAniStickerInfo == null) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = new AniStickerResultInfo(localAniStickerInfo);
      paramString2.setResultId(paramString1);
      return paramString2;
    }
    paramString1 = localAniStickerInfo;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = new AniStickerSurpriseInfo(localAniStickerInfo);
      paramString1.setSurpriseId(paramString2);
    }
    return paramString1;
  }
  
  public static int getAnimEmoCount()
  {
    if (sAnimEmoCount == -1)
    {
      long l = System.currentTimeMillis();
      Object localObject = QQSysAndEmojiConfProcessor.a();
      if (!TextUtils.isEmpty(((QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)localObject).o.a)) {
        sAnimEmoCount = parseAnimCountByModel(((QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)localObject).o.a, Build.MODEL);
      }
      if ((sAnimEmoCount == -1) && (!TextUtils.isEmpty(((QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)localObject).o.b))) {
        sAnimEmoCount = parseAnimCountByVersion(((QQSysAndEmojiConfProcessor.SystemAndEmojiConfBean)localObject).o.b, Build.VERSION.SDK_INT);
      }
      i = sAnimEmoCount;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      ((StringBuilder)localObject).append("]");
      QLog.d("SysFaceUtil", 1, new Object[] { "animCount:", Integer.valueOf(i), ", parseCostTime = [", ((StringBuilder)localObject).toString() });
    }
    int i = sAnimEmoCount;
    int j = MIN_ANIM_EMO_COUNT;
    if (i < j)
    {
      sAnimEmoCount = j;
    }
    else
    {
      int k = MAX_ANIM_EMO_COUNT;
      if (i > k) {
        sAnimEmoCount = k;
      } else if (i == -1) {
        sAnimEmoCount = j;
      }
    }
    return sAnimEmoCount;
  }
  
  public static String getEMCode(int paramInt)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
    if ((localQQSysAndEmojiResInfo instanceof QQSysFaceResImpl)) {
      return ((QQSysFaceResImpl)localQQSysAndEmojiResInfo).getEMCode(paramInt);
    }
    return null;
  }
  
  public static String getEMCode(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
    if ((localQQSysAndEmojiResInfo instanceof QQSysFaceResImpl)) {
      return ((QQSysFaceResImpl)localQQSysAndEmojiResInfo).getEMCode(paramString);
    }
    return null;
  }
  
  public static String getFaceDescription(int paramInt)
  {
    String str2 = QQSysAndEmojiResMgr.getInstance().getResImpl(1).getDescription(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
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
    if (paramInt >= 0)
    {
      localObject = QQSysAndEmojiResMgr.getInstance().getResImpl(1).getDrawable(paramInt);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("face not found, use local res, id=");
          localStringBuilder.append(paramInt);
          QLog.d("SysFaceUtil", 2, localStringBuilder.toString());
        }
        getFaceDrawableFromLocal(paramInt);
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invaid sysface static index: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  static Drawable getFaceDrawableFromLocal(int paramInt)
  {
    Object localObject;
    if (paramInt < EmotcationConstants.VALID_SYS_EMOTCATION_COUNT)
    {
      localObject = BaseApplication.getContext().getResources();
      paramInt = EmotcationConstants.STATIC_SYS_EMOTCATION_RESOURCE[paramInt];
      if (GlobalImageCache.a != null) {
        return QQEmojiUtil.getResourceDrawableThroughImageCache((Resources)localObject, paramInt);
      }
      return ((Resources)localObject).getDrawable(paramInt);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("face not found at local, return null, id=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("SysFaceUtil", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static Drawable getFaceGifDrawable(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = null;
      QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
      if ((localQQSysAndEmojiResInfo instanceof QQSysFaceResImpl)) {
        localObject = ((QQSysFaceResImpl)localQQSysAndEmojiResInfo).getGifDrawable(paramInt);
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invaid sysface gif index: ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static final String getFaceString(int paramInt)
  {
    return String.valueOf(new char[] { '\024', (char)paramInt });
  }
  
  public static int getLocalIdFromEMCode(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
    if ((localQQSysAndEmojiResInfo instanceof QQSysFaceResImpl)) {
      return ((QQSysFaceResImpl)localQQSysAndEmojiResInfo).getLocalIdFromEMCode(paramString);
    }
    return -1;
  }
  
  public static ArrayList<Integer> getOrderList()
  {
    Object localObject = QQSysAndEmojiResMgr.getInstance().getResImpl(1).getOrderList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      return localObject;
    }
    localObject = SYS_EMOTION_ORDER;
    ArrayList localArrayList = new ArrayList(localObject.length);
    int i = 0;
    while (i < localObject.length)
    {
      localArrayList.add(Integer.valueOf(localObject[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static String getPrueFaceDescription(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    String str = paramString;
    if (paramString.startsWith("/")) {
      str = paramString.substring(1);
    }
    return str;
  }
  
  public static boolean isAniSticker(int paramInt)
  {
    return ((QQSysFaceResImpl)QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getAniStickerType(paramInt) == 1;
  }
  
  public static boolean isApolloEmoticon(int paramInt)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
    if ((localQQSysAndEmojiResInfo instanceof QQSysFaceResImpl)) {
      return ((QQSysFaceResImpl)localQQSysAndEmojiResInfo).isCMEmoji(paramInt);
    }
    return false;
  }
  
  public static boolean isEmoReady(int paramInt)
  {
    return QQSysAndEmojiResMgr.getInstance().getResImpl(1).isResReady(paramInt);
  }
  
  public static boolean isNormalSysFace(int paramInt)
  {
    return ((QQSysFaceResImpl)QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getAniStickerType(paramInt) == 0;
  }
  
  public static boolean isRandomAniSticker(int paramInt)
  {
    return ((QQSysFaceResImpl)QQSysAndEmojiResMgr.getInstance().getResImpl(1)).getAniStickerType(paramInt) == 2;
  }
  
  public static boolean isStaticFace(int paramInt)
  {
    Object localObject = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
    if ((localObject instanceof QQSysFaceResImpl)) {
      localObject = (QQSysFaceResImpl)localObject;
    }
    try
    {
      boolean bool = ((QQSysFaceResImpl)localObject).isStaticFace(paramInt);
      return bool;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      label28:
      break label28;
    }
    return false;
  }
  
  public static boolean isValidFaceId(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt != 255)
    {
      bool1 = bool2;
      if (paramInt != 511)
      {
        if (paramInt == 250) {
          return false;
        }
        bool1 = bool2;
        if (paramInt >= 0)
        {
          bool1 = bool2;
          if (paramInt <= 65535) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static int maxServerId()
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
    int i;
    if ((localQQSysAndEmojiResInfo instanceof QQSysFaceResImpl))
    {
      int j = ((QQSysFaceResImpl)localQQSysAndEmojiResInfo).getMaxServerId();
      i = j;
      if (j == 0) {
        return SERVER_TO_LOCALE.length;
      }
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  protected static int parseAnimCountByModel(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.split("\\|");
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString1[i].split(":");
        if ((arrayOfString.length == 2) && (paramString2.equalsIgnoreCase(arrayOfString[0])))
        {
          i = Integer.parseInt(arrayOfString[1]);
          return i;
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
    for (;;)
    {
      int i;
      try
      {
        paramString = paramString.split("\\|");
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          String[] arrayOfString1 = paramString[i].split(":");
          if (arrayOfString1.length != 2) {
            break label130;
          }
          String[] arrayOfString2 = arrayOfString1[0].split("-");
          if (((!TextUtils.isEmpty(arrayOfString2[0])) && (paramInt < Integer.parseInt(arrayOfString2[0]))) || ((arrayOfString2.length > 1) && (!TextUtils.isEmpty(arrayOfString2[1])) && (paramInt >= Integer.parseInt(arrayOfString2[1])))) {
            break label130;
          }
          paramInt = Integer.parseInt(arrayOfString1[1]);
          return paramInt;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("SysFaceUtil", 1, "parseAnimCountByVersion error!", paramString);
      }
      return 10;
      label130:
      i += 1;
    }
  }
  
  public static void preLoadEmoDrawable()
  {
    QQSysAndEmojiResMgr.getInstance().getResImpl(1).preLoadURLDrawable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQSysFaceUtil
 * JD-Core Version:    0.7.0.1
 */