package com.tencent.mobileqq.filemanager.activity;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.downloadnew.ControlPolicyUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

class UniformDownloadActivity$7
  implements ActionSheet.OnButtonClickListener
{
  UniformDownloadActivity$7(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.a.n == null) {
      return;
    }
    if (paramView != null)
    {
      paramView = this.a.n.getContent(paramInt);
      if (!TextUtils.isEmpty(paramView)) {
        if ((!paramView.equals(this.a.getResources().getString(2131888793))) && (!paramView.equals(this.a.getResources().getString(2131888794))))
        {
          if ((paramView.equals(this.a.getResources().getString(2131888792))) || (paramView.equals(this.a.getResources().getString(2131886908))) || (paramView.equals(this.a.getResources().getString(2131886907)))) {
            UniformDownloadActivity.g(this.a);
          }
        }
        else
        {
          ReportController.b(null, "dc00898", "", "", "0X8008F87", "0X8008F87", 1, 0, "", "", "", "");
          if (UniformDownloadActivity.c(this.a))
          {
            if (ControlPolicyUtil.k())
            {
              OpenSdkStatic.a().a(UniformDownloadActivity.d(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3007", false);
              paramView = UniformDownloadActivity.e(this.a);
              UniformDownloadActivity.a(this.a, paramView);
              paramView = UniformDownloadActivity.b(this.a, paramView);
              if (QLog.isColorLevel())
              {
                String str = UniformDownloadActivity.a;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("tmastUrl=");
                localStringBuilder.append(paramView);
                QLog.d(str, 2, localStringBuilder.toString());
              }
              UniformDownloadActivity.a(this.a, paramView);
              UniformDownloadActivity.f(this.a);
              this.a.finish();
              this.a.overridePendingTransition(0, 0);
            }
            else
            {
              UniformDownloadActivity.g(this.a);
            }
          }
          else
          {
            UniformDownloadActivity.h(this.a).setVisibility(0);
            ThreadManager.getSubThreadHandler().post(new UniformDownloadActivity.7.1(this));
          }
        }
      }
    }
    this.a.n.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.7
 * JD-Core Version:    0.7.0.1
 */