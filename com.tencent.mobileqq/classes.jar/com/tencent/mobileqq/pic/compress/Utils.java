package com.tencent.mobileqq.pic.compress;

import agqd;
import agqe;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegDecompressor;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Utils
{
  public static long a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!FileUtils.b(paramString)))
    {
      Logger.b("compress.Utils", "getFileSize()", "path is empty, or file does not exist. path:" + paramString);
      return 0L;
    }
    return new File(paramString).length();
  }
  
  private static agqe a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 1;
    int m = 0;
    int j = URLDrawableHelper.a(false);
    int i = URLDrawableHelper.b(false);
    if (paramInt3 == 1)
    {
      j = FilePicURLDrawlableHelper.a;
      i = FilePicURLDrawlableHelper.c;
      if (paramInt1 <= j) {
        break label127;
      }
      if (!a(paramInt1, paramInt2, paramInt3)) {
        break label120;
      }
      paramInt2 = 1;
      paramInt1 = k;
    }
    for (;;)
    {
      agqe localagqe = new agqe(null);
      localagqe.a = paramInt2;
      localagqe.b = paramInt1;
      Logger.a("compress.Utils", "getType()", " type=" + localagqe);
      return localagqe;
      if (paramInt3 != 2) {
        break;
      }
      j = FilePicURLDrawlableHelper.b;
      i = FilePicURLDrawlableHelper.d;
      break;
      label120:
      paramInt1 = 2;
      paramInt2 = 2;
      continue;
      label127:
      if ((paramInt1 <= j) && (paramInt1 > i))
      {
        if (paramInt2 > j)
        {
          if (a(paramInt1, paramInt2, paramInt3))
          {
            paramInt2 = 1;
            paramInt1 = 3;
            continue;
          }
          paramInt1 = 4;
          paramInt2 = 2;
          continue;
        }
        if ((paramInt2 <= j) && (paramInt2 > i))
        {
          paramInt1 = 5;
          paramInt2 = 3;
        }
      }
      else if ((paramInt1 <= i) && (paramInt1 > 0))
      {
        if (paramInt2 > j)
        {
          paramInt1 = 6;
          paramInt2 = 4;
          continue;
        }
        if ((paramInt2 <= j) && (paramInt2 > i))
        {
          if (a(paramInt1, paramInt2, paramInt3))
          {
            paramInt1 = 7;
            paramInt2 = 4;
            continue;
          }
          paramInt1 = 8;
          paramInt2 = 3;
          continue;
        }
        if ((paramInt2 <= i) && (paramInt2 > 0))
        {
          if (a(paramInt1, paramInt2, paramInt3))
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
      paramInt2 = m;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap)
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
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    Logger.a("compress.Utils", "compositingWhiteBg()", "compositingWhiteBg is success");
    return paramBitmap;
  }
  
  public static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.a(paramString)))
    {
      String str2 = AppConstants.aK + "thumb/";
      if (paramString.startsWith(str2)) {
        return paramString;
      }
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      String str1;
      if (j <= 0) {
        str1 = paramString.substring(i + 1);
      }
      for (;;)
      {
        long l = new File(paramString).lastModified();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str2);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append(str1);
        localStringBuffer.append("_").append(l);
        localStringBuffer.append(".jpg");
        paramString = new File(str2);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        if (i < j + 1) {
          str1 = paramString.substring(i + 1, j);
        } else {
          str1 = paramString.substring(i + 1);
        }
      }
    }
    Logger.a("compress.Utils", "getThumbnailPath()", "realpath is empty, or file does not exist, realpath:" + paramString);
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (FileUtils.a(paramString)) && (PicQuality.a(paramInt)))
    {
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      Object localObject;
      String str;
      StringBuffer localStringBuffer;
      if ((j <= 0) || (j <= i))
      {
        localObject = paramString.substring(i + 1);
        long l = new File(paramString).lastModified();
        str = AppConstants.aK + "photo/";
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append((String)localObject);
        localStringBuffer.append("_").append(l);
        localObject = localStringBuffer.append("_");
        if (!a()) {
          break label233;
        }
      }
      label233:
      for (paramString = "wifi";; paramString = "xg")
      {
        ((StringBuffer)localObject).append(paramString);
        localStringBuffer.append("_").append(paramInt);
        localStringBuffer.append(".jpg");
        paramString = new File(str);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        localObject = paramString.substring(i + 1, j);
        break;
      }
    }
    Logger.a("compress.Utils", "getSendPhotoPath()", "realpath is empty, or file does not exist, or picQuality Illegal realpath:" + paramString + " picQuality:" + paramInt);
    return "";
  }
  
  public static void a(Context paramContext, List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int n;
    int m;
    int j;
    Object localObject1;
    String str2;
    String str3;
    String str4;
    String str5;
    int i1;
    int i;
    String str1;
    String str6;
    String str7;
    Object localObject3;
    Object localObject2;
    Object localObject4;
    Object localObject5;
    int k;
    if (paramList.size() > 1)
    {
      n = 1;
      m = 0;
      j = 0;
      localObject1 = "";
      str2 = BaseApplication.getContext().getString(2131436940);
      str3 = BaseApplication.getContext().getString(2131436941);
      str4 = BaseApplication.getContext().getString(2131436942);
      str5 = BaseApplication.getContext().getString(2131436943);
      i1 = 0;
      i = 0;
      str1 = "";
      str6 = BaseApplication.getContext().getString(2131436944);
      str7 = BaseApplication.getContext().getString(2131436945);
      localObject3 = BaseApplication.getContext().getString(2131436946);
      localObject2 = BaseApplication.getContext().getString(2131436947);
      localObject4 = paramList.iterator();
      for (;;)
      {
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (CompressInfo)((Iterator)localObject4).next();
          if ((localObject5 != null) && (((CompressInfo)localObject5).c)) {
            if (n != 0)
            {
              k = 1;
              localObject3 = localObject2;
            }
          }
        }
      }
    }
    for (;;)
    {
      label188:
      localObject4 = str1;
      localObject2 = localObject1;
      if (k == 0)
      {
        localObject5 = paramList.iterator();
        paramList = str1;
        label212:
        localObject4 = paramList;
        i1 = i;
        localObject2 = localObject1;
        m = j;
        if (((Iterator)localObject5).hasNext())
        {
          localObject2 = (CompressInfo)((Iterator)localObject5).next();
          if ((localObject2 == null) || (((CompressInfo)localObject2).e) || (!((CompressInfo)localObject2).jdField_b_of_type_Boolean)) {
            break label436;
          }
          i1 = 1;
          j = 1;
          if (!str4.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString)) {
            break label382;
          }
          localObject4 = paramList;
          i1 = i;
          localObject2 = localObject1;
          m = j;
          if (!str4.equals(localObject1))
          {
            if (n == 0) {
              break label366;
            }
            localObject2 = str5;
            m = j;
            i1 = i;
            localObject4 = paramList;
          }
        }
      }
      for (;;)
      {
        if (k == 0) {
          break label494;
        }
        QQToast.a(paramContext, (CharSequence)localObject3, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
        return;
        n = 0;
        break;
        k = 1;
        break label188;
        label366:
        localObject2 = str4;
        localObject4 = paramList;
        i1 = i;
        m = j;
      }
      label382:
      m = i1;
      if (str2.equals(((CompressInfo)localObject2).jdField_b_of_type_JavaLangString))
      {
        m = i1;
        if (!str2.equals(localObject1)) {
          if (n != 0)
          {
            j = 1;
            localObject1 = str3;
          }
        }
      }
      for (;;)
      {
        break label212;
        j = 1;
        localObject1 = str2;
        continue;
        label436:
        m = j;
        if (localObject2 != null)
        {
          m = j;
          if (((CompressInfo)localObject2).e)
          {
            m = j;
            if (((CompressInfo)localObject2).jdField_b_of_type_Boolean)
            {
              m = j;
              if (i == 0)
              {
                if (n != 0)
                {
                  i = 1;
                  paramList = str7;
                  continue;
                }
                i = 1;
                paramList = str6;
                continue;
                label494:
                if (m != 0)
                {
                  QQToast.a(paramContext, (CharSequence)localObject2, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
                  return;
                }
                if (i1 == 0) {
                  break;
                }
                QQToast.a(paramContext, (CharSequence)localObject4, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
                return;
              }
            }
          }
        }
        j = m;
      }
      localObject3 = "";
      k = 0;
    }
  }
  
  public static boolean a()
  {
    return NetworkUtil.b(BaseApplication.getContext()) == 1;
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 == 1) || (paramInt3 == 2)) {
      if (paramInt2 <= (int)(paramInt1 * 1.777778F)) {}
    }
    while (paramInt2 > paramInt1 * 3)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static boolean a(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = PicItemBuilder.a();
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
  
  public static boolean a(Bitmap paramBitmap, agqe paramagqe, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    int n = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    int i = URLDrawableHelper.a(false);
    int m = URLDrawableHelper.b(false);
    if (paramInt == 1)
    {
      i = FilePicURLDrawlableHelper.a;
      m = FilePicURLDrawlableHelper.c;
    }
    label40:
    label1596:
    for (;;)
    {
      int j;
      int i1;
      int k;
      Object localObject;
      int i4;
      switch (paramagqe.b)
      {
      case 2: 
      case 4: 
      case 5: 
      default: 
        j = i2;
        i1 = n;
        k = n;
        n = j;
        j = i2;
        localObject = new Matrix();
        i4 = URLDrawableHelper.a(paramString1);
        if ((!paramBoolean) || (i4 == 0) || (i4 % 90 != 0)) {
          break;
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        Logger.a("compress.Utils", paramString3, paramString4 + " sample after W:" + k + " H:" + j + " isLongImg:" + a(0, 0, paramInt) + " type:" + paramagqe + " needRotate:" + bool2);
        int i3;
        if (i1 > n) {
          i3 = i1;
        }
        boolean bool1;
        for (i2 = n;; i2 = i1) {
          switch (paramagqe.a)
          {
          default: 
            bool1 = false;
            paramBoolean = false;
            Logger.a("compress.Utils", paramString3, paramString4 + " destWidth：" + i1 + " destHeight:" + n + " needCut:" + bool1 + " needScale:" + paramBoolean + " needRotate:" + bool2);
            paramBitmap = a(paramBitmap);
            if (paramInt == 3)
            {
              paramBoolean = a(paramBitmap);
              Logger.a("compress.Utils", paramString3, paramString4 + " isDrawGIFSucc：" + paramBoolean);
            }
            paramBoolean = c(paramString2, paramBitmap, 70, paramString4, null);
            if (paramBitmap != null) {
              paramBitmap.recycle();
            }
            return paramBoolean;
            if (paramInt != 2) {
              break label1596;
            }
            i = FilePicURLDrawlableHelper.b;
            m = FilePicURLDrawlableHelper.d;
            break label40;
            Logger.a("compress.Utils", paramString3, paramString4 + " type.type2:136");
            if (n > i2)
            {
              j = i2;
              label477:
              if ((paramInt != 1) && (paramInt != 2)) {
                break label591;
              }
              k = (int)(j * 1.777778F);
              label499:
              if (n <= i2) {
                break label600;
              }
            }
            for (;;)
            {
              for (;;)
              {
                n = k;
                try
                {
                  if (k > paramBitmap.getWidth()) {
                    n = paramBitmap.getWidth();
                  }
                  k = j;
                  if (j > paramBitmap.getHeight()) {
                    k = paramBitmap.getHeight();
                  }
                  localObject = Bitmap.createBitmap(paramBitmap, 0, 0, n, k);
                  k = ((Bitmap)localObject).getWidth();
                  j = ((Bitmap)localObject).getHeight();
                  n = j;
                  i1 = k;
                  paramBitmap = (Bitmap)localObject;
                }
                catch (OutOfMemoryError paramString1)
                {
                  label591:
                  label600:
                  paramBitmap.recycle();
                  paramString1.printStackTrace();
                  Logger.b("compress.Utils", paramString3, paramString4 + " cut 3:1 createBitmap OutOfMemoryError, type:" + paramagqe);
                  return false;
                }
              }
              j = n;
              break label477;
              k = j * 3;
              break label499;
              n = j;
              j = k;
              k = n;
            }
            i3 = n;
          }
        }
        float f = m / (i2 * 1.0F);
        i2 = (int)(i3 * f);
        if (bool2) {
          ((Matrix)localObject).postRotate(i4, k >> 1, j >> 1);
        }
        ((Matrix)localObject).postScale(f, f);
        i2 = k;
        for (;;)
        {
          for (;;)
          {
            try
            {
              if (k > paramBitmap.getWidth()) {
                i2 = paramBitmap.getWidth();
              }
              k = j;
              if (j > paramBitmap.getHeight()) {
                k = paramBitmap.getHeight();
              }
              paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, i2, k, (Matrix)localObject, true);
              if (i1 > n) {
                j = m;
              }
            }
            catch (OutOfMemoryError paramString1)
            {
              try
              {
                if (i4 / 90 % 2 == 0) {
                  break label1575;
                }
                i1 = j;
                if (j > paramString1.getWidth()) {
                  i1 = paramString1.getWidth();
                }
                n = i;
                if (i > paramString1.getHeight()) {
                  n = paramString1.getHeight();
                }
                paramBitmap = Bitmap.createBitmap(paramString1, 0, 0, i1, n);
                bool1 = true;
                paramBoolean = true;
              }
              catch (OutOfMemoryError paramBitmap)
              {
                paramString1.recycle();
                paramBitmap.printStackTrace();
                Logger.b("compress.Utils", paramString3, paramString4 + " case 1: cut createBitmap OutOfMemoryError, type:" + paramagqe);
                return false;
              }
              paramString1 = paramString1;
              paramBitmap.recycle();
              paramString1.printStackTrace();
              Logger.b("compress.Utils", paramString3, paramString4 + " case 1: scale or rotate createBitmap OutOfMemoryError, type:" + paramagqe);
              return false;
            }
            j = i;
            i = m;
            continue;
            f = i / (i3 * 1.0F);
            m = (int)(i2 * f);
            if (i1 > n)
            {
              i1 = i;
              n = m;
            }
            for (;;)
            {
              for (;;)
              {
                if (bool2) {
                  ((Matrix)localObject).postRotate(i4, k >> 1, j >> 1);
                }
                ((Matrix)localObject).postScale(f, f);
                i = k;
                try
                {
                  if (k > paramBitmap.getWidth()) {
                    i = paramBitmap.getWidth();
                  }
                  k = j;
                  if (j > paramBitmap.getHeight()) {
                    k = paramBitmap.getHeight();
                  }
                  paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, i, k, (Matrix)localObject, true);
                  bool1 = false;
                  paramBitmap = paramString1;
                  paramBoolean = true;
                }
                catch (OutOfMemoryError paramString1)
                {
                  paramBitmap.recycle();
                  paramString1.printStackTrace();
                  Logger.b("compress.Utils", paramString3, paramString4 + " case 2: scale or rotate createBitmap OutOfMemoryError, type:" + paramagqe);
                  return false;
                }
              }
              n = i;
              i1 = m;
            }
            if (!bool2) {
              break;
            }
            ((Matrix)localObject).postRotate(i4, k >> 1, j >> 1);
            i = k;
            try
            {
              if (k > paramBitmap.getWidth()) {
                i = paramBitmap.getWidth();
              }
              k = j;
              if (j > paramBitmap.getHeight()) {
                k = paramBitmap.getHeight();
              }
              paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, i, k, (Matrix)localObject, true);
              bool1 = false;
              paramBitmap = paramString1;
              paramBoolean = false;
            }
            catch (OutOfMemoryError paramString1)
            {
              paramBitmap.recycle();
              paramString1.printStackTrace();
              Logger.b("compress.Utils", paramString3, paramString4 + " case 3: rotate createBitmap OutOfMemoryError, type:" + paramagqe);
              return false;
            }
          }
          if (bool2)
          {
            ((Matrix)localObject).postRotate(i4, k >> 1, j >> 1);
            i = k;
          }
          for (;;)
          {
            try
            {
              if (k > paramBitmap.getWidth()) {
                i = paramBitmap.getWidth();
              }
              k = j;
              if (j > paramBitmap.getHeight()) {
                k = paramBitmap.getHeight();
              }
              paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, i, k, (Matrix)localObject, true);
              paramBitmap = paramString1;
              if ((paramInt == 1) || (paramInt == 2))
              {
                i = (int)(i2 * 1.777778F);
                if (i1 <= n) {
                  break label1496;
                }
                j = i2;
              }
            }
            catch (OutOfMemoryError paramString1)
            {
              try
              {
                if (i4 / 90 % 2 == 0) {
                  break label1557;
                }
                i1 = j;
                if (j > paramBitmap.getWidth()) {
                  i1 = paramBitmap.getWidth();
                }
                n = i;
                if (i > paramBitmap.getHeight()) {
                  n = paramBitmap.getHeight();
                }
                paramString1 = Bitmap.createBitmap(paramBitmap, 0, 0, i1, n);
                paramBitmap = paramString1;
                bool1 = true;
                paramBoolean = false;
              }
              catch (OutOfMemoryError paramString1)
              {
                if (paramBitmap.isRecycled()) {
                  break label1519;
                }
                paramBitmap.recycle();
                paramString1.printStackTrace();
                Logger.b("compress.Utils", paramString3, paramString4 + " case 4: cut createBitmap OutOfMemoryError, type:" + paramagqe);
                return false;
              }
              paramString1 = paramString1;
              paramBitmap.recycle();
              paramString1.printStackTrace();
              Logger.b("compress.Utils", paramString3, paramString4 + " case 4: rotate createBitmap OutOfMemoryError, type:" + paramagqe);
              return false;
            }
            i = i2 * 3;
            continue;
            label1496:
            j = i;
            i = i2;
            continue;
            label1519:
            k = i;
            i = j;
            j = k;
          }
          k = i;
          i = j;
          j = k;
        }
      }
    }
  }
  
  private static boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (paramOptions == null)
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramOptions.outWidth;
    int n = paramOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
      return false;
    }
    int j = n;
    int k = m;
    int i = 1;
    k >>= 1;
    j >>= 1;
    if ((k < paramInt) || (j < paramInt))
    {
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label172;
      }
    }
    label172:
    for (paramInt = paramOptions.inSampleSize;; paramInt = 1)
    {
      paramOptions.inSampleSize = paramInt;
      Logger.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  public static boolean a(BitmapFactory.Options paramOptions, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramOptions == null) || (TextUtils.isEmpty(paramString)))
    {
      Logger.b("compress.Utils", "calculateInSampleSize()", "options == null || TextUtils.isEmpty(filepath)");
      return false;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 < paramInt2)) {
      throw new IllegalArgumentException("max < 0 || min < 0 || max < min");
    }
    if (paramInt2 > paramInt1 / 2) {
      throw new IllegalArgumentException("min > max / 2");
    }
    paramOptions.inJustDecodeBounds = true;
    ImageUtil.a(paramString, paramOptions);
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    if (j > i)
    {
      i = j;
      if (i > paramInt1)
      {
        j = 1;
        int k;
        int m;
        do
        {
          do
          {
            k = i >> 1;
            m = j * 2;
            i = k;
            j = m;
          } while (k < paramInt2);
          i = k;
          j = m;
        } while (k > paramInt1);
        paramOptions.inSampleSize = m;
      }
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label214;
      }
    }
    label214:
    for (paramInt1 = paramOptions.inSampleSize;; paramInt1 = 1)
    {
      paramOptions.inSampleSize = paramInt1;
      Logger.a("compress.Utils", "calculateInSampleSize()", "options.inSampleSize=" + paramOptions.inSampleSize);
      return true;
      break;
    }
  }
  
  private static boolean a(JpegOptions paramJpegOptions, int paramInt)
  {
    if (paramJpegOptions == null)
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramJpegOptions.outWidth;
    int n = paramJpegOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      Logger.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
      return false;
    }
    int j = n;
    int k = m;
    int i = 1;
    k >>= 1;
    j >>= 1;
    if ((k < paramInt) || (j < paramInt))
    {
      paramJpegOptions.inSampleSize = i;
      paramJpegOptions.inJustDecodeBounds = false;
      if (paramJpegOptions.inSampleSize < 1) {
        break label172;
      }
    }
    label172:
    for (paramInt = paramJpegOptions.inSampleSize;; paramInt = 1)
    {
      paramJpegOptions.inSampleSize = paramInt;
      Logger.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramJpegOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool = GifDrawable.isGifFile(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "isGifFile result:" + bool);
      }
      return bool;
    }
    return false;
  }
  
  public static boolean a(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if (c()) {
      return b(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
    }
    return c(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.b(paramString1)))
    {
      Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      return false;
    }
    Logger.a("compress.Utils", "compressAIOThumbnail", paramString3);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    ImageUtil.a(paramString1, localOptions);
    int j;
    int i;
    agqe localagqe;
    if (localOptions.outWidth > localOptions.outHeight)
    {
      j = localOptions.outWidth;
      i = localOptions.outHeight;
      localagqe = a(i, j, paramInt);
      i = URLDrawableHelper.a(false);
      URLDrawableHelper.b(false);
      if (paramInt != 1) {
        break label218;
      }
      i = FilePicURLDrawlableHelper.a;
      j = FilePicURLDrawlableHelper.c;
    }
    for (;;)
    {
      if (a(localOptions, i)) {
        break label237;
      }
      Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " calculateInSampleSize fail");
      return false;
      j = localOptions.outHeight;
      i = localOptions.outWidth;
      break;
      label218:
      if (paramInt == 2)
      {
        i = FilePicURLDrawlableHelper.b;
        j = FilePicURLDrawlableHelper.d;
      }
    }
    try
    {
      label237:
      Bitmap localBitmap3 = ImageUtil.a(paramString1, localOptions);
      Bitmap localBitmap1 = localBitmap3;
      if (localBitmap3 == null)
      {
        Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError");
      localOptions.inSampleSize *= 2;
      try
      {
        Bitmap localBitmap2 = ImageUtil.a(paramString1, localOptions);
        i = localBitmap2.getWidth();
        j = localBitmap2.getHeight();
        Logger.a("compress.Utils", "compressAIOThumbnail", paramString3 + " sample after W:" + i + " H:" + j);
        return a(localBitmap2, localagqe, paramBoolean, paramString1, paramString2, "compressAIOThumbnail", paramString3, paramInt);
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        Logger.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localOptions.inSampleSize);
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 2) {
      return false;
    }
    return localObject[1].equals("1");
  }
  
  public static boolean b(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (FileUtils.b(paramString))
    {
      bool1 = bool3;
      if (!FileUtils.a(paramString).equals("jpg")) {}
    }
    try
    {
      float f = JpegCompressor.getJpegQuality(paramString);
      long l = FileUtils.a(paramString);
      bool1 = bool2;
      if (f <= 80.0F)
      {
        bool1 = bool2;
        if (l < 307200L) {
          bool1 = true;
        }
      }
      Logger.a("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality = " + f + ",picSize = " + l + "result = " + bool1);
      return bool1;
    }
    catch (RuntimeException paramString)
    {
      Logger.b("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality RuntimeException error = " + paramString + ",return false!");
      return false;
    }
    catch (OutOfMemoryError paramString)
    {
      Logger.b("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality OutOfMemoryError error = " + paramString + ",return false!");
    }
    return false;
  }
  
  private static boolean b(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBitmap == null) || (paramInt > 100) || (paramInt <= 0))
    {
      Logger.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " TextUtils.isEmpty(destPath) || bm == null || quality > 100 || quality <= 0");
      return false;
    }
    Logger.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      ((File)localObject).createNewFile();
      localObject = new JpegCompressor(new agqd((File)localObject, paramCompressInfo));
      ((JpegCompressor)localObject).setParams(paramInt, true, true, false);
      try
      {
        LogTag.a();
        ((JpegCompressor)localObject).compress(paramBitmap);
        LogTag.a("peak_pgjpeg", "pgjpeg " + paramBitmap.getWidth() + "x" + paramBitmap.getHeight() + " compress");
        Logger.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
        return true;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("peak_pgjpeg", 2, "JpegCompressor.compress() error", localException);
        }
        return c(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
      }
      return false;
    }
    catch (FileNotFoundException paramString1)
    {
      Logger.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " FileOutputStream FileNotFoundException");
      paramString1.printStackTrace();
      return false;
    }
    catch (IOException paramString1)
    {
      Logger.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " createNewFile IOException");
      paramString1.printStackTrace();
    }
  }
  
  public static boolean b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!FileUtils.b(paramString1)))
    {
      Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      return false;
    }
    Logger.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3);
    JpegOptions localJpegOptions = new JpegOptions();
    localJpegOptions.inJustDecodeBounds = true;
    JpegDecompressor.decodeFile(paramString1, localJpegOptions);
    int j;
    int i;
    agqe localagqe;
    if (localJpegOptions.outWidth > localJpegOptions.outHeight)
    {
      j = localJpegOptions.outWidth;
      i = localJpegOptions.outHeight;
      localagqe = a(i, j, paramInt);
      i = URLDrawableHelper.a(false);
      URLDrawableHelper.b(false);
      if (paramInt != 1) {
        break label218;
      }
      i = FilePicURLDrawlableHelper.a;
      j = FilePicURLDrawlableHelper.c;
    }
    for (;;)
    {
      if (a(localJpegOptions, i)) {
        break label237;
      }
      Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " calculateInSampleSize fail");
      return false;
      j = localJpegOptions.outHeight;
      i = localJpegOptions.outWidth;
      break;
      label218:
      if (paramInt == 2)
      {
        i = FilePicURLDrawlableHelper.b;
        j = FilePicURLDrawlableHelper.d;
      }
    }
    try
    {
      label237:
      Bitmap localBitmap3 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
      Bitmap localBitmap1 = localBitmap3;
      if (localBitmap3 == null)
      {
        Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError");
      localJpegOptions.inSampleSize *= 2;
      try
      {
        Bitmap localBitmap2 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
        i = localBitmap2.getWidth();
        j = localBitmap2.getHeight();
        Logger.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " sample after W:" + i + " H:" + j);
        return a(localBitmap2, localagqe, paramBoolean, paramString1, paramString2, "compressAIOThumbnailWithTrubo", paramString3, paramInt);
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        Logger.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localJpegOptions.inSampleSize);
      }
    }
    return false;
  }
  
  public static boolean c()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 1) {
      return false;
    }
    return localObject[0].equals("1");
  }
  
  /* Error */
  private static boolean c(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: invokestatic 17	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +17 -> 24
    //   10: aload_1
    //   11: ifnull +13 -> 24
    //   14: iload_2
    //   15: bipush 100
    //   17: if_icmpgt +7 -> 24
    //   20: iload_2
    //   21: ifgt +37 -> 58
    //   24: ldc 25
    //   26: ldc_w 652
    //   29: new 29	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   36: aload_3
    //   37: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 589
    //   43: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 45	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   52: iconst_0
    //   53: istore 5
    //   55: iload 5
    //   57: ireturn
    //   58: ldc 25
    //   60: ldc_w 652
    //   63: new 29	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   70: aload_3
    //   71: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 591
    //   77: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload_2
    //   81: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 90	com/tencent/mobileqq/pic/Logger:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   90: new 47	java/io/File
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 211	java/io/File:exists	()Z
    //   103: ifeq +8 -> 111
    //   106: aload_0
    //   107: invokevirtual 594	java/io/File:delete	()Z
    //   110: pop
    //   111: aload_0
    //   112: invokevirtual 597	java/io/File:createNewFile	()Z
    //   115: pop
    //   116: new 654	java/io/FileOutputStream
    //   119: dup
    //   120: aload_0
    //   121: invokespecial 657	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: astore 7
    //   126: new 659	java/io/BufferedOutputStream
    //   129: dup
    //   130: aload 7
    //   132: invokespecial 662	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   135: astore 6
    //   137: aload 6
    //   139: astore_0
    //   140: aload_1
    //   141: getstatic 668	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   144: iload_2
    //   145: aload 6
    //   147: invokevirtual 671	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   150: pop
    //   151: aload 6
    //   153: astore_0
    //   154: aload 6
    //   156: invokevirtual 674	java/io/BufferedOutputStream:flush	()V
    //   159: aload 6
    //   161: astore_0
    //   162: aload 7
    //   164: invokevirtual 678	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   167: astore_1
    //   168: aload_1
    //   169: ifnull +20 -> 189
    //   172: aload 6
    //   174: astore_0
    //   175: aload_1
    //   176: invokevirtual 683	java/io/FileDescriptor:valid	()Z
    //   179: ifeq +10 -> 189
    //   182: aload 6
    //   184: astore_0
    //   185: aload_1
    //   186: invokevirtual 686	java/io/FileDescriptor:sync	()V
    //   189: aload 6
    //   191: ifnull -136 -> 55
    //   194: aload 6
    //   196: invokevirtual 689	java/io/BufferedOutputStream:close	()V
    //   199: iconst_1
    //   200: ireturn
    //   201: astore_0
    //   202: aload_0
    //   203: invokevirtual 637	java/io/IOException:printStackTrace	()V
    //   206: iconst_1
    //   207: ireturn
    //   208: astore_0
    //   209: aload 4
    //   211: ifnull +12 -> 223
    //   214: aload 6
    //   216: astore_0
    //   217: aload 4
    //   219: iconst_1
    //   220: invokevirtual 692	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   223: aload 6
    //   225: astore_0
    //   226: ldc 25
    //   228: ldc_w 652
    //   231: ldc_w 694
    //   234: invokestatic 45	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   237: goto -48 -> 189
    //   240: astore_1
    //   241: aload 6
    //   243: astore_0
    //   244: ldc 25
    //   246: ldc_w 652
    //   249: new 29	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   256: aload_3
    //   257: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc_w 633
    //   263: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 45	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   272: aload 6
    //   274: astore_0
    //   275: aload_1
    //   276: invokevirtual 634	java/io/FileNotFoundException:printStackTrace	()V
    //   279: aload 6
    //   281: ifnull +8 -> 289
    //   284: aload 6
    //   286: invokevirtual 689	java/io/BufferedOutputStream:close	()V
    //   289: iconst_0
    //   290: ireturn
    //   291: astore_0
    //   292: aload 4
    //   294: ifnull +12 -> 306
    //   297: aload 6
    //   299: astore_0
    //   300: aload 4
    //   302: iconst_1
    //   303: invokevirtual 692	com/tencent/mobileqq/pic/CompressInfo:b	(Z)V
    //   306: aload 6
    //   308: astore_0
    //   309: ldc 25
    //   311: ldc_w 652
    //   314: ldc_w 696
    //   317: invokestatic 45	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   320: goto -131 -> 189
    //   323: astore_1
    //   324: aload 6
    //   326: astore_0
    //   327: ldc 25
    //   329: ldc_w 652
    //   332: new 29	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   339: aload_3
    //   340: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: ldc_w 698
    //   346: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 45	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   355: aload 6
    //   357: astore_0
    //   358: aload_1
    //   359: invokevirtual 699	java/lang/Exception:printStackTrace	()V
    //   362: aload 6
    //   364: ifnull +8 -> 372
    //   367: aload 6
    //   369: invokevirtual 689	java/io/BufferedOutputStream:close	()V
    //   372: iconst_0
    //   373: ireturn
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual 637	java/io/IOException:printStackTrace	()V
    //   379: goto -90 -> 289
    //   382: astore_0
    //   383: aload_0
    //   384: invokevirtual 637	java/io/IOException:printStackTrace	()V
    //   387: goto -15 -> 372
    //   390: astore_1
    //   391: aconst_null
    //   392: astore_0
    //   393: aload_0
    //   394: ifnull +7 -> 401
    //   397: aload_0
    //   398: invokevirtual 689	java/io/BufferedOutputStream:close	()V
    //   401: aload_1
    //   402: athrow
    //   403: astore_0
    //   404: aload_0
    //   405: invokevirtual 637	java/io/IOException:printStackTrace	()V
    //   408: goto -7 -> 401
    //   411: astore_1
    //   412: goto -19 -> 393
    //   415: astore_1
    //   416: aconst_null
    //   417: astore 6
    //   419: goto -95 -> 324
    //   422: astore_1
    //   423: aconst_null
    //   424: astore 6
    //   426: goto -185 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	paramString1	String
    //   0	429	1	paramBitmap	Bitmap
    //   0	429	2	paramInt	int
    //   0	429	3	paramString2	String
    //   0	429	4	paramCompressInfo	CompressInfo
    //   1	55	5	bool	boolean
    //   135	290	6	localBufferedOutputStream	java.io.BufferedOutputStream
    //   124	39	7	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   194	199	201	java/io/IOException
    //   154	159	208	java/io/SyncFailedException
    //   162	168	208	java/io/SyncFailedException
    //   175	182	208	java/io/SyncFailedException
    //   185	189	208	java/io/SyncFailedException
    //   140	151	240	java/io/FileNotFoundException
    //   154	159	240	java/io/FileNotFoundException
    //   162	168	240	java/io/FileNotFoundException
    //   175	182	240	java/io/FileNotFoundException
    //   185	189	240	java/io/FileNotFoundException
    //   217	223	240	java/io/FileNotFoundException
    //   226	237	240	java/io/FileNotFoundException
    //   300	306	240	java/io/FileNotFoundException
    //   309	320	240	java/io/FileNotFoundException
    //   154	159	291	java/io/IOException
    //   162	168	291	java/io/IOException
    //   175	182	291	java/io/IOException
    //   185	189	291	java/io/IOException
    //   140	151	323	java/lang/Exception
    //   154	159	323	java/lang/Exception
    //   162	168	323	java/lang/Exception
    //   175	182	323	java/lang/Exception
    //   185	189	323	java/lang/Exception
    //   217	223	323	java/lang/Exception
    //   226	237	323	java/lang/Exception
    //   300	306	323	java/lang/Exception
    //   309	320	323	java/lang/Exception
    //   284	289	374	java/io/IOException
    //   367	372	382	java/io/IOException
    //   111	137	390	finally
    //   397	401	403	java/io/IOException
    //   140	151	411	finally
    //   154	159	411	finally
    //   162	168	411	finally
    //   175	182	411	finally
    //   185	189	411	finally
    //   217	223	411	finally
    //   226	237	411	finally
    //   244	272	411	finally
    //   275	279	411	finally
    //   300	306	411	finally
    //   309	320	411	finally
    //   327	355	411	finally
    //   358	362	411	finally
    //   111	137	415	java/lang/Exception
    //   111	137	422	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.Utils
 * JD-Core Version:    0.7.0.1
 */