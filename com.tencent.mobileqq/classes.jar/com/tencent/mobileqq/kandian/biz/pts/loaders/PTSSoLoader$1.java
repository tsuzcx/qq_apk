package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.qphone.base.util.QLog;

class PTSSoLoader$1
  implements OnLoadListener
{
  PTSSoLoader$1(PTSSoLoader paramPTSSoLoader, String paramString) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = new StringBuilder();
    paramLoadExtResult.append("[onLoadResult], resCode = ");
    paramLoadExtResult.append(paramInt);
    QLog.i("PTSSoLoader", 1, paramLoadExtResult.toString());
    if (paramInt == 0)
    {
      paramLoadExtResult = SoLoadManager.getInstance().getInitVer(this.jdField_a_of_type_JavaLangString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onLoadResult], load so succeeded, name = ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", currentVersion = ");
      localStringBuilder.append(paramLoadExtResult);
      QLog.i("PTSSoLoader", 1, localStringBuilder.toString());
      if (PTSSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSSoLoader, paramLoadExtResult, "1.1.4")) {
        PTSSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSSoLoader, true);
      }
    }
    PTSSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsLoadersPTSSoLoader, this.jdField_a_of_type_JavaLangString, paramInt, SoLoadManager.getInstance().getInitVer(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSSoLoader.1
 * JD-Core Version:    0.7.0.1
 */