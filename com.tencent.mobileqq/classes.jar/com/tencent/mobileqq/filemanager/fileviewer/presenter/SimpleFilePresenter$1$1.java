package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import apmx;
import appk;
import appl;
import axqw;
import ayfe;
import ayfv;
import ayhk;
import bbjj;
import bcpw;
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
  public SimpleFilePresenter$1$1(appl paramappl, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    Object localObject = ayfe.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Appl.a.jdField_a_of_type_Apmx.h());
    this.jdField_a_of_type_Appl.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.1.1.1(this));
    try
    {
      if (((JSONObject)localObject).getInt("retcode") != 0)
      {
        this.jdField_a_of_type_Appl.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.1.1.2(this));
        axqw.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 2, 0, "", "", "", "");
        return;
      }
      TencentDocData localTencentDocData = new TencentDocData();
      TencentDocData.obtainFromJsonObject((JSONObject)localObject, null, localTencentDocData);
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_flag_from_plugin", true);
      ((Intent)localObject).putExtra("k_forward_show_direct_share_tips", true);
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.a())
      {
        ((Intent)localObject).setClass(this.jdField_a_of_type_Appl.a.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
        bbjj.a(this.jdField_a_of_type_Appl.a.jdField_a_of_type_AndroidAppActivity, 1001, 95, "web_share", "", localTencentDocData.docIcon, localTencentDocData.title, localTencentDocData.summary, this.jdField_a_of_type_Appl.a.jdField_a_of_type_AndroidAppActivity.getString(2131696697, new Object[] { localTencentDocData.title }), this.jdField_a_of_type_JavaLangString, "web", null, null, null, "web", null, null, null, ayfv.d, this.jdField_a_of_type_Appl.a.jdField_a_of_type_AndroidAppActivity.getString(2131720161), "", (Intent)localObject, -1, "https://docs.qq.com/desktop/m/index.html?_wv=2097154", -1L);
        ayhk.a(null, "0X800A21F");
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      axqw.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 3, 0, "", "", "", "");
      QLog.e("SimpleFilePresenter<FileAssistant>", 1, "direct share fail", localJSONException);
      bcpw.a(BaseApplicationImpl.getApplication(), 1, 2131720242, 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b())
    {
      if (!appk.b(this.jdField_a_of_type_Appl.a))
      {
        long l = ayhk.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.k + "-" + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d);
        if (l > 0L) {
          axqw.b(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(l), "");
        }
        localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localJSONException.docUrl = this.jdField_a_of_type_JavaLangString;
        ayfv.a((QQAppInterface)localObject, this.jdField_a_of_type_Appl.a.jdField_a_of_type_AndroidAppActivity, localJSONException, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
        return;
      }
      ayfe.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.m, this.jdField_a_of_type_Appl.a.jdField_a_of_type_Apmx.h());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.1
 * JD-Core Version:    0.7.0.1
 */