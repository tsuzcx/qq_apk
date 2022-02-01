package com.tencent.mobileqq.download.unite.core;

import com.tencent.open.downloadnew.DownloadInfo;

class UniteDownloadDbOperator$1
  implements Runnable
{
  UniteDownloadDbOperator$1(UniteDownloadDbOperator paramUniteDownloadDbOperator, DownloadInfo paramDownloadInfo, String paramString) {}
  
  public void run()
  {
    UniteDownloadEntity localUniteDownloadEntity = UniteDownloadEntity.fromDownloadInfo(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadInfo);
    this.this$0.a(this.jdField_a_of_type_JavaLangString, localUniteDownloadEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.download.unite.core.UniteDownloadDbOperator.1
 * JD-Core Version:    0.7.0.1
 */