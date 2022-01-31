package dov.com.tencent.mobileqq.shortvideo;

import anzb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceStatus.ISVConfig;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ShortVideoResDownload
  implements ShortVideoResourceStatus.ISVConfig
{
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private anzb jdField_a_of_type_Anzb;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
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
        PtvFilterSoLoad.a(VideoEnvironment.a());
        if (PtvFilterSoLoad.d()) {
          ShortVideoResourceManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Anzb);
        }
      } while (!PtvFilterSoLoad.e());
      ShortVideoResourceManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, this.jdField_a_of_type_Anzb);
      return;
      VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| check config error=" + paramInt1, null);
      return;
    }
    VideoEnvironment.a(this.jdField_a_of_type_JavaLangString, "onConfigResult| result= RESULT_FAILED error=" + paramInt2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoResDownload
 * JD-Core Version:    0.7.0.1
 */