package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import java.util.ArrayList;
import java.util.List;

final class DownloadApi$6
  implements Runnable
{
  DownloadApi$6(String paramString, DownloadQueryListener paramDownloadQueryListener) {}
  
  public void run()
  {
    LogUtility.a(DownloadApi.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia enter");
    try
    {
      new ArrayList();
      List localList = DownloadManager.a().b(this.jdField_a_of_type_JavaLangString);
      localObject = DownloadApi.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getQueryDownloadActionByVia result = ");
      localStringBuilder.append(localList);
      LogUtility.a((String)localObject, localStringBuilder.toString());
      if (this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener != null)
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener.a(localList);
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c(DownloadApi.jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia Exception>>>", localException);
      Object localObject = this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadQueryListener;
      if (localObject != null) {
        ((DownloadQueryListener)localObject).a(-1, localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi.6
 * JD-Core Version:    0.7.0.1
 */