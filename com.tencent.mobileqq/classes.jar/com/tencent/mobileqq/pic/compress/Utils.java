package com.tencent.mobileqq.pic.compress;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegDecompressor;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AIOImgThumbHelper;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FilePicConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import mqq.app.MobileQQ;

public class Utils
{
  public static long a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.fileExistsAndNotEmpty(paramString))) {
      return new File(paramString).length();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("path is empty, or file does not exist. path:");
    localStringBuilder.append(paramString);
    Logger.b("compress.Utils", "getFileSize()", localStringBuilder.toString());
    return 0L;
  }
  
  public static Bitmap a()
  {
    Drawable localDrawable = MobileQQ.getContext().getResources().getDrawable(2130838156);
    if (localDrawable != null)
    {
      if ((localDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)localDrawable).getBitmap();
      }
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
    }
    return null;
  }
  
  static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return paramBitmap;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localPaint.setXfermode(null);
      paramBitmap.recycle();
      paramBitmap = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    Logger.a("compress.Utils", "compositingWhiteBg()", "compositingWhiteBg is success");
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    int n = paramBitmap.getWidth();
    int i1 = paramBitmap.getHeight();
    float f2 = n;
    float f1 = i1;
    float f3 = f1 * 3.0F;
    int i;
    if (f2 > f3)
    {
      i = (int)f3;
    }
    else
    {
      f2 *= 3.0F;
      if (f1 > f2)
      {
        j = (int)f2;
        i = n;
        break label71;
      }
      i = n;
    }
    int j = i1;
    label71:
    int m = paramThumbWidthHeightDP.mMinWidth;
    int k = paramThumbWidthHeightDP.mMinHeight;
    int i3 = paramThumbWidthHeightDP.mMaxWidth;
    int i2 = paramThumbWidthHeightDP.mMaxHeight;
    if (i < j)
    {
      if (i < m)
      {
        k = (int)(j * m * 1.0F / i);
      }
      else
      {
        m = i;
        k = j;
      }
      if (j > i2)
      {
        m = (int)(i * i2 * 1.0F / j);
        k = i2;
      }
    }
    else
    {
      if (j < k)
      {
        m = (int)(i * k * 1.0F / j);
      }
      else
      {
        m = i;
        k = j;
      }
      if (i > i3)
      {
        k = (int)(j * i3 * 1.0F / i);
        m = i3;
      }
    }
    f1 = MobileQQ.getContext().getResources().getDisplayMetrics().density;
    m = (int)(m * f1 + 0.5F);
    k = (int)(k * f1 + 0.5F);
    try
    {
      paramThumbWidthHeightDP = Bitmap.createBitmap(m, k, paramBitmap.getConfig());
      paramThumbWidthHeightDP.setDensity(MobileQQ.getContext().getResources().getDisplayMetrics().densityDpi);
      Paint localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clip w=");
      localStringBuilder.append(n);
      localStringBuilder.append(", h=");
      localStringBuilder.append(i1);
      localStringBuilder.append(", wClip=");
      localStringBuilder.append(i);
      localStringBuilder.append(", hClip=");
      localStringBuilder.append(j);
      localStringBuilder.append(", dstW=");
      localStringBuilder.append(m);
      localStringBuilder.append(", dstH=");
      localStringBuilder.append(k);
      QLog.d("compress.Utils", 1, localStringBuilder.toString());
      new Canvas(paramThumbWidthHeightDP).drawBitmap(paramBitmap, new Rect(0, 0, i, j), new Rect(0, 0, m, k), localPaint);
      return paramThumbWidthHeightDP;
    }
    catch (Exception paramThumbWidthHeightDP)
    {
      QLog.e("compress.Utils", 1, "Exception", paramThumbWidthHeightDP);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramThumbWidthHeightDP)
    {
      QLog.e("compress.Utils", 1, "OutOfMemoryError", paramThumbWidthHeightDP);
    }
    return paramBitmap;
  }
  
  static Bitmap a(Bitmap paramBitmap, boolean paramBoolean, String paramString1, String paramString2, String paramString3, ThumbWidthHeightDP paramThumbWidthHeightDP, Utils.ThumbWidthHeightPx paramThumbWidthHeightPx)
  {
    if ((paramThumbWidthHeightDP != null) && (paramThumbWidthHeightDP.mLimitSizeByServer))
    {
      paramBitmap = a(paramBitmap, paramThumbWidthHeightDP);
    }
    else
    {
      int j = paramThumbWidthHeightPx.c;
      int k = paramThumbWidthHeightPx.a;
      int i = 0;
      if (paramBoolean) {
        i = BaseImageUtil.c(paramString1);
      }
      paramString1 = new StringBuilder();
      paramString1.append(paramString3);
      paramString1.append(" ClipStrategy begin, thumbSizeMax：");
      paramString1.append(j);
      paramString1.append(" thumbSizeMin:");
      paramString1.append(k);
      paramString1.append(" degree:");
      paramString1.append(i);
      Logger.a("compress.Utils", paramString2, paramString1.toString());
      paramString1 = new ClipStrategy(j, k, i);
      paramBitmap = paramString1.a(paramBitmap);
      paramThumbWidthHeightDP = new StringBuilder();
      paramThumbWidthHeightDP.append(" needCut:");
      paramThumbWidthHeightDP.append(paramString1.b);
      paramThumbWidthHeightDP.append(" needScale:");
      paramThumbWidthHeightDP.append(paramString1.c);
      Logger.a("compress.Utils", paramString2, paramThumbWidthHeightDP.toString());
    }
    if (paramBitmap == null)
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append(paramString3);
      paramBitmap.append(" ClipStrategy fail");
      Logger.a("compress.Utils", paramString2, paramBitmap.toString());
      return null;
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramString3);
    paramString1.append(" ClipStrategy suc, destWidth：");
    paramString1.append(paramBitmap.getWidth());
    paramString1.append(" destHeight:");
    paramString1.append(paramBitmap.getHeight());
    Logger.a("compress.Utils", paramString2, paramString1.toString());
    return paramBitmap;
  }
  
  static Utils.ThumbWidthHeightPx a(ThumbWidthHeightDP paramThumbWidthHeightDP, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      paramInt1 = FilePicConstants.c;
      paramInt2 = FilePicConstants.b;
    }
    else if (paramInt1 == 2)
    {
      paramInt1 = FilePicConstants.d;
      paramInt2 = FilePicConstants.a;
    }
    else if (paramThumbWidthHeightDP != null)
    {
      paramInt1 = paramThumbWidthHeightDP.maxPx();
      paramInt2 = paramThumbWidthHeightDP.minPx();
    }
    else
    {
      boolean bool2 = false;
      if (paramInt1 == 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int i = AIOImgThumbHelper.getAioThumbMaxPx(bool1, true, paramInt2);
      if (paramInt1 == 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      i = Math.max(i, CommonImgThumbHelper.getImgThumbMaxPx(bool1));
      if (paramInt1 == 3) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramInt2 = AIOImgThumbHelper.getAioThumbMinPx(bool1, true, paramInt2);
      boolean bool1 = bool2;
      if (paramInt1 == 3) {
        bool1 = true;
      }
      paramInt2 = Math.max(paramInt2, CommonImgThumbHelper.getImgThumbMinPx(bool1));
      paramInt1 = i;
    }
    return new Utils.ThumbWidthHeightPx(paramInt2, paramInt2, paramInt1, paramInt1);
  }
  
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.fileExists(paramString)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject).append("thumb/");
      String str = RmVFSUtils.getVFSPath(((StringBuilder)localObject).toString());
      if (paramString.startsWith(str)) {
        return paramString;
      }
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      if (j <= 0) {
        localObject = paramString.substring(i + 1);
      } else if (i < j + 1) {
        localObject = paramString.substring(i + 1, j);
      } else {
        localObject = paramString.substring(i + 1);
      }
      long l = new File(paramString).lastModified();
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(str);
      localStringBuffer.append("_");
      localStringBuffer.append(paramString.hashCode());
      localStringBuffer.append("_");
      localStringBuffer.append((String)localObject);
      localStringBuffer.append("_");
      localStringBuffer.append(l);
      localStringBuffer.append(".jpg");
      paramString = new File(str);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return localStringBuffer.toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("realpath is empty, or file does not exist, realpath:");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("compress.Utils", "getThumbnailPath()", ((StringBuilder)localObject).toString());
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.fileExists(paramString)) && (a(paramInt)))
    {
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      if ((j > 0) && (j > i)) {
        localObject1 = paramString.substring(i + 1, j);
      } else {
        localObject1 = paramString.substring(i + 1);
      }
      long l = new File(paramString).lastModified();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(AppConstants.SDCARD_PATH);
      ((StringBuilder)localObject2).append("photo/");
      String str = RmVFSUtils.getVFSPath(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuffer();
      ((StringBuffer)localObject2).append(str);
      ((StringBuffer)localObject2).append("_");
      ((StringBuffer)localObject2).append(paramString.hashCode());
      ((StringBuffer)localObject2).append("_");
      ((StringBuffer)localObject2).append((String)localObject1);
      ((StringBuffer)localObject2).append("_");
      ((StringBuffer)localObject2).append(l);
      ((StringBuffer)localObject2).append("_");
      if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
        paramString = "wifi";
      } else {
        paramString = "xg";
      }
      ((StringBuffer)localObject2).append(paramString);
      ((StringBuffer)localObject2).append("_");
      ((StringBuffer)localObject2).append(paramInt);
      ((StringBuffer)localObject2).append(".jpg");
      paramString = new File(str);
      if (!paramString.exists()) {
        paramString.mkdirs();
      }
      return ((StringBuffer)localObject2).toString();
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("realpath is empty, or file does not exist, or picQuality Illegal realpath:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" picQuality:");
    ((StringBuilder)localObject1).append(paramInt);
    Logger.a("compress.Utils", "getSendPhotoPath()", ((StringBuilder)localObject1).toString());
    return "";
  }
  
  public static boolean a()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeviceProfileManager.DpcNames.pg_switch value ");
      localStringBuilder.append((String)localObject);
      QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 2) {
      return false;
    }
    return localObject[1].equals("1");
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  static boolean a(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = a();
      if (localBitmap == null) {
        return false;
      }
      int i = localBitmap.getWidth() / 2;
      int j = localBitmap.getHeight() / 2;
      int m = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      m = m - i - 7;
      k = k - j - 7;
      if ((m > 0) && (k > 0))
      {
        paramBitmap = new Canvas(paramBitmap);
        Paint localPaint = new Paint(2);
        paramBitmap.drawBitmap(localBitmap, null, new Rect(m, k, i + m, j + k), localPaint);
      }
      return true;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return false;
  }
  
  static boolean a(Bitmap paramBitmap, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramBitmap = a(paramBitmap);
    if (paramInt == 3)
    {
      bool = a(paramBitmap);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" isDrawGIFSucc：");
      localStringBuilder.append(bool);
      Logger.a("compress.Utils", paramString2, localStringBuilder.toString());
    }
    boolean bool = c(paramString1, paramBitmap, 70, paramString3, null);
    if (paramBitmap != null) {
      paramBitmap.recycle();
    }
    return bool;
  }
  
  static boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (paramOptions == null)
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramOptions.outWidth;
    int n = paramOptions.outHeight;
    if ((m != 0) && (n != 0))
    {
      int k = m;
      int j = n;
      int i = 1;
      for (;;)
      {
        k >>= 1;
        j >>= 1;
        if ((k < paramInt) || (j < paramInt)) {
          break;
        }
        i *= 2;
      }
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize >= 1) {
        paramInt = paramOptions.inSampleSize;
      } else {
        paramInt = 1;
      }
      paramOptions.inSampleSize = paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("options.inSampleSize=");
      localStringBuilder.append(paramOptions.inSampleSize);
      localStringBuilder.append(" srcWidth:");
      localStringBuilder.append(m);
      localStringBuilder.append(" srcHeight:");
      localStringBuilder.append(n);
      Logger.a("compress.Utils", "calculateInSampleSizeThumbnail()", localStringBuilder.toString());
      return true;
    }
    Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
    return false;
  }
  
  public static boolean a(BitmapFactory.Options paramOptions, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramOptions != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt1 >= paramInt2))
      {
        if (paramInt2 <= paramInt1 / 2)
        {
          paramOptions.inJustDecodeBounds = true;
          BaseImageUtil.a(paramString, paramOptions);
          int j = paramOptions.outHeight;
          int k = paramOptions.outWidth;
          int i = j;
          if (k > j) {
            i = k;
          }
          if (i > paramInt1)
          {
            j = 1;
            int m;
            do
            {
              do
              {
                k = i >> 1;
                m = j * 2;
                j = m;
                i = k;
              } while (k < paramInt2);
              j = m;
              i = k;
            } while (k > paramInt1);
            paramOptions.inSampleSize = m;
          }
          paramOptions.inJustDecodeBounds = false;
          if (paramOptions.inSampleSize >= 1) {
            paramInt1 = paramOptions.inSampleSize;
          } else {
            paramInt1 = 1;
          }
          paramOptions.inSampleSize = paramInt1;
          paramString = new StringBuilder();
          paramString.append("options.inSampleSize=");
          paramString.append(paramOptions.inSampleSize);
          Logger.a("compress.Utils", "calculateInSampleSize()", paramString.toString());
          return true;
        }
        throw new IllegalArgumentException("min > max / 2");
      }
      throw new IllegalArgumentException("max < 0 || min < 0 || max < min");
    }
    Logger.b("compress.Utils", "calculateInSampleSize()", "options == null || TextUtils.isEmpty(filepath)");
    return false;
  }
  
  static boolean a(JpegOptions paramJpegOptions, int paramInt)
  {
    if (paramJpegOptions == null)
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramJpegOptions.outWidth;
    int n = paramJpegOptions.outHeight;
    if ((m != 0) && (n != 0))
    {
      int k = m;
      int j = n;
      int i = 1;
      for (;;)
      {
        k >>= 1;
        j >>= 1;
        if ((k < paramInt) || (j < paramInt)) {
          break;
        }
        i *= 2;
      }
      paramJpegOptions.inSampleSize = i;
      paramJpegOptions.inJustDecodeBounds = false;
      if (paramJpegOptions.inSampleSize >= 1) {
        paramInt = paramJpegOptions.inSampleSize;
      } else {
        paramInt = 1;
      }
      paramJpegOptions.inSampleSize = paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("options.inSampleSize=");
      localStringBuilder.append(paramJpegOptions.inSampleSize);
      localStringBuilder.append(" srcWidth:");
      localStringBuilder.append(m);
      localStringBuilder.append(" srcHeight:");
      localStringBuilder.append(n);
      Logger.a("compress.Utils", "calculateInSampleSizeThumbnail()", localStringBuilder.toString());
      return true;
    }
    Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool1 = FileUtils.fileExistsAndNotEmpty(paramString);
    boolean bool2 = false;
    if ((bool1) && (FileUtils.estimateFileType(paramString).equals("jpg"))) {
      try
      {
        float f = JpegCompressor.getJpegQuality(paramString);
        long l = FileUtils.getFileSizes(paramString);
        bool1 = bool2;
        if (f <= 80.0F)
        {
          bool1 = bool2;
          if (l < 307200L) {
            bool1 = true;
          }
        }
        paramString = new StringBuilder();
        paramString.append("getJpegQuality = ");
        paramString.append(f);
        paramString.append(",picSize = ");
        paramString.append(l);
        paramString.append("result = ");
        paramString.append(bool1);
        Logger.a("compress.Utils", "isMatchQualityAndSizeCondition()", paramString.toString());
        return bool1;
      }
      catch (OutOfMemoryError paramString)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getJpegQuality OutOfMemoryError error = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",return false!");
        Logger.b("compress.Utils", "isMatchQualityAndSizeCondition()", localStringBuilder.toString());
        return false;
      }
      catch (RuntimeException paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getJpegQuality RuntimeException error = ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",return false!");
        Logger.b("compress.Utils", "isMatchQualityAndSizeCondition()", localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public static boolean a(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if (b()) {
      return b(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
    }
    return c(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (FileUtils.fileExistsAndNotEmpty(paramString1)))
    {
      Logger.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3);
      JpegOptions localJpegOptions = new JpegOptions();
      localJpegOptions.inJustDecodeBounds = true;
      JpegDecompressor.decodeFile(paramString1, localJpegOptions);
      Utils.ThumbWidthHeightPx localThumbWidthHeightPx = a(null, paramInt, Math.max(localJpegOptions.outHeight, localJpegOptions.outWidth));
      if (!a(localJpegOptions, localThumbWidthHeightPx.c))
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString3);
        paramString1.append(" calculateInSampleSize fail");
        Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString1.toString());
        return false;
      }
      try
      {
        localObject3 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString3);
          ((StringBuilder)localObject1).append(" bm == null, maybe is broken");
          Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", ((StringBuilder)localObject1).toString());
          return false;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject3;
        localOutOfMemoryError.printStackTrace();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString3);
        ((StringBuilder)localObject2).append(" decodeFile OutOfMemoryError");
        Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", ((StringBuilder)localObject2).toString());
        localJpegOptions.inSampleSize *= 2;
        try
        {
          localObject2 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
          int i = ((Bitmap)localObject2).getWidth();
          int j = ((Bitmap)localObject2).getHeight();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramString3);
          ((StringBuilder)localObject3).append(" sample after W:");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(" H:");
          ((StringBuilder)localObject3).append(j);
          Logger.a("compress.Utils", "compressAIOThumbnailWithTrubo", ((StringBuilder)localObject3).toString());
          paramString1 = a((Bitmap)localObject2, paramBoolean, paramString1, "compressAIOThumbnailWithTrubo", paramString3, null, localThumbWidthHeightPx);
          if (paramString1 != null) {
            return a(paramString1, paramString2, "compressAIOThumbnailWithTrubo", paramString3, paramInt);
          }
          return false;
        }
        catch (OutOfMemoryError paramString1)
        {
          paramString1.printStackTrace();
          paramString1 = new StringBuilder();
          paramString1.append(paramString3);
          paramString1.append(" decodeFile OutOfMemoryError, op.inSampleSize:");
          paramString1.append(localJpegOptions.inSampleSize);
          Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString1.toString());
          return false;
        }
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString3);
    ((StringBuilder)localObject2).append(" infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append(" outfilePath:");
    ((StringBuilder)localObject2).append(paramString2);
    Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", ((StringBuilder)localObject2).toString());
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (FileUtils.fileExistsAndNotEmpty(paramString1)))
    {
      Logger.a("compress.Utils", "compressAIOThumbnail", paramString3);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BaseImageUtil.a(paramString1, localOptions);
      Utils.ThumbWidthHeightPx localThumbWidthHeightPx = a(paramThumbWidthHeightDP, paramInt, Math.max(localOptions.outHeight, localOptions.outWidth));
      if (!a(localOptions, localThumbWidthHeightPx.c))
      {
        paramString1 = new StringBuilder();
        paramString1.append(paramString3);
        paramString1.append(" calculateInSampleSize fail");
        Logger.b("compress.Utils", "compressAIOThumbnail", paramString1.toString());
        return false;
      }
      try
      {
        localObject3 = SafeBitmapFactory.safeDecode(paramString1, localOptions);
        Object localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramString3);
          ((StringBuilder)localObject1).append(" bm == null, maybe is broken");
          Logger.b("compress.Utils", "compressAIOThumbnail", ((StringBuilder)localObject1).toString());
          return false;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject3;
        localOutOfMemoryError.printStackTrace();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString3);
        ((StringBuilder)localObject2).append(" decodeFile OutOfMemoryError");
        Logger.b("compress.Utils", "compressAIOThumbnail", ((StringBuilder)localObject2).toString());
        localOptions.inSampleSize *= 2;
        try
        {
          localObject2 = BaseImageUtil.a(paramString1, localOptions);
          int i = ((Bitmap)localObject2).getWidth();
          int j = ((Bitmap)localObject2).getHeight();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramString3);
          ((StringBuilder)localObject3).append(" sample after W:");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(" H:");
          ((StringBuilder)localObject3).append(j);
          Logger.a("compress.Utils", "compressAIOThumbnail", ((StringBuilder)localObject3).toString());
          paramString1 = a((Bitmap)localObject2, paramBoolean, paramString1, "compressAIOThumbnail", paramString3, paramThumbWidthHeightDP, localThumbWidthHeightPx);
          if (paramString1 != null) {
            return a(paramString1, paramString2, "compressAIOThumbnail", paramString3, paramInt);
          }
          return false;
        }
        catch (OutOfMemoryError paramString1)
        {
          paramString1.printStackTrace();
          paramString1 = new StringBuilder();
          paramString1.append(paramString3);
          paramString1.append(" decodeFile OutOfMemoryError, op.inSampleSize:");
          paramString1.append(localOptions.inSampleSize);
          Logger.b("compress.Utils", "compressAIOThumbnail", paramString1.toString());
          return false;
        }
      }
    }
    paramThumbWidthHeightDP = new StringBuilder();
    paramThumbWidthHeightDP.append(paramString3);
    paramThumbWidthHeightDP.append(" infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:");
    paramThumbWidthHeightDP.append(paramString1);
    paramThumbWidthHeightDP.append(" outfilePath:");
    paramThumbWidthHeightDP.append(paramString2);
    Logger.b("compress.Utils", "compressAIOThumbnail", paramThumbWidthHeightDP.toString());
    return false;
  }
  
  static boolean b()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeviceProfileManager.DpcNames.pg_switch value ");
      localStringBuilder.append((String)localObject);
      QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 1) {
      return false;
    }
    return localObject[0].equals("1");
  }
  
  private static boolean b(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramBitmap != null) && (paramInt <= 100) && (paramInt > 0))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" quality:");
      ((StringBuilder)localObject).append(paramInt);
      Logger.a("compress.Utils", "compressQualityWithProgressive()", ((StringBuilder)localObject).toString());
      localObject = new File(paramString1);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      try
      {
        ((File)localObject).createNewFile();
        localObject = new JpegCompressor(new Utils.1((File)localObject, paramCompressInfo));
        ((JpegCompressor)localObject).setParams(paramInt, true, true, false);
        try
        {
          LogTag.a();
          ((JpegCompressor)localObject).compress(paramBitmap);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("pgjpeg ");
          ((StringBuilder)localObject).append(paramBitmap.getWidth());
          ((StringBuilder)localObject).append("x");
          ((StringBuilder)localObject).append(paramBitmap.getHeight());
          ((StringBuilder)localObject).append(" compress");
          LogTag.a("peak_pgjpeg", ((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append(" quality:");
          ((StringBuilder)localObject).append(paramInt);
          Logger.a("compress.Utils", "compressQualityWithProgressive()", ((StringBuilder)localObject).toString());
          return true;
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("peak_pgjpeg", 2, "JpegCompressor.compress() error", localException);
          }
          return c(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
        }
        paramString1 = new StringBuilder();
      }
      catch (IOException paramString1)
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append(paramString2);
        paramBitmap.append(" createNewFile IOException");
        Logger.b("compress.Utils", "compressQualityWithProgressive()", paramBitmap.toString());
        paramString1.printStackTrace();
        return false;
      }
      catch (FileNotFoundException paramString1)
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append(paramString2);
        paramBitmap.append(" FileOutputStream FileNotFoundException");
        Logger.b("compress.Utils", "compressQualityWithProgressive()", paramBitmap.toString());
        paramString1.printStackTrace();
        return false;
      }
    }
    paramString1.append(paramString2);
    paramString1.append(" TextUtils.isEmpty(destPath) || bm == null || quality > 100 || quality <= 0");
    Logger.b("compress.Utils", "compressQualityWithProgressive()", paramString1.toString());
    return false;
  }
  
  /* Error */
  private static boolean c(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +484 -> 488
    //   7: aload_1
    //   8: ifnull +480 -> 488
    //   11: iload_2
    //   12: bipush 100
    //   14: if_icmpgt +474 -> 488
    //   17: iload_2
    //   18: ifgt +6 -> 24
    //   21: goto +467 -> 488
    //   24: new 34	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   31: astore 5
    //   33: aload 5
    //   35: aload_3
    //   36: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 5
    //   42: ldc_w 616
    //   45: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 5
    //   51: iload_2
    //   52: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 43
    //   58: ldc_w 672
    //   61: aload 5
    //   63: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 148	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   69: new 25	java/io/File
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 28	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore 9
    //   79: aload 9
    //   81: invokevirtual 382	java/io/File:exists	()Z
    //   84: ifeq +9 -> 93
    //   87: aload 9
    //   89: invokevirtual 621	java/io/File:delete	()Z
    //   92: pop
    //   93: aconst_null
    //   94: astore 7
    //   96: aconst_null
    //   97: astore 8
    //   99: aconst_null
    //   100: astore 6
    //   102: aload 6
    //   104: astore 5
    //   106: aload_0
    //   107: invokestatic 676	com/tencent/mobileqq/utils/FileUtils:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   110: pop
    //   111: aload 6
    //   113: astore 5
    //   115: new 678	java/io/FileOutputStream
    //   118: dup
    //   119: aload 9
    //   121: invokespecial 681	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: astore 9
    //   126: aload 6
    //   128: astore 5
    //   130: new 683	java/io/BufferedOutputStream
    //   133: dup
    //   134: aload 9
    //   136: invokespecial 686	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   139: astore 6
    //   141: aload_1
    //   142: getstatic 692	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   145: iload_2
    //   146: aload 6
    //   148: invokevirtual 695	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   151: pop
    //   152: aload 6
    //   154: invokevirtual 698	java/io/BufferedOutputStream:flush	()V
    //   157: aload 9
    //   159: invokevirtual 702	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +64 -> 228
    //   167: aload_1
    //   168: invokevirtual 707	java/io/FileDescriptor:valid	()Z
    //   171: ifeq +57 -> 228
    //   174: aload_1
    //   175: invokevirtual 710	java/io/FileDescriptor:sync	()V
    //   178: goto +50 -> 228
    //   181: aload 4
    //   183: ifnull +9 -> 192
    //   186: aload 4
    //   188: iconst_1
    //   189: invokevirtual 715	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   192: ldc 43
    //   194: ldc_w 672
    //   197: ldc_w 717
    //   200: invokestatic 55	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   203: goto +25 -> 228
    //   206: aload 4
    //   208: ifnull +9 -> 217
    //   211: aload 4
    //   213: iconst_1
    //   214: invokevirtual 715	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   217: ldc 43
    //   219: ldc_w 672
    //   222: ldc_w 719
    //   225: invokestatic 55	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload 6
    //   230: invokevirtual 722	java/io/BufferedOutputStream:close	()V
    //   233: goto +8 -> 241
    //   236: astore_1
    //   237: aload_1
    //   238: invokevirtual 663	java/io/IOException:printStackTrace	()V
    //   241: aload_0
    //   242: invokestatic 23	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   245: ifeq +5 -> 250
    //   248: iconst_1
    //   249: ireturn
    //   250: new 34	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   257: astore_0
    //   258: aload_0
    //   259: aload_3
    //   260: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_0
    //   265: ldc_w 724
    //   268: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: ldc 43
    //   274: ldc_w 672
    //   277: aload_0
    //   278: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 55	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   284: iconst_0
    //   285: ireturn
    //   286: astore_0
    //   287: aload 6
    //   289: astore 5
    //   291: goto +177 -> 468
    //   294: astore_1
    //   295: aload 6
    //   297: astore_0
    //   298: goto +18 -> 316
    //   301: astore_1
    //   302: aload 6
    //   304: astore_0
    //   305: goto +89 -> 394
    //   308: astore_0
    //   309: goto +159 -> 468
    //   312: astore_1
    //   313: aload 7
    //   315: astore_0
    //   316: aload_0
    //   317: astore 5
    //   319: new 34	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   326: astore 4
    //   328: aload_0
    //   329: astore 5
    //   331: aload 4
    //   333: aload_3
    //   334: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_0
    //   339: astore 5
    //   341: aload 4
    //   343: ldc_w 726
    //   346: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload_0
    //   351: astore 5
    //   353: ldc 43
    //   355: ldc_w 672
    //   358: aload 4
    //   360: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 55	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload_0
    //   367: astore 5
    //   369: aload_1
    //   370: invokevirtual 727	java/lang/Exception:printStackTrace	()V
    //   373: aload_0
    //   374: ifnull +14 -> 388
    //   377: aload_0
    //   378: invokevirtual 722	java/io/BufferedOutputStream:close	()V
    //   381: iconst_0
    //   382: ireturn
    //   383: astore_0
    //   384: aload_0
    //   385: invokevirtual 663	java/io/IOException:printStackTrace	()V
    //   388: iconst_0
    //   389: ireturn
    //   390: astore_1
    //   391: aload 8
    //   393: astore_0
    //   394: aload_0
    //   395: astore 5
    //   397: new 34	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   404: astore 4
    //   406: aload_0
    //   407: astore 5
    //   409: aload 4
    //   411: aload_3
    //   412: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_0
    //   417: astore 5
    //   419: aload 4
    //   421: ldc_w 665
    //   424: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload_0
    //   429: astore 5
    //   431: ldc 43
    //   433: ldc_w 672
    //   436: aload 4
    //   438: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 55	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   444: aload_0
    //   445: astore 5
    //   447: aload_1
    //   448: invokevirtual 666	java/io/FileNotFoundException:printStackTrace	()V
    //   451: aload_0
    //   452: ifnull +14 -> 466
    //   455: aload_0
    //   456: invokevirtual 722	java/io/BufferedOutputStream:close	()V
    //   459: iconst_0
    //   460: ireturn
    //   461: astore_0
    //   462: aload_0
    //   463: invokevirtual 663	java/io/IOException:printStackTrace	()V
    //   466: iconst_0
    //   467: ireturn
    //   468: aload 5
    //   470: ifnull +16 -> 486
    //   473: aload 5
    //   475: invokevirtual 722	java/io/BufferedOutputStream:close	()V
    //   478: goto +8 -> 486
    //   481: astore_1
    //   482: aload_1
    //   483: invokevirtual 663	java/io/IOException:printStackTrace	()V
    //   486: aload_0
    //   487: athrow
    //   488: new 34	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   495: astore_0
    //   496: aload_0
    //   497: aload_3
    //   498: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload_0
    //   503: ldc_w 668
    //   506: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: ldc 43
    //   512: ldc_w 672
    //   515: aload_0
    //   516: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 55	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   522: iconst_0
    //   523: ireturn
    //   524: astore_1
    //   525: goto -319 -> 206
    //   528: astore_1
    //   529: goto -348 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	paramString1	String
    //   0	532	1	paramBitmap	Bitmap
    //   0	532	2	paramInt	int
    //   0	532	3	paramString2	String
    //   0	532	4	paramCompressInfo	CompressInfo
    //   31	443	5	localObject1	Object
    //   100	203	6	localBufferedOutputStream	java.io.BufferedOutputStream
    //   94	220	7	localObject2	Object
    //   97	295	8	localObject3	Object
    //   77	81	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   228	233	236	java/io/IOException
    //   141	152	286	finally
    //   152	163	286	finally
    //   167	178	286	finally
    //   186	192	286	finally
    //   192	203	286	finally
    //   211	217	286	finally
    //   217	228	286	finally
    //   141	152	294	java/lang/Exception
    //   152	163	294	java/lang/Exception
    //   167	178	294	java/lang/Exception
    //   186	192	294	java/lang/Exception
    //   192	203	294	java/lang/Exception
    //   211	217	294	java/lang/Exception
    //   217	228	294	java/lang/Exception
    //   141	152	301	java/io/FileNotFoundException
    //   152	163	301	java/io/FileNotFoundException
    //   167	178	301	java/io/FileNotFoundException
    //   186	192	301	java/io/FileNotFoundException
    //   192	203	301	java/io/FileNotFoundException
    //   211	217	301	java/io/FileNotFoundException
    //   217	228	301	java/io/FileNotFoundException
    //   106	111	308	finally
    //   115	126	308	finally
    //   130	141	308	finally
    //   319	328	308	finally
    //   331	338	308	finally
    //   341	350	308	finally
    //   353	366	308	finally
    //   369	373	308	finally
    //   397	406	308	finally
    //   409	416	308	finally
    //   419	428	308	finally
    //   431	444	308	finally
    //   447	451	308	finally
    //   106	111	312	java/lang/Exception
    //   115	126	312	java/lang/Exception
    //   130	141	312	java/lang/Exception
    //   377	381	383	java/io/IOException
    //   106	111	390	java/io/FileNotFoundException
    //   115	126	390	java/io/FileNotFoundException
    //   130	141	390	java/io/FileNotFoundException
    //   455	459	461	java/io/IOException
    //   473	478	481	java/io/IOException
    //   152	163	524	java/io/SyncFailedException
    //   167	178	524	java/io/SyncFailedException
    //   152	163	528	java/io/IOException
    //   167	178	528	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.Utils
 * JD-Core Version:    0.7.0.1
 */