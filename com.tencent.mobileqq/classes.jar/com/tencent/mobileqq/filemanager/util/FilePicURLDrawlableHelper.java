package com.tencent.mobileqq.filemanager.util;

import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FilePicURLDrawlableHelper
{
  public static int a;
  private static List<String> a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static int f;
  public static final int g;
  public static final int h;
  
  static
  {
    jdField_a_of_type_Int = 232;
    b = 750;
    c = 130;
    d = 421;
    if (BaseChatItemLayout.f > 0)
    {
      jdField_a_of_type_Int = BaseChatItemLayout.f;
      c = (int)(BaseChatItemLayout.f * 0.5625F);
    }
    e = jdField_a_of_type_Int;
    f = c;
    float f1 = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density;
    if (f1 != 0.0F)
    {
      e = (int)(jdField_a_of_type_Int / f1);
      f = (int)(c / f1);
    }
    g = c;
    h = jdField_a_of_type_Int;
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      paramInt2 = 0;
      return paramInt2;
    }
    int j = 1;
    int i = paramInt1;
    paramInt1 = j;
    for (;;)
    {
      i >>= 1;
      paramInt2 >>= 1;
      if ((i < paramInt3) || (paramInt2 < paramInt3))
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= 1) {
          break;
        }
        return 1;
      }
      paramInt1 *= 2;
    }
  }
  
  public static long a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      if (jdField_a_of_type_JavaUtilList.contains(paramString)) {
        return -1L;
      }
      jdField_a_of_type_JavaUtilList.add(paramString);
      return 1L;
    }
  }
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 90	java/io/BufferedInputStream
    //   5: dup
    //   6: new 92	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 98	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: aload_2
    //   21: aconst_null
    //   22: aload_1
    //   23: invokestatic 104	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_2
    //   30: ifnull +9 -> 39
    //   33: aload_2
    //   34: invokevirtual 109	java/io/InputStream:close	()V
    //   37: aload_1
    //   38: astore_0
    //   39: aload_0
    //   40: areturn
    //   41: astore_1
    //   42: aconst_null
    //   43: astore_2
    //   44: aload_2
    //   45: astore_0
    //   46: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +14 -> 63
    //   52: aload_2
    //   53: astore_0
    //   54: ldc 117
    //   56: iconst_2
    //   57: ldc 119
    //   59: aload_1
    //   60: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   63: aload_3
    //   64: astore_0
    //   65: aload_2
    //   66: ifnull -27 -> 39
    //   69: aload_2
    //   70: invokevirtual 109	java/io/InputStream:close	()V
    //   73: aconst_null
    //   74: areturn
    //   75: astore_0
    //   76: aconst_null
    //   77: areturn
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_2
    //   81: aload_2
    //   82: astore_0
    //   83: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +14 -> 100
    //   89: aload_2
    //   90: astore_0
    //   91: ldc 117
    //   93: iconst_2
    //   94: ldc 124
    //   96: aload_1
    //   97: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload_3
    //   101: astore_0
    //   102: aload_2
    //   103: ifnull -64 -> 39
    //   106: aload_2
    //   107: invokevirtual 109	java/io/InputStream:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: areturn
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 109	java/io/InputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_0
    //   129: aload_1
    //   130: areturn
    //   131: astore_0
    //   132: goto -6 -> 126
    //   135: astore_1
    //   136: goto -18 -> 118
    //   139: astore_1
    //   140: goto -59 -> 81
    //   143: astore_1
    //   144: goto -100 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString	String
    //   0	147	1	paramOptions	BitmapFactory.Options
    //   17	90	2	localBufferedInputStream	java.io.BufferedInputStream
    //   1	100	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	41	java/lang/OutOfMemoryError
    //   69	73	75	java/io/IOException
    //   2	18	78	java/lang/Exception
    //   106	110	112	java/io/IOException
    //   2	18	115	finally
    //   33	37	128	java/io/IOException
    //   122	126	131	java/io/IOException
    //   20	27	135	finally
    //   46	52	135	finally
    //   54	63	135	finally
    //   83	89	135	finally
    //   91	100	135	finally
    //   20	27	139	java/lang/Exception
    //   20	27	143	java/lang/OutOfMemoryError
  }
  
  public static FilePicURLDrawlableHelper.AIOImgInfo a(int paramInt1, int paramInt2, FilePicURLDrawlableHelper.Type paramType, boolean paramBoolean)
  {
    int i1 = jdField_a_of_type_Int;
    int i2 = c;
    int j;
    int i;
    int k;
    int m;
    int i3;
    int n;
    switch (paramType.b)
    {
    case 2: 
    case 4: 
    case 5: 
    default: 
      j = paramInt2;
      i = paramInt1;
      k = paramInt2;
      m = paramInt1;
      if (i > j)
      {
        i3 = i;
        n = j;
        switch (paramType.jdField_a_of_type_Int)
        {
        default: 
          paramType = new FilePicURLDrawlableHelper.AIOImgInfo();
          paramType.jdField_a_of_type_Int = paramInt1;
          paramType.b = paramInt2;
          return paramType;
        }
      }
      break;
    case 1: 
    case 3: 
    case 6: 
      label79:
      if (paramInt1 > paramInt2)
      {
        i = paramInt2;
        k = (int)(i * 1.777778F);
        if (paramInt1 <= paramInt2) {
          break label199;
        }
        j = i;
        i = k;
        if (k > paramInt1) {
          i = paramInt1;
        }
        if (j <= paramInt2) {
          break label474;
        }
      }
      label140:
      label158:
      break;
    }
    for (;;)
    {
      j = paramInt2;
      k = paramInt2;
      m = i;
      paramInt1 = i;
      break;
      i = paramInt1;
      break label140;
      label199:
      j = k;
      k = i;
      break label158;
      i3 = j;
      n = i;
      break label79;
      float f1 = i2 / (n * 1.0F);
      n = (int)(i3 * f1);
      if (m > paramInt1) {}
      for (;;)
      {
        if (k > paramInt2) {}
        for (;;)
        {
          k = Math.round(paramInt1 * f1);
          m = Math.round(paramInt2 * f1);
          if (i > j)
          {
            paramInt2 = i2;
            i = i1;
            label287:
            paramInt1 = i;
            if (i > k) {
              paramInt1 = k;
            }
            if (paramInt2 <= m) {
              break label459;
            }
            paramInt2 = m;
          }
          label405:
          label441:
          label459:
          for (;;)
          {
            break;
            paramInt2 = i1;
            i = i2;
            break label287;
            f1 = i1 / (i3 * 1.0F);
            n = (int)(n * f1);
            if ((i <= j) || (m > paramInt1)) {}
            for (;;)
            {
              if (k > paramInt2) {}
              for (;;)
              {
                paramInt1 = Math.round(paramInt1 * f1);
                paramInt2 = Math.round(paramInt2 * f1);
                break;
                break;
                k = (int)(n * 1.777778F);
                if (i > j)
                {
                  i = n;
                  j = k;
                  if (k > paramInt1) {
                    j = paramInt1;
                  }
                  if (i <= paramInt2) {
                    break label441;
                  }
                }
                for (;;)
                {
                  paramInt1 = j;
                  break;
                  i = k;
                  k = n;
                  break label405;
                  paramInt2 = i;
                }
                paramInt2 = k;
              }
              paramInt1 = m;
            }
          }
          paramInt2 = k;
        }
        paramInt1 = m;
      }
      label474:
      paramInt2 = j;
    }
  }
  
  public static FilePicURLDrawlableHelper.AIOImgInfo a(int paramInt1, int paramInt2, String paramString)
  {
    int i = g;
    int j = h;
    FilePicURLDrawlableHelper.AIOImgInfo localAIOImgInfo = new FilePicURLDrawlableHelper.AIOImgInfo();
    float f1;
    if (FileUtils.b(paramString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      a(paramString, localOptions);
      localAIOImgInfo.jdField_a_of_type_Int = localOptions.outWidth;
      localAIOImgInfo.b = localOptions.outHeight;
      paramString = localAIOImgInfo;
      paramInt2 = paramString.jdField_a_of_type_Int;
      paramInt1 = paramString.b;
      f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      if ((paramInt2 >= f) && (paramInt1 >= f)) {
        break label234;
      }
      if (paramInt2 < paramInt1)
      {
        f1 = c / paramInt2;
        i = c;
        j = (int)(f1 * paramInt1 + 0.5F);
        paramInt1 = j;
        paramInt2 = i;
        if (j > jdField_a_of_type_Int)
        {
          paramInt1 = jdField_a_of_type_Int;
          paramInt2 = i;
        }
        label157:
        paramString.jdField_a_of_type_Int = paramInt2;
        paramString.b = paramInt1;
        return paramString;
      }
    }
    else
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
        break label379;
      }
      i = paramInt2;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      paramString = a(paramInt2, i, false);
      break;
      paramInt2 = (int)(c / paramInt1 * paramInt2 + 0.5F);
      paramInt1 = paramInt2;
      if (paramInt2 > jdField_a_of_type_Int) {
        paramInt1 = jdField_a_of_type_Int;
      }
      i = c;
      paramInt2 = paramInt1;
      paramInt1 = i;
      break label157;
      label234:
      if ((paramInt2 < e) && (paramInt1 < e))
      {
        paramInt2 = (int)(paramInt2 * f1 + 0.5F);
        paramInt1 = (int)(f1 * paramInt1 + 0.5F);
        break label157;
      }
      if (paramInt2 > paramInt1)
      {
        f1 = jdField_a_of_type_Int / paramInt2;
        label282:
        if (paramInt2 <= paramInt1) {
          break label367;
        }
      }
      label367:
      for (float f2 = c / paramInt1;; f2 = c / paramInt2)
      {
        f1 = Math.max(f1, f2);
        paramInt2 = (int)(paramInt2 * f1 + 0.5F);
        paramInt1 = (int)(f1 * paramInt1 + 0.5F);
        paramInt2 = Math.min(paramInt2, jdField_a_of_type_Int);
        paramInt1 = Math.min(paramInt1, jdField_a_of_type_Int);
        paramInt2 = Math.max(paramInt2, c);
        paramInt1 = Math.max(paramInt1, c);
        break;
        f1 = jdField_a_of_type_Int / paramInt1;
        break label282;
      }
      label379:
      paramInt1 = j;
      paramInt2 = i;
      i = paramInt1;
    }
  }
  
  public static FilePicURLDrawlableHelper.AIOImgInfo a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i;
    if (paramInt1 > paramInt2) {
      i = paramInt2;
    }
    for (int j = paramInt1;; j = paramInt2)
    {
      FilePicURLDrawlableHelper.Type localType = a(i, j);
      i = a(paramInt1, paramInt2, jdField_a_of_type_Int);
      return a(paramInt1 * i, i * paramInt2, localType, false);
      i = paramInt1;
    }
  }
  
  public static FilePicURLDrawlableHelper.AIOImgInfo a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    FilePicURLDrawlableHelper.AIOImgInfo localAIOImgInfo = new FilePicURLDrawlableHelper.AIOImgInfo();
    int j;
    int i;
    float f1;
    int k;
    if (FileUtils.b(paramFileManagerEntity.strMiddleThumPath))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      a(paramFileManagerEntity.strMiddleThumPath, localOptions);
      localAIOImgInfo.jdField_a_of_type_Int = localOptions.outWidth;
      localAIOImgInfo.b = localOptions.outHeight;
      paramFileManagerEntity = localAIOImgInfo;
      j = paramFileManagerEntity.jdField_a_of_type_Int;
      i = paramFileManagerEntity.b;
      f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
      if ((j >= f) && (i >= f)) {
        break label272;
      }
      if (j >= i) {
        break label226;
      }
      f1 = c / j;
      k = c;
      int m = (int)(f1 * i + 0.5F);
      i = m;
      j = k;
      if (m > jdField_a_of_type_Int)
      {
        i = jdField_a_of_type_Int;
        j = k;
      }
    }
    for (;;)
    {
      paramFileManagerEntity.jdField_a_of_type_Int = j;
      paramFileManagerEntity.b = i;
      return paramFileManagerEntity;
      if ((paramFileManagerEntity.imgWidth > 0) && (paramFileManagerEntity.imgHeight > 0)) {
        j = paramFileManagerEntity.imgWidth;
      }
      for (i = paramFileManagerEntity.imgHeight;; i = h)
      {
        paramFileManagerEntity = a(j, i, false);
        break;
        j = g;
      }
      label226:
      j = (int)(c / i * j + 0.5F);
      i = j;
      if (j > jdField_a_of_type_Int) {
        i = jdField_a_of_type_Int;
      }
      k = c;
      j = i;
      i = k;
      continue;
      label272:
      if ((j >= e) || (i >= e)) {
        break label310;
      }
      j = (int)(j * f1 + 0.5F);
      i = (int)(f1 * i + 0.5F);
    }
    label310:
    if (j > i)
    {
      f1 = jdField_a_of_type_Int / j;
      label325:
      if (j <= i) {
        break label379;
      }
    }
    label379:
    for (float f2 = c / i;; f2 = c / j)
    {
      f1 = Math.max(f1, f2);
      j = (int)(j * f1 + 0.5F);
      i = (int)(f1 * i + 0.5F);
      break;
      f1 = jdField_a_of_type_Int / i;
      break label325;
    }
  }
  
  private static FilePicURLDrawlableHelper.Type a(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 1;
    int k = jdField_a_of_type_Int;
    int m = c;
    if (paramInt1 > k) {
      if (a(paramInt1, paramInt2))
      {
        paramInt2 = 1;
        paramInt1 = j;
      }
    }
    for (;;)
    {
      FilePicURLDrawlableHelper.Type localType = new FilePicURLDrawlableHelper.Type();
      localType.jdField_a_of_type_Int = paramInt2;
      localType.b = paramInt1;
      return localType;
      paramInt1 = 2;
      paramInt2 = 2;
      continue;
      if ((paramInt1 <= k) && (paramInt1 > m))
      {
        if (paramInt2 > k)
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt2 = 1;
            paramInt1 = 3;
            continue;
          }
          paramInt1 = 4;
          paramInt2 = 2;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          paramInt1 = 5;
          paramInt2 = 3;
        }
      }
      else if ((paramInt1 <= m) && (paramInt1 > 0))
      {
        if (paramInt2 > k)
        {
          paramInt1 = 6;
          paramInt2 = 4;
          continue;
        }
        if ((paramInt2 <= k) && (paramInt2 > m))
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt1 = 7;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 8;
          paramInt2 = 3;
          continue;
        }
        if ((paramInt2 <= m) && (paramInt2 > 0))
        {
          if (a(paramInt1, paramInt2))
          {
            paramInt1 = 9;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 10;
          paramInt2 = 3;
          continue;
        }
      }
      paramInt1 = 0;
      paramInt2 = i;
    }
  }
  
  public static String a(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "qlarge-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "qxlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "getThumbPath entity is null, so return null");
      localObject = null;
      return localObject;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
      paramFileManagerEntity = MD5.a(paramFileManagerEntity.strFileMd5);
    }
    for (;;)
    {
      localObject = paramFileManagerEntity;
      if (paramFileManagerEntity == null) {
        break;
      }
      return paramFileManagerEntity.replace("/", "");
      if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid))
      {
        paramFileManagerEntity = MD5.a(paramFileManagerEntity.Uuid);
      }
      else if (FileUtil.b(paramFileManagerEntity.getFilePath()))
      {
        localObject = FileManagerUtil.e(paramFileManagerEntity.getFilePath());
        if ((localObject != null) && (localObject.length > 0)) {
          paramFileManagerEntity = HexUtil.bytes2HexStr((byte[])localObject).toUpperCase();
        } else {
          paramFileManagerEntity = MD5.a(paramFileManagerEntity.fileName);
        }
      }
      else
      {
        paramFileManagerEntity = MD5.a(paramFileManagerEntity.fileName);
      }
    }
  }
  
  public static String a(String paramString)
  {
    if (!FileUtil.b(paramString)) {}
    label141:
    for (;;)
    {
      return null;
      String str1 = HexUtil.bytes2HexStr(FileManagerUtil.e(paramString));
      a();
      str1 = FMSettings.a().d() + a(5, str1);
      String str2 = str1 + "_original_.tmp";
      if (FileUtils.b(paramString)) {}
      for (;;)
      {
        for (;;)
        {
          if (paramString == null) {
            break label141;
          }
          try
          {
            if (!FileUtils.b(str2)) {
              Utils.a(paramString, str2, true, "", 1);
            }
            if ((!FileUtils.b(str2)) || (FileUtils.b(new File(str2), new File(str1)) != true)) {
              break;
            }
            return str1;
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
        }
        paramString = null;
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = null;
    if (a(paramString2) == -1L)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile temp Thumb file " + paramString2 + " is creating");
      return null;
    }
    if (!FileUtils.b(paramString1))
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile file " + paramString1 + " is not exist");
      paramString1 = localObject;
    }
    for (;;)
    {
      a(paramString2);
      return paramString1;
      a();
      String str = paramString2 + ".tmp";
      try
      {
        Utils.a(paramString1, str, true, "", paramInt);
        if (FileUtils.b(str)) {
          break label220;
        }
        QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile created tmp Thumb file " + str + " failed");
        paramString1 = localObject;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile created tmp Thumb file " + str + " failed");
        paramString1 = localObject;
      }
      continue;
      label220:
      if (!FileUtils.b(new File(str), new File(paramString2)))
      {
        FileUtils.a(str, true);
        QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithFile rename tmp Thumb file " + str + " failed");
        paramString1 = localObject;
      }
      else
      {
        paramString1 = paramString2;
      }
    }
  }
  
  public static URL a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    String str;
    do
    {
      return null;
      int j = 0;
      int i = j;
      if (paramFileManagerEntity.getCloudType() == 3)
      {
        i = j;
        if (!FileUtils.b(paramFileManagerEntity.strMiddleThumPath)) {
          i = 1;
        }
      }
      if (i == 0) {
        break;
      }
      str = a(paramFileManagerEntity.getFilePath());
    } while (str == null);
    Object localObject2 = paramFileManagerEntity.strFileMd5;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = paramFileManagerEntity.Uuid;
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = HexUtil.bytes2HexStr(FileManagerUtil.e(paramFileManagerEntity.getFilePath())).toUpperCase();
    }
    localObject1 = FMSettings.a().d() + a(5, MD5.a((String)localObject2));
    if ((FileUtils.b(str)) && (!FileUtil.b(paramFileManagerEntity.strMiddleThumPath)) && (FileUtils.b(new File(str), new File((String)localObject1)) == true)) {
      paramFileManagerEntity.strMiddleThumPath = ((String)localObject1);
    }
    return b(paramFileManagerEntity);
  }
  
  private static void a()
  {
    File localFile = new File(FMSettings.a().d());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithOrig entity is null, so return null");
      return;
    }
    if (FileUtils.b(paramFileManagerEntity.strMiddleThumPath))
    {
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithOrig Thumb file " + paramFileManagerEntity.strMiddleThumPath + " already exist");
      return;
    }
    a(paramFileManagerEntity, paramFileManagerEntity.getFilePath());
  }
  
  private static void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    String str = a(paramFileManagerEntity);
    paramString = a(paramString, FMSettings.a().d() + a(5, str), 1);
    if (paramString == null) {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQlarge failed");
    }
    do
    {
      return;
      paramFileManagerEntity.strMiddleThumPath = paramString;
      paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramString == null);
    paramString.getFileManagerDataCenter().c(paramFileManagerEntity);
    paramString.getFileManagerNotifyCenter().a(true, 3, null);
  }
  
  private static void a(String paramString)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      jdField_a_of_type_JavaUtilList.remove(paramString);
      return;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt2 > (int)(paramInt1 * 1.777778F);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return b(paramFileManagerEntity.imgWidth, paramFileManagerEntity.imgHeight);
  }
  
  public static URL b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    Object localObject2 = paramFileManagerEntity.strMiddleThumPath;
    Object localObject1 = localObject2;
    if (paramFileManagerEntity.status == 16)
    {
      localObject1 = localObject2;
      if (!FileUtil.b((String)localObject2))
      {
        if (!FileUtil.b(paramFileManagerEntity.strLargeThumPath)) {
          break label129;
        }
        localObject1 = paramFileManagerEntity.strLargeThumPath;
      }
    }
    label46:
    localObject2 = localObject1;
    if (!FileUtil.b((String)localObject1))
    {
      localObject2 = localObject1;
      if (FileUtil.b(paramFileManagerEntity.strLargeThumPath))
      {
        localObject1 = paramFileManagerEntity.strLargeThumPath;
        localObject2 = localObject1;
        if (a(paramFileManagerEntity))
        {
          ThreadManager.post(new FilePicURLDrawlableHelper.1(paramFileManagerEntity), 8, null, false);
          localObject2 = localObject1;
        }
      }
    }
    if (FileUtils.b((String)localObject2)) {}
    for (;;)
    {
      label129:
      try
      {
        paramFileManagerEntity = AsyncImageView.a((String)localObject2, -1, -1, new File((String)localObject2), false, false, true);
        if (paramFileManagerEntity == null) {
          break;
        }
        return paramFileManagerEntity;
      }
      catch (Exception paramFileManagerEntity) {}
      localObject1 = localObject2;
      if (!FileUtil.b(paramFileManagerEntity.strThumbPath)) {
        break label46;
      }
      localObject1 = paramFileManagerEntity.strThumbPath;
      break label46;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FilePicURLDrawlableHelper<FileAssistant>", 1, "createFilePicDrawlableURL generateAIOThumbURL error!");
      return null;
      paramFileManagerEntity = null;
    }
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQXLarge entity is null, so return null");
      return;
    }
    if (FileUtils.b(paramFileManagerEntity.strMiddleThumPath))
    {
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQXLarge Thumb file " + paramFileManagerEntity.strMiddleThumPath + " already exist");
      return;
    }
    a(paramFileManagerEntity, paramFileManagerEntity.strLargeThumPath);
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    if ((paramInt2 <= 0) || (paramInt1 <= 0)) {}
    for (;;)
    {
      return true;
      int i;
      if (paramInt1 > paramInt2)
      {
        i = paramInt2;
        paramInt2 = paramInt1;
      }
      while (!a(i, paramInt2))
      {
        return false;
        i = paramInt1;
      }
    }
  }
  
  public static void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQlarge entity is null, so return null");
      return;
    }
    if (FileUtils.b(paramFileManagerEntity.strMiddleThumPath)) {}
    a(paramFileManagerEntity, paramFileManagerEntity.strMiddleThumPath);
  }
  
  public static void d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig entity is null, so return");
      return;
    }
    if (paramFileManagerEntity.nFileType != 0)
    {
      QLog.i("FilePicURLDrawlableHelper<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] createQXlargeThumbWithOrig is not image file!");
      return;
    }
    if (FileUtils.b(paramFileManagerEntity.strLargeThumPath))
    {
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig Thumb file " + paramFileManagerEntity.strLargeThumPath + " already exist");
      return;
    }
    String str = a(paramFileManagerEntity);
    str = FMSettings.a().d() + a(7, str);
    str = a(paramFileManagerEntity.getFilePath(), str, 2);
    if (str == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig failed");
      return;
    }
    paramFileManagerEntity.strLargeThumPath = str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper
 * JD-Core Version:    0.7.0.1
 */