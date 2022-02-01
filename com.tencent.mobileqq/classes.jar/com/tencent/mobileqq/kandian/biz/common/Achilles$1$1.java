package com.tencent.mobileqq.kandian.biz.common;

import com.tencent.mobileqq.bigbrother.RockDownloader.QueryAPKListener;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.kandian.repo.aladdin.config.AchillesParams;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class Achilles$1$1
  extends QueryAPKListener
{
  Achilles$1$1(Achilles.1 param1, RockDownloadInfo paramRockDownloadInfo, AchillesParams paramAchillesParams) {}
  
  public void a(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    paramString = new StringBuilder();
    paramString.append("query predownload info fail: ");
    paramString.append(paramRockDownloadInfo);
    QLog.d("Achilles", 1, paramString.toString());
    Achilles.a(this.jdField_a_of_type_ComTencentMobileqqDataRockDownloadInfo, this.jdField_a_of_type_ComTencentMobileqqKandianRepoAladdinConfigAchillesParams);
  }
  
  public void a(ArrayList<RockDownloadInfo> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("query predownload info success: ");
    localStringBuilder.append(paramArrayList);
    QLog.d("Achilles", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.Achilles.1.1
 * JD-Core Version:    0.7.0.1
 */