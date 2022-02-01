package com.tencent.mobileqq.shortvideo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ShortVideoResDownload
  implements ShortVideoResourceStatus.ISVConfig
{
  private static String jdField_a_of_type_JavaLangString = "ShortVideoResDownload_";
  private static ConcurrentHashMap<Integer, ShortVideoResDownload> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public int a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ShortVideoResDownload.ResDownloadCallBack jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload$ResDownloadCallBack;
  boolean jdField_a_of_type_Boolean;
  
  private ShortVideoResDownload(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    jdField_a_of_type_JavaLangString += this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload$ResDownloadCallBack = new ShortVideoResDownload.ResDownloadCallBack(jdField_a_of_type_JavaLangString, this);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, @Nullable ShortVideoResourceStatus.ISVConfig_V2 paramISVConfig_V2)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLogin] - BEGIN -");
    boolean bool = VideoEnvironment.supportShortVideoRecordAndPlay();
    if (!bool)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      if (paramISVConfig_V2 != null) {
        paramISVConfig_V2.a(-1, -6);
      }
      AEQLog.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLogin] - END -, supportShortVideo=" + bool);
      return;
    }
    if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 3)
    {
      if (paramISVConfig_V2 != null) {
        paramISVConfig_V2.a(-1, -1);
      }
      AEQLog.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLogin] - END -, reach to max session size=" + jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
      return;
    }
    paramQQAppInterface = new ShortVideoResDownload(paramQQAppInterface, true);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int), paramQQAppInterface);
    paramQQAppInterface.a(paramISVConfig_V2);
    AEQLog.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLogin] - END -");
  }
  
  private void a(@Nullable ShortVideoResourceStatus.ISVConfig_V2 paramISVConfig_V2)
  {
    AEQLog.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLoginInternal] - BEGIN -");
    ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ShortVideoResDownload.2(this, paramISVConfig_V2));
    AEQLog.b(jdField_a_of_type_JavaLangString, "[startDownload215ConfigWithoutLoginInternal] - END -");
  }
  
  private boolean a()
  {
    boolean bool = NetworkUtil.g(null);
    if (bool)
    {
      VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131714039), null);
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return bool;
    }
    VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, HardCodeUtil.a(2131713978), null);
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, true);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (!VideoEnvironment.supportShortVideoRecordAndPlay())
        {
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
          paramBoolean = bool;
          return paramBoolean;
        }
        if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() >= 3)
        {
          VideoEnvironment.LogDownLoad("ShortVideoResDownload", "reach to max session size=" + jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size(), null);
          paramBoolean = bool;
          continue;
        }
        paramQQAppInterface = new ShortVideoResDownload(paramQQAppInterface, paramBoolean);
      }
      finally {}
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int), paramQQAppInterface);
      bool = paramQQAppInterface.a();
      paramBoolean = bool;
      if (!bool)
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramQQAppInterface.jdField_a_of_type_Int));
        paramBoolean = bool;
      }
    }
  }
  
  private static void b(ShortVideoResDownload paramShortVideoResDownload)
  {
    if (paramShortVideoResDownload != null) {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramShortVideoResDownload.jdField_a_of_type_Int));
    }
  }
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult | result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| uncompress config error=" + paramInt2, null);
        b(this);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| check config success...", null);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload$ResDownloadCallBack.jdField_a_of_type_Boolean = false;
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload$ResDownloadCallBack);
        VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| mDownloadFilterSo=false", null);
        if (this.jdField_a_of_type_Boolean)
        {
          if (PtvFilterSoLoad.c())
          {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload$ResDownloadCallBack.b = false;
            ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload$ResDownloadCallBack);
          }
          if (PtvFilterSoLoad.g())
          {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload$ResDownloadCallBack.d = false;
            ShortVideoResourceManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload$ResDownloadCallBack);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload$ResDownloadCallBack.a();
        return;
      }
      VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| check config error=" + paramInt1, null);
      b(this);
      return;
    }
    VideoEnvironment.LogDownLoad(jdField_a_of_type_JavaLangString, "onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
    b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResDownload
 * JD-Core Version:    0.7.0.1
 */