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
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      return;
    }
    if (paramView != null)
    {
      paramView = this.a.jdField_a_of_type_ComTencentWidgetActionSheet.getContent(paramInt);
      if (!TextUtils.isEmpty(paramView)) {
        if ((!paramView.equals(this.a.getResources().getString(2131691830))) && (!paramView.equals(this.a.getResources().getString(2131691831))))
        {
          if ((paramView.equals(this.a.getResources().getString(2131691829))) || (paramView.equals(this.a.getResources().getString(2131690089))) || (paramView.equals(this.a.getResources().getString(2131690088)))) {
            UniformDownloadActivity.c(this.a);
          }
        }
        else
        {
          ReportController.b(null, "dc00898", "", "", "0X8008F87", "0X8008F87", 1, 0, "", "", "", "");
          if (UniformDownloadActivity.a(this.a))
          {
            if (ControlPolicyUtil.g())
            {
              OpenSdkStatic.a().a(UniformDownloadActivity.a(this.a), "1", "ANDROIDQQ.POPUP.YYBDOWNAPP", "3007", false);
              paramView = UniformDownloadActivity.a(this.a);
              UniformDownloadActivity.a(this.a, paramView);
              paramView = UniformDownloadActivity.a(this.a, paramView);
              if (QLog.isColorLevel())
              {
                String str = UniformDownloadActivity.jdField_a_of_type_JavaLangString;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("tmastUrl=");
                localStringBuilder.append(paramView);
                QLog.d(str, 2, localStringBuilder.toString());
              }
              UniformDownloadActivity.a(this.a, paramView);
              UniformDownloadActivity.b(this.a);
              this.a.finish();
              this.a.overridePendingTransition(0, 0);
            }
            else
            {
              UniformDownloadActivity.c(this.a);
            }
          }
          else
          {
            UniformDownloadActivity.b(this.a).setVisibility(0);
            ThreadManager.getSubThreadHandler().post(new UniformDownloadActivity.7.1(this));
          }
        }
      }
    }
    this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.7
 * JD-Core Version:    0.7.0.1
 */