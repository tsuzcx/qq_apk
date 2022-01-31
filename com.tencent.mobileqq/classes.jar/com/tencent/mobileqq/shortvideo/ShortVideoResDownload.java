package com.tencent.mobileqq.shortvideo;

import aiee;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ShortVideoResDownload
  implements ShortVideoResourceStatus.ISVConfig
{
  private static SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(5);
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  public int a;
  private aiee jdField_a_of_type_Aiee;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "ShortVideoResDownload_";
  boolean jdField_a_of_type_Boolean;
  
  private ShortVideoResDownload(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    this.jdField_a_of_type_JavaLangString += this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Aiee = new aiee(this.jdField_a_of_type_JavaLangString, this);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private boolean a()
  {
    boolean bool = NetworkUtil.g(null);
    if (bool)
    {
      VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "短视频配置下载中...", null);
      ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      return bool;
    }
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "请连接网络后,重新进入重试", null);
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
        if (!VideoEnvironment.c(paramQQAppInterface))
        {
          jdField_a_of_type_AndroidUtilSparseArray.clear();
          paramBoolean = bool;
          return paramBoolean;
        }
        if (jdField_a_of_type_AndroidUtilSparseArray.size() >= 3)
        {
          VideoEnvironment.a("ShortVideoResDownload", "reach to max session size=" + jdField_a_of_type_AndroidUtilSparseArray.size(), null);
          paramBoolean = bool;
          continue;
        }
        paramQQAppInterface = new ShortVideoResDownload(paramQQAppInterface, paramBoolean);
      }
      finally {}
      jdField_a_of_type_AndroidUtilSparseArray.put(paramQQAppInterface.jdField_a_of_type_Int, paramQQAppInterface);
      bool = paramQQAppInterface.a();
      paramBoolean = bool;
      if (!bool)
      {
        jdField_a_of_type_AndroidUtilSparseArray.remove(paramQQAppInterface.jdField_a_of_type_Int);
        paramBoolean = bool;
      }
    }
  }
  
  private static void b(ShortVideoResDownload paramShortVideoResDownload)
  {
    if (paramShortVideoResDownload != null) {}
    try
    {
      jdField_a_of_type_AndroidUtilSparseArray.remove(paramShortVideoResDownload.jdField_a_of_type_Int);
      return;
    }
    finally
    {
      paramShortVideoResDownload = finally;
      throw paramShortVideoResDownload;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult | result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0)
      {
        VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| uncompress config error=" + paramInt2, null);
        b(this);
        return;
      }
      ArrayList localArrayList = new ArrayList(1);
      paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
      if (paramInt1 == 0)
      {
        VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| check config success...", null);
        this.jdField_a_of_type_Aiee.jdField_a_of_type_Boolean = false;
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Aiee);
        VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| mDownloadFilterSo=false", null);
        if (this.jdField_a_of_type_Boolean)
        {
          if (PtvFilterSoLoad.a(VideoEnvironment.a()) == 0) {
            break label265;
          }
          ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Aiee);
          this.jdField_a_of_type_Aiee.b = false;
        }
        for (;;)
        {
          if (PtvFilterSoLoad.d())
          {
            this.jdField_a_of_type_Aiee.c = false;
            ShortVideoResourceManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Aiee);
          }
          if (PtvFilterSoLoad.e())
          {
            this.jdField_a_of_type_Aiee.d = false;
            ShortVideoResourceManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Aiee);
          }
          if (PtvFilterSoLoad.g())
          {
            this.jdField_a_of_type_Aiee.e = false;
            ShortVideoResourceManager.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Aiee);
          }
          this.jdField_a_of_type_Aiee.a();
          return;
          label265:
          VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| getFilterSoState != 2", null);
        }
      }
      VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| check config error=" + paramInt1, null);
      b(this);
      return;
    }
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
    b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResDownload
 * JD-Core Version:    0.7.0.1
 */