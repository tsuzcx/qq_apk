package com.tencent.mobileqq.text;

import ahzs;
import ahzt;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.Editable;
import android.util.Pair;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.lovelanguage.LoveLanguageConfig;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.widget.QzoneEmoticonConstants;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AccountNotMatchException;

public class TextUtils
{
  public static int a(String paramString)
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
                                    break label241;
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
        break label232;
      }
      k = paramString.charAt(i + 1);
      if (k < 56320) {
        break;
      }
      j = i;
    } while (k <= 57343);
    label232:
    while (k != 8419)
    {
      i += 1;
      break;
    }
    return i;
    label241:
    return -1;
  }
  
  public static final Drawable a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji index: " + paramInt);
    }
    int j = 2130839942;
    if (paramInt >= 1000) {
      return b(BaseApplicationImpl.getContext().getResources(), paramInt);
    }
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < EmotcationConstants.jdField_b_of_type_Int) {
        i = 2130839808 + paramInt;
      }
    }
    if (BaseApplicationImpl.sImageCache != null) {
      return a(BaseApplicationImpl.getContext().getResources(), i);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(i);
  }
  
  public static final Drawable a(int paramInt, TextUtils.LoadSysEmojiCallback paramLoadSysEmojiCallback)
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
      ThreadManager.executeOnFileThread(new ahzs(paramInt, paramLoadSysEmojiCallback));
      return null;
    }
    if ((paramInt >= 0) && (paramInt < EmotcationConstants.jdField_b_of_type_Int)) {}
    for (paramInt = 2130839808 + paramInt;; paramInt = 2130839942)
    {
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject = "android.resource://" + paramInt;
        localObject = (Pair)BaseApplicationImpl.sImageCache.get(localObject);
        if ((localObject != null) && (((Pair)localObject).first != null)) {
          return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(localResources);
        }
        ThreadManager.executeOnFileThread(new ahzt(paramInt, paramLoadSysEmojiCallback));
        return null;
      }
      return BaseApplicationImpl.getContext().getResources().getDrawable(paramInt);
    }
  }
  
  public static final Drawable a(int paramInt, boolean paramBoolean)
  {
    localObject1 = null;
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_a_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    localResources = BaseApplicationImpl.getContext().getResources();
    if (!paramBoolean)
    {
      paramInt = EmotcationConstants.jdField_b_of_type_ArrayOfInt[paramInt];
      if (BaseApplicationImpl.sImageCache != null) {
        localObject1 = a(localResources, paramInt);
      }
    }
    do
    {
      do
      {
        return localObject1;
        return localResources.getDrawable(paramInt);
        int i = EmotcationConstants.jdField_a_of_type_ArrayOfInt[paramInt];
        int j = EmotcationConstants.jdField_b_of_type_ArrayOfInt[paramInt];
        try
        {
          localObject2 = localResources.getResourceEntryName(i);
          if (QLog.isColorLevel()) {
            QLog.d("TextUtils", 2, "getDrawable host:" + (String)localObject2);
          }
          localObject2 = new URL("emotion", localResources.getResourceEntryName(i), "");
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            Object localObject2;
            if (QLog.isColorLevel()) {
              QLog.d("TextUtils", 2, "getDrawable ,", localMalformedURLException);
            }
            Object localObject3 = null;
            continue;
            localObject1 = localResources.getDrawable(j);
            localObject3 = URLDrawable.getDrawable((URL)localObject3, (Drawable)localObject1, (Drawable)localObject1, true);
          }
        }
      } while (localObject2 == null);
      localObject1 = ((URL)localObject2).toString();
      if ((BaseApplicationImpl.sImageCache == null) || (BaseApplicationImpl.sImageCache.get(localObject1) == null)) {
        break label251;
      }
      localObject1 = new ColorDrawable();
      localObject2 = URLDrawable.getDrawable((URL)localObject2, (Drawable)localObject1, (Drawable)localObject1, true);
      localObject1 = localObject2;
    } while (localObject2 == null);
    ((URLDrawable)localObject2).addHeader("faceIdx", Integer.toString(paramInt));
    return localObject2;
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
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
        paramInt = SkinUtils.a((Drawable)localObject);
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
  
  public static final String a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.d.length)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return String.valueOf(Character.toChars(EmotcationConstants.d[paramInt]));
  }
  
  public static String a(String paramString)
  {
    String str1;
    if (android.text.TextUtils.isEmpty(paramString)) {
      str1 = "";
    }
    int i;
    int j;
    do
    {
      return str1;
      i = 0;
      while (i < EmotcationConstants.d.length)
      {
        j = paramString.indexOf(EmotcationConstants.d[i], 0);
        str1 = paramString;
        if (j != -1)
        {
          str1 = paramString;
          if (j + 2 <= paramString.length()) {
            str1 = paramString.replace(paramString.substring(j, j + 2), "");
          }
        }
        i += 1;
        paramString = str1;
      }
      str1 = paramString;
    } while (!a(paramString));
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
                break label526;
              }
              paramString = (EmoticonManager)paramString.getManager(13);
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
              localStringBuilder.replace(i, localStringBuilder.length(), "[小表情]");
              i += "[小表情]".length() - 1;
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
              paramString = EmosmUtils.a(paramString);
              if (paramString == null) {
                break label519;
              }
            }
            if (i >= localStringBuilder.length()) {
              break label507;
            }
            j = i;
            if (localStringBuilder.codePointAt(i) == 20)
            {
              j = i;
              if (i < localStringBuilder.length() - 1)
              {
                k = localStringBuilder.charAt(i + 1);
                if (k >= EmotcationConstants.jdField_a_of_type_Int) {
                  continue;
                }
                paramString = EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[k];
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
          int k;
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
                str2 = "[小表情]";
              }
              localStringBuilder.replace(i, i + 5, str2);
              j = i + (str2.length() - 1);
              break;
              label507:
              return localStringBuilder.toString();
            }
            label519:
            j = 0;
            k = 0;
          }
          label526:
          paramString = null;
        }
      }
    }
  }
  
  public static String a(String paramString, int paramInt)
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
  
  public static final void a(EditText paramEditText)
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
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = SystemEmoticonInfo.jdField_b_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean a(CharSequence paramCharSequence)
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
  
  public static boolean a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    while (-1 == paramString.indexOf('\024')) {
      return false;
    }
    return true;
  }
  
  public static final Drawable b(int paramInt, boolean paramBoolean)
  {
    paramInt = LoveLanguageConfig.a((char)paramInt);
    if ((paramInt < 0) || (paramInt >= LoveLanguageConfig.jdField_a_of_type_ArrayOfInt.length)) {
      if (QLog.isColorLevel()) {
        QLog.d("TextUtils", 2, new Object[] { "love language getLoveLanguageEmotcationDrawable index ivalid :", Integer.valueOf(paramInt) });
      }
    }
    Resources localResources;
    do
    {
      return null;
      localResources = BaseApplicationImpl.getContext().getResources();
    } while (paramBoolean);
    paramInt = LoveLanguageConfig.jdField_a_of_type_ArrayOfInt[paramInt];
    if (BaseApplicationImpl.sImageCache != null) {
      return a(localResources, paramInt);
    }
    return localResources.getDrawable(paramInt);
  }
  
  /* Error */
  public static final Drawable b(Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: new 36	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   7: ldc 90
    //   9: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: iload_1
    //   13: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: astore 7
    //   21: getstatic 80	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   24: ifnull +36 -> 60
    //   27: getstatic 80	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   30: aload 7
    //   32: invokevirtual 96	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 98	android/util/Pair
    //   38: astore 5
    //   40: aload 5
    //   42: ifnull +18 -> 60
    //   45: aload 5
    //   47: getfield 102	android/util/Pair:first	Ljava/lang/Object;
    //   50: checkcast 104	android/graphics/drawable/Drawable$ConstantState
    //   53: aload_0
    //   54: invokevirtual 108	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   57: astore_0
    //   58: aload_0
    //   59: areturn
    //   60: invokestatic 377	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   63: getstatic 382	com/tencent/mobileqq/text/AppleEmojiManager:b	Ljava/lang/String;
    //   66: invokevirtual 385	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   69: astore 5
    //   71: iload_1
    //   72: sipush 1000
    //   75: isub
    //   76: i2l
    //   77: lstore_3
    //   78: aload 5
    //   80: astore_0
    //   81: aload 5
    //   83: lload_3
    //   84: invokevirtual 391	java/io/RandomAccessFile:seek	(J)V
    //   87: aload 5
    //   89: astore_0
    //   90: invokestatic 397	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   93: iconst_4
    //   94: invokevirtual 401	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   97: astore 6
    //   99: aload 5
    //   101: astore_0
    //   102: aload 5
    //   104: aload 6
    //   106: iconst_0
    //   107: iconst_4
    //   108: invokevirtual 405	java/io/RandomAccessFile:read	([BII)I
    //   111: pop
    //   112: aload 5
    //   114: astore_0
    //   115: aload 6
    //   117: invokestatic 408	com/tencent/mobileqq/text/AppleEmojiManager:a	([B)I
    //   120: istore_2
    //   121: aload 5
    //   123: astore_0
    //   124: invokestatic 397	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   127: aload 6
    //   129: invokevirtual 412	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   132: aload 5
    //   134: astore_0
    //   135: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +456 -> 594
    //   141: aload 5
    //   143: astore_0
    //   144: ldc_w 414
    //   147: iconst_2
    //   148: new 36	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 416
    //   158: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload_2
    //   162: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: goto +423 -> 594
    //   174: aload 5
    //   176: astore_0
    //   177: ldc_w 414
    //   180: iconst_4
    //   181: new 36	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 418
    //   191: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload_1
    //   195: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload 5
    //   206: ifnull +12 -> 218
    //   209: invokestatic 377	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   212: getstatic 382	com/tencent/mobileqq/text/AppleEmojiManager:b	Ljava/lang/String;
    //   215: invokevirtual 420	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   218: aconst_null
    //   219: areturn
    //   220: aload 5
    //   222: astore_0
    //   223: invokestatic 397	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   226: sipush 4096
    //   229: invokevirtual 401	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   232: astore 6
    //   234: aload 5
    //   236: astore_0
    //   237: aload 6
    //   239: iconst_0
    //   240: aload 5
    //   242: aload 6
    //   244: iconst_0
    //   245: iload_2
    //   246: invokevirtual 405	java/io/RandomAccessFile:read	([BII)I
    //   249: invokestatic 426	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   252: astore 6
    //   254: aload 5
    //   256: astore_0
    //   257: aload 6
    //   259: invokestatic 431	com/tencent/mobileqq/util/Utils:a	(Landroid/graphics/Bitmap;)I
    //   262: istore_2
    //   263: aload 5
    //   265: astore_0
    //   266: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +33 -> 302
    //   272: aload 5
    //   274: astore_0
    //   275: ldc_w 414
    //   278: iconst_2
    //   279: new 36	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 433
    //   289: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: iload_2
    //   293: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: iload_2
    //   303: ifle +154 -> 457
    //   306: aload 5
    //   308: astore_0
    //   309: new 435	android/graphics/drawable/BitmapDrawable
    //   312: dup
    //   313: aload 6
    //   315: invokespecial 438	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   318: astore 6
    //   320: aload 5
    //   322: astore_0
    //   323: getstatic 80	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   326: ifnull +70 -> 396
    //   329: aload 5
    //   331: astore_0
    //   332: getstatic 80	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   335: aload 7
    //   337: new 98	android/util/Pair
    //   340: dup
    //   341: aload 6
    //   343: invokevirtual 200	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   346: iload_2
    //   347: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   350: invokespecial 207	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   353: invokevirtual 211	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   356: pop
    //   357: aload 5
    //   359: astore_0
    //   360: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +33 -> 396
    //   366: aload 5
    //   368: astore_0
    //   369: ldc_w 414
    //   372: iconst_2
    //   373: new 36	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 440
    //   383: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: iload_1
    //   387: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: aload 5
    //   398: astore_0
    //   399: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +35 -> 437
    //   405: aload 5
    //   407: astore_0
    //   408: ldc_w 414
    //   411: iconst_2
    //   412: invokestatic 445	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   415: ldc_w 447
    //   418: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: iload_1
    //   422: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: ldc_w 449
    //   428: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload 6
    //   439: astore_0
    //   440: aload 5
    //   442: ifnull -384 -> 58
    //   445: invokestatic 377	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   448: getstatic 382	com/tencent/mobileqq/text/AppleEmojiManager:b	Ljava/lang/String;
    //   451: invokevirtual 420	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   454: aload 6
    //   456: areturn
    //   457: aload 5
    //   459: ifnull +12 -> 471
    //   462: invokestatic 377	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   465: getstatic 382	com/tencent/mobileqq/text/AppleEmojiManager:b	Ljava/lang/String;
    //   468: invokevirtual 420	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   471: aconst_null
    //   472: areturn
    //   473: astore 6
    //   475: aconst_null
    //   476: astore 5
    //   478: aload 5
    //   480: astore_0
    //   481: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +18 -> 502
    //   487: aload 5
    //   489: astore_0
    //   490: ldc_w 414
    //   493: iconst_2
    //   494: ldc_w 451
    //   497: aload 6
    //   499: invokestatic 454	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   502: aload 5
    //   504: ifnonnull +9 -> 513
    //   507: aload 5
    //   509: astore_0
    //   510: invokestatic 456	com/tencent/mobileqq/text/EmotcationConstants:b	()V
    //   513: aload 5
    //   515: ifnull +12 -> 527
    //   518: invokestatic 377	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   521: getstatic 382	com/tencent/mobileqq/text/AppleEmojiManager:b	Ljava/lang/String;
    //   524: invokevirtual 420	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   527: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   530: ifeq +32 -> 562
    //   533: ldc_w 414
    //   536: iconst_2
    //   537: invokestatic 445	com/tencent/mobileqq/activity/aio/AIOUtils:a	()Ljava/lang/StringBuilder;
    //   540: ldc_w 447
    //   543: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: iload_1
    //   547: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   550: ldc_w 458
    //   553: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 154	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: aconst_null
    //   563: areturn
    //   564: astore 5
    //   566: aconst_null
    //   567: astore_0
    //   568: aload_0
    //   569: ifnull +12 -> 581
    //   572: invokestatic 377	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   575: getstatic 382	com/tencent/mobileqq/text/AppleEmojiManager:b	Ljava/lang/String;
    //   578: invokevirtual 420	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)V
    //   581: aload 5
    //   583: athrow
    //   584: astore 5
    //   586: goto -18 -> 568
    //   589: astore 6
    //   591: goto -113 -> 478
    //   594: iload_2
    //   595: iflt -421 -> 174
    //   598: iload_2
    //   599: sipush 4096
    //   602: if_icmple -382 -> 220
    //   605: goto -431 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	paramResources	Resources
    //   0	608	1	paramInt	int
    //   120	483	2	i	int
    //   77	7	3	l	long
    //   38	476	5	localObject1	Object
    //   564	18	5	localObject2	Object
    //   584	1	5	localObject3	Object
    //   97	358	6	localObject4	Object
    //   473	25	6	localThrowable1	Throwable
    //   589	1	6	localThrowable2	Throwable
    //   19	317	7	str	String
    // Exception table:
    //   from	to	target	type
    //   60	71	473	java/lang/Throwable
    //   60	71	564	finally
    //   81	87	584	finally
    //   90	99	584	finally
    //   102	112	584	finally
    //   115	121	584	finally
    //   124	132	584	finally
    //   135	141	584	finally
    //   144	171	584	finally
    //   177	204	584	finally
    //   223	234	584	finally
    //   237	254	584	finally
    //   257	263	584	finally
    //   266	272	584	finally
    //   275	302	584	finally
    //   309	320	584	finally
    //   323	329	584	finally
    //   332	357	584	finally
    //   360	366	584	finally
    //   369	396	584	finally
    //   399	405	584	finally
    //   408	437	584	finally
    //   481	487	584	finally
    //   490	502	584	finally
    //   510	513	584	finally
    //   81	87	589	java/lang/Throwable
    //   90	99	589	java/lang/Throwable
    //   102	112	589	java/lang/Throwable
    //   115	121	589	java/lang/Throwable
    //   124	132	589	java/lang/Throwable
    //   135	141	589	java/lang/Throwable
    //   144	171	589	java/lang/Throwable
    //   177	204	589	java/lang/Throwable
    //   223	234	589	java/lang/Throwable
    //   237	254	589	java/lang/Throwable
    //   257	263	589	java/lang/Throwable
    //   266	272	589	java/lang/Throwable
    //   275	302	589	java/lang/Throwable
    //   309	320	589	java/lang/Throwable
    //   323	329	589	java/lang/Throwable
    //   332	357	589	java/lang/Throwable
    //   360	366	589	java/lang/Throwable
    //   369	396	589	java/lang/Throwable
    //   399	405	589	java/lang/Throwable
    //   408	437	589	java/lang/Throwable
  }
  
  public static final String b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= QzoneEmoticonConstants.e.length)) {
      throw new IllegalArgumentException("invaid emotcation index: " + paramInt);
    }
    return String.valueOf(Character.toChars(QzoneEmoticonConstants.e[paramInt]));
  }
  
  public static String b(String paramString)
  {
    int i = a(paramString);
    if (i != -1)
    {
      if (i + 2 > paramString.length()) {}
      for (int j = paramString.length();; j = i + 2)
      {
        paramString = paramString.replace(paramString.substring(i, j), "");
        i = a(paramString);
        break;
      }
    }
    return paramString;
  }
  
  public static boolean b(String paramString)
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
  
  public static final String c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_a_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return String.valueOf(new char[] { '\024', (char)paramInt });
  }
  
  public static String c(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      localObject1 = "";
    }
    do
    {
      return localObject1;
      localObject1 = paramString;
    } while (!a(paramString));
    Object localObject1 = BaseApplicationImpl.getContext();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    StringBuilder localStringBuilder;
    int j;
    int k;
    label237:
    Object localObject3;
    label243:
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
              break label237;
            }
            localObject1 = (EmoticonManager)((AppInterface)localObject1).getManager(13);
            localStringBuilder = new StringBuilder(paramString);
            i = 0;
            if (i >= localStringBuilder.length()) {
              break label467;
            }
            j = i;
            if (localStringBuilder.codePointAt(i) == 20)
            {
              j = i;
              if (i < localStringBuilder.length() - 1)
              {
                k = localStringBuilder.charAt(i + 1);
                if ((k >= EmotcationConstants.jdField_a_of_type_Int) && (250 != k)) {
                  break label243;
                }
                j = k;
                if (250 == k) {
                  j = 10;
                }
                paramString = EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[j];
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
              break label292;
            }
            localStringBuilder.replace(i, localStringBuilder.length(), "[小表情]");
            i += "[小表情]".length() - 1;
          }
        }
        label292:
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
        paramString = EmosmUtils.a(paramString);
        str = "[小表情]";
        if (paramString == null) {
          break label478;
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
        label467:
        return localStringBuilder.toString();
      }
      label478:
      j = 0;
      k = 0;
    }
  }
  
  public static final String d(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_a_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
  }
  
  public static String d(String paramString)
  {
    Object localObject;
    if (android.text.TextUtils.isEmpty(paramString)) {
      localObject = "";
    }
    int i;
    int j;
    do
    {
      return localObject;
      i = 0;
      while (i < EmotcationConstants.d.length)
      {
        j = paramString.indexOf(EmotcationConstants.d[i], 0);
        localObject = paramString;
        if (j != -1)
        {
          localObject = paramString;
          if (j + 2 <= paramString.length())
          {
            localObject = EmotcationConstants.a(i);
            localObject = paramString.replace(paramString.substring(j, j + 2), (CharSequence)localObject);
          }
        }
        i += 1;
        paramString = (String)localObject;
      }
      localObject = paramString;
    } while (!a(paramString));
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    paramString = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    for (;;)
    {
      paramString = paramString.getSharedPreferences("Last_Login", i).getString("uin", "");
      label288:
      label573:
      label578:
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
              break label327;
            }
            paramString = (EmoticonManager)paramString.getManager(13);
            k = 0;
            i = 0;
            if (i >= localStringBuilder.length()) {
              break label578;
            }
            if ((localStringBuilder.codePointAt(i) != 20) || (i >= localStringBuilder.length() - 1)) {
              break label573;
            }
            m = localStringBuilder.charAt(i + 1);
            if (m >= EmotcationConstants.jdField_a_of_type_Int) {
              break label332;
            }
            localObject = EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[m];
            if (k != 0) {
              break label597;
            }
            localObject = "表情" + (String)localObject;
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
        label327:
        label332:
        label597:
        for (;;)
        {
          int k;
          int m;
          paramString.printStackTrace();
          paramString = null;
          continue;
          paramString = null;
          continue;
          j = i;
          if (m == 255) {
            if (i + 4 >= localStringBuilder.length())
            {
              localStringBuilder.replace(i, localStringBuilder.length(), "[小表情]");
              i += "[小表情]".length() - 1;
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
              localObject = EmosmUtils.a((char[])localObject);
              String str = "[小表情]";
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
                  j = 0;
                  break label288;
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
  
  public static String e(String paramString)
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
  
  public static String f(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils
 * JD-Core Version:    0.7.0.1
 */