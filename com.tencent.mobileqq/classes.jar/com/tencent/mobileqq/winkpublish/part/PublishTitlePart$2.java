package com.tencent.mobileqq.winkpublish.part;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.api.IAEEditorManagerForQzone;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.util.FSToastUtil;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class PublishTitlePart$2
  implements ActionSheet.OnButtonClickListener
{
  PublishTitlePart$2(PublishTitlePart paramPublishTitlePart, int paramInt) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.b.j().getActivity();
    if (paramView != null)
    {
      if (this.b.b == null) {
        return;
      }
      if (paramInt != 0)
      {
        if (paramInt == 1) {
          if (this.a == 3)
          {
            paramView.finish();
          }
          else
          {
            localObject = this.b;
            PublishTitlePart.a((PublishTitlePart)localObject, "em_xsj_save_return", PublishTitlePart.b((PublishTitlePart)localObject));
            if (PublishTitlePart.c(this.b).e())
            {
              FSToastUtil.a(this.b.c().getResources().getString(2131896384), 1);
              PublishTitlePart.c(this.b).a(this.b.j(), 1);
              AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_PUBLIC_EXIT_CANCEL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", PublishTitlePart.c(this.b).y), QCircleReportHelper.newEntry("ext1", "save"), QCircleReportHelper.newEntry("ret_code", "0") }));
              paramView.finish();
            }
            else
            {
              FSToastUtil.a(this.b.c().getResources().getString(2131916939), 1);
            }
          }
        }
      }
      else if (this.a == 3)
      {
        if (PublishTitlePart.c(this.b).e())
        {
          FSToastUtil.a(this.b.c().getResources().getString(2131896384), 1);
          PublishTitlePart.c(this.b).a(this.b.j(), 1);
          AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.E_PUBLIC_EXIT_CANCEL, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("traceid", PublishTitlePart.c(this.b).y), QCircleReportHelper.newEntry("ext1", "save"), QCircleReportHelper.newEntry("ret_code", "0") }));
          paramView.finish();
        }
        else
        {
          FSToastUtil.a(this.b.c().getResources().getString(2131916939), 1);
        }
      }
      else
      {
        localObject = this.b;
        PublishTitlePart.a((PublishTitlePart)localObject, "em_xsj_return_edit", PublishTitlePart.b((PublishTitlePart)localObject));
        PublishTitlePart.c(this.b).a(this.b.j(), 1);
        PublishTitlePart.c(this.b).o = true;
        PublishTitlePart.c(this.b).J = true;
        PublishTitlePart.c(this.b).a(this.b.c());
        PublishTitlePart.c(this.b).i();
        if (this.b.E().a(PublishLabelPart.class.getName()) != null) {
          ((PublishLabelPart)this.b.E().a(PublishLabelPart.class.getName())).d();
        }
        paramView.finish();
      }
      paramView = PublishTitlePart.c(this.b).h();
      Object localObject = PublishTitlePart.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("User cancel with video edit in progress. missionId=");
      localStringBuilder.append(paramView);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      ((IAEEditorManagerForQzone)QRoute.api(IAEEditorManagerForQzone.class)).cancelQFSMission(paramView);
      this.b.b.superDismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishTitlePart.2
 * JD-Core Version:    0.7.0.1
 */