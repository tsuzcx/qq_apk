package com.tencent.mobileqq.pic.compress;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.PhotoIncompatibleBase;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

public class CompressOperator
{
  private static final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getString(2131691040);
  @ConfigInject(configPath="Business/qqpic-api/src/main/resources/Inject_InitCompressPicType.yml", version=1)
  public static HashMap<String, Class<? extends AbstractPicType>> a;
  private static List<String> jdField_a_of_type_JavaUtilList;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("2", PicTypeGif.class);
    jdField_a_of_type_JavaUtilHashMap.put("1", PicTypeLong.class);
    jdField_a_of_type_JavaUtilHashMap.put("0", PicTypeNormal.class);
    jdField_a_of_type_JavaUtilHashMap.put("0_1036", PicTypeKandian.class);
    jdField_a_of_type_JavaUtilHashMap.put("0_1035", PicTypeTroopBar.class);
  }
  
  public static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 2) {
        return 0;
      }
      return 2;
    }
    return 0;
  }
  
  static AbstractPicType a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo != null)
    {
      Object localObject1 = jdField_a_of_type_JavaUtilHashMap;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramCompressInfo.jdField_f_of_type_Int);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramCompressInfo.jdField_a_of_type_Int);
      localObject2 = (Class)((HashMap)localObject1).get(((StringBuilder)localObject2).toString());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramCompressInfo.jdField_f_of_type_Int);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject1 = (Class)jdField_a_of_type_JavaUtilHashMap.get(localObject1);
      }
      if (localObject1 != null) {
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredConstructor(new Class[] { CompressInfo.class });
          ((Constructor)localObject1).setAccessible(true);
          paramCompressInfo = (AbstractPicType)((Constructor)localObject1).newInstance(new Object[] { paramCompressInfo });
          return paramCompressInfo;
        }
        catch (Exception paramCompressInfo)
        {
          Logger.b("CompressOperator", " picTypeFactory", paramCompressInfo.getMessage());
        }
      }
    }
    return null;
  }
  
  private static void a(CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    if ((paramCompressInfo != null) && (!TextUtils.isEmpty(paramCompressInfo.c)) && (!TextUtils.isEmpty(paramCompressInfo.jdField_e_of_type_JavaLangString)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" checkAndLog()");
      Logger.a("CompressOperator", ((StringBuilder)localObject).toString(), paramCompressInfo.toString());
      if (paramCompressInfo.jdField_a_of_type_Boolean)
      {
        if (!paramBoolean)
        {
          long l1 = Utils.a(paramCompressInfo.c);
          long l2 = Utils.a(paramCompressInfo.jdField_e_of_type_JavaLangString);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(" checkAndLog()");
          localObject = ((StringBuilder)localObject).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("src File size:");
          localStringBuilder.append(l1);
          Logger.a("CompressOperator", (String)localObject, localStringBuilder.toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(" checkAndLog()");
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("dest File size:");
          localStringBuilder.append(l2);
          Logger.a("CompressOperator", (String)localObject, localStringBuilder.toString());
          if ((l1 > 0L) && (l2 > l1))
          {
            if (PhotoIncompatibleBase.b(paramCompressInfo.c))
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append(" checkAndLog()");
              Logger.a("CompressOperator", ((StringBuilder)localObject).toString(), "src is incompatible ,keep compress file");
              return;
            }
            if (l1 > 1024L)
            {
              FileUtils.estimateFileType(paramCompressInfo.c);
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append(" checkAndLog()");
              Logger.a("CompressOperator", ((StringBuilder)localObject).toString(), jdField_a_of_type_JavaLangString);
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("CompressOperator");
              ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append(" checkAndLog()");
              ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
              paramCompressInfo.jdField_f_of_type_JavaLangString = ((StringBuilder)localObject).toString();
              FileUtils.deleteFile(paramCompressInfo.jdField_e_of_type_JavaLangString);
              if (jdField_a_of_type_JavaUtilList == null) {
                jdField_a_of_type_JavaUtilList = new ArrayList();
              }
              localObject = jdField_a_of_type_JavaUtilList;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramBoolean);
              localStringBuilder.append(paramCompressInfo.c);
              if (!((List)localObject).contains(localStringBuilder.toString()))
              {
                localObject = jdField_a_of_type_JavaUtilList;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(paramBoolean);
                localStringBuilder.append(paramCompressInfo.c);
                ((List)localObject).add(localStringBuilder.toString());
              }
              paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
              ((StringBuilder)localObject).append(" checkAndLog()");
              Logger.b("CompressOperator", ((StringBuilder)localObject).toString(), " destSize > srcSize, info.destPath = info.srcPath");
              return;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
            ((StringBuilder)localObject).append(" checkAndLog()");
            Logger.a("CompressOperator", ((StringBuilder)localObject).toString(), "src length is too small");
            paramBoolean = "MI 6".equals(Build.MODEL);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "SendPicSrcProblem", paramBoolean, 0L, l1, null, "");
          }
        }
      }
      else
      {
        paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" checkAndLog()");
        Logger.b("CompressOperator", ((StringBuilder)localObject).toString(), "info.isSuccess = false, info.destPath = info.srcPath");
      }
      return;
    }
    Logger.b("CompressOperator", " checkAndLog()", "info == null || TextUtils.isEmpty(info.srcPath) || TextUtils.isEmpty(info.destPath)");
  }
  
  public static boolean a(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" CompressOperator.start()");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processName = ");
    localStringBuilder.append(MobileQQ.sMobileQQ.getQQProcessName());
    localStringBuilder.append(",srcPath = ");
    localStringBuilder.append(paramCompressInfo.c);
    Logger.a("CompressOperator", (String)localObject, localStringBuilder.toString());
    long l1 = System.currentTimeMillis();
    int i = HardCoderManager.a().a(0, 1, 1, Process.myTid(), 2000, 203, 128L, Process.myTid(), "sendPic", true);
    boolean bool = a(paramCompressInfo, false);
    long l2 = System.currentTimeMillis();
    paramCompressInfo = null;
    if (HardCoderManager.a().a())
    {
      paramCompressInfo = new HashMap();
      paramCompressInfo.put("hcState", String.valueOf(HardCoderManager.a().a()));
      paramCompressInfo.put("model", Build.MODEL);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AIOPicCompress", bool, l2 - l1, 0L, paramCompressInfo, "");
    if (i != 0) {
      HardCoderManager.a().a(i);
    }
    if (QLog.isColorLevel())
    {
      paramCompressInfo = new StringBuilder();
      paramCompressInfo.append("pic compress cost=");
      paramCompressInfo.append(System.currentTimeMillis() - l1);
      QLog.d("CompressOperator", 2, paramCompressInfo.toString());
    }
    return bool;
  }
  
  private static boolean a(CompressInfo paramCompressInfo, boolean paramBoolean)
  {
    Object localObject;
    if ((paramCompressInfo != null) && (FileUtils.fileExistsAndNotEmpty(paramCompressInfo.c)))
    {
      localObject = jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(paramCompressInfo.c);
        if (((List)localObject).contains(localStringBuilder.toString()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(" startImpl()");
          Logger.a("CompressOperator", ((StringBuilder)localObject).toString(), jdField_a_of_type_JavaLangString);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("CompressOperator");
          ((StringBuilder)localObject).append(paramCompressInfo.jdField_a_of_type_JavaLangString);
          ((StringBuilder)localObject).append(" startImpl()");
          ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
          paramCompressInfo.jdField_f_of_type_JavaLangString = ((StringBuilder)localObject).toString();
          paramCompressInfo.jdField_e_of_type_JavaLangString = paramCompressInfo.c;
          localObject = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
          BitmapFactory.decodeFile(paramCompressInfo.jdField_e_of_type_JavaLangString, (BitmapFactory.Options)localObject);
          paramCompressInfo.d = ((BitmapFactory.Options)localObject).outWidth;
          paramCompressInfo.jdField_e_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
          return true;
        }
      }
      paramCompressInfo.h = NetworkUtil.getNetworkType(BaseApplication.getContext());
      if (BaseImageUtil.b(paramCompressInfo.c)) {
        paramCompressInfo.jdField_f_of_type_Int = 2;
      } else if (a(paramCompressInfo.c)) {
        paramCompressInfo.jdField_f_of_type_Int = 1;
      } else {
        paramCompressInfo.jdField_f_of_type_Int = 0;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("info:");
        ((StringBuilder)localObject).append(paramCompressInfo);
        Logger.a("CompressOperator", " startImpl()", ((StringBuilder)localObject).toString());
      }
      localObject = a(paramCompressInfo);
      boolean bool;
      if (paramBoolean) {
        bool = ((AbstractPicType)localObject).a();
      } else {
        bool = ((AbstractPicType)localObject).b();
      }
      paramCompressInfo.jdField_a_of_type_Boolean = bool;
      a(paramCompressInfo, paramBoolean);
      if (paramCompressInfo.jdField_e_of_type_JavaLangString != null)
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      }
    }
    try
    {
      BaseImageUtil.a(paramCompressInfo.jdField_e_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      paramCompressInfo.d = ((BitmapFactory.Options)localObject).outWidth;
      paramCompressInfo.jdField_e_of_type_Int = ((BitmapFactory.Options)localObject).outHeight;
      return paramCompressInfo.jdField_a_of_type_Boolean;
    }
    catch (OutOfMemoryError paramCompressInfo) {}
    Logger.b("CompressOperator", " startImpl()", "info == null || TextUtils.isEmpty(info.srcPath)");
    return false;
    return false;
  }
  
  public static boolean a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    boolean bool = true;
    localOptions.inJustDecodeBounds = true;
    try
    {
      BaseImageUtil.a(paramString, localOptions);
    }
    catch (OutOfMemoryError paramString)
    {
      QLog.e("_photo", 1, paramString, new Object[0]);
    }
    catch (Exception paramString)
    {
      QLog.e("_photo", 1, paramString, new Object[0]);
    }
    int i = localOptions.outHeight;
    int j = localOptions.outWidth;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isLargeFile w:");
      paramString.append(j);
      paramString.append(",h:");
      paramString.append(i);
      QLog.d("_photo", 2, paramString.toString());
    }
    if ((i != -1) && (j != -1))
    {
      if (i <= j * 3)
      {
        if (j > i * 3) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public static boolean b(CompressInfo paramCompressInfo)
  {
    if (paramCompressInfo == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramCompressInfo.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" startThumbnail()");
    Logger.a("CompressOperator", localStringBuilder.toString(), "");
    return a(paramCompressInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.compress.CompressOperator
 * JD-Core Version:    0.7.0.1
 */