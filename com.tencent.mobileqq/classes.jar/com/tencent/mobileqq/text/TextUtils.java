package com.tencent.mobileqq.text;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.Editable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.Pair;
import android.util.SparseArray;
import android.widget.EditText;
import android.widget.TextView;
import anvx;
import aqxe;
import aqzy;
import asdi;
import awyr;
import bhbd;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;

public class TextUtils
{
  public static final String ELLIPSIS_NORMAL = "…";
  public static final int EMO_PREFIX = 20;
  public static final int FACE_REPLACE_NUM = EmotcationConstants.EMOJI_CONTENT_DESC.length;
  public static final int SPACE_POINT_CODE = 32;
  private static final String TAG = "TextUtils";
  
  public static String Symbol2FavoriteSymbol(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      localObject1 = "";
    }
    do
    {
      return localObject1;
      localObject1 = paramString;
    } while (!hasSysEmotion(paramString));
    Object localObject1 = BaseApplicationImpl.getContext();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    StringBuilder localStringBuilder;
    int j;
    int k;
    label236:
    Object localObject3;
    label242:
    String str;
    for (;;)
    {
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences("Last_Login", i).getString("uin", "");
      try
      {
        localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject1);
        if (localObject1 == null) {}
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        for (;;)
        {
          try
          {
            if ((localObject1 instanceof NearbyAppInterface)) {
              break label236;
            }
            localObject1 = (awyr)((AppInterface)localObject1).getManager(QQManagerFactory.EMOTICON_MANAGER);
            localStringBuilder = new StringBuilder(paramString);
            i = 0;
            if (i >= localStringBuilder.length()) {
              break label466;
            }
            j = i;
            if (localStringBuilder.codePointAt(i) == 20)
            {
              j = i;
              if (i < localStringBuilder.length() - 1)
              {
                k = localStringBuilder.charAt(i + 1);
                if ((!QQSysFaceUtil.isValidFaceId(k)) && (250 != k)) {
                  break label242;
                }
                j = k;
                if (250 == k) {
                  j = 10;
                }
                paramString = QQSysFaceUtil.getFaceDescription(j);
                localStringBuilder.replace(i, i + 2, paramString);
                j = i + (paramString.length() - 1);
              }
            }
            i = j + 1;
            continue;
            i = 0;
          }
          catch (Throwable localThrowable)
          {
            Object localObject2;
            localThrowable.printStackTrace();
          }
          localAccountNotMatchException = localAccountNotMatchException;
          localAccountNotMatchException.printStackTrace();
          localObject2 = null;
          continue;
          localObject3 = null;
          continue;
          j = i;
          if (k == 255)
          {
            if (i + 4 < localStringBuilder.length()) {
              break label291;
            }
            paramString = QQText.SMALL_EMOJI_SYMBOL;
            localStringBuilder.replace(i, localStringBuilder.length(), paramString);
            i += paramString.length() - 1;
          }
        }
        label291:
        paramString = new char[4];
        paramString[0] = localStringBuilder.charAt(i + 4);
        paramString[1] = localStringBuilder.charAt(i + 3);
        paramString[2] = localStringBuilder.charAt(i + 2);
        paramString[3] = localStringBuilder.charAt(i + 1);
        j = 0;
        if (j < 3)
        {
          if (paramString[j] == 'ú') {
            paramString[j] = 10;
          }
          for (;;)
          {
            j += 1;
            break;
            if (paramString[j] == 'þ') {
              paramString[j] = 13;
            }
          }
        }
        paramString = asdi.a(paramString);
        str = QQText.SMALL_EMOJI_SYMBOL;
        if (paramString == null) {
          break label477;
        }
      }
    }
    if (paramString.length == 2)
    {
      k = paramString[0];
      j = paramString[1];
    }
    for (;;)
    {
      if (localObject3 != null) {}
      for (paramString = localObject3.a(Integer.toString(k), Integer.toString(j));; paramString = null)
      {
        if (paramString != null) {
          str = paramString.character;
        }
        localStringBuilder.replace(i, i + 5, str);
        j = i + (str.length() - 1);
        break;
        label466:
        return localStringBuilder.toString();
      }
      label477:
      j = 0;
      k = 0;
    }
  }
  
  public static String adjustEllipsizeEndText(TextView paramTextView, String paramString, int paramInt)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      paramTextView = "";
    }
    int j;
    do
    {
      return paramTextView;
      paramTextView.getLayout();
      int m = (int)Layout.getDesiredWidth("...", paramTextView.getPaint());
      int k = paramString.codePointCount(0, paramString.length());
      j = paramString.length();
      for (int i = (int)Layout.getDesiredWidth(paramString.subSequence(0, j), paramTextView.getPaint()) + 1; (k > 0) && (i > paramInt - m - 1); i = (int)Layout.getDesiredWidth(paramString.subSequence(0, j), paramTextView.getPaint()) + 1)
      {
        k -= 1;
        j = paramString.offsetByCodePoints(0, k);
      }
      paramTextView = paramString;
    } while (j == paramString.length());
    return paramString.substring(0, j) + "...";
  }
  
  public static final void backspace(EditText paramEditText)
  {
    try
    {
      Editable localEditable = paramEditText.getText();
      int j = paramEditText.getSelectionStart();
      int i = 0;
      if (j > 1) {
        i = android.text.TextUtils.getOffsetBefore(paramEditText.getText(), j);
      }
      if (j != i) {
        localEditable.delete(Math.min(j, i), Math.max(j, i));
      }
      return;
    }
    catch (Exception paramEditText)
    {
      paramEditText.printStackTrace();
    }
  }
  
  public static String cToe(String paramString)
  {
    int i = 0;
    String[] arrayOfString = new String[40];
    arrayOfString[0] = "！";
    arrayOfString[1] = "，";
    arrayOfString[2] = "。";
    arrayOfString[3] = "；";
    arrayOfString[4] = "~";
    arrayOfString[5] = "《";
    arrayOfString[6] = "》";
    arrayOfString[7] = "（";
    arrayOfString[8] = "）";
    arrayOfString[9] = "？";
    arrayOfString[10] = "”";
    arrayOfString[11] = "｛";
    arrayOfString[12] = "｝";
    arrayOfString[13] = "“";
    arrayOfString[14] = "：";
    arrayOfString[15] = "【";
    arrayOfString[16] = "】";
    arrayOfString[17] = "”";
    arrayOfString[18] = "‘";
    arrayOfString[19] = "’";
    arrayOfString[20] = "!";
    arrayOfString[21] = ",";
    arrayOfString[22] = ".";
    arrayOfString[23] = ";";
    arrayOfString[24] = "`";
    arrayOfString[25] = "<";
    arrayOfString[26] = ">";
    arrayOfString[27] = "(";
    arrayOfString[28] = ")";
    arrayOfString[29] = "?";
    arrayOfString[30] = "'";
    arrayOfString[31] = "{";
    arrayOfString[32] = "}";
    arrayOfString[33] = "\"";
    arrayOfString[34] = ":";
    arrayOfString[35] = "{";
    arrayOfString[36] = "}";
    arrayOfString[37] = "\"";
    arrayOfString[38] = "'";
    arrayOfString[39] = "'";
    while (i < arrayOfString.length / 2)
    {
      paramString = paramString.replaceAll(arrayOfString[i], arrayOfString[(arrayOfString.length / 2 + i)]);
      i += 1;
    }
    return paramString;
  }
  
  public static void compoundEllipsize(TextView paramTextView, String paramString1, int paramInt1, TextUtils.TruncateAt paramTruncateAt, String paramString2, int paramInt2)
  {
    if ((paramTextView == null) || (android.text.TextUtils.isEmpty(paramString1))) {
      return;
    }
    int i = paramInt1 - paramInt2;
    float f1 = paramTextView.getPaint().measureText(paramString1);
    if (i >= f1)
    {
      paramTextView.setText(paramString1);
      return;
    }
    if (paramTruncateAt == TextUtils.TruncateAt.END)
    {
      CharSequence localCharSequence = android.text.TextUtils.ellipsize(paramString1, paramTextView.getPaint(), i, paramTruncateAt);
      f1 = paramTextView.getPaint().measureText((String)localCharSequence);
      f2 = paramTextView.getPaint().measureText("的");
      paramString2 = localCharSequence;
      if (i - f1 > f2 / 2.0F)
      {
        paramString2 = localCharSequence;
        if (paramInt2 != 0)
        {
          paramInt2 = (int)(i + f2);
          paramTextView.setMaxWidth((int)(paramInt1 + f2));
          paramString2 = android.text.TextUtils.ellipsize(paramString1, paramTextView.getPaint(), paramInt2, paramTruncateAt);
        }
      }
      paramTextView.setText(paramString2);
      return;
    }
    if ((paramTruncateAt != TextUtils.TruncateAt.MIDDLE) || (android.text.TextUtils.isEmpty(paramString2)))
    {
      paramTextView.setEllipsize(paramTruncateAt);
      return;
    }
    paramInt1 = paramString1.lastIndexOf(paramString2);
    if (paramInt1 == -1)
    {
      paramTextView.setText(paramString1);
      return;
    }
    paramTruncateAt = paramString1.substring(0, paramInt1);
    paramString2 = "…" + paramString1.substring(paramInt1);
    f1 = paramTextView.getPaint().measureText(paramTruncateAt);
    float f2 = paramTextView.getPaint().measureText(paramString2);
    if (f2 > i)
    {
      paramTextView.setText(paramString1);
      return;
    }
    while (i - f1 < f2)
    {
      paramTruncateAt = paramTruncateAt.substring(0, paramTruncateAt.length() - 1);
      f1 = paramTextView.getPaint().measureText(paramTruncateAt);
    }
    paramTextView.setText(paramTruncateAt + paramString2);
  }
  
  public static String emoticonToText(String paramString)
  {
    String str1;
    if (android.text.TextUtils.isEmpty(paramString)) {
      str1 = "";
    }
    int j;
    int i;
    int k;
    do
    {
      return str1;
      j = QQEmojiUtil.getEmojiCount();
      i = 0;
      while (i < j)
      {
        k = paramString.indexOf(QQEmojiUtil.getEmojiUnicode(i), 0);
        str1 = paramString;
        if (k != -1)
        {
          str1 = paramString;
          if (k + 2 <= paramString.length()) {
            str1 = paramString.replace(paramString.substring(k, k + 2), QQEmojiUtil.getEmojiDescription(i));
          }
        }
        i += 1;
        paramString = str1;
      }
      str1 = paramString;
    } while (!hasSysEmotion(paramString));
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    paramString = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    for (;;)
    {
      paramString = paramString.getSharedPreferences("Last_Login", i).getString("uin", "");
      str1 = null;
      try
      {
        paramString = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
        if (paramString != null)
        {
          for (;;)
          {
            try
            {
              if ((paramString instanceof NearbyAppInterface)) {
                break label527;
              }
              paramString = (awyr)paramString.getManager(QQManagerFactory.EMOTICON_MANAGER);
              i = 0;
              str1 = paramString;
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
              i = 0;
              continue;
              j = i;
              if (k != 255) {
                continue;
              }
              if (i + 4 < localStringBuilder.length()) {
                continue;
              }
              paramString = QQText.SMALL_EMOJI_SYMBOL;
              localStringBuilder.replace(i, localStringBuilder.length(), paramString);
              i += paramString.length() - 1;
              continue;
              paramString = new char[4];
              paramString[0] = localStringBuilder.charAt(i + 4);
              paramString[1] = localStringBuilder.charAt(i + 3);
              paramString[2] = localStringBuilder.charAt(i + 2);
              paramString[3] = localStringBuilder.charAt(i + 1);
              j = 0;
              if (j >= 3) {
                continue;
              }
              if (paramString[j] != 'ú') {
                continue;
              }
              paramString[j] = 10;
              j += 1;
              continue;
              if (paramString[j] != 'þ') {
                continue;
              }
              paramString[j] = 13;
              continue;
              paramString = asdi.a(paramString);
              if (paramString == null) {
                break label520;
              }
            }
            if (i >= localStringBuilder.length()) {
              break label508;
            }
            j = i;
            if (localStringBuilder.codePointAt(i) == 20)
            {
              j = i;
              if (i < localStringBuilder.length() - 1)
              {
                k = localStringBuilder.charAt(i + 1);
                if (!QQSysFaceUtil.isValidFaceId(k)) {
                  continue;
                }
                paramString = QQSysFaceUtil.getFaceDescription(k);
                localStringBuilder.replace(i, i + 2, paramString);
                j = i + (paramString.length() - 1);
              }
            }
            i = j + 1;
          }
          i = 0;
        }
      }
      catch (AccountNotMatchException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
          continue;
          if (paramString.length == 2)
          {
            k = paramString[0];
            j = paramString[1];
          }
          for (;;)
          {
            if (str1 != null) {}
            for (paramString = str1.a(Integer.toString(k), Integer.toString(j));; paramString = "")
            {
              String str2 = paramString;
              if (android.text.TextUtils.isEmpty(paramString)) {
                str2 = QQText.SMALL_EMOJI_SYMBOL;
              }
              localStringBuilder.replace(i, i + 5, str2);
              j = i + (str2.length() - 1);
              break;
              label508:
              return localStringBuilder.toString();
            }
            label520:
            j = 0;
            k = 0;
          }
          label527:
          paramString = null;
        }
      }
    }
  }
  
  public static String emoticonToTextForTalkBack(String paramString)
  {
    Object localObject;
    if (android.text.TextUtils.isEmpty(paramString))
    {
      localObject = "";
      return localObject;
    }
    int i = 0;
    int k;
    while (i < FACE_REPLACE_NUM)
    {
      k = paramString.indexOf(EmotcationConstants.EMOJI_CODES[i], 0);
      localObject = paramString;
      if (k != -1)
      {
        if (k >= paramString.length()) {
          localObject = paramString;
        }
      }
      else
      {
        label53:
        i += 1;
        paramString = (String)localObject;
        continue;
      }
      if (paramString.codePointAt(k) <= 65535) {
        break label652;
      }
    }
    label649:
    label652:
    for (int j = 2;; j = 1)
    {
      localObject = paramString;
      if (k == -1) {
        break label53;
      }
      localObject = paramString;
      if (k + j > paramString.length()) {
        break label53;
      }
      localObject = EmotcationConstants.getEmojiDesc(i);
      localObject = paramString.replace(paramString.substring(k, j + k), (CharSequence)localObject);
      break label53;
      localObject = paramString;
      if (!hasSysEmotion(paramString)) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      paramString = BaseApplicationImpl.getContext();
      if (Build.VERSION.SDK_INT > 10) {
        i = 4;
      }
      for (;;)
      {
        paramString = paramString.getSharedPreferences("Last_Login", i).getString("uin", "");
        try
        {
          paramString = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
          if (paramString == null) {}
        }
        catch (AccountNotMatchException paramString)
        {
          for (;;)
          {
            try
            {
              if ((paramString instanceof NearbyAppInterface)) {
                break label376;
              }
              paramString = (awyr)paramString.getManager(QQManagerFactory.EMOTICON_MANAGER);
              k = 0;
              i = 0;
              if (i >= localStringBuilder.length()) {
                break label630;
              }
              if ((localStringBuilder.codePointAt(i) != 20) || (i >= localStringBuilder.length() - 1)) {
                break label625;
              }
              j = localStringBuilder.charAt(i + 1);
              m = j;
              if (j == 250) {
                m = 10;
              }
              if (!QQSysFaceUtil.isValidFaceId(m)) {
                break label381;
              }
              localObject = QQSysFaceUtil.getFaceDescription(m);
              if (k != 0) {
                break label649;
              }
              localObject = anvx.a(2131714265) + (String)localObject;
              localStringBuilder.replace(i, i + 2, (String)localObject);
              j = i + (((String)localObject).length() - 1);
              k = 1;
              i = j;
              j = k;
              i += 1;
              k = j;
              continue;
              i = 0;
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
            }
            paramString = paramString;
            paramString.printStackTrace();
            paramString = null;
          }
        }
        catch (ClassCastException paramString)
        {
          for (;;)
          {
            int m;
            label337:
            paramString.printStackTrace();
            paramString = null;
            continue;
            label376:
            paramString = null;
            continue;
            label381:
            j = i;
            if (m == 255) {
              if (i + 4 >= localStringBuilder.length())
              {
                localObject = QQText.SMALL_EMOJI_SYMBOL;
                localStringBuilder.replace(i, localStringBuilder.length(), (String)localObject);
                i += ((String)localObject).length() - 1;
              }
              else
              {
                localObject = new char[4];
                localObject[0] = localStringBuilder.charAt(i + 4);
                localObject[1] = localStringBuilder.charAt(i + 3);
                localObject[2] = localStringBuilder.charAt(i + 2);
                localObject[3] = localStringBuilder.charAt(i + 1);
                j = 0;
                if (j < 3)
                {
                  if (localObject[j] == 'ú') {
                    localObject[j] = 10;
                  }
                  for (;;)
                  {
                    j += 1;
                    break;
                    if (localObject[j] == 'þ') {
                      localObject[j] = 13;
                    }
                  }
                }
                localObject = asdi.a((char[])localObject);
                String str = QQText.SMALL_EMOJI_SYMBOL;
                if ((localObject != null) && (localObject.length == 2))
                {
                  k = localObject[0];
                  j = localObject[1];
                }
                for (;;)
                {
                  if (paramString != null) {}
                  for (localObject = paramString.a(Integer.toString(k), Integer.toString(j));; localObject = null)
                  {
                    if (localObject != null) {
                      str = ((Emoticon)localObject).character;
                    }
                    localStringBuilder.replace(i, i + 5, str);
                    j = i + (str.length() - 1);
                    break;
                    label625:
                    j = 0;
                    break label337;
                    label630:
                    return localStringBuilder.toString();
                  }
                  j = 0;
                  k = 0;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static String emoticonToTextWithoutSysEmotion(String paramString)
  {
    localStringBuilder = new StringBuilder(paramString);
    str1 = null;
    for (;;)
    {
      try
      {
        paramString = BaseApplicationImpl.getContext();
        if (Build.VERSION.SDK_INT <= 10) {
          continue;
        }
        i = 4;
        paramString = paramString.getSharedPreferences("Last_Login", i).getString("uin", "");
        paramString = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
      }
      catch (Exception paramString)
      {
        int i;
        paramString.printStackTrace();
        paramString = null;
        continue;
        if (paramString.length != 2) {
          continue;
        }
        int k = paramString[0];
        int j = paramString[1];
        if (str1 == null) {
          continue;
        }
        paramString = str1.a(Integer.toString(k), Integer.toString(j));
        String str2 = paramString;
        if (!android.text.TextUtils.isEmpty(paramString)) {
          continue;
        }
        str2 = QQText.SMALL_EMOJI_SYMBOL;
        localStringBuilder.replace(i, i + 5, str2);
        j = i + (str2.length() - 1);
        continue;
        return localStringBuilder.toString();
        paramString = "";
        continue;
        j = 0;
        k = 0;
        continue;
        paramString = null;
        continue;
      }
      if (paramString == null) {
        continue;
      }
      try
      {
        if ((paramString instanceof NearbyAppInterface)) {
          continue;
        }
        paramString = (awyr)paramString.getManager(QQManagerFactory.EMOTICON_MANAGER);
        i = 0;
        str1 = paramString;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        i = 0;
        continue;
        j = i;
        if (k != 255) {
          continue;
        }
        if (i + 4 < localStringBuilder.length()) {
          continue;
        }
        paramString = QQText.SMALL_EMOJI_SYMBOL;
        localStringBuilder.replace(i, localStringBuilder.length(), paramString);
        i += paramString.length() - 1;
        continue;
        paramString = new char[4];
        paramString[0] = localStringBuilder.charAt(i + 4);
        paramString[1] = localStringBuilder.charAt(i + 3);
        paramString[2] = localStringBuilder.charAt(i + 2);
        paramString[3] = localStringBuilder.charAt(i + 1);
        j = 0;
        if (j >= 3) {
          continue;
        }
        if (paramString[j] != 'ú') {
          continue;
        }
        paramString[j] = 10;
        j += 1;
        continue;
        if (paramString[j] != 'þ') {
          continue;
        }
        paramString[j] = 13;
        continue;
        paramString = asdi.a(paramString);
        if (paramString == null) {
          continue;
        }
      }
      if (i >= localStringBuilder.length()) {
        continue;
      }
      j = i;
      if (localStringBuilder.codePointAt(i) == 20)
      {
        j = i;
        if (i < localStringBuilder.length() - 1)
        {
          k = localStringBuilder.charAt(i + 1);
          if (!QQSysFaceUtil.isValidFaceId(k)) {
            continue;
          }
          paramString = QQSysFaceUtil.getFaceDescription(k);
          localStringBuilder.replace(i, i + 2, paramString);
          j = i + (paramString.length() - 1);
        }
      }
      i = j + 1;
      continue;
      i = 0;
    }
  }
  
  public static void fixTextViewANRForAnd10(TextView paramTextView)
  {
    if ((Build.VERSION.SDK_INT >= 29) && (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))) {}
    try
    {
      if (!((aqzy)aqxe.a().a(566)).c) {
        paramTextView.setBreakStrategy(0);
      }
      return;
    }
    catch (Throwable paramTextView)
    {
      QLog.e("TextUtils", 1, paramTextView, new Object[0]);
    }
  }
  
  public static String getColorNickSysEmoticonString(int paramInt)
  {
    return String.valueOf(new char[] { '<', '$', (char)QQSysFaceUtil.convertToServer(paramInt), '>' });
  }
  
  public static final Drawable getEmojiDrawable(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji index: " + paramInt);
    }
    int j = 2130839942;
    if (paramInt >= 1000) {
      return loadEmojiFromDisk(BaseApplicationImpl.getContext().getResources(), paramInt);
    }
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < EmotcationConstants.VALID_EMOJI_COUNT) {
        i = 2130839808 + paramInt;
      }
    }
    if (BaseApplicationImpl.sImageCache != null) {
      return getResourceDrawableThroughImageCache(BaseApplicationImpl.getContext().getResources(), i);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(i);
  }
  
  public static final Drawable getEmojiDrawable(int paramInt, TextUtils.LoadSysEmojiCallback paramLoadSysEmojiCallback)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji index: " + paramInt);
    }
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    Object localObject;
    if (paramInt >= 1000)
    {
      localObject = "emotion://" + paramInt;
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject = (Pair)BaseApplicationImpl.sImageCache.get(localObject);
        if ((localObject != null) && (((Pair)localObject).first != null)) {
          return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(localResources);
        }
      }
      ThreadManager.executeOnFileThread(new TextUtils.1(paramInt, paramLoadSysEmojiCallback));
      return null;
    }
    if ((paramInt >= 0) && (paramInt < EmotcationConstants.VALID_EMOJI_COUNT)) {}
    for (paramInt = 2130839808 + paramInt;; paramInt = 2130839942)
    {
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject = "android.resource://" + paramInt;
        localObject = (Pair)BaseApplicationImpl.sImageCache.get(localObject);
        if ((localObject != null) && (((Pair)localObject).first != null)) {
          return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(localResources);
        }
        ThreadManager.executeOnFileThread(new TextUtils.2(paramInt, paramLoadSysEmojiCallback));
        return null;
      }
      return BaseApplicationImpl.getContext().getResources().getDrawable(paramInt);
    }
  }
  
  public static final String getEmojiString(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.EMOJI_CODES.length)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return String.valueOf(Character.toChars(EmotcationConstants.EMOJI_CODES[paramInt]));
  }
  
  public static String getNeoTextAfter(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt2 * 4;
    int k;
    int m;
    int j;
    if (paramInt1 + i <= paramString.length())
    {
      k = i + paramInt1;
      m = paramInt1;
      j = 0;
      i = paramInt1;
      label31:
      if (m >= k) {
        break label327;
      }
      i = paramString.codePointAt(m);
      if ((i != 20) || (m + 1 >= k)) {
        break label287;
      }
      if ((paramString.charAt(m + 1) < 'ÿ') || (m + 4 >= k)) {
        break label278;
      }
      i = m + 4;
      label91:
      if (QLog.isColorLevel()) {
        QLog.d("TextUtils", 2, new Object[] { "subStringLength= ", Integer.valueOf(i), " start=", Integer.valueOf(paramInt1) });
      }
      j += 1;
      if (j < paramInt2) {
        break label300;
      }
    }
    label278:
    label287:
    label300:
    label327:
    for (;;)
    {
      if (j < paramInt2) {
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TextUtils", 2, new Object[] { "loopTime= ", Integer.valueOf(j), " start=", Integer.valueOf(paramInt1) });
        }
        String str = paramString.substring(paramInt1, paramInt2);
        paramString = str;
        if (paramBoolean) {
          if (!str.contains("\n"))
          {
            paramString = str;
            if (!str.contains("\r")) {}
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("TextUtils", 2, new Object[] { "cutString=", str });
            }
            paramString = "";
          }
        }
        return paramString;
        k = paramString.length();
        break;
        i = m + 2;
        break label91;
        i = Character.charCount(i) + m;
        break label91;
        m = i;
        break label31;
        paramInt2 = i;
        if (i > paramString.length()) {
          paramInt2 = paramString.length();
        }
      }
    }
  }
  
  public static String getNeoTextBefore(String paramString, int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = paramInt2 * 4;
    SparseArray localSparseArray;
    int j;
    label27:
    int m;
    if (paramInt1 - i <= 0)
    {
      i = 0;
      localSparseArray = new SparseArray();
      j = 0;
      if (i >= paramInt1) {
        break label164;
      }
      localSparseArray.put(j, Integer.valueOf(i));
      if (QLog.isColorLevel()) {
        QLog.d("TextUtils", 2, new Object[] { "getNeoTextBefore subStringLength= ", Integer.valueOf(i), " end:", Integer.valueOf(paramInt1) });
      }
      m = paramString.codePointAt(i);
      if ((m != 20) || (i + 1 >= paramInt1)) {
        break label153;
      }
      if ((paramString.charAt(i + 1) < 'ÿ') || (i + 4 >= paramInt1)) {
        break label146;
      }
      i += 4;
    }
    for (;;)
    {
      j += 1;
      break label27;
      i = paramInt1 - i;
      break;
      label146:
      i += 2;
      continue;
      label153:
      i += Character.charCount(m);
    }
    label164:
    if (localSparseArray.size() - paramInt2 >= 0)
    {
      j = ((Integer)localSparseArray.get(localSparseArray.size() - paramInt2)).intValue();
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("TextUtils", 2, new Object[] { "getNeoTextBefore from Array subStringLength= ", Integer.valueOf(j), " loopTime - maxContentLength:", Integer.valueOf(localSparseArray.size() - paramInt2) });
      }
    }
    for (i = j;; i = paramInt1)
    {
      if (i < 0) {}
      for (paramInt2 = k;; paramInt2 = i) {
        return paramString.substring(paramInt2, paramInt1);
      }
    }
  }
  
  public static int getQQTextCharCount(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0;
    }
    int i3 = paramString.length();
    int k = 0;
    int n = 0;
    int i4;
    int i;
    int j;
    int m;
    if (n < i3)
    {
      i4 = paramString.codePointAt(n);
      if (((paramInt & 0x6) > 0) && (i4 == 20) && (n < i3 - 1))
      {
        i = paramString.charAt(n + 1);
        if (QQSysFaceUtil.isValidFaceId(i))
        {
          j = 1;
          i = k + 1;
          m = 2;
          k = j;
          j = m;
        }
        for (;;)
        {
          m = i;
          if (k == 0)
          {
            m = i + 1;
            j = 1;
          }
          k = m;
          n = j + n;
          break;
          if ((i >= 255) && (n + 4 < i3))
          {
            j = 4;
            m = 1;
            i = k + 1;
            k = m;
          }
          else
          {
            if (i != 250) {
              break label449;
            }
            m = 1;
            i = k + 1;
            j = 2;
            k = m;
          }
        }
      }
      if ((paramInt & 0x1) != 1) {
        break label449;
      }
      m = EmotcationConstants.getSingleEmoji(i4);
      if (i4 > 65535)
      {
        if (i3 <= n + 2) {
          break label485;
        }
        j = paramString.codePointAt(n + 2);
        i = 0;
      }
    }
    for (;;)
    {
      label222:
      if (EmotcationConstants.isSkinEmoji(j)) {}
      for (int i1 = 1;; i1 = 0)
      {
        label257:
        int i2;
        if ((m == -1) || (i1 != 0))
        {
          i1 = EmotcationConstants.getDoubleEmoji(i4, j);
          if (i1 == -1)
          {
            i2 = 1;
            i1 = m;
          }
        }
        for (m = i2;; m = 0)
        {
          if (i1 != -1)
          {
            if (m != 0) {
              if ((i4 > 65535) && (i3 >= n + 2))
              {
                m = 2;
                label299:
                if ((j <= 65535) || (i3 < n + 2)) {
                  break label406;
                }
                j = m + 2;
                label320:
                if (i == 0) {
                  break label444;
                }
                i = j + 1;
              }
            }
            for (;;)
            {
              m = 1;
              j = i;
              i = k + 1;
              k = m;
              break;
              if (i3 <= n + 1) {
                break label485;
              }
              j = paramString.codePointAt(n + 1);
              if ((j != 65039) || (i3 <= n + 2)) {
                break label480;
              }
              j = paramString.codePointAt(n + 2);
              i = 1;
              break label222;
              m = i1;
              break label257;
              m = 1;
              break label299;
              label406:
              j = m + 1;
              break label320;
              if ((i4 > 65535) && (i3 >= n + 2))
              {
                i = 2;
              }
              else
              {
                i = 1;
                continue;
                return k;
                label444:
                i = j;
              }
            }
          }
          label449:
          m = 0;
          i = k;
          j = 0;
          k = m;
          break;
          i1 = m;
        }
      }
      label480:
      i = 0;
      continue;
      label485:
      i = 0;
      j = -1;
    }
  }
  
  public static Drawable getResourceDrawableThroughImageCache(Resources paramResources, int paramInt)
  {
    String str = "android.resource://" + paramInt;
    Object localObject = (Pair)BaseApplicationImpl.sImageCache.get(str);
    if (localObject != null) {
      paramResources = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramResources);
    }
    for (;;)
    {
      return paramResources;
      try
      {
        localObject = paramResources.getDrawable(paramInt);
        paramInt = bhbd.a((Drawable)localObject);
        paramResources = (Resources)localObject;
        if (paramInt > 0)
        {
          BaseApplicationImpl.sImageCache.put(str, new Pair(((Drawable)localObject).getConstantState(), Integer.valueOf(paramInt)));
          return localObject;
        }
      }
      catch (Exception paramResources) {}
    }
    return null;
  }
  
  public static String getStringWithoutEmoji(String paramString)
  {
    int i = hasEmoji(paramString);
    if (i != -1)
    {
      if (i + 2 > paramString.length()) {}
      for (int j = paramString.length();; j = i + 2)
      {
        paramString = paramString.replace(paramString.substring(i, j), "");
        i = hasEmoji(paramString);
        break;
      }
    }
    return paramString;
  }
  
  public static final String getSysEmotcationDisplayString(int paramInt)
  {
    return QQSysFaceUtil.getFaceDescription(paramInt);
  }
  
  public static final Drawable getSysEmotcationDrawable(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return QQSysFaceUtil.getFaceDrawable(paramInt);
    }
    return QQSysFaceUtil.getFaceGifDrawable(paramInt);
  }
  
  public static final String getSysEmotcationString(int paramInt)
  {
    return QQSysFaceUtil.getFaceString(paramInt);
  }
  
  public static String getTextWithoutEmoji(String paramString)
  {
    Object localObject2;
    if (android.text.TextUtils.isEmpty(paramString)) {
      localObject2 = null;
    }
    Object localObject1;
    int k;
    int i;
    do
    {
      return localObject2;
      localObject1 = "";
      k = paramString.length();
      i = 0;
      localObject2 = localObject1;
    } while (i >= k);
    int j;
    if (paramString.codePointAt(i) == 20)
    {
      j = i;
      localObject2 = localObject1;
      if (i < k - 1)
      {
        if (paramString.charAt(i + 1) >= 'ÿ') {
          break label88;
        }
        j = i + 1;
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      i = j + 1;
      localObject1 = localObject2;
      break;
      label88:
      j = i + 4;
      localObject2 = localObject1;
      continue;
      localObject2 = (String)localObject1 + paramString.charAt(i);
      j = i;
    }
  }
  
  public static boolean hasChnChar(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramCharSequence.length())
      {
        int j = Integer.parseInt(Integer.toHexString(paramCharSequence.charAt(i)), 16);
        if ((j >= 19968) && (j <= 40891)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static int hasEmoji(String paramString)
  {
    int j;
    if (android.text.TextUtils.isEmpty(paramString)) {
      j = -1;
    }
    int i;
    int k;
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
                                  return j;
                                  i = 0;
                                  if (i >= paramString.length()) {
                                    break label245;
                                  }
                                  k = paramString.charAt(i);
                                  if (k < 8448) {
                                    break;
                                  }
                                  j = i;
                                } while (k <= 10239);
                                if (k < 10548) {
                                  break;
                                }
                                j = i;
                              } while (k <= 10549);
                              if (k < 11013) {
                                break;
                              }
                              j = i;
                            } while (k <= 11015);
                            if (k < 11035) {
                              break;
                            }
                            j = i;
                          } while (k <= 11036);
                          j = i;
                        } while (k == 169);
                        j = i;
                      } while (k == 174);
                      j = i;
                    } while (k == 8252);
                    j = i;
                  } while (k == 8265);
                  j = i;
                } while (k == 11088);
                j = i;
              } while (k == 11093);
              j = i;
            } while (k == 12336);
            j = i;
          } while (k == 12349);
          j = i;
        } while (k == 12951);
        j = i;
      } while (k == 12953);
      if ((k < 55296) || (k > 56319) || (i >= paramString.length() - 1)) {
        break label236;
      }
      k = paramString.charAt(i + 1);
      if (k < 56320) {
        break;
      }
      j = i;
    } while (k <= 57343);
    label236:
    while (k != 8419)
    {
      i += 1;
      break;
    }
    return i;
    label245:
    return -1;
  }
  
  public static boolean hasSysEmotion(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    while (-1 == paramString.indexOf('\024')) {
      return false;
    }
    return true;
  }
  
  public static String hideUinInShowString(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder().append("**");
    if (paramInt >= paramString.length()) {}
    for (paramString = "-";; paramString = paramString.substring(paramInt)) {
      return paramString;
    }
  }
  
  public static boolean isAllSystemEmotcation(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    label11:
    if (i < paramString.length())
    {
      int j = paramString.codePointAt(i);
      if (20 == j) {
        i += 1;
      }
      for (;;)
      {
        i += 1;
        break label11;
        if (32 != j) {
          break;
        }
      }
    }
    return true;
  }
  
  public static boolean isApolloEmoticon(int paramInt)
  {
    return QQSysFaceUtil.isApolloEmoticon(paramInt);
  }
  
  public static boolean isContainComplexScript(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        int k = paramString.charAt(i);
        if (((k >= 1536) && (k <= 1791)) || ((k >= 1872) && (k <= 1919)) || ((k >= 64336) && (k <= 65023)) || ((k >= 65136) && (k <= 65279))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static final Drawable loadEmojiFromDisk(Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: new 101	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 469
    //   10: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: iload_1
    //   14: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: astore 7
    //   22: getstatic 458	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   25: ifnull +36 -> 61
    //   28: getstatic 458	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   31: aload 7
    //   33: invokevirtual 475	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 477	android/util/Pair
    //   39: astore 5
    //   41: aload 5
    //   43: ifnull +18 -> 61
    //   46: aload 5
    //   48: getfield 481	android/util/Pair:first	Ljava/lang/Object;
    //   51: checkcast 483	android/graphics/drawable/Drawable$ConstantState
    //   54: aload_0
    //   55: invokevirtual 487	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   58: astore_0
    //   59: aload_0
    //   60: areturn
    //   61: invokestatic 659	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   64: getstatic 664	begp:b	Ljava/lang/String;
    //   67: invokevirtual 667	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   70: astore 5
    //   72: iload_1
    //   73: sipush 1000
    //   76: isub
    //   77: i2l
    //   78: lstore_3
    //   79: aload 5
    //   81: astore_0
    //   82: aload 5
    //   84: lload_3
    //   85: invokevirtual 673	java/io/RandomAccessFile:seek	(J)V
    //   88: aload 5
    //   90: astore_0
    //   91: invokestatic 679	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   94: iconst_4
    //   95: invokevirtual 683	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   98: astore 6
    //   100: aload 5
    //   102: astore_0
    //   103: aload 5
    //   105: aload 6
    //   107: iconst_0
    //   108: iconst_4
    //   109: invokevirtual 687	java/io/RandomAccessFile:read	([BII)I
    //   112: pop
    //   113: aload 5
    //   115: astore_0
    //   116: aload 6
    //   118: invokestatic 690	begp:a	([B)I
    //   121: istore_2
    //   122: aload 5
    //   124: astore_0
    //   125: invokestatic 679	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   128: aload 6
    //   130: invokevirtual 694	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   133: aload 5
    //   135: astore_0
    //   136: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +456 -> 595
    //   142: aload 5
    //   144: astore_0
    //   145: ldc_w 696
    //   148: iconst_2
    //   149: new 101	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 698
    //   159: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload_2
    //   163: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: goto +423 -> 595
    //   175: aload 5
    //   177: astore_0
    //   178: ldc_w 696
    //   181: iconst_4
    //   182: new 101	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 703
    //   192: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: iload_1
    //   196: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload 5
    //   207: ifnull +12 -> 219
    //   210: invokestatic 659	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   213: getstatic 664	begp:b	Ljava/lang/String;
    //   216: invokevirtual 705	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   219: aconst_null
    //   220: areturn
    //   221: aload 5
    //   223: astore_0
    //   224: invokestatic 679	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   227: sipush 4096
    //   230: invokevirtual 683	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   233: astore 6
    //   235: aload 5
    //   237: astore_0
    //   238: aload 6
    //   240: iconst_0
    //   241: aload 5
    //   243: aload 6
    //   245: iconst_0
    //   246: iload_2
    //   247: invokevirtual 687	java/io/RandomAccessFile:read	([BII)I
    //   250: invokestatic 711	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   253: astore 6
    //   255: aload 5
    //   257: astore_0
    //   258: aload 6
    //   260: invokestatic 716	bhbx:a	(Landroid/graphics/Bitmap;)I
    //   263: istore_2
    //   264: aload 5
    //   266: astore_0
    //   267: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +33 -> 303
    //   273: aload 5
    //   275: astore_0
    //   276: ldc_w 696
    //   279: iconst_2
    //   280: new 101	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 718
    //   290: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: iload_2
    //   294: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: iload_2
    //   304: ifle +154 -> 458
    //   307: aload 5
    //   309: astore_0
    //   310: new 720	android/graphics/drawable/BitmapDrawable
    //   313: dup
    //   314: aload 6
    //   316: invokespecial 723	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   319: astore 6
    //   321: aload 5
    //   323: astore_0
    //   324: getstatic 458	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   327: ifnull +70 -> 397
    //   330: aload 5
    //   332: astore_0
    //   333: getstatic 458	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   336: aload 7
    //   338: new 477	android/util/Pair
    //   341: dup
    //   342: aload 6
    //   344: invokevirtual 592	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   347: iload_2
    //   348: invokestatic 524	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   351: invokespecial 595	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   354: invokevirtual 598	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   357: pop
    //   358: aload 5
    //   360: astore_0
    //   361: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +33 -> 397
    //   367: aload 5
    //   369: astore_0
    //   370: ldc_w 696
    //   373: iconst_2
    //   374: new 101	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 196	java/lang/StringBuilder:<init>	()V
    //   381: ldc_w 725
    //   384: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: iload_1
    //   388: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload 5
    //   399: astore_0
    //   400: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq +35 -> 438
    //   406: aload 5
    //   408: astore_0
    //   409: ldc_w 696
    //   412: iconst_2
    //   413: invokestatic 731	com/tencent/mobileqq/activity/aio/AIOUtils:obtainStringBuilder	()Ljava/lang/StringBuilder;
    //   416: ldc_w 733
    //   419: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: iload_1
    //   423: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   426: ldc_w 735
    //   429: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: aload 6
    //   440: astore_0
    //   441: aload 5
    //   443: ifnull -384 -> 59
    //   446: invokestatic 659	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   449: getstatic 664	begp:b	Ljava/lang/String;
    //   452: invokevirtual 705	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   455: aload 6
    //   457: areturn
    //   458: aload 5
    //   460: ifnull +12 -> 472
    //   463: invokestatic 659	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   466: getstatic 664	begp:b	Ljava/lang/String;
    //   469: invokevirtual 705	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   472: aconst_null
    //   473: areturn
    //   474: astore 6
    //   476: aconst_null
    //   477: astore 5
    //   479: aload 5
    //   481: astore_0
    //   482: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   485: ifeq +18 -> 503
    //   488: aload 5
    //   490: astore_0
    //   491: ldc_w 696
    //   494: iconst_2
    //   495: ldc_w 736
    //   498: aload 6
    //   500: invokestatic 739	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   503: aload 5
    //   505: ifnonnull +9 -> 514
    //   508: aload 5
    //   510: astore_0
    //   511: invokestatic 742	com/tencent/mobileqq/text/EmotcationConstants:reDownloadAppleEmoji	()V
    //   514: aload 5
    //   516: ifnull +12 -> 528
    //   519: invokestatic 659	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   522: getstatic 664	begp:b	Ljava/lang/String;
    //   525: invokevirtual 705	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   528: invokestatic 519	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq +32 -> 563
    //   534: ldc_w 696
    //   537: iconst_2
    //   538: invokestatic 731	com/tencent/mobileqq/activity/aio/AIOUtils:obtainStringBuilder	()Ljava/lang/StringBuilder;
    //   541: ldc_w 733
    //   544: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: iload_1
    //   548: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: ldc_w 744
    //   554: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 701	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   563: aconst_null
    //   564: areturn
    //   565: astore 5
    //   567: aconst_null
    //   568: astore_0
    //   569: aload_0
    //   570: ifnull +12 -> 582
    //   573: invokestatic 659	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   576: getstatic 664	begp:b	Ljava/lang/String;
    //   579: invokevirtual 705	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   582: aload 5
    //   584: athrow
    //   585: astore 5
    //   587: goto -18 -> 569
    //   590: astore 6
    //   592: goto -113 -> 479
    //   595: iload_2
    //   596: iflt -421 -> 175
    //   599: iload_2
    //   600: sipush 4096
    //   603: if_icmple -382 -> 221
    //   606: goto -431 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	609	0	paramResources	Resources
    //   0	609	1	paramInt	int
    //   121	483	2	i	int
    //   78	7	3	l	long
    //   39	476	5	localObject1	Object
    //   565	18	5	localObject2	Object
    //   585	1	5	localObject3	Object
    //   98	358	6	localObject4	Object
    //   474	25	6	localThrowable1	Throwable
    //   590	1	6	localThrowable2	Throwable
    //   20	317	7	str	String
    // Exception table:
    //   from	to	target	type
    //   61	72	474	java/lang/Throwable
    //   61	72	565	finally
    //   82	88	585	finally
    //   91	100	585	finally
    //   103	113	585	finally
    //   116	122	585	finally
    //   125	133	585	finally
    //   136	142	585	finally
    //   145	172	585	finally
    //   178	205	585	finally
    //   224	235	585	finally
    //   238	255	585	finally
    //   258	264	585	finally
    //   267	273	585	finally
    //   276	303	585	finally
    //   310	321	585	finally
    //   324	330	585	finally
    //   333	358	585	finally
    //   361	367	585	finally
    //   370	397	585	finally
    //   400	406	585	finally
    //   409	438	585	finally
    //   482	488	585	finally
    //   491	503	585	finally
    //   511	514	585	finally
    //   82	88	590	java/lang/Throwable
    //   91	100	590	java/lang/Throwable
    //   103	113	590	java/lang/Throwable
    //   116	122	590	java/lang/Throwable
    //   125	133	590	java/lang/Throwable
    //   136	142	590	java/lang/Throwable
    //   145	172	590	java/lang/Throwable
    //   178	205	590	java/lang/Throwable
    //   224	235	590	java/lang/Throwable
    //   238	255	590	java/lang/Throwable
    //   258	264	590	java/lang/Throwable
    //   267	273	590	java/lang/Throwable
    //   276	303	590	java/lang/Throwable
    //   310	321	590	java/lang/Throwable
    //   324	330	590	java/lang/Throwable
    //   333	358	590	java/lang/Throwable
    //   361	367	590	java/lang/Throwable
    //   370	397	590	java/lang/Throwable
    //   400	406	590	java/lang/Throwable
    //   409	438	590	java/lang/Throwable
  }
  
  public static String removeColorNickCode(String paramString)
  {
    if ((android.text.TextUtils.isEmpty(paramString)) || (paramString.length() < 5)) {
      return paramString;
    }
    int i = 0;
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    while (i < j)
    {
      char c = paramString.charAt(i);
      if ((c == '<') && (i < j - 2))
      {
        int k = paramString.charAt(i + 1);
        if (((k == 36) || (k == 37) || (k == 38)) && (i < j - 5))
        {
          k = paramString.indexOf('>', i);
          if (k != -1)
          {
            i = i + k + 1;
            continue;
          }
        }
      }
      localStringBuilder.append(c);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String replaceEmojiWithSpace(String paramString)
  {
    Object localObject1;
    if (android.text.TextUtils.isEmpty(paramString)) {
      localObject1 = null;
    }
    Object localObject2;
    int k;
    int i;
    do
    {
      return localObject1;
      localObject2 = "";
      k = paramString.length();
      i = 0;
      localObject1 = localObject2;
    } while (i >= k);
    int j;
    if (paramString.codePointAt(i) == 20)
    {
      j = i;
      localObject1 = localObject2;
      if (i < k - 1)
      {
        if (paramString.charAt(i + 1) >= 'ÿ') {
          break label107;
        }
        localObject1 = (String)localObject2 + "  ";
        j = i + 1;
      }
    }
    for (;;)
    {
      i = j + 1;
      localObject2 = localObject1;
      break;
      label107:
      localObject1 = (String)localObject2 + "     ";
      j = i + 4;
      continue;
      localObject1 = (String)localObject2 + paramString.charAt(i);
      j = i;
    }
  }
  
  public static String subQQTextString(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (paramPaint == null);
    int j = 0;
    int i3 = paramString.length();
    int i = 0;
    int i4 = ViewUtils.dip2px(paramInt2);
    paramInt2 = 0;
    Object localObject = new StringBuilder();
    int k = 0;
    int i5;
    int m;
    int n;
    int i1;
    if ((k < i3) && (paramInt2 < paramInt3))
    {
      i5 = paramString.codePointAt(k);
      if (((paramInt1 & 0x6) > 0) && (i5 == 20) && (k < i3 - 1))
      {
        paramInt2 = paramString.charAt(k + 1);
        if (QQSysFaceUtil.isValidFaceId(paramInt2))
        {
          paramInt2 = 2;
          i += 1;
          j = 1;
        }
        for (;;)
        {
          if (j == 0)
          {
            paramInt2 = 1;
            ((StringBuilder)localObject).append(paramString.charAt(k));
          }
          j = (int)(paramPaint.measureText(((StringBuilder)localObject).toString()) + i * i4 + 0.5F);
          m = k + paramInt2;
          k = paramInt2;
          paramInt2 = j;
          j = k;
          k = m;
          break;
          if ((paramInt2 >= 255) && (k + 4 < i3))
          {
            paramInt2 = 4;
            i += 1;
            j = 1;
          }
          else
          {
            if (paramInt2 != 250) {
              break label596;
            }
            paramInt2 = 2;
            i += 1;
            j = 1;
          }
        }
      }
      if ((paramInt1 & 0x1) != 1) {
        break label596;
      }
      j = EmotcationConstants.getSingleEmoji(i5);
      paramInt2 = -1;
      n = 0;
      i1 = 0;
      if (i5 > 65535)
      {
        m = i1;
        if (i3 > k + 2)
        {
          paramInt2 = paramString.codePointAt(k + 2);
          m = i1;
        }
        label301:
        if (EmotcationConstants.isSkinEmoji(paramInt2)) {
          n = 1;
        }
        if ((j != -1) && (n == 0)) {
          break label604;
        }
        n = EmotcationConstants.getDoubleEmoji(i5, paramInt2);
        if (n != -1) {
          break label489;
        }
        label336:
        i1 = 1;
        n = j;
      }
    }
    for (j = i1;; j = 0)
    {
      if (n != -1)
      {
        if (j != 0) {
          if ((i5 > 65535) && (i3 >= k + 2))
          {
            j = 2;
            label378:
            if ((paramInt2 <= 65535) || (i3 < k + 2)) {
              break label502;
            }
            paramInt2 = j + 2;
            label399:
            if (m == 0) {
              break label593;
            }
            paramInt2 += 1;
          }
        }
        label593:
        for (;;)
        {
          i += 1;
          j = 1;
          break;
          m = i1;
          if (i3 <= k + 1) {
            break label301;
          }
          int i2 = paramString.codePointAt(k + 1);
          m = i1;
          paramInt2 = i2;
          if (i2 != 65039) {
            break label301;
          }
          m = i1;
          paramInt2 = i2;
          if (i3 <= k + 2) {
            break label301;
          }
          paramInt2 = paramString.codePointAt(k + 2);
          m = 1;
          break label301;
          label489:
          j = n;
          break label336;
          j = 1;
          break label378;
          label502:
          paramInt2 = j + 1;
          break label399;
          if ((i5 > 65535) && (i3 >= k + 2))
          {
            paramInt2 = 2;
          }
          else
          {
            paramInt2 = 1;
            continue;
            if ((k < i3 - 1) && (paramBoolean)) {}
            for (paramString = paramString.substring(0, k - j) + "…";; paramString = paramString.substring(0, k)) {
              return paramString;
            }
          }
        }
      }
      label596:
      j = 0;
      paramInt2 = 0;
      break;
      label604:
      n = j;
    }
  }
  
  public static String trimNewLine(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    int k;
    int m;
    do
    {
      return paramString;
      int n = 0;
      k = 0;
      int j = paramString.length();
      int i = j;
      if (paramBoolean)
      {
        i = k;
        for (;;)
        {
          k = j;
          m = i;
          if (i >= j) {
            break;
          }
          k = j;
          m = i;
          if (paramString.charAt(i) != '\n') {
            break;
          }
          i += 1;
        }
      }
      for (;;)
      {
        k = i;
        m = n;
        if (i >= 0) {
          break;
        }
        k = i;
        m = n;
        if (paramString.charAt(i - 1) != '\n') {
          break;
        }
        i -= 1;
      }
    } while ((m <= 0) && (k >= paramString.length()));
    return paramString.substring(m, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils
 * JD-Core Version:    0.7.0.1
 */