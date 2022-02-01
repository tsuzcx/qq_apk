package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.report.ReportCenter;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;

class ForwardSdkShareOption$10
  implements DialogInterface.OnClickListener
{
  ForwardSdkShareOption$10(ForwardSdkShareOption paramForwardSdkShareOption) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.F) {
      ReportCenter.a().a(this.a.q.getAccount(), "", String.valueOf(this.a.G), "1000", "52", "0", false, true);
    }
    paramDialogInterface = new Intent();
    paramDialogInterface.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.a.G), "addToQQFavorites" })));
    paramDialogInterface.setPackage(this.a.s.getIntent().getStringExtra("pkg_name"));
    paramDialogInterface = PendingIntent.getActivity(this.a.s, 0, paramDialogInterface, 268435456);
    Intent localIntent = new Intent();
    localIntent.putExtra("is_share_flag", true);
    if (this.a.G > 0L) {
      localIntent.putExtra("activity_finish_run_pendingIntent", paramDialogInterface);
    }
    QfavHelper.a(this.a.s, this.a.q.getAccount(), localIntent, -1, true);
    QfavReport.b(this.a.q, 2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkShareOption.10
 * JD-Core Version:    0.7.0.1
 */