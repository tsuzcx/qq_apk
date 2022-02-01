package com.tencent.mobileqq.datareportviewer;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
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
      if (paramDownloadTask.exists()) {
        paramDownloadTask = FileUtils.a(paramDownloadTask);
      }
    }
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        paramDownloadTask = new JSONArray(paramDownloadTask);
        localArrayList = new ArrayList(paramDownloadTask.length());
        i = 0;
        if (i < paramDownloadTask.length())
        {
          JSONObject localJSONObject = paramDownloadTask.optJSONObject(i);
          if (TextUtils.isEmpty(localJSONObject.optString("group"))) {
            localArrayList.add(ReportDataConfig.a(localJSONObject));
          } else {
            localArrayList.add(ReportDataConfigGroup.a(localJSONObject));
          }
        }
      }
      catch (JSONException paramDownloadTask)
      {
        paramDownloadTask.printStackTrace();
      }
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportSettingFragment.getActivity().runOnUiThread(new DataReportSettingFragment.4.1(this, localArrayList));
        return;
      } while (!QLog.isColorLevel());
      QLog.d("IphoneTitleBarFragment", 2, "downloadGuide failed");
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.4
 * JD-Core Version:    0.7.0.1
 */