package com.tencent.mobileqq.education.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/education/utils/StudyBitmapUtils;", "", "()V", "bitmapToBase64", "", "bitmap", "Landroid/graphics/Bitmap;", "format", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "", "checkBitmapValidBytes", "", "maxSize", "", "checkBitmapValidSize", "minWidth", "minHeight", "getBitmapFileBase64Data", "filePath", "getBitmapValidCompressQuality", "maxByteSize", "getStudyFileSaveRootPath", "saveBitmapToFile", "qq_education_impl_release"}, k=1, mv={1, 1, 16})
public final class StudyBitmapUtils
{
  @NotNull
  public final String a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_ROOT);
    ((StringBuilder)localObject).append("/Tencent/Study/");
    localObject = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "VFSAssistantUtils.getSDK…ROOT + \"/Tencent/Study/\")");
    return localObject;
  }
  
  @Nullable
  public final String a(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    return a(paramBitmap, Bitmap.CompressFormat.JPEG, 100);
  }
  
  /* Error */
  @Nullable
  public final String a(@NotNull Bitmap paramBitmap, @Nullable Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 79
    //   3: invokestatic 82	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aconst_null
    //   7: checkcast 97	java/lang/String
    //   10: astore 7
    //   12: aconst_null
    //   13: checkcast 99	java/io/ByteArrayOutputStream
    //   16: astore 6
    //   18: aload 6
    //   20: astore 4
    //   22: new 99	java/io/ByteArrayOutputStream
    //   25: dup
    //   26: sipush 1024
    //   29: invokespecial 102	java/io/ByteArrayOutputStream:<init>	(I)V
    //   32: astore 5
    //   34: aload_1
    //   35: aload_2
    //   36: iload_3
    //   37: aload 5
    //   39: checkcast 104	java/io/OutputStream
    //   42: invokevirtual 110	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   45: pop
    //   46: aload 5
    //   48: invokevirtual 114	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   51: iconst_2
    //   52: invokestatic 120	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   55: astore_1
    //   56: aload_1
    //   57: astore_2
    //   58: aload 5
    //   60: invokevirtual 123	java/io/ByteArrayOutputStream:flush	()V
    //   63: aload_1
    //   64: astore_2
    //   65: aload 5
    //   67: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   70: aload_1
    //   71: areturn
    //   72: astore_1
    //   73: aload_1
    //   74: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   77: aload_2
    //   78: areturn
    //   79: astore_1
    //   80: goto +50 -> 130
    //   83: astore_2
    //   84: aload 5
    //   86: astore_1
    //   87: goto +15 -> 102
    //   90: astore_1
    //   91: aload 4
    //   93: astore 5
    //   95: goto +35 -> 130
    //   98: astore_2
    //   99: aload 6
    //   101: astore_1
    //   102: aload_1
    //   103: astore 4
    //   105: aload_2
    //   106: invokevirtual 130	java/lang/Exception:printStackTrace	()V
    //   109: aload_1
    //   110: ifnull +17 -> 127
    //   113: aload 7
    //   115: astore_2
    //   116: aload_1
    //   117: invokevirtual 123	java/io/ByteArrayOutputStream:flush	()V
    //   120: aload 7
    //   122: astore_2
    //   123: aload_1
    //   124: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   127: aload 7
    //   129: areturn
    //   130: aload 5
    //   132: ifnull +21 -> 153
    //   135: aload 5
    //   137: invokevirtual 123	java/io/ByteArrayOutputStream:flush	()V
    //   140: aload 5
    //   142: invokevirtual 126	java/io/ByteArrayOutputStream:close	()V
    //   145: goto +8 -> 153
    //   148: astore_2
    //   149: aload_2
    //   150: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	StudyBitmapUtils
    //   0	155	1	paramBitmap	Bitmap
    //   0	155	2	paramCompressFormat	Bitmap.CompressFormat
    //   0	155	3	paramInt	int
    //   20	84	4	localObject1	Object
    //   32	109	5	localObject2	Object
    //   16	84	6	localByteArrayOutputStream	ByteArrayOutputStream
    //   10	118	7	str	String
    // Exception table:
    //   from	to	target	type
    //   58	63	72	java/io/IOException
    //   65	70	72	java/io/IOException
    //   116	120	72	java/io/IOException
    //   123	127	72	java/io/IOException
    //   34	56	79	finally
    //   34	56	83	java/lang/Exception
    //   22	34	90	finally
    //   105	109	90	finally
    //   22	34	98	java/lang/Exception
    //   135	145	148	java/io/IOException
  }
  
  @NotNull
  public final String a(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    if (!FileUtils.fileExistsAndNotEmpty(paramString)) {
      return "";
    }
    paramString = BitmapFactory.decodeFile(paramString);
    if (paramString != null)
    {
      int i = b(paramString, paramLong);
      paramString = a(paramString, Bitmap.CompressFormat.JPEG, i);
      if (paramString != null) {
        return paramString;
      }
      return "";
    }
    return "";
  }
  
  public final boolean a(@NotNull Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    return (i > paramInt1) && (j > paramInt2);
  }
  
  public final boolean a(@NotNull Bitmap paramBitmap, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    return paramBitmap.getByteCount() <= paramLong;
  }
  
  public final boolean a(@NotNull Bitmap paramBitmap, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    try
    {
      FileUtils.deleteFile(paramString);
      FileUtils.createFileIfNotExits(paramString);
      paramString = new FileOutputStream(new File(paramString));
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)paramString);
      paramString.flush();
      paramString.close();
      return true;
    }
    catch (Exception paramBitmap)
    {
      label61:
      break label61;
    }
    return false;
  }
  
  public final int b(@NotNull Bitmap paramBitmap, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.JPEG;
    OutputStream localOutputStream = (OutputStream)localByteArrayOutputStream;
    int n = 100;
    paramBitmap.compress(localCompressFormat, 100, localOutputStream);
    if (localByteArrayOutputStream.size() <= paramLong) {
      return 100;
    }
    localByteArrayOutputStream.reset();
    localCompressFormat = Bitmap.CompressFormat.JPEG;
    int i = 0;
    paramBitmap.compress(localCompressFormat, 0, localOutputStream);
    if (localByteArrayOutputStream.size() > paramLong) {
      return -1;
    }
    int m = 100;
    int j = 0;
    int k;
    for (;;)
    {
      k = n;
      if (i >= m) {
        break;
      }
      j = (i + m) / 2;
      localByteArrayOutputStream.reset();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, j, localOutputStream);
      long l = localByteArrayOutputStream.size();
      if (l == paramLong)
      {
        k = j;
        break;
      }
      if (l > paramLong) {
        m = j - 1;
      } else {
        i = j + 1;
      }
    }
    if (m == j - 1) {
      k = i;
    }
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.education.utils.StudyBitmapUtils
 * JD-Core Version:    0.7.0.1
 */