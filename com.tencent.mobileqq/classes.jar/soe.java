import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.RepUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneShareManager;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;

public class soe
  implements View.OnClickListener
{
  public soe(ForwardRecentActivity paramForwardRecentActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent();
    int j = paramView.getIntExtra("req_type", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "-->addQZoneEntry--onClick--req_type = " + j);
    }
    Bundle localBundle = paramView.getExtras();
    Object localObject = localBundle.getString("image_url_remote");
    paramView = (View)localObject;
    if (localObject == null) {
      paramView = localBundle.getString("image_url");
    }
    localObject = new ArrayList();
    if (!TextUtils.isEmpty(paramView))
    {
      paramView = paramView.split(";");
      int i = 0;
      while (i < paramView.length)
      {
        ((ArrayList)localObject).add(URLDecoder.decode(paramView[i]));
        i += 1;
      }
    }
    localBundle.putStringArrayList("image_url", (ArrayList)localObject);
    localBundle.putString("share_action", "shareToQQ");
    localBundle.putString("jfrom", "login");
    localBundle.putBoolean("thirdPartShare", true);
    com.tencent.mobileqq.app.PhoneContactManagerImp.g = true;
    QZoneShareManager.a(this.a.app, this.a, localBundle, null);
    paramView = new QZoneClickReport.ReportInfo();
    paramView.c = "1";
    paramView.d = "0";
    paramView.b = 4;
    paramView.k = "5";
    paramView.l = "thirdApp";
    paramView.m = "activefeed";
    QZoneClickReport.startReportImediately(this.a.app.getAccount(), paramView);
    paramView = new HashMap();
    paramView.put("source_type", "5");
    paramView.put("source_from", "thirdApp");
    paramView.put("source_to", "activefeed");
    StatisticCollector.a(this.a.getApplicationContext()).a(this.a.app.getAccount(), "actQZSourceDataReport", true, 0L, 0L, paramView, null);
    if (this.a.jdField_a_of_type_Boolean)
    {
      ReportCenter.a().a(this.a.app.getAccount(), "", this.a.b, "1000", "33", "0", false);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption instanceof ForwardSdkBaseOption))
      {
        paramView = (ForwardSdkBaseOption)this.a.jdField_a_of_type_ComTencentMobileqqForwardForwardBaseOption;
        localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "102");
        ((Bundle)localObject).putString("act_type", "81");
        ((Bundle)localObject).putString("intext_1", "" + ReportDef.RepUtil.a(paramView.b));
        ((Bundle)localObject).putString("intext_2", "" + ReportDef.RepUtil.a(-1, AppConstants.ay));
        ((Bundle)localObject).putString("intext_3", "0");
        ReportCenter.a().a((Bundle)localObject, "", this.a.app.getCurrentAccountUin(), false);
      }
    }
    if ((!this.a.jdField_a_of_type_Boolean) || (j != 5))
    {
      this.a.finish();
      return;
    }
    ForwardRecentActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     soe
 * JD-Core Version:    0.7.0.1
 */