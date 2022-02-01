package com.tencent.mobileqq.troop.homework.recite.utils;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class SoLibraryChecker$4
  implements Runnable
{
  SoLibraryChecker$4(SoLibraryChecker paramSoLibraryChecker, JSONObject paramJSONObject, String paramString, DownloadListener paramDownloadListener) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_OrgJsonJSONObject.optString("url");
    Object localObject = new File(this.jdField_a_of_type_JavaLangString);
    Bundle localBundle = new Bundle();
    localObject = new DownloadTask(str, (File)localObject);
    ((DownloadTask)localObject).b = 3;
    SoLibraryChecker.a(this.this$0).a((DownloadTask)localObject, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SoLibraryLoader", 2, "start Download url = " + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker.4
 * JD-Core Version:    0.7.0.1
 */