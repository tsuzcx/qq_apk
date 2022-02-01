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
  public static final String ELLIPSIS_NORMAL = "…";
  public static final int EMO_PREFIX = 20;
  public static final int FACE_REPLACE_NUM = EmotcationConstants.EMOJI_CONTENT_DESC.length;
  public static final int SPACE_POINT_CODE = 32;
  private static final String TAG = "TextUtils";
  
  public static String Symbol2FavoriteSymbol(String paramString)
  {
    Object localObject;
    if (android.text.TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (!hasSysEmotion(paramString));
    IEmoticonManager localIEmoticonManager = getEmoMgr();
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    int i = 0;
    int j;
    int k;
    while (i < localStringBuilder.length())
    {
      j = i;
      if (localStringBuilder.codePointAt(i) == 20)
      {
        j = i;
        if (i < localStringBuilder.length() - 1)
        {
          k = localStringBuilder.charAt(i + 1);
          if ((!QQSysFaceUtil.isValidFaceId(k)) && (250 != k)) {
            break label143;
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
      label143:
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (k != 255);
      if (i + 4 >= localStringBuilder.length())
      {
        paramString = AbsQQText.SMALL_EMOJI_SYMBOL;
        localStringBuilder.replace(i, localStringBuilder.length(), paramString);
        i += paramString.length() - 1;
      }
      else
      {
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
        localObject = QQSmallEmoUtils.getEmoDescripFromChars(paramString);
        paramString = "";
        if ((localObject == null) || (localObject.length != 2)) {
          break label383;
        }
        k = localObject[0];
        j = localObject[1];
      }
    }
    for (;;)
    {
      if (localIEmoticonManager != null) {
        paramString = localIEmoticonManager.syncGetEmoticonDescriptionById(Integer.toString(k), Integer.toString(j));
      }
      localObject = paramString;
      if (android.text.TextUtils.isEmpty(paramString)) {
        localObject = AbsQQText.SMALL_EMOJI_SYMBOL;
      }
      localStringBuilder.replace(i, i + 5, (String)localObject);
      j = i + (((String)localObject).length() - 1);
      break;
      return localStringBuilder.toString();
      label383:
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
    String str;
    if (android.text.TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int j;
    int k;
    do
    {
      return str;
      j = QQEmojiUtil.getEmojiCount();
      i = 0;
      while (i < j)
      {
        k = paramString.indexOf(QQEmojiUtil.getEmojiUnicode(i), 0);
        str = paramString;
        if (k != -1)
        {
          str = paramString;
          if (k + 2 <= paramString.length()) {
            str = paramString.replace(paramString.substring(k, k + 2), QQEmojiUtil.getEmojiDescription(i));
          }
        }
        i += 1;
        paramString = str;
      }
      str = paramString;
    } while (!hasSysEmotion(paramString));
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    IEmoticonManager localIEmoticonManager = getEmoMgr();
    int i = 0;
    while (i < localStringBuilder.length())
    {
      j = i;
      if (localStringBuilder.codePointAt(i) == 20)
      {
        j = i;
        if (i < localStringBuilder.length() - 1)
        {
          k = localStringBuilder.charAt(i + 1);
          if (!QQSysFaceUtil.isValidFaceId(k)) {
            break label194;
          }
          paramString = QQSysFaceUtil.getFaceDescription(k);
          localStringBuilder.replace(i, i + 2, paramString);
          j = i + (paramString.length() - 1);
        }
      }
      label194:
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (k != 255);
      if (i + 4 >= localStringBuilder.length())
      {
        paramString = AbsQQText.SMALL_EMOJI_SYMBOL;
        localStringBuilder.replace(i, localStringBuilder.length(), paramString);
        i += paramString.length() - 1;
      }
      else
      {
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
        paramString = QQSmallEmoUtils.getEmoDescripFromChars(paramString);
        if ((paramString == null) || (paramString.length != 2)) {
          break label432;
        }
        k = paramString[0];
        j = paramString[1];
      }
    }
    for (;;)
    {
      if (localIEmoticonManager != null) {}
      for (paramString = localIEmoticonManager.getSmallEmoticonDescription(Integer.toString(k), Integer.toString(j));; paramString = "")
      {
        str = paramString;
        if (android.text.TextUtils.isEmpty(paramString)) {
          str = AbsQQText.SMALL_EMOJI_SYMBOL;
        }
        localStringBuilder.replace(i, i + 5, str);
        j = i + (str.length() - 1);
        break;
        return localStringBuilder.toString();
      }
      label432:
      j = 0;
      k = 0;
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
        break label538;
      }
    }
    label273:
    label535:
    label538:
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
      IEmoticonManager localIEmoticonManager = getEmoMgr();
      k = 0;
      i = 0;
      int m;
      if (i < localStringBuilder.length()) {
        if ((localStringBuilder.codePointAt(i) == 20) && (i < localStringBuilder.length() - 1))
        {
          j = localStringBuilder.charAt(i + 1);
          m = j;
          if (j == 250) {
            m = 10;
          }
          if (QQSysFaceUtil.isValidFaceId(m))
          {
            paramString = QQSysFaceUtil.getFaceDescription(m);
            if (k != 0) {
              break label535;
            }
            paramString = HardCodeUtil.a(2131719704) + paramString;
          }
        }
      }
      for (;;)
      {
        localStringBuilder.replace(i, i + 2, paramString);
        j = i + (paramString.length() - 1);
        do
        {
          k = 1;
          i = j;
          j = k;
          i += 1;
          k = j;
          break;
          j = i;
        } while (m != 255);
        if (i + 4 >= localStringBuilder.length())
        {
          paramString = AbsQQText.SMALL_EMOJI_SYMBOL;
          localStringBuilder.replace(i, localStringBuilder.length(), paramString);
          i += paramString.length() - 1;
          break;
        }
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
        localObject = QQSmallEmoUtils.getEmoDescripFromChars(paramString);
        paramString = "";
        if ((localObject != null) && (localObject.length == 2))
        {
          k = localObject[0];
          j = localObject[1];
        }
        for (;;)
        {
          if (localIEmoticonManager != null) {
            paramString = localIEmoticonManager.syncGetEmoticonDescriptionById(Integer.toString(k), Integer.toString(j));
          }
          localObject = paramString;
          if (android.text.TextUtils.isEmpty(paramString)) {
            localObject = AbsQQText.SMALL_EMOJI_SYMBOL;
          }
          localStringBuilder.replace(i, i + 5, (String)localObject);
          j = i + (((String)localObject).length() - 1);
          break;
          j = 0;
          break label273;
          return localStringBuilder.toString();
          j = 0;
          k = 0;
        }
      }
    }
  }
  
  public static String emoticonToTextWithoutSysEmotion(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    IEmoticonManager localIEmoticonManager = getEmoMgr();
    int i = 0;
    int j;
    int k;
    while (i < localStringBuilder.length())
    {
      j = i;
      if (localStringBuilder.codePointAt(i) == 20)
      {
        j = i;
        if (i < localStringBuilder.length() - 1)
        {
          k = localStringBuilder.charAt(i + 1);
          if (!QQSysFaceUtil.isValidFaceId(k)) {
            break label100;
          }
          paramString = QQSysFaceUtil.getFaceDescription(k);
          localStringBuilder.replace(i, i + 2, paramString);
          j = i + (paramString.length() - 1);
        }
      }
      label100:
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (k != 255);
      if (i + 4 >= localStringBuilder.length())
      {
        paramString = AbsQQText.SMALL_EMOJI_SYMBOL;
        localStringBuilder.replace(i, localStringBuilder.length(), paramString);
        i += paramString.length() - 1;
      }
      else
      {
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
        paramString = QQSmallEmoUtils.getEmoDescripFromChars(paramString);
        if ((paramString == null) || (paramString.length != 2)) {
          break label338;
        }
        k = paramString[0];
        j = paramString[1];
      }
    }
    for (;;)
    {
      if (localIEmoticonManager != null) {}
      for (paramString = localIEmoticonManager.getSmallEmoticonDescription(Integer.toString(k), Integer.toString(j));; paramString = "")
      {
        String str = paramString;
        if (android.text.TextUtils.isEmpty(paramString)) {
          str = AbsQQText.SMALL_EMOJI_SYMBOL;
        }
        localStringBuilder.replace(i, i + 5, str);
        j = i + (str.length() - 1);
        break;
        return localStringBuilder.toString();
      }
      label338:
      j = 0;
      k = 0;
    }
  }
  
  public static void fixTextViewANRForAnd10(TextView paramTextView)
  {
    if ((Build.VERSION.SDK_INT >= 29) && (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))) {}
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
  
  public static String getColorNickSysEmoticonString(int paramInt)
  {
    return String.valueOf(new char[] { '<', '$', (char)QQSysFaceUtil.convertToServer(paramInt), '>' });
  }
  
  private static IEmoticonManager getEmoMgr()
  {
    try
    {
      Object localObject = BaseApplication.getContext();
      if (Build.VERSION.SDK_INT > 10) {}
      for (int i = 4;; i = 0)
      {
        localObject = ((BaseApplication)localObject).getSharedPreferences("Last_Login", i).getString("uin", "");
        localObject = (IEmoticonManager)MobileQQ.sMobileQQ.getAppRuntime((String)localObject).getRuntimeService(IEmoticonManager.class, "all");
        return localObject;
      }
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static final Drawable getEmojiDrawable(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji index: " + paramInt);
    }
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
  
  public static final Drawable getEmojiDrawable(int paramInt, TextUtils.LoadSysEmojiCallback paramLoadSysEmojiCallback)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji index: " + paramInt);
    }
    Resources localResources = BaseApplication.getContext().getResources();
    int i = EmotcationConstants.INVALID_EMOJ_RES;
    Object localObject;
    if (paramInt >= 1000)
    {
      localObject = "emotion://" + paramInt;
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
    if ((paramInt >= 0) && (paramInt < EmotcationConstants.VALID_EMOJI_COUNT)) {}
    for (paramInt = EmotcationConstants.FIRST_EMOJI_RES + paramInt;; paramInt = i)
    {
      if (GlobalImageCache.a != null)
      {
        localObject = "android.resource://" + paramInt;
        localObject = (Pair)GlobalImageCache.a.get(localObject);
        if ((localObject != null) && (((Pair)localObject).first != null)) {
          return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(localResources);
        }
        ThreadManager.executeOnFileThread(new TextUtils.2(paramInt, paramLoadSysEmojiCallback));
        return null;
      }
      return BaseApplication.getContext().getResources().getDrawable(paramInt);
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
    Object localObject = (Pair)GlobalImageCache.a.get(str);
    if (localObject != null) {
      paramResources = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramResources);
    }
    for (;;)
    {
      return paramResources;
      try
      {
        localObject = paramResources.getDrawable(paramInt);
        paramInt = SkinUtils.a((Drawable)localObject);
        paramResources = (Resources)localObject;
        if (paramInt > 0)
        {
          GlobalImageCache.a.put(str, new Pair(((Drawable)localObject).getConstantState(), Integer.valueOf(paramInt)));
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
    int i4 = ViewUtils.a(paramInt2);
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