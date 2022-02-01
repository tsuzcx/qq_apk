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
import android.util.Pair;
import android.util.SparseArray;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSmallEmoUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qqemoticon.api.IEmoticonManager;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TextUtils
{
  public static final int COLOR_NICK_EMOTICON_HEAD = 36;
  public static final int COLOR_NICK_GRADIENT_COLOR_HEAD = 37;
  public static final int COLOR_NICK_PURE_COLOR_HEAD = 38;
  public static final int EMO_PREFIX = 20;
  public static final int FACE_REPLACE_NUM = EmotcationConstants.EMOJI_CONTENT_DESC.length;
  public static final int SPACE_POINT_CODE = 32;
  private static final String TAG = "TextUtils";
  
  public static String Symbol2FavoriteSymbol(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (!hasSysEmotion(paramString)) {
      return paramString;
    }
    IEmoticonManager localIEmoticonManager = getEmoMgr();
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    int i = 0;
    while (i < localStringBuilder.length())
    {
      int j = i;
      if (localStringBuilder.codePointAt(i) == 20)
      {
        j = i;
        if (i < localStringBuilder.length() - 1)
        {
          int m = i + 1;
          int k = localStringBuilder.charAt(m);
          if ((!QQSysFaceUtil.isValidFaceId(k)) && (250 != k))
          {
            j = i;
            if (k != 255) {
              break label374;
            }
            j = i + 4;
            if (j >= localStringBuilder.length())
            {
              paramString = AbsQQText.SMALL_EMOJI_SYMBOL;
              localStringBuilder.replace(i, localStringBuilder.length(), paramString);
              i += paramString.length() - 1;
              continue;
            }
            paramString = new char[4];
            paramString[0] = localStringBuilder.charAt(j);
            paramString[1] = localStringBuilder.charAt(i + 3);
            paramString[2] = localStringBuilder.charAt(i + 2);
            paramString[3] = localStringBuilder.charAt(m);
            j = 0;
            while (j < 3)
            {
              if (paramString[j] == 'ú') {
                paramString[j] = 10;
              } else if (paramString[j] == 'þ') {
                paramString[j] = 13;
              }
              j += 1;
            }
            paramString = QQSmallEmoUtils.getEmoDescripFromChars(paramString);
            if ((paramString != null) && (paramString.length == 2))
            {
              k = paramString[0];
              j = paramString[1];
            }
            else
            {
              j = 0;
              k = 0;
            }
            if (localIEmoticonManager != null) {
              paramString = localIEmoticonManager.syncGetEmoticonDescriptionById(Integer.toString(k), Integer.toString(j));
            } else {
              paramString = "";
            }
            String str = paramString;
            if (android.text.TextUtils.isEmpty(paramString)) {
              str = AbsQQText.SMALL_EMOJI_SYMBOL;
            }
            localStringBuilder.replace(i, i + 5, str);
            j = str.length();
          }
          else
          {
            j = k;
            if (250 == k) {
              j = 10;
            }
            paramString = QQSysFaceUtil.getFaceDescription(j);
            localStringBuilder.replace(i, i + 2, paramString);
            j = paramString.length();
          }
          j = i + (j - 1);
        }
      }
      label374:
      i = j + 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String adjustEllipsizeEndText(TextView paramTextView, String paramString, int paramInt)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramTextView.getLayout();
    int k = (int)Layout.getDesiredWidth("...", paramTextView.getPaint());
    int i = paramString.codePointCount(0, paramString.length());
    int j = paramString.length();
    for (float f = Layout.getDesiredWidth(paramString.subSequence(0, j), paramTextView.getPaint());; f = Layout.getDesiredWidth(paramString.subSequence(0, j), paramTextView.getPaint()))
    {
      int m = (int)f;
      if ((i <= 0) || (m + 1 <= paramInt - k - 1)) {
        break;
      }
      i -= 1;
      j = paramString.offsetByCodePoints(0, i);
    }
    if (j == paramString.length()) {
      return paramString;
    }
    paramTextView = new StringBuilder();
    paramTextView.append(paramString.substring(0, j));
    paramTextView.append("...");
    return paramTextView.toString();
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
      if (j != i)
      {
        localEditable.delete(Math.min(j, i), Math.max(j, i));
        return;
      }
    }
    catch (Exception paramEditText)
    {
      paramEditText.printStackTrace();
    }
  }
  
  public static String cToe(String paramString)
  {
    String[] arrayOfString = new String[40];
    int i = 0;
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
  
  public static String emoticonToText(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return "";
    }
    int j = QQEmojiUtil.getEmojiCount();
    int i = 0;
    int k;
    String str;
    int m;
    while (i < j)
    {
      k = paramString.indexOf(QQEmojiUtil.getEmojiUnicode(i), 0);
      str = paramString;
      if (k != -1)
      {
        m = k + 2;
        str = paramString;
        if (m <= paramString.length()) {
          str = paramString.replace(paramString.substring(k, m), QQEmojiUtil.getEmojiDescription(i));
        }
      }
      i += 1;
      paramString = str;
    }
    if (!hasSysEmotion(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    IEmoticonManager localIEmoticonManager = getEmoMgr();
    i = 0;
    while (i < localStringBuilder.length())
    {
      j = i;
      if (localStringBuilder.codePointAt(i) == 20)
      {
        j = i;
        if (i < localStringBuilder.length() - 1)
        {
          k = i + 1;
          m = localStringBuilder.charAt(k);
          if (QQSysFaceUtil.isValidFaceId(m))
          {
            paramString = QQSysFaceUtil.getFaceDescription(m);
            localStringBuilder.replace(i, i + 2, paramString);
          }
          for (j = paramString.length();; j = str.length())
          {
            j = i + (j - 1);
            break label429;
            j = i;
            if (m != 255) {
              break label429;
            }
            j = i + 4;
            if (j >= localStringBuilder.length())
            {
              paramString = AbsQQText.SMALL_EMOJI_SYMBOL;
              localStringBuilder.replace(i, localStringBuilder.length(), paramString);
              i += paramString.length() - 1;
              break;
            }
            paramString = new char[4];
            paramString[0] = localStringBuilder.charAt(j);
            paramString[1] = localStringBuilder.charAt(i + 3);
            paramString[2] = localStringBuilder.charAt(i + 2);
            paramString[3] = localStringBuilder.charAt(k);
            j = 0;
            while (j < 3)
            {
              if (paramString[j] == 'ú') {
                paramString[j] = 10;
              } else if (paramString[j] == 'þ') {
                paramString[j] = 13;
              }
              j += 1;
            }
            paramString = QQSmallEmoUtils.getEmoDescripFromChars(paramString);
            if ((paramString != null) && (paramString.length == 2))
            {
              k = paramString[0];
              j = paramString[1];
            }
            else
            {
              j = 0;
              k = 0;
            }
            if (localIEmoticonManager != null) {
              paramString = localIEmoticonManager.getSmallEmoticonDescription(Integer.toString(k), Integer.toString(j));
            } else {
              paramString = "";
            }
            str = paramString;
            if (android.text.TextUtils.isEmpty(paramString)) {
              str = AbsQQText.SMALL_EMOJI_SYMBOL;
            }
            localStringBuilder.replace(i, i + 5, str);
          }
        }
      }
      label429:
      i = j + 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String emoticonToTextForTalkBack(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = 0;
    int j;
    String str;
    for (;;)
    {
      k = FACE_REPLACE_NUM;
      j = 2;
      if (i >= k) {
        break;
      }
      k = paramString.indexOf(EmotcationConstants.EMOJI_CODES[i], 0);
      str = paramString;
      if (k != -1) {
        if (k >= paramString.length())
        {
          str = paramString;
        }
        else
        {
          if (paramString.codePointAt(k) <= 65535) {
            j = 1;
          }
          str = paramString;
          if (k != -1)
          {
            j += k;
            str = paramString;
            if (j <= paramString.length())
            {
              str = EmotcationConstants.getEmojiDesc(i);
              str = paramString.replace(paramString.substring(k, j), str);
            }
          }
        }
      }
      i += 1;
      paramString = str;
    }
    if (!hasSysEmotion(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    IEmoticonManager localIEmoticonManager = getEmoMgr();
    i = 0;
    int k = 0;
    while (i < localStringBuilder.length())
    {
      if ((localStringBuilder.codePointAt(i) == 20) && (i < localStringBuilder.length() - 1))
      {
        int n = i + 1;
        j = localStringBuilder.charAt(n);
        int m = j;
        if (j == 250) {
          m = 10;
        }
        if (QQSysFaceUtil.isValidFaceId(m))
        {
          str = QQSysFaceUtil.getFaceDescription(m);
          paramString = str;
          if (k == 0)
          {
            paramString = new StringBuilder();
            paramString.append(HardCodeUtil.a(2131916985));
            paramString.append(str);
            paramString = paramString.toString();
          }
          localStringBuilder.replace(i, i + 2, paramString);
        }
        for (j = paramString.length();; j = str.length())
        {
          j = i + (j - 1);
          break label524;
          j = i;
          if (m != 255) {
            break label524;
          }
          j = i + 4;
          if (j >= localStringBuilder.length())
          {
            paramString = AbsQQText.SMALL_EMOJI_SYMBOL;
            localStringBuilder.replace(i, localStringBuilder.length(), paramString);
            i += paramString.length() - 1;
            break;
          }
          paramString = new char[4];
          paramString[0] = localStringBuilder.charAt(j);
          paramString[1] = localStringBuilder.charAt(i + 3);
          paramString[2] = localStringBuilder.charAt(i + 2);
          paramString[3] = localStringBuilder.charAt(n);
          j = 0;
          while (j < 3)
          {
            if (paramString[j] == 'ú') {
              paramString[j] = 10;
            } else if (paramString[j] == 'þ') {
              paramString[j] = 13;
            }
            j += 1;
          }
          paramString = QQSmallEmoUtils.getEmoDescripFromChars(paramString);
          if ((paramString != null) && (paramString.length == 2))
          {
            k = paramString[0];
            j = paramString[1];
          }
          else
          {
            j = 0;
            k = 0;
          }
          if (localIEmoticonManager != null) {
            paramString = localIEmoticonManager.syncGetEmoticonDescriptionById(Integer.toString(k), Integer.toString(j));
          } else {
            paramString = "";
          }
          str = paramString;
          if (android.text.TextUtils.isEmpty(paramString)) {
            str = AbsQQText.SMALL_EMOJI_SYMBOL;
          }
          localStringBuilder.replace(i, i + 5, str);
        }
        label524:
        k = 1;
        i = j;
        j = k;
      }
      else
      {
        j = 0;
      }
      i += 1;
      k = j;
    }
    return localStringBuilder.toString();
  }
  
  public static String emoticonToTextWithoutSysEmotion(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    IEmoticonManager localIEmoticonManager = getEmoMgr();
    int i = 0;
    while (i < localStringBuilder.length())
    {
      int j = i;
      if (localStringBuilder.codePointAt(i) == 20)
      {
        j = i;
        if (i < localStringBuilder.length() - 1)
        {
          int k = i + 1;
          int m = localStringBuilder.charAt(k);
          if (QQSysFaceUtil.isValidFaceId(m))
          {
            paramString = QQSysFaceUtil.getFaceDescription(m);
            localStringBuilder.replace(i, i + 2, paramString);
          }
          String str;
          for (j = paramString.length();; j = str.length())
          {
            j = i + (j - 1);
            break label337;
            j = i;
            if (m != 255) {
              break label337;
            }
            j = i + 4;
            if (j >= localStringBuilder.length())
            {
              paramString = AbsQQText.SMALL_EMOJI_SYMBOL;
              localStringBuilder.replace(i, localStringBuilder.length(), paramString);
              i += paramString.length() - 1;
              break;
            }
            paramString = new char[4];
            paramString[0] = localStringBuilder.charAt(j);
            paramString[1] = localStringBuilder.charAt(i + 3);
            paramString[2] = localStringBuilder.charAt(i + 2);
            paramString[3] = localStringBuilder.charAt(k);
            j = 0;
            while (j < 3)
            {
              if (paramString[j] == 'ú') {
                paramString[j] = 10;
              } else if (paramString[j] == 'þ') {
                paramString[j] = 13;
              }
              j += 1;
            }
            paramString = QQSmallEmoUtils.getEmoDescripFromChars(paramString);
            if ((paramString != null) && (paramString.length == 2))
            {
              k = paramString[0];
              j = paramString[1];
            }
            else
            {
              j = 0;
              k = 0;
            }
            if (localIEmoticonManager != null) {
              paramString = localIEmoticonManager.getSmallEmoticonDescription(Integer.toString(k), Integer.toString(j));
            } else {
              paramString = "";
            }
            str = paramString;
            if (android.text.TextUtils.isEmpty(paramString)) {
              str = AbsQQText.SMALL_EMOJI_SYMBOL;
            }
            localStringBuilder.replace(i, i + 5, str);
          }
        }
      }
      label337:
      i = j + 1;
    }
    return localStringBuilder.toString();
  }
  
  public static void fixTextViewANRForAnd10(TextView paramTextView)
  {
    if ((Build.VERSION.SDK_INT >= 29) && (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))) {
      try
      {
        paramTextView.setBreakStrategy(0);
        return;
      }
      catch (Throwable paramTextView)
      {
        QLog.e("TextUtils", 1, paramTextView, new Object[0]);
      }
    }
  }
  
  public static String getColorNickSysEmoticonString(int paramInt)
  {
    return String.valueOf(new char[] { '<', '$', (char)QQSysFaceUtil.convertToServer(paramInt), '>' });
  }
  
  private static IEmoticonManager getEmoMgr()
  {
    for (;;)
    {
      try
      {
        Object localObject = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT > 10)
        {
          i = 4;
          localObject = ((BaseApplication)localObject).getSharedPreferences("Last_Login", i).getString("uin", "");
          localObject = (IEmoticonManager)MobileQQ.sMobileQQ.getAppRuntime((String)localObject).getRuntimeService(IEmoticonManager.class, "all");
          return localObject;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      int i = 0;
    }
  }
  
  public static final Drawable getEmojiDrawable(int paramInt)
  {
    if (paramInt >= 0)
    {
      int j = EmotcationConstants.INVALID_EMOJ_RES;
      if (paramInt >= 1000) {
        return QQEmojiUtil.loadEmojiFromDisk(BaseApplication.getContext().getResources(), paramInt);
      }
      int i = j;
      if (paramInt >= 0)
      {
        i = j;
        if (paramInt < EmotcationConstants.VALID_EMOJI_COUNT) {
          i = EmotcationConstants.FIRST_EMOJI_RES + paramInt;
        }
      }
      if (GlobalImageCache.a != null) {
        return getResourceDrawableThroughImageCache(BaseApplication.getContext().getResources(), i);
      }
      return BaseApplication.getContext().getResources().getDrawable(i);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invaid emoji index: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static final Drawable getEmojiDrawable(int paramInt, TextUtils.LoadSysEmojiCallback paramLoadSysEmojiCallback)
  {
    if (paramInt >= 0)
    {
      Resources localResources = BaseApplication.getContext().getResources();
      int j = EmotcationConstants.INVALID_EMOJ_RES;
      Object localObject;
      if (paramInt >= 1000)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("emotion://");
        ((StringBuilder)localObject).append(paramInt);
        localObject = ((StringBuilder)localObject).toString();
        if (GlobalImageCache.a != null)
        {
          localObject = (Pair)GlobalImageCache.a.get(localObject);
          if ((localObject != null) && (((Pair)localObject).first != null)) {
            return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(localResources);
          }
        }
        ThreadManager.executeOnFileThread(new TextUtils.1(paramInt, paramLoadSysEmojiCallback));
        return null;
      }
      int i = j;
      if (paramInt >= 0)
      {
        i = j;
        if (paramInt < EmotcationConstants.VALID_EMOJI_COUNT) {
          i = EmotcationConstants.FIRST_EMOJI_RES + paramInt;
        }
      }
      if (GlobalImageCache.a != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("android.resource://");
        ((StringBuilder)localObject).append(i);
        localObject = ((StringBuilder)localObject).toString();
        localObject = (Pair)GlobalImageCache.a.get(localObject);
        if ((localObject != null) && (((Pair)localObject).first != null)) {
          return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(localResources);
        }
        ThreadManager.executeOnFileThread(new TextUtils.2(i, paramLoadSysEmojiCallback));
        return null;
      }
      return BaseApplication.getContext().getResources().getDrawable(i);
    }
    paramLoadSysEmojiCallback = new StringBuilder();
    paramLoadSysEmojiCallback.append("invaid emoji index: ");
    paramLoadSysEmojiCallback.append(paramInt);
    throw new IllegalArgumentException(paramLoadSysEmojiCallback.toString());
  }
  
  public static final String getEmojiString(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < EmotcationConstants.EMOJI_CODES.length)) {
      return String.valueOf(Character.toChars(EmotcationConstants.EMOJI_CODES[paramInt]));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invaid sys emotcation index: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static String getNeoTextAfter(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int m = paramInt2 * 4 + paramInt1;
    if (m > paramString.length()) {
      m = paramString.length();
    }
    int k = paramInt1;
    int j = 0;
    int i;
    int n;
    label121:
    do
    {
      i = k;
      n = j;
      if (k >= m) {
        break;
      }
      i = paramString.codePointAt(k);
      if (i == 20)
      {
        n = k + 1;
        if (n < m)
        {
          if (paramString.charAt(n) >= 'ÿ')
          {
            i = k + 4;
            if (i < m) {}
          }
          else
          {
            i = k + 2;
          }
          break label121;
        }
      }
      i = k + Character.charCount(i);
      if (QLog.isColorLevel()) {
        QLog.d("TextUtils", 2, new Object[] { "subStringLength= ", Integer.valueOf(i), " start=", Integer.valueOf(paramInt1) });
      }
      n = j + 1;
      k = i;
      j = n;
    } while (n < paramInt2);
    if (n < paramInt2) {
      paramInt2 = paramInt1;
    } else if (i > paramString.length()) {
      paramInt2 = paramString.length();
    } else {
      paramInt2 = i;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TextUtils", 2, new Object[] { "loopTime= ", Integer.valueOf(n), " start=", Integer.valueOf(paramInt1) });
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
  }
  
  public static String getNeoTextBefore(String paramString, int paramInt1, int paramInt2)
  {
    int j = paramInt1 - paramInt2 * 4;
    int i = j;
    if (j <= 0) {
      i = 0;
    }
    SparseArray localSparseArray = new SparseArray();
    j = 0;
    while (i < paramInt1)
    {
      localSparseArray.put(j, Integer.valueOf(i));
      if (QLog.isColorLevel()) {
        QLog.d("TextUtils", 2, new Object[] { "getNeoTextBefore subStringLength= ", Integer.valueOf(i), " end:", Integer.valueOf(paramInt1) });
      }
      int k = paramString.codePointAt(i);
      if (k == 20)
      {
        int m = i + 1;
        if (m < paramInt1)
        {
          if (paramString.charAt(m) >= 'ÿ')
          {
            k = i + 4;
            if (k < paramInt1)
            {
              i = k;
              break label145;
            }
          }
          i += 2;
          label145:
          break label156;
        }
      }
      i += Character.charCount(k);
      label156:
      j += 1;
    }
    if (localSparseArray.size() - paramInt2 >= 0)
    {
      j = ((Integer)localSparseArray.get(localSparseArray.size() - paramInt2)).intValue();
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("TextUtils", 2, new Object[] { "getNeoTextBefore from Array subStringLength= ", Integer.valueOf(j), " loopTime - maxContentLength:", Integer.valueOf(localSparseArray.size() - paramInt2) });
        i = j;
      }
    }
    else
    {
      i = paramInt1;
    }
    paramInt2 = i;
    if (i < 0) {
      paramInt2 = 0;
    }
    return paramString.substring(paramInt2, paramInt1);
  }
  
  public static int getQQTextCharCount(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return 0;
      }
      int i4 = paramString.length();
      int m = 0;
      int j = 0;
      while (m < i4)
      {
        int i5 = paramString.codePointAt(m);
        int k = 2;
        if (((paramInt & 0x6) > 0) && (i5 == 20) && (m < i4 - 1))
        {
          i = paramString.charAt(m + 1);
          if (QQSysFaceUtil.isValidFaceId(i)) {
            i = k;
          }
        }
        for (;;)
        {
          j += 1;
          k = 1;
          break label414;
          if ((i >= 255) && (m + 4 < i4))
          {
            j += 1;
            k = 1;
            i = 4;
            break label414;
          }
          if (i != 250) {
            break;
          }
          i = k;
          continue;
          if ((paramInt & 0x1) != 1) {
            break;
          }
          int i1 = EmotcationConstants.getSingleEmoji(i5);
          if (i5 > 65535)
          {
            i = m + 2;
            if (i4 > i)
            {
              i = paramString.codePointAt(i);
              break label238;
            }
          }
          else
          {
            i = m + 1;
            if (i4 > i)
            {
              n = paramString.codePointAt(i);
              i = n;
              if (n != 65039) {
                break label238;
              }
              i2 = m + 2;
              i = n;
              if (i4 <= i2) {
                break label238;
              }
              i2 = paramString.codePointAt(i2);
              n = 1;
              break label244;
            }
          }
          i = -1;
          label238:
          int n = 0;
          int i2 = i;
          label244:
          boolean bool = EmotcationConstants.isSkinEmoji(i2);
          if ((i1 != -1) && (!bool))
          {
            int i3 = 0;
            i = i1;
            i1 = i3;
          }
          else
          {
            i = EmotcationConstants.getDoubleEmoji(i5, i2);
            if (i == -1) {
              i = i1;
            }
            i1 = 1;
          }
          if (i == -1) {
            break;
          }
          if (i1 != 0)
          {
            if ((i5 <= 65535) || (i4 < m + 2)) {
              k = 1;
            }
            if ((i2 > 65535) && (i4 >= m + 2)) {
              k += 2;
            } else {
              k += 1;
            }
            i = k;
            if (n != 0) {
              i = k + 1;
            }
          }
          else if ((i5 > 65535) && (i4 >= m + 2))
          {
            i = k;
          }
          else
          {
            i = 1;
          }
        }
        k = 0;
        int i = 0;
        label414:
        if (k == 0)
        {
          j += 1;
          i = 1;
        }
        m += i;
      }
      return j;
    }
    return 0;
  }
  
  public static Drawable getResourceDrawableThroughImageCache(Resources paramResources, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("android.resource://");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    Pair localPair = (Pair)GlobalImageCache.a.get(localObject);
    if (localPair != null) {
      return ((Drawable.ConstantState)localPair.first).newDrawable(paramResources);
    }
    try
    {
      paramResources = paramResources.getDrawable(paramInt);
      paramInt = SkinUtils.b(paramResources);
      if (paramInt > 0) {
        GlobalImageCache.a.put(localObject, new Pair(paramResources.getConstantState(), Integer.valueOf(paramInt)));
      }
      return paramResources;
    }
    catch (Exception paramResources)
    {
      label94:
      break label94;
    }
    return null;
  }
  
  public static String getStringWithoutEmoji(String paramString)
  {
    for (int i = hasEmoji(paramString); i != -1; i = hasEmoji(paramString))
    {
      int k = i + 2;
      int j = k;
      if (k > paramString.length()) {
        j = paramString.length();
      }
      paramString = paramString.replace(paramString.substring(i, j), "");
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
    if (android.text.TextUtils.isEmpty(paramString)) {
      return null;
    }
    int k = paramString.length();
    int i = 0;
    Object localObject2;
    for (Object localObject1 = ""; i < k; localObject1 = localObject2)
    {
      int j;
      if (paramString.codePointAt(i) == 20)
      {
        j = i;
        localObject2 = localObject1;
        if (i < k - 1)
        {
          j = i + 1;
          if (paramString.charAt(j) < 'ÿ')
          {
            localObject2 = localObject1;
          }
          else
          {
            j = i + 4;
            localObject2 = localObject1;
          }
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(paramString.charAt(i));
        localObject2 = ((StringBuilder)localObject2).toString();
        j = i;
      }
      i = j + 1;
    }
    return localObject1;
  }
  
  public static boolean hasChnChar(CharSequence paramCharSequence)
  {
    int i = 0;
    while (i < paramCharSequence.length())
    {
      int j = Integer.parseInt(Integer.toHexString(paramCharSequence.charAt(i)), 16);
      if ((j >= 19968) && (j <= 40891)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static int hasEmoji(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return -1;
    }
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.charAt(i);
      if ((j >= 8448) && (j <= 10239)) {
        return i;
      }
      if ((j >= 10548) && (j <= 10549)) {
        return i;
      }
      if ((j >= 11013) && (j <= 11015)) {
        return i;
      }
      if ((j >= 11035) && (j <= 11036)) {
        return i;
      }
      if ((j != 169) && (j != 174) && (j != 8252) && (j != 8265) && (j != 11088) && (j != 11093) && (j != 12336) && (j != 12349) && (j != 12951))
      {
        if (j == 12953) {
          return i;
        }
        if ((j >= 55296) && (j <= 56319) && (i < paramString.length() - 1))
        {
          j = paramString.charAt(i + 1);
          if ((j >= 56320) && (j <= 57343)) {
            return i;
          }
        }
        else if (j == 8419)
        {
          return i;
        }
        i += 1;
      }
      else
      {
        return i;
      }
    }
    return -1;
  }
  
  public static boolean hasSysEmotion(String paramString)
  {
    boolean bool2 = android.text.TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (-1 != paramString.indexOf('\024')) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static String hideUinInShowString(String paramString, int paramInt)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("**");
      if (paramInt >= paramString.length()) {
        paramString = "-";
      } else {
        paramString = paramString.substring(paramInt);
      }
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return "null";
  }
  
  public static boolean isAllSystemEmotcation(String paramString)
  {
    boolean bool1 = android.text.TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    int i = 0;
    while (i < paramString.length())
    {
      int j = paramString.codePointAt(i);
      if (20 == j)
      {
        i += 1;
      }
      else
      {
        bool1 = bool2;
        if (32 != j) {
          return bool1;
        }
      }
      i += 1;
    }
    bool1 = true;
    return bool1;
  }
  
  public static boolean isApolloEmoticon(int paramInt)
  {
    return QQSysFaceUtil.isApolloEmoticon(paramInt);
  }
  
  public static boolean isContainComplexScript(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return false;
    }
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
    return false;
  }
  
  public static String removeColorNickCode(String paramString)
  {
    Object localObject = paramString;
    if (!android.text.TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 5) {
        return paramString;
      }
      int i = 0;
      int j = paramString.length();
      localObject = new StringBuilder();
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
              i += k;
              break label127;
            }
          }
        }
        ((StringBuilder)localObject).append(c);
        label127:
        i += 1;
      }
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String replaceEmojiWithSpace(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return null;
    }
    int k = paramString.length();
    int i = 0;
    Object localObject1;
    for (Object localObject2 = ""; i < k; localObject2 = localObject1)
    {
      int j;
      if (paramString.codePointAt(i) == 20)
      {
        j = i;
        localObject1 = localObject2;
        if (i < k - 1)
        {
          j = i + 1;
          if (paramString.charAt(j) < 'ÿ')
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("  ");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("     ");
            localObject1 = ((StringBuilder)localObject1).toString();
            j = i + 4;
          }
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(paramString.charAt(i));
        localObject1 = ((StringBuilder)localObject1).toString();
        j = i;
      }
      i = j + 1;
    }
    return localObject2;
  }
  
  public static String subQQTextString(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramPaint == null) {
        return paramString;
      }
      int i1 = paramString.length();
      int i2 = ViewUtils.dip2px(paramInt2);
      StringBuilder localStringBuilder = new StringBuilder();
      int k = 0;
      int j = 0;
      paramInt2 = 0;
      int i;
      for (int m = 0; (k < i1) && (j < paramInt3); m = i)
      {
        int i3 = paramString.codePointAt(k);
        if (((paramInt1 & 0x6) > 0) && (i3 == 20) && (k < i1 - 1))
        {
          paramInt2 = paramString.charAt(k + 1);
          if (QQSysFaceUtil.isValidFaceId(paramInt2)) {}
          for (;;)
          {
            i = m + 1;
            j = 1;
            paramInt2 = 2;
            break label458;
            if ((paramInt2 >= 255) && (k + 4 < i1))
            {
              i = m + 1;
              j = 1;
              paramInt2 = 4;
              break label458;
            }
            if (paramInt2 != 250) {
              break;
            }
          }
        }
        if ((paramInt1 & 0x1) == 1)
        {
          j = EmotcationConstants.getSingleEmoji(i3);
          int n;
          if (i3 > 65535)
          {
            paramInt2 = k + 2;
            if (i1 <= paramInt2) {
              break label274;
            }
            paramInt2 = paramString.codePointAt(paramInt2);
          }
          else
          {
            paramInt2 = k + 1;
            if (i1 <= paramInt2) {
              break label274;
            }
            i = paramString.codePointAt(paramInt2);
            paramInt2 = i;
            if (i == 65039)
            {
              n = k + 2;
              paramInt2 = i;
              if (i1 > n)
              {
                paramInt2 = paramString.codePointAt(n);
                i = 1;
                break label279;
              }
            }
          }
          i = 0;
          break label279;
          label274:
          i = 0;
          paramInt2 = -1;
          label279:
          boolean bool = EmotcationConstants.isSkinEmoji(paramInt2);
          if ((j != -1) && (!bool))
          {
            n = 0;
          }
          else
          {
            n = EmotcationConstants.getDoubleEmoji(i3, paramInt2);
            if (n != -1) {
              j = n;
            }
            n = 1;
          }
          if (j != -1)
          {
            if (n != 0)
            {
              if ((i3 > 65535) && (i1 >= k + 2)) {
                j = 2;
              } else {
                j = 1;
              }
              if ((paramInt2 > 65535) && (i1 >= k + 2)) {
                j += 2;
              } else {
                j += 1;
              }
              paramInt2 = j;
              if (i != 0) {
                paramInt2 = j + 1;
              }
            }
            else if ((i3 > 65535) && (i1 >= k + 2))
            {
              paramInt2 = 2;
            }
            else
            {
              paramInt2 = 1;
            }
            i = m + 1;
            j = 1;
            break label458;
          }
        }
        j = 0;
        paramInt2 = 0;
        i = m;
        label458:
        if (j == 0)
        {
          localStringBuilder.append(paramString.charAt(k));
          paramInt2 = 1;
        }
        j = (int)(paramPaint.measureText(localStringBuilder.toString()) + i * i2 + 0.5F);
        k += paramInt2;
      }
      if ((k < i1 - 1) && (paramBoolean))
      {
        paramPaint = new StringBuilder();
        paramPaint.append(paramString.substring(0, k - paramInt2));
        paramPaint.append("…");
        return paramPaint.toString();
      }
      return paramString.substring(0, k);
    }
    return "";
  }
  
  public static String trimNewLine(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return paramString;
      }
      int n = 0;
      int k = 0;
      int j = paramString.length();
      int i = j;
      int m;
      if (paramBoolean)
      {
        i = k;
        for (;;)
        {
          k = i;
          m = j;
          if (i >= j) {
            break;
          }
          k = i;
          m = j;
          if (paramString.charAt(i) != '\n') {
            break;
          }
          i += 1;
        }
      }
      for (;;)
      {
        k = n;
        m = i;
        if (i <= 0) {
          break;
        }
        k = n;
        m = i;
        if (paramString.charAt(i - 1) != '\n') {
          break;
        }
        i -= 1;
      }
      if (k <= 0)
      {
        str = paramString;
        if (m >= paramString.length()) {}
      }
      else
      {
        str = paramString.substring(k, m);
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils
 * JD-Core Version:    0.7.0.1
 */