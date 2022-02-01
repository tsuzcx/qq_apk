package com.tencent.mobileqq.datareportviewer;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class DataReportSettingFragment$4
  extends DownloadListener
{
  DataReportSettingFragment$4(DataReportSettingFragment paramDataReportSettingFragment, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask.a == 0)
    {
      paramDownloadTask = new File(this.jdField_a_of_type_JavaLangString);
      if (!paramDownloadTask.exists()) {
        break label148;
      }
      paramDownloadTask = FileUtils.readFileContent(paramDownloadTask);
    }
    for (;;)
    {
      int i;
      try
      {
        paramDownloadTask = new JSONArray(paramDownloadTask);
        ArrayList localArrayList = new ArrayList(paramDownloadTask.length());
        i = 0;
        if (i < paramDownloadTask.length())
        {
          JSONObject localJSONObject = paramDownloadTask.optJSONObject(i);
          if (TextUtils.isEmpty(localJSONObject.optString("group")))
          {
            localArrayList.add(ReportDataConfig.a(localJSONObject));
            break label149;
          }
          localArrayList.add(ReportDataConfigGroup.a(localJSONObject));
          break label149;
        }
        this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment.getBaseActivity().runOnUiThread(new DataReportSettingFragment.4.1(this, localArrayList));
        return;
      }
      catch (JSONException paramDownloadTask)
      {
        paramDownloadTask.printStackTrace();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, "downloadGuide failed");
      }
      label148:
      return;
      label149:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */