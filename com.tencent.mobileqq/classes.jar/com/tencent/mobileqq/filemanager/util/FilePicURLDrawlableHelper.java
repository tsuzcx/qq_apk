package com.tencent.mobileqq.filemanager.util;

import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.FilePicConstants;
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
  public static int b;
  public static final int c = FilePicConstants.b;
  public static final int d = FilePicConstants.c;
  private static List<String> e = new ArrayList();
  
  static
  {
    if (BaseChatItemLayout.f > 0)
    {
      FilePicConstants.c = BaseChatItemLayout.f;
      FilePicConstants.b = (int)(BaseChatItemLayout.f * 0.5625F);
    }
    a = FilePicConstants.c;
    b = FilePicConstants.b;
    float f = BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density;
    if (f != 0.0F)
    {
      a = (int)(FilePicConstants.c / f);
      b = (int)(FilePicConstants.b / f);
    }
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      int j = 1;
      int k = 1;
      int i = paramInt1;
      paramInt1 = k;
      for (;;)
      {
        i >>= 1;
        paramInt2 >>= 1;
        if ((i < paramInt3) || (paramInt2 < paramInt3)) {
          break;
        }
        paramInt1 *= 2;
      }
      paramInt2 = j;
      if (paramInt1 >= 1) {
        paramInt2 = paramInt1;
      }
      return paramInt2;
    }
    return 0;
  }
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 73	java/io/BufferedInputStream
    //   5: dup
    //   6: new 75	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 78	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 81	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: astore_0
    //   20: aload_2
    //   21: aconst_null
    //   22: aload_1
    //   23: invokestatic 87	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: aload_2
    //   30: invokevirtual 92	java/io/InputStream:close	()V
    //   33: aload_0
    //   34: areturn
    //   35: astore_1
    //   36: goto +16 -> 52
    //   39: astore_1
    //   40: goto +34 -> 74
    //   43: astore_1
    //   44: aconst_null
    //   45: astore_0
    //   46: goto +59 -> 105
    //   49: astore_1
    //   50: aconst_null
    //   51: astore_2
    //   52: aload_2
    //   53: astore_0
    //   54: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +71 -> 128
    //   60: aload_2
    //   61: astore_0
    //   62: ldc 100
    //   64: iconst_2
    //   65: ldc 102
    //   67: aload_1
    //   68: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   71: goto +57 -> 128
    //   74: aload_2
    //   75: astore_0
    //   76: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +14 -> 93
    //   82: aload_2
    //   83: astore_0
    //   84: ldc 100
    //   86: iconst_2
    //   87: ldc 107
    //   89: aload_1
    //   90: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   93: aload_2
    //   94: ifnull +8 -> 102
    //   97: aload_3
    //   98: astore_0
    //   99: goto -70 -> 29
    //   102: aconst_null
    //   103: areturn
    //   104: astore_1
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 92	java/io/InputStream:close	()V
    //   113: goto +5 -> 118
    //   116: aload_1
    //   117: athrow
    //   118: goto -2 -> 116
    //   121: astore_1
    //   122: aload_0
    //   123: areturn
    //   124: astore_0
    //   125: goto -12 -> 113
    //   128: aload_2
    //   129: ifnull -27 -> 102
    //   132: aload_3
    //   133: astore_0
    //   134: goto -105 -> 29
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_2
    //   140: goto -66 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   0	143	1	paramOptions	BitmapFactory.Options
    //   17	123	2	localBufferedInputStream	java.io.BufferedInputStream
    //   1	132	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   20	27	35	java/lang/Exception
    //   20	27	39	java/lang/OutOfMemoryError
    //   2	18	43	finally
    //   2	18	49	java/lang/Exception
    //   20	27	104	finally
    //   54	60	104	finally
    //   62	71	104	finally
    //   76	82	104	finally
    //   84	93	104	finally
    //   29	33	121	java/io/IOException
    //   109	113	124	java/io/IOException
    //   2	18	137	java/lang/OutOfMemoryError
  }
  
  public static FilePicURLDrawlableHelper.AIOImgInfo a(int paramInt1, int paramInt2, FilePicURLDrawlableHelper.Type paramType, boolean paramBoolean)
  {
    int m = FilePicConstants.c;
    int n = FilePicConstants.b;
    int i = paramType.b;
    int k;
    int j;
    if ((i == 1) || (i == 3) || (i == 6))
    {
      if (paramInt1 > paramInt2) {
        i = paramInt2;
      } else {
        i = paramInt1;
      }
      i1 = (int)(i * 1.777778F);
      k = i;
      j = i1;
      if (paramInt1 > paramInt2)
      {
        k = i1;
        j = i;
      }
      if (k <= paramInt1) {
        paramInt1 = k;
      }
      if (j <= paramInt2) {
        paramInt2 = j;
      }
    }
    if (paramInt1 > paramInt2)
    {
      i = paramInt1;
      j = paramInt2;
    }
    else
    {
      j = paramInt1;
      i = paramInt2;
    }
    int i1 = paramType.a;
    float f;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        k = paramInt1;
        i = paramInt2;
        if (i1 != 3) {
          if (i1 != 4)
          {
            k = paramInt1;
            i = paramInt2;
          }
          else
          {
            i = (int)(j * 1.777778F);
            if (paramInt1 <= paramInt2)
            {
              k = i;
              i = j;
              j = k;
            }
            if (i <= paramInt1) {
              paramInt1 = i;
            }
            if (j > paramInt2)
            {
              k = paramInt1;
              i = paramInt2;
            }
            else
            {
              i = j;
              k = paramInt1;
            }
          }
        }
      }
      else
      {
        f = m / (i * 1.0F);
        k = Math.round(paramInt1 * f);
        i = Math.round(paramInt2 * f);
      }
    }
    else
    {
      f = n / (j * 1.0F);
      k = Math.round(paramInt1 * f);
      i = Math.round(paramInt2 * f);
      if (paramInt1 > paramInt2)
      {
        paramInt1 = n;
        paramInt2 = m;
      }
      else
      {
        paramInt1 = m;
        paramInt2 = n;
      }
      if (paramInt2 <= k) {
        k = paramInt2;
      }
      if (paramInt1 <= i) {
        i = paramInt1;
      }
    }
    paramType = new FilePicURLDrawlableHelper.AIOImgInfo();
    paramType.a = k;
    paramType.b = i;
    return paramType;
  }
  
  public static FilePicURLDrawlableHelper.AIOImgInfo a(int paramInt1, int paramInt2, String paramString)
  {
    int j = c;
    int i = d;
    FilePicURLDrawlableHelper.AIOImgInfo localAIOImgInfo = new FilePicURLDrawlableHelper.AIOImgInfo();
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      a(paramString, localOptions);
      localAIOImgInfo.a = localOptions.outWidth;
      localAIOImgInfo.b = localOptions.outHeight;
      paramString = localAIOImgInfo;
    }
    else
    {
      if ((paramInt1 <= 0) || (paramInt2 <= 0))
      {
        paramInt1 = j;
        paramInt2 = i;
      }
      paramString = a(paramInt1, paramInt2, false);
    }
    paramInt2 = paramString.a;
    paramInt1 = paramString.b;
    float f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    i = b;
    if ((paramInt2 >= i) && (paramInt1 >= i))
    {
      i = a;
      if ((paramInt2 < i) && (paramInt1 < i))
      {
        paramInt2 = (int)(paramInt2 * f1 + 0.5F);
        paramInt1 = (int)(paramInt1 * f1 + 0.5F);
      }
      else
      {
        float f2;
        if (paramInt2 > paramInt1)
        {
          f2 = FilePicConstants.c;
          f1 = paramInt2;
        }
        else
        {
          f2 = FilePicConstants.c;
          f1 = paramInt1;
        }
        float f3 = f2 / f1;
        if (paramInt2 > paramInt1)
        {
          f1 = FilePicConstants.b;
          f2 = paramInt1;
        }
        else
        {
          f1 = FilePicConstants.b;
          f2 = paramInt2;
        }
        f1 = Math.max(f3, f1 / f2);
        paramInt2 = (int)(paramInt2 * f1 + 0.5F);
        paramInt1 = (int)(paramInt1 * f1 + 0.5F);
        paramInt2 = Math.min(paramInt2, FilePicConstants.c);
        paramInt1 = Math.min(paramInt1, FilePicConstants.c);
        paramInt2 = Math.max(paramInt2, FilePicConstants.b);
        paramInt1 = Math.max(paramInt1, FilePicConstants.b);
      }
    }
    else if (paramInt2 < paramInt1)
    {
      f1 = FilePicConstants.b / paramInt2;
      i = FilePicConstants.b;
      j = (int)(paramInt1 * f1 + 0.5F);
      paramInt2 = i;
      paramInt1 = j;
      if (j > FilePicConstants.c)
      {
        paramInt1 = FilePicConstants.c;
        paramInt2 = i;
      }
    }
    else
    {
      f1 = FilePicConstants.b / paramInt1;
      paramInt1 = (int)(paramInt2 * f1 + 0.5F);
      paramInt2 = paramInt1;
      if (paramInt1 > FilePicConstants.c) {
        paramInt2 = FilePicConstants.c;
      }
      paramInt1 = FilePicConstants.b;
    }
    paramString.a = paramInt2;
    paramString.b = paramInt1;
    return paramString;
  }
  
  public static FilePicURLDrawlableHelper.AIOImgInfo a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j;
    int k;
    if (paramInt1 > paramInt2)
    {
      j = paramInt1;
      i = paramInt2;
      k = i;
    }
    else
    {
      k = paramInt1;
      i = paramInt2;
      j = i;
    }
    FilePicURLDrawlableHelper.Type localType = c(k, j);
    int i = a(paramInt1, paramInt2, FilePicConstants.c);
    return a(paramInt1 * i, paramInt2 * i, localType, false);
  }
  
  public static String a(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
      break;
    case 8: 
      str = "screen-dsc-";
      break;
    case 7: 
      str = "qxlarge-dsc-";
      break;
    case 6: 
      str = "xlarge-dsc-";
      break;
    case 5: 
      str = "qlarge-dsc-";
      break;
    case 4: 
      str = "large-dsc-";
      break;
    case 3: 
      str = "middle-dsc-";
      break;
    case 2: 
      str = "small-dsc-";
      break;
    case 1: 
      str = "minni-dsc-";
      break;
    case 0: 
      str = "micro-dsc-";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (!FileUtil.b(paramString)) {
      return null;
    }
    String str = HexUtil.bytes2HexStr(FileManagerUtil.g(paramString));
    a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FMSettings.a().getDefaultThumbPath());
    ((StringBuilder)localObject).append(a(5, str));
    str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("_original_.tmp");
    localObject = ((StringBuilder)localObject).toString();
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      paramString = null;
    }
    if (paramString == null) {
      return null;
    }
    try
    {
      if (!FileUtils.fileExistsAndNotEmpty((String)localObject)) {
        ((ICompressOperator)QRoute.api(ICompressOperator.class)).compressAIOThumbnail(paramString, (String)localObject, true, "", 1);
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    if ((FileUtils.fileExistsAndNotEmpty((String)localObject)) && (FileUtils.renameFile(new File((String)localObject), new File(str)) == true)) {
      return str;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    long l = b(paramString2);
    Object localObject1 = null;
    if (l == -1L)
    {
      paramString1 = new StringBuilder();
      paramString1.append("createThumbWithFile temp Thumb file ");
      paramString1.append(paramString2);
      paramString1.append(" is creating");
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, paramString1.toString());
      return null;
    }
    Object localObject2;
    if (!FileUtils.fileExistsAndNotEmpty(paramString1))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("createThumbWithFile file ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" is not exist");
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      paramString1 = localObject1;
    }
    else
    {
      a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(".tmp");
      localObject2 = ((StringBuilder)localObject2).toString();
      try
      {
        ((ICompressOperator)QRoute.api(ICompressOperator.class)).compressAIOThumbnail(paramString1, (String)localObject2, true, "", paramInt);
        if (!FileUtils.fileExistsAndNotEmpty((String)localObject2))
        {
          paramString1 = new StringBuilder();
          paramString1.append("createThumbWithFile created tmp Thumb file ");
          paramString1.append((String)localObject2);
          paramString1.append(" failed");
          QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, paramString1.toString());
          paramString1 = localObject1;
        }
        else if (!FileUtils.renameFile(new File((String)localObject2), new File(paramString2)))
        {
          FileUtils.delete((String)localObject2, true);
          paramString1 = new StringBuilder();
          paramString1.append("createThumbWithFile rename tmp Thumb file ");
          paramString1.append((String)localObject2);
          paramString1.append(" failed");
          QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, paramString1.toString());
          paramString1 = localObject1;
        }
        else
        {
          paramString1 = paramString2;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = new StringBuilder();
        paramString1.append("createThumbWithFile created tmp Thumb file ");
        paramString1.append((String)localObject2);
        paramString1.append(" failed");
        QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, paramString1.toString());
        paramString1 = localObject1;
      }
    }
    c(paramString2);
    return paramString1;
  }
  
  public static URL a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    int j = 0;
    int i = j;
    if (paramFileManagerEntity.getCloudType() == 3)
    {
      i = j;
      if (!FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath)) {
        i = 1;
      }
    }
    if (i != 0)
    {
      String str = a(paramFileManagerEntity.getFilePath());
      if (str == null) {
        return null;
      }
      Object localObject2 = paramFileManagerEntity.strFileMd5;
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramFileManagerEntity.Uuid;
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = HexUtil.bytes2HexStr(FileManagerUtil.g(paramFileManagerEntity.getFilePath())).toUpperCase();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(FMSettings.a().getDefaultThumbPath());
      ((StringBuilder)localObject1).append(a(5, MD5.b((String)localObject2)));
      localObject1 = ((StringBuilder)localObject1).toString();
      if ((FileUtils.fileExistsAndNotEmpty(str)) && (!FileUtil.b(paramFileManagerEntity.strMiddleThumPath)) && (FileUtils.renameFile(new File(str), new File((String)localObject1)) == true)) {
        paramFileManagerEntity.strMiddleThumPath = ((String)localObject1);
      }
    }
    return g(paramFileManagerEntity);
  }
  
  private static void a()
  {
    File localFile = new File(FMSettings.a().getDefaultThumbPath());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  private static void a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    String str = b(paramFileManagerEntity);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FMSettings.a().getDefaultThumbPath());
    localStringBuilder.append(a(5, str));
    paramString = a(paramString, localStringBuilder.toString(), 1);
    if (paramString == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQlarge failed");
      return;
    }
    paramFileManagerEntity.strMiddleThumPath = paramString;
    paramString = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramString != null)
    {
      paramString.getFileManagerDataCenter().c(paramFileManagerEntity);
      paramString.getFileManagerNotifyCenter().a(true, 3, null);
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt2 > (int)(paramInt1 * 1.777778F);
  }
  
  public static long b(String paramString)
  {
    synchronized (e)
    {
      if (e.contains(paramString)) {
        return -1L;
      }
      e.add(paramString);
      return 1L;
    }
  }
  
  public static String b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "getThumbPath entity is null, so return null");
      return null;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))
    {
      paramFileManagerEntity = MD5.b(paramFileManagerEntity.strFileMd5);
    }
    else if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid))
    {
      paramFileManagerEntity = MD5.b(paramFileManagerEntity.Uuid);
    }
    else if (FileUtil.b(paramFileManagerEntity.getFilePath()))
    {
      localObject = FileManagerUtil.g(paramFileManagerEntity.getFilePath());
      if ((localObject != null) && (localObject.length > 0)) {
        paramFileManagerEntity = HexUtil.bytes2HexStr((byte[])localObject).toUpperCase();
      } else {
        paramFileManagerEntity = MD5.b(paramFileManagerEntity.fileName);
      }
    }
    else
    {
      paramFileManagerEntity = MD5.b(paramFileManagerEntity.fileName);
    }
    Object localObject = paramFileManagerEntity;
    if (paramFileManagerEntity != null) {
      localObject = paramFileManagerEntity.replace("/", "");
    }
    return localObject;
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0)
    {
      if (paramInt1 <= 0) {
        return true;
      }
      int j = paramInt1;
      int i = paramInt2;
      if (paramInt1 > paramInt2)
      {
        i = paramInt1;
        j = paramInt2;
      }
      return a(j, i);
    }
    return true;
  }
  
  private static FilePicURLDrawlableHelper.Type c(int paramInt1, int paramInt2)
  {
    int k = FilePicConstants.c;
    int m = FilePicConstants.b;
    int j = 0;
    int i = 3;
    if (paramInt1 > k) {
      if (a(paramInt1, paramInt2))
      {
        paramInt1 = 1;
        paramInt2 = 1;
        break label191;
      }
    }
    for (paramInt1 = 2;; paramInt1 = 4)
    {
      paramInt2 = 2;
      break label191;
      if ((paramInt1 > k) || (paramInt1 <= m)) {
        break label97;
      }
      if (paramInt2 <= k) {
        break label78;
      }
      if (a(paramInt1, paramInt2))
      {
        paramInt1 = 3;
        break;
      }
    }
    label78:
    if ((paramInt2 <= k) && (paramInt2 > m))
    {
      paramInt1 = 5;
      paramInt2 = i;
      break label191;
      label97:
      if ((paramInt1 <= m) && (paramInt1 > 0))
      {
        if (paramInt2 > k) {
          paramInt1 = 6;
        }
        for (;;)
        {
          paramInt2 = 4;
          break label191;
          if ((paramInt2 <= k) && (paramInt2 > m))
          {
            if (a(paramInt1, paramInt2))
            {
              paramInt1 = 7;
            }
            else
            {
              paramInt1 = 8;
              paramInt2 = i;
              break label191;
            }
          }
          else
          {
            if ((paramInt2 > m) || (paramInt2 <= 0)) {
              break label187;
            }
            if (!a(paramInt1, paramInt2)) {
              break;
            }
            paramInt1 = 9;
          }
        }
        paramInt1 = 10;
        paramInt2 = i;
        break label191;
      }
    }
    label187:
    paramInt2 = 0;
    paramInt1 = j;
    label191:
    FilePicURLDrawlableHelper.Type localType = new FilePicURLDrawlableHelper.Type();
    localType.a = paramInt2;
    localType.b = paramInt1;
    return localType;
  }
  
  public static void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithOrig entity is null, so return null");
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createThumbWithOrig Thumb file ");
      localStringBuilder.append(paramFileManagerEntity.strMiddleThumPath);
      localStringBuilder.append(" already exist");
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    a(paramFileManagerEntity, paramFileManagerEntity.getFilePath());
  }
  
  private static void c(String paramString)
  {
    synchronized (e)
    {
      e.remove(paramString);
      return;
    }
  }
  
  public static void d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQXLarge entity is null, so return null");
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createThumbWithQXLarge Thumb file ");
      localStringBuilder.append(paramFileManagerEntity.strMiddleThumPath);
      localStringBuilder.append(" already exist");
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, localStringBuilder.toString());
      return;
    }
    a(paramFileManagerEntity, paramFileManagerEntity.strLargeThumPath);
  }
  
  public static void e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createThumbWithQlarge entity is null, so return null");
      return;
    }
    FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath);
    a(paramFileManagerEntity, paramFileManagerEntity.strMiddleThumPath);
  }
  
  public static void f(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig entity is null, so return");
      return;
    }
    if (paramFileManagerEntity.nFileType != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("] createQXlargeThumbWithOrig is not image file!");
      QLog.i("FilePicURLDrawlableHelper<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createQXlargeThumbWithOrig Thumb file ");
      ((StringBuilder)localObject).append(paramFileManagerEntity.strLargeThumPath);
      ((StringBuilder)localObject).append(" already exist");
      QLog.d("FilePicURLDrawlableHelper<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = b(paramFileManagerEntity);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FMSettings.a().getDefaultThumbPath());
    localStringBuilder.append(a(7, (String)localObject));
    localObject = localStringBuilder.toString();
    localObject = a(paramFileManagerEntity.getFilePath(), (String)localObject, 2);
    if (localObject == null)
    {
      QLog.w("FilePicURLDrawlableHelper<FileAssistant>", 1, "createQXlargeThumbWithOrig failed");
      return;
    }
    paramFileManagerEntity.strLargeThumPath = ((String)localObject);
  }
  
  public static URL g(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    Object localObject2 = paramFileManagerEntity.strMiddleThumPath;
    Object localObject1 = localObject2;
    if (paramFileManagerEntity.status == 16)
    {
      localObject1 = localObject2;
      if (!FileUtil.b((String)localObject2)) {
        if (FileUtil.b(paramFileManagerEntity.strLargeThumPath))
        {
          localObject1 = paramFileManagerEntity.strLargeThumPath;
        }
        else
        {
          localObject1 = localObject2;
          if (FileUtil.b(paramFileManagerEntity.strThumbPath)) {
            localObject1 = paramFileManagerEntity.strThumbPath;
          }
        }
      }
    }
    localObject2 = localObject1;
    if (!FileUtil.b((String)localObject1))
    {
      localObject2 = localObject1;
      if (FileUtil.b(paramFileManagerEntity.strLargeThumPath))
      {
        localObject1 = paramFileManagerEntity.strLargeThumPath;
        localObject2 = localObject1;
        if (i(paramFileManagerEntity))
        {
          ThreadManager.post(new FilePicURLDrawlableHelper.1(paramFileManagerEntity), 8, null, false);
          localObject2 = localObject1;
        }
      }
    }
    if (FileUtils.fileExistsAndNotEmpty((String)localObject2)) {}
    try
    {
      localObject1 = AsyncImageView.a((String)localObject2, -1, -1, new File((String)localObject2), false, false, true);
      paramFileManagerEntity = (FileManagerEntity)localObject1;
      if (localObject1 != null) {
        break label170;
      }
      return null;
    }
    catch (Exception paramFileManagerEntity)
    {
      label151:
      break label151;
    }
    if (QLog.isColorLevel()) {
      QLog.e("FilePicURLDrawlableHelper<FileAssistant>", 1, "createFilePicDrawlableURL generateAIOThumbURL error!");
    }
    return null;
    paramFileManagerEntity = null;
    label170:
    return paramFileManagerEntity;
  }
  
  public static FilePicURLDrawlableHelper.AIOImgInfo h(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return null;
    }
    FilePicURLDrawlableHelper.AIOImgInfo localAIOImgInfo = new FilePicURLDrawlableHelper.AIOImgInfo();
    if (FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strMiddleThumPath))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      a(paramFileManagerEntity.strMiddleThumPath, localOptions);
      localAIOImgInfo.a = localOptions.outWidth;
      localAIOImgInfo.b = localOptions.outHeight;
      paramFileManagerEntity = localAIOImgInfo;
    }
    else
    {
      if ((paramFileManagerEntity.imgWidth > 0) && (paramFileManagerEntity.imgHeight > 0))
      {
        i = paramFileManagerEntity.imgWidth;
        j = paramFileManagerEntity.imgHeight;
      }
      else
      {
        i = c;
        j = d;
      }
      paramFileManagerEntity = a(i, j, false);
    }
    int j = paramFileManagerEntity.a;
    int i = paramFileManagerEntity.b;
    float f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    int k = b;
    if ((j >= k) && (i >= k))
    {
      k = a;
      if ((j < k) && (i < k)) {}
      for (;;)
      {
        j = (int)(j * f1 + 0.5F);
        i = (int)(i * f1 + 0.5F);
        break;
        float f2;
        if (j > i)
        {
          f1 = FilePicConstants.c;
          f2 = j;
        }
        else
        {
          f1 = FilePicConstants.c;
          f2 = i;
        }
        float f3 = f1 / f2;
        if (j > i)
        {
          f1 = FilePicConstants.b;
          f2 = i;
        }
        else
        {
          f1 = FilePicConstants.b;
          f2 = j;
        }
        f1 = Math.max(f3, f1 / f2);
      }
    }
    if (j < i)
    {
      f1 = FilePicConstants.b / j;
      k = FilePicConstants.b;
      int m = (int)(i * f1 + 0.5F);
      i = m;
      j = k;
      if (m > FilePicConstants.c)
      {
        i = FilePicConstants.c;
        j = k;
      }
    }
    else
    {
      f1 = FilePicConstants.b / i;
      i = (int)(j * f1 + 0.5F);
      j = i;
      if (i > FilePicConstants.c) {
        j = FilePicConstants.c;
      }
      i = FilePicConstants.b;
    }
    paramFileManagerEntity.a = j;
    paramFileManagerEntity.b = i;
    return paramFileManagerEntity;
  }
  
  public static boolean i(FileManagerEntity paramFileManagerEntity)
  {
    return b(paramFileManagerEntity.imgWidth, paramFileManagerEntity.imgHeight);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper
 * JD-Core Version:    0.7.0.1
 */