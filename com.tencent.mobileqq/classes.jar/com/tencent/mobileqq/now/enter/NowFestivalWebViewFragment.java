package com.tencent.mobileqq.now.enter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class NowFestivalWebViewFragment
  extends WebViewFragment
{
  private long jdField_a_of_type_Long;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  
  public void f() {}
  
  public void g()
  {
    QLog.i("NowFestivalWebViewFragment", 3, "startLoadUrl-----");
    if (!TextUtils.isEmpty(this.g)) {
      if (!this.g.contains("auto="))
      {
        if (this.g.contains("?")) {
          this.g += "&auto=false";
        }
      }
      else
      {
        QLog.i("NowFestivalWebViewFragment", 3, "startLoadUrl, url = " + this.g);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.g = (this.g + "&t=" + this.jdField_a_of_type_Long);
      }
    }
    for (;;)
    {
      super.g();
      return;
      this.g += "?auto=false";
      break;
      QLog.i("NowFestivalWebViewFragment", 1, "startLoadUrl, url is empty");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = ((FragmentActivity)paramActivity);
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.l();
    new ReportTask(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app).a("dc00899").b("Grp_AIO").c("year_icon").d("h5_view").a();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.now.enter.NowFestivalWebViewFragment
 * JD-Core Version:    0.7.0.1
 */