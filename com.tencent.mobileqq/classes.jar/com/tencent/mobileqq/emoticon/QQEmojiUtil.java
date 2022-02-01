package com.tencent.mobileqq.emoticon;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import areu;
import arev;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticonview.EmojiEmoticonInfo;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class QQEmojiUtil
{
  public static final String TAG = "EmojiUtil";
  
  public static int getEmojiCount()
  {
    int j = arev.a().a(2).b();
    int i = j;
    if (j < EmotcationConstants.EMOJI_CODES.length) {
      i = EmotcationConstants.EMOJI_CODES.length;
    }
    return i;
  }
  
  public static String getEmojiDescription(int paramInt)
  {
    String str2 = arev.a().a(2).a(paramInt);
    String str1 = str2;
    if (android.text.TextUtils.isEmpty(str2))
    {
      if ((paramInt >= 0) && (paramInt < EmotcationConstants.EMOJI_CONTENT_DESC.length)) {
        str1 = EmotcationConstants.EMOJI_CONTENT_DESC[paramInt];
      }
    }
    else {
      return str1;
    }
    return "未知";
  }
  
  public static Drawable getEmojiDrawable(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji static index: " + paramInt);
    }
    Object localObject = BaseApplicationImpl.getContext().getResources();
    if (paramInt >= 1000) {
      localObject = com.tencent.mobileqq.text.TextUtils.loadEmojiFromDisk((Resources)localObject, paramInt);
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      if (paramInt < EmotcationConstants.VALID_EMOJI_COUNT)
      {
        paramInt = 2130839808 + paramInt;
        if (BaseApplicationImpl.sImageCache != null) {
          return com.tencent.mobileqq.text.TextUtils.getResourceDrawableThroughImageCache((Resources)localObject, paramInt);
        }
        return ((Resources)localObject).getDrawable(paramInt);
      }
      localDrawable = arev.a().a(2).a(paramInt);
      localObject = localDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("EmojiUtil", 2, "getEmojiDrawable in new way");
    return localDrawable;
  }
  
  public static int getEmojiLocalId(int paramInt)
  {
    int j = arev.a().a(2).b(paramInt);
    int i = j;
    if (j == -1) {
      i = EmotcationConstants.EMOJI_MAP.get(paramInt, -1);
    }
    return i;
  }
  
  public static int getEmojiUnicode(int paramInt)
  {
    int j = arev.a().a(2).a(paramInt);
    int i = j;
    if (j == -1)
    {
      if ((paramInt >= 0) && (paramInt < EmotcationConstants.EMOJI_CODES.length)) {
        i = EmotcationConstants.EMOJI_CODES[paramInt];
      }
    }
    else {
      return i;
    }
    QLog.d("EmojiUtil", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
    return j;
  }
  
  public static int getLocalIdFromEMCode(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = arev.a().a(2);
    if ((localQQSysAndEmojiResInfo instanceof areu)) {
      return ((areu)localQQSysAndEmojiResInfo).a(paramString);
    }
    return -1;
  }
  
  public static ArrayList<Integer> getOrderList()
  {
    ArrayList localArrayList = arev.a().a(2).a();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return localArrayList;
    }
    localArrayList = new ArrayList(EmojiEmoticonInfo.EMOJI_COUNT);
    int i = 0;
    while (i < EmojiEmoticonInfo.EMOJI_COUNT)
    {
      localArrayList.add(Integer.valueOf(i));
      i += 1;
    }
    return localArrayList;
  }
  
  public static boolean isEmoReady(int paramInt)
  {
    return arev.a().a(2).a(paramInt);
  }
  
  public static boolean isValidEmojiId(int paramInt)
  {
    int j = arev.a().a(2).a();
    int i = j;
    if (j <= 0) {
      i = EmotcationConstants.EMOJI_CODES.length - 1;
    }
    return (paramInt >= 0) && (paramInt <= i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.QQEmojiUtil
 * JD-Core Version:    0.7.0.1
 */