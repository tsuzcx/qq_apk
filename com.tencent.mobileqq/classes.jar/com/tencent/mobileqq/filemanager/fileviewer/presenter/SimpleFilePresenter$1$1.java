package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import aovk;
import aoxw;
import aoxx;
import awqx;
import axfb;
import axfs;
import axhg;
import baic;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleFilePresenter$1$1
  implements Runnable
{
  public SimpleFilePresenter$1$1(aoxx paramaoxx, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    Object localObject = axfb.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aoxx.a.jdField_a_of_type_Aovk.h());
    this.jdField_a_of_type_Aoxx.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.1.1.1(this));
    try
    {
      if (((JSONObject)localObject).getInt("retcode") != 0)
      {
        this.jdField_a_of_type_Aoxx.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.1.1.2(this));
        awqx.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 2, 0, "", "", "", "");
        return;
      }
      TencentDocData localTencentDocData = new TencentDocData();
      TencentDocData.obtainFromJsonObject((JSONObject)localObject, null, localTencentDocData);
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_flag_from_plugin", true);
      ((Intent)localObject).putExtra("k_forward_show_direct_share_tips", true);
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.a())
      {
        ((Intent)localObject).setClass(this.jdField_a_of_type_Aoxx.a.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
        baic.a(this.jdField_a_of_type_Aoxx.a.jdField_a_of_type_AndroidAppActivity, 1001, 95, "web_share", "", localTencentDocData.docIcon, localTencentDocData.title, localTencentDocData.summary, this.jdField_a_of_type_Aoxx.a.jdField_a_of_type_AndroidAppActivity.getString(2131630985, new Object[] { localTencentDocData.title }), this.jdField_a_of_type_JavaLangString, "web", null, null, null, "web", null, null, null, axfs.d, this.jdField_a_of_type_Aoxx.a.jdField_a_of_type_AndroidAppActivity.getString(2131654267), "", (Intent)localObject, -1, "https://docs.qq.com/desktop/m/index.html?_wv=2097154", -1L);
        axhg.a(null, "0X800A21F");
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      awqx.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 3, 0, "", "", "", "");
      QLog.e("SimpleFilePresenter<FileAssistant>", 1, "direct share fail", localJSONException);
      bbmy.a(BaseApplicationImpl.getApplication(), 1, 2131654348, 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b())
    {
      if (!aoxw.a(this.jdField_a_of_type_Aoxx.a))
      {
        long l = axhg.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.k + "-" + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d);
        if (l > 0L) {
          awqx.b(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(l), "");
        }
        localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localJSONException.docUrl = this.jdField_a_of_type_JavaLangString;
        axfs.a((QQAppInterface)localObject, this.jdField_a_of_type_Aoxx.a.jdField_a_of_type_AndroidAppActivity, localJSONException, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
        return;
      }
      axfb.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.m, this.jdField_a_of_type_Aoxx.a.jdField_a_of_type_Aovk.h());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.1
 * JD-Core Version:    0.7.0.1
 */