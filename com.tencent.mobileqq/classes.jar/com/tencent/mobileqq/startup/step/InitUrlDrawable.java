package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import anhk;
import bcpl;
import bcpm;
import bcpn;
import bcpo;
import bcpq;
import bdqh;
import bdua;
import bhgg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.dinifly.DiniFlyLog;
import com.tencent.mobileqq.dinifly.IDiniFlyQLog;
import com.tencent.mobileqq.theme.effect.QEffectApngImageView;
import com.tencent.mobileqq.theme.effect.QEffectGifImageView;
import com.tencent.mobileqq.theme.effect.QEffectLottieImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.effect.engine.QEffectEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InitUrlDrawable
  extends Step
{
  public static bdua a;
  private static IDiniFlyQLog jdField_a_of_type_ComTencentMobileqqDiniflyIDiniFlyQLog = new bcpl();
  private static List<String> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  public static volatile boolean a;
  
  private static String b(Exception paramException, boolean paramBoolean)
  {
    int k = 0;
    if (paramException == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramException = paramException.getStackTrace();
    ArrayList localArrayList = new ArrayList(8);
    int m = paramException.length;
    int i = 0;
    Object localObject;
    int j;
    if (i < m)
    {
      localObject = paramException[i];
      String str = localObject.getClassName();
      j = k;
      if (!str.contains("URLDrawable"))
      {
        j = k;
        if (!str.startsWith("android."))
        {
          j = k;
          if (!str.startsWith("java."))
          {
            j = k;
            if (!str.startsWith("com.android."))
            {
              if (!str.startsWith("dalvik.")) {
                break label134;
              }
              j = k;
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      k = j;
      break;
      label134:
      k += 1;
      if (k >= 8) {
        return localStringBuffer.toString();
      }
      localArrayList.add(localObject.toString());
      localStringBuffer.append(localObject.toString()).append(",");
      j = k;
      if (paramBoolean)
      {
        localStringBuffer.append("\n");
        j = k;
      }
    }
  }
  
  private static String b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.split(",");
    StringBuilder localStringBuilder = new StringBuilder(128);
    int i = 0;
    if ((i < paramString.length) && (i < paramInt))
    {
      int j = paramString[i].indexOf("(");
      if (j > 0) {
        localStringBuilder.append(paramString[i].substring(0, j)).append("()").append(",");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString[i]).append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  private static void b(Exception paramException, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong) {}
  
  protected boolean doStep()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    jdField_a_of_type_Boolean = true;
    DiniFlyLog.setLog(jdField_a_of_type_ComTencentMobileqqDiniflyIDiniFlyQLog);
    QEffectEngine.getInstance().setJsonConvert(new bcpo());
    QEffectEngine.getInstance().registerLoad(new bdqh());
    QEffectEngine.getInstance().registerEffect(2, "a.png", QEffectApngImageView.class);
    QEffectEngine.getInstance().registerEffect(3, "lottie", QEffectLottieImageView.class);
    QEffectEngine.getInstance().registerEffect(8, "gif", QEffectGifImageView.class);
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    URLDrawable.DEBUG = false;
    File localFile;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      localFile = new File(bhgg.a(anhk.ba));
    }
    try
    {
      for (;;)
      {
        URLDrawable.init(localBaseApplicationImpl, new bcpq(localBaseApplicationImpl));
        if (Build.VERSION.SDK_INT >= 11) {
          URLDrawable.setDebuggableCallback(new bcpm());
        }
        URLDrawable.isPublicVersion = true;
        localFile = new File(localFile, "diskcache");
        jdField_a_of_type_Bdua = new bdua(localFile);
        bdzx.a = localFile;
        JpegExifReader.initJpegExifReader(new bcpn());
        return true;
        localFile = localBaseApplicationImpl.getCacheDir();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AutoMonitor", 1, "", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable
 * JD-Core Version:    0.7.0.1
 */