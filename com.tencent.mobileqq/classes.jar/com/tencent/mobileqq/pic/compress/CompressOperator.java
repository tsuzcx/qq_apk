package com.tencent.mobileqq.pic.compress;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class CompressOperator
{
  private static final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getString(2131436928);
  private static List jdField_a_of_type_JavaUtilList;
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 1: 
    default: 
      return 0;
    }
    return 2;
  }
  
  private static PicType a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo != null) {}
    switch (paramCompressInfo.jdField_f_of_type_Int)
    {
    default: 
      return null;
    case 0: 
      if (paramCompressInfo.jdField_a_of_type_Int == 1035) {
        return new PicTypeTroopBar(paramCompressInfo);
      }
      return new PicTypeNormal(paramCompressInfo);
    case 1: 
      return new PicTypeLong(paramCompressInfo);
    }
    return new PicTypeGif(paramCompressInfo);
  }
  
  private static void a(CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if ((paramCompressInfo == null) || (TextUtils.isEmpty(paramCompressInfo.c)) || (TextUtils.isEmpty(paramCompressInfo.jdField_e_of_type_JavaLangString))) {
      Logger.b("CompressOperator", " checkAndLog()", "info == null || TextUtils.isEmpty(info.srcPath) || TextUtils.isEmpty(info.destPath)");
    }
    long l1;
    do
    {
      long l2;
      do
      {
        do
        {
          return;
          Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", paramCompressInfo.toString());
          if (!paramCompressInfo.jdField_a_of_type_Boolean) {
            break;
          }
        } while (paramBoolean);
        l1 = Utils.a(paramCompressInfo.c);
        l2 = Utils.a(paramCompressInfo.jdField_e_of_type_JavaLangString);
        Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "src File size:" + l1);
        Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "dest File size:" + l2);
      } while ((l1 <= 0L) || (l2 <= l1));
      if (l1 <= 1024L) {
        break;
      }
    } while ("webp".equals(FileUtils.a(paramCompressInfo.c)));
    Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", jdField_a_of_type_JavaLangString);
    paramCompressInfo.jdField_f_of_type_JavaLangString = ("CompressOperator" + paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()" + jdField_a_of_type_JavaLangString);
    FileUtils.d(paramCompressInfo.jdField_e_of_type_JavaLangString);
    if (jdField_a_of_type_JavaUtilList == null) {
      jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (!jdField_a_of_type_JavaUtilList.contains(paramBoolean + paramCompressInfo.c)) {
      jdField_a_of_type_JavaUtilList.add(paramBoolean + paramCompressInfo.c);
    }
    paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
    Logger.b("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", " destSize > srcSize, info.destPath = info.srcPath");
    return;
    Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "src length is too small");
    paramBoolean = "MI 6".equals(Build.MODEL);
    StatisticCollector.a(BaseApplication.getContext()).a(null, "SendPicSrcProblem", paramBoolean, 0L, l1, null, "");
    return;
    paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
    Logger.b("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " checkAndLog()", "info.isSuccess = false, info.destPath = info.srcPath");
  }
  
  public static boolean a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {
      return false;
    }
    Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " CompressOperator.start()", "processName = " + BaseApplicationImpl.sApplication.getProcessName() + ",srcPath = " + paramCompressInfo.c);
    long l1 = System.currentTimeMillis();
    boolean bool = a(paramCompressInfo, false);
    long l2 = System.currentTimeMillis();
    StatisticCollector.a(BaseApplication.getContext()).a(null, "AIOPicCompress", bool, l2 - l1, 0L, null, "");
    return bool;
  }
  
  private static boolean a(CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if ((paramCompressInfo == null) || (!FileUtils.b(paramCompressInfo.c)))
    {
      Logger.b("CompressOperator", " startImpl()", "info == null || TextUtils.isEmpty(info.srcPath)");
      return false;
    }
    Object localObject;
    if ((jdField_a_of_type_JavaUtilList != null) && (jdField_a_of_type_JavaUtilList.contains(paramBoolean + paramCompressInfo.c)))
    {
      Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " startImpl()", jdField_a_of_type_JavaLangString);
      paramCompressInfo.jdField_f_of_type_JavaLangString = ("CompressOperator" + paramCompressInfo.jdField_a_of_type_JavaLangString + " startImpl()" + jdField_a_of_type_JavaLangString);
      paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramCompressInfo.jdField_e_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      paramCompressInfo.d = ((BitmapFactory.Options)localObject).outWidth;
      paramCompressInfo.jdField_e_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      return true;
    }
    paramCompressInfo.h = NetworkUtil.b(BaseApplication.getContext());
    if (Utils.a(paramCompressInfo.c))
    {
      paramCompressInfo.jdField_f_of_type_Int = 2;
      if (QLog.isColorLevel()) {
        Logger.a("CompressOperator", " startImpl()", "info:" + paramCompressInfo);
      }
      localObject = a(paramCompressInfo);
      if (!paramBoolean) {
        break label335;
      }
    }
    label335:
    for (boolean bool = ((PicType)localObject).b();; bool = ((PicType)localObject).a())
    {
      paramCompressInfo.jdField_a_of_type_Boolean = bool;
      a(paramCompressInfo, paramBoolean);
      if (paramCompressInfo.jdField_e_of_type_JavaLangString != null)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      }
      try
      {
        ImageUtil.a(paramCompressInfo.jdField_e_of_type_JavaLangString, (BitmapFactory.Options)localObject);
        paramCompressInfo.d = ((BitmapFactory.Options)localObject).outWidth;
        paramCompressInfo.jdField_e_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
        return paramCompressInfo.jdField_a_of_type_Boolean;
      }
      catch (OutOfMemoryError paramCompressInfo) {}
      if (PhotoUtils.a(paramCompressInfo.c))
      {
        paramCompressInfo.jdField_f_of_type_Int = 1;
        break;
      }
      paramCompressInfo.jdField_f_of_type_Int = 0;
      break;
    }
    return false;
  }
  
  public static boolean b(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {
      return false;
    }
    Logger.a("CompressOperator", paramCompressInfo.jdField_a_of_type_JavaLangString + " startThumbnail()", "");
    return a(paramCompressInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.CompressOperator
 * JD-Core Version:    0.7.0.1
 */