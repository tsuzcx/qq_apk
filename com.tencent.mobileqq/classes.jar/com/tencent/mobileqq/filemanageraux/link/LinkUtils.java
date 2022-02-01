package com.tencent.mobileqq.filemanageraux.link;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import mqq.app.AppRuntime;

public final class LinkUtils
{
  public static long a(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      return -1L;
    }
    long l2 = NetConnInfoCenter.getServerTime();
    long l1;
    if (paramInt == 1) {
      l1 = 604800000L;
    } else {
      l1 = 2592000000L;
    }
    return l2 * 1000L + l1;
  }
  
  public static Bitmap a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = QRUtils.a(paramString, -1);
    if (localObject == null)
    {
      QLog.w("LinkUtils<FileAssistant>", 2, "getQrCode4Weiyun: encode failed.");
      return null;
    }
    int m = ((BitMatrix)localObject).a();
    int n = ((BitMatrix)localObject).b();
    paramString = new int[m * n];
    int i = 0;
    int j;
    int k;
    while (i < n)
    {
      j = 0;
      while (j < m)
      {
        if (((BitMatrix)localObject).a(j, i)) {
          k = -16777216;
        } else {
          k = 16777215;
        }
        paramString[(i * m + j)] = k;
        j += 1;
      }
      i += 1;
    }
    localObject = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString, 0, m, 0, 0, m, n);
    if (m == paramInt)
    {
      paramString = (String)localObject;
      if (n == paramInt) {}
    }
    else
    {
      paramString = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
      new Canvas(paramString).drawBitmap((Bitmap)localObject, new Rect(0, 0, m, n), new Rect(0, 0, paramInt, paramInt), null);
      ((Bitmap)localObject).recycle();
    }
    localObject = BitmapManager.a(BaseApplicationImpl.sApplication.getResources(), 2130845719);
    if (localObject != null)
    {
      paramInt = ((Bitmap)localObject).getWidth();
      i = ((Bitmap)localObject).getHeight();
      Canvas localCanvas = new Canvas(paramString);
      j = localCanvas.getWidth();
      k = localCanvas.getHeight();
      localCanvas.drawBitmap((Bitmap)localObject, new Rect(0, 0, paramInt, i), new Rect((j - paramInt) / 2, (k - i) / 2, (j + paramInt) / 2, (k + i) / 2), null);
      ((Bitmap)localObject).recycle();
    }
    return paramString;
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity, String paramString)
  {
    String str = paramString;
    if (paramFileManagerEntity != null) {
      if (TextUtils.isEmpty(paramFileManagerEntity.fileName)) {
        str = paramString;
      } else {
        str = paramFileManagerEntity.fileName;
      }
    }
    paramFileManagerEntity = FileUtil.a(str);
    if ((!".doc".equalsIgnoreCase(paramFileManagerEntity)) && (!".docx".equalsIgnoreCase(paramFileManagerEntity)))
    {
      if ((!".xls".equalsIgnoreCase(paramFileManagerEntity)) && (!".xlsx".equalsIgnoreCase(paramFileManagerEntity)))
      {
        if ((!".ppt".equalsIgnoreCase(paramFileManagerEntity)) && (!".pptx".equalsIgnoreCase(paramFileManagerEntity)))
        {
          if (".pdf".equalsIgnoreCase(paramFileManagerEntity)) {
            return "4";
          }
          if (".txt".equalsIgnoreCase(paramFileManagerEntity)) {
            return "5";
          }
          if ((!".zip".equalsIgnoreCase(paramFileManagerEntity)) && (!".rar".equalsIgnoreCase(paramFileManagerEntity))) {
            return "7";
          }
          return "6";
        }
        return "3";
      }
      return "2";
    }
    return "1";
  }
  
  public static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "1";
    }
    return "2";
  }
  
  public static void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString2 == null) {
      paramString2 = "";
    }
    if (paramString3 == null) {
      paramString3 = "";
    }
    ReportController.b(null, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, "", "");
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    if (paramBoolean) {
      return true;
    }
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramFileManagerEntity == null) {
      return false;
    }
    int i = FileManagerUtil.h(paramFileManagerEntity);
    if (i == 2) {
      return TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId) ^ true;
    }
    if (i == 1)
    {
      paramBoolean = bool2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.Uuid))
      {
        paramBoolean = bool2;
        if (!TextUtils.isEmpty(paramFileManagerEntity.peerUin)) {
          paramBoolean = true;
        }
      }
      return paramBoolean;
    }
    if (i == 4)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        try
        {
          paramFileManagerEntity = TroopFileUtils.a((QQAppInterface)localAppRuntime, paramFileManagerEntity);
          paramBoolean = bool1;
          if (paramFileManagerEntity != null)
          {
            bool2 = TextUtils.isEmpty(paramFileManagerEntity.r);
            paramBoolean = bool1;
            if (!bool2) {
              paramBoolean = true;
            }
          }
          return paramBoolean;
        }
        catch (Throwable paramFileManagerEntity)
        {
          QLog.e("LinkUtils<FileAssistant>", 2, "isSupportedShareByWeiyun error", paramFileManagerEntity);
        }
      }
    }
    return false;
  }
  
  public static String b(int paramInt)
  {
    if (paramInt <= 0) {
      return "";
    }
    Random localRandom = new Random();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      localStringBuilder.append("abcdefghijklmnopqrstuvwxyz0123456789".charAt(localRandom.nextInt(36)));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "";
        }
        return "3";
      }
      return "2";
    }
    return "1";
  }
  
  public static String d(int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 9)
        {
          if (paramInt != 10)
          {
            if (paramInt != 47) {
              return "";
            }
            return "5";
          }
          return "4";
        }
        return "3";
      }
      return "2";
    }
    return "1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.LinkUtils
 * JD-Core Version:    0.7.0.1
 */