package com.tencent.mobileqq.filemanager.fileviewer.presenter;

import android.app.Activity;
import android.content.Intent;
import arfz;
import arin;
import ario;
import azmj;
import badd;
import badt;
import bafi;
import bdir;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleFilePresenter$1$1
  implements Runnable
{
  public SimpleFilePresenter$1$1(ario paramario, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo) {}
  
  public void run()
  {
    Object localObject = badd.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Ario.a.jdField_a_of_type_Arfz.j());
    this.jdField_a_of_type_Ario.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.1.1.1(this));
    try
    {
      if (((JSONObject)localObject).getInt("retcode") != 0)
      {
        this.jdField_a_of_type_Ario.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.1.1.2(this));
        azmj.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 2, 0, "", "", "", "");
        return;
      }
      TencentDocData localTencentDocData = new TencentDocData();
      TencentDocData.obtainFromJsonObject((JSONObject)localObject, null, localTencentDocData);
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_flag_from_plugin", true);
      ((Intent)localObject).putExtra("k_forward_show_direct_share_tips", true);
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.a())
      {
        ((Intent)localObject).setClass(this.jdField_a_of_type_Ario.a.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
        bdir.a(this.jdField_a_of_type_Ario.a.jdField_a_of_type_AndroidAppActivity, 1001, 95, "web_share", "", localTencentDocData.docIcon, localTencentDocData.title, localTencentDocData.summary, this.jdField_a_of_type_Ario.a.jdField_a_of_type_AndroidAppActivity.getString(2131696873, new Object[] { localTencentDocData.title }), this.jdField_a_of_type_JavaLangString, "web", null, null, null, "web", null, null, null, badt.d, this.jdField_a_of_type_Ario.a.jdField_a_of_type_AndroidAppActivity.getString(2131720708), "", (Intent)localObject, -1, "https://docs.qq.com/desktop/m/index.html?_wv=2097154", -1L);
        bafi.a(null, "0X800A21F");
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      azmj.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 3, 0, "", "", "", "");
      QLog.e("SimpleFilePresenter<FileAssistant>", 1, "direct share fail", localJSONException);
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131720789, 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.b())
    {
      if (!arin.b(this.jdField_a_of_type_Ario.a))
      {
        long l = bafi.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.k + "-" + this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.d);
        if (l > 0L) {
          azmj.b(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(l), "");
        }
        localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localJSONException.docUrl = this.jdField_a_of_type_JavaLangString;
        badt.a((QQAppInterface)localObject, this.jdField_a_of_type_Ario.a.jdField_a_of_type_AndroidAppActivity, localJSONException, this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
        return;
      }
      badd.a(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.m, this.jdField_a_of_type_Ario.a.jdField_a_of_type_Arfz.j());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.1
 * JD-Core Version:    0.7.0.1
 */