package com.tencent.mobileqq.shortvideo;

import ahll;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ShortVideoResDownload
  implements ShortVideoResourceStatus.ISVConfig
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private ahll jdField_a_of_type_Ahll;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "ShortVideoResDownload_";
  boolean jdField_a_of_type_Boolean;
  
  private ShortVideoResDownload(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString += jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    this.jdField_a_of_type_Ahll = new ahll(this.jdField_a_of_type_JavaLangString);
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
    if (!VideoEnvironment.c(paramQQAppInterface)) {
      return false;
    }
    return new ShortVideoResDownload(paramQQAppInterface, paramBoolean).a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult | result=" + paramInt1 + ",serverError=" + paramInt2, null);
    if ((paramInt1 == 1) || (paramInt1 == 0))
    {
      if (paramInt2 != 0) {
        VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| uncompress config error=" + paramInt2, null);
      }
      ArrayList localArrayList;
      do
      {
        return;
        localArrayList = new ArrayList(1);
        paramInt1 = ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList);
        if (paramInt1 != 0) {
          break;
        }
        VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| check config success...", null);
        ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Ahll);
        VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| mDownloadFilterSo=false", null);
      } while (!this.jdField_a_of_type_Boolean);
      if (PtvFilterSoLoad.a(VideoEnvironment.a()) != 0) {
        ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Ahll);
      }
      for (;;)
      {
        if (PtvFilterSoLoad.d()) {
          ShortVideoResourceManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Ahll);
        }
        if (!PtvFilterSoLoad.e()) {
          break;
        }
        ShortVideoResourceManager.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Ahll);
        return;
        VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| getFilterSoState != 2", null);
      }
      VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| check config error=" + paramInt1, null);
      return;
    }
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResDownload
 * JD-Core Version:    0.7.0.1
 */